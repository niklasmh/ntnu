# Teorioppgaver øving 9
## Oppgave 1:
 - a) **Gitt at |V|=|E||V|=|E|. Hvordan kan grafen GG lagres mest plasseffektivt i denne situasjonen? (7.1 %)**
  - Nabolister
 - b) **Gitt to noder, u,v∈Vu,v∈V. Hvor lang tid vil det ta å sjekke om det finnes en kant, e∈Ee∈E, som går fra uu til vv gitt at grafen GG er representert ved hjelp nabolister?Anta at du ikke vet noe om hvor mange kanter eller hvor mange noder det finnes i GG. (7.1 %)**
  - O(|V|)O(|V|)
 - c) **Hvor lang tid vil tilsvarende oppslag ta hvis GG var representert ved hjelp av en nabomatrise? (7.1 %)**
  - O(1)O(1)

## Oppgave 2:
 - a) **Hvilke av følgende alternativ må holde for at et bredde-først-søk skal kunne finne korteste vei fra en node til alle andre? Anta at vi har en sammenhengende graf. (7.1 %)**
  - Alle kantene har lik vekt
 - b) **Et bredde-først-søk implementeres vanligvis ved hjelp av en kø (queue)? (7.1 %)**
  - Sant
 - c) **Et dypde-først-søk kan brukes til å klassifisere kantene i en graf. Hvilken av følgende kanttyper betegner en kant som går fra en forgjenger (ancestor) til en etterkommer (descendant)? (7.1 %)**
  - Tree edge
 - d) **Hver gang vi kommer til en node i et dypde-først-søk som allerede er farget svart vet vi at kanten vi brukte for å komme oss hit må være en cross edge. (7.1 %)**
  - Usant

## Oppgave 3:
 - a) **Hvilken av seksvensene tilsvarer et bredde-først-søk? (7.1 %)**
  - 2
 - b) **Hvilken av sekvensene tilsvarer et dypde-først-søk? (7.1 %)**
  - 3
 - c) **Hvilken klassifikasjon vil kanten mellom node P og O få ved et dybde-først-søk? (7.1 %)**
  - Back edge
 - d) **Hvilken klassifikasjon vil kanten mellom node O og Y få ved et dybde-først-søk? (7.1 %)**
  - Tree edge
 - e) **Hvilken klassifikasjon vil kanten mellom node I og P få ved et dybde-først-søk? (7.1 %)**
  - Back edge

## Oppgave 4:
 - a) **Hvilke av følgende alternativ er en gyldig topologisk sortering av grafen? (7.1 %)**
  - A, E, D, C, I, H, B, F, G
 - b) **Du ønsker å lage en topologisk sortering av en graf G=(V,E)G=(V,E). Hvilke av følgende kriterier må være sanne (for grafen GG) for at det skal finnes en topologisk sortering? (7.1 %)**
  - Den må være rettet og asyklisk (en DAG)
