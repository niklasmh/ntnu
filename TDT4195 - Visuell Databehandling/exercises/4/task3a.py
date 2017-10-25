#!/usr/bin/python3

import numpy as np
import matplotlib.pyplot as plt
from scipy import misc

image = misc.imread('./images/4.1.07-jelly-beans.tiff')
#image = misc.imread('./images/rainbow.tiff')
#image = misc.imread('./images/lochness.tiff')
#print(image.shape)


# Our better grey function from task 2
def grey(img):
  img = np.array(img)
  r = img[..., 0]
  g = img[..., 1]
  b = img[..., 2]

  avgGrey = (r * 0.2126 + g * 0.7152 + b * 0.0722)

  img[..., 0] = avgGrey
  img[..., 1] = avgGrey
  img[..., 2] = avgGrey
  return img


# Return the negated version of the image
def negation(img):
  img = np.array(img)

  # 2**8 - 1 = 255 is the value with the highest intensity as this is a 8-bit representation
  img[..., 0] = 255 - img[..., 0]
  img[..., 1] = 255 - img[..., 1]
  img[..., 2] = 255 - img[..., 2]

  return img


_, ax = plt.subplots(1, 3, figsize=(30, 16))

# Original image
ax[0].imshow(image)
ax[0].set_axis_off()

# The grey scaled image
ax[1].imshow(grey(image))
ax[1].set_axis_off()

# The grey scaled and negated image
ax[2].imshow(negation(grey(image)))
# ax[2].imshow(grey(negation(image))) # It does not matter if the grey comes before or after the negation
ax[2].set_axis_off()

plt.show()
