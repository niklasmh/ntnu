# Teorioppgaver øving 8
## Oppgave 1:
 - a) **Grådige algoritmer brukes til å løse optimaliseringsproblemer. Sant eller usant? (2.4 %)**
  - Sant
 - b) **Hvis man kan løse et problem med dynamisk programmering kan man alltid løse det med en grådig algoritme. Sant eller usant? (2.4 %)**
  - Usant
 - c) **Grådige algoritmer er garantert O(n)O(n). Sant eller usant? (2.4 %)**
  - Usant
 - d) **Grådige algoritmer tar lokalt optimale beslutninger. Sant eller usant? (2.4 %)**
  - Sant
 - e) **En grådig algoritme må vite løsningen på alle mulige delproblemer før den kan gjøre det grådige valget. Sant eller usant? (2.4 %)**
  - Usant
 - f) **En grådig algoritme kan ombestemme seg senere når den har funnet ut mer om løsningene på delproblemene. Sant eller usant? (2.4 %)**
  - Usant
 - g) **Vi må ha overlappende delproblemer for å bruke en grådig algoritme. Sant eller usant? (2.4 %)**
  - Usant

## Oppgave 2:
 - a) **Hvilke to egenskaper må et problem ha for å vi kan bruke en grådig algoritme? (2.4 %)**
  - Grådighetsegenskapen og optimal substruktur
 - b) **Hvorfor kan det være ønskelig å bruke en grådig algoritme istedenfor dynamisk programmering? (2.4 %)**
  - Algoritmen kan være enklere å implementere og ha bedre kjøretid.
 - c) **Grådighetsegenskapen (the greedy-choice property) sier... (2.4 %)**
  - at vi kan finne en global optimal løsning ved å ta lokalt optimale valg
 - d) **Hva har grådige algoritmer og dynamisk programmering til felles? (2.4 %)**
  - Begge utnytter optimal delstruktur

## Oppgave 3:
Denne oppgaven handler om aktivitetsutvalg (se kapittel 16.1 i boka).

Du ønsker å velge ut så mange aktiviteter som mulig fra en mengde av åtte aktiviter uten at noen overlapper. Aktivitetene har følgende start og sluttidspunkter:

*s1=12, s2=12, s3=6, s4=15, s5=20, s6=0, s7=4, s8=6*
*f1=14, f2=17, f3=10, f4=18, f5=24, f6=22, f7=7, f8=9*
 - a) **Gitt at du hadde brukt RECURSIVE-ACTIVITY-SELECTOR (side 419) til å løse problemet. Hvilken aktivitet ville du først valgt ut til å være i løsningsmengden AA? (2.4 %)**
  - 7
 - b) **Gitt at du hadde brukt GREEDY-ACTIVITY-SELECTOR (side 421) til å løse problemet. Hvilken aktivitet ville du først valgt ut til å være i løsningsmengden AA? (2.4 %)**
  - 7
 - c) **Gitt at du hadde brukt GREEDY-ACTIVITY-SELECTOR (side 421) til å løse problemet. Hva blir løsningen? Aktiviter i kronologisk rekkefølge. (7.2 %)**
  - 7, 1, 4, 5
    <pre>
    . 0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19  20  21  22  23  24
    1 | . | . | . | . | . | . | . | . | . | . | . | . |███████| . | . | . | . | . | . | . | . | . | . |
    2 | . | . | . | . | . | . | . | . | . | . | . | . |←-----------------→| . | . | . | . | . | . | . |
    3 | . | . | . | . | . | . |←-------------→| . | . | . | . | . | . | . | . | . | . | . | . | . | . |
    4 | . | . | . | . | . | . | . | . | . | . | . | . | . | . | . |███████████| . | . | . | . | . | . |
    5 | . | . | . | . | . | . | . | . | . | . | . | . | . | . | . | . | . | . | . | . |███████████████|
    6 |←-------------------------------------------------------------------------------------→| . | . |
    7 | . | . | . | . |███████████| . | . | . | . | . | . | . | . | . | . | . | . | . | . | . | . | . |
    8 | . | . | . | . | . | . |←---------→| . | . | . | . | . | . | . | . | . | . | . | . | . | . | . |
    9 | . | . | . | . | . | . | . | . | . | . | . | . | . | . | . | . | . | . | . | . | . | . | . | . |
    </pre>
 - d) **Hva forteller teorem 16.1 i boka oss om aktivitetsutvalg-problemet? (4.8 %)**
  - At det har grådighetsegenskapen
 - e) **Hvordan beviser de teorem 16.1 i boka? (12 %)**
  - De starter med en optimal løsning, bytter ut en aktivitet i løsningen med det grådige valget og viser at den nye løsningen er like bra

## Oppgave 4:
Denne oppgaven handler om Huffman-koder (se kapittel 16.3 i boka).

Du ønsker å finne optimal prefix-kode for en streng. Strengens alfabet representeres ved bokstavene a til g. Frekvensene er som følger:

*a.freq=5, b.freq=2, c.freq=20, d.freq=255, e.freq=10, f.freq=22, g.freq=35*
 - a) **Gitt at vi velger å kode alfabetet på følgende måte: a:00001,b:001,c:1,d:00000,e:0001,f:010,g:011,a:00001,b:001,c:1,d:00000,e:0001,f:010,g:011,. Hvor mange bits må vi bruke for å representere strengen? (4.8 %)**
  - 1537
 - b) **Du bruker Huffmans algoritme. Hvilke to bokstaver slår du sammen først? (2.4 %)**
  - aa og bb
 - c) **Du bruker Huffmans algoritme. Hvor mange bits blir aa kodet til? (2.4 %)**
  - 5
 - d) **Du bruker Huffmans algoritme. Hvor mange bits blir bb kodet til? (2.4 %)**
  - 5
 - e) **Du bruker Huffmans algoritme. Hvor mange bits blir cc kodet til? (2.4 %)**
  - 3
 - f) **Du bruker Huffmans algoritme. Hvor mange bits blir dd kodet til? (2.4 %)**
  - 1
 - g) **Du bruker Huffmans algoritme. Hvor mange bits trenger vi for kode strengen med løsningen du finner? (2.4 %)**
  - 561
 - h) **Hva forteller lemma 16.2 om prefix-kode-problemet? (2.4 %)**
  - At det har grådighetsegenskapen
 - i) **Hvordan beviser de lemma 16.2 i boka? (9.6 %)**
  - De starter med et tre som representerer en optimal løsning, bytter om på noder slik at treet inneholder det grådige valget og viser at den nye løsningen er like bra
 - j) **Hva forteller lemma 16.3 om prefix-kode-problemet? (2.4 %)**
  - At det har optimal substruktur

## Oppgave 5:
 - a) **0/1 knapsack har optimal substruktur. Sant eller Usant? (2.4 %)**
  - Sant
 - b) **0/1 knapsack har grådighetsegenskapen. Sant eller Usant? (2.4 %)**
  - Usant
 - c) **Fractional knapsack har optimal substruktur. Sant eller Usant? (2.4 %)**
  - Sant
 - d) **Fractional knapsack har grådighetsegenskapen. Sant eller Usant? (2.4 %)**
  - Sant
