#ifndef PROGRAM_HPP
#define PROGRAM_HPP
#pragma once


// System headers
#include <GLFW/glfw3.h>
#include <glad/glad.h>
#include <string>
#include "sceneGraph.hpp"


// Main OpenGL program
void runProgram(GLFWwindow* window);
void runProgram(GLFWwindow* window, char* file);


// Function for handling keypresses
void handleKeyboardInput(GLFWwindow* window);


// Define existing functions
int vertexArrayObject(float *vertices, unsigned int vertexCount, unsigned int *indices, unsigned int indexCount, float *colors, unsigned int colorCount);
float* createBox(float offX, float offY, float offZ, float w, float h, float d, float scale);
float* createGroundSquare(float offX, float offY, float offZ, float w, float h, float scale);
SceneNode* generateSceneNodes();
void updateSceneGraph(SceneNode* node);
void drawSceneNodes(SceneNode* node, glm::mat4 transformMatrix);
void moveCam(float x, float y, float z, float scale);

// Checks for whether an OpenGL error occurred. If one did,
// it prints out the error type and ID
inline void printGLError() {
    int errorID = glGetError();

    if(errorID != GL_NO_ERROR) {
        std::string errorString;

        switch(errorID) {
            case GL_INVALID_ENUM:
                errorString = "GL_INVALID_ENUM";
                break;
            case GL_INVALID_OPERATION:
                errorString = "GL_INVALID_OPERATION";
                break;
            case GL_INVALID_FRAMEBUFFER_OPERATION:
                errorString = "GL_INVALID_FRAMEBUFFER_OPERATION";
                break;
            case GL_OUT_OF_MEMORY:
                errorString = "GL_OUT_OF_MEMORY";
                break;
            case GL_STACK_UNDERFLOW:
                errorString = "GL_STACK_UNDERFLOW";
                break;
            case GL_STACK_OVERFLOW:
                errorString = "GL_STACK_OVERFLOW";
                break;
            default:
                errorString = "[Unknown error ID]";
                break;
        }

        fprintf(stderr, "An OpenGL error occurred (%i): %s.\n",
                errorID, errorString.c_str());
    }
}

#endif
