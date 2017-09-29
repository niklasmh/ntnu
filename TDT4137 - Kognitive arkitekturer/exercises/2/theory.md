# Øving 2

**Nedenfor ser du to skjermbilder fra en telefon-app som styres med pekefingeren. Du skal vurdere hvor effektivt ringing er med inntasting av nummer, kontra valg fra favoritt-listen. Anta 8 siffer i telefonnummeret. Når en ringer med favorittlisten trykker en bare med fingeren på navnet for å ringe. Anta at personen du ringer til, f.eks mamma, finnes på første side i favorittlisten, så du slipper å skrolle. Favorittlisten kommer opp ved å trykke på stjerneikonet med teksten ”Favoritter” nederst på skjermen. Tilsvarende kommer tastaturet opp ved å trykke på tastatursymbolet med teksten ”Tastatur” nederst.**

**a) Angi typiske ”unit-tasks” for telefon-appen og modeller topp-nivået i NGOMSL. Husk å ta med ”unit-task level”.**

#### Top-level unit-tasks
- ringe fra nummber
- ringe fra favoritter
- ringe fra kontakter
- endre en kontakt

#### Method to accomplish goal of "bruke applikasjonen"
1. Få neste "unit-task" fra _instruksjonsliste over oppgaver_
2. Bestem: Hvis ikke flere oppgaver, returner med målet oppnådd
3. Fullfør målet med å _bevege seg til "unit-task" lokasjonen_
4. Fullfør målet med å _fullføre en "unit-task"_
5. Gå til 1

#### Selection rule set for the goal of "utføre en enhetsoppgave"
- Hvis "ringe fra nummber", utfør målet med å ringe fra nummber
- Hvis "ringe fra favoritter", utføre målet med å ringe fra favoritter
- Hvis "ringe fra kontakter", utføre målet med å ringe fra kontakter
- Hvis "Endre en kontakt", utføre målet med å endre en kontakt

**b) Modeller målet ”ring” (call) , som ringer opp en person.**

#### Method to accomplish goal of "bevege seg til enhetsoppgavelokasjon"
1. Gjenkjenn hvilken tab-knapp for å oppnå målet
2. Bestem: Hvis tab vises, returner med målet oppnådd
3. Lokaliser tab-knapp
4. Beveg finger til tab-knapp-lokasjon
5. Trykk tab-knapp

Returner med målet oppnådd

#### Method to accomplish goal of "ring"
- Hvis "ringe fra nummber", utfør målet med å ringe fra nummer
- Hvis "ringe fra favoritter", utføre målet med å ringe fra favoritter

Returner med målet oppnådd

#### Method to accomplish goal of "ringe fra nummber"
1. Utfør målet med å fullføre _bevege seg til enhetsoppgavelokasjon_
2. Gjenkjenn neste tall
3. Lokaliser tallet
4. Beveg finger til lokasjonen
5. Trykk på lokasjonen med tallet
6. Bestem: Hvis flere tall i nummer, gå til 2
7. Lokaliser ring knapp
8. Beveg finger til ring knapp
9. Trykk ring knapp med finger

Returner med målet oppnådd

#### Method to accomplish goal of "ringe fra favoritt"
1. Utfør målet med å fullføre _bevege seg til enhetsoppgavelokasjon_
2. Gjenkjenn personen du skal ringe i favoritter
3. Lokaliser navnet i listen
4. Beveg fingeren til lokasjonen
5. Trykk på lokasjonen

Returner med målet oppnådd

**c) Beregn utførselstid for alternativene (execution time)?**

| Forkortelse | Tid | Betydning
|:---|:---|:---
| CP | 1.2s | Lokaliser
| B | 0.1s | Trykke
| H | 0.4s | Hjem
| K | 0.2s | Tastetrykk
| M | 1.2s | Kognitiv prosessering
| P | 1.1s | Peke

#### Ringe et nummer på 8 tall

`Tid = M + (M eller (CP + P + B)) + antall * (M + CP + P + B) + (CP + P + B)`

Svar (med at man er i en annen tab): `34.8s`

#### Ringe et nummer fra favoritter

`Tid = M + (M eller (CP + P + B)) + M + CP + P + B`

Svar (med at man er i en annen tab): `7.2s`
