# Første del (Roger Midtstraum)
### Forelesning 1: (uke 2) – 9/1 Introduksjon til faget og databaser. . . . kap. 1 og 2
 - Database:
   - En samling av data.
   - Erstatning for filer. Bygger på de mest brukte metodene man brukte for å lagre i filer; Søk, legge til, slette og oppdatere (CRUD).
 - 

### Forelesning 2: (uke 2) – 10/1 Datamodellering . . . . . . . . . . . . . kap. 3 og 4
 - ER-modell (Entity Relationship Model):
   - Beskriver datastrukturen og organiseringen av data som skal bygge en database.
   - Kan bruke et ER-diagram for å beskrive relasjoner, fremmednøkler og primærnøkler, samt kolonner i tabeller.

### Forelesning 3: (uke 3) – 16/1 Datamodellering . . . . . . . . . . . . . kap. 3 og 4
 - Kardinalitet:
   - `(0, 1) <=> -o|-`
   - `(0, n) <=> -o∈-`
   - `(1, 1) <=> -||-`
   - `(1, n) <=> -|∈-`
 - Rekursive relasjonsklasser:
   - Eksempel:
     - Person:
       <pre>
. . . . . . . . .A. . . . . . .Underordnet. . . .
. . . +--------------+. . +---------------+ . . .
. . . | . . . . . . .|. . | . . . . . . . | . . .
. . . | . . . . . . .|. . | . . . . . . . | . . .
. . . v . . . . (0,1)|. . |(0,1). . . . . v . . .
. . . . . . . . . +------------+. . . . . . . . .
. +-------+ . . . | . . . . . .|. . . . +-----+ .
. |Forhold| . . . | Person. . .|. . . . |Sjef | .
. +----+--+ . . . | . . . . . .|. . . . +-+---+ .
. . . .|. . . . . | . . . . . .|. . . . . | . . .
. . . .|. . . . . +---+--------+. . . . . | . . .
. . . .|. . . . (0,1) | . |(0,n). . . . . | . . .
. . . .|. . . . . . . ^ . ^ . . . . . . . | . . .
. . . .|. . . . . . . | . | . . . . . . . | . . .
. . . .+--------------+ . +---------------+ . . .
. . . . . . .B. . . . . . . Overordnet. . . . . .
       </pre>
     - Relasjonsky:
       <pre>
. . . . . . . . Relasjoner. . . . . . . .
. . . . . . +--------------+----------+ .
. +------------+. . . . . .|. . . . . | .
. | . . . . . .+-----------+. Forhold | .
. | .Harald . .|. . . . . .|. . . . . | .
. | . . . . . .|. . . . . .+----------+ .
. | .Sonja. . .+-------------+. . . . . .
. | . . . . . .|. . . . . . . . . . . . .
. | .Erna . . .+--------------+ . . . . .
. | . . . . . .|. . . . . +-----------+ .
. | .Siv. . . .+----------+ . . . . . | .
. | .Børge. . .|. . . . . | .Sjef . . | .
. +------------+. . . . . | . . . . . | .
. . . . . . . . . . . . . +-----------+ .
       </pre>
     - Person = { Harald, Sonja, Erna, Siv, Børge }
     - Forhold = { (Harald, Sonja) }
     - Sjef = { (Harald, Erna), (Erna, Siv), (Erna, Børge) }

### Forelesning 4: (uke 3) – 17/1 Relasjonsmodellen . . . . . . . . . . . . kap. 5
### Forelesning 5: (uke 4) – 23/1 Modelloversetting og Relasjonsalgebra . . kap. 9 og 8
### Forelesning 6: (uke 4) – 24/1 Relasjonsalgebra og SQL . . . . . . . . . kap. 6 og 8
### Forelesning 7: (uke 5) – 30/1 SQL . . . . . . . . . . . . . . . . . . . kap. 6 og 7
### Forelesning 8: (uke 5) – 31/1 SQL og Normalisering. . . . . . . . . . . kap. 6, 7 og 14
### Forelesning 9: (uke 6) – 6/2 Normalisering. . . . . . . . . . . . . . . kap. 14
### Forelesning 10: (uke 6) – 7/2 Normalisering . . . . . . . . . . . . . . kap. 14
### Forelesning 11: (uke 7) – 13/2 Designteori. . . . . . . . . . . . . . . kap. 15
### Forelesning 12: (uke 7) – 14/2 Designteori. . . . . . . . . . . . . . . kap. 15

# Andre del (Svein Erik Bratsberg)
### Forelesning 13: (uke 8) – 20/2 System- og databasedesign . . . . . . . .Eget notat
### Forelesning 14: (uke 8) – 21/2 System- og databasedesign, DB-prosjekt . Eget notat
### Forelesning 15: (uke 9-11) Databaseprosjekt
### Forelesning 16: (uke 12) – 20/3 Lagring/indekser. . . . . . . . . . . . kap. 16
### Forelesning 17: (uke 12) – 21/3 Lagring/indekser. . . . . . . . . . . . kap. 17
### Forelesning 18: (uke 13) – 27/3 Queryprosessering . . . . . . . . . . . kap. 18
### Forelesning 19: (uke 13) – 28/3 Transaksjoner, teori. . . . . . . . . . kap. 20
### Forelesning 20: (uke 14) – 3/4 Transaksjoner, låser . . . . . . . . . . kap. 21
### Forelesning 21: (uke 14) – 4/4 Transaksjoner, recovery. . . . . . . . . kap. 22
