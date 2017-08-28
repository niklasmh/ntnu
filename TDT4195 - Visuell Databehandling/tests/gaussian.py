#!/usr/bin/python3

from math import e, pi
from sys import argv

def N(x, o):
  return 1 / (o**2 * (2*pi)**.5) * e**(-x**2 / (2 * o))

if len(argv) < 3:
  print("args needed: amount omega scale")
  exit()

amount = int(argv[1])
omega = int(argv[2])
scale = int(argv[3])

summ = 0

for i in range(-amount // 2, amount // 2 + 1):
  elem = N(i, omega)
  summ += elem
  print("*" * int(elem * scale))

print("Sum: " + str(summ))

