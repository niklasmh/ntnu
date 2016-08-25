__author__ = 'Niklas'
# -*- coding: utf-8 -*-

num = input("Skriv inn et positivt heltall:\n")

while not num.isdigit():
    num = input("Skriv inn et positivt heltall:\n")

n = int(num)
ledd = 1
summ = 1
rekke = "1^2"

for i in range(2, n+1):
    if summ+i**2 * (-1 if i % 2 == 0 else 1) > n:
        break
    rekke += (" - " if i % 2 == 0 else " + ") + str(i) + "^2"
    summ += i**2 * (-1 if i % 2 == 0 else 1)
    ledd += 1

print("Hvis n =", n,
      "blir resultatet", rekke,
      "=", summ,
      "og antall ledd " + str(ledd) + ".")
print("Det som skrives ut er da:\nResultat med n = %d: %d" % (n, summ))
print("Antall ledd:", ledd)
