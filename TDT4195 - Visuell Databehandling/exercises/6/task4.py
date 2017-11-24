#!/usr/bin/python3

import numpy as np
import matplotlib.pyplot as plt
import imageio
from skimage.morphology import erosion, dilation, disk

# Read in image
filepath = "images/noisy.tiff"
img = imageio.imread(filepath)

def removeNoise(img, r=7):

    structuringElement = disk(r)

    # Applying erosion at the binary image
    eroded = erosion(img, structuringElement)

    # Dilate the remaining pixels from the eroded image
    dilated = dilation(eroded, structuringElement)

    # We have now opened the image. Now we need to close it:

    # We could have done this in the same step as the last, but we want to show all steps
    dilated2 = dilation(dilated, structuringElement)

    # Then we close by eroding back to normal
    result = erosion(dilated2, structuringElement)

    return result

def boundaryExtraction(img):

    # Creating a 3x3 array with ones
    structuringElement = np.ones((3, 3))

    # Applying erosion at the binary image
    eroded = erosion(img, structuringElement)

    # Dilate the remaining pixels from the eroded image
    boundaryExtract = img - eroded

    return eroded, boundaryExtract

noiseRemoved = removeNoise(img)
eroded, boundaryExtract = boundaryExtraction(noiseRemoved)

_, ax = plt.subplots(1, 3, figsize=(30, 10))
ax[0].imshow(noiseRemoved, cmap=plt.cm.gray)
ax[0].set_axis_off()

ax[1].imshow(eroded, cmap=plt.cm.gray)
ax[1].set_axis_off()

ax[2].imshow(boundaryExtract, cmap=plt.cm.gray)
ax[2].set_axis_off()

plt.show()
