__author__ = 'Niklas'
# -*- coding: utf-8 -*-


def is_p(num):
    return str(num) == str(num)[::-1]

s = 0
for i in range(1000):
    for j in range(1000):
        print(i, j)
        if is_p(i*j):
            s = i*j if i*j > s else s

print(s)
