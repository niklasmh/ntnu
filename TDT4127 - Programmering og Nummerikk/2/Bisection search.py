#!/usr/bin/python3


# Functions
def f(x):
    return (x - 1) * (x - 3)

def sign(x):
    return x > 0

def same_sign(x, y):
    return not sign(x) ^ sign(y)

def is_close_to(x, close_to=.01):
    return abs(x) <= close_to


# Bisection
def bisection(function, interval, print_output=True, exit_on_error=True, single_loop=False):
    a = interval[0]
    b = interval[1]
    f1 = function(a)
    f2 = function(b)

    if same_sign(f1, f2):
        if exit_on_error:
            print('Invalid starting interval.')
            exit()
        else:
            return ''

    while not is_close_to(a - b):
        c = (a + b) / 2
        f3 = function(c)

        if same_sign(f3, f1):
            a = c
        else:
            b = c

        f1 = function(a)
        f2 = function(b)
        if single_loop: break

    if print_output:
        print('There is a zero between {} and {}.'.format(a, b))

    return (a + b) / 2


''' a) '' '
answer = float(input('Which number does the method converge to? '))

solution = bisection(f, (-1, 2), print_output=False)
print(answer, solution)
if is_close_to(solution - answer, .1):
    print('Great! Correct answer.')
else:
    print('Wrong.')
exit()
#'''

a = float(input('Lower limit of interval: '))
b = float(input('Upper limit of interval: '))
interval = (a, b)

''' b) '' '
# Sikker på at bisect search skal kunne finne mer enn et nullpunkt?
first_search = bisection(f, (interval[0], interval[1] / 2), print_output=False, exit_on_error=False)
second_search = bisection(f, (interval[1] / 2, interval[1]), print_output=False, exit_on_error=False)
if first_search != '' and second_search != '':
    print('There are two zeroes between {} and {}.'.format(interval[0], interval[1]))
elif first_search == '' and second_search == '':
    print('There is no zero between {} and {}.'.format(interval[0], interval[1]))
else:
    print('There is one zero between {} and {}.'.format(interval[0], interval[1]))
#'''

''' c) '' '
bisection(f, interval, single_loop=True)
#'''

''' d) '''
def g(x):
    return x**2 - 2

bisection(g, interval, single_loop=True)
#'''
