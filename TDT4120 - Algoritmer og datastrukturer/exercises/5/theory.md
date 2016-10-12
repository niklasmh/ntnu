# Teorioppgaver øving 5
## Oppgave 1:
 - a) **Sammenligningsbaserte sorteringingsalgoritmer har en worst-case på ... (7.1 %)**
  - Ω(nlgn)Ω(nlg⁡n)
 - b) **Det finnes generelle sorteringsalgorimer med worst-case kjøretid Θ(n)Θ(n). (7.1 %)**
  - Nei
 - c) **En stabil sorteringsalgoritme ... (7.1 %)**
  - holder på den relative ordningen til elementer med like nøkler.
 - d) **Hvilket av alternativene under består kun av sammenlikningsbaserte algoritmer? (7.1 %)**
  - Bubble sort, heapsort og merge sort
 - e) **Hvilken av følgende algoritmer er stabil? (7.1 %)**
  - Mergesort
 - f) **Medianen i ei sortert liste er ... (7.1 %)**
  - det midterste elementet.

## Oppgave 2:
 - a) **Se på figur 8.2 s. 195 i Cormen. I det algoritmen setter inn elementer i B, itereres det over A. Hva er rett? (7.1 %)**
  - Vi må iterere bakover over A.
 - b) **Du ønsker å sortere en sekvens A av reelle tall som er fordelt etter en gitt sannsynlighetsfunksjon med kjent kumulativ sannsynlighetsfunksjon. Hva er den beste kjøretiden du kan få, i gjennomsnitt? (7.1 %)**
  - O(n)O(n) med Bucket Sort
 - c) **Radix Sort bruker en annen sorteringsalgoritme som "del-algoritme". Hvilken av følgende algoritmer fungerer best? (7.1 %)**
  - Merge Sort
 - d) **Hva er worst-case kjøretiden til Bucket Sort, slik den er beskrevet i Cormen? (7.1 %)**
  - Θ(n2)Θ(n2)

## Oppgave 3:

En av eksamensvaktene under fjorårets algdat-eksamen bestemte seg for å bruke radix sort for å sortere besvarelsene etter kandidatnummer, men ble litt forvirret rundt hvordan algoritmen faktisk fungerer. Som den oppegående studenten du er, bestemmer du deg for å hjelpe. Eksamensvakten har 10 bunker nummerert 0 til 9 som besvarelsene fordeles i. Gitt følgende kandidatnr:
10219, 12543, 51323, 10395, 31337, 11235, 12357, 86123, 19023

 - a) **Etter to iterasjoner, hvor mange besvarelser ligger i bunke nr 2? (7.1 %)**
  - 3
 - b) **Etter tre iterasjoner, hvilken rekkefølge har besvarelsene i bunke nr 3? (7.1 %)**
  - 51323, 31337, 12357, 10395

## Oppgave 4:
 - a) **Hvilke(t) utsagn er sant om Randomized-Select? 1. Forventet kjøretid er O(n)O(n) 2. Worst-case kjøretid er Θ(n2)Θ(n2) 3. Worst-case kjøretid er Θ(n)Θ(n) 4. Forventet kjøretid er O(nlgn)O(nlg⁡n) (7.1 %)**
  - 1 og 2
 - b) **Hvilke(t) utsagn er sant om Select? 1. Det er en algoritme som er mest av teoretisk interesse og sjeldent brukt i praksis. 2. Den har garantert worst-case O(n)O(n) for alle sekvenser. 3. Den kan bare finne medianen i en sekvens. 4. Den løser seleksjonsproblemet. (7.1 %)**
  - 1, 2 og 4
