__author__ = 'Niklas'
# -*- coding: utf-8 -*-

from collections import Counter
import re

filename = 'the_holy_bible.txt'

# a)


def readfile():
    return open(filename, 'r').read()

# b)


def removespecialchars(txt):
    return re.sub(r'[^a-zA-Z\s]', '', txt)

# c)


def countwords(txt):
    return Counter(txt.lower().split())

# d)


def main():
    c = countwords(removespecialchars(readfile())).most_common()
    for i in range(len(c)):
        print('%d\t%s' % (c[i][1], c[i][0]))

main()