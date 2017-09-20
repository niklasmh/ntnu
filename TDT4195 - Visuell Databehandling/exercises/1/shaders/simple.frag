#version 430 core

out vec4 color;

void main()
{
    float val = (gl_FragCoord.x + gl_FragCoord.y) / 42;
    float r = sin(val)*.5f + .5f;
    float g = sin(val + 2.0f / 3.0f * 3.141f)*.5f + .5f;
    float b = sin(val + 4.0f / 3.0f * 3.141f)*.5f + .5f;
    color = vec4(r, g, b, 1.0f);
}
