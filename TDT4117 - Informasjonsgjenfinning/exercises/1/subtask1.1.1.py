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
    { Spring, Spring, Autumn },
    { Spring, Spring, Winter },
    { Winter, Autumn, Winter, Spring },
]

def l(s): return len(set(s))

queries = [
    { 'f': lambda d: Spring in d and Autumn in d, 'q': 'Spring AND Autumn' },
    { 'f': lambda d: Autumn in d and Winter in d, 'q': 'Autumn AND Winter' },
    { 'f': lambda d: Winter in d or Spring in d, 'q': 'Winter OR Spring' },
    { 'f': lambda d: Autumn in d and not Spring in d, 'q': 'Autumn NOT Spring' },
    { 'f': lambda d: Winter in d, 'q': 'Winter' }
]

for query in queries:
    print(query['q'])
    for doc in docs:
        print('1' if query['f'](doc) else '-', end='')
    print()
