# TDT4180 - Databasemodellering og databasesystemer

## Forelesningsplan
- [Forelesning 1: (uke 2) – 9/1 Introduksjon til faget og databaser. Kap. 1 og 2](#forelesning-1-uke-2--91-introduksjon-til-faget-og-databaser-kap-1-og-2)
- [Forelesning 2: (uke 2) – 10/1 Datamodellering. Kap. 3 og 4](#forelesning-2-uke-2--101-datamodellering-kap-3-og-4)
- [Forelesning 3: (uke 3) – 16/1 Datamodellering. Kap. 3 og 4](#forelesning-3-uke-3--161-datamodellering-kap-3-og-4)
- [Forelesning 4: (uke 3) – 17/1 Relasjonsmodellen. Kap. 5](#forelesning-4-uke-3--171-relasjonsmodellen-kap-5)
- [Forelesning 5: (uke 4) – 23/1 Modelloversetting og Relasjonsalgebra. Kap. 9 og 8](#forelesning-5-uke-4--231-modelloversetting-og-relasjonsalgebra-kap-9-og-8)
- [Forelesning 6: (uke 4) – 24/1 Relasjonsalgebra og SQL. Kap. 6 og 8](#forelesning-6-uke-4--241-relasjonsalgebra-og-sql-kap-6-og-8)
- [Forelesning 7: (uke 5) – 30/1 SQL. Kap. 6 og 7](#forelesning-7-uke-5--301-sql-kap-6-og-7)
- [Forelesning 8: (uke 5) – 31/1 SQL og Normalisering. Kap. 6, 7 og 14](#forelesning-8-uke-5--311-sql-og-normalisering-kap-6-7-og-14)
- [Forelesning 9: (uke 6) – 6/2 Normalisering. Kap. 14](#forelesning-9-uke-6--62-normalisering-kap-14)
- [Forelesning 10: (uke 6) – 7/2 Normalisering. Kap. 14](#forelesning-10-uke-6--72-normalisering-kap-14)
- [Forelesning 11: (uke 7) – 13/2 Designteori. Kap. 15](#forelesning-11-uke-7--132-designteori-kap-15)
- [Forelesning 12: (uke 7) – 14/2 Designteori. Kap. 15](#forelesning-12-uke-7--142-designteori-kap-15)
- [Forelesning 13: (uke 8) – 20/2 System- og databasedesign. Eget notat](#forelesning-13-uke-8--202-system-og-databasedesign-eget-notat)
- [Forelesning 16: (uke 12) – 20/3 Lagringindekser. Kap. 16](#forelesning-16-uke-12--203-lagringindekser-kap-16)
- [Forelesning 17: (uke 12) – 21/3 Lagringindekser. Kap. 17](#forelesning-17-uke-12--213-lagringindekser-kap-17)
- [Forelesning 18: (uke 13) – 27/3 Queryprosessering. Kap. 18](#forelesning-18-uke-13--273-queryprosessering-kap-18)
- [Forelesning 19: (uke 13) – 28/3 Transaksjoner, teori. Kap. 20](#forelesning-19-uke-13--283-transaksjoner-teori-kap-20)
- [Forelesning 20: (uke 14) – 3/4 Transaksjoner, låser. Kap. 21](#forelesning-20-uke-14--34-transaksjoner-låser-kap-21)
- [Forelesning 21: (uke 14) – 4/4 Transaksjoner, recovery. Kap. 22](#forelesning-21-uke-14--44-transaksjoner-recovery-kap-22)

## Første del (Roger Midtstraum)

### Forelesning 1: (uke 2) – 9/1 Introduksjon til faget og databaser. Kap. 1 og 2
 - Database:
   - En samling av data.
   - Erstatning for filer. Bygger på de mest brukte metodene man brukte for å lagre i filer; Søk, legge til, slette og oppdatere (CRUD).
 - 

[//]: # "                       ########     ###    ########    ###"
[//]: # "                       ##     ##   ## ##      ##      ## ##"
[//]: # "                       ##     ##  ##   ##     ##     ##   ##"
[//]: # "                       ##     ## ##     ##    ##    ##     ## #######"
[//]: # "                       ##     ## #########    ##    #########"
[//]: # "                       ##     ## ##     ##    ##    ##     ##"
[//]: # "                       ########  ##     ##    ##    ##     ##"
[//]: # "##     ##  #######  ########  ######## ##       ##       ######## ########  #### ##    ##  ######"
[//]: # "###   ### ##     ## ##     ## ##       ##       ##       ##       ##     ##  ##  ###   ## ##    ##"
[//]: # "#### #### ##     ## ##     ## ##       ##       ##       ##       ##     ##  ##  ####  ## ##"
[//]: # "## ### ## ##     ## ##     ## ######   ##       ##       ######   ########   ##  ## ## ## ##   ####"
[//]: # "##     ## ##     ## ##     ## ##       ##       ##       ##       ##   ##    ##  ##  #### ##    ##"
[//]: # "##     ## ##     ## ##     ## ##       ##       ##       ##       ##    ##   ##  ##   ### ##    ##"
[//]: # "##     ##  #######  ########  ######## ######## ######## ######## ##     ## #### ##    ##  ######"

### Forelesning 2: (uke 2) – 10/1 Datamodellering. Kap. 3 og 4
 - ER-modell (Entity Relationship Model):
   - Beskriver datastrukturen og organiseringen av data som skal bygge en database.
   - Kan bruke et ER-diagram for å beskrive relasjoner, fremmednøkler og primærnøkler, samt kolonner i tabeller.

### Forelesning 3: (uke 3) – 16/1 Datamodellering. Kap. 3 og 4
 - Kardinalitet:
   - `(0, 1) <=> -o|-`
   - `(0, n) <=> -o∈-`
   - `(1, 1) <=> -||-`
   - `(1, n) <=> -|∈-`
 - Rekursive relasjonsklasser:
   - Eksempel:
<pre>
Person
                 A             Underordnet
      +--------------+    +---------------+
      |              |    |               |
      |              |    |               |
      v         (0,1)|    |(0,1)          v
                  +------------+
  +-------+       |            |        +----+
 < Forhold >      | Person     |       < Sjef >
  +----+--+       |            |        +-+--+
       |          |            |          |
       |          +---+--------+          |
       |        (0,1) |   |(0,n)          |
       |              ^   ^               |
       |              |   |               |
       +--------------+   +---------------+
             B              Overordnet

Relasjonsky
                Relasjoner
            +--------------+----------+
  +------------+           |          |
  |            +-----------+  Forhold |
  |  Harald    |           |          |
  |            |           +----------+
  |  Sonja     +-------------+
  |            |
  |  Erna      +--------------+
  |            |          +-----------+
  |  Siv       +----------+           |
  |  Børge     |          |  Sjef     |
  +------------+          |           |
                          +-----------+

Person = { Harald, Sonja, Erna, Siv, Børge }
Forhold = { (Harald, Sonja) }
Sjef = { (Harald, Erna), (Erna, Siv), (Erna, Børge) }
</pre>
 - Relasjoner av grad > 2:
   - Eksempel:
<pre>
                                +---------+
                                | Student |
                                +---------+
                                      |(0,n)
   +--------+                         |
   |Emne    |                        DeltarIGruppe
   +--------+                         |
  (0,n)|    |(0,n)                    |
       |    |                         |
       |   EmneBrukerGruppe           |(1,n)
       |    |                      +-----------+
       |    +----------------------+StudGruppe |
       |                     (0,n) +-----------+
    HarVeileder
       |
       |
       |  +------------+
       +--+  Veileder  |
     (1,n)+------------+
</pre>
   - Her er det også mulig å legge til en relasjon mellom Emne, Veileder og StudGruppe som heter VeilederGruppeEmne.
   - `{ (SGID, EID, VID), ... }`
   - Finnes ikke relasjoner som har relasjoner i dette faget.
 - Svake entitetsklasse:
   - Mangler "naturlig" nøkkel.
   - Kan av og til identifisere gjennom relasjon til annen e-klasse.
   - Eksempel:
<pre>
              +-----+knr
  +-----------+
  |Kommune    |
  +-----------+
   (0,n)|     |
        |     +-----+navn
     HarGate
        |
   (1,1)|                \*Unik i en kommune
   +==========+
   | Gate     +----+\_navn\_\*
   +==========+
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

[//]: # "########  ######## ##          ###     ######        ##  #######  ##    ##  ######"
[//]: # "##     ## ##       ##         ## ##   ##    ##       ## ##     ## ###   ## ##    ##"
[//]: # "##     ## ##       ##        ##   ##  ##             ## ##     ## ####  ## ##"
[//]: # "########  ######   ##       ##     ##  ######        ## ##     ## ## ## ##  ######  #######"
[//]: # "##   ##   ##       ##       #########       ## ##    ## ##     ## ##  ####       ##"
[//]: # "##    ##  ##       ##       ##     ## ##    ## ##    ## ##     ## ##   ### ##    ##"
[//]: # "##     ## ######## ######## ##     ##  ######   ######   #######  ##    ##  ######"
[//]: # "     ##     ##  #######  ########  ######## ##       ##       ######## ##    ##"
[//]: # "     ###   ### ##     ## ##     ## ##       ##       ##       ##       ###   ##"
[//]: # "     #### #### ##     ## ##     ## ##       ##       ##       ##       ####  ##"
[//]: # "     ## ### ## ##     ## ##     ## ######   ##       ##       ######   ## ## ##"
[//]: # "     ##     ## ##     ## ##     ## ##       ##       ##       ##       ##  ####"
[//]: # "     ##     ## ##     ## ##     ## ##       ##       ##       ##       ##   ###"
[//]: # "     ##     ##  #######  ########  ######## ######## ######## ######## ##    ##"

### Forelesning 4: (uke 3) – 17/1 Relasjonsmodellen. Kap. 5

### Forelesning 5: (uke 4) – 23/1 Modelloversetting og Relasjonsalgebra. Kap. 9 og 8

[//]: # "########  ######## ##          ###     ######        ##  #######  ##    ##  ######"
[//]: # "##     ## ##       ##         ## ##   ##    ##       ## ##     ## ###   ## ##    ##"
[//]: # "##     ## ##       ##        ##   ##  ##             ## ##     ## ####  ## ##"
[//]: # "########  ######   ##       ##     ##  ######        ## ##     ## ## ## ##  ######  #######"
[//]: # "##   ##   ##       ##       #########       ## ##    ## ##     ## ##  ####       ##"
[//]: # "##    ##  ##       ##       ##     ## ##    ## ##    ## ##     ## ##   ### ##    ##"
[//]: # "##     ## ######## ######## ##     ##  ######   ######   #######  ##    ##  ######"
[//]: # "            ###    ##        ######   ######## ########  ########     ###"
[//]: # "           ## ##   ##       ##    ##  ##       ##     ## ##     ##   ## ##"
[//]: # "          ##   ##  ##       ##        ##       ##     ## ##     ##  ##   ##"
[//]: # "         ##     ## ##       ##   #### ######   ########  ########  ##     ##"
[//]: # "         ######### ##       ##    ##  ##       ##     ## ##   ##   #########"
[//]: # "         ##     ## ##       ##    ##  ##       ##     ## ##    ##  ##     ##"
[//]: # "         ##     ## ########  ######   ######## ########  ##     ## ##     ##"

### Forelesning 6: (uke 4) – 24/1 Relasjonsalgebra og SQL. Kap. 6 og 8

[//]: # " ######   #######  ##"
[//]: # "##    ## ##     ## ##"
[//]: # "##       ##     ## ##"
[//]: # " ######  ##     ## ##"
[//]: # "      ## ##  ## ## ##"
[//]: # "##    ## ##    ##  ##"
[//]: # " ######   ##### ## ########"

### Forelesning 7: (uke 5) – 30/1 SQL. Kap. 6 og 7

### Forelesning 8: (uke 5) – 31/1 SQL og Normalisering. Kap. 6, 7 og 14

[//]: # "##    ##  #######  ########  ##     ##    ###    ##       ####  ######  ######## ########  #### ##    ##  ######"
[//]: # "###   ## ##     ## ##     ## ###   ###   ## ##   ##        ##  ##    ## ##       ##     ##  ##  ###   ## ##    ##"
[//]: # "####  ## ##     ## ##     ## #### ####  ##   ##  ##        ##  ##       ##       ##     ##  ##  ####  ## ##"
[//]: # "## ## ## ##     ## ########  ## ### ## ##     ## ##        ##   ######  ######   ########   ##  ## ## ## ##   ####"
[//]: # "##  #### ##     ## ##   ##   ##     ## ######### ##        ##        ## ##       ##   ##    ##  ##  #### ##    ##"
[//]: # "##   ### ##     ## ##    ##  ##     ## ##     ## ##        ##  ##    ## ##       ##    ##   ##  ##   ### ##    ##"
[//]: # "##    ##  #######  ##     ## ##     ## ##     ## ######## ####  ######  ######## ##     ## #### ##    ##  ######"

### Forelesning 9: (uke 6) – 6/2 Normalisering. Kap. 14

Normalformer (Ref. wikipendium):
- 1NF: A table represents a relation and has no repeating groups. All attribute values are required to be atomic.
- 2NF: No non-prime attribute in the table is partially dependent on any candidate key.
- 3NF: Every non-prime attribute in the table is directly dependent on every candidate key.
- BCNF: Every non-trivial functional dependency is a dependency on a superkey.
- 4NF: For every non-trivial multi-valued dependency (MVD) X->>Y, X is a superkey.

### Forelesning 10: (uke 6) – 7/2 Normalisering. Kap. 14

[//]: # "########  ########  ######  ####  ######   ##    ## ######## ########  #######  ########  ####"
[//]: # "##     ## ##       ##    ##  ##  ##    ##  ###   ##    ##    ##       ##     ## ##     ##  ##"
[//]: # "##     ## ##       ##        ##  ##        ####  ##    ##    ##       ##     ## ##     ##  ##"
[//]: # "##     ## ######    ######   ##  ##   #### ## ## ##    ##    ######   ##     ## ########   ##"
[//]: # "##     ## ##             ##  ##  ##    ##  ##  ####    ##    ##       ##     ## ##   ##    ##"
[//]: # "##     ## ##       ##    ##  ##  ##    ##  ##   ###    ##    ##       ##     ## ##    ##   ##"
[//]: # "########  ########  ######  ####  ######   ##    ##    ##    ########  #######  ##     ## ####"

### Forelesning 11: (uke 7) – 13/2 Designteori. Kap. 15

### Forelesning 12: (uke 7) – 14/2 Designteori. Kap. 15


## Andre del (Svein Erik Bratsberg)

[//]: # "         ######  ##    ##  ######  ######## ######## ##     ##"
[//]: # "        ##    ##  ##  ##  ##    ##    ##    ##       ###   ###"
[//]: # "        ##         ####   ##          ##    ##       #### ####"
[//]: # "         ######     ##     ######     ##    ######   ## ### ## #######"
[//]: # "              ##    ##          ##    ##    ##       ##     ##"
[//]: # "        ##    ##    ##    ##    ##    ##    ##       ##     ##"
[//]: # "         ######     ##     ######     ##    ######## ##     ##"
[//]: # "                           #######   ######"
[//]: # "                          ##     ## ##    ##"
[//]: # "                          ##     ## ##"
[//]: # "                          ##     ## ##   ####"
[//]: # "                          ##     ## ##    ##"
[//]: # "                          ##     ## ##    ##"
[//]: # "                           #######   ######"
[//]: # "########     ###    ########    ###    ########     ###     ######  ########"
[//]: # "##     ##   ## ##      ##      ## ##   ##     ##   ## ##   ##    ## ##"
[//]: # "##     ##  ##   ##     ##     ##   ##  ##     ##  ##   ##  ##       ##"
[//]: # "##     ## ##     ##    ##    ##     ## ########  ##     ##  ######  ######"
[//]: # "##     ## #########    ##    ######### ##     ## #########       ## ##"
[//]: # "##     ## ##     ##    ##    ##     ## ##     ## ##     ## ##    ## ##"
[//]: # "########  ##     ##    ##    ##     ## ########  ##     ##  ######  ########"
[//]: # "          ########  ########  ######  ####  ######   ##    ##"
[//]: # "          ##     ## ##       ##    ##  ##  ##    ##  ###   ##"
[//]: # "          ##     ## ##       ##        ##  ##        ####  ##"
[//]: # "          ##     ## ######    ######   ##  ##   #### ## ## ##"
[//]: # "          ##     ## ##             ##  ##  ##    ##  ##  ####"
[//]: # "          ##     ## ##       ##    ##  ##  ##    ##  ##   ###"
[//]: # "          ########  ########  ######  ####  ######   ##    ##"

### Forelesning 13: (uke 8) – 20/2 System- og databasedesign. Eget notat

Hashing:
- B+-trær
  - Ofte clustered.
  - Effektivt om det er flere rader med data.
  - Avg. B+-tre er 3. Kan anta det på eksamen.
  - Eksamen ex:
    - Oppg: Vi skal sette inn følgende nøkler i et B+-tre i den gitte rekkefølge: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10.
<pre>
    +-----------------+-----[3, 5, 7]---+-----------------+
    |                 |                 |                 |
[1, 2, ]           [3, 4, ]         [5, 6, ]         [7, 8, 9]

Siste iterasjon, 10 mangler:
              +-------------------[5, ]------------------+
              |                                          |
    +-----[3, , ]-----+                 +-------------[7, 9, ]-----------+
    |                 |                 |                |               |
[1, 2, ]           [3, 4, ]         [5, 6, ]         [7, 8, ]        [9, 10, ]
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

[//]: # "##          ###     ######   ########  #### ##    ##  ######"
[//]: # "##         ## ##   ##    ##  ##     ##  ##  ###   ## ##    ##"
[//]: # "##        ##   ##  ##        ##     ##  ##  ####  ## ##"
[//]: # "##       ##     ## ##   #### ########   ##  ## ## ## ##   ####"
[//]: # "##       ######### ##    ##  ##   ##    ##  ##  #### ##    ##"
[//]: # "##       ##     ## ##    ##  ##    ##   ##  ##   ### ##    ##"
[//]: # "######## ##     ##  ######   ##     ## #### ##    ##  ######"

### Forelesning 16: (uke 12) – 20/3 Lagring/indekser. Kap. 16

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

      | Name = Smith, John |#| Ssn = 123456789 |#| ...
      | --- | --- | --- | --- | ---
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

### Forelesning 17: (uke 12) – 21/3 Lagring/indekser. Kap. 17

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
      - Høyde 4: `133⁴ = 312900721 poster`
      - Høyde 3: `133³ = 2352637 poster`
    - Hvis løvnodene inneholder selve posten (clustered B+-tre):
      - Høyde 4: `133⁴ * 20 = 47 millioner poster? Regner 6.2 milliarder.`
    - Vil i praksis ha de øverste nivåene.

      | Nivå | Blokker | Plass
      | --- | ---:| ---:
      | Level 3 | 1 blokk | 8KB
      | Level 2 | 133 blokk | 1MB
      | Level 1 | 17600 blokk | 133MB
      | Level 0 (root) | 2.3 mill blokk | 18GB

18. Blokksplitting i B+-tre
    - Pleier å splitte ved midterste post i antall eller størrelse.
    - Max størrelse er ofte bestemt ur ifra 1/2 blokk-størrelse.
    - Indeksposter er små (Nøkkel + blokk id).
    - Løvnodeposter kan være større (clustered).

19. Eksempel med innsetting i B+-tre:
    - Sett inn tallene: 2, 5, 14, 22, 27, 3, 7, 16, 24
    - Skal ende opp med dette, ifølge algoritmen:
<pre>
               +-------[14, , ]--------+
               |                       |
   +--------[5, , ]        +-------[22, 27, ]-------+
   |           |           |           |            |
[2, 3, ]   [5, 7, ]   [14, 16, ]   [22, 24, ]   [27, 33, ]
</pre>

20. Indekser på sammensatte nøkler (17.4)
    - Ex:
      - Employee (ssn, dno, age, street, zip, salery, skill)
      - `SELECT * FROM Employee WHERE dno = 4 AND age > 50`
      - Hvilke indekser hjelper mest?
        - Indeks på dno:
          - Finn all poster med `dno = 4` og se på de med `age > 50`.
        - Indeks på age:
          - Skann indeksen fra 50 og finn alle poster med `dno = 4`.
        - Velger den som er mest selektivt: `dno` (avdelingsnr).
          - Selektiv = den som filtrerer vekk flest poster.
        - Bruker leksikalsk sortering.

[//]: # "                         #######  ##     ## ######## ########  ##    ##"
[//]: # "                        ##     ## ##     ## ##       ##     ##  ##  ##"
[//]: # "                        ##     ## ##     ## ##       ##     ##   ####"
[//]: # "                        ##     ## ##     ## ######   ########     ##    #######"
[//]: # "                        ##  ## ## ##     ## ##       ##   ##      ##"
[//]: # "                        ##    ##  ##     ## ##       ##    ##     ##"
[//]: # "                         ##### ##  #######  ######## ##     ##    ##"
[//]: # "########  ########   #######   ######  ########  ######   ######  ######## ########  #### ##    ##  ######"
[//]: # "##     ## ##     ## ##     ## ##    ## ##       ##    ## ##    ## ##       ##     ##  ##  ###   ## ##    ##"
[//]: # "##     ## ##     ## ##     ## ##       ##       ##       ##       ##       ##     ##  ##  ####  ## ##"
[//]: # "########  ########  ##     ##  ######  ######    ######   ######  ######   ########   ##  ## ## ## ##   ####"
[//]: # "##        ##   ##   ##     ##       ## ##             ##       ## ##       ##   ##    ##  ##  #### ##    ##"
[//]: # "##        ##    ##  ##     ## ##    ## ##       ##    ## ##    ## ##       ##    ##   ##  ##   ### ##    ##"
[//]: # "##        ##     ##  #######   ######  ########  ######   ######  ######## ##     ## #### ##    ##  ######"

### Forelesning 18: (uke 13) – 27/3 Queryprosessering. Kap. 18

#### Queryprosessering/optimalisering:
  - Intro/oversetting
  - Flettesortering
  - Seleksjon
  - Join

1. Algoritmer for queryprosessering og optimalisering (18)
<pre>
JDBC/SQL

+----------------+      +-------------+
| SQL-kompilator | <--- | SQL-katalog |
+----------------+      +-------------+
        | Alg.         /
        v            v/
   +--------------------+      +------------+
   | Queryoptimalisator | <--- | Statistikk |
   +--------------------+      +------------+
              | Alg./utførelsesplan
              v
          +-------+
          | Utfør | Her velges en passende alg.
          +-------+

Optimalisering:
  - Regelbasert.
  - Kostnadsbasert optimalisering.
</pre>

2. Teknikker for å utføre relasjonsalgebraoperatorer (18.3)
    - Indeksering: Bruker `WHERE`-utrykket til å trekke ut små mengder poster. (Spesielt for seleksjon.)
    - Iterasjon: Skanner tabellen.
    - Partisjonering: Sortere/hashe input. => Operasjoner på mindre datamengder.

3. Statistikk om data
    - For hver taell: #rader, #blokker.
    - For hver indeks: #nøkkelverdier, #blokker, histogrammer
    - For hvert B+-tre: Trehøyde, lowkey, highkey

4. Aksessvei / Access path (18.3)
    - Måte å få tak i data.
      - Filskann
      - Indeks som matcher en seleksjon.
        - B+-tre-indeks på `<a, b, c>`
          - Matcher `a = 5 AND b = 3`
          - Matcher ikke `b = 3`
      - Hashindeks på `<a, b, c>`
        - Matcher `a = 5 AND b = 3 AND c = 2`
        - Matcher ikke `a = 5 AND b = 3 AND c > 2`

5. Oversetting SQL -> Algebra (18.1)
    - Er en fordel å dele opp spørringen for å dele opp dataene. Her er aggregering først:
<pre>
SELECT lname, fname
FROM Employee
WHERE Salery > (SELECT MAX(Salery) FROM Employee WHERE dno = 5)

T_(max(salery)) (G_dno=5 (Employee)) -> C
PI_(lname, fname) (G_(salery>C) (Employee))
</pre>

6. Flettesortering (18.2)
    - Sortering av store datamengder.
    - 2 faser.
    - Fase 1: Sorterer deler som får plass i RAM.
      - Antall deler: nᵣ
      - Antall blokker med data: b
      - Tilgj. buffer: nᵦ
      - Ex:
        - nᵦ, b = 1024
        - => nᵣ = ⌈b/nᵦ⌉
        - nᵣ = 205

[//]: # "######## ########     ###    ##    ##  ######     ###    ##    ##  ######        ##  #######  ##    ## ######## ########"
[//]: # "   ##    ##     ##   ## ##   ###   ## ##    ##   ## ##   ##   ##  ##    ##       ## ##     ## ###   ## ##       ##     ##"
[//]: # "   ##    ##     ##  ##   ##  ####  ## ##        ##   ##  ##  ##   ##             ## ##     ## ####  ## ##       ##     ##"
[//]: # "   ##    ########  ##     ## ## ## ##  ######  ##     ## #####     ######        ## ##     ## ## ## ## ######   ########"
[//]: # "   ##    ##   ##   ######### ##  ####       ## ######### ##  ##         ## ##    ## ##     ## ##  #### ##       ##   ##"
[//]: # "   ##    ##    ##  ##     ## ##   ### ##    ## ##     ## ##   ##  ##    ## ##    ## ##     ## ##   ### ##       ##    ##"
[//]: # "   ##    ##     ## ##     ## ##    ##  ######  ##     ## ##    ##  ######   ######   #######  ##    ## ######## ##     ##"

### Forelesning 19: (uke 13) – 28/3 Transaksjoner, teori. Kap. 20

### Forelesning 20: (uke 14) – 3/4 Transaksjoner, låser. Kap. 21

### Forelesning 21: (uke 14) – 4/4 Transaksjoner, recovery. Kap. 22

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
