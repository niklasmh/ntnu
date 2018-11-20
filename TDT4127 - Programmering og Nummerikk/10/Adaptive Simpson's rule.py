#!/usr/bin/python3
import math

# a)
def simpsons_method(f, a, b):
    h = (b - a) / 2
    c = (a + b) / 2
    return (h/3) * (f(a) + 4*f(c) + f(b))
'''
def f(x):
    return math.log(x)
print(simpsons_method(f,1,2))
#'''

# b)
def recursive(f, a, b, epsilon):
    whole = simpsons_method(f, a, b)
    c = (a + b) / 2
    left = simpsons_method(f, a, c)
    right = simpsons_method(f, c, b)
    if abs(left + right - whole) > 15 * epsilon:
        return recursive(f, a, c, epsilon / 2) + recursive(f, c, b, epsilon / 2)
    else:
        return (16 * (left + right) - whole) / 15
#'''
def f(x):
    return math.log(x)
print(recursive(f, 1 , 2, 0.00001))
#'''
