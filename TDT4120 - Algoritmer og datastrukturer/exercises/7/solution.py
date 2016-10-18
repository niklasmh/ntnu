#!/usr/bin/python3

from sys import stdin

def maxValue(widths, heights, values, paperWidth, paperHeight):
    # Create array; width major
    result = [None] * (paperWidth + 1)
    for w in range(paperWidth + 1):
        result[w] = [-1] * (paperHeight + 1)
    
    # Find the minimal width or height
    minSize = 10**9
    for w in widths:
        if w < minSize:
            minSize = w
    for h in heights:
        if h < minSize:
            minSize = h
    
    # Zero out all entries with too small width or height
    for a in range(minSize):
        for w in range(paperWidth):
            result[w][a] = 0
        for h in range(paperHeight):
            result[a][h] = 0
    
    # Set the values we know (better values may be found, though)
    for x in range(len(values)):
        if widths[x] <= paperWidth and heights[x] <= paperHeight and result[widths[x]][heights[x]] < values[x]:
            result[widths[x]][heights[x]] = values[x]
        if heights[x] <= paperWidth and widths[x] <= paperHeight and result[heights[x]][widths[x]] < values[x]:
            result[heights[x]][widths[x]] = values[x]
    
    # Calculate the other entries
    for w in range(paperWidth + 1):
        for h in range(paperHeight + 1):
            if result[w][h] == 0:
                continue
            if result[w][h] == -1:
                best = 0
            else:
                best = result[w][h]
            for cutWidth in range(1, w):
                if best < result[cutWidth][h] + result[w - cutWidth][h]:
                    best = result[cutWidth][h] + result[w - cutWidth][h]
            for cutHeight in range(1, h):
                if best < result[w][cutHeight] + result[w][h - cutHeight]:
                    best = result[w][cutHeight] + result[w][h - cutHeight]
            result[w][h] = best
    return result[paperWidth][paperHeight]

widths = []
heights = []
values = []
for triple in stdin.readline().split():
    dim_value = triple.split(':', 1)
    dim = dim_value[0].split('x', 1)
    width = int(dim[0][1:])
    height = int(dim[1][:-1])
    value = int(dim_value[1])
    widths.append(int(width))
    heights.append(int(height))
    values.append(int(value))
for line in stdin:
    paperWidth, paperHeight = line.split('x', 1)
    print(maxValue(widths, heights, values, int(paperWidth), int(paperHeight)))
