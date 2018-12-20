#!/usr/bin/python3

# a)
def f(x):
    return -x - 2*x**2 - 5*x**3 + 6*x**4

# b)
def f_derivative(x):
    return -1 - 4*x - 15*x**2 + 24*x**3

# c)
def Newton_method(x, epsilon):
    method = lambda x: x - f(x) / f_derivative(x)
    old_x = x
    new_x = method(x)
    while abs(old_x - new_x) > epsilon:
        temp_x = method(new_x)
        old_x = new_x
        new_x = temp_x

    return new_x

print(Newton_method(2, .1))
print(Newton_method(2, .0001))
print(Newton_method(2, 1e-10))
