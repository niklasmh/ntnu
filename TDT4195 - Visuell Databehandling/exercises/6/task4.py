#!/usr/bin/python3

import numpy as np
import matplotlib.pyplot as plt
import imageio
from skimage.morphology import erosion

# Read in image
filepath = "images/noisy.tiff"
img = imageio.imread(filepath)

def boundaryExtraction(img):

    # Creating a 3x3 array with ones
    structuringElement = np.ones((3, 3))

    # Applying erosion at the binary image
    eroded = erosion(img, structuringElement)

    # Dilate the remaining pixels from the eroded image
    boundaryExtract = img - eroded

    return eroded, boundaryExtract

eroded, boundaryExtract = boundaryExtraction(img)

_, ax = plt.subplots(1, 3, figsize=(30, 10))
ax[0].imshow(img, cmap=plt.cm.gray)
ax[0].set_axis_off()
ax[1].imshow(eroded, cmap=plt.cm.gray)
ax[1].set_axis_off()
ax[2].imshow(boundaryExtract, cmap=plt.cm.gray)
ax[2].set_axis_off()
plt.show()
