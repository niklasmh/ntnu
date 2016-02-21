__author__ = 'Niklas'
# -*- coding: utf-8 -*-

# a)

count = 0

with open("numbers.txt", "r") as f:
    for line in f:
        count += 1
        print(line[:-1])

print("Antall linjer:", count)

# b)

tall = []

with open("numbers.txt", "r") as f:
    for line in f:
        tall += line.split()

# c)

maks = 0
for i, t in enumerate(tall):
    maks = int(t) if int(t) > maks else maks

for i in range(maks+1):
    antall = tall.count(str(i))
    if antall > 0:
        print(str(i) + ":", antall)
