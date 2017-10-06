// Local headers
#include <iostream>
#include <glm/ext.hpp>
#include "program.hpp"
#include "gloom/gloom.hpp"
#include "gloom/shader.hpp"

GLuint vertexArrayObject(float *vertices, unsigned int vertexCount, unsigned int *indices, unsigned int indexCount, float *colors, unsigned int colorCount);
float* createBox(float cx, float cy, float cz, float w, float h, float d, float scale);

//Oppgave 4c
float rotX = 0;
float rotY = 0;
float cordX = 0;
float cordY = -2.0f;
float cordZ = -3.0f;

void runProgram(GLFWwindow* window)
{
    // Enable depth (Z) buffer (accept "closest" fragment)
    glEnable(GL_DEPTH_TEST);
    glDepthFunc(GL_LESS);
    glClearDepth(1);

    // Configure miscellaneous OpenGL settings
    glEnable(GL_CULL_FACE);

    // Making it possible to add transparency
    glEnable(GL_BLEND);
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

    // Set default colour after clearing the colour buffer
    glClearColor(0.3f, 0.8f, 1.0f, 1.0f);

    // Adding the index buffer for a cube of triangles created in createBox
    unsigned int g_index_buffer_data[] = {
        0, 1, 2,
        2, 1, 3,
        2, 6, 0,
        6, 4, 0,
        3, 1, 7,
        1, 5, 7,
        4, 6, 7,
        4, 7, 5,
        4, 5, 1,
        4, 1, 0,
        7, 6, 2,
        7, 2, 3,
     };

    // Adding a color buffer making the cube contain all color gradients
    float g_color_buffer_data[] = {
        1.0f, 1.0f, 1.0f, 1.0f, // White
        1.0f, 1.0f, 0.0f, 1.0f, // Yellow
        0.0f, 1.0f, 1.0f, 1.0f, // Cyan
        0.0f, 1.0f, 0.0f, 1.0f, // Green
        1.0f, 0.0f, 1.0f, 1.0f, // Pink
        1.0f, 0.0f, 0.0f, 1.0f, // Red
        0.0f, 0.0f, 1.0f, 1.0f, // Blue
        0.0f, 0.0f, 0.0f, 1.0f, // Black
    };

    // Creating an identity and perspective matrix for later
    glm::mat4x4 identityMatrix = glm::mat4(1.0f);
    glm::mat4x4 perspectiveMatrix = glm::perspective(glm::radians(45.0f), 16.0f / 9.0f, 1.0f, 100.0f);

    // Setting some constant variables for creating the initial VAOs
    const int pointsCount = 12 * 8; // triangles * edges
    const int ibdCount = sizeof(g_index_buffer_data);
    const int cbdCount = sizeof(g_color_buffer_data);
    const float scale = 0.1f;

    // Creating the initial VAOs
    GLuint vaoHead = vertexArrayObject(createBox(-4.0f, 24.0f, -4.0f, 8.0f, 8.0f, 8.0f, scale), pointsCount, g_index_buffer_data, ibdCount, g_color_buffer_data, cbdCount);
    GLuint vaoBody = vertexArrayObject(createBox(-4.0f, 24.0f, -2.0f, 8.0f, -12.0f, 4.0f, scale), pointsCount, g_index_buffer_data, ibdCount, g_color_buffer_data, cbdCount);
    GLuint vaoArmLeft = vertexArrayObject(createBox(-8.0f, 24.0f, -2.0f, 4.0f, -12.0f, 4.0f, scale), pointsCount, g_index_buffer_data, ibdCount, g_color_buffer_data, cbdCount);
    GLuint vaoArmRight = vertexArrayObject(createBox(4.0f, 24.0f, -2.0f, 4.0f, -12.0f, 4.0f, scale), pointsCount, g_index_buffer_data, ibdCount, g_color_buffer_data, cbdCount);
    GLuint vaoLegLeft = vertexArrayObject(createBox(-4.0f, 12.0f, -2.0f, 4.0f, -12.0f, 4.0f, scale), pointsCount, g_index_buffer_data, ibdCount, g_color_buffer_data, cbdCount);
    GLuint vaoLegRight = vertexArrayObject(createBox(0.0f, 12.0f, -2.0f, 4.0f, -12.0f, 4.0f, scale), pointsCount, g_index_buffer_data, ibdCount, g_color_buffer_data, cbdCount);

    // Adding the VAOs to a list
    GLuint vaoList[] = {
        vaoHead,
        vaoBody,
        vaoArmLeft,
        vaoArmRight,
        vaoLegLeft,
        vaoLegRight,
    };

    // Activating vertex and fragment shaders from text files
    Gloom::Shader shader;
    shader.makeBasicShader("../gloom/shaders/simple.vert", "../gloom/shaders/simple.frag");
    shader.activate();

    // Rendering Loop
    while (!glfwWindowShouldClose(window))
    {
        // Clear colour and depth buffers
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        // Assign a value to our uniform variable

        // Translation
        glm::mat4x4 translation = glm::translate(glm::mat4(), glm::vec3(cordX, cordY, cordZ));
        glm::mat4x4 transposedTrans = glm::transpose(translation);

        // Rotation
        glm::mat4x4 rotXMatrix = glm::rotate(glm::radians(rotX), glm::vec3(1.0f, 0.0f, 0.0f));
        glm::mat4x4 rotYMartix = glm::rotate(glm::radians(rotY), glm::vec3(0.0f, 1.0f, 0.0f));

        glm::mat4x4 transposedRotX = glm::transpose(rotXMatrix);
        glm::mat4x4 transposedRotY = glm::transpose(rotYMartix);

        glm::mat4x4 finalTransformationMatrix = transposedRotX * transposedRotY * transposedTrans * perspectiveMatrix * identityMatrix;
        glUniformMatrix4fv(4, 1, GL_FALSE, glm::value_ptr(finalTransformationMatrix));
        
        // Drawing VAOs from the VAO array
        int listSize = sizeof(vaoList);
        for (int i = 0; i < listSize; i++) {
            glBindVertexArray(vaoList[i]);
            glDrawElements(GL_TRIANGLES, sizeof(g_index_buffer_data) / sizeof(unsigned int), GL_UNSIGNED_INT, (void*)0);
        }

        // Handle other events
        glfwPollEvents();
        handleKeyboardInput(window);

        // Flip buffers
        glfwSwapBuffers(window);
    }
    shader.deactivate();
    shader.destroy();
}

