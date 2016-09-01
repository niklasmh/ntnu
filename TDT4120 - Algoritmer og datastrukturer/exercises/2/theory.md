# Teorioppgaver øving 2
## Oppgave 1:
 - a) **At en algoritme har kjøretid Θ(f(n)), betyr at kjøretiden har en ... begrensning. (5 %)**
   - .
 - b) **Hvilke av egenskapene må ikke bevises for å bevise en løkkeinvariant? (5 %)**
   - .
 - c) **Ved sterk induksjon antar vi at ... (5 %)**
   - .

## Oppgave 2:
 - a) **Hilken av algoritmene under er en splitt-og-hersk-algoritme? (5 %)**
   - .
 - b) **Hvor mange sammenligninger (comparisons) og bytter (swaps) trengs for å sortere listen [5, 29, 32, 32, 65, 66] om du bruker insertion sort? (5 %)**
   - .
 - c) **Hvor mange sammenligninger (comparisons) og bytter (swaps) trengs for å sortere listen [5, 32, 66, 32, 65, 29] om du bruker insertion sort? (5 %)**
   - .
 - d) **Hva er det maksimale antallet sammenligninger (comparisons) og bytter (swaps) man kan måtte bruke med en liste på 6 elementer om man bruker insertion sort? (5 %)**
   - .
 - e) **Hva er worst-case-kjøretiden til merge sort? (5 %)**
   - .
 - f) **Hvor mange merge-operasjoner er nødvendig for å sortere listen [1, 2, 3, 4, 5, 6, 8, 7] med merge-sort? (5 %)**
   - .
 - g) **Hvor mange merge-opersjoner er nødvendig for å sortere en liste på 1024 elementer med merge sort? (5 %)**
   - .

## Oppgave 3:
 - a) **Uttrykket 65n4 + 3n3 + 43n2 + 23n + 45 er: (5 %)**
   - .
 - b) **Uttrykket n3 + logn er: (5 %)**
   - .
 - c) **Uttrykket 15n er: (5 %)**
   - .
 - d) **Uttrykket 6(n/2)4 + sqrt(n)logn + 1 (sqrt = kvadratrot) er: (5 %)**
   - .
 - e) **Uttrykket 3nlog3n er: (5 %)**
   - .
 - f) **Uttrykket n1+sin(n) er: (5 %)**
   - .
 - g) **Hvilket av uttrykkene stiger raskest? (5 %)**
   - .

## Oppgave 4:
gjørNoe(n) har kjøretid Θ(n2) for alle oppgavene.

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
   - .
 - b) **Hva er kjøretiden til function2(n)? (5 %)**
   - .
 - c) **Hva er kjøretiden til function3? (5 %)**
   - .
