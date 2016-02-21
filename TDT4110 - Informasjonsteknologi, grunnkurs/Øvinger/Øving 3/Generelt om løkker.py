__author__ = 'Niklas'
# -*- coding: utf-8 -*-

fra = 0
til = 100

# Vi kan både bruke en formel og en teller for å legge sammen tallene

# Denne summerer med en formel, denne er såklart kjappest:
summer = (til-fra+1)*(fra + til)/2
print(summer)

summer = 0

for i in range(fra, til+1):
    summer += i

print(summer)

# Oppgave b)

i = 0
summer = 1
while summer <= 1000:
    i += 1
    summer *= i

print("\nb)\n", summer)

# Oppgave c)

name = input("\nMy name is?\n")

while name.lower() != "slim shady":
    name = input("My name is?\n")

print("That's right!")
