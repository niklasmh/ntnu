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
<pre>
Person
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

Relasjonsky
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

Person = { Harald, Sonja, Erna, Siv, Børge }
Forhold = { (Harald, Sonja) }
Sjef = { (Harald, Erna), (Erna, Siv), (Erna, Børge) }
</pre>
 - Relasjoner av grad > 2:
   - Eksempel:
<pre>
. . . . . . . . . . . . . . . . +---------+ . . . . .
. . . . . . . . . . . . . . . . | Student | . . . . .
. . . . . . . . . . . . . . . . +---------+ . . . . .
. . . . . . . . . . . . . . . . . . . |(0,n). . . . .
. .+--------+ . . . . . . . . . . . . | . . . . . . .
. .|Emne. . | . . . . . . . . . . . .DeltarIGruppe. .
. .+--------+ . . . . . . . . . . . . | . . . . . . .
. (0,n)|. . |(0,n). . . . . . . . . . | . . . . . . .
. . . .|. . | . . . . . . . . . . . . | . . . . . . .
. . . .|. .EmneBrukerGruppe . . . . . |(1,n). . . . .
. . . .|. . | . . . . . . . . . . .+-----------+. . .
. . . .|. . +----------------------+StudGruppe.|. . .
. . . .|. . . . . . . . . . .(0,n).+-----------+. . .
. . HarVeileder . . . . . . . . . . . . . . . . . . .
. . . .|. . . . . . . . . . . . . . . . . . . . . . .
. . . .|. . . . . . . . . . . . . . . . . . . . . . .
. . . .|. +------------+. . . . . . . . . . . . . . .
. . . .+--+ .Veileder .|. . . . . . . . . . . . . . .
. . .(1,n)+------------+. . . . . . . . . . . . . . .
</pre>
   - Her er det også mulig å legge til en relasjon mellom Emne, Veileder og StudGruppe som heter VeilederGruppeEmne.
   - `{ (SGID, EID, VID), ... }`
   - Finnes ikke relasjoner som har relasjoner i dette faget.
 - Svake entitetsklasse:
   - Mangler "naturlig" nøkkel.
   - Kan av og til identifisere gjennom relasjon til annen e-klasse.
   - Eksempel:
<pre>
. . . . . . . +-----+knr. . . . . . . . . . .
. +-----------+ . . . . . . . . . . . . . . .
. |Kommune. . | . . . . . . . . . . . . . . .
. +-----------+ . . . . . . . . . . . . . . .
. .(0,n)| . . | . . . . . . . . . . . . . . .
. . . . | . . +-----+navn . . . . . . . . . .
. . .HarGate. . . . . . . . . . . . . . . . .
. . . . | . . . . . . . . . . . . . . . . . .
. .(1,1)| . . . . . . . .\*Unik.i.en kommune .
. .+==========+ . . . . . . . . . . . . . . .
. .|.Gate . . +----+\_navn\_\* . . . . . . . . .
. .+==========+ . . . . . . . . . . . . . . .
</pre>
 - Prosess:
   1. En e-klasser, noen attr.
   2. Finn r-klasser med navn.
   3. Komplette med attr., nøklaer og andre restriksjon.
   4. Vurder modellen.
   5. Oppfylle krav/bruke
   6. r.klasser -> e-klasser
   7. e-klasse -> attr, rel.
   8. r-klasse spille slå sammen.
   9. attr. -> e-klasse/rel.

### Forelesning 4: (uke 3) – 17/1 Relasjonsmodellen . . . . . . . . . . . . kap. 5

### Forelesning 5: (uke 4) – 23/1 Modelloversetting og Relasjonsalgebra . . kap. 9 og 8

### Forelesning 6: (uke 4) – 24/1 Relasjonsalgebra og SQL . . . . . . . . . kap. 6 og 8

### Forelesning 7: (uke 5) – 30/1 SQL . . . . . . . . . . . . . . . . . . . kap. 6 og 7

### Forelesning 8: (uke 5) – 31/1 SQL og Normalisering. . . . . . . . . . . kap. 6, 7 og 14

