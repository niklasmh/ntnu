# Øving 5

## Oppgave 1

- **Input phase:** Steget hvor man henter in ting man percieves. Dette plasseres så i WM.
- **Operator Selection:** Denne har 2 faser:
  - Elaboration: Først har vi et mål og en aktiv state. Nå må dette utdypes slik at vi kan ta et valg i neste fase. Her vil man først prøve å finne noe lignende fra en Episodic i LTM, siden det er "cached" og løser problemet kjappere. Går ikke det vil den prøve å finne en løsning som finner målet på en ny måte med noen semantiske regler.
  - Decision: Den må nå velge en løsning for å komme videre.
- **Operator Application:**
  - Elaboration: Legger til flere strukturer til den valgte operatoren.
  - Application: Denne fasen vil ikke bli utført før det er full stillhet i systemet. Om den blir utført kan den endre struktur til systemet, eller fjerne struktur. Mellom hver av endringene vil den gå innom elaboration fasen for å sjekke om utfordringer for hver endring. Better safe than sorry!

## Oppgave 2

- a)
  - **Instantiation-support:** Tester ikke den aktive operatoren. Nylige lagde elementer i WM vil også bli fjernet om det blir fjernet et element etter testing av regel **condition**.
  - **Operator-support:** Elementer som er laget av en operator-application regel vil bare bli fjernet om de blir fjernet fra staten eller den blir fjernet av en aksjon fra en regel.
- b)
  - **Impasse** er situasjonen når det ikke er flere operatorer å velge. Da vil programmet heller velge en tilfeldig sub-oppgave slik at man kan komme frem til en løsning på den originale oppgaven.

## Oppgave 3

- a)
  - **Identifikatorer:** S1, L1, R1 ...
  - **Attributter:** name, left-bank, desired ...
  - **Verdier:** 0, 1, wcg ...
- b)
  - DR1 er en identifikator.

## Oppgave 4

På den første kodesnutten lager man en variabel bank med attributtene right-bank og left-bank. Deretter sjekker man om denne variabelen har enten en attributt wolf, goat eller cabbage som er over 0. Skjer dette så:  
-->  
Legger vi til en attributt, operator, som knyttes til en ny identifikator som får navn: move-boat. Denne identifikatoren får så nyttet til attributtene fra bank-variabelen til bank-attributtet. Så får den en cargo variabel med attributt type 1 knyttet til cargo attributtet.

Det over kan tyde på at denne koden vil legge til nye states hvor vi flytter båten til siden hvor det er noe og velger et element fra denne siden slik at lasten blir 1.  
Dette er en **operator proposal**.

På den andre sjekker den først om det finnes en operator attributt med en identifikator kalt move-boat med diverse attributter, hvor attributten, cargo, skal være tom.  
-->  
Stemmer dette, er båten tom og koden skriver ut en newline med "record: alone". Den lager så en ny state som sier noe om forrige state.

Denne kodesnutten sjekker om båten ikke har noe last og kan dermed plukke opp noe.  
Dette er en **state elaboration**.

Den siste vil prøve å matche noe som har feilet. Dette gjør at man kan korrigere og gå tilbake til roten av problemet.
Dette er en **operator evaluation**.

# DISCLAIMER: JEG KAN IKKE SOAR!!!
