#!/usr/bin/python3

import numpy as np
import matplotlib.pyplot as plt
import imageio
from skimage.draw import line
from skimage.feature import canny
from skimage.morphology import square, erosion, dilation, rectangle, closing
from skimage.transform import hough_line, hough_line_peaks, probabilistic_hough_line

# Read in image
filepath = "images/task5-01.tiff"
img = imageio.imread(filepath)

def findEdges(img):

    # We use canny edge detection as of the gradients and thin lines
    edges = canny(img, 2)

    return edges

def findLines(img):
    r = img[..., 0]
    g = img[..., 1]
    b = img[..., 2]

    # Add all edges together
    edges = findEdges(r) + findEdges(g) + findEdges(b)

    # Dilate to make the edges thicker
    dilatedEdges = dilation(edges)

    # To a Hough transform to find the lines
    h, theta, d = hough_line(dilatedEdges)

    return edges, dilatedEdges, (h, theta, d)

# Removing long lines from image
def removeChessboard(img):

    # Get the major lines in the image
    edges, dilatedEdges, (h, theta, d) = findLines(img)

    # Create image with ones to fill inn lines
    lines = np.ones(img.shape[:2])

    # Add lines to image as zeroes
    for _, angle, dist in zip(*hough_line_peaks(h, theta, d)):
        y0 = (dist - 0 * np.cos(angle)) / np.sin(angle)
        y1 = (dist - img.shape[1] * np.cos(angle)) / np.sin(angle)
        x, y = line(int(y1), 0, int(y0), img.shape[1] - 1)
        x = np.clip(x, 0, img.shape[0] - 1)
        y = np.clip(y, 0, img.shape[1] - 1)
        lines[x, y] = 0

    # Remove border edges from image with all edges
    w = 4
    edges = np.pad(edges[w:img.shape[0] - w, w:img.shape[1] - w], w, mode='constant')

    # Erode the lines bigger, such that they cover the original lines
    lines = erosion(lines, square(13))

    # Remove major lines and close shape paths
    removedChessboard = closing(edges * lines, square(8))

    return removedChessboard

removedNoise = removeChessboard(img)

_, ax = plt.subplots(1, 2, figsize=(30, 10))
ax[0].imshow(img, cmap=plt.cm.gray)
ax[0].set_axis_off()

ax[1].imshow(removedNoise, cmap=plt.cm.gray)
ax[1].set_axis_off()

plt.show()
