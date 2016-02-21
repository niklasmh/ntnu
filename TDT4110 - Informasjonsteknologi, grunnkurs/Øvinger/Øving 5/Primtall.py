__author__ = 'Niklas'
# -*- coding: utf-8 -*-

n = int(input("Hvor mange tall vil du sjekke?\n"))
primtall = [2]


def is_primtall(tall, lst):
    for i in lst:
        if tall % i == 0:
            return False
    primtall.append(tall)
    print(tall, end=", ")
    return True

for p in range(2, n):
    is_primtall(p, primtall)

# print(primtall)
"""
print(primtall[0])
for p in primtall[1:]:
    print(p)
"""

"""
def write():
    print('Creating new text file')

    name = 'primtall.txt'

    try:
        file = open(name, 'w')
        file.write(str(primtall[0]))
        for p in primtall[1:]:
            file.write(", " + str(p))
        file.close()
        print("Task completed")
    except:
        print('Something went wrong. Maybe the file was open?')

write()"""
