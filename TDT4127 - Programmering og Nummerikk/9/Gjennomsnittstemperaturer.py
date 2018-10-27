#!/usr/bin/python3

''' a)
f = open('Månedlig gjennomsnittstemperatur.txt', 'r')
print(f.read())
#'''

# b)
def get_lists(file):
    f = open(file)
    f.readline()
    yearly = list(map(float, f.readline()[1:-2].split(',')))
    f.readline()
    trondheim = list(map(float, f.readline()[1:-2].split(',')))
    f.readline()
    mars = list(map(float, f.readline()[1:-2].split(',')))
    return (yearly, trondheim, mars)

'''
print(get_lists('Månedlig gjennomsnittstemperatur.txt'))
#'''

# c)
def get_min_max(file):
    lists = get_lists(file)
    min_val = max_val = lists[0][0]
    for l in lists:
        min_val = min(min(l), min_val)
        max_val = max(max(l), max_val)
    return (min_val, max_val)

'''
print(get_min_max('Månedlig gjennomsnittstemperatur.txt'))
#'''

import matplotlib.pyplot as plt
''' d)
def make_graph(file):
    lists = get_lists(file)
    [min_val, max_val] = get_min_max(file)
    x_axis = lists[0]
    plt.plot(x_axis, lists[1])
    plt.plot(x_axis, lists[2])
    plt.axis([1, lists[0][-1], min_val - 1, max_val + 1])
    plt.show()

make_graph('Månedlig gjennomsnittstemperatur.txt')
#'''

# e)
def make_graph(file, x_name, y_name, list1_name, list2_name):
    lists = get_lists(file)
    [min_val, max_val] = get_min_max(file)
    x_axis = lists[0]
    plt.plot(x_axis, lists[1], label=list1_name)
    plt.plot(x_axis, lists[2], label=list2_name)
    plt.xlabel(x_name)
    plt.ylabel(y_name)
    plt.legend()
    plt.axis([1, lists[0][-1], min_val - 1, max_val + 1])
    plt.show()
#'''
make_graph('Månedlig gjennomsnittstemperatur.txt', 'Måned (jan-des)', 'Gjennomsnittstemperatur i °C', 'Trondheim', 'Gale Crater (Mars)')
#'''
