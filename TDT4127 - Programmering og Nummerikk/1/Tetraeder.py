#!/usr/bin/python3

h = float(input('Skriv inn en høyde: '))
a = 3 / 6**.5 * h

areal = 3**.5 * a**2
print('Et tetraeder med høyde', h, 'har areal', areal)

volum = (2**.5 * a**3) / 12
print('Et tetraeder med høyde', h, 'har volum', volum)
