#!/usr/bin/python3

# a)
def f(x, t):
    return -10 * x + 4 * t

# b)
def explicitEuler(x_0, h, N):
    result = []
    x = x_0
    result.append(x)
    for j in range(N):
        x = x + h*f(x, j*h)
        result.append(x)
    return result

# c)
def df(x, t, h = .00001):
    return (f(x, t) - f(x - h, t)) / h

def newtons(x, t):
    return x - f(x, t) / df(x, t)

def implicitEuler(x_0, h, N):
    result = []
    x = x_0
    result.append(x)
    for j in range(N):
        x = newtons(x, (j + 1)*h)
        result.append(x)
    return result

# d)
import matplotlib.pyplot as plt

'''
N = 40
#'''
#'''
N = 100
#'''

h = 10 / N
x_0 = 0
plt.xlabel('t')

'''
result = explicitEuler(x_0, h, N)
x_axis = [x * h for x in range(len(result))]
plt.title('N = {}, explicit Euler'.format(N))
plt.plot(x_axis, result)
plt.show()
#'''
#'''
result = implicitEuler(x_0, h, N)
x_axis = [x * h for x in range(len(result))]
plt.title('N = {}, implicit Euler'.format(N))
plt.plot(x_axis, result)
plt.show()
#'''
