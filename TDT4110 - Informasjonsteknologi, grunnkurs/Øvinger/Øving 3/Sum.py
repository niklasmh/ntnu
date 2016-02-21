__author__ = 'Niklas'
# -*- coding: utf-8 -*-

import math

num = input("Skriv inn et positivt heltall:\n")

while not num.isdigit():
    num = input("Skriv inn et positivt heltall:\n")

n = int(num)
summ = 0

for i in range(1, n+1):
    summ += 1/i**2

print(summ)

# Oppgave b
tol = .0000000001
summ = math.pi**2/6
print("Summen skal nærme seg:", summ)
x = summ
i = 0
summ = 0

while tol < x:
    i += 1
    diff = summ
    summ += 1/i**2
    x = summ - diff

print("Summen ble:", summ)
