#!/usr/bin/python3

'''
Oppgave D:

1. Hva er det laveste antall hidden-noder som gir et godt resultat?

- Det varierer veldig på hvilken vekter man starter med. Det hender at resultatet har blitt
  produsert med en feil på under +/- 0.5 i error med 1 skjult node. Det er derimot mye
  større sannsynlighet for at den feiler på færre skjulte lag. 8 skjulte noder kan også
  gi et dårlig resultat.

2. Hva er det det nevrale nettet har gjenskapt gjennom hidden-laget for å produsere et bra
resultat med dette minste antallet noder i hidden-laget?

- Den har nå klart å lage en tilpasset representasjon av dataene basert på å justere vektene
  ved hjelp av en form for regresjon med funksjonen tanh.

3. Aktiver nettverket med tall du ikke har trent med, som desimaltall, negative tall og tall
over 8. Kommenter hvor godt nettverket håndterer disse nye input-dataene.

- Om man går over 8-10 i alle input, resulterer det i tall i et mindre definisjonsområde.
  Bruker man tall fra 0-1 vil man klare seg fint, selv med 1 node. Dette kan være et resultat
  av at funksjonen ikke klarer å tilpasses tanh, som vi bruker i dette tilfellet.
  Prøver man odde antall, får man også veldig feile resultater fordi de går mot veldig høye
  og veldig lave verdier.

'''

from pybrain.tools.shortcuts import buildNetwork
from pybrain.structure import TanhLayer
from pybrain.datasets import SupervisedDataSet
from pybrain.supervised.trainers import BackpropTrainer

net = buildNetwork(2, 8, 1, bias=True, hiddenclass=TanhLayer)

ds = SupervisedDataSet(2, 1)
ds.addSample((1), (1,))
ds.addSample((2), (2,))
ds.addSample((3), (3,))
ds.addSample((4), (4,))
ds.addSample((5), (5,))
ds.addSample((6), (6,))
ds.addSample((7), (7,))
ds.addSample((8), (8,))

trainer = BackpropTrainer(net, ds)

trainer.trainUntilConvergence(verbose=False, validationProportion=0.15, maxEpochs=1000, continueEpochs=10)

res = net.activateOnDataset(ds)

d = 0
p = 0
for i, r in enumerate(res):
  d = r[0] - p
  p = r[0]
  print("{}: {} => {} {}".format(ds['input'][i][0], ds['input'][i][1], r[0], round(ds['input'][i][1] - r[0])))
