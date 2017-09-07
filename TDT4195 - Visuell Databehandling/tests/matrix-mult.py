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
for i in range(len(a)): print(a[i], end=' ' if (i + 1) % w else '\n')
print()
print("Matrix 2:")
for i in range(len(b)): print(a[i], end=' ' if (i + 1) % w else '\n')
print()
print("m1 * m2 =")
m = min(w, h)
m3 = []

for i in range(m**2):
  s = sum([a[w * (i // h) + e] * b[i % h + e * h] for e in range(w)])
  # s = [str(a[w * (i // h) + e])+"*"+str(b[i % h + e * h]) for e in range(w)]
  print(s, end=' ' if (i + 1) % m else '\n')
  m3.append(s)

print()
print(m3)
print(" ".join(map(str, m3)))
