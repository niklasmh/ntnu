__author__ = 'Niklas'
# -*- coding: utf-8 -*-


s = 1
r = False
i = 0
while True:
    i+=1
    r = True
    for j in range(2, 21):
        if i % j != 0:
            r = False
            break
    if r:
        print(i, "nice ;)")
        break
