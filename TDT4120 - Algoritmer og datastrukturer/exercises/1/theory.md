# Teorioppgaver øving 1
## Oppgave 1:
 - a) **En instans av et problem er ... (12.5 %)**
   - ...
 - b) **Hvilket alternativ beskriver best algoritmer og datastrukturer? (12.5 %)**
   - Ummm...
 - c) **Hva er pseudokode? (12.5 %)**
   - Kode for å beskrive en prosess som er ganske generell for de fleste kodespråk
 - d) **I dette faget vil vi i hovedsak vurdere algoritmer ut fra ... (12.5 %)**
   - Kjøretid

## Oppgave 2:
I denne oppgaven skal vi se på en variant av spillet Nim. Reglene er som følger: To spillere skal etter tur plukke vekk fyrstikker fra en haug på bordet. Den som plukker opp den siste fyrstikken har tapt. Hver spiller må plukke opp mins en fyrstikk i hver runde, og kan maksimal plukke opp seks fyrstikker.
 - a) **Hvis det er 5 fyrstikker igjen, hvor mange må du ta for å vinne? (12.5 %)**
   - 4, siden da blir det 1 igjen.
 - b) **Hvis det er 10 fyrstikker igjen, hvor mange må du ta for å vinne? (12.5 %)**
   - 2, siden da kan motstanderen maks ta 6 slik at det blir 2 igjen. Da kan du ta èn og vinne.
 - c) **Hvis det er 250 fyrstikker igjen og det er din tur, hvor mange fyrstikker må du ta for å vinne? (Hint: finn en generell strategi.) (12.5 %)**
   - La oss se på små tall først:
     - 1: Ta 1. Man har tapt.
     - 2: Ta 1.
     - 3: Ta 2.
     - 4: Ta 3.
     - 5: Ta 4.
     - 6: Ta 5.
     - 7: Ta 6. Maks nådd.
     - 8: Ta 1, blir 7 igjen, og den med 7 vinner. Unngå å få 8.
     - 9: Ta 1 -> 8 igjen. Nå får motstanderen 8.
     - 10: Ta 2 -> 8.
     - 11: Ta 3 -> 8.
     - 12: Ta 4 -> 8.
     - Osv...
   - Vi kan nå se at det omhandler modulo og kan lage en formel:
     - f(x, maks) = max((x - 1) % (maks + 1), random)
     - Ifølge denne blir da vinnertrekket:
       - f(200, 6) = 4
 - d) **Hvis det er 134 fyrstikker igjen, hvor mange må du ta for å vinne? (12.5 %)**
   - f(134, 6) = random. Er ikke sikkert man vinner uansett trekk.
