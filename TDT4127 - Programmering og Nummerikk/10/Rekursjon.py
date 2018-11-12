#!/usr/bin/python3

# a)
def recursive_sum(n):
    if n > 0:
        return n + recursive_sum(n - 1)
    else:
        return n
#'''
print(recursive_sum(53))
#'''

# b)
def fakultet(n):
    if n > 1:
        return n * fakultet(n - 1)
    else:
        return n
#'''
print(fakultet(5))
print(fakultet(3))
#'''

# c)
def find_smallest_element(numbers):
    l = len(numbers)
    if l <= 1:
        return numbers[0]
    else:
        if numbers[0] > numbers[l - 1]:
            return find_smallest_element(numbers[1:])
        else:
            return find_smallest_element(numbers[:l-1])
#'''
print(find_smallest_element([1, 2, 4, 5, 5, 3, 2, 6]))
#'''

# d)
def binary_search(numbers, element):
    l = len(numbers)
    mi = l // 2
    me = numbers[mi]
    if l == 1 and numbers[0] == element:
        return 1

    if l <= 1:
        return -float('inf')

    if element > me:
        return mi + binary_search(numbers[mi:], element)
    elif element < me:
        return binary_search(numbers[:mi], element)
    else:
        return mi
#'''
liste = [1, 4, 6, 9, 13, 34, 45, 53, 65, 78]
print(binary_search(liste, 13)) # = 4
print(binary_search(liste, 53)) # = 7
print(binary_search(liste, 10)) # = -inf
print(binary_search(liste, 80)) # = -inf
#'''

# e)
import time
from turtle import *

pensize(2)
pencolor("orange")
bgcolor("green")
fillcolor("blue")
hideturtle()

def halfPetal():
    forward(50)
    left(30)
    forward(75)
    left(30)
    forward(50)
    left(120)

def petal():
    for i in range(2):
        halfPetal()

def flower(num, i=1):
    if i == 1:
        begin_fill()
    left(360 / num)
    petal()
    if i < num:
        flower(12, i + 1)
    if i == 1:
        end_fill()

flower(12)
time.sleep(1)
