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
          - `nᵦ = 5, b = 1024`
          - `=> nᵣ = ⌈b/nᵦ⌉`
          - `nᵣ = 205`
          - Vi har 205 sorterte delfiler.
          - Så flette de i fase 2.
      - Fase 2: Flette sammen sorterte delfiler.
        - Fra fase 1 har vi 205 sorterte delfiler.
        - Har `nᵦ = 5` tilgjengelige buffer => 4 input og 1 output.
        - Får etter fletting: 55 delfiler => 13 delfiler => 4 delfiler => 1 fil. (x / 4 input)
    - Flettegrad `dₘ`
      - Antall delfiler som kan flettes i hvert pass
        - `dₘ = nᵦ - 1 = 4`
        - Minus et siste for outputfil.
      - Flettepass: `⌈log_(dₘ)(nᵣ)⌉`
        - Ex:
          - `nᵦ = 5, dₘ = 4, nᵣ = 205`
          - `=> ⌈log₄(205)⌉ => ⌈3.84⌉ => 4`

7. Metoder for enkle seleksjoner (18.3.1)
    1. Lineært filskann.
    2. Bruk clusteres B+-tra eller hashindeks.
    3. Bruke sekundærindeks.

8. Eksempel på seleksjon
    - `SELECT * FROM Employee WHERE lname < 'C%'`
    - Antar 10% av lname tilfredstiller betingelsen.
    - Totalt 204800 poster.
    - 200 poster i en blokk.
    - 1024 blokker i heapfilen.
    - Metode 1: Filskann
      - 1024 I/O-er
    - Metode 2: B+-tre som postene (Clustered) sortert på lname
      - `10% * 1024 * 1.5 (blokker på løvnivå) = 154 I/O-er`
    - Metode 3: Heapfil + sekundærindeks:
      - a) Antar B+-tre er 10% av 1024 (Indeksposten er 10% av resten av posten)
        - `103 blokkaer * 10% = 11 blokker`
      - b) Men det er en \* der, ergo:
        - 204800 poster må hentes fra heapfil.
        - Potensielt like mange O/I-er som poster => 20480 I/O-er.
      - => a) + b) = 20491 I/O-er.

9. Metoder for utføring av join (18.3.2)
    - **J1: Nested-loop-join**
      - For hver blokk i den ene tabellen, skann den andre tabellen og se etter matcher.
      - Raskeste måten å gjøre det på.
    - **J2: Single-loop-join (index nested loop)**
      - Loope gjennom den ene tabellen, slå opp i en indeks for den andre.
    - **J3: Sort-merge-join**
      - Sorter tabellene på joinattributtene, så flett tabellene
      - Smart om den allerede er sortert på join-attr
    - **J4: Partition-hash-join**
      - Partisjonere inputargumentene på join-attr.
      - Probe/join
        - Les og join tilsvarende partisjoner fra de to tabellene.

10. Joineksempel
    - `Employee (_SSN_, fname, lname, salery, ..., dno)`
    - `Department (dname, _dnumber_, ...)`
    - `SELECT e.lname, e.salery FROM Employee e, Department d WHERE e.dno = d.dnumber AND d.name = 'Accounting'`
    - Info:
    - Department: 5000 poster lagret i 10 blokker.
    - Employee: 60000 poster lagret i 2000 blokker.
    - Minne: 7 blokker.
    - Regne på antall I/O-er for lesing.
      - J1 - nested loop:
        - 5 buffer til den ene tabellen.
        - 1 buffer til den andre.
        - 1 buffer til resultat.
        - Først leser inn halve Department tabellen (10 blokker) => 5 blokker.
        - Så kan vi lese inn en og en blokk fra den andre, som blir 2000 blokker fra Employee.
        - Gjør det 2 ganger fordi vi delte Department på 2.
        - `=> (5 + 2000) * 2 = 4010`
      - J3 - Sort-merge-join:
        - Antar de er usorterte.
        - Sorter Department:
          - Sort `b = 10, nᵦ = 7, nᵣ = ⌈10/7⌉ = 2 delfiler`
          - Merge: `dₘ = nᵦ - 1 = 6`
            - `=> ⌈log₆(2)⌉ = 1`
            - partisjonering + lese/skrive
            - `=> (2 * 10) + (2 * 10 * 1) = 40 I/O-er`
        - Sorter Employee:
          - `b = 2000, nᵦ = 7, nᵣ = ⌈2000/7⌉ = 286 delfiler`
          - Merge: `dₘ = nᵦ - 1 = 7`
            - `=> ⌈log₆(286)⌉ = 4`
            - (lese/skrive partisjonering) + (lese/skrive)
            - `=> (2 * 2000) + (2 * 2000 * 2) = 12000`
        - Join av sorterte filer: `10 + 2000 = 2010`
        - Totalt `40 + 12000 + 2010 = 14050` I/O-er.

