__author__ = 'Niklas'
# -*- coding: utf-8 -*-


def ducci(lst):
    while True:
        print(lst)
        oldlst = lst[:]
        newlst = lst[:]
        for i, c in enumerate(lst[:-1]):
            newlst[i] = abs(lst[i]-lst[i+1])
        newlst[-1] = abs(lst[-1]-lst[0])
        lst = newlst
        if oldlst == lst:
            break
    return lst


# print(ducci([10, 8, 12, 15, 5, 7, 43, 21]))
# print(ducci([1, 5, 7, 9, 9]))
print(ducci([1, 2, 1, 2, 1, 0]))
