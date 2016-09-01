# Velkommen til TDT4120 - Algoritmer og datastrukturer
Her er alle mine øvinger og noen av notatene mine fra faget.

## Forelesningsplan

### Forelesning 1 - Problemer og algoritmer
 - [x] Kunne definere problem, instans og problemstørrelse
 - [x] Forstå løkkeinvarianter og naturlig induksjon
 - [x] Forstå bokas pseudokode-konvensjoner
 - [x] Kjenne egenskapene til random-access machine-modellen
 - [x] Forstå Insertion-Sort
 - [x] Kunne definere best-case, average-case og worst-case
    - 
 - [x] Forstå ideen bak divide-or-conquer
 - [x] Forstå Merge-Sort
 - [x] Kunne definere asymptotisk notasjon, O, Ω, Θ, o og ω.
    - Huskeregel:
        - ω >
        - Ω >=
        - Θ =
        - O <=
        - o <
    - Kompleksitetsregler
        - 1
        - n
        - n^k
        - ...
        - 1 < ln(n) < n < n^2 < 2^n < n! < n^n

### Forelesning 2 - Datastrukturer
 - [ ] Forstå hvordan stakker og køer fungerer
 - [ ] Forstå hvordan lenkede lister fungerer
 - [ ] Forstå hvordan pekere og objekter kan implementeres
 - [ ] Forstå hvordan rotfaste trær kan implementeres
 - [ ] Forstå hvordan direkte adressering og hashtabeller fungerer
 - [ ] Forstå konfliktløsing ved kjeding (chaining)
 - [ ] Kjenne til grunnleggende hashfunksjoner
 - [ ] Vite at man for statiske datasett kan ha worst-case O(1) for søk
 - [ ] Kunne definere amortisert analyse
 - [ ] Forstå hvordan dynamiske tabeller fungerer 

### Forelesning 3 - Splitt og hersk
 - [ ] Forstå strukturell induksjon∗
 - [ ] Forstå designmetoden divide-and-conquer (splitt og hersk)
 - [ ] Kunne løse rekurrenser med substitusjon, rekursjonstrær og masterteoremet
 - [ ] Forstå hvordan variabelskifte fungerer
 - [ ] Forstå Quicksort og Randomized-Quicksort
 - [ ] Forstå binærsøk

### Forelesning 4 - Rangering i lineær tid
 - [ ] Forstå hvorfor sammenligningsbasert sortering har en worst-case på Ω(n lg n)
 - [ ] Vite hva en stabil sorteringsalgoritme er
 - [ ] Forstå Counting-Sort, og hvorfor den er stabil
 - [ ] Forstå Radix-Sort, og hvorfor den trenger en stabil subrutine
 - [ ] Forstå Bucket-Sort
 - [ ] Forstå Randomized-Select
 - [ ] Forstå Select

### Forelesning 5 - Rotfaste trestrukturer
 - [ ] Forstå hvordan heaps fungerer, og hvordan de kan brukes som prioritetskøer
 - [ ] Forstå Heapsort
 - [ ] Forstå hvordan binære søketrær fungerer
 - [ ] Forstå flere ulike operasjoner på binære søketrær, ut over bare søk
 - [ ] Vite at forventet høyde for et tilfeldig binært søketre er Θ(lg n)
 - [ ] Vite at det finnes søketrær med garantert høyde på Θ(lg n) 

### Forelesning 6 - Dynamisk programmering
 - [ ] Forstå ideen om en delproblemrelasjon eller delproblemgraf
 - [ ] Forstå induksjon over velfunderte relasjoner ∗
 - [ ] Forstå designmetoden dynamisk programmering
 - [ ] Forstå løsning ved memoisering (top-down)
 - [ ] Forstå løsning ved iterasjon (bottom-up)
 - [ ] Forstå hvordan man rekonstruerer en løsning fra lagrede beslutninger
 - [ ] Forstå hva optimal delstruktur er
 - [ ] Forstå hva overlappende delproblemer er
 - [ ] Vite forskjellen på et segment og en underfølge (subsequence)
 - [ ] Forstå eksemplene stavkutting, matrisekjede-multiplikasjon og LCS
 - [ ] Forstå løsningen på 0-1-ryggsekkproblemet

### Forelesning 7 - Grådige algoritmer
 - [ ] Forstå designmetoden grådighet
 - [ ] Forstå grådighetsegenskapen (the greedy-choice property)
 - [ ] Forstå eksemplene aktivitet-utvelgelse og det fraksjonelle ryggsekkproblemet
 - [ ] Forstå Huffman og Huffman-koder
 - [ ] Forstå bevismetoden bevis ved fortrinn (exchange arguments) ∗
 - [ ] Forstå bevismetoden bevis ved forsprang (staying ahead) ∗

### Forelesning 8 - Traversering av grafer
 - [ ] Forstå hvordan grafer kan implementeres
 - [ ] Forstå BFS, også for å finne korteste vei uten vekter
 - [ ] Forstå DFS og parentesteoremet
 - [ ] Forstå hvordan DFS klassifiserer kanter
 - [ ] Forstå Topological-Sort
 - [ ] Forstå hvordan DFS kan implementeres med en stakk ∗
 - [ ] Forstå hva traverseringstrær (som bredde-først- og dybde-først-trær) er
 - [ ] Forstå traversering med vilkårlig prioritetskø ∗ 

### Forelesning 9 - Minimale spenntrær
 - [ ] Forstå skog-implementasjonen av disjunkte mengder
 - [ ] Vite hva spenntrær og minimale spenntrær er
 - [ ] Forstå Generic-MST
 - [ ] Forstå hvorfor lette kanter er trygge kanter
 - [ ] Forstå MST-Kruskal
 - [ ] Forstå MST-Prim 

