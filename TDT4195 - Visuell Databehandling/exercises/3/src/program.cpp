// Local headers
#include <iostream>
#include <glm/ext.hpp>
#include "program.hpp"
//#include "sceneGraph.hpp"
#include "gloom/gloom.hpp"
#include "gloom/shader.hpp"

int vertexArrayObject(float *vertices, unsigned int vertexCount, unsigned int *indices, unsigned int indexCount, float *colors, unsigned int colorCount);
float* createBox(float cx, float cy, float cz, float w, float h, float d, float scale);
float* createGroundSquare(float cx, float cy, float cz, float w, float h, float scale);
SceneNode* generateSceneNodes();
void updateSceneGraph(SceneNode* node);
void drawSceneNodes(SceneNode* node, glm::mat4 transformMatrix);

// Position
float rotX = 0;
float rotY = 0;
float cordX = 0;
float cordY = -2.0f;
float cordZ = -3.0f;

// Globals
int pointsCount = 12 * 8;
SceneNode* startNode;
int vaoGround;
int vaoHead;
int vaoBody;
int vaoArmLeft;
int vaoArmRight;
int vaoLegLeft;
int vaoLegRight;

// Animation
float deltaAnimTime;
SceneNode* root;
bool firstTarget = true;
std::vector<glm::vec3> destinationPoints;
glm::vec3 destinationLocation;
int pointIndex = 0;

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

    // Generating the whole scene graph
    //startNode = generateSceneNodes();
    
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

    // Setting some constant variables for creating the initial VAOs
    const int ibdCount = sizeof(g_index_buffer_data);
    const int cbdCount = sizeof(g_color_buffer_data);
    const float scale = 0.1f;

    // Creating the initial VAOs for the body
    vaoHead = vertexArrayObject(createBox(-4.0f, 24.0f, -4.0f, 8.0f, 8.0f, 8.0f, scale), pointsCount, g_index_buffer_data, ibdCount, g_color_buffer_data, cbdCount);
    vaoBody = vertexArrayObject(createBox(-4.0f, 24.0f, -2.0f, 8.0f, -12.0f, 4.0f, scale), pointsCount, g_index_buffer_data, ibdCount, g_color_buffer_data, cbdCount);
    vaoArmLeft = vertexArrayObject(createBox(-8.0f, 24.0f, -2.0f, 4.0f, -12.0f, 4.0f, scale), pointsCount, g_index_buffer_data, ibdCount, g_color_buffer_data, cbdCount);
    vaoArmRight = vertexArrayObject(createBox(4.0f, 24.0f, -2.0f, 4.0f, -12.0f, 4.0f, scale), pointsCount, g_index_buffer_data, ibdCount, g_color_buffer_data, cbdCount);
    vaoLegLeft = vertexArrayObject(createBox(-4.0f, 12.0f, -2.0f, 4.0f, -12.0f, 4.0f, scale), pointsCount, g_index_buffer_data, ibdCount, g_color_buffer_data, cbdCount);
    vaoLegRight = vertexArrayObject(createBox(0.0f, 12.0f, -2.0f, 4.0f, -12.0f, 4.0f, scale), pointsCount, g_index_buffer_data, ibdCount, g_color_buffer_data, cbdCount);
    
    // Adding the VAOs to a list
    GLuint vaoList[] = {
        vaoHead,
        vaoBody,
        vaoArmLeft,
        vaoArmRight,
        vaoLegLeft,
        vaoLegRight,
    };

    // Creating the initial VAOs for the ground squares
    const int floorSizeW = 7;
    const int floorSizeH = 5;
    const int floorTileCount = floorSizeW * floorSizeH;
    float floorScale = 1.0f;
    GLuint vaoGround[floorTileCount];

    unsigned int g_index_buffer_data_ground[] = {
        0, 2, 1,
        2, 3, 1,
    };

    float green_color_buffer_data_ground[] = {
        0.0f, 1.0f, 0.0f, 1.0f, // Green
        0.0f, 1.0f, 0.0f, 1.0f, // Green
        0.0f, 1.0f, 0.0f, 1.0f, // Green
        0.0f, 1.0f, 0.0f, 1.0f, // Green
    };

    float purple_color_buffer_data_ground[] = {
        0.5f, 0.0f, 1.0f, 1.0f, // Purple
        0.5f, 0.0f, 1.0f, 1.0f, // Purple
        0.5f, 0.0f, 1.0f, 1.0f, // Purple
        0.5f, 0.0f, 1.0f, 1.0f, // Purple
    };

    const int ibdGroundCount = sizeof(g_index_buffer_data_ground);
    const int cbdGroundCount = sizeof(green_color_buffer_data_ground);

    for (int i = 0; i < floorTileCount; i++) {

        // Switching between even/odd colors on chess board
        if (i % 2 == 0) {
            vaoGround[i] = vertexArrayObject(
                createGroundSquare((i % floorSizeW - floorSizeW / 2) * floorSizeW, 0.0f, -std::floor(i / floorSizeW) * floorSizeH, floorSizeW, floorSizeH, floorScale), pointsCount,
                g_index_buffer_data_ground, ibdGroundCount,
                green_color_buffer_data_ground, cbdGroundCount
            );
        } else {
            vaoGround[i] = vertexArrayObject(
                createGroundSquare((i % floorSizeW - floorSizeW / 2) * floorSizeW, 0.0f, -std::floor(i / floorSizeW) * floorSizeH, floorSizeW, floorSizeH, floorScale), pointsCount,
                g_index_buffer_data_ground, ibdGroundCount,
                purple_color_buffer_data_ground, cbdGroundCount
            );
        }
    }

    // Generating a SceneNode for each object
    SceneNode* rootNode = createSceneNode();
    SceneNode* groundNode = createSceneNode();
    SceneNode* squareNode = createSceneNode();

    SceneNode* headNode = createSceneNode();
    SceneNode* bodyNode = createSceneNode();
    SceneNode* armLeftNode = createSceneNode();
    SceneNode* armRightNode = createSceneNode();
    SceneNode* legLeftNode = createSceneNode();
    SceneNode* legRightNode = createSceneNode();

    // Connecting the edges between the nodes in the scene graph
    addChild(rootNode, groundNode);
    addChild(groundNode, squareNode);

    addChild(rootNode, bodyNode);
    addChild(bodyNode, headNode);
    addChild(bodyNode, armLeftNode);
    addChild(bodyNode, armRightNode);
    addChild(bodyNode, legLeftNode);
    addChild(bodyNode, legRightNode);


    // Creating an identity and perspective matrix for later
    glm::mat4x4 identityMatrix = glm::mat4(1.0f);
    glm::mat4x4 perspectiveMatrix = glm::perspective(glm::radians(45.0f), 16.0f / 9.0f, 1.0f, 100.0f);

    // Activating vertex and fragment shaders from text files
    Gloom::Shader shader;
    shader.makeBasicShader("../gloom/shaders/simple.vert", "../gloom/shaders/simple.frag");
    shader.activate();

    deltaAnimTime = getTimeDeltaSeconds();

    // Rendering Loop
    while (!glfwWindowShouldClose(window))
    {
        // Updating the animation timing
        deltaAnimTime = getTimeDeltaSeconds();

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

        glm::mat4x4 finalTransformMatrix = transposedRotX * transposedRotY * transposedTrans * perspectiveMatrix * identityMatrix;
        glUniformMatrix4fv(4, 1, GL_FALSE, glm::value_ptr(finalTransformMatrix));

        //updateSceneGraph(startNode);
        //drawSceneNodes(startNode, finalTransformMatrix);
        // Drawing VAOs from the VAO ground array
        int listSize = sizeof(vaoGround);
        for (int i = 0; i < listSize; i++) {
            glBindVertexArray(vaoGround[i]);
            //printf("VAO id: %i\n", vaoGround[i]);
            glDrawElements(GL_TRIANGLES, sizeof(g_index_buffer_data_ground) / sizeof(unsigned int), GL_UNSIGNED_INT, (void*)0);
        }
        // Drawing VAOs from the VAO body array
        listSize = sizeof(vaoList);
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

int vertexArrayObject(float *vertices, unsigned int vertexCount, unsigned int *indices, unsigned int indexCount, float *colors, unsigned int colorCount)
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
        glfwSetWindowShouldClose(window, GL_TRUE);
    if (glfwGetKey(window, GLFW_KEY_UP) == GLFW_PRESS)
        cordY += 0.01;
    if (glfwGetKey(window, GLFW_KEY_DOWN) == GLFW_PRESS)
        cordY -= 0.01;
    if (glfwGetKey(window, GLFW_KEY_LEFT) == GLFW_PRESS)
        cordX -= 0.01;
    if (glfwGetKey(window, GLFW_KEY_RIGHT) == GLFW_PRESS)
        cordX += 0.01;
    if (glfwGetKey(window, GLFW_KEY_SPACE) == GLFW_PRESS)
        cordZ += 0.01;
    if (glfwGetKey(window, GLFW_KEY_LEFT_CONTROL) == GLFW_PRESS)
        cordZ -= 0.01;
    if (glfwGetKey(window, GLFW_KEY_W) == GLFW_PRESS)
        rotX += 1.0;
    if (glfwGetKey(window, GLFW_KEY_S) == GLFW_PRESS)
        rotX -= 1.0;
    if (glfwGetKey(window, GLFW_KEY_A) == GLFW_PRESS)
        rotY -= 1.0;
    if (glfwGetKey(window, GLFW_KEY_D) == GLFW_PRESS)
        rotY += 1.0;
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
        std::max(w + cx, cx), cy, std::max(h + cz, cz),
        std::min(w + cx, cx), cy, std::max(h + cz, cz),
        std::max(w + cx, cx), cy, std::min(h + cz, cz),
        std::min(w + cx, cx), cy, std::min(h + cz, cz),
    };

    static float vba[12];

    for (int i = 0; i < 12; i++) {
        vba[i] = g_vertex_buffer_data[i] * scale;
        //std::cout << i << " = " << vba[i] << std::endl;
    }

    return vba;
}

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
    node->directionVector = glm::vec3(0, 0, 0);
    node->rotationDirection = glm::vec3(0, 0, 0);
    node->motionType = NONE;
    node->referencePoint = glm::vec3(0, 0, 0);
    node->vertexArrayObjectID = -1;
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
        node->children.size() / sizeof(unsigned int),
        node->rotationX, node->rotationY, node->rotationZ,
        node->x, node->y, node->z,
        node->referencePoint.x, node->referencePoint.y, node->referencePoint.z,
        node->vertexArrayObjectID
    );
}

// --- Utility functions ---

// The standard library's random number generator needs to be seeded in order to produce
// different results every time the program is run. This should only happen once, so
// we keep track here with a global variable whether this has happened previously.
bool isRandomInitialised = false;

//float randomm() {
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
