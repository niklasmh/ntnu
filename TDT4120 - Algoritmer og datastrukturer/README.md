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
      <pre>
      ω >
      Ω ≧
      Θ =
      O ≦
      o <
      </pre>
    - Kompleksitetsregler:
      <pre>
      1
      n
      nᵏ
      ...
      1 < ln(n) < n < n² < 2ⁿ < n! < nⁿ
      </pre>

### Forelesning 2 - Datastrukturer
 - [x] Forstå hvordan stakker og køer fungerer
 - [x] Forstå hvordan lenkede lister fungerer
 - [x] Forstå hvordan pekere og objekter kan implementeres
 - [x] Forstå hvordan rotfaste trær kan implementeres
 - [x] Forstå hvordan direkte adressering og hashtabeller fungerer
 - [x] Forstå konfliktløsing ved kjeding (chaining)
 - [x] Kjenne til grunnleggende hashfunksjoner
 - [x] Vite at man for statiske datasett kan ha worst-case O(1) for søk
 - [x] Kunne definere amortisert analyse
 - [x] Forstå hvordan dynamiske tabeller fungerer 

### Forelesning 3 - Splitt og hersk
 - [x] Forstå strukturell induksjon∗
   - `+ 2`
   - `+ 2 x 2`
   - `+ ...`
   - `+ 2 x ... x 2`
   - `= 2 x ... x 2 x 2 - 2`
   - `+ 2 x ... x 2 x 2`
   - **`= 2 x ... x 2 x 2 - 2`**
   - `sum^ln(n)_{i=1} 2^i = 2n - 1`
 - [x] Forstå designmetoden divide-and-conquer (splitt og hersk)
   - `len(2 x 2 x 2 x ... x 2) = m`
   - `lg(2 x 2 x 2 x ... x 2) = m`
   - `lg(3 x 3 x 3 x ... x 3) = m`
   - `lg(k x k x k x ... x k) = m`
 - [x] Kunne løse rekurrenser med substitusjon, rekursjonstrær og masterteoremet
   - `f(x) = 1 + f(x)`
   - `[f(x)] = [1 + [f(x)]]`
   - `[f(x)] = [1 + [1 + [f(x)]]]`
   - `[f(x)] = [1 + [1 + [1 + [...]]]]`
   - `f(x) = 1 + f(x - 1)`
   - `[f(x)] = [1 + f(x - 1)]`
   - `[f(x)] = [1 + f(x - 1)]`
 - [x] Forstå hvordan variabelskifte fungerer
 - [x] Forstå Quicksort og Randomized-Quicksort
   - Quicksort starter på siste element.
   - Randomized starter på et tilfeldig element.
   - Worst case er ferdig sortert. O(n²).
 - [x] Forstå binærsøk
   1. Sortèr utvalget.
   2. Dele i 2.
   3. Velg den biten som inneholder søket.
   4. Fortsett punkt 2 og 3 til elementet er funnet.
 - Notater:
   - Merge sort:
     <pre>
     Merge(A, p, q, r)
       1 Copier L til R
       2 <b>for</b> k = p <b>til</b> r
       3       <b>if</b> L[i] <= R[j]
       4             A[k] = L[i]
       5             i++
       6       <b>else</b> A[k] = R[j]
       7            j++
       </pre>
   - Litt grunnleggende:
     - `log(x^(log(y))) = log(y^(log(x)))`
     - `2^log₃(n) = n^log₃(2)`

### Forelesning 4 - Rangering i lineær tid
 - [x] Forstå hvorfor sammenligningsbasert sortering har en worst-case på Ω(n lg n)
 - [x] Vite hva en stabil sorteringsalgoritme er
 - [x] Forstå Counting-Sort, og hvorfor den er stabil
 - [x] Forstå Radix-Sort, og hvorfor den trenger en stabil subrutine
 - [x] Forstå Bucket-Sort
 - [x] Forstå Randomized-Select
 - [x] Forstå Select
   - Notater:
     <pre>
     Rekursjon:

     <b>Time:</b>
     1 if n > 1
     2     t = Time(n - 1)
     3     return t + n
     4 else return 1

     Iterativ:

     <b>Rec-Ins-Sort:</b>
     1 if j > 1
     2     Rec-Ins-Sort(A, j - 1)
     3     key = A[j]
     4     i = j - 1
     5     while i > 0 and A[i] > key
     6         A[i + 1] = A[i]
     7         i--
     8     A[i + 1] = key
     </pre>

