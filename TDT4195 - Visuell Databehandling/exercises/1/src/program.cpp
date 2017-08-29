// Local headers
#include "program.hpp"
#include "gloom/gloom.hpp"
#include "gloom/shader.hpp"

GLuint vertexArrayObject(const GLfloat *vertices, int vertexCount);

void runProgram(GLFWwindow* window)
{
    // Enable depth (Z) buffer (accept "closest" fragment)
    glEnable(GL_DEPTH_TEST);
    glDepthFunc(GL_LESS);

    // Configure miscellaneous OpenGL settings
    glEnable(GL_CULL_FACE);

    // Set default colour after clearing the colour buffer
    glClearColor(0.3f, 0.8f, 1.0f, 1.0f);
    
    static const GLfloat g_vertex_buffer_data[] = {
         0.6f, -0.8f, -1.2f,
         0.0f,  0.4f,  0.0f,
        -0.8f, -0.2f,  1.2f,
    };

    GLuint vertexbuffer = vertexArrayObject(g_vertex_buffer_data, sizeof(g_vertex_buffer_data));

    Gloom::Shader shader;
    shader.makeBasicShader("/home/niklasmh/Dropbox/NTNU/TDT4195 - Visuell Databehandling/exercises/gloom/shaders/simple.vert", "/home/niklasmh/Dropbox/NTNU/TDT4195 - Visuell Databehandling/exercises/gloom/shaders/simple.frag");
    shader.activate();
    
    // Rendering Loop
    while (!glfwWindowShouldClose(window))
    {
        // Clear colour and depth buffers
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        // Draw your scene here
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vertexbuffer);
        glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 0, (void*)0);

        glDrawArrays(GL_TRIANGLES, 0, static_cast<int>(sizeof(g_vertex_buffer_data) / 3));
        glDisableVertexAttribArray(0);

        // Handle other events
        glfwPollEvents();
        handleKeyboardInput(window);

        // Flip buffers
        glfwSwapBuffers(window);
    }
    shader.deactivate();
    shader.destroy();
}

GLuint vertexArrayObject(const GLfloat *vertices, int vertexCount)
{
    GLuint VertexArrayID;
    glGenVertexArrays(1, &VertexArrayID);
    glBindVertexArray(VertexArrayID);

    GLuint vertexbuffer;
    glGenBuffers(1, &vertexbuffer);
    glBindBuffer(GL_ARRAY_BUFFER, vertexbuffer);
    glBufferData(GL_ARRAY_BUFFER, vertexCount, vertices, GL_STATIC_DRAW);

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
