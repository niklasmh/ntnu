#!/usr/bin/python3

import numpy as np
import matplotlib.pyplot as plt
import imageio
import math

# Read in image
filepath = "images/fishingboat.tiff"
filepath = "images/5.1.10-aerial.tiff"
img = imageio.imread(filepath)

# Normal filter, returning the original image
I = np.array([
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0],
  [0, 0, 1, 0, 0],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0]
])

# Gaussian filter
gauss5 = np.array([
  [1, 4, 6, 4, 1],
  [4, 16, 24, 16, 4],
  [6, 24, 36, 24, 6],
  [4, 16, 24, 16, 4],
  [1, 4, 6, 4, 1]
])
gauss5 = gauss5 / np.sum(gauss5)

def unsharpMasking(image, smoothing, k):
    # Change image to freq domain shift center and make values easier to see
    fimage = np.fft.fft2(image)
    fimage = np.fft.fftshift(fimage)
    fimageShow = np.log(1 + np.abs(fimage))

    # Manipulate the kernel like in formula 4.9-13 from the bok
    unsharp_kernel = I + k * (I - smoothing)

    # Pad kernel with zeros
    kernel_zeros = np.zeros(image.shape)
    kernel_zeros[:unsharp_kernel.shape[0], :unsharp_kernel.shape[1]] = unsharp_kernel

    # Change kernel to freq domain and do all that
    fkernel = np.fft.fft2(kernel_zeros)
    fkernel = np.fft.fftshift(fkernel)
    fkernelShow = np.log(1 + np.abs(fkernel))

    # Apply the filter
    newf = np.multiply(fimage, fkernel)
    newfShow = np.log(1 + np.abs(newf))

    # Change back to spatial domain
    newImage = np.fft.ifft2(newf)
    newImage = np.abs(newImage)

    return fimageShow, fkernelShow, newfShow, newImage

# Set the amount of sharpning. Should be between [0, 1]
k = .5

fimageShow, fkernelShow, newfShow, newImage = unsharpMasking(img, gauss5, k)

_, ax = plt.subplots(1, 5, figsize=(30, 10))
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
