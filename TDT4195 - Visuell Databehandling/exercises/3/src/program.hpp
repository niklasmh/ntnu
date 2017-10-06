#ifndef PROGRAM_HPP
#define PROGRAM_HPP
#pragma once


// System headers
#include <GLFW/glfw3.h>
#include <glad/glad.h>
#include <string>

#include <glm/glm.hpp>
#include <glm/mat4x4.hpp>
#include <glm/gtc/type_ptr.hpp>
#include <glm/gtx/transform.hpp>

#include <stack>
#include <vector>
#include <cstdio>
#include <stdbool.h>
#include <cstdlib> 
#include <ctime> 
#include <chrono>
#include <fstream>



// Main OpenGL program
void runProgram(GLFWwindow* window);


// Function for handling keypresses
void handleKeyboardInput(GLFWwindow* window);


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


#ifndef PI 
#define PI 3.14159265
#endif

// Matrix stack related functions
std::stack<glm::mat4>* createEmptyMatrixStack();
void pushMatrix(std::stack<glm::mat4>* stack, glm::mat4 matrix);
void popMatrix(std::stack<glm::mat4>* stack);
glm::mat4 peekMatrix(std::stack<glm::mat4>* stack);

void printMatrix(glm::mat4 matrix);

// SceneGraph related functions

// Enum(eration) variables allow you to create a variable which can only take on specific values. 
// This one can be a way to implement the various animation types in this assignment.
// For more info see the SceneNode struct.
enum MotionType {LEFT_LEG_MOTION, RIGHT_LEG_MOTION, LEFT_ARM_MOTION, RIGHT_ARM_MOTION, TORSO_MOTION, HEAD_MOTION, NONE};

// In case you haven't got much experience with C or C++, let me explain this "typedef" you see below.
// The point of a typedef is that you it, as its name implies, allows you to define arbitrary data types based upon existing ones. For instance, "typedef float typeWhichMightBeAFloat;" allows you to define a variable such as this one: "typeWhichMightBeAFloat variableName = 5.0;". The C/C++ compiler translates this type into a float. 
// What is the point of using it here? A smrt person, while designing the C language, thought it would be a good idea for various reasons to force you to explicitly state that you are using a data structure datatype (struct). So, when defining a variable, you'd have to type "struct SceneNode node = ..." in the case of a SceneNode. Which can get in the way of readability.
// If we just use typedef to define a new type called "SceneNode", which really is the type "struct SceneNode", we can omit the "struct" part when creating an instance of SceneNode. 
typedef struct SceneNode {
// A list of all children that belong to this node. 
// For instance, in case of the scene graph of a human body shown in the assignment text, the "Upper Torso" node would contain the "Left Arm", "Right Arm", "Head" and "Lower Torso" nodes in its list of children.
std::vector<SceneNode*> children;

// The node's position relative to its parent
float x, y, z;
glm::vec3 directionVector;

// How you implement different motions in this assignment depends on how you choose to implement them.
// These fields here present a suggested solution. 

// We first define rotation along different axis.
float rotationX, rotationY, rotationZ;
// We also keep track of what type of motion the node should use.
// When traversing the scene graph we can decide how to update the node by inspecting its motion type setting.
MotionType motionType;
// It may be easiest to determine progress within the animation by using a variable to keep track of the direction in which the part was moved during the previous frame.
glm::vec3 rotationDirection;

// A transformation matrix representing the transformation of the node's location relative to its parent. This matrix is updated every frame.
glm::mat4 currentTransformationMatrix;

int behavior;
float xref;
float yref;
float zref;
float rotationAngularDirection;
glm::mat4 currentTransformMatrix;

// The location of the node's reference point
glm::vec3 referencePoint;

// The ID of the VAO containing the "appearance" of this SceneNode.
int vertexArrayObjectID;
} SceneNode;

// Struct for keeping track of 2D coordinates
typedef struct int2 {
int x, y;
} int2;

SceneNode* createSceneNode();
void addChild(SceneNode* parent, SceneNode* child);
void printNode(SceneNode* node);

// Utility functions
//float randomm();
double getTimeDeltaSeconds();
float toRadians(float angleDegrees);
std::vector<int2> readCoordinatesFile(std::string filePath);

// For more details, see SceneGraph.cpp.

#endif
