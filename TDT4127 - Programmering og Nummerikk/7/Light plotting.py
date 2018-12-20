#!/usr/bin/python3

# a)
def argList(N, a, b):
    h = (b - a) / N
    return list(map(lambda j: a + j*h, range(N + 1)))

'''
print(argList(10, 0, 1))
#'''

# b)
from math import exp, cos, pi
def f(x):
    func = lambda x: exp(x)*cos(50*pi*x)
    return list(map(func, x))

#''' c)
import matplotlib.pyplot as plt
xaxis = argList(500, 0, 1)
plt.plot(xaxis, f(xaxis))
plt.title('N = 500')
plt.xlabel('x')
plt.ylabel('f(x)')
plt.show()
#'''

#''' d)
import matplotlib.pyplot as plt
xaxis = argList(51, 0, 1)
plt.plot(xaxis, f(xaxis))
plt.title('N = 500')
plt.xlabel('x')
plt.ylabel('f(x)')
plt.show()
#'''

#''' e)
import matplotlib.pyplot as plt

xaxis = argList(500, 0, 1)
plt.plot(xaxis, f(xaxis))

xaxis = argList(51, 0, 1)
plt.plot(xaxis, f(xaxis), 'ro')

plt.title('N = 500')
plt.xlabel('x')
plt.ylabel('f(x)')
plt.show()
#'''
