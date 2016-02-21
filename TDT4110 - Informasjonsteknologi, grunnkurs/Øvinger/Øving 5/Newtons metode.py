__author__ = 'Niklas'
# -*- coding: utf-8 -*-


import math

e = math.e
serieon = True
# serieon = False


def f(x):
    return (x - 12)*e**(5*x) - 8*(x + 2)**2


def g(x):
    return -x - 2*x**2 - 5*x**3 + 6*x**4


def j(x):
    return 6*x**7 + 4 + math.sinh(2*x)


def k(x):
    return 2 - 2*x + math.sin(x)


def l(x):
    return x**4 - 4*x - 2


def derivert(x, function=f, h=.001):
    return (function(x + h/2) - function(x - h/2))/h


def newtonsmetode(function=f, start=1, tol=.00000000001):
    i = 0
    ans = start
    while i < 100:
        if serieon:
            print(ans, "\t\t", function(ans))
        i += 1
        ans -= function(ans)/derivert(ans, function)

        if abs(function(ans)) < tol:
            break
    return ans


print(newtonsmetode(f, 13), "er ca. svaret på f")
print(newtonsmetode(g, 1), "er ca. svaret på g\n\n")
print(newtonsmetode(j, -1), "er ca. svaret på j")
print(newtonsmetode(k, 1), "er ca. svaret på k")

print(newtonsmetode(l, 2), "er ca. svaret på l")