### Forelesning 9: (uke 6) – 6/2 Normalisering. . . . . . . . . . . . . . . kap. 14

Normalformer (Ref. wikipendium):
- 1NF: A table represents a relation and has no repeating groups. All attribute values are required to be atomic.
- 2NF: No non-prime attribute in the table is partially dependent on any candidate key.
- 3NF: Every non-prime attribute in the table is directly dependent on every candidate key.
- BCNF: Every non-trivial functional dependency is a dependency on a superkey.
- 4NF: For every non-trivial multi-valued dependency (MVD) X->>Y, X is a superkey.

### Forelesning 10: (uke 6) – 7/2 Normalisering . . . . . . . . . . . . . . kap. 14

### Forelesning 11: (uke 7) – 13/2 Designteori. . . . . . . . . . . . . . . kap. 15

### Forelesning 12: (uke 7) – 14/2 Designteori. . . . . . . . . . . . . . . kap. 15


# Andre del (Svein Erik Bratsberg)
### Forelesning 13: (uke 8) – 20/2 System- og databasedesign . . . . . . . .Eget notat

Hashing:
- B+-trær
  - Ofte clustered.
  - Effektivt om det er flere rader med data.
  - Avg. B+-tre er 3. Kan anta det på eksamen.
  - Eksamen ex:
    - Oppg: Vi skal sette inn følgende nøkler i et B+-tre i den gitte rekkefølge: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10.
<pre>
. . +-----------------+-----[3, 5, 7]---+-----------------+ .
. . | . . . . . . . . | . . . . . . . . | . . . . . . . . | .
[1, 2, ] . . . . . [3, 4, ] . . . . [5, 6, ] . . . . [7, 8, 9]

Siste iterasjon, 10 mangler:
. . . . . . . +-------------------[5, ]------------------+ . . . . . . . . .
. . . . . . . | . . . . . . . . . . . . . . . . . . . . .| . . . . . . . . .
. . +-----[3, 5, 7]---+ . . . . . . . . +-------------[5, 9, ]-----------+ .
. . | . . . . . . . . | . . . . . . . . | . . . . . . . . | . . . . . . .| .
[1, 2, ] . . . . . [3, 4, ] . . . . [5, 6, ] . . . . [7, 8, ] . . . .[9, 10, ]
</pre>
- Hashing
  - En unik nøkkelverdi. Kjappere å finne.
  - Må unngå primærnøkkel.
- Heap file
  - Lagret i lagringsblokker.
  - Mest brukt.

- lustered VS. unclustered:
  - Clustered inneholder faktiske dataene
  - Unclustered har pekere til data.

- Data i en DB ligger i en blokk. Der ligger alt.
- Ex:
  - 20 personer i en clustered.
  - 20 pekere i en unclustered.

- Extendible hashing.

### Forelesning 14: (uke 8) – 21/2 System- og databasedesign, DB-prosjekt . Eget notat

### Forelesning 15: (uke 9-11) Databaseprosjekt

### Forelesning 16: (uke 12) – 20/3 Lagring/indekser. . . . . . . . . . . . kap. 16

#### Arkitektur for databasesystemer

#### Hvordan lagres databasen?
  - Poster / blokker
  - Heapfiler
  - Hashing
  - B+-trær

#### Hvordan indekserer vi databasen?
- Hashing
  - Statisk
  - Extendible hashing
  - Linear hashing
- B+-trær

1. Viktige egenskaper ved et databasesystem
    - Håndtere store datamengder. Gjerne mer enn primærminne på datamaskin.
    - Støtte effektiv aksess til store datamengder.

2. Arkitektur / innhold
    - JDBC / C# / SQLCommand / PHP
      - SQL => SQL-kompliator <= SQL Catalog / Dictionary
      - SQL-kompilator => Optimalisator <= Statistikk
      - Optimalisator => Utfører (18)
      - Utfører => DB-buffer
      - DB-buffer => Tabeller, indekser (16) => Blokker (17), poster
      - Utfører => Låser (21)
      - Utfører => Logg (22)
      - Utfører => Transaksjonstabell (20, 22)

