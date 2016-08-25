__author__ = 'Niklas'
# -*- coding: utf-8 -*-


typer = [1, 5, 10, 20]
typer = typer[::-1]
print(typer)

# a)

mynter = [5, 1, 5, 10, 20, 5, 1]


def countCoins(coins):
    countobj = {}
    for t in typer:
        countobj[str(t)] = 0

    for c in coins:
        countobj[str(c)] += 1

    return countobj

cc = countCoins(mynter)

print('enere: ' + str(cc['1']), 'femmere: ' + str(cc['5']), 'tiere: ' + str(cc['10']), 'tjuekroner: ' + str(cc['20']), sep="\n")

# b)

liste = [12, 23, 34, 45, 56, 67, 78, 89, 90, 98, 87, 65, 54, 43, 21]


def numCoins(lst):
    newlst = []

    for l in lst:
        summ = l

        countobj = {}
        for t in typer:
            countobj[str(t)] = 0

        while summ > 0:
            for t in typer:
                if summ >= t:
                    summ -= t
                    countobj[str(t)] += 1
        newlst.append(countobj)
    return newlst

print(numCoins(liste))


def sumCoins(lst):
    newlst = []
    for l in lst:
        summ = 0
        for t in typer:
            summ += t*l[str(t)]
        newlst.append(summ)

    return newlst

print(liste)
print(sumCoins(numCoins(liste)))


# c)

vekt = [9.9, 6.8, 7.85, 4.35]


def totVekt(lst):
    summ = 0
    for l in lst:
        for t in typer:
            summ += t*l[str(t)]*vekt[t]
    return summ

print(totVekt(liste))
