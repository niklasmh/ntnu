# TDT4180 - Menneske-maskin interaksjon

### Forelesning 1: (13.01)
 - Opplegg:
   - 5 eller 6 Øvinger (5 på planen).
     - 2 første om teknikkdel (Hallvard).
     - Rsterende er om design-del (Yngve).
   - Delt opp i Design (Pensum til eksamen) og kontruksjon (Ikke relevant, enda).
 - Brukskvalitet
   - Brukskvalitet (Også omtalt som brukervennelighet):
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
     - ISO 9241-11 (1998):
       - Anvendbarhet:
         - Grad av nøyaktighet og kompletthet.
         - Klarer brukeren å løse oppgaven?
       - Effektivitet:
         - Ressursforbruk i forhold til kompletthet.
         - Hvor mye tid brukes for å fremstille løsningen?
       - Tilfredstillelse:
         - Subjektiv opplevelse av designløsnngens egenhet.
         - Hvordan oppleves designet av brukerene?
     - Jacob Nielsen (1993):
       - Grunnlagt mye teori bak brukskvalitet.
   - "Context of use":
     - Venndiagramm:
       - Brukere
       - Oppgaver
       - Omgivelser
     - TAM (Technology Acceptance Model):
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
 - Introduksjon til brukersentrert design
   - Brukersentrert design:
     - Pugg en figur til eksamen.
     - ISO 9241-210:
       - Hvordan gå frem.
     - Viktig å involvere brukeren:
       - Vi må kommunisere.
       - Brukeren burde opplyses om hva somer mulig.
   - Iterativt design:
     - Kom sammen med skjermer og grafikk.
     - Begynte å utvikle med fossafalls-metode og se et behov for det.
     - Feilrate:
       - Synker etterhvert med flere iterasjoner.
         - Fra rundt 50% - under 10% i 5 iterasjon.

Relevant litteratur: ISO 9241-11, ISO 9241-210, læreboka kap. 1.

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

### Forelesning 2.5: (20.01)

 - MMI-historikk
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
 - Anvendelse av GUI komponenter
   - 

### Forelesning 3: (25.01)

 - Interaktivitet med JavaFX og FXML og SceneBuilder
   - UI
     - Sammenlignbart med
       - at U går gjennom V -> C -> M -> C -> V
       - og I går gjennom V -> C -> V
 - Controller-klasser

### Forelesning 3.5: (27.01)

 - Designretningslinjer
   - Nødvendig å teste om man følger retningelinjene? JA! De er bare en kravspekk. Den er ikke spesialiser for alle.
   - Prinsipper:
     - Don Normans's "Design of everyday things"
       - **Visibility** - Kan jeg se det?
         - Mer synlig funksjon => Enklere vil brukeren bruke funksjonen. Lettere mål til aksjon. Lettere å se tilstand.
         - Eksempel:
           - Automatisk vannkran.
             - Hvor skal man putte hendene?
             - Hvordan slå på vannet?
       - **Affordable** - Hvordan kan jeg bruke det?
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
       - **Constraints** - Hvorfor kan jeg ikke gjøre slik?
         - Signaliserer begrensninger i forhold til handlinger.
         - Henger sammen med affordance. Affordance tilbyr ulike måter å bruke det. Constraints tilbyr litt mer hva vi gjør til vanlig pga. kultur eller noe.
           - F.eks: Noe blir rødt. Forbinder det med stopp eller fare.
           - Å snakke i mobil i forelesning.
           - Henger sammen med f.eks. en dør som er flat og bare kan pushes fra den ene siden. På den andre siden kan den pulles. Det sier både hva den må fungere og har en begrensning.
           - Trinnbasert oppsett av mail.
             - Kan ikke gå videre om man har gjort noe feil eller mangler noe.
       - **Feedback** - Hva skjer nå?
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
       - **Mapping** - Er det en naturlig sammenheng mellom kontrollen og effekt?
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
       - **Consistency** - Har jeg ikke sett dette før?
         - Elementer som ser like ut bør ha samme funksjon.

 - **Øvinger:**
   - Øving 1
   - Øving 2

### Forelesning 4: (01.02)

 - Data-orienterte komponenter og interaktivitet
 - Mer om Controller-klasser.

### Forelesning 4.5: (03.02)

 - Gestalt
   - Meningsfull helhet.
   - Prinsipper:
     - Likhet. 
       - Like former sees sammen.
       - Like farger sees sammen.
     - Nærhet.
       - Elementer som står nær hverandre oppfattes som samhørende.
       - I GUI kan dette være formelementer som grupperes slik at de omhandler den samme informasjonen.
     - Mental komplettering.
       - Vi oppfetter lukkede eller sluttede former. Slik som når 2 streker fullfører et hjørne - som om hjørnet ikke er synlig.
       - I GUI pleier man å lage silhuetter slik at man danner former med det tomme rom.
     - Kontinuitet.
       - Linjer fortsetter i den retningen de avbrytes. Er nesten det samme som mental komplettering.
       - Om du har en halv-sirkel vet du at den vil fullføre en sirkel.
     - Helhet. Forgrunn/bakgrunn.
       - Vi oppfatter raskt om noe er forgrunn eller bakgrunn.
       - Farge, kontrast, rammer, størrelse og perspektiv påvirker hva som er bakgrunn og forgrunn.
       - I GUI kan det være vindu-prinsippet til Windows og forsåvidt alle andre OS. Legger på skygge for å heve ut.
 - Konseptuelle- og mentale modeller
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
 - Metaforer
   - Kan gå ut på dato slik som en diskett for å lagre.
   - Skalerer ikke. Skrivebord er som den fysiske verden - kan ikke bli noe mer.
   - Forsikre om at metaforen ikke sender ut feil signaler. F.eks. et skrivespill for barn burde ikke inneholder zombier og masse andre elementer.

Relevant litteratur: Johnson& Henderson 2002, læreboka kap. 2.

 - **Øvinger:**
   - Øving 3

### Forelesning 6: (08.02)

 - Komplekse GUI-komponenter og datamodeller.
 - Egendefinerte komponentklasser

### Forelesning 6.5: (10.02)

 - Gjesteforelesning om brukersentrert design

### Forelesning 7: (15.02)

### Forelesning 7.5: (17.02)

 - Presentasjon og diskusjon av øving om bruk av designprinsipper.

### Forelesning 8: (24.02)

 - Brukersentrert design: Personas, scenarier, prototyping

### Forelesning 9: (03.03)

 - Brukersentrert design: Brukbarhetstesting

 - **Øvinger:**
   - Øving 4

### Forelesning 10: (10.03)

 - Brukersentrert design: Gjennomgang av konkret design og utviklingsløp.
 
### Forelesning 11: (17.03)

 - Gjesteforelesning

### Forelesning 12: (24.03)

 - Deltagende design

 - **Øvinger:**
   - Øving 5

### Forelesning 13: (31.03)

 - Ubiquitous computing og interaksjonsteknikker

### Forelesning 14: (07.04)

 - Oppsummering
 - Gjennomgang av gamle eksamensoppgaver

### Forelesning 15: (14.04)

 - *Påskeferie*
