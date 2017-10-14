#include "sceneGraph.hpp"
#include <iostream>

// --- Matrix Stack related functions ---

// You can use these to create a more "realistic" scene graph implementation 

// Allocate a new empty matrix stack on the heap
std::stack<glm::mat4>* createEmptyMatrixStack() {
    return new std::stack<glm::mat4>();
}

// Push a matrix on top of the stack
void pushMatrix(std::stack<glm::mat4>* stack, glm::mat4 matrix) {
    stack->push(matrix);
}

// Remove a matrix from the top of the stack. The popped value is not returned.
void popMatrix(std::stack<glm::mat4>* stack) {
    stack->pop();
}

// Return the matrix which is currently at the top of the stack
glm::mat4 peekMatrix(std::stack<glm::mat4>* stack) {
    return stack->top();
}

// Pretty prints the values of a matrix to stdout. 
void printMatrix(glm::mat4 matrix) {
    float* values = glm::value_ptr(matrix);

    printf("(%f, %f, %f, %f)\n(%f, %f, %f, %f)\n(%f, %f, %f, %f)\n(%f, %f, %f, %f)\n",
        values[0], values[4], values[8], values[12], 
        values[1], values[5], values[9], values[13], 
        values[2], values[6], values[10], values[14], 
        values[3], values[7], values[11], values[15]);
}

// --- Scene Graph related functions ---

// Creates an empty SceneNode instance.
// Values are initialised because otherwise they may contain garbage memory.
SceneNode* createSceneNode() {
    SceneNode* node = new SceneNode;
    node->rotationX = 0;
    node->rotationY = 0;
    node->rotationZ = 0;
    node->x = 0;
    node->y = 0;
    node->z = 0;
    node->rotationDirection = 0;
    node->motionType = NONE;
    node->referencePoint = glm::vec3(0, 0, 0);
    node->currentTransformationMatrix = glm::mat4();
    node->vertexArrayObjectID = -1;
    node->indexCount = 0;
    return node;
}

// Add a child node to its parent's list of children
void addChild(SceneNode* parent, SceneNode* child) {
    parent->children.push_back(child);
}

// Pretty prints the current values of a SceneNode instance to stdout
void printNode(SceneNode* node) {
    printf(
        "SceneNode {\n"
        "    Child count: %i\n"
        "    Rotation: (%f, %f, %f)\n"
        "    Location: (%f, %f, %f)\n"
        "    Reference point: (%f, %f, %f)\n"
        "    VAO ID: %i\n"
        "}\n",
        static_cast<int>(node->children.size()),
        node->rotationX, node->rotationY, node->rotationZ,
        node->x, node->y, node->z,
        node->referencePoint.x, node->referencePoint.y, node->referencePoint.z, 
        node->vertexArrayObjectID);
}

// --- Utility functions ---

// The standard library's random number generator needs to be seeded in order to produce
// different results every time the program is run. This should only happen once, so
// we keep track here with a global variable whether this has happened previously.
bool isRandomInitialised = false;

//float random() {
//	if (!isRandomInitialised) {
//		// Initialise the random number generator using the current time as a seed
//		srand(static_cast <unsigned> (time(0)));
//		isRandomInitialised = true;
//	}
//	// rand() produces a random integer between 0 and RAND_MAX. This normalises it to a number between 0 and 1.
//	return static_cast <float> (rand()) / static_cast <float>(RAND_MAX);
//}

// In order to be able to calculate when the getTimeDeltaSeconds() function was last called, we need to know the point in time when that happened. This requires us to keep hold of that point in time. 
// We initialise this value to the time at the start of the program.
static std::chrono::steady_clock::time_point _previousTimePoint = std::chrono::steady_clock::now();

// Calculates the elapsed time since the previous time this function was called.
double getTimeDeltaSeconds() {
    // Determine the current time
    std::chrono::steady_clock::time_point currentTime = std::chrono::steady_clock::now();
    // Look up the time when the previous call to this function occurred.
    //std::chrono::steady_clock::time_point previousTime = _previousTimePoint;

    // Calculate the number of nanoseconds that elapsed since the previous call to this function
    long long timeDelta = std::chrono::duration_cast<std::chrono::nanoseconds>(currentTime - _previousTimePoint).count();
    // Convert the time delta in nanoseconds to seconds
    double timeDeltaSeconds = (double)timeDelta / 1000000000.0;
    
    // Store the previously measured current time
    _previousTimePoint = currentTime;
    
    // Return the calculated time delta in seconds
    return timeDeltaSeconds;
}

float toRadians(float angleDegrees) {
    return angleDegrees * (PI / 180.0);
}

// Reads a text file containing 2D integer coordinates in a specific format
// and returns a vector with these coordinates.
std::vector<int2> readCoordinatesFile(std::string filePath) {
    // Open input file
    std::ifstream inputFile(filePath);
    std::vector<int2> foundPoints;

    // Check in case the file failed to open
    if(!inputFile)
    {
        std::cerr << "Could not open file located at: " << filePath.c_str() << std::endl;
        std::cerr << "Most likely the file was not found." << std::endl;
        return foundPoints;
    }

    // Determine the number of points in the text file (specified by the first line)
    int pointCount;
    inputFile >> pointCount;

    // Read all coordinates
    for(int i = 0; i < pointCount; i++)
    {
        int2 currentPoint;
        inputFile >> currentPoint.x >> currentPoint.y;
        foundPoints.push_back(currentPoint);
    }

    // We'll be good citizens and let the OS know we're done with this file
    inputFile.close();

    // Return the points we loaded
    return foundPoints;
}
