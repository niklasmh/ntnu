#include "program.hpp"
#include "gloom/gloom.hpp"
#include "gloom/shader.hpp"
#include "sceneGraph.cpp"
#include <glm/ext.hpp>

#include <iostream>

#include <math.h>
#include <vector>


// Input file here:
char const* filePath = "coordinates_0.txt";


/**
 * Run the program while setting the file path externally (as an argument).
 * 
 * @params window {GLFWwindow*} A pointer to the a pointer to the startup window
 * @params window {char const*} A string of the file path to the coordinates
 */
void runProgram(GLFWwindow* window, char* file) {
    filePath = file;
    runProgram(window);
}


// Position
float rotX = 48.0f;
float rotY = 120.0f;
float cordX = 0;
float cordY = -28.0f;
float cordZ = -5.0f;


// Globals
int pointsCount = 12 * 8;
int grundTileCount = 12 * 4;
SceneNode* startNode;
GLuint vaoHead;
GLuint vaoBody;
GLuint vaoArmLeft;
GLuint vaoArmRight;
GLuint vaoLegLeft;
GLuint vaoLegRight;


// Animation
float deltaAnimTime;
float animTime;
SceneNode* root;
bool firstTarget = true;
std::vector<glm::vec3> destinationPoints;
glm::vec3 destinationLocation;
int pointIndex = 0;
std::vector<int2> coords;
float pathDistance = 0.0f;
int coordIndex = 0;


// Adding some "physics", such that the player can jump
float gravity = -0.01f;
float velocity = 0.0f;
float floorY = 0.0f;
float playerHeight = 24.0f;
bool jumpReady = true;


// Vertices

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
const int ibdBoxCount = sizeof(g_index_buffer_data);
const int cbdCount = sizeof(g_color_buffer_data);
const float scale = 0.1f;


// Creating the initial VAOs for the ground squares
const int floorSizeW = 7;
const int floorSizeH = 5;
const int floorTileCount = floorSizeW * floorSizeH;
float floorScale = 8.0f;
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


/**
 * The GUI program.
 * 
 * @params window {GLFWwindow*} A pointer to the a pointer to the startup window
 */
void runProgram(GLFWwindow* window) {

    // Enable depth (Z) buffer (accept "closest" fragment)
    glEnable(GL_DEPTH_TEST);
    glDepthFunc(GL_LESS);

    // Configure miscellaneous OpenGL settings
    glEnable(GL_CULL_FACE);

    // Making it possible to add transparency
    glEnable(GL_BLEND);
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

    // Set default colour after clearing the colour buffer
    glClearColor(0.3f, 0.8f, 1.0f, 1.0f);

    // Generating the whole scene graph
    startNode = generateSceneNodes();

    // Creating a perspective matrix
    glm::mat4 perspectiveMatrix = glm::perspective(glm::radians(45.0f), 16.0f / 9.0f, 1.0f, 100.0f);

    // Activating vertex and fragment shaders from text files
    Gloom::Shader shader;
    shader.makeBasicShader("../gloom/shaders/simple.vert", "../gloom/shaders/simple.frag");
    shader.activate();

    // Getting the walk path
    coords = readCoordinatesFile(filePath);

    // Creating a delta time and a total animation time
    deltaAnimTime = getTimeDeltaSeconds();
    animTime = 0.0f;

    // Rendering Loop
    while (!glfwWindowShouldClose(window)) {

        // Updating the animation timing
        deltaAnimTime = getTimeDeltaSeconds();
        animTime += deltaAnimTime;

        // Clear colour and depth buffers
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        // Translation
        glm::mat4 translationMatrix = glm::translate(glm::mat4(), glm::vec3(cordX, cordY, cordZ));
        glm::mat4 rotXMatrix = glm::rotate(glm::radians(rotX), glm::vec3(1.0f, 0.0f, 0.0f));
        glm::mat4 rotYMartix = glm::rotate(glm::radians(rotY), glm::vec3(0.0f, 1.0f, 0.0f));

        // Adding the matrices in the correct order: Perspective <- Cam rotation <- Cam translation <- Instance tranformations etc...
        glm::mat4 finalTransformMatrix = perspectiveMatrix * rotXMatrix * rotYMartix * translationMatrix;

        // Updating all the nodes positions relative to the root node
        updateSceneGraph(startNode);

        // Draw the scene graph while passing in our calculated matrix describing the view (camera)
        drawSceneNodes(startNode, finalTransformMatrix);

        // Handle other events
        glfwPollEvents();
        handleKeyboardInput(window);

        // Flip buffers
        glfwSwapBuffers(window);
    }

    shader.deactivate();
    shader.destroy();
}


