__author__ = 'Niklas'
# -*- coding: utf-8 -*-

# a)

def bubbleSort(lst):
    done = False
    while not done:
        done = True
        for i in range(0, len(lst)-1):
            if lst[i] > lst[i+1]:
                lst[i], lst[i+1] = lst[i+1], lst[i]
                done = False
    return lst

print(bubbleSort([1, 2, 3, 4, 5]))
print(bubbleSort([5, 4, 3, 2, 1]))


# b)

def selectionSort(lst):
    newlst = []
    oldmax, pos = 0, 0
    for k, l in enumerate(lst):
        max = 0
        for i, j in enumerate(lst):
            if j > max and (j <= oldmax or k == 0):
                max = j
                pos = i
        lst[pos] = max + 1
        oldmax = max
        newlst.append(max)
    return newlst

print(selectionSort([1, 2, 3, 4, 5]))
print(selectionSort([5, 4, 3, 2, 1]))
print(selectionSort([10, 4, 8, 1, 0, 1]))


# c) Jeg vil si siste pga den kjører garantert flere prosesser.
# Den første kan brukte kortere tid.
