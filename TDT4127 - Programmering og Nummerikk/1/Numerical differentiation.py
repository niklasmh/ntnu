#!/usr/bin/python3

from math import sin, cos

x = float(input('Enter x: '))
h = float(input('Enter step length, h: '))

f1 = sin(x)
f2 = sin(x + h)

svar = (f2 - f1) / h
print('Den deriverte av sin(x) ved x =', x, 'og steglengde', h, 'er', svar)

f3 = cos(x)
diff = svar - f3
print('The difference between the exact value of cos(x) in the point', x, 'and the numerical approximation is', diff,'when h is', h)
