#!/usr/bin/python3

from sys import stdin

class Kubbe:
    vekt = None
    neste = None
    def __init__(self, vekt):
        self.vekt = vekt
        self.neste = None

def spor(kubbe):
    vekt = kubbe.vekt
    while kubbe.neste is not None:
        kubbe = kubbe.neste
        vekt = kubbe.vekt if kubbe.vekt > vekt else vekt
    return vekt

# Oppretter lenket liste
forste = None
siste = None
for linje in stdin:
    forrige_siste = siste
    siste = Kubbe(int(linje))
    if forste == None:
        forste = siste
    else:
        forrige_siste.neste = siste

# Kaller loesningsfunksjonen og skriver ut resultatet
print(spor(forste))