/**
 * Updates the scend graph such that the node parameters gets correct.
 * To search through the graph, we are using recursion.
 * 
 * @params node {SceneNode*} A pointer to the a pointer to the node which should be updated
 */
void updateSceneGraph(SceneNode* node) {

    // Update the state of the nodes before we can change their transformations
    switch (node->motionType) {
        case NONE:
            break;

        case LEFT_ARM_MOTION:
            node->rotationX = 30.0f * sin(animTime * 10.0f);
            break;

        case RIGHT_ARM_MOTION:
            node->rotationX = 30.0f * -sin(animTime * 10.0f);
            break;

        case LEFT_LEG_MOTION:
            node->rotationX = 30.0f * -sin(animTime * 10.0f);
            break;

        case RIGHT_LEG_MOTION:
            node->rotationX = 30.0f * sin(animTime * 10.0f);
            break;

        case HEAD_MOTION:
            break;

        case TORSO_MOTION:

            // Fetching the start and end coord based on an index:
            int2 coordStart = coords[coordIndex % coords.size()];
            int2 coordEnd = coords[(coordIndex + 1) % coords.size()];

            // Setting the body rotation from start to end position
            node->rotationDirection = std::atan2(coordEnd.x - coordStart.x, coordEnd.y - coordStart.y);

            // Adding a distance to walk based on the time interval
            float distance = deltaAnimTime / 2.0f;
            pathDistance += distance;

            // Calculate the added x and y from the start coord based on a total time
            float x = pathDistance * sin(node->rotationDirection);
            float y = pathDistance * cos(node->rotationDirection);

            // Checking if the body has passed the end goal in distance
            float totalDistance = std::sqrt(std::pow(coordEnd.y - coordStart.y, 2) + std::pow(coordEnd.x - coordStart.x, 2));
            if (pathDistance > totalDistance) {

                // We now change index and set the total distance walked to 0 so we can tavel the new route (line)
                coordIndex++;
                pathDistance = 0;
            }

            // Updating the position based on the floor tiles
            node->x = (coordStart.x + x + 0.5f) * floorScale;
            node->z = (coordStart.y + y + 0.5f) * floorScale;

            // Rotating the body along the y-axis, which affects all nodes attached to the body
            node->rotationY = glm::degrees(node->rotationDirection);

            // Making it possible to jump
            velocity += gravity;
            node->y += velocity;
            if (node->y <= floorY + playerHeight * scale) {
                node->y = floorY + playerHeight * scale;
                velocity = 0.0f;
                jumpReady = true;
            }
            break;
    }

    // First create all transformations
    glm::mat4 translationMatrix = glm::translate(glm::vec3(node->x, node->y, node->z));
    glm::mat4 rotXMatrix = glm::rotate(glm::radians(node->rotationX), glm::vec3(1.0f, 0.0f, 0.0f));
    glm::mat4 rotYMatrix = glm::rotate(glm::radians(node->rotationY), glm::vec3(0.0f, 1.0f, 0.0f));
    glm::mat4 rotZMatrix = glm::rotate(glm::radians(node->rotationZ), glm::vec3(0.0f, 0.0f, 1.0f));
    glm::mat4 rotMatrix = rotXMatrix * rotYMatrix * rotZMatrix;

    // Add them together in the correct order
    glm::mat4 localTransformMatrix = translationMatrix * rotMatrix;

    // Apply them to the node
    node->currentTransformationMatrix = localTransformMatrix;

    // Do this for all its child nodes
    for (SceneNode* child : node->children) {
        updateSceneGraph(child);
    }
}


/**
 * Draw the scene based on the scene graph and the global transformations applied.
 * 
 * @params node {SceneNode*} A pointer to the a pointer to the node in the scene graph which should be drawn
 * @params transformMatrix {glm::mat4} The final transform matrix which should be applied to all vertices
 */