### Forelesning 10 - Korteste vei fra én til alle
 - [ ] Forstå ulike varianter av korteste-vei- eller korteste-sti-problemet
 - [ ] Forstå strukturen til korteste-vei-problemet
 - [ ] Forstå at negative sykler gir mening for korteste enkle vei (simple path) ∗
 - [ ] Forstå at korteste enkle vei er ekvivalent med lengste enkle vei ∗
 - [ ] Forstå hvordan man kan representere et korteste-vei-tre
 - [ ] Forstå kant-slakking (edge relaxation) og Relax
 - [ ] Forstå ulike egenskaper ved korteste veier og slakking
 - [ ] Forstå Bellman-Ford
 - [ ] Forstå Dag-Shortest-Path
 - [ ] Forstå kobling mellom Dag-Shortest-Path og dynamisk programmering∗
 - [ ] Forstå Dijkstra 

### Forelesning 11 - Korteste vei fra alle til alle
 - [ ] Forstå forgjengerstrukturen for alle-til-alle-varianten av korteste vei-problemet
 - [ ] Forstå Floyd-Warshall
 - [ ] Forstå Transitive-Closure

### Forelesning 12 - Maksimal flyt
 - [ ] Kunne definere flytnettverk, flyt og maks-flyt-problemet
 - [ ] Kunne håndtere antiparallelle kanter og flere kilder og sluk
 - [ ] Kunne definere residualnettverket til et nettverk med en gitt flyt
 - [ ] Forstå hvordan man kan oppheve (cancel) flyt
 - [ ] Forstå hva en forøkende sti (augmenting path) er
 - [ ] Forstå hva snitt, snitt-kapasitet og minimalt snitt er
 - [ ] Forstå maks-flyt/min-snitt-teoremet
 - [ ] Forstå Ford-Fulkerson
 - [ ] Vite at Ford-Fulkerson med BFS kalles Edmonds-Karp-algoritmen
 - [ ] Forstå hvordan maks-flyt kan finne en maksimum bipartitt matching
 - [ ] Forstå heltallsteoremet

### Forelesning 13 - NP-kompletthet
 - [ ] Forstå sammenhengen mellom optimerings- og beslutnings-problemer
 - [ ] Forstå koding (encoding) av en instans
 - [ ] Forstå hvorfor løsningen vår på 0-1-ryggsekkproblemet ikke er polynomisk
 - [ ] Forstå forskjellen på konkrete og abstrakte problemer
 - [ ] Forstå representasjonen av beslutningsproblemer som formelle språk
 - [ ] Forstå definisjonen av klassen P
 - [ ] Forstå definisjonen av klassene NP og co-NP
 - [ ] Forstå redusibilitets-relasjonen ≤P
 - [ ] Forstå definisjonen av NP-hardhet og NP-kompletthet
 - [ ] Forstå den konvensjonelle hypotesen om forholdet mellom P, NP og NPC
 - [ ] Forstå hvorfor CIRCUIT-SAT er NP-komplett 

### Forelesning 14 - NP-komplette problemer
 - [ ] Forstå hvordan NP-kompletthet kan bevises ved ´en reduksjon
 - [ ] Kjenne de NP-komplette problemene CIRCUIT-SAT, SAT, 3-CNF-SAT, CLIQUE, VERTEX-COVER, HAM-CYCLE, TSP og SUBSET-SUM
 - [ ] Forstå NP-kompletthetsbevisene for disse problemene
 - [ ] Forstå at 0-1-ryggsekkproblemet er NP-hardt
 - [ ] Forstå at lengste enkle-vei-problemet er NP-hardt
 - [ ] Være i stand til å konstruere enkle NP-kompletthetsbevis 

## Appendix A
 - [x] Setningslogikk
    - And, or, not
 - [x] Predikatslogikk
    - Forhold mellom de induviduelle x, y, x... og kvantifikatorene "for alle x" og "det eksisterer en x"
 - [x] Inferensregler
    - Introduksjon og eliminasjon
    - Formelle systemer
        - Regler
            - | P | Q | 
            - | 0 | 0 | 
            - | 0 | 1 | 
            - | 1 | 0 | 
            - | 1 | 1 | 
        - Implikasjon P ⇒ Q
        - Modus Ponens P ⇒ Q, P | Q
        - P ⇒ Q
        - P^- vs. ¬P
        - P ⇒ Q ≡ ¬Q ⇒ ¬P
        - P ⇒ Q, Q ⇒ P | P ⇔ Q
        - P ⇔ Q | P ⇒ Q, Q ⇒ P
        - P ⇔ Q ⇔ R ≡ P ⇒ Q ⇒ R ⇒ P
    - Negasjon, Reductio ad Absurdum
        - Q, ¬Q | ⊥
    - Andre bevis for at P eller Q er sant
        - P, Q | P  ∧ Q
        - P  ∧ Q | P, Q
    - Proof by Cases
        - P | P ∨ Q
        - P ∨ Q, P...R, Q...R | R
    - Annet bevis for eller
        - P ∨ Q ≡ ¬P ⇒ Q
    - Kvantifikatorer
        - Alle
            - P(a) | ∀xP(x)
            - ∀xP(x) | P(a)
        - Element
            - P(a) | ∃xP(x)
            - ∃xP(x) | P(y)
        - E!xP(x):
            - xP(x)  ∀x∀y((P(x) ∧ P(y)) ⇒ x = y)