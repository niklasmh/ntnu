#!/usr/bin/python3

from sys import stdin

Inf = float(1e3000)

def mst(nm):
    # SKRIV DIN KODE HER


lines = []
for str in stdin:
    lines.append(str)
n = len(lines)
neighbour_matrix = [None] * n
node = 0
for line in lines:
    neighbour_matrix[node] = [Inf] * n
    for k in line.split():
        data = k.split(':')
        neighbour = int(data[0])
        weight = int(data[1])
        neighbour_matrix[node][neighbour] = weight
    node += 1
print (mst(neighbour_matrix))
