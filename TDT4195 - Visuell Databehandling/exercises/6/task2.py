#!/usr/bin/python3

import numpy as np
import matplotlib.pyplot as plt
import imageio
from scipy import misc

# Read in image
filepath = imageio.imread("images/weld.tiff")

# Manually selected seedpoints
seedpoints = [
    [254, 140],
    [251, 293],
    [241, 442]
]

# Threshold
threshold = 20

def regionGrow(img, seedpoints, T):
    # Change values of pixels here when they are included
    newImage = np.zeros_like(img)
    includedPixels = []

    for seedpoint in seedpoints:
        intensityValue = img[seedpoint[0],seedpoint[1]].astype('float16')
        pixelQueue = getNeighbors(img, seedpoint)
        while pixelQueue:
            currentPixel = pixelQueue.pop()
            pixelValue = img[currentPixel[0],currentPixel[1]].astype('float16')
            if abs(pixelValue - intensityValue) < T:
                includedPixels.append(currentPixel)
                neighbors = getNeighbors(img, currentPixel)
                for pixel in neighbors:
                    if pixel not in includedPixels and pixel not in pixelQueue:
                        pixelQueue.append(pixel)

    for pixel in includedPixels:
        newImage[pixel[0],pixel[1]] = 255
    return newImage

# Returns a list of neighbors
def getNeighbors(img, pixel):
    x = pixel[0]
    y = pixel[1]
    return [(x-1, y), (x, y-1), (x+1, y), (x, y+1)]

_, ax = plt.subplots(1, 2, figsize=(15, 6))
ax[0].imshow(filepath, cmap=plt.cm.gray)
ax[0].set_axis_off()
ax[1].imshow(regionGrow(filepath, seedpoints, threshold), cmap=plt.cm.gray)
ax[1].set_axis_off()
plt.show()
