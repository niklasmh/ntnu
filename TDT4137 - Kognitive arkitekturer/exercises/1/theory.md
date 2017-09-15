# Øving 1

**a) En bremsepedal skal trykkes ned så snart det røde bremselyset til bilen foran lyser opp. Beregn vha. MHP hva responstida blir til pedalen trykkes ned (tegn gjerne opp).**

1. Først må man oppdage lyset via den perceptuelle prosessoren. Her går det en p-sykel.
2. Kognitivt vil man knytte en handling til motor prosessoren. Her går en c-sykel.
3. Motoren bruker heretter tid på å utføre aksjonen. Her går en m-sykel.

Svar: `tₚ + tc + tₘ = 100ms + 70ms + 70ms = 240ms`

Maks og minimumtiden vil variere mellom `105ms og 470ms`.

**b) Anta at en bruker ser et flagg på en skjerm. Hvor lang tid tar det før hun vet om det er skandinavisk? (Anta at flaggets semantiske navn må hentes fra LTM etc.)**

1. Oppdage flagget og laste det inn i Visual Image Store som er i Working Memory.
2. Gjenkjenne flagget som er lagret i LTM.
3. Finne ut av landet, som er kognitivt.
4. Så finne ut om landet er i skandinavia, som også er kognitivt.

Regnestykket blir slik: `tₚ + 3tc = 100ms + 210ms = 310ms`

Hvor minste tiden og makstiden er `125ms og 710ms`.

**c) Hva menes med ID (Index of Difficulty)?**

ID er en del av Fitts lov som generelt forklarer hvor vanskelig en oppgave er å utføre. Den tar hensyn til størrelse på målet og avstanden.

**Vi skal bruke Fitts lov til å vise at det er mye hurtigere å flytte kursor til et mål som ligger langs kanten av skjermen enn til et mål som kan posisjoneres fritt bort fra kanten.**

**Ser vi på menyrekken (menu bar) på Macintosh så ligger den alltid helt i kanten på toppen av skjermen: [bilde]**

**På Windows ligger tilsvarende menyer (fullskjermmodus) litt unna kanten, adskilt med en "blå" toppstripe: [bilde]**

**Den kan i tillegg flyte fritt med vinduet.**

**Anta at størrelsen W for Windowsmenyen er 5 mm (figuren over er feil skalert). Målinger på en 15" flatskjerm viser at "kanteffekten" gir en effekt som om W = 50 mm på Macintosh (selv om målet fysisk sett er ca 5 mm også her). Dette skyldes at en slipper å stoppe innenfor menyen - en kan bare flytte kursor mot kanten med passende bevegelse. Anta at a=50 og b=150 i Fitts lov (Shannon utgaven) og at gjennomsnittlig avstand fra kursor til menyrekken er A=80 mm (på en 15" skjerm). Hvor lang tid tar det å nå menyrekken (menyfelt) på hhv. Macintosh og Windows?**

Her kan vi tenke oss at Macintosh har en evig stor meny, ettersom bevegelsen kan fortsette i samme retning i evig tid. Dette gjør også at Macintosh blir en klar vinner. Vi kan også bevise dette ved Shannons versjon av Fitts lov:

Windows: `50 + 150*log₂(80 / 5 + 1) = 663`
Macintosh: `50 + 150*log₂(80 / 50 + 1) = 257`
