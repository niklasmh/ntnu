__author__ = 'Niklas'
# -*- coding: utf-8 -*-

# a)


def multipliser(tol=.00001):
    i = 1
    new = 2
    diff = 2
    while diff > tol:
        i += 1
        old = new
        new *= (1 + 1/i**2)
        diff = abs(new - old)
    return new

print(multipliser())