### Forelesning 5 - Rotfaste trestrukturer
 - [x] Forstå hvordan heaps fungerer, og hvordan de kan brukes som prioritetskøer
 - [x] Forstå Heapsort
 - [x] Forstå hvordan binære søketrær fungerer
     <pre>
     Successor(x)
     1 if x.right != NIL
     2     return Min(x.right)
     3 y = x.p
     4 while y != NIL and x == y.right
     5     x = y
     6     y = y.p
     7     return y
     </pre>
 - [x] Forstå flere ulike operasjoner på binære søketrær, ut over bare søk
   - Insetting
     <pre>
     Insert(T, z)
     1 y = NIL
     2 x = T.root
     3 <b>while</b> x != NIL
     4     y = x
     5     <b>if</b> z.key < x.key
     6         x = x.left
     7     <b>else</b> x = x.right
     8 z.p = y
     9 <b>if</b> y == NIL
     10    T.root = z
     11 <b>else if</b> z.key < y.key
     12    y.left = z
     13 <b>else</b> y.right = z
     </pre>
   - Transplant - brukes i ved sletting
   - <pre>
     Transplant(T, u, v)
     1 <b>if</b> u.p == NIL
     2     T.root = v
     3 <b>elseif</b> u == u.p.left
     4     u.p.left = v
     5 <b>else</b> u.p.right = v
     6 <b>if</b> v != NIL
     7     v.p = u.p
     </pre>
   - Sletting
   - <pre>
     Delete(T,z)
     1 <b>if</b> z.left == NIL
     2     Transp(T, z, z.right)
     3 <b>elseif</b> z.right == NIL
     4     Transp(T, z, z.left)
     5 <b>else</b> y = Minimum(z.right)
     6     <b>if</b> y.p != z
     7         Transp(T, y, y.right)
     8         y.right = z.right
     9         y.right.p = y
     10    Transp(T, z, y)
     11    y.left = z.left
     12    y.left.p = y
     </pre>
 - [x] Vite at forventet høyde for et tilfeldig binært søketre er Θ(lg n)
 - [x] Vite at det finnes søketrær med garantert høyde på Θ(lg n)
 - Kjøretider for binære søketre:
   <pre>
   <b>Algoritme</b>          <b>Kjøretid</b>
   Inorder-Tree-Walk  Θ(n)
   Tree-Search        O(n)
   Tree-Minimum       O(n)
   Tree-Successor     O(n)
   Tree-Insert        O(n)
   Tree-Delete        O(n)
   </pre>
