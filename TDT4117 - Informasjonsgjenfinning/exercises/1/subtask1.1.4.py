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
    for doc in docs:
        c = doc.count(term)
        tf = find_tf(c)
        tfs[term].append(tf)

ns = {}
for term in terms:
    ns[term] = []
    n = 0
    N = len(docs)
    for doc in docs:
        n += 1 if doc.count(term) else 0

    ns[term] = n

tfidf = {}
for term in terms:
    tfidf[term] = []
    i = 0
    N = len(docs)
    for doc in docs:
        tfidf[term].append(tfs[term][i] * log2(N / ns[term]))
        i += 1

def eq(d1, d2):
    s = 0
    for term in terms:
        s += (tfidf[term][d2 - 1] - tfidf[term][d1 - 1])**2
    return s**.5

print('E.D(5, 1) = {:.3f}'.format(eq(5, 1)))
print('E.D(5, 2) = {:.3f}'.format(eq(5, 2)))
print('E.D(5, 4) = {:.3f}'.format(eq(5, 4)))
print('E.D(5, 10) = {:.3f}'.format(eq(5, 10)))