3. Datalagringsmedier (16.1)
    - Primærlager / RAM
      - Databasebuffer.
    - Sekundærlager
      - Magnetisk disk: Stor, men treg til tilfeldig lesning.
      - SSD: Liten, men rask til tilfeldig lesing.

4. Databaselagring (16.1.2)
    - Databasen lagres i filer eller på "raw device"
    - Lagring av tabeller:
      - Heapfil
      - Hashfil
      - B+-trær (innoDB)
    - Lagring av indekser
      - Hashing
      - B+-trær
      - R-trær

5. Lagring av poster (16.4)
    - En rad i en tabell er lagret som en post i en fil.
    - En post har felter med navn og datatype.
    - Fig 16.5 (s. 562):
      | 0. Name | 12. Ssn | 21. Salery | 25. Job_code | 29. Department
      | --- | --- | --- | --- | ---
      | Smith, John | 123456789 | XXXX | XXXX | Computer
    - Man kan sette nummer på hver av kolonnene for å vise hvor mye plass som skal settes av.
    - Deretter kan man finne data ved hjelp av dette biblioteket.
    - Annen måte:
      - | Name = Smith, John |#| Ssn = 123456789 |#| ...
      - Her lagres attributt sammen ved verdi, litt som XML.

6. Heapfiler (16.6)
    - "Rått lager" av poster.
    - Poster settes inn på slutten av filen.
      - | Blokk | => Fylles med poster => | [Post] [Post] | | [Post] [Post] | ... | Slutt |
      - Skal du finne en post må du gjennom hele filen.
        - Derfor har man en indeks på et søkefelt.
        - En referanse til posten:
          - RecordId = (BlokkId, Indeks innen blokk)
          - \+ Lett å sette inn posten.
          - \+ God til tabellskann.
          - \- Søk på felter.

7. Hashbaserte indekser (16.8)
    - Indeksstruktur som er bra for direkte aksess på søkenøkkel.
      | Indeks | Blokk
      |:------:| -----
      | 0      |
      | 1      | Post, Post
      |        |
      | 2      | Post
      |        |
      |        |
      | M-1    |
    - Om en blokk blir full havner neste i en overflytsblokk med en peker til.
      - Håndtering:
        - Åpen adressering: Lagrer i første ledige etterfølgende blokk.
        - Separat overløp: Lenk sammen overløpsblokker.
    - h-hashfunksjon skal spre postene godt.
      - Ex: h(k) = K mod M - restfunksjon.

8. Statisk hashing (16.8.3)
    - MySQL: Partition by key.
    - Fast antall blokker i samme fil.
    - Må bruke overløp for dynamiske datamengder.
    - Lange overløp som ødelegger ytelse.
    - Oppg:
      - Har en liten hashfil med 4 blokker.
      - Key mod 4.
      - Sett inn: 9, 11, 12, 7, 8, 4
        | Key | Mod 4
        |:---:| -----
        |  9  | 01
        | 11  | 11
        | 12  | 00
        |  7  | 11
        |  8  | 00
        |  4  | 00
      - Fil:
        | Indeks | Blokk
        |:------:| -----
        | 00     | 12, 8 => overløp [ 4 ]
        | 01     | 9
        | 10     |
        | 11     | 11, 7

9. Extendible hashing (16.8.3)
    - Håndering a dynamiske datamengder.
    - Løser problemet med statisk hashing:
      - Hvis blokk er full, hvorfor ikke reorganisere filen ved å doble antall blokker?
      - Lesing og skriving til hele fila.
    - Bruk katalog med pekere til blokker og dobler katalog ved behov.
      - => Splitte blokken som ble full.
    - Ex:
      - En katalog med 4 pekere til dataene.
        <pre>
        * => hashverdi av nøkkel
        Global depth
        . . .v
        . .| 2 | . . .| 2 | <- Local depth
        -------------------------------
        00 | . | ---> | 4*, 12*, 16*, 32*
        01 | . | ---> | 1*, 5*, 13*, 21*
        10 | . | ---> | 10*
        11 | . | ---> | 7*, 15*, 19*
        -------------------------------
        . . . . . . . | 2 | <- Local depth
        </pre>
      - Ser på de siste bitene i hashverdien (global depth)
      - Directory dobling når vi dobler katalog for å få plass til flere verdier.

