#!/usr/bin/python3

import numpy as np
import matplotlib.pyplot as plt
from scipy import misc

image = misc.imread('./images/4.1.07-jelly-beans.tiff')
#image = misc.imread('./images/rainbow.tiff')
#image = misc.imread('./images/lochness.tiff')


# Return a greyed version of the image
def grey(img):
  img = np.array(img)
  r = img[..., 0]
  g = img[..., 1]
  b = img[..., 2]

  avgGrey = (r / 3 + g / 3 + b / 3) # Avoiding overflow

  img[..., 0] = avgGrey
  img[..., 1] = avgGrey
  img[..., 2] = avgGrey
  return img


# Return a greyed version of the image based on the lumination
def betterGrey(img):
  img = np.array(img)
  r = img[..., 0]
  g = img[..., 1]
  b = img[..., 2]

  avgGrey = r * 0.2126 + g * 0.7152 + b * 0.0722

  img[..., 0] = avgGrey
  img[..., 1] = avgGrey
  img[..., 2] = avgGrey
  return img


_, ax = plt.subplots(1, 3, figsize=(30, 16))

# Original image
ax[0].imshow(image)
ax[0].set_axis_off()

# The grey scaled image
ax[1].imshow(grey(image))
ax[1].set_axis_off()

# The grey scaled image with a better grey
ax[2].imshow(betterGrey(image))
ax[2].set_axis_off()

plt.show()
