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

tfs = {}
for term in terms:
    tfs[term] = []
    print(term)
    for doc in docs:
        c = doc.count(term)
        tf = find_tf(c)
        tfs[term].append(tf)
        print(c, end=' ')
        print(tf if c else '-')
    print()

ns = {}
for term in terms:
    ns[term] = []
    print(term)
    n = 0
    N = len(docs)
    for doc in docs:
        n += 1 if doc.count(term) else 0

    ns[term] = n

    print('n idf')
    print(n, end=' ')
    print(log2(N/n))
    print()

print('Document-term-matrix:')
for term in terms:
    print(term)
    i = 0
    N = len(docs)
    for doc in docs:
        print('{:.2f}'.format(tfs[term][i], N, ns[term], tfs[term][i] * log2(N / ns[term])), end=' ')
        i += 1
    print()