void drawSceneNodes(SceneNode* node, glm::mat4 transformMatrix) {

    // Check if node has a VAO. If that is true, draw it
    if (node->vertexArrayObjectID != -1) {

        // Adding the spesific transformation from the current node to its vertices
        transformMatrix *= node->currentTransformationMatrix;

        // Referring to the created ID such that we know which buffers we should handle
        glBindVertexArray(node->vertexArrayObjectID);

        // Before drawing, we apply our new transformation to the uniform in the vertex shader
        glUniformMatrix4fv(4, 1, GL_FALSE, glm::value_ptr(glm::transpose(transformMatrix)));

        // Drawing the triangles from the buffers
        glDrawElements(GL_TRIANGLES, node->indexCount, GL_UNSIGNED_INT, (void*)0);
    }

    // Then we go through all its children, if there is any
    for (SceneNode* child : node->children) {
        drawSceneNodes(child, transformMatrix);
    }
}

/**
 * Creating all the shapes into the buffers and attaching them to a scene graph.
 * Also setting their initial positions.
 * 
 * @return {SceneNode*} A pointer to the pointer to the root node in the scene graph
 */
SceneNode* generateSceneNodes() {

    // Creating the initial VAOs for the body
    vaoHead = vertexArrayObject(createBox(-4.0f, 0.0f, -4.0f, 8.0f, 8.0f, 8.0f, scale), pointsCount, g_index_buffer_data, ibdBoxCount, g_color_buffer_data, cbdCount);
    vaoBody = vertexArrayObject(createBox(-4.0f, 0.0f, -2.0f, 8.0f, -12.0f, 4.0f, scale), pointsCount, g_index_buffer_data, ibdBoxCount, g_color_buffer_data, cbdCount);
    vaoArmLeft = vertexArrayObject(createBox(-2.0f, 0.0f, -2.0f, 4.0f, -12.0f, 4.0f, scale), pointsCount, g_index_buffer_data, ibdBoxCount, g_color_buffer_data, cbdCount);
    vaoArmRight = vertexArrayObject(createBox(-2.0f, 0.0f, -2.0f, 4.0f, -12.0f, 4.0f, scale), pointsCount, g_index_buffer_data, ibdBoxCount, g_color_buffer_data, cbdCount);
    vaoLegLeft = vertexArrayObject(createBox(-2.0f, 0.0f, -2.0f, 4.0f, -12.0f, 4.0f, scale), pointsCount, g_index_buffer_data, ibdBoxCount, g_color_buffer_data, cbdCount);
    vaoLegRight = vertexArrayObject(createBox(-2.0f, 0.0f, -2.0f, 4.0f, -12.0f, 4.0f, scale), pointsCount, g_index_buffer_data, ibdBoxCount, g_color_buffer_data, cbdCount);

    // Creating VAOs for each tile. The advantage of this is that the floot can change its structure if needed.
    for (int i = 0; i < floorTileCount; i++) {

        // Switching between even/odd colors on chess board
        if (i % 2 == 0) {
            vaoGround[i] = vertexArrayObject(
                createGroundSquare(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, floorScale), grundTileCount,
                g_index_buffer_data_ground, ibdGroundCount,
                green_color_buffer_data_ground, cbdGroundCount
            );
        } else {
            vaoGround[i] = vertexArrayObject(
                createGroundSquare(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, floorScale), grundTileCount,
                g_index_buffer_data_ground, ibdGroundCount,
                purple_color_buffer_data_ground, cbdGroundCount
            );
        }
    }

    // Generating a SceneNode for each object
    SceneNode* rootNode = createSceneNode();
    SceneNode* groundNode = createSceneNode();
    SceneNode* tileNodes[floorTileCount];

    SceneNode* headNode = createSceneNode();
    SceneNode* bodyNode = createSceneNode();
    SceneNode* armLeftNode = createSceneNode();
    SceneNode* armRightNode = createSceneNode();
    SceneNode* legLeftNode = createSceneNode();
    SceneNode* legRightNode = createSceneNode();

    // Connecting the edges between the nodes in the scene graph
    addChild(rootNode, groundNode);

    addChild(rootNode, bodyNode);
    addChild(bodyNode, headNode);
    addChild(bodyNode, armLeftNode);
    addChild(bodyNode, armRightNode);
    addChild(bodyNode, legLeftNode);
    addChild(bodyNode, legRightNode);

    for (unsigned int i = 0; i < floorTileCount; i++) {

        // Binding all the tiles to the ground node
        tileNodes[i] = createSceneNode();
        addChild(groundNode, tileNodes[i]);

        // Adding all the tiles as their own nodes while setting their positions
        tileNodes[i]->x = (i % floorSizeW) * floorScale;
        tileNodes[i]->y = floorY;
        tileNodes[i]->z = std::floor(i / floorSizeW) * floorScale;
        tileNodes[i]->vertexArrayObjectID = vaoGround[i];
        tileNodes[i]->indexCount = ibdGroundCount;
    }

    // Head
    bodyNode->motionType = HEAD_MOTION;
    headNode->vertexArrayObjectID = vaoHead;
    headNode->indexCount = ibdBoxCount;

    // Torso
    bodyNode->y = playerHeight * scale;
    bodyNode->motionType = TORSO_MOTION;
    bodyNode->vertexArrayObjectID = vaoBody;
    bodyNode->indexCount = ibdBoxCount;

    // Left arm
    armLeftNode->x = -6.0f * scale;
    armLeftNode->motionType = LEFT_ARM_MOTION;
    armLeftNode->vertexArrayObjectID = vaoArmLeft;
    armLeftNode->indexCount = ibdBoxCount;

    // Right arm
    armRightNode->x = 6.0f * scale;
    armRightNode->motionType = RIGHT_ARM_MOTION;
    armRightNode->vertexArrayObjectID = vaoArmRight;
    armRightNode->indexCount = ibdBoxCount;

    // Left leg
    legLeftNode->x = -2.0f * scale;
    legLeftNode->y = -12.0f * scale;
    legLeftNode->motionType = LEFT_LEG_MOTION;
    legLeftNode->vertexArrayObjectID = vaoLegLeft;
    legLeftNode->indexCount = ibdBoxCount;

    // Right leg
    legRightNode->x = 2.0f * scale;
    legRightNode->y = -12.0f * scale;
    legRightNode->motionType = RIGHT_LEG_MOTION;
    legRightNode->vertexArrayObjectID = vaoLegRight;
    legRightNode->indexCount = ibdBoxCount;

    return rootNode;
}


