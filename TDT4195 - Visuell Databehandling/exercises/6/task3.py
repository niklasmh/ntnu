#!/usr/bin/python3

import numpy as np
import matplotlib.pyplot as plt
import imageio
from skimage.morphology import erosion, dilation

# Read in image
filepath = "images/noisy.tiff"
img = imageio.imread(filepath)

def removeNoise(img, r=7):

    # Creating a circle inside an array
    c = r # Center
    d = 2 * r + 1 # Diameter
    y, x = np.ogrid[-c:d-c, -c:d-c] # Create a True/False grid in numpy
    mask = x * x + y * y <= r * r # Circular shape
    structuringElement = np.zeros((d, d))
    structuringElement[mask] = 1 # Fill ones at the places with True

    # Applying erosion at the binary image
    eroded = erosion(img, structuringElement)

    # Dilate the remaining pixels from the eroded image
    dilated = dilation(eroded, structuringElement)

    # We have now opened the image. Now we need to close it:

    # We could have done this in the same step as the last, but we want to show all steps
    dilated2 = dilation(dilated, structuringElement)

    # Then we close by eroding back to normal
    eroded2 = erosion(dilated2, structuringElement)

    return eroded, dilated, dilated2, eroded2

# Using a structuring element with radius 7 to reach all noise
eroded, dilated, dilated2, eroded2 = removeNoise(img, 7)

_, ax = plt.subplots(1, 5, figsize=(30, 10))
ax[0].imshow(img, cmap=plt.cm.gray)
ax[0].set_axis_off()
ax[1].imshow(eroded, cmap=plt.cm.gray)
ax[1].set_axis_off()
ax[2].imshow(dilated, cmap=plt.cm.gray)
ax[2].set_axis_off()
ax[3].imshow(dilated2, cmap=plt.cm.gray)
ax[3].set_axis_off()
ax[4].imshow(eroded2, cmap=plt.cm.gray)
ax[4].set_axis_off()
plt.show()
