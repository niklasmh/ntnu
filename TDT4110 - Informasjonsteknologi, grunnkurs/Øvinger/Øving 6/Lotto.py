__author__ = 'Niklas'
# -*- coding: utf-8 -*-

from random import shuffle
from random import randint

# a)

numbers = list(range(1, 35))


# b)

# myGuess = []
# for i in range(1, 8):
#     myGuess.append(int(input("\nTall " + str(i) + ":\n")))
#
# print("Dine tall:", myGuess)

# c)

# Nå skal lista bli tilfeldig
shuffle(numbers)


# d)


def compList(lst1, lst2):
    newlst = []

    for i, e in enumerate(lst1):
        for j in lst2:
            if e == j:
                newlst.append(e)
    return newlst  # Her ligger også antallet


def premie(fasit, minetall):
    rette = compList(numbers[1:8], myGuess)
    tillegg = compList(numbers[8:12], myGuess)

    antallrette = len(rette)
    tilleggstall = len(tillegg)

    if antallrette == 7:
        premien = 2749455
    elif antallrette == 6 and tilleggstall == 1:
        premien = 102110
    elif antallrette == 6:
        premien = 3385
    elif antallrette == 5:
        premien = 95
    elif antallrette == 4 and tilleggstall == 1:
        premien = 45
    else:
        premien = 0
    return {"premien": premien, "rette": rette, "tillegg": tillegg}


# f)

# print(premie(numbers, myGuess))


# g)

cash = 0
gang = 0
ganger = 100000
# Denne kjører veldig lenge
ganger = 1000000

for i in range(ganger):
    cash -= 5
    gang += 1
    shuffle(numbers)
    myGuess = [randint(1, 34) for j in range(1, 8)]
    cash += premie(numbers, myGuess)["premien"]

print("Du vil ligge", abs(cash), "på underskudd" if cash < 0 else "på overskudd", "etter", gang, "ganger.")