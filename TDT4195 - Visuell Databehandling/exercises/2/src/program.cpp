// Local headers
#include <iostream>
#include <glm/ext.hpp>
#include "program.hpp"
#include "gloom/gloom.hpp"
#include "gloom/shader.hpp"

GLuint vertexArrayObject(float *vertices, uint vertexCount, uint *indices, uint indexCount, float *colors, uint colorCount);

void runProgram(GLFWwindow* window)
{
    // Enable depth (Z) buffer (accept "closest" fragment)
    glEnable(GL_DEPTH_TEST);
    glDepthFunc(GL_GREATER);
    glClearDepth(-1);

    // Configure miscellaneous OpenGL settings
    glEnable(GL_CULL_FACE);

    // Making it possible to add transparency
    glEnable(GL_BLEND);
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

    // Set default colour after clearing the colour buffer
    glClearColor(0.3f, 0.8f, 1.0f, 1.0f);

    float g_vertex_buffer_data[] = {
        -0.4f,  -0.25f, 0.6f,
         0.1f,  -0.25f, 0.6f,
        -0.15f,  0.3f,  0.6f,
        -0.1f,  -0.25f, 0.7f,
         0.4f,  -0.25f, 0.7f,
         0.15f,  0.3f,  0.7f,
        -0.25f, -0.58f, 0.8f,
         0.25f, -0.58f, 0.8f,
         0.0f,  -0.03f, 0.8f,
    };

    float g_color_buffer_data[] = {
        1.0f, 0.0f, 0.0f, 0.4f,
        1.0f, 0.0f, 0.0f, 0.4f,
        1.0f, 0.0f, 0.0f, 0.4f,
        0.0f, 1.0f, 0.0f, 0.4f,
        0.0f, 1.0f, 0.0f, 0.4f,
        0.0f, 1.0f, 0.0f, 0.4f,
        0.0f, 0.0f, 1.0f, 0.4f,
        0.0f, 0.0f, 1.0f, 0.4f,
        0.0f, 0.0f, 1.0f, 0.4f,
    };

    unsigned int g_index_buffer_data[] = { 0,1,2,3,4,5,6,7,8, };

    float value = 0.0f;
    glm::mat4x4 identityMatrix = glm::mat4(1.0f);
    glm::mat4x4 perspectiveMatrix = glm::perspective(glm::radians(45.0f), 16.0f / 9.0f, 1.0f, 100.0f);

    GLuint vao = vertexArrayObject(
      g_vertex_buffer_data, sizeof(g_vertex_buffer_data),
      g_index_buffer_data, sizeof(g_index_buffer_data),
      g_color_buffer_data, sizeof(g_color_buffer_data)
    );

    Gloom::Shader shader;
    shader.makeBasicShader("../gloom/shaders/simple.vert", "../gloom/shaders/simple.frag");
    shader.activate();

    // Rendering Loop
    while (!glfwWindowShouldClose(window))
    {
        // Clear colour and depth buffers
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        // Assign a value to our uniform variable

        value += 0.1f;
        glm::mat4x4 perspectiveMatrix = glm::perspective(glm::radians(45.0f), 16.0f / 9.0f, -10.0f, 100.0f);
        glm::mat4 View = glm::lookAt(
            glm::vec3(4,3,3),
            glm::vec3(0,0,0),
            glm::vec3(0,1,0)
        );
        glm::mat4x4 translation = glm::translate(glm::mat4(), glm::vec3(0.0f, 0.0f, 0.0f));
        glm::mat4x4 rotX = glm::rotate(glm::radians(value), glm::vec3(1.0f, 0.0f, 0.0f));
        glm::mat4x4 rotY = glm::rotate(glm::radians(value), glm::vec3(0.0f, 1.0f, 0.0f));

        glm::mat4x4 finalTransformationMatrix = perspectiveMatrix * translation * identityMatrix;

        glUniformMatrix4fv(4, 1, GL_FALSE, glm::value_ptr(finalTransformationMatrix));

        // Draw your scene here
        glDrawElements(GL_TRIANGLES, sizeof(g_index_buffer_data) / sizeof(uint), GL_UNSIGNED_INT, 0);

        // Handle other events
        glfwPollEvents();
        handleKeyboardInput(window);

        // Flip buffers
        glfwSwapBuffers(window);
    }
    shader.deactivate();
    shader.destroy();
}

GLuint vertexArrayObject(float *vertices, uint vertexCount, uint *indices, uint indexCount, float *colors, uint colorCount)
{
    GLuint VertexArrayID;
    glGenVertexArrays(1, &VertexArrayID);
    glBindVertexArray(VertexArrayID);

    GLuint vertexbuffer;
    glGenBuffers(1, &vertexbuffer);
    glBindBuffer(GL_ARRAY_BUFFER, vertexbuffer);
    glBufferData(GL_ARRAY_BUFFER, vertexCount, vertices, GL_STATIC_DRAW);

    glEnableVertexAttribArray(0);
    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 0, (void*)0);

    GLuint indexbuffer;
    glGenBuffers(1, &indexbuffer);
    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, indexbuffer);
    glBufferData(GL_ELEMENT_ARRAY_BUFFER, indexCount, indices, GL_STATIC_DRAW);

    GLuint colorbuffer;
    glGenBuffers(1, &colorbuffer);
    glBindBuffer(GL_ARRAY_BUFFER, colorbuffer);
    glBufferData(GL_ARRAY_BUFFER, colorCount, colors, GL_STATIC_DRAW);

    glEnableVertexAttribArray(1);
    glVertexAttribPointer(1, 4, GL_FLOAT, GL_FALSE, 0, (void*)0);

    return vertexbuffer;
}

void handleKeyboardInput(GLFWwindow* window)
{
    // Use escape key for terminating the GLFW window
    if (glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_PRESS)
    {
        glfwSetWindowShouldClose(window, GL_TRUE);
    }
}
