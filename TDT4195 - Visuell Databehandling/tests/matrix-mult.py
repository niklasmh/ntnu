#!/usr/bin/python3

from sys import argv

if len(argv) < 2:
  print("w h m1 m2")
  exit()

args = list(map(int, argv[1:]))

w = args[0]
h = args[1]

if len(args) < 2 + w + h:
  print("Need more args...")
  exit()

a = args[2:2 + w * h]
b = args[2 + w * h:]

print("Matrix 1:")
print(a)
print()
print("Matrix 2:")
print(b)
print()
print("m1 * m2 =")
m = min(w, h)
for i in range(m**2):
  s = sum([a[w * (i // h) + e] * b[i % h + e * h] for e in range(w)])
  #s = [str(a[w * (i // h) + e])+"*"+str(b[i % h + e * h]) for e in range(w)]
  print(s, end=' ' if (i + 1) % m else '\n')

