#!/usr/bin/python3

from sys import argv

if len(argv) <= 1:
  print("Args: range point point point ...")

m = int(argv[1])

a = []
for arg in argv[2:]:
  a.append(int(arg))

def hist(a, n):
 arr,acc=[],0
 for i in range(m):
   s = len([c for c in a if c == i])
   acc += s
   arr.append(acc/n*m)
 newa = [list(map(round,arr))[i] for i in a]
 return newa

print(hist(a, len(a)))

