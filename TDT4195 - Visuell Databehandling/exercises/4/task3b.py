#!/usr/bin/python3

import numpy as np
import matplotlib.pyplot as plt
from scipy import misc

image = misc.imread('./images/4.1.07-jelly-beans.tiff')
#image = misc.imread('./images/rainbow.tiff')
#image = misc.imread('./images/lochness.tiff')


# Our better grey function from task 2
def grey(img):
  img = np.array(img)
  r = img[..., 0]
  g = img[..., 1]
  b = img[..., 2]

  avgGrey = r * 0.2126 + g * 0.7152 + b * 0.0722

  img[..., 0] = avgGrey
  img[..., 1] = avgGrey
  img[..., 2] = avgGrey
  return img


# Apply the gamma function to an image
def brightness(img, c=1, gamma=1):
  img = np.array(img)

  normalizationFactor = 255**(1 - gamma)
  c *= normalizationFactor # Normalize by scaling the max intensity to 255

  img[..., 0] = c * img[..., 0]**gamma
  img[..., 1] = c * img[..., 1]**gamma
  img[..., 2] = c * img[..., 2]**gamma

  return img


_, ax = plt.subplots(1, 3, figsize=(30, 16))

# The grey scaled and brightned image
ax[0].imshow(brightness(grey(image), 1, 1.5))
ax[0].set_axis_off()

# Original image in grey
ax[1].imshow(brightness(grey(image), 1, 1))
ax[1].set_axis_off()

# The grey scaled and brightned image
ax[2].imshow(brightness(grey(image), 1, .5))
ax[2].set_axis_off()

plt.show()
