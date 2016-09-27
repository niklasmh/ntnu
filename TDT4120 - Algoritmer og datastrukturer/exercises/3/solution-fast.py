#!/usr/bin/python3

from sys import stdin
from itertools import repeat

def merge(decks):
    linear = []
    for i in decks:
        linear.extend(i)
    sorted = []
    word = []
    gmin = linear[0]
    for l in linear:
        if l[0] < gmin[0]:
            gmin = l
    min = gmin
    for l in linear:
        for i in linear:
            if i not in sorted:
                min = i
                break
        for i in linear:
            if i not in sorted:
                if i[0] <= min[0]:
                    min = i
        gmin = min
        sorted.append(min)
        word.append(min[1])
    return "".join(word)

def main():
    # Read input.
    decks = []
    for line in stdin:
        (index, csv) = line.strip().split(':')
        deck = list(zip(map(int, csv.split(',')), repeat(index)))
        decks.append(deck)
    # Merge the decks and print result.
    print(merge(decks))

if __name__ == "__main__":
    main()
