#!/usr/bin/python3

from sys import argv

#''' a)
def divisable(x, y):
    return x % y == 0
#'''

#''' b)
def isPrime(a):
    for i in range(2, a):
        if divisable(a, i):
            return False
    return True

if len(argv) <= 1:
    print(isPrime(11))
    print(isPrime(15))
#'''

#''' c)
def isPrime2(a):
    if a < 2: return False
    if a == 2: return True
    if divisable(a, 2): return False
    for i in range(3, round(a**.5 + .5) + 1, 2):
        if divisable(a, i):
            return False
    return True

if len(argv) > 1:
    print(isPrime2(int(argv[1])))
else:
    for i in range(100):
        print(i) if isPrime2(i) else ''

#'''
