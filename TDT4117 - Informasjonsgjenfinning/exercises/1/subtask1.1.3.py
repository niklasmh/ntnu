#!/usr/bin/python3

from math import log2

Winter = 'Winter'
Autumn = 'Autumn'
Spring = 'Spring'

docs = [
    [ Winter, Autumn, Spring, Spring ],
    [ Spring, Autumn ],
    [ Winter, Winter, Autumn ],
    [ Autumn, Autumn, Winter, Autumn, Spring, Winter, Spring, Autumn ],
    [ Winter ],
    [ Spring, Spring ],
    [ Winter, Autumn, Spring ],
    [ Spring, Spring, Autumn ],
    [ Spring, Spring, Winter ],
    [ Winter, Autumn, Winter, Spring ],
]

def find_tf(f):
    return 0 if f <= 0 else (1 + log2(f))

terms = [ Winter, Autumn, Spring ]

for term in terms:
    print(term)
    for doc in docs:
        c = doc.count(term)
        tf = find_tf(c)
        print(c, end=' ')
        print(tf if c else '-')
    print()