[//]: # "######## ########     ###    ##    ##  ######     ###    ##    ##  ######        ##  #######  ##    ## ######## ########"
[//]: # "   ##    ##     ##   ## ##   ###   ## ##    ##   ## ##   ##   ##  ##    ##       ## ##     ## ###   ## ##       ##     ##"
[//]: # "   ##    ##     ##  ##   ##  ####  ## ##        ##   ##  ##  ##   ##             ## ##     ## ####  ## ##       ##     ##"
[//]: # "   ##    ########  ##     ## ## ## ##  ######  ##     ## #####     ######        ## ##     ## ## ## ## ######   ########"
[//]: # "   ##    ##   ##   ######### ##  ####       ## ######### ##  ##         ## ##    ## ##     ## ##  #### ##       ##   ##"
[//]: # "   ##    ##    ##  ##     ## ##   ### ##    ## ##     ## ##   ##  ##    ## ##    ## ##     ## ##   ### ##       ##    ##"
[//]: # "   ##    ##     ## ##     ## ##    ##  ######  ##     ## ##    ##  ######   ######   #######  ##    ## ######## ##     ##"

### Forelesning 19: (uke 13) – 28/3 Transaksjoner, teori. Kap. 20

1. Transaksjoner (20-22)
    - [Kap. 20](#forelesning-19-uke-13--283-transaksjoner-teori-kap-20)
      - Hvorfor vi har transaksjoner.
      - Transaksjoner og SQL
      - Transaksjoneteori
    - [Kap. 21](#forelesning-20-uke-14--34-transaksjoner-låser-kap-21)
      - Flerbrukerkontroll
      - Låsing
      - Multiversjonskontroll
    - [Kap. 22](#forelesning-21-uke-14--44-transaksjoner-recovery-kap-22)
      - Logging og recovery
      - Abortering av transaksjoner
      - Krasjrecovery

2. Hvorfor transaksjoner
    - Støtter deling og samtidig aksess.
    - Støtter sikker, atomisk akksess til store mengder data.

3. Databaseoperasjoner (20.1.2)
    - X - databaseobjekt post/blokk
    - read(x) => r(x)
    - write(x) => w(x)
    - Tilhørende en transaksjon 1.
    - read₁(x) => r₁(x)
    - commit₁ => c₁ => Avslutning av transaksjon 1 - alt gikk bra.
    - abort₁ => a₁ => Rollback

4. Samtidighetsproblemer, eksempel (20.1.3)
    - 2 transaksjoner:
      - T1: `BEGIN A = A + 100, B = B - 100 END` - (Overfører 100 til en annen konto)
      - T1: `BEGIN A = A * 1.06, B = B * 1.06 END` - (Legg til 6% rente til begge kontoer)
    - En mulig fletting:
      <pre>
      T1: A = A + 100                  B = B - 100
                      \              /             \
      T2:               A = A * 1.06                 B = B * 1.06
      </pre>
    - Annen mulig fletting (not good, bank taper):
      <pre>
      T1: A = A + 100                                B = B - 100
                      \                             /
      T2:               A = A * 1.06 -> B = B * 1.06
      </pre>
    - Historie (Schedule)
      - `T1: r(A), w(A) . . . . . . . . . . . . . r(B), w(B)`
      - `T2: . . . . . . . r(A), w(A), r(B), w(B)`
      - `=> r1(A), w1(A), r2(A), w2(A), r2(B), w2(B), r1(B), w1(B)`

5. Samtidighetsproblemer, klasser (20.1.3)
    - Dirty read:
      - `=> r1(A); w1(A); r2(A); w2(A); c2; r1(B); w(B); a1`
      - Lese før noen har committet.
    - Lost update:
      - `=> w1(A); w2(A); w2(B); c2; w1(B); c1`
      - Overskriver litt for tidlig.
    - Unrepeatable read:
      - `=> r1(A); r2(A); w2(A); c2; r1(A); w1(A); c1`
    - Incorrect summary:
      - En transaksjon beregner en aggregatfunksjon.
      - En annen gjør oppdateringer samtidig.
      - `=> w3(A); r3(A); w3(A); r1(X); w1(X); r3(X); r3(Y); r1(Y); w1(Y)`

6. Hvorfor trenger vi recovery? (20.x)
    - 2 typer recovery:
      1. En transaksjon aborterer (rollback)
      2. Nodekrasjrecovery (datamaskin krasjer)
          - Krever at databsesystemet må restartes.
    - Typer av feil:
      - Systemkrasj - Maskinvare eller programvare.
      - Brukerfeil - Manglende date eller feil i data.
      - Samtidighetskontroll - Andre queries ble utført samtidig.

7. ACID-egenskaper ved en transaksjon (20.3)
    - Transaksjon: En gruppering av operasjoner mot databasen.
    - A (Atomiske): Enten kjøres alle, ellers kjøres ingen.
    - C (Consistency): Transaksjon overholder konsistenskrav (PK, REFS, CHECK, ... -> [constraints]).
    - I (Isolation): Transaksjonene er isolert fra hverandre. Upåvirket av hverandre (kan merke ytelse, tho).
    - D (Durability): Permanente, dvs. de mistes ikke etter commit. Skriver til loggen når det skrives til disk.
    - => En transaksjon er vanligvis en logisk operasjon.

8. Commit/Abort (20.2.2-3)
    - En transaksjon slutter med
      - COMMIT => Alt gikk bra og endringene finnes i databasen.
        - I JDBC => `Connection.commit();`
      - ROLLBACK => Transaksjonen rulles tilbake og ingen endringer i transaksjonen fnnes i databasen.
        - JDBC => `Connection.rollback();`
      - Autocommit => Hver SQL-setning er en egen transaksjon.
        - Kan skru av at det er default i JDBC. Så hver ";" vil commite om du ikke endrer det som i eksempelet under.
        - JDBC: `Connection.SetAutoCommit(false);`
        - Ex:
          - `SET AUTOCOMMIT OFF;`
          - `UPDATE Account SET b = b - 1000 WHERE aid = x;`
          - `UPDATE Account SET b = b + 1000 WHERE aid = x;`
          - `COMMIT;`
      - Ex2: EKT
        - `INSERT INTO Reg VALUES (1, 123123, 31, 100);`
        - `INSERT INTO Reg VALUES (2, 123123, 32, 120);`
        - `UPDATE Løper SET Status = 'ok' WHERE brikker = 123123;`
        - `COMMIT;`

9. SQLs isolasjonsnivå (20.6)
    - `SET TRANSACTION ISOLATION LEVEL`
      - `| READ UNCOMMITTED`
      - `| READ COMMITTED`
      - `| REPEATABLE READ`
      - `v SERIALIZEABLE (default);`
      - Mer isolasjon nedover, men får mer detaljert om du går høyere.
    - Grunner til å bruke dette:
      - Dirty read.
      - Unrepeatable read.
      - Unngå fantomer:
        - Hvis T leser en mengde verdier basert på en søkebetingelse, så vil ikke denne mengden endre seg før T er ferdig.
    - Tabell med fordeler/ulemper med de forskjellige nivåene:

      | Nivå | Dirty read | Unrepeatable read | Har fantomer
      |:--- |:---:|:---:|:---:
      | READ UNCOMMITTED | JA | JA | JA
      | READ COMMITTED | NEI | JA | JA
      | REPEATABLE READ | NEI | NEI | JA
      | SERIALIZEABLE | NEI | NEI | NEI

10. Transaksjonshistorie (20.4.1)
    - Historie (schedule)
    - Ex:
      - a) `r1(X); r2(X); w1(X); r1(Y); w2(X); w1(Y);`
      - b) `r1(X); w1(X); r2(X); w2(X); r1(Y); a1`
      - c) `w3(A); r3(A); w3(A); r1(X); w1(X); r3(X); r3(Y); r1(Y); w1(Y);`
    - Konflikt:
      - To aksjoner fra en historie er i konflikt hvis;
        1. De tilhører forskjellige transaksjoner og
        2. De bruker det samme dataelementet og
        3. Minst en av aksjonene er en write.
      - Ex (fra over):
        - a)
          - `r2(X) og w1(X) - kollisjon/konflikt.`
          - `r2(X) og w2(X) - kollisjon/konflikt.`
          - `r1(X) og r2(X) - ikke kollisjon.`
      - To aksjoner er i konflikt hvis endringen av rekkefølgen endrer resultatet i databasen.

### Forelesning 20: (uke 14) – 3/4 Transaksjoner, låser. Kap. 21

- Transaksjonsteori:
  - Gjenopprettbarhet
  - Serialiserbarhet
- Låsing
- Vranglås
- Multiversjonssamtidighetskontroll

11. Historier og gjenopprettbarhet (20.4.2)
    - **Gjenopprettbar historie** (recoverable schedule)
      - Hver transaksjon committer etter at transaksjoner de har lest fra har committed. Ex:
        - `H1: w2(A); w1(B); w1(B); w1(A); r2(B); c1; c2;` (Gjenopprettbar)
        - `H2: w2(A); w1(B); w1(B); w1(A); r2(B); c2; c1;` (Ikke gjenopprettbar)
    - Historier som unngår gallopperende abort (**ACA** - avoid cascading abort)
      - Kan kun lese verdier som er committed. Ex:
        - `H1: w1(A); w1(B); w2(A); c1; r2(B); c2;` (ACA)
        - `H2: w1(A); w1(B); w2(A); r2(B); c1; c2;` (Ikke ACA)
    - **Strikt historie**:
      - Når transaksjoner verken kan lese eller skrive ikke-committede verdier.
        - `H1: w1(A); w1(B); w2(A); c1; r2(B); c2;` (ikke strikt)
        - `H2: w1(A); w1(B); w2(B); c1; w2(A); c2;` (strikt)
      - Fordel: Kan gjøre UNDO recoverage ved before image (se i loggen fra tidligere).
    - Sammenheng: Strikt ⋸ ACA ⋸ Gjenopprettbar (⋸ => is in).
    - Ex:
      - `H1: r1(A); w1(A); r1(A); w2(A); c2; c1;` => (Ikke gjenopprettbar)
      - `H2: r1(A); w1(A); c1; r2(A); w2(A); c2;` => (Strikt)
      - `H3: r1(A); w1(A); r2(A); w2(A); c1; c2;` => (Gjenopprettbar - fordi vi leser en verdi som er skrevet av en annen transaksjon)
      - `H4: r2(A); w2(B); w1(B); c2; r1(A); c1;` => (ACA - fordi w1(B) skriver før w2(B) har committa)

12. Historier og serialiserbarhet (20.5.1)
    - Seriell historie:
      - En historie som ikke fletter operasjoner fra forskjellige transaksjoner.
    - Serialiserbare historie:
      - En historie som har samme effekti på databasen som en seriell historie.
      - Ergo: Samme effektiv som om de kjørte etterhverandre - selv om de kjører i parallell.
    - Hvorfor ønsker vi serialiserbarhet?
      - Fordi vi øsnker å tillate samtidighet.
        1. Parallell - fordi alle datamaskiner bruker for det meste parallellitet.
        2. Kan være mye diskaksess - så da kan andre transaksjoner jobbe når disken aksesseres.

13. Konfliktserialiserbarhet (20.5.1)
    - Konflikt mellom 2 operasjoner:
      - En leser og den andre skriver.
      - Begge skriver.
    - Konfliktekvivalens:
      - 2 historier er konfliktekvivalente hvis de kan bli like ved å bytte plass (rekkefølge) for operasjoner som ikke er i konflikt.
    - Konfliktserialiserbar:
      - En historier er konfliktserialiserbar hvis den er konfliktekvivalent med en seriell historie.
    - Konfliktserialiserbarhet impliserer serialiserbarhet, men ikke nødvendigvis motsatt.

14. Presidensgrafer (20.5.2)
    - Rettet graf.
    - Nodene er transaksjoner i en historie.
    - Kantene er operasjonene:
      - T1 -> T2 når det finnes en operasjon i T1 som er i koflikt med en i T2, og T1 sin operasjon skjer før T2 sin operasjon.
    - Hvis en presedensgraf ikke har sykler, er historien konfliktserialiserbar.

15. Serialiserbarhet ved låsing (21.1.1)
    - Bruker låser av dataelement (post eller blokk) for å garantere konfliktserialiserbarhet.
    - Låsertyper:
      - Delt lås (leselås)
      - Ekslusiv lås (skrivelås)

16. Implementasjon av låser (21.1.1)
    - Fungerer ved:
      - Du har en låsetabell i minnet - raskt tilgjengelig.
      - Kan ha:
        - Postlåser.
        - Blokklåser.
        - Tabellåser.
        - Verdiområdelåser (rangelock).
        - Predikatlås (I where clause i SQL).
    - Er ikke viktig å lagre de siden de er enkle å gjenskape.

17. 2PL - Tofaselåsing (21.1.2)
    - En transaksjon har tofaselåsing hvis alle låseoperasjoner skjer før opplåsningsoperasjonen.
    - Tofaselåsing impliserer serialiserbarhet.
    - 4 former for faselåsing:
      1. Basic 2PL. Låser ved behov. `/\`
      2. Konservativ 2PL. Låser alt før man gjør noe som helst. Må vite eksakt hva som skal låses. `|\`
      3. Strikt 2PL. Deler låsingen i 2 faser. `/^|`
      4. Rigorous 2PL. Låser når den trenger ting, så slippe alt i et tidspunkt (med commit/abort). `/|`

18. Vranglås (21.1.3)
    - 2 eller flere transaksjoner venter gjensidig på hverandres låser.
    - Kan løses med 3 forskjellige strategier:
      1. Unngåelse (Ikke viktig for pensum).
      2. Oppdagelse.
      3. Bruke en timeout.

19. Vranglåsoppdagelse (21.1.3)
    - Vanligste løsningen.
    - Konstruerer en wait-for-graph.
      - Hver transaksjon er en node.
      - Hvis transaksjon T1 venter på en lås holdt av T2 får vi en rettet kant T1 -> T2.
      - Har en vranglås om det er en sykel i den grafen.
      - Prøv å abortere en transaksjon og se om sykelen forsvinner.

20. Timeout (21.1.3)
    - Enkleste løsningen.
    - Lar hver transaksjon har en timeout.
    - Hvis timeouten går, aborteres transaksjonen.
    - Vanskeig å sette timeouten.

21. Hvorfor recovery (22)
    - Databasesystemet støtter sikker, atomisk aksess til store mengder data.
    - Transaksjoner har 4 egenskaper: ACID.
      - A: Atomisk: Enten kjører alt eller ingenting.
      - D: Durable: Er permanente. Ved commit mistes ikke data.

22. Transaksjoner etter recovery (22)
    <pre>
    -------------------------------> Tid
    T1  |----|
    T2     |----|
    T3        |----| (<- Fullførte = vinner)
    T4          |------------------> (Aner ikke hva som skulle skje her = taper)
    T5              |-------------->

    { T1, T2, T3 } - skal være permanente (vinnere)
    { T4, T5 } - skal aborteres (tapere)
    </pre>

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