10. Linear hashing (16.8.3)
    - (MySQL: linear hash)
    - En hashfil som kan være dynamisk uten å bruke katalog.
    - Anta fila har M blokkene 0, 1, ... , M-1 og h(K) = K mod M
    - Bruker lenka overløp (som i statisk hashing).
    - Splitter en og en blokk, hvorav navnet lineært.
    - Ukontrollert splitting.

### Forelesning 17: (uke 12) – 21/3 Lagring/indekser. . . . . . . . . . . . kap. 17

11. Ordnede indekser (17)
    - ISAM (Index Sequential Access Method) - Gammel, finnes enda i noen store maskiner.
    - InnoDB bruker for det meste idag.
    - B-tre - Ordnet treindeks
    - B+-tre - Ordnet treindeks

12. Begreper innen indeksering (17)
    - Indeksfelt: Attr / Felt av posten som indeksen bruker.
    - Primærindeks: Indeks på primærnøkkelen.
    - Klusterindeks: Indeks på en tabell som er lagret i samme rekkefølge som tabellen.
      - => B+-tre.
    - Sekundærindeks: Ekstra indeks på en annen attr / et annet felt enn primørnøkkelen.
      - Denne indeksen kan være UNIQUE.
    - Noen DBMS lar deg velge hvilken måte du kan lagre på, men ofte blir det bare B+-trær.

13. Vanlige lagrings / indekssituasjoner:
    - a) Tabell lagret i heapfil.
      - Indeks på primærnøkkel (evt. en hash) med B+-tre.
      - MySQL - MyISAM (pleide å være det frem til rundt 2013 hvor innoDB ble standard/default).
    - b) B-tre på primærnøkkel -> Alltid bare en rotnode.
      - Lagrer selve tabellraden i løvnodene.
      - Clustered B+-tre.
      - InnoDB - storage engine - bruke denne.
    - c) Hashtabell med hashindex på primærnøkkel.
      - Selve posten er lagret på indeksen.
      - Clustered hashindex.

14. ISAM - Index Sequential Access Method
    - To nivåer med indeks.
    - Sekvensiell lagring av dataene.
    - Fordeler:
      - Effektiv for å finne data baser på primærnøkkel.
      - Veldig effektiv på sekvensiell skann på primærnøkkel.
    - Ulempe:
      - Vanskelig å sette inn data mellom andre data. Da må man flytte data.
        - Vil si det går bra å sette de inn etterhverandre på slutten.

15. B-trær (Opprinnelig, ikke B+) (17.3.1)
    - Generalisering av ISAM med multiple nivåer.
    - Bra på direkteaksess på søkenøkkel.
    - Gode på sekvensielle skann og verdiområdesøk.
    - Trær er balanserte.
    - Poster også på indexnivå.

16. B+-trær (17.3.2)
    - Den er den mest bruke indeksen.
    - Innsetting, gjenfinning og sletting (CRD) har alle kostnad: Log_f(N).
      - N: Antall blokker.
      - f: Fanout - antall poster på en indeksblokk (antall pekere i en blokk).
    - Minimum: 50% fyllgrad.
    - Avg: 67% fyllgrad. 2/3 full.
    - Du vil helst ikke ha mindre i tilfelle det kommer mer info senere.

17. B+-trær i praksis (17.3.2)
    - Typisk fanout: 133
    - Typisk fyllgrad: 67%
    - Typisk kapasitet
      - Høyde 4: `133⁴ = 312900700 poster`
      - Høyde 3: `133³ = 2352637 poster`
    - Hvis løvnodene inneholder selve posten (clustered B+-tre):
      - Høyde 4: `133⁴ * 20 = 47 mill poster`
    - Vil i praksis ha de øverste nivåene.

