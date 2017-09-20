#version 430 core

in vec3 position;
in layout(location=1) vec4 vertexColor;

out layout(location=1) vec4 outVertexColor;

void main()
{
    outVertexColor = vertexColor;
    vec3 newPosition = position * vec3(-1, -1, 1);
    gl_Position = vec4(newPosition, 1.0f);
}
