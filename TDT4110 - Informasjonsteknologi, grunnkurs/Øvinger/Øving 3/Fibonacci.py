__author__ = 'Niklas'
# -*- coding: utf-8 -*-

import random

liste = []
for i in range(1, 10):
    liste.append(random.randint(100))


def delelig(a, b):
    return a % b == 0


def deleligmax(tall):
    divisjon = int(tall/2)
    while divisjon > 0:
        if divisjon % tall == 0:
            break
        divisjon -= 1
    return divisjon


def deleligmaxiliste(liste):
    maxliste = []
    for l in liste:
        maxliste.append(deleligmax(l))
    return maxliste

print(deleligmaxiliste(liste))

