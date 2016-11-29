# Teorioppgaver øving 3
## Oppgave 1:
Anta du har en kø Q = <4,7,32,72,3> hvor det bakerste elementet representerer hodet til køen.
 - a) **Hvordan vil køen se ut etter å ha kjørt ENQUEUE(Q,3)? (5 %)**
   - <3,4,7,32,72,3>
 - b) **Hvordan vil køen se ut etter å ha kjørt DEQUEUE(Q)? (5 %)**
   - <4,7,32,72>
 - c) **Hva er det minste antallet ENQUEUE/DEQUEUE-operasjoner du trenger for at køen skal endres til <3,4,7,32,72,3>? (5 %)**
   - 1

## Oppgave 2:
Anta du har en stakk S = <4,7,32,72,3> hvor det bakerste elementet representerer toppen av stakken.
 - a) **Hvordan vil stakken se ut etter å ha kjørt PUSH(S,3)? (5 %)**
   - <4,7,32,72,3,3>
 - b) **Hvordan vil stakken se ut etter å ha kjørt POP(S)? (5 %)**
   - <4,7,32,72>
 - c) **Hva er det minste antallet PUSH/POP-operasjoner du trenger for at stakken skal endres til <3,4,7,32,72,3>? (5 %)**
   - 11

## Oppgave 3:
Anta at du har en sirkulær dobbel lenket liste L = <4,7,32,72,3> hvor HEAD peker på 4-tallet.
 - a) **Hvordan vil listen se ut etter LIST-SEARCH(L,4)? (5 %)**
   - <4,7,32,72,3>
 - b) **Hvordan vil listen se ut etter LIST-INSERT(L,3)? (5 %)**
   - <3,4,7,32,72,3>
 - c) **Hvordan vil listen se ut etter LIST-DELETE(L,4)? (5 %)**
   - <7,32,72,3>
 - d) **Vi ønsker å implementere L som et flerarray av objekter tilsvarende som i Cormen (figur 10.5 s.242). Hvilket av alternativene under for startvariabel L og arrayene N = next, K = key og P = prev er korrekt implementert? (5 %)**
   - L = 7, N = <3,0,4,/,0,1,6,0>, K = <32,0,72,3,0,7,4,0>, P = <6,0,1,3,0,7,/,0>
 - e) **Vi ønsker å implementere L som et array av objekter tilsvarende som i Cormen (figur 10.6 s.243). Hvilket av alternativene under for startvariabel L og array A er korrekt implementert? (5 %)**
   - L = 4 A = <72,13,10,4,7,/,7,10,4,32,1,7,3,/,1>

## Oppgave 4:
 - a) **En god hash-funksjon vil, for en tabell av lengde n, kunne garantere for at k < n innsettinger ikke vil gi kollisjon? (5 %)**
   - Nei
 - b) **Du får oppgitt at x.key = m og h(m) = j der h er en hash-funksjon. Da er... (5 %)**
   - x elementet, m nøkkelen og j hashen.
 - c) **Er h(k) = (k * randint(0,k)) mod m hvor k er nøkkelen og m er størrelsen på hashtabellen en god hashfunksjon? (5 %)**
   - Nei
 - d) **Hva betyr kollisjon (collision) i forbindelse med hash-tabeller? (5 %)**
   - Flere ulike faktiske nøkler gir samme hash-verdi.
 - e) **Hvis vi har en funksjon DELETE(T,x) der T er en kjedet hash-tabell og x er et listenode, så er worst case kjøretiden... (operasjonen Delete(T,x) inkluderer ikke søket som må gjøres før elementet fjernes) (5 %)**
   - O( - n) **for enkel lenket liste og O(1) for dobbel lenket liste.**
 - f) **Hva er worst-case-kjøretiden for innsetting i en hash-tabell om man bruker kjeding ved kollisjoner? Anta at innsettingen også må sjekke om elementet allerede finnes i tabellen. (5 %)**
   - O(n)
 - g) **For å unngå at vi lager for stor initiell hashtabell ønsker vi å doble størrelsen på hashtabellen hver gang lastfaktoren blir ¼ (lastfaktor beregnes N/M hvor N er antall elementer i hashtabellen og M er størrelsen på hashtabellen). Hvis vi benytter amorisert analyse får vi at kjøretiden for innsetting er ... (5 %)**
   - O(1)

## Oppgave 5:
 - a) **Anta du har binærtre G og legger til en ny kant i treet. Du vil nå ha... (5 %)**
   - En syklisk graf.
 - b) **Hvorfor er amortisert analyse bedre enn vanlig worst-case-beregning i mange tilfeller? (5 %)**
   - Worst case kan være altfor pessimistisk.