GLuint vertexArrayObject(float *vertices, unsigned int vertexCount, unsigned int *indices, unsigned int indexCount, float *colors, unsigned int colorCount)
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

    return VertexArrayID;
}

void handleKeyboardInput(GLFWwindow* window)
{
    // Use escape key for terminating the GLFW window
    if (glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_PRESS)
    {
        glfwSetWindowShouldClose(window, GL_TRUE);
    }

    if (glfwGetKey(window, GLFW_KEY_UP) == GLFW_PRESS)
    {
        cordY += 0.01;
    }

    if (glfwGetKey(window, GLFW_KEY_DOWN) == GLFW_PRESS)
    {
        cordY -= 0.01;
    }

    if (glfwGetKey(window, GLFW_KEY_LEFT) == GLFW_PRESS)
    {
        cordX -= 0.01;
    }

    if (glfwGetKey(window, GLFW_KEY_RIGHT) == GLFW_PRESS)
    {
        cordX += 0.01;
    }

    if (glfwGetKey(window, GLFW_KEY_SPACE) == GLFW_PRESS)
    {
        cordZ += 0.01;
    }

    if (glfwGetKey(window, GLFW_KEY_LEFT_CONTROL) == GLFW_PRESS)
    {
        cordZ -= 0.01;
    }

    if (glfwGetKey(window, GLFW_KEY_W) == GLFW_PRESS)
    {
        rotX += 1.0;
    }

    if (glfwGetKey(window, GLFW_KEY_S) == GLFW_PRESS)
    {
        rotX -= 1.0;
    }

    if (glfwGetKey(window, GLFW_KEY_A) == GLFW_PRESS)
    {
        rotY -= 1.0;
    }

    if (glfwGetKey(window, GLFW_KEY_D) == GLFW_PRESS)
    {
        rotY += 1.0;
    }
}

float* createBox(float cx, float cy, float cz, float w, float h, float d, float scale)
{
    float g_vertex_buffer_data[] = {
        std::max(w + cx, cx), std::max(h + cy, cy), std::max(d + cz, cz),
        std::min(w + cx, cx), std::max(h + cy, cy), std::max(d + cz, cz),
        std::max(w + cx, cx), std::min(h + cy, cy), std::max(d + cz, cz),
        std::min(w + cx, cx), std::min(h + cy, cy), std::max(d + cz, cz),
        std::max(w + cx, cx), std::max(h + cy, cy), std::min(d + cz, cz),
        std::min(w + cx, cx), std::max(h + cy, cy), std::min(d + cz, cz),
        std::max(w + cx, cx), std::min(h + cy, cy), std::min(d + cz, cz),
        std::min(w + cx, cx), std::min(h + cy, cy), std::min(d + cz, cz),
    };

    static float vba[24];

    for (int i = 0; i < 24; i++) {
        vba[i] = g_vertex_buffer_data[i] * scale;
    }

    return vba;
}

float* createGroundSquare(float cx, float cy, float cz, float w, float h, float scale)
{
    float g_vertex_buffer_data[] = {
        std::max(w + cx, cx), std::max(h + cy, cy), cz,
        std::min(w + cx, cx), std::max(h + cy, cy), cz,
        std::max(w + cx, cx), std::min(h + cy, cy), cz,
        std::min(w + cx, cx), std::min(h + cy, cy), cz,
    };

    static float vba[24];

    for (int i = 0; i < 24; i++) {
        vba[i] = g_vertex_buffer_data[i] * scale;
    }

    return vba;
}