/**
 * Creating a vertex array object which is binded to the buffers.
 * 
 * @param vertices {float*} A pointer to the vertices for all points
 * @param vertexCount {unsigned int} The number of vertices given
 * @param indices {unsigned int*} A pointer to the indices for describing all points in the triangles
 * @param indexCount {unsigned int} The number of indices given
 * @param colors {float*} A pointer to the colors of each vertex given
 * @param colorCount {unsigned int} The number of color points given
 * 
 * @return {int} The ID for the vertex array object
 */
int vertexArrayObject(float *vertices, unsigned int vertexCount, unsigned int *indices, unsigned int indexCount, float *colors, unsigned int colorCount) {
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


/**
 * Listener for keyboard events.
 * 
 * @param window {GLFWwindow*} A pointer to the a pointer to the startup window
 */
void handleKeyboardInput(GLFWwindow* window) {

    // Use escape key for terminating the GLFW window
    if (glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_PRESS)
        glfwSetWindowShouldClose(window, GL_TRUE);

    // Making it possible to navigate as a drone
    if (glfwGetKey(window, GLFW_KEY_W) == GLFW_PRESS) moveCam(0, 0, 1.0f, 0.1f);
    if (glfwGetKey(window, GLFW_KEY_S) == GLFW_PRESS) moveCam(0, 0, -1.0f, 0.1f);
    if (glfwGetKey(window, GLFW_KEY_A) == GLFW_PRESS) moveCam(1.0f, 0, 0, 0.1f);
    if (glfwGetKey(window, GLFW_KEY_D) == GLFW_PRESS) moveCam(-1.0f, 0, 0, 0.1f);
    if (glfwGetKey(window, GLFW_KEY_SPACE) == GLFW_PRESS) moveCam(0, 1.0f, 0, 0.1f);
    if (glfwGetKey(window, GLFW_KEY_LEFT_CONTROL) == GLFW_PRESS) moveCam(0, -1.0f, 0, 0.1f);
    if (glfwGetKey(window, GLFW_KEY_UP) == GLFW_PRESS) rotX -= 1.0;
    if (glfwGetKey(window, GLFW_KEY_DOWN) == GLFW_PRESS) rotX += 1.0;
    if (glfwGetKey(window, GLFW_KEY_LEFT) == GLFW_PRESS) rotY -= 1.0;
    if (glfwGetKey(window, GLFW_KEY_RIGHT) == GLFW_PRESS) rotY += 1.0;

    // Making the body jump
    if (glfwGetKey(window, GLFW_KEY_J) == GLFW_PRESS && jumpReady) {
        velocity = 0.3f;
        jumpReady = false;
    }
}


/**
 * Translate the cam relative to its rotation.
 * 
 * @params x {float} Steps in the x-axis of the cam
 * @params y {float} Steps in the y-axis of the cam
 * @params z {float} Steps in the z-axis of the cam
 * @params scale {float} The scale of the steps
 */
void moveCam(float x, float y, float z, float scale) {
    float dist = scale * std::sqrt(x * x + y * y + z * z);

    cordX += x * dist * sin(glm::radians(-rotY) + PI / 2);
    cordZ += x * dist * cos(glm::radians(-rotY) + PI / 2);
    
    cordX += y * dist * sin(glm::radians(-rotY)) * cos(glm::radians(rotX) - PI / 2);
    cordY += y * dist * sin(glm::radians(rotX) - PI / 2);
    cordZ += y * dist * cos(glm::radians(-rotY)) * cos(glm::radians(rotX) - PI / 2);

    cordX += z * dist * sin(glm::radians(-rotY)) * cos(glm::radians(rotX));
    cordY += z * dist * sin(glm::radians(rotX));
    cordZ += z * dist * cos(glm::radians(-rotY)) * cos(glm::radians(rotX));
}


/**
 * Creating vertices for a box shape.
 * 
 * @param offX {float} Offset position in the x-axis
 * @param offY {float} Offset position in the y-axis
 * @param offZ {float} Offset position in the z-axis
 * @param w {float} Width
 * @param h {float} Height
 * @param d {float} Depth
 * 
 * @return {float*} A pointer to the pointer to a vertex buffer array with 8 unique points
 */
float* createBox(float offX, float offY, float offZ, float w, float h, float d, float scale) {
    float g_vertex_buffer_data[] = {
        std::max(w + offX, offX), std::max(h + offY, offY), std::max(d + offZ, offZ),
        std::min(w + offX, offX), std::max(h + offY, offY), std::max(d + offZ, offZ),
        std::max(w + offX, offX), std::min(h + offY, offY), std::max(d + offZ, offZ),
        std::min(w + offX, offX), std::min(h + offY, offY), std::max(d + offZ, offZ),
        std::max(w + offX, offX), std::max(h + offY, offY), std::min(d + offZ, offZ),
        std::min(w + offX, offX), std::max(h + offY, offY), std::min(d + offZ, offZ),
        std::max(w + offX, offX), std::min(h + offY, offY), std::min(d + offZ, offZ),
        std::min(w + offX, offX), std::min(h + offY, offY), std::min(d + offZ, offZ),
    };

    static float vba[24];

    for (int i = 0; i < 24; i++) {
        vba[i] = g_vertex_buffer_data[i] * scale;
    }

    return vba;
}


/**
 * Creating vertices for a flat rectangle aligned with the xz-plane.
 * 
 * @param offX {float} Offset position in the x-axis
 * @param offY {float} Offset position in the y-axis
 * @param offZ {float} Offset position in the z-axis
 * @param w {float} Width
 * @param h {float} Height
 * 
 * @return {float*} A pointer to the pointer to a vertex buffer array with 4 unique points
 */
float* createGroundSquare(float offX, float offY, float offZ, float w, float h, float scale) {
    float g_vertex_buffer_data[] = {
        std::max(w + offX, offX), offY, std::max(h + offZ, offZ),
        std::min(w + offX, offX), offY, std::max(h + offZ, offZ),
        std::max(w + offX, offX), offY, std::min(h + offZ, offZ),
        std::min(w + offX, offX), offY, std::min(h + offZ, offZ),
    };

    static float vba[12];

    for (int i = 0; i < 12; i++) {
        vba[i] = g_vertex_buffer_data[i] * scale;
    }

    return vba;
}
