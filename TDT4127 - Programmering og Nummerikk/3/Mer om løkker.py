#!/usr/bin/python3

#''' a) Summere heltall
summ = 0
for i in range(7):
    heltall = int(input('Skriv inn et heltall: '))
    summ += heltall
print('Summen av tallene ble', summ)
#'''

#''' b) Summere 1, 2, 3, ..., sum < 1000
produkt = 1
index = 1
while produkt <= 1000:
    index += 1
    produkt *= index
print('Produkt over 1000 =>', produkt)
#'''

#''' c) Spørreloop
attempts = 1
answer = input('Hva er hovedstaden i Norge? ')
while answer.lower() != 'oslo':
    attempts += 1
    print('Det var feil, prøv igjen.')
    answer = input('Hva er hovedstaden i Norge? ')
print('Korrekt!! Du brukte', attempts, 'forsøk.')
#'''