| Nivå | Blokker | Plass
| --- | ---:| ---:
| Level 3 | 1 blokk | 8KB
| Level 2 | 133 blokk | 1MB
| Level 1 | 17600 blokk | 133MB
| Level 0 (root) | 2.3 mill blokk | 18GB

### Forelesning 18: (uke 13) – 27/3 Queryprosessering . . . . . . . . . . . kap. 18

### Forelesning 19: (uke 13) – 28/3 Transaksjoner, teori. . . . . . . . . . kap. 20

### Forelesning 20: (uke 14) – 3/4 Transaksjoner, låser . . . . . . . . . . kap. 21

### Forelesning 21: (uke 14) – 4/4 Transaksjoner, recovery. . . . . . . . . kap. 22

Gitt følgende historier:
1. r1(X); r2(Y), w3(X); r2(X); r1(Y); c1; c2; c3;
  - Leser fra 2 X
  - Ikke gjenopprettbar.
2. r1(X); r1(Y); w1(X); r2(Y); w2(X); w1x r3y c1 c2 c3
  - 1 -> x
  - 1 -> x
  - 2 ->
  - 
3. r2x w3x c3 w1y c1 r2y w2z c2
  - t2 -> x
  - t3 -> wx
  - t3 -> cx
  - 3 0 y
  - 2y
  - 
  - Gjenopprettbar, ACA og strikt.

- r => read
- w => write
- c => commit
- a => abort

Avgjør recoveryegenskapene (ikke gjennopprettbar, gjenopprettbar, ACA eller strikt) til historiene.

- Ikke gjen
- Gjen:
  - Transaksjoner som leser endringer av andr, må committe etter di.
- ACA:
  - 


Serialiserbarhet:
  - Ekvivalent med en seriell historie
Konfliktsseialiserbarhet
  - Presedensgraf - hvilke transaksjoner må kommer før de andre.
  Finner det sykler? Hvis ikke - konfliktserialiserbar.

H1: r1x r2y r1y r3x r3y w1x c1 w3y c3 r2x w2z c2

t3 -> t1 -> t2 -> t3
t1 -> t3

=> Ikke konflikt serialiserbar.

##### Låser:
- 2PL: Alle låseoperasjoner skjer før ale opplåsningsoperasjoner.
- Basic:
  -  Konservativ: Låser alt man trenger aller først.
    - Unngå det med timeout, lage sykel.
  - Stict: Opplåsning av skrivelåser etter ferdig transaksjon.
    - Ikke Konservativ.
  - Rigorous: Opplåsing av alle låser etter ferdig transaksjon.
    - Strict.

Ex:
  - H4: r1a r2b w1b w1c r2a c1 c2
  - H5: rl1a r1a rl2b r2b rl2a r2a unl2 c2 wl1b w1b wl1c w1c unl1 c1

#### Transaksjoner
- Atomic: Kjør alt eller ingenting.
- Consistency: Må følge regler for databasen.
- Isolation: Må være konfliktseialiserbar.
- Durability: Når en transaksjon ha commitet så blir databasen værende i den tilstanden.

- Unngå: Dirty Read, Unrepeatable read, Lost update.

##### Recovery
- ARIES: No-Force, Steal. Undo/Redo.
- LSN: Logginsekvens-nummer: I stigende rekkefølge.
- PageLSN: LSN til logpost som sist endret en blokk.
- FlushedLSN: LSN til nteste loggpost skrevet til disk.

- Aries: Redo-Undo.
- Skriver loggen til disk før den skriver blokken.

- Når trenger en ikke Redo:
  - PageID ikke er I Dirty Page Table.
  - Loggpostens LSN er mindre enn DPT RecoveryLSN (første I DPT).
  - Losspostens LSN er mindre eller lik blokkas pageLSN
- Hva gjør en undo på:
  - Alle write operasjoner fra transaksjoner som ikke er commited.
