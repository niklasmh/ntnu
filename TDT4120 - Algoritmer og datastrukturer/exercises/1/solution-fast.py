#!/usr/bin/python3

from sys import stdin

# Rekursivt forsok
def spor_rec (k, vekt):
    if k[0] > vekt:
        vekt = k[0]
        print(vekt)
    return spor_rec(k[1], vekt) if k[1] is not None else vekt

# Lineaert forsok
def spor_lin(kubbe):
    vekt = kubbe[0]
    try:
        while True:
            kubbe = kubbe[1]
            if kubbe[0] > vekt: vekt = kubbe[0]
    except:
        return vekt

# Oppretter lenket liste
siste = None
for linje in map(int, stdin):
    siste = (linje, siste)

# Kaller loesningsfunksjonen og skriver ut resultatet
#print(spor_rec(siste, siste[0]))
print(spor_lin(siste))