### Forelesning 6 - Dynamisk programmering
 - [x] Forstå ideen om en delproblemrelasjon eller delproblemgraf
 - [x] Forstå induksjon over velfunderte relasjoner ∗
 - [x] Forstå designmetoden dynamisk programmering
   - Hva er <b>DP</b>?
     - Karakterisere strukturen ...
     - Rekursivt definere verdi ...
     - Kalkuler verdi ...
     - Konstruktør ...
   - Oppskrift, <b>Sniedivich</b>
     1. Embed your problem in a family of related problems
     2. Derive a relationship between the solutions to these problems
     3. Solve this relationship
     4. Recover a solution to your problem from this relationship
 - [x] Forstå løsning ved memoisering (top-down)
   - Nyttig når vi har overlappende løsninger.
   - Korrekt når vi har optimal substruktur.
 - [x] Forstå løsning ved iterasjon (bottom-up)
 - [x] Forstå hvordan man rekonstruerer en løsning fra lagrede beslutninger
 - [x] Forstå hva optimal delstruktur er
 - [x] Forstå hva overlappende delproblemer er
 - [x] Vite forskjellen på et segment og en underfølge (subsequence)
 - [x] Forstå eksemplene stavkutting, matrisekjede-multiplikasjon og LCS
   - Stavkutting. Denne er eksponentiell:
   - <pre>
     Cut(p, n)
     1 if n == 0
     2     return 0
     3 q = -∞
     4 <b>for</b> i = 1 to n
     5     t = p[i] + Cut(p, n - i)
     6     q = max(q, t)
     7 <b>return</b> q

     q, t = -∞, - > 6.6 > -, -
     </pre>
   - En annen metode med 2 prosedyrer som er kvadratisk O(n²):
     <pre>
     Memoized-Cut-Rod(p, n)
     1 let r[0 ..n] be a new array
     2 <b>for</b> i = 0 to n
     3  r[i] = -∞
     4 <b>return</b> Aux(p, n, r)
     </pre>
   - Selve prosedyren:
     <pre>
     Aux(p, n, r)
     1 <b>if</b> r[n] ≥ 0
     2     <b>return</b> r[n]
     3 <b>if</b> n == 0
     4     q = 0
     5 <b>else</b> q = -∞
     6     <b>for</b> i = 1 <b>to</b> n
     7         t = p[i] + Aux(p, n - i, r)
     8         q = max(q, t)
     9 r[n] = q
     10 <b>return</b> q
     </pre>
   - <b>LCS</b>
     - Mye brukt i bioinformatikk.
     - Eksempel 1:
       <pre>
       1 klapper takpapp
       2 kapp akpapp
       3 kapp kapp
       </pre>
     - Eksempel 2:
       <pre>
       1234567 1234567`
       klapper takpapp
       </pre>
     - Endelig eksempel:
       <pre>
       . . . . . | s t o r m k a s t
       . . . . 0 | 1 2 3 4 5 6 7 8 9
       . ---------------------------
       . | 0 | 0 | 0 0 0 0 0 0 0 0 0
       . ---------------------------
       a | 1 | 0 | 0 0 0 0 0 0 1 1 1
       t | 2 | 0 | 0 <b>1</b> 1 1 1 1 1 1 2
       o | 3 | 0 | 0 1 <b>2</b> 2 2 2 2 2 2
       m | 4 | 0 | 0 1 2 2 <b>3</b> 3 3 3 3
       m | 5 | 0 | 0 1 2 2 3 3 3 3 3
       a | 6 | 0 | 0 1 2 2 3 3 <b>4</b> 4 4
       k | 7 | 0 | 0 1 2 2 3 4 4 4 4
       t | 8 | 0 | 0 1 2 2 3 4 4 4 <b>5</b>
       </pre>
     - Observasjon 1:
       <pre>
       . . . . . | s t o r m k a s t
       . . . . 0 | 1 2 3 4 5 6 7 8 9
       . ---------------------------
       . | 0 | 0 | 0 0 0 0 0 0 0 0 0
       . ---------------------------
       a | 1 | 0 | ⇑ ↑ ↑ ↑ ↑ ↑ ↑ ← ←
       t | 2 | 0 | ↑ ⇖ ← ← ← ← ↑ ↑ ↖
       o | 3 | 0 | ↑ ↑ ⇖ ⇐ ← ← ← ← ↑
       m | 4 | 0 | ↑ ↑ ↑ ↑ ⇖ ⇐ ← ← ←
       m | 5 | 0 | ↑ ↑ ↑ ↑ ↖ ⇑ ↑ ↑ ↑
       a | 6 | 0 | ↑ ↑ ↑ ↑ ↑ ↑ ⇖ ⇐ ←
       k | 7 | 0 | ↑ ↑ ↑ ↑ ↑ ↖ ↑ ⇑ ↑
       t | 8 | 0 | ↑ ↖ ↑ ↑ ↑ ↑ ↑ ↑ ⇖
       </pre>
     - Observasjon 2:
       <pre>
       . . . . . | s <b>t</b> <b>o</b> r <b>m</b> k <b>a</b> s <b>t</b>
       . . . . 0 | 1 2 3 4 5 6 7 8 9
       . ---------------------------
       . | 0 | 0 | 0 0 0 0 0 0 0 0 0
       . ---------------------------
       a | 1 | 0 | ↑ ↑ ↑ ↑ ↑ ↑ ↑ ← ←
       <b>t</b> | 2 | 0 | ↑ ⇖ ← ← ← ← ↑ ↑ ↖
       <b>o</b> | 3 | 0 | ↑ ↑ ⇖ ← ← ← ← ← ↑
       <b>m</b> | 4 | 0 | ↑ ↑ ↑ ↑ ⇖ ← ← ← ←
       m | 5 | 0 | ↑ ↑ ↑ ↑ ↖ ↑ ↑ ↑ ↑
       <b>a</b> | 6 | 0 | ↑ ↑ ↑ ↑ ↑ ↑ ⇖ ← ←
       k | 7 | 0 | ↑ ↑ ↑ ↑ ↑ ↖ ↑ ↑ ↑
       <b>t</b> | 8 | 0 | ↑ ↖ ↑ ↑ ↑ ↑ ↑ ↑ ⇖
       </pre>
 - [x] Forstå løsningen på 0-1-ryggsekkproblemet

### Forelesning 7 - Grådige algoritmer
 - [x] Forstå designmetoden grådighet
 - [x] Forstå grådighetsegenskapen (the greedy-choice property)
 - [x] Forstå eksemplene aktivitet-utvelgelse og det fraksjonelle ryggsekkproblemet
 - [x] Forstå Huffman og Huffman-koder
   - `abbabcad` i bits
     - `a=000, b=001, c=01, d=1`
     - `000 001 001 000 001 01 001 1 (uten mellomrom)`
     - Prefix hindrer lesing fra å kunne kombineres med andre tegn.
 - [x] Forstå bevismetoden bevis ved fortrinn (exchange arguments) ∗
 - [x] Forstå bevismetoden bevis ved forsprang (staying ahead) ∗
 - Notater:
   - Aktivitetsutvalg (tabell), start på første slutt (her: 0-**2**):
     <pre>
     0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16
     |←-----→| . | . | . | . | . | . | . | . | . | . | . | . | . | . |
     | . |←-------------→| . | . | . | . | . | . | . | . | . | . | . |
     | . | . | . | . |←---------→| . | . | . | . | . | . | . | . | . |
     |←-----------------------------→| . | . | . | . | . | . | . | . |
     | . | . | . | . | . |←-------------→| . | . | . | . | . | . | . |
     | . | . | . | . | . | . | . | . |←-----→| . | . | . | . | . | . |
     | . | . | . | . | . | . | . | . | . |←-----→| . | . | . | . | . |
     | . | . | . | . | . | . | . | . | . | . | . |←---------→| . | . |
     | . | . | . | . | . | . | . | . | . | . | . | . | . |←---------→|
     </pre>
   - Aktivitetsutvalg (etter algoritme):
     <pre>
     0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16
     |███████| . | . | . | . | . | . | . | . | . | . | . | . | . | . |
     | . |←------x------→| . | . | . | . | . | . | . | . | . | . | . |
     | . | . | . | . |███████████| . | . | . | . | . | . | . | . | . |
     |←--------------x--------------→| . | . | . | . | . | . | . | . |
     | . | . | . | . | . |←------x------→| . | . | . | . | . | . | . |
     | . | . | . | . | . | . | . | . |███████| . | . | . | . | . | . |
     | . | . | . | . | . | . | . | . | . |←--x--→| . | . | . | . | . |
     | . | . | . | . | . | . | . | . | . | . | . |███████████| . | . |
     | . | . | . | . | . | . | . | . | . | . | . | . | . |←----x----→|
     </pre>
   - Grådig Algoritme:
     <pre>
     Recursive-Activity-Selector(s, f, m, n)
     1 m = k + 1
     2 <b>while</b> m ≦ n <b>and</b> s[m] < f[k]
     3    m = m + 1
     4 <b>if</b> m ≦ n
     5    S = Recursive-Activity-Selector(s, f, m, n)
     6    <b>return</b> {aₘ} ∪ S
     7 <b>else</b> <b>return</b> ∅
     </pre>
   - Iterativ Algoritme:
     <pre>
     Greedy-Activity-Selector(s, f)
     1 n = s.length
     2 A = {a₁}
     3 for m = 2 to n
     4    if s[m] ≧ f[k]
     5        A = A ∪ {aₘ}
     6        k = m
     7 return A
     </pre>

### Forelesning 8 - Traversering av grafer
 - [x] Forstå hvordan grafer kan implementeres
   - Defineres som G = (V, E) | V = |noder|, E = |kanter|
   - Nabolister, som beskriver grafen
     - A -> B*
     - B -> D -> E*
     - C -> A -> E*
   - Nabomatrise
     <pre>
      . | A B C D E
      -------------
      A | 0 1 0 0 0
      B | 0 1 0 1 1
      C | 1 1 0 0 1
      D | 0 0 0 0 0
      E | 0 0 0 0 0
     </pre>
   - Tegning:
     <pre>
. . . . . . +---+ . . . . . +---+. .
. . +-----+ | A | <-------+ | C |. .
. . | . . . +---+ . . . . . +---+. .
. . v. . . . . . . . . . . . . . . .
. . . . . . . +. . . . . . . . . . .
. +---+ . . . |. . . . . . . . . . .
. | B | . . . |. . . . . . . . . . .
. +---+ . . . | . . . . . . .+---+ .
. . . . . . . +------------>.|.E.| .
. . + . . . . . . . . . . . .+---+ .
. . |. . . . . . . . . . . . . . . .
. . | . . . .+---+. . . . . . .^ . .
. . +------>.|.D.|.+-----------+ . .
. . . . . . .+---. . . . . . . . . .
     </pre>
   - Graftraversering
     - British Museum Algorithm
       - Gå en tilfeldig vei. Vil å evig fordi den ikke husker.
 - [x] Forstå BFS, også for å finne korteste vei uten vekter
   - Breadth-first search:
     - Går til hvert naboelement. Fra de igjen - velg naboene som ikke er valgt.
   - Breadth-first search, algoritme:
     <pre>
     BFS(s, Adj)
     1 level = { s: ø }
     2 parent = { s: None }
     3 i = 0
     4 frontier = [s] ← level i - 1
     5 <b>while</b> frontier:
     6     next = [] ← level i
     7     <b>for</b> u <b>in</b> frontier:
     8         <b>for</b> v <b>in</b> Adj[u]:
     9             <b>if</b> v <b>not in</b> level: <b># Unngå duplikater</b>
     10                level[v] = i
     11                parent[v] = u
     12                next.append(v)
     13     frontier = next
     14     i = i + 1
     </pre>
 - [x] Forstå DFS og **parentesteoremet** (parantes)
   - Depth-first search.
     - Går helt inn til en kant før den traverserer en annen vei.
   - DFS. Algoritme:
     <pre>
     DFS(G)
     1 <b>for</b> each vertex u ∈ G.V
     2    u.color = white
     3    u.π = NIL
     4 time = 0 # global
     5 <b>for</b> each vertex u ∈ G.V
     6    <b>if</b> u.color == white
     7        DFS-Visit(G, u)
     </pre>
   - DFS-Visit funksjon:
     <pre>
     DFS-Visit(G, u)
     1 time = time + 1
     2 u.d = time
     3 u.color = gray
     4 <b>for</b> each v ∈ V.Adj[u]
     5    <b>if</b> v.color == white
     6        v.π = u
     7        DFS-Visit(G, v)
     8 u.color = black
     9 time = time + 1
     10 u.f = time
     </pre>
 - [x] Forstå hvordan DFS klassifiserer kanter
   - 3 statuser:
     - Før oppdagelse.
     - Er i stacken. Har naboer som er i stack eller ikke oppdaget.
     - Tatt ut av stack.
   - 4 cases:
     - **Three edges:** Første oppdagelse. → **Ref. Forelesning 9.**
     - **Back edges:** En sykel.
     - **Forward edges:** Ikke en three edge. Hvis u er forgjenger av v.
     - **Cross edges:** Alle andre kanter.
 - [x] Forstå Topological-Sort
   - Def.: Hvilken rekkefølge som er lov.
   - Eks: Grunnmur.
     - Vegger.
       - Tak.
         - Interiør.
       - Vinduer.
         - Interiør.
       - Vann.
         - Interiør.
   - Gir nodene en rekkefølge.
   - Foreldre før barn.
   - Evt.: Alle kommer etter avhengigheter.
   - Krevevr DAG (dvs. velfundert)!
   - Ex:
     <pre>
. . . . +------------+. . . . . . .+------------+. . . .
. .9/10 | .Klokke . .|. . . . . . .|. .Sokker . | 17/18.
. . . . +------------+. . . . . . .+------+-----+. . . .
. . . . . . . . . . . . . . . . . . . . . v. . . . . . .
. . . . +------------+.+--------->.+------+-----+. . . .
. 11/16 | .Truse. . .|. . . . . . .|. Sko . . . | 13/14.
. . . . +-----+------+.+--------->.+------------+. . . .
. . . . . . . v . . . .| . . . . . . . . . . . . . . . .
. . . . +-----+------+.|. . . . . .+------------+. . . .
. 12/15 | . Bukse . .|.+. . . . .+.|. .Skjorte. | 1/8. .
. . . . +-----+------+. . . . . .|.+------+-----+. . . .
. . . . . . . v . . . . . . . . .|. . . . v. . . . . . .
. . . . +-----+------+.<---------+.+------+-----+. . . .
. . 6/7 | . Belte . .|. . . . . . .|. .Slips. . | 2/5. .
. . . . +------------+.+. . . . . .+------+-----+. . . .
. . . . . . . . . . . .|. . . . . . . . . v. . . . . . .
. . . . . . . . . . . .|. . . . . .+------+-----+. . . .
. . . . . . . . . . . .+--------->.|. .Jakke. . | 3/4. .
. . . . . . . . . . . . . . . . . .+------------+. . . .
     </pre>
 - [x] Forstå hvordan DFS kan implementeres med en stakk ∗
 - [x] Forstå hva traverseringstrær (som bredde-først- og dybde-først-trær) er
 - [x] Forstå traversering med vilkårlig prioritetskø ∗ 

### Forelesning 9 - Minimale spenntrær
 - [x] Forstå skog-implementasjonen av disjunkte mengder
 - [x] Vite hva spenntrær og minimale spenntrær er
   - Backlog
     - Kantklassifisering, DFS
     - Parentesteoremet
     - Topologisk sortering
   - Minimale:
     - Disjunkte mengder
     - Generisk MST
     - Kruskals algoritme
     - Prims algoritme
   - Spenntrær:
     - 
   - Disjunkte mengder:
     - Union by rank
     - m operasjoner: O(m*a(n))
     - Sette varablene
       <pre>
       Make-Set(x)
       1 x.p = x
       2 x.rank = 0
       </pre>
     - Sette varablene
       <pre>
       Union(x, y)
       1 Link(Find-Set(x), Find-Set(y))
       </pre>
     - Sette varablene
       <pre>
       Link(x, y)
       1 <b>if</b> x.rank > y.rank
       2     y.p = x
       3 <b>else</b> x.p = y
       4     <b>if</b> x.rank == y.rank
       5         y.rank = y.rank + 1
       </pre>
       <pre>
       Find-Set(x)
       1 <b>if</b> x != x.p
       2      x.p = Find-Set(x.p)
       3 <b>return</b> x.p
       </pre>
 - [x] Forstå Generic-MST
   - ###
 - [z] Forstå hvorfor lette kanter er trygge kanter
   - Kantklassifiseringer:
     - Tre-kanter
       - Konter i dybde-først-"skogen".
     - Bakoverkanter
       - Kanter til en forgjenger i DF-"skogen".
     - Foroverkanter
       - Kanter utenfor DF-skogen to en etterkommer i DF-skogen.
     - Krysskanter
       - Alle andre kanter.
   - Hvordan definere klassene
   - Møter en hvit node
     - Tre-kant
   - Møter en grå node
     - Bakoverkant
   - Møter en svart node:
     - Forover- eller krysskant
 - [x] Forstå MST-Kruskal
   - Algoritme:
     <pre>
     MST-Kruskal(G, w)
     1 A = ∅
     2 <b>for</b> each vertex v ∈ G.V
     3    Make-Set(v)
     4 sort G.E by w
     5 <b>for</b> each edge (u, v) ∈ G.E
     6    <b>if</b> Find-Set(u) != Find-Set(v)
     7      A = A U {(u, v)}
     8      Union(u, v)
     9 <b>return</b> A
     </pre>
   - Kjøretid:
     <pre>
     Operasjon Antall   Kjøretid
     **Make-Set**    V        O(1)
     **Sortering**   1        O(E lg E)
     **Find-Set**    O(E)     O(lg V )
     **Union**       O(E)     O(lg V )
     **Totalt**: O(E lgV)
     |E| < |V|² => lg|E| < 2 lg|V| => lgE = O(lgV)
     </pre>
 - [x] Forstå MST-Prim
   - Hva det er:
     - Kan implementeres vha. traversering
     - Der BFS bruker FIFO og DFS bruker LIFO, så bruker Prim en min-prioritets-kø
     - Prioriteten er vekten på den letteste kanten mellom noden til treet
     - For enkelhets skyld: Legg alle noder inn fra starten, med uendelig dårlig prioritet
   - Algoritme:
     <pre>
     MST-Prim(G, w, r)
     1 <b>for</b> each u ∈ G.V
     2     u.key = ∞
     3     u.pi = NIL
     4 r.key = 0
     5 Q = G.V
     6 <b>while</b> Q != ∅
     7     u = Extract-Min(Q)
     8     <b>for</b> each v ∈ G.Adj[u]
     9         <b>if</b> v ∈ Q and w(u, v) < v.key
     10            v.pi = u
     11            v.key = w(u, v)
     </pre>
   - Kjøretid:
     <pre>
     Operasjon        Antall   Kjøretid
     **Build-Min-Heap**    1       O(V )
     **Extract-Min**       V       O(lg V )
     **Decrease-Key**      E       O(lg V )
     **Totalt**: O(E lgV)
     **Dette gjelder om vi bruker en binærhaug**
     **Kan forbedres til O(E + V lgV) med Fibonacci-haug**
     </pre>
   - I det følgende: Farging som for BFS
   - Kanter mellom svarte noder er endelige
   - Beste kanter for grå noder også uthevet
   - Boka uthever bare kantene i spenntreet

### Forelesning 10 - Korteste vei fra én til alle
 - [x] Forstå ulike varianter av korteste-vei- eller korteste-sti-problemet
   - En enkel sti er en sti uten sykler
   - En kortest vei vil aldri inneholde en positiv sykel
   - Om vi ikke kan nå noen negative sykler så er «korteste sti» det samme som «korteste enkle sti»
   - Om en sti til v har en negativ sykel, så finnes det alltid en kortere sti – ingen er kortest!
   - Det vil likevel finnes en kortest enkel sti til v, men vi kjenner ingen generelle algoritmer for å finne den
 - [x] Forstå strukturen til korteste-vei-problemet
 - [x] Forstå at negative sykler gir mening for korteste enkle vei (simple path) ∗
 - [x] Forstå at korteste enkle vei er ekvivalent med lengste enkle vei ∗
 - [x] Forstå hvordan man kan representere et korteste-vei-tre
 - [x] Forstå kant-slakking (edge relaxation) og Relax
 - [x] Forstå ulike egenskaper ved korteste veier og slakking
 - [x] Forstå Bellman-Ford
   - Gå gjennom alle kanter en gang.
   - Vi vet da at vi må ha vært innom en av nodene en gang.
   - Hvis vi har slakket alle alle kantene k ganger.
   - V - 1 antall ganger.
   - Algoritme:
     <pre>
     Bellman-Ford(G, w, s)
     1 Initialize-Single-Source(G, s)
     2 <b>for</b> i = 1 <b>to</b> |G.V| - 1
     3    <b>for</b> each edge (u, v) ∈ G.E
     4        Relax(u, v, w)
     5 <b>for</b> each edge (u, v) ∈ G.E
     6    <b>if</b> v.d > u.d + w(u, v)
     7        <b>return</b> false
     8 <b>return</b> true
     </pre>
 - [x] Forstå Dag-Shortest-Path
   - Algoritme:
     <pre>
     Dag-Shortest-Path(G, w, s)
     1 topologically sort the vertices of G
     2 Initialize-Single-Source(G, s)
     3 for each vertex u, in topsort order
     4 for each vertex v 2 G.Adj[u]
     5 Relax(u, v, w)
     </pre>
   - Kjøretid:
     <pre>
     Operasjon            Antall    Kjøretid
     <b>Topologisk sortering</b>   1       Θ(V + E)
     <b>Initialisering</b>         1       Θ(V)
     <b>Relax</b>                  E       Θ(1)
     Totalt: Θ(V + E)
     </pre>
 - [x] Forstå kobling mellom Dag-Shortest-Path og dynamisk programmering∗
 - [x] Forstå Dijkstra
   - Forklaring:
     - Om vi har sykler, kan vi ikke få til topologisk sortering
     - Alternativ: Besøke nodene i stigende avstandsrekkefølge
     - Alle korteste stier får da fortsatt sine kanter slakket i riktig rekkefølge
     - Men vi kjenner jo ikke avstandsrekkefølgen!
 - Notater:
   - **Sti-slakkings-egenskapen:**
     - Om p er en kortest vei fra s til v og vi slakker
     - kantene til p i rekkefølge, så vil v få riktig avstandsestimat.
     - Det gjelder uavhengig av om
     - andre slakkinger forekommer, selv om de kommer
     - innimellom.
   - Slakkingsalgoritme, init:
     <pre>
     Initialize-Single-Source(G, s)
     1 for each vertex v 2 G.V
     2    v.d = 1
     3    v.π = nil
     4 s.d = 0
     </pre>
   - Slakkingsalgoritme, init:
     <pre>
     Relax(u, v, w)
     1 if v.d > u.d + w(u, v)
     2    v.d = u.d + w(u, v)
     3    v.π = u
     </pre>

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