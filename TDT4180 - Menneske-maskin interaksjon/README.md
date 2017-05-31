# TDT4180 - Menneske-maskin interaksjon

[//]: # "########  ######## ##    ##  ######  ##     ## ##     ##"
[//]: # "##     ## ##       ###   ## ##    ## ##     ## ###   ###"
[//]: # "##     ## ##       ####  ## ##       ##     ## #### ####"
[//]: # "########  ######   ## ## ##  ######  ##     ## ## ### ##"
[//]: # "##        ##       ##  ####       ## ##     ## ##     ##"
[//]: # "##        ##       ##   ### ##    ## ##     ## ##     ##"
[//]: # "##        ######## ##    ##  ######   #######  ##     ##"

## Pensum
- [Introduksjon til begreper, prinsipper og praksis for konstruksjon av brukervennlige menneske-maskingrensesnitt](#forelesning-1-1301)
  - Begreper:
    - [Brukskvalitet (usability)](#brukskvalitet)
      - [ISO 9241-11](#iso-9241-11-1998)
    - [Brukersentrert design (user-centered design)](#brukersentrert-design)
      - [ISO 9241-210](#iso-9241-210)
    - [Usability](#usability)
    - [Context of use](#context-of-use)
    - [Beyond usability](#beyond-usability)
    - [TAM](#tam-technology-acceptance-model)
  - Prinsipper:
    - Don Norman ("Design of everyday things")
      - [Visibility (Kan jeg se det?)](#visibility)
      - [Affordable (Hvordan brukes det?)](#affordable)
      - [Constraints (Hvorfor funker ikke dette?)](#constraints)
      - [Feedback (Hva skjer nå?)](#feedback)
      - [Mapping (Sammenhenger? Hva fører til hva?)](#mapping)
      - [Consistency (Sett dette før?)](#consistency)
    - [Universell utforming](#universell-utforming)
    - [Ubiquitous computing (UbiComp)](#ubiquitous-computing-ubicomp)
    - [Interaksjonsteknikker](#interaksjonsteknikker)
- [Oppgaveanalyse]()
- [Feltstudie-teknikker]()
- [Scenariebygging]()
- [Iterative designmetoder]()
- [Brukbarhetstesting](#brukernære-metoder-i-systemutvikling)
- [Mentale modeller](#konseptuelle--og-mentale-modeller)
- [Metaforbruk](#metaforer)
- [Gestaltprinsipper for visuell komposisjon](#gestalt)
- [Empiriske og formelle evalueringsmetoder]()
- [Dialogteknikker]()
- [Prototypingsteknikker]()
- [ISO standarder om brukskvalitet (spesielt ISO 9241-11 og ISO 9241-210)](#iso-9241-11-1998)
- [Innføring i vindussystemer]()

[//]: # "########  #######  ########  ######## ##       ########  ######  ##    ## #### ##    ##  ######   ######## ########"
[//]: # "##       ##     ## ##     ## ##       ##       ##       ##    ## ###   ##  ##  ###   ## ##    ##  ##       ##     ##"
[//]: # "##       ##     ## ##     ## ##       ##       ##       ##       ####  ##  ##  ####  ## ##        ##       ##     ##"
[//]: # "######   ##     ## ########  ######   ##       ######    ######  ## ## ##  ##  ## ## ## ##   #### ######   ########"
[//]: # "##       ##     ## ##   ##   ##       ##       ##             ## ##  ####  ##  ##  #### ##    ##  ##       ##   ##"
[//]: # "##       ##     ## ##    ##  ##       ##       ##       ##    ## ##   ###  ##  ##   ### ##    ##  ##       ##    ##"
[//]: # "##        #######  ##     ## ######## ######## ########  ######  ##    ## #### ##    ##  ######   ######## ##     ##"

## Forelesninger
- [Forelesning 1: (13.01)](#forelesning-1-1301)
- [Forelesning 2: (18.01)](#forelesning-2-1801)
- [Forelesning 2.5: (20.01)](#forelesning-25-2001)
- [Forelesning 3: (25.01)](#forelesning-3-2501)
- [Forelesning 3.5: (27.01)](#forelesning-35-2701)
- [Forelesning 4: (01.02)](#forelesning-4-0102)
- [Forelesning 4.5: (03.02)](#forelesning-45-0302)
- [Forelesning 5: (08.02)](#forelesning-5-0802)
- [Forelesning 5.5: (10.02)](#forelesning-55-1002)
- [Forelesning 6: (17.02)](#forelesning-6-1702)
- [Forelesning 7: (24.02)](#forelesning-7-2402)
- [Forelesning 8: (03.03)](#forelesning-8-0303)
- [Forelesning 9: (10.03)](#forelesning-9-1003)
- [Forelesning 10: (17.03)](#forelesning-10-1703)
- [Forelesning 11: (24.03)](#forelesning-11-2403)
- [Forelesning 12: (31.03)](#forelesning-12-3103)
- [Forelesning 13: (07.04)](#forelesning-13-0704)
- [Forelesning 14: (14.04)](#forelesning-14-1404)

[//]: # "########   ##"
[//]: # "##       ####"
[//]: # "##         ##"
[//]: # "######     ##"
[//]: # "##         ##"
[//]: # "##         ##"
[//]: # "##       ######"

### Forelesning 1: (13.01)

#### Opplegg:
- 5 eller 6 Øvinger (5 på planen).
  - 2 første om teknikkdel (Hallvard).
  - Resterende er om design-del (Yngve).
- Delt opp i Design (Pensum til eksamen) og kontruksjon (Ikke relevant, enda).

#### Brukskvalitet
- (Også omtalt som brukervennelighet):
- Kvalitet:
  - Evalueringkriterier - hvordan vurdere kvalitet.
    - 4 C'er for diamanter:
      - Cut
      - Carat
      - Color
      - Clarity
    - Skihopper:
      - Lengde
      - Stil
    - Dataspill:
      - Sjanger
      - Historie
      - Kontroll
      - ...
- Eksempelvis vurderes mange mobiler ut ifra brukervennelighet.
- Hva er brukervennelighet? Ifølge Jacob Nilsen (1993)
  - System acceptability
    - Social acceptability
    - Practical acceptability
      - Cost
      - Compability
      - Reliability
      - Etc.
      - Usefulness
        - Utility
        - #### **Usability**
          - (Også kalt brukervennelighet, brukbarhet og brukskvalitet)
          - Easy to learm
          - Efficient to use
          - Easy to remember
          - Few errors
          - Subjectively pleasing
- #### ISO 9241-11 (1998):
  - Beskriver *hva* brukskvalitet er.
  - Anvendbarhet:
    - Grad av *nøyaktighet og kompletthet*.
    - Klarer brukeren å løse oppgaven?
  - Effektivitet:
    - *Ressursforbruk* i forhold til kompletthet.
    - Hvor mye tid brukes for å fremstille løsningen?
  - Tilfredstillelse:
    - *Subjektiv* opplevelse av designløsnngens egenhet.
    - Hvordan oppleves og beskrives designløsningen av brukerne?
- Jacob Nielsen (1993):
  - Grunnlagt mye teori bak brukskvalitet.
- #### "Context of use":
  - Venndiagramm (Hvor alle overlapper hverandre):
    - Brukere
      - Hvem er brukerne av designløsningen?
    - Oppgaver
      - Hva ønsker de å bruke den til?
    - Omgivelser
      - Hvor skal den brukes?
- #### "Beyond usability"
  - Nytteverdi
  - Brukeropplevelse (UX)
- #### TAM (Technology Acceptance Model):
  - Oppfattet brukervennelighet. = B
  - Oppfattet nytte. = N
  - Holding til bruk. = H
  - Intensjon om å bruke. = I
  - Faktisk systembruk. = S
  - Graf:
    - N => B, H
    - B => H, I
    - H => I
    - I => S
  - Aksept = Nytte + Brukervennlighet
- Introduksjon til brukersentrert design

#### Brukersentrert design:
- Brukeropplevelsen (UX)
#### ISO 9241-210:
- Beskriver **hvordan* en går frem for å lage produkter, tjenester og systemer med høy brukskvalitet.
- Viktig å involvere brukeren:
  - Vi må kommunisere.
  - Brukeren burde opplyses om hva som er mulig.
- 2010
- *Human-centered design of interactive systems*
  - En brukersentrert designprosess har typisk:
    - Aktiv involvering av brukere.
    - Klar forståelse av brukere og oppgavene.
    - En iterativ prosess.
    - Tverrfaglige utviklingsteam.
  - Sterkt fokus på at utvikler må forstå og kunne formulere produktets "brukssammenheng" [context og use](#context-of-use)
  - Fokus på kommunikasjon med bruker gjennom f.eks. *konkrete* typer.
- Den brukersentrerte design prosessen:
<pre>
+-------------------------+
| Plan the human centered |
|     design process      |
+-------------------------+
            |
            v
+------------------------+               +-------------------------------+
| Understand and specify | ------------> | Specify the user requirements |
|  the context of use    |               +-------------------------------+
+------------------------+                       ^      |
          ^                                     /       |
           \ Iterate, where appropriate        /        |
            + - - - - - - - - - - - - - - - - +         |
            |                                  \        |
            |                                   v       v
+----------------------+                 +-----------------------------+
| Evaluate the designs |                 | Produce design solutions to |
| against requirements | <-------------- |    meet user requirements   |
+----------------------+                 +-----------------------------+
            |
            v
/-------------------------\
| Designed solution meets |
|    user requirements    |
\-------------------------/
</pre>
#### Iterativt design:
  - Kom sammen med skjermer og grafikk.
  - Begynte å utvikle med fossafalls-metode og se et behov for det.
  - Metode (som i modellen over):
    - +--> Analyse -> Prototyping -> Evaluering --+
    - +-------------------------------------------+
  - Skape valg, lage problemer, vil divergere (åpne).
  - Ta valg, finne løsningner, vil konvergere (lukke).
    - Løsning kommer gjerne til slutt da det bare er et valg igjen.
  - Feilrate:
    - Synker etterhvert med flere iterasjoner.
      - Fra rundt 50% - under 10% i 5 iterasjon.

Relevant litteratur: ISO 9241-11, ISO 9241-210, læreboka kap. 1.

[//]: # "########  #######"
[//]: # "##       ##     ##"
[//]: # "##              ##"
[//]: # "######    #######"
[//]: # "##       ##"
[//]: # "##       ##"
[//]: # "##       #########"

### Forelesning 2: (18.01)

- Representasjon av GUI-innhold
  - MVC
    - Model
      - Datastrukturen som brukes i bakgrunnen av applikasjoner. Gjerne som en database.
    - View
      - Visningen av data på et display. Mye utregning med matriser før det vises her.
    - Controller
      - Den delen som styrer hva som skal vises hvor i View fra Modell.
  - 3 lags:
    - UI
      - View og Controller.
    - Modell
      - Fungerer som et lim.
    - Persistent
- Scene graph-konseptet og grafikk i JavaFX og FXML
  - Ligner på web-programmering. HTML <=> FXML. CSS <=> CSS i JavaFX.
  - Veldig populært blant designere å bruke komponenter for å tegne grafikk.

[//]: # "########  #######      ########"
[//]: # "##       ##     ##     ##"
[//]: # "##              ##     ##"
[//]: # "######    #######      #######"
[//]: # "##       ##                  ##"
[//]: # "##       ##        ### ##    ##"
[//]: # "##       ######### ###  ######"

### Forelesning 2.5: (20.01)

#### MMI-historikk
  - Mainframes (1960 - 1985) - First wave
    - Mange brukere, en datamaskin.
  - Personal computing (1985 - 2000) - Second wave
    - En bruker, en datamaskin.
  - Ubiquitous computing (2000 - ) - Third wave
    - En bruker, mange datamaskiner.
  - Historie:
    - ENIAC, UNIVAC.
      - Nye yrkesgrupper.
        - Programmerere, elektronikkeksperter og matematikere.
    - 1973
      - Alto, med grafikk, tastatur, skjerm.
    - 1980
      - Xerox Star. Navn som skrivebord, mapper, ikon.
        - Nye yrkesgrupper.
          - Programmerere, psykologer og designere.
      - Lite brukerfokus.
    - 1984
      - Apple: Macintosh. og MS med PC.

#### Anvendelse av GUI komponenter
- Typer elementer:
  - Input
  - Navigasjon
  - Info
  - Konteinere
- Viktig med luft rundt for å skape grupper.
- Oppsummering:
  - Følg konvensjonene for bruk av kontrollelementer.
  - Vær konsistent.
  - Less is more!
  - Test brukergrensesnittet.

[//]: # "########  #######"
[//]: # "##       ##     ##"
[//]: # "##              ##"
[//]: # "######    #######"
[//]: # "##              ##"
[//]: # "##       ##     ##"
[//]: # "##        #######"

### Forelesning 3: (25.01)

- Interaktivitet med JavaFX og FXML og SceneBuilder
  - UI
    - Sammenlignbart med
      - at U går gjennom V -> C -> M -> C -> V
      - og I går gjennom V -> C -> V
- Controller-klasser

[//]: # "########  #######      ########"
[//]: # "##       ##     ##     ##"
[//]: # "##              ##     ##"
[//]: # "######    #######      #######"
[//]: # "##              ##           ##"
[//]: # "##       ##     ## ### ##    ##"
[//]: # "##        #######  ###  ######"

### Forelesning 3.5: (27.01)

#### Flere typer designkunnskap
  - Konvensjoner
    - Regler for bruk av elementer (Checkbox for avkryssning).
    - Hvordan håndtere interaksjoner fra bruker (F.eks. swipe for å scrolle).
  - Designprinsipper/guidelines
    - Basert på erfaring, kunnskap og sunn fornuft.
    - Kan være vanskelig å operasjonalisere.
  - Teorier
    - F.eks. konseptuelle og mentale modeller.

#### Hvorfor designprinsipper?
  - Generalisere - slik at man kan samarbeide og bygge gode regler, sammen.
  - Bra for:
    - [Consistency](#consistency)
    - Blikkfang
    - Forenkling
  - Det fungerer som en sjekkliste.
    - Som reduserer designiterasjoner, og kostnader i form av tid og penger.
  - Lenker til lister med designretningslinjer:
    - [Jacob Nielsen](https://www.nngroup.com/articles/ten-usability-heuristics/)
    - [Ben Shneiderman](https://www.cs.umd.edu/users/ben/goldenrules.html)
    - [Bruce Togazzinis](http://asktog.com/atc/principles-of-interaction-design/)
    - [Universell Design](http://universaldesign.ie/What-is-Universal-Design/The-7-Principles/)
    - [WCAG 2.0](https://www.w3.org/Translations/WCAG20-no/#guidelines)

#### Designretningslinjer
- Nødvendig å teste om man følger retningelinjene? JA! De er bare en kravspekk. Den er ikke spesialiser for alle.
- Prinsipper:
  - Don Normans's "Design of everyday things"
    - #### **Visibility**
      - => Kan jeg se det?
      - Mer synlig funksjon => Enklere vil brukeren bruke funksjonen. Lettere mål til aksjon. Lettere å se tilstand.
      - Eksempel:
        - Automatisk vannkran.
          - Hvor skal man putte hendene?
          - Hvordan slå på vannet?
    - #### **Affordable**
      - => Hvordan kan jeg bruke det?
      - Hvilken handling en gjenstand signaliserer. Hva forteller formen?
      - Kommer fra psykologi (1977).
      - Mulige aksjonen en omgivelse tilbyr en aktør.
      - Perceived affordance (hva oppfatter en aktør at han skal gjøre):
        - Grafiske grensesnitt har ikke "real affordance" - de er visuelle.
        - Viktig at GUI har aksjoner som kan kobles til den virkelige verden.
      - False affordance (feller):
        - Labels som ser ut som knapper.
      - Matrise:
        <pre>
        P | A |
        1 | 1 | False affordance
        1 | 0 | Perceived affordance
        0 | 1 | Correct Rejection
        0 | 0 | Hidden affordance
        </pre>
      - Eksempel:
        - En hanske.
        - Ser at man skal putte hånda i den.
    - #### **Constraints**
      - => Hvorfor kan jeg ikke gjøre slik?
      - Signaliserer begrensninger i forhold til handlinger.
      - Henger sammen med affordance. Affordance tilbyr ulike måter å bruke det. Constraints tilbyr litt mer hva vi gjør til vanlig pga. kultur eller noe.
        - F.eks: Noe blir rødt. Forbinder det med stopp eller fare.
        - Å snakke i mobil i forelesning.
        - Henger sammen med f.eks. en dør som er flat og bare kan pushes fra den ene siden. På den andre siden kan den pulles. Det sier både hva den må fungere og har en begrensning.
        - Trinnbasert oppsett av mail.
          - Kan ikke gå videre om man har gjort noe feil eller mangler noe.
    - #### **Feedback**
      - => Hva skjer nå?
      - Info til brukeren om hvilke handlinger som har blitt utført.
      - Forteller også om hvilken tilstand systemet har.
      - Gyldige handlinger skal alltid gi feedback. (Mener personlig at også ikke godkjente skal gi feedback).
      - Eksempeler:
        - Knapper forandrer ramme.
        - Ratt gir motstand om man svinger.
        - Knapper lager lyd.
      - Ulike typer:
        - Visuell.
        - Auditiv.
        - Taktil. Mostand eller vibrasjon.
        - Kombinasjon av de over.
    - #### **Mapping**
      - => Er det en naturlig sammenheng mellom kontrollen og effekt?
      - Overføring av design til den virkelige verden.
      - Eksempel:
        - Volumkontroll med vri-knapp:
          - Med klokken -> Høyere volum
          - Mot klokken -> Mindre volum
      - Natual mapping:
        - Layout på kontroll tilsvarer layout på apparat.
        - Sammenheng mellom interaksjon og effekt.
      - Omvendt av natural:
        - Volumknapp med + neders og - øverst.
      - Poor mapping:
        - Stekeplater:
          - Kan legge knapper på en linje med like lang avstand.
          - Bedre med å samle 2 av de for å se hvilken side de tilhører.
          - Beste er å legge de i samme form som platene (i en miniversjon).
            - Det blir nå natual mapping.
    - #### **Consistency**
      - => Har jeg ikke sett dette før?
      - Elementer som ser like ut bør ha samme funksjon.

#### Jacob Nielsens 10 brukbarhets-heuristikker
- **Visibility of system status**
  - Alltid tilbakemelding - så brukeren vet statusen til systemet.
- **Match between system and the real world**
  - Vis bilder, illustrer for å kommunisere med brukeren på best mulig måte.
  - Bruk kjente begreper og metaforer som er vanlige.
- **User control and freedom**
  - La brukeren ha kontroll.
  - Ha angre-muligheter på alle nivåer.
- **Consistency and standards**
  - Konsistens i grensesnitt
  - Følg retningslinjene til platformen du bruker (iOS, Windows) - for [consistency](#consistency).
  - Store bedrifter pleier f.eks. å ha designguidlines for logo og bruk av deres produkt.
- **Error prevention**
  - Bedre å unngå feil enn å måtte fikse feilene senere.
  - Fleksibilitet. Kan være folk skriver addressen forskjellig om det bare er et skrivefelt.
- **Recognition rather than recall**
  - La brukeren få se mest mulig av relevant info.
    - Vis font, om man skal velge font.
    - Vis meny fra tidligere, om man skal dypere inn i den.
  - Brukeren er dum.
- **Flexibility and efficiency of use**
  - Ha snarveier til mer erfarne brukere. De vil da bli mer effektive.
  - Copy/Paste er en ganske standard snarvei.
- **Aesthetic and minimalist design**
  - Viktig med fokus på kun det viktigste.
- **Help users recognize, diagnose, and recover from errors**
  - Hjelp brukeren å unngå feil - som i auto-fullføring på tekstfelt.
  - Hjelp med å håndtere feil - som å detektere og komme med forslag.
- **Help and documentation**
  - Lag et godt system for å finne hjelp. Forum, manual, toot tips, etc.
  - Helst lavterskel.

#### Universell utforming
- Lage systemer som kan brukes av flest mulig i målgruppen.
- Gjelder å være kreativ med blinde, de med lesevansker, osv.
- "Design for all".
- Etisk basis.
- Definert i [WCAG 2.0](#hvorfor-designprinsipper).
- Bygger på en forståelse av funksjonshemming som *relasjonell*.
- Funksjonshemming oppstår når der ikke er samsvar med en persons funksjonsevner og krevene omgivelsene stiller.
  - Dårlig design skaper funksjonehemming.
  - Det er ikke personen som skaper funksjonshemningene.
- **Menneskelig mangfold**
  - Forskjellige fysiske evner, kognitive evner og senseevner.
  - Barn, voksne og eldre.
  - Frisk, skadet og syk.
  - Mann og kvinne.
  - Ulike kropper.
- **7 Prinsipper for universell utforming**
  1. Like muligheter for bruk
      - Brukelig for personer med ulike ferdigheter.
      - Like muligheter - ihvertfall oppnå det samme, selv om noen må bruke lengre tid.
      - Privatliv skal være mulig.
      - Ex: Automatiske skyvedører.
  2. Fleksibel i bruk
      - Kunne tåle mange variasjoner av ferdigheter.
      - Løses gjerne med flere muligheter for å oppnå det samme.
      - Ex: En saks for både høyre og ventre hånds personer.
  3. Enkel og intuitiv bruk
      - Eliminere unødig kompleksitet.
      - Få brukeren til å kunne anta på en enkel måte - intuitivt.
      - Vise hva som er viktig - fokus.
      - Ex: Bruke bilder i manualer.
  4. Forståelig informasjon
      - Maksimere lesbarhet av essensiell informasjon.
      - Ex: Skjermer på en flyplass for å vise informasjon om gates og tider.
  5. Toleranse for feil
      - Sørge for advarsler om bruker gjør feil.
      - Vær mest mulig feilsikker.
      - Ex: Undo knapper og trådløse RFID-skannere som bare trenger et kort i nærheten - ikke i en posisjon.
  6. Lav fysisk anstrengelse
      - Færrest mulig handlinger.
      - Ex: Vask, som detekterer av seg selv, og lamper som kan skru seg på når noen er i rommet.
  7. Større og plass for tilgang og bruk
      - Gjøre det mulig for alle brukere å kunne bruke systemet.
      - Både høye og lave skal kunne bruke det.
      - Ex: Billettautomat på tog med lave skjermer.

- **Øvinger:**
  - Øving 1
  - Øving 2

[//]: # "######## ##"
[//]: # "##       ##    ##"
[//]: # "##       ##    ##"
[//]: # "######   ##    ##"
[//]: # "##       #########"
[//]: # "##             ##"
[//]: # "##             ##"

### Forelesning 4: (01.02)

- Data-orienterte komponenter og interaktivitet
- Mer om Controller-klasser.

[//]: # "######## ##            ########"
[//]: # "##       ##    ##      ##"
[//]: # "##       ##    ##      ##"
[//]: # "######   ##    ##      #######"
[//]: # "##       #########           ##"
[//]: # "##             ##  ### ##    ##"
[//]: # "##             ##  ###  ######"

### Forelesning 4.5: (03.02)

- #### Gestalt
  - Meningsfull helhet.
  - Prinsipper:
    - **Likhet.**
      - Like farger og former sees sammen.
    - **Nærhet.**
      - Elementer som står nær hverandre oppfattes som samhørende.
      - I GUI kan dette være formelementer som grupperes slik at de omhandler den samme informasjonen.
    - **Mental komplettering.**
      - Vi oppfatter lukkede eller sluttede former. Slik som når 2 streker fullfører et hjørne - selv om hjørnet ikke er synlig.
      - I GUI pleier man å lage silhuetter slik at man danner former med det tomme rom.
    - **Kontinuitet.**
      - Linjer fortsetter i den retningen de avbrytes. Er nesten det samme som mental komplettering.
      - Om du har en halv-sirkel vet du at den vil fullføre en sirkel.
    - **Helhet. Forgrunn/bakgrunn.**
      - Vi oppfatter raskt om noe er forgrunn eller bakgrunn.
      - Farge, kontrast, rammer, størrelse og perspektiv påvirker hva som er bakgrunn og forgrunn.
      - I GUI kan det være vindu-prinsippet til Windows og forsåvidt alle andre OS. Legger på skygge for å heve ut.
- #### Konseptuelle- og mentale modeller
  - 3 modeller
    - Design Modell: Designer
    - Bruker Modell: Bruker
    - System Modell: Systembilde
  - Elementer:
    - **Design metaforen** som benyttes evt.
    - **Konsepter** brukeres må forholde seg til når h*n bruker systemet.
    - **Relasjonene** mellom konseptene.
    - **Overførbarhet (mapping)** mellom konseptene ...
  - Eksempel:
    - AtB Mobillett:
      - Velg antall og type.
      - Betal.
      - Motta.
      - Vise.
- #### Metaforer
  - Kan gå ut på dato slik som en diskett for å lagre.
  - Skalerer ikke. Skrivebord er som den fysiske verden - kan ikke bli noe mer.
  - Forsikre om at metaforen ikke sender ut feil signaler. F.eks. et skrivespill for barn burde ikke inneholder zombier og masse andre elementer.

Relevant litteratur: Johnson& Henderson 2002, læreboka kap. 2.

- **Øvinger:**
  - Øving 3

[//]: # "######## ########"
[//]: # "##       ##"
[//]: # "##       ##"
[//]: # "######   #######"
[//]: # "##             ##"
[//]: # "##       ##    ##"
[//]: # "##        ######"

### Forelesning 5: (08.02)

- Komplekse GUI-komponenter og datamodeller.
- Egendefinerte komponentklasser

[//]: # "######## ########     ########"
[//]: # "##       ##           ##"
[//]: # "##       ##           ##"
[//]: # "######   #######      #######"
[//]: # "##             ##           ##"
[//]: # "##       ##    ## ### ##    ##"
[//]: # "##        ######  ###  ######"

### Forelesning 5.5: (10.02)

- Gjesteforelesning om brukersentrert design
  - Handlet om feedback:
    - Visuell
    - Auditiv
    - Taktil

[//]: # "########  #######"
[//]: # "##       ##     ##"
[//]: # "##       ##"
[//]: # "######   ########"
[//]: # "##       ##     ##"
[//]: # "##       ##     ##"
[//]: # "##        #######"

### Forelesning 6: (17.02)

- Presentasjon og diskusjon av øving om bruk av designprinsipper.

#### Fasene i brukersentrert design:

Gjentar modell:

<pre>
+-------------------------+
| Plan the human centered |
|     design process      |
+-------------------------+
            |
            v
+------------------------+               +-------------------------------+
| Understand and specify | ------------> | Specify the user requirements |
|  the context of use    |               +-------------------------------+
+------------------------+                       ^      |
          ^                                     /       |
           \ Iterate, where appropriate        /        |
            + - - - - - - - - - - - - - - - - +         |
            |                                  \        |
            |                                   v       v
+----------------------+                 +-----------------------------+
| Evaluate the designs |                 | Produce design solutions to |
| against requirements | <-------------- |    meet user requirements   |
+----------------------+                 +-----------------------------+
            |
            v
/-------------------------\
| Designed solution meets |
|    user requirements    |
\-------------------------/
</pre>

Denne modellen har 4 steg:
1. **Understand and specify the context of use:**
    - For å forstå "context of use":
      - Feltstudier
      - Intervjuer
      - Gruppeintervju/fokusgrupper
      - Automatisk logging av bruksmønster
      - Rollespill
      - Litteraturstudie
    - Formidle "context of use":
      - Personas basert på obervasjoner og intervju.
      - Scenarier av dagens situasjon basert på observasjon.
      - Loggdata-analyser.
2. **Specify the user requirements:**
    - Hvordan spesifisere krav:
      - Intervju med brukere og andre interessenter.
      - Fokusgrupper.
      - Rollespill.
    - Hvordan formidle krav:
      - Kravlister (user requirements spesification)
      - Overordnede ikke-funksjonelle krav (bl.a. brukervennlighet)
      - Scenarier og personas som viser tenkt system i bruk.
    - Brukerkrav liste ex:

      | ID | Krav | Må | Bør | Kan | Kommentar/Forklaring | Kriterier
      | --- | --- | --- | --- | --- | --- | ---
      | 1. | App må gi bruker mulighet til feedbak | 1 | | | | |
      | 2. | App må gi bruker mulighet til å få verifikasjon hver gang hjelp mottas | 1 | | | Tidpunkt burde være på verifikasjonen |
      | 3. | Bør gi oversikt over tidligere historikk | | 2 | | |
3. **Produce design solutions to meet user requirements:**
    - Måter å utvikle designløsninger:
      - Prototyping:
        - Ikke-funksjonelle (papirprototyper)
        - Funksjonelle (kjørende prototyper)
      - Scenarier med persones for løsning i bruk.
      - Designretningslinjer (Norma, Nielsen, etc)
    - Formidling av designløsninger:
      - Utprøving/Demo av selve prototypene.
      - Vise scenarier med personas for tenkt system i bruk.
4. **Evaluate the designs against requirements:**
    - Evaluere designløsninger:
      - Brukbarhetstesting i lab.
      - Fokusgrupper for feedback på løsning.
      - Felt-tester og logging av bruk.
      - Skjema (SUS).
    - Formidle resultat fra evaluering:
      - Testrapport fra brukbarhetstest.
      - Oppsummering av feedback fra fokusgrupper.
      - Analyser av felt-tester og loggdata.

[//]: # "######## ########"
[//]: # "##       ##    ##"
[//]: # "##           ##"
[//]: # "######      ##"
[//]: # "##         ##"
[//]: # "##         ##"
[//]: # "##         ##"

### Forelesning 7: (24.02)

- Brukersentrert design: Personas, scenarier, prototyping

[//]: # "########  #######"
[//]: # "##       ##     ##"
[//]: # "##       ##     ##"
[//]: # "######    #######"
[//]: # "##       ##     ##"
[//]: # "##       ##     ##"
[//]: # "##        #######"

### Forelesning 8: (03.03)

- Brukersentrert design: Brukbarhetstesting

- **Øvinger:**
  - Øving 4

[//]: # "########  #######"
[//]: # "##       ##     ##"
[//]: # "##       ##     ##"
[//]: # "######    ########"
[//]: # "##              ##"
[//]: # "##       ##     ##"
[//]: # "##        #######"

### Forelesning 9: (10.03)

- Brukersentrert design: Gjennomgang av konkret design og utviklingsløp.

[//]: # "########   ##     #####"
[//]: # "##       ####    ##   ##"
[//]: # "##         ##   ##     ##"
[//]: # "######     ##   ##     ##"
[//]: # "##         ##   ##     ##"
[//]: # "##         ##    ##   ##"
[//]: # "##       ######   #####"

### Forelesning 10: (17.03)

- Gjesteforelesning

[//]: # "########   ##     ##"
[//]: # "##       ####   ####"
[//]: # "##         ##     ##"
[//]: # "######     ##     ##"
[//]: # "##         ##     ##"
[//]: # "##         ##     ##"
[//]: # "##       ###### ######"

### Forelesning 11: (24.03)

- Deltagende design

- **Øvinger:**
  - Øving 5

[//]: # "########   ##    #######"
[//]: # "##       ####   ##     ##"
[//]: # "##         ##          ##"
[//]: # "######     ##    #######"
[//]: # "##         ##   ##"
[//]: # "##         ##   ##"
[//]: # "##       ###### #########"

### Forelesning 12: (31.03)

- Ubiquitous computing og interaksjonsteknikker

#### Ubiquitous computing (UbiComp)
- Interaksjon med datamaskiner hvor som helst, når som helst.
- Teknologien er i "bakgrunnen" av brukerens bevissthet.
  - Integrert i de fysiske omgivelsene (smarte omgivelser).
  - Transparent - "Forlengelse" av kroppen.
  - Sømløst integrert i livene våre.

#### Interaksjonsteknikker
- Interaksjonsteknikk er en kombo av in- og utdata, med relevant maskin-/programvare, som gjør relevante oppgaver mulig for bruker å gjennomføre.
- Ex: Drag-and-drop
  - Flytte på elementer med en musepeker i f.eks. mapper og filer.

#### Desktop computing VS. Ubiquitous computing

| | Dektop - PC/Internett | UbiComp - Mobil, trådløs IT
| --- | --- | ---
| Forgrunn / Bakgrunn | Hovedfokuset er på bruk av PCen. | Mobiltelefonen er integrert med andre aktiviteter.
| En bruker / Flere brukere | Ofte én bruker. Samhandling over nett | Flere brukere samtidig, i den fysiske verden.
| Omgivelses-data | Fysiske posisjon er irrelevant (CyberSpace) | Lokasjon og sensordata kan brukes av software.
| Hardware og ergonomi | PCen har funnet sin fysiske form (desktop/laptop). | Hardware/form blir viktig (størrelse, vekt, form, materialer, batterilevetid)
| Skjerm og input, nye brukergr.snitt. | Store skjermer, tastatur og mus | Små skjermer, penn, knapper, berøring, stemmestyring, kroppen som interaksjonsmedium

#### Ubiquitous computing (UbiComp)

[//]: # "########   ##    #######"
[//]: # "##       ####   ##     ##"
[//]: # "##         ##          ##"
[//]: # "######     ##    #######"
[//]: # "##         ##          ##"
[//]: # "##         ##   ##     ##"
[//]: # "##       ######  #######"

### Forelesning 13: (07.04)

- Oppsummering
- Gjennomgang av gamle eksamensoppgaver

[//]: # "########   ##   ##"
[//]: # "##       ####   ##    ##"
[//]: # "##         ##   ##    ##"
[//]: # "######     ##   ##    ##"
[//]: # "##         ##   #########"
[//]: # "##         ##         ##"
[//]: # "##       ######       ##"

### Forelesning 14: (14.04)

- *Påskeferie*

#### Brukernære metoder i systemutvikling

| Navn | Formål | Type data | God på | Dårlig på
| --- | --- | --- | --- | ---
| **Spørreskjema** | Få svar på spesifikke spørsmål | I hovedsak kvantitative | Kan nå mange pesoner | Vi må vite hva vi skal spørre om
| **Intervju** | Utforske. Få innblikk i et tema. | Kvalitativt | Gi innsikt i et problem. Dialog med bruker. | Tar tid, og viser ikke faktisk arbeidskontekst.
| **Fokusgrupper og workshops** | Dialog med gruppe av brukere | Kvalitativt | Komme dypt i å forstå et problem. Brukerinvolvering | Ressurskrevende.
| **Observasjon** | Studie av faktisk brukskontekst | Kvalitativt | Forstå brukerens faktiske hverdag. | Tar tid. Krever ofte tillatelse, f.eks. på sykehus.
| **Brukbarhets-testing.** | Evaluering av prototyp eller produkt | Kvalitativt og kvantitativt | Evaluere brukskvalitet av prototyp/produkt. | Krever at man har prototyp. Skjer ikke i faktisk kontekst.
| **Logging av bruk** | Evaluering av faktisk bruk | Kvantitativt | Faktisk bruk. Mange personer. | Gir ikke innsyn i årsaker til problemer.
