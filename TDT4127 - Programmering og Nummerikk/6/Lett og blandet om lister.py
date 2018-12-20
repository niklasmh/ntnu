#!/usr/bin/python3

# a)
def is_six_at_edge(liste):
    return liste[0] == 6 or liste[-1] == 6

print(is_six_at_edge([1, 2, 3, 4, 5, 6]))
print(is_six_at_edge([1, 2, 3, 4, 5, 6, 7]))

# b)
def average(liste):
    return sum(liste) / len(liste)

print(average([1, 3, 5, 7, 9, 11]))

# c)
def median(liste):
    liste.sort()
    return liste[len(liste) // 2]

print(median([1, 2, 4, 5, 7, 9, 10]))
print(median([1, 4, 2, 5, 3]))
