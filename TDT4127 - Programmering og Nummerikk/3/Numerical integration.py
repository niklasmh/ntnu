#!/usr/bin/python3

# Imports
import math

# Functions
def f(x):
    return math.exp(x**2)

def midpoint_rule(function, a, b, intervals):
    solution = 0
    h = (b - a) / intervals
    for k in range(intervals):
        midpoint = a + k*h + h*.5
        solution += f(midpoint)
    return solution * h

def simpsons_rule(function, a, b, intervals):
    solution = f(a)
    h = (b - a) / (intervals * 2)
    for k in range(1, intervals * 2):
        x = a + k*h
        if k % 2:
            solution += 4 * f(x)
        else:
            solution += 2 * f(x)
    solution += f(b)
    return solution * h / 3

# Common inputs
a = int(input('Enter starting point a: '))
b = int(input('Enter stopping point b: '))
intervals = int(input('Enter number of intervals N: '))

''' a) Midpoint rule
solution = midpoint_rule(f, a, b, intervals)
answer = 'The integral from {} to {} using {} intervals is {}'.format(a, b, intervals, solution)
print(answer)
#'''

''' b) Simpson's rule
solution = simpsons_rule(f, a, b, intervals)
answer = 'The integral from {} to {} using {} intervals is {}'.format(a, b, intervals, solution)
print(answer)
#'''

#''' c) Error between midpoint and simpson's rule
correct = 1.462651745907181
error_m = abs(midpoint_rule(f, a, b, intervals) - correct)
error_s = abs(simpsons_rule(f, a, b, intervals) - correct)
answer_m = 'The integration error using the midpoint method with {} intervals is {}'.format(intervals, error_m)
print(answer_m)
answer_s = 'The integration error using Simpson\'s method with {} intervals is {}'.format(intervals, error_s)
print(answer_s)
#'''
