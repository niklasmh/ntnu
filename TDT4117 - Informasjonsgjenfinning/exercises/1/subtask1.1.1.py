#!/usr/bin/python3

Winter = 'Winter'
Autumn = 'Autumn'
Spring = 'Spring'

docs = [
    { Winter, Autumn, Spring, Spring },
    { Spring, Autumn },
    { Winter, Winter, Autumn },
    { Autumn, Autumn, Winter, Autumn, Spring, Winter, Spring, Autumn },
    { Winter },
    { Spring, Spring },
    { Winter, Autumn, Spring },
    { Spring, Spring, Autumn,  },
    { Spring, Spring, Winter },
    { Winter, Autumn, Winter, Spring },
]

def l(s): return len(set(s))

queries = [
    { 'f': lambda doc: l(doc & { Spring }) and l(doc & { Autumn }), 'q': "Spring AND Autumn" },
    { 'f': lambda doc: l(doc & { Autumn }) and l(doc & { Winter }), 'q': "Autumn AND Winter" },
    { 'f': lambda doc: l(doc & { Winter }) or l(doc & { Spring }), 'q': "Winter OR Spring" },
    { 'f': lambda doc: l(doc & { Autumn }) and not l(doc & { Spring }), 'q': "Autumn NOT Spring" },
    { 'f': lambda doc: l(doc & { Winter }), 'q': "Winter" }
]

for query in queries:
    print(query['q'])
    for doc in docs:
        print(doc if query['f'](doc) else 'nope')
    print()
