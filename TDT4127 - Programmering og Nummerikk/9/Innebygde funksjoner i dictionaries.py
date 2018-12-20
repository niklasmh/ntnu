#!/usr/bin/python3

''' a)
i. [88, 92, 100]
ii. 100
'''

# b)
fruit = {
    'epler': 1,
    'pærer': 2,
    'appelsiner': 3
}

# c)
fruit['bananer'] = 0
fruit['kiwier'] = 0
del fruit['epler']
del fruit['pærer']
del fruit['appelsiner']

# d)
print(fruit['bananer'])
print(fruit['kiwier'])

# e)
print(fruit)
if 'bananer' in fruit:
    del fruit['bananer']
print(fruit)

# f)
fruit = {
    'epler': 1,
    'pærer': 2,
    'appelsiner': 3
}
for navn, antall in fruit.items():
    print(navn, antall)
