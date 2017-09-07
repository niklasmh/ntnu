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
s = max(len(str(min(a + b))), len(str(max(a + b))))
def fs (n): return ('' if n < 0 else ' ') + str(n) + ' '*(s + (0 if n < 0 else -1) - len(str(n)))

print("Matrix 1:")
s = max(len(str(min(a))), len(str(max(a))))
for i in range(len(a)): print(fs(a[i]), end=' ' if (i + 1) % w else '\n')
print()
print("Matrix 2:")
s = max(len(str(min(b))), len(str(max(b))))
for i in range(len(b)): print(fs(b[i]), end=' ' if (i + 1) % w else '\n')
print()
print("m1 * m2 =")
m = min(w, h)
m3 = []

for i in range(m**2):
  p = sum([a[w * (i // h) + e] * b[i % h + e * h] for e in range(w)])
  # p = [str(a[w * (i // h) + e])+"*"+str(b[i % h + e * h]) for e in range(w)]
  m3.append(p)

s = max(len(str(min(m3))), len(str(max(m3))))
for i in range(m**2):
  print(fs(m3[i]), end=' ' if (i + 1) % m else '\n')

print()
print(m3)
print(" ".join(map(str, m3)))
