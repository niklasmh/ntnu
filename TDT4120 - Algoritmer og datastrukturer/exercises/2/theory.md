# Teorioppgaver øving 2
## Oppgave 1:
 - a) **At en algoritme har kjøretid Θ(f(n)), betyr at kjøretiden har en ... begrensning. (5 %)**
   - øvre og nedre
 - b) **Hvilke av egenskapene må ikke bevises for å bevise en løkkeinvariant? (5 %)**
   - Indeksering
 - c) **Ved sterk induksjon antar vi at ... (5 %)**
   - P(n) er sann for alle n mindre enn m+1 

## Oppgave 2:
 - a) **Hilken av algoritmene under er en splitt-og-hersk-algoritme? (5 %)**
   - Merge sort
 - b) **Hvor mange sammenligninger (comparisons) og bytter (swaps) trengs for å sortere listen [5, 29, 32, 32, 65, 66] om du bruker insertion sort? (5 %)**
   - 5 sammenligninger og 0 bytter
 - c) **Hvor mange sammenligninger (comparisons) og bytter (swaps) trengs for å sortere listen [5, 32, 66, 32, 65, 29] om du bruker insertion sort? (5 %)**
   - 11 sammenligninger og 6 bytter
 - d) **Hva er det maksimale antallet sammenligninger (comparisons) og bytter (swaps) man kan måtte bruke med en liste på 6 elementer om man bruker insertion sort? (5 %)**
   - 15 sammenligninger og 15 bytter
 - e) **Hva er worst-case-kjøretiden til merge sort? (5 %)**
   - O(nlogn)
 - f) **Hvor mange merge-operasjoner er nødvendig for å sortere listen [1, 2, 3, 4, 5, 6, 8, 7] med merge-sort? (5 %)**
   - 7 merge-operasjoner
 - g) **Hvor mange merge-opersjoner er nødvendig for å sortere en liste på 1024 elementer med merge sort? (5 %)**
   - 1023 merge-operasjoner

## Oppgave 3:
 - a) **Uttrykket 65n⁴ + 3n³ + 43n² + 23n + 45 er: (5 %)**
   - *O(n⁴)*
   - *Θ(n⁴)*
   - *Ω(n⁴)*
   - Alle alternativene over ✓
 - b) **Uttrykket n³ + logn er: (5 %)**
   - *o(n³)*
   - *ω(n³)*
   - Ingen av alternativene over ✓
 - c) **Uttrykket 15ⁿ er: (5 %)**
   - O((log n)n)
 - d) **Uttrykket 6(n/2)⁴ + sqrt(n)logn + 1 (sqrt = kvadratrot) er: (5 %)**
   - Θ(n⁴)
 - e) **Uttrykket 3nlog₃n er: (5 %)**
   - Θ(nlog₂n)
 - f) **Uttrykket n^(1+sin(n)) er: (5 %)**
   - Bare O(n²)
 - g) **Hvilket av uttrykkene stiger raskest? (5 %)**
   - n!

## Oppgave 4:
gjørNoe(n) har kjøretid Θ(n²) for alle oppgavene.

```python
def function1(n):
    for i range(n):
        for j in range(i):
            for k in range(j-10):
                gjorNoe(n)

def function2(n):
    if n > 0:
        function2(n-1)
        gjorNoe(n)

def function3(n):
    n-=1
    if n > 0:
        function3(42)
    gjorNoe(n)
```

 - a) **Hva er kjøretiden til function1(n)? (5 %)**
   - Θ(n⁵)
 - b) **Hva er kjøretiden til function2(n)? (5 %)**
   - Θ(n³)
 - c) **Hva er kjøretiden til function3? (5 %)**
   - Den vil aldri stoppe
