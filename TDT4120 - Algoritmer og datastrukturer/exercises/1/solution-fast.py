#!/usr/bin/python3

from sys import stdin

class Kubbe:
    vekt = None
    neste = None
    def __init__(self, vekt):
        self.vekt = vekt
        self.neste = None

def spor(kubbe):
    vekt = kubbe[0]
    while kubbe[1] is not None:
        kubbe = kubbe[1]
        if kubbe[0] > vekt:
            vekt = kubbe[0]
    return vekt

# Oppretter lenket liste
forste = None
siste = None
forrige_vekt = 0
forrige_neste = None
init = True
for linje in stdin:
    if init:
        forrige_vekt = int(linje)
        forrige_neste = None
        init = False
    else:
        forrige_neste = siste
        siste = (
            forrige_vekt,
            forrige_neste
        )
        forrige_vekt = int(linje)
siste = (
    forrige_vekt,
    siste
)

# Kaller loesningsfunksjonen og skriver ut resultatet
print(spor(siste))
