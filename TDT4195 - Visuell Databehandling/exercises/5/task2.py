#!/usr/bin/python3

import numpy as np
import matplotlib.pyplot as plt
import imageio
import math

# Read in image
filepath = "images/fishingboat.tiff"
img = imageio.imread(filepath)

# Calculate high and low pass filter(gauss)
gauss5 = [
  [1, 4, 6, 4, 1],
  [4, 16, 24, 16, 4],
  [6, 24, 36, 24, 6],
  [4, 16, 24, 16, 4],
  [1, 4, 6, 4, 1]
]

lowpass = gauss5 / np.sum(gauss5)

highpass = lowpass * -1
highpass[2][2] += 1

def freqFilter(image, kernel):
    # Change image to freq domain shift center and make values easier to see
    fimage = np.fft.fft2(image)
    fimage = np.fft.fftshift(fimage)
    fimageShow = np.log(1 + np.abs(fimage))

    # Pad kernel with zeros
    kernel_zeros = np.zeros(image.shape)
    kernel_zeros[:kernel.shape[0], :kernel.shape[1]] = kernel

    # Change kernel to freq domain and do all that
    fkernel = np.fft.fft2(kernel_zeros)
    fkernel = np.fft.fftshift(fkernel)
    fkernelShow = np.log(1+ np.abs(fkernel))

    # Apply the filter
    newf = np.multiply(fimage, fkernel)
    newfShow = np.log(1+ np.abs(newf))

    # Change back to spatial domain
    newImage = np.fft.ifft2(newf)
    newImage = np.abs(newImage)

    return fimageShow, fkernelShow, newfShow, newImage

fimageShow, fkernelShow, newfShow, newImage = freqFilter(img, lowpass)

_, ax = plt.subplots(1, 5, figsize=(20, 6))
ax[0].imshow(img, cmap=plt.cm.gray)
ax[0].set_axis_off()
ax[1].imshow(fimageShow, cmap=plt.cm.gray)
ax[1].set_axis_off()
ax[2].imshow(fkernelShow, cmap=plt.cm.gray)
ax[2].set_axis_off()
ax[3].imshow(newfShow, cmap=plt.cm.gray)
ax[3].set_axis_off()
ax[4].imshow(newImage, cmap=plt.cm.gray)
ax[4].set_axis_off()
plt.show()
