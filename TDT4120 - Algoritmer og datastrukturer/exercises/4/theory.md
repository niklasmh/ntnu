# Teorioppgaver øving 4
## Oppgave 1:
Denne oppgaven handler om sorteringsalgoritmer.
 - a) **Vi har en usortert liste med nn elementer, og vi ønsker å finne ut om alle elementene i listen er unike. Etter algoritmene vi har lært så langt, hva er raskeste kjøretiden vi kan få når vi løser denne oppgaven? (5 %)**
   - Θ(nlog(n))Θ(nlog⁡(n))
 - b) **Vi ønsker å sortere en liste med lavest mulig minneforbruk. Hvilken algoritme er best? (5 %)**
   - Heapsort
 - c) **Vi oppnår worst-case tid for quicksort hvis listen allerede er sortert. (5 %)**
   - Sant
 - d) **Quicksort forbruker O(1)O(1) ekstra minne i tillegg til det minnet som trengs for å lagre tallene som skal sorteres. (5 %)**
   - Usant
 - e) **All input kan gi worst-case kjøretid for randomized-quicksort. (5 %)**
   - Sant

## Oppgave 2:
Denne oppgaven tar for seg substitusjonsmetoden for å løse rekurrenser.

Gitt rekurrensen:

*T(n)=2401T(n/7)+n3*

*T(1)=1*

Dersom vi skulle benyttet oss av substitusjonsmetoden og antatt at:

*T(n/2)≤c⋅n24⋅log⁡(n/2)*
 - a) **Hva håper vi på å kunne bevise? (5 %)**
   - At T(n)≤c⋅n2⋅log(n)T(n)≤c⋅n2⋅log⁡(n)
 - b) **Hvis du anvender master-teoremet på denne rekurrensen, hvilket tilfelle tilhører den? (5 %)**
   - Case 1
 - c) **Hva blir kjøretiden? (Du kan velge fremgangsmåte selv) (5 %)**
   - Θ(n4)Θ(n4)
 - d) **Hvis vi bytter ut n3n3 med n5n5, hvilket case får vi hvis vi vil bruke masterteoremet? (5 %)**
   - Case 3

## Oppgave 3:
Løs denne oppgaven ved hjelp av variabelskifte. Husk at *n^½=sqrt(n)*.
 - a) **Løs rekurrensen gitt ved: T(n)=T(n12)+1T(n)=T(n12)+1 (5 %)**
   - Θ(lglgn)Θ(lg⁡lg⁡n)

## Oppgave 4:
Løs denne oppgaven ved hjelp av rekursjonstrær.
 - a) **Vi har en rekurrens T(n)=T(n/3)+T(n/2)+nT(n)=T(n/3)+T(n/2)+n, T(1)=1T(1)=1. Hva er høyden til rekursjonstreet? (10 %)**
   - Θ(log(n))Θ(log⁡(n))

## Oppgave 5:
Denne oppgaven handler om kjøretidsanalyse.
 - a)
Funksjonen gjørNoe() har kjøretid Θ(1).

```
 def f1(i):
  gjørNoe()
  if i <= 1:
    return
  f1(i // 2)
  f2(i - 2)

def f2(i):
  gjørNoe()
  if i <= 1:
    return
  f1(i // 2)
```
Hva er kjøretiden til f1(n)? (Tips: Ikke prøv å regne det ut nøyaktig.)

(10 %)
   - Θ(n)Θ(n)

## Oppgave 6:
 - a)
```
def funksjon1(n):
  if n > 0:
    funksjon1(n-42)
    funksjon1(42)
  gjørNoe(42)
```
Hva er kjøretiden til funksjonen hvis gjørNoe(n) har kjøretid Θ(n)?

(10 %)
   - Den vil aldri stoppe.
 - b)
```
def funksjon2(n):
  gjørNoe(n)
  if n >= 1:
    funksjon2(n//3)
    funksjon2(2n//3)
```
Hva er kjøretiden hvis gjørNoe(n) har kjøretid Θ(n)?

(10 %)
   - O(nlogn)O(nlog⁡n)
 - c)
```
def funksjon3(n):
  gjørNoe(n//6)
  if n > 0:
    funksjon3(n/2-2)
    funksjon3(n/2-3)
```
Hva blir kjøretiden hvis gjørNoe(n) har kjøretid Θ(n)?

(10 %)
   - O(nlogn)O(nlog⁡n)"
