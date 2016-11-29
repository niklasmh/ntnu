# Teorioppgaver øving 12
## Oppgave 1:
 - a) **Hvilken kjøretid (asymptotisk) har Floyd-Warshall implementasjon vi finner i Cormen (s. 695)? (4 %)**
  - Θ(V3)Θ(V3)
 - b) **Hvor mye plass bruker Floyd-Warshall algoritmen vi finner i Cormen (s. 695)? (4 %)**
  - Θ(V2)Θ(V2)
 - c) **Kan Floyd-Warshalls algoritme brukes til å finne ut om det finnes negative sykler i en graf? (4 %)**
  - Ja

## Oppgave 2:
 - a) **Hvordan ser D(1)D(1) ut? (4 %)**
  - d)
 - b) **Hvordan ser D(3)D(3) ut? (4 %)**
  - d)
 - c) **Hvordan ser D(5)D(5) ut? (4 %)**
  - d)
 - d) **Hvilken sti vil Floyd-Warshall gi som korteste sti fra node 1 til node 4? (4 %)**
  - 1-2-3-5-4
 - e) **Hva er tolkningen av elementet i rad ii, kolonne jj i matrisen D(5)D(5)? (4 %)**
  - Korteste vei fra i til j som får lov til å gå igjennom node 1, 2, 3, 4 og 5

## Oppgave 3:
 - a) **Gitt algoritmen TRANSITIVE-CLOSURE(GG) på side. 698 i Cormen. Kan vi ved hjelp av denne algoritmen finne ut om en rettet graf er asyklisk? (4 %)**
  - Nei
 - b) **Hvis vi endrer linje 5 i TRANSITIVE-CLOSURE(GG) til:  if  (i,j)  is in G.E: if  (i,j)  is in G.E: Vil det nå være mulig å bruke denne algoritmen for å finne ut om en rettet graf er asyklisk? (4 %)**
  - Ja

## Oppgave 4:
 - a) **En rettet graf uten sykler og uten negative kanter. (8 %)**
  - Dag-Shortest-path, kjørt V ganger
 - b) **Assymptotisk strammeste kjøretid for de(n) raskeste algoritmen(e) i a) er? (4 %)**
  - O(EV+V2)
 - c) **En rettet graf uten sykler og med negative kanter. (8 %)**
  - Dag-Shortest-path, kjørt V ganger
 - d) **Assymptotisk strammeste kjøretid for de(n) raskeste algoritmen(e) i c) er? (4 %)**
  - O(EV+V2)
 - e) **En graf med sykler og uten negative kanter. (8 %)**
  - Ingen er entydig best
 - f) **Assymptotisk strammeste kjøretid for de(n) raskeste algoritmen(e) i e) er? (4 %)**
  - O(V3)
 - g) **En graf med sykler og med negative kanter(men uten negative sykler) (8 %)**
  - Floyd-Warshall
 - h) **Assymptotisk strammeste kjøretid for de(n) raskeste algoritmen(e) i g) er? (4 %)**
  - O(V3)
 - i) **En graf med negative sykler. Her holder det ikke å kun oppdage at det finnes negative sykler (8 %)**
  - Ingen av de nevnte kan løse problemet (uten modifikasjoner)
 - j) **Assymptotisk strammeste kjøretid for de(n) raskeste algoritmen(e) i i) er? (4 %)**
  - Ingen kunne løse problemet
