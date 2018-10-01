#!/usr/bin/python3

from math import *

# a)
def f(x):
    return (x - 12)*exp(x*.5) - 8*(x + 2)**2

def g(x):
    return -x - 2*x**2 - 5*x**3 + 6*x**4

print(f(0))
print(g(1))

# b)
def differentiate(x_k, x_k1, func):
    return (func(x_k) - func(x_k1)) / (x_k - x_k1)

print(differentiate(9, 10, f))

#''' c)
def secant_method(x0, x1, func, tol):
    def method(x0, x1, func):
        return x0 - func(x0) / differentiate(x0, x1, func)

    old_x = x0
    new_x = x1
    while abs(new_x - old_x) > tol:
        temp_x = method(old_x, new_x, func)
        old_x = new_x
        new_x = temp_x

    print('Funksjonen nærmer seg et nullpunkt når x = {:.2f}, da er f(x) = {:.2f}'.format(new_x, func(new_x)))
    return new_x

secant_method(11, 13, f, .00001)
secant_method(1, 2, g, .00001)
secant_method(0, 1, g, .00001)
#'''
