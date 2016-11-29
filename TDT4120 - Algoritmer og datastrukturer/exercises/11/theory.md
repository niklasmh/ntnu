# Teorioppgaver øving 11
## Oppgave 1:
Denne opppgaven handler om korteste vei, én til alle. Se innledning til kapittel 24.
 - a) **Hva går korteste vei-problemet ut på? (1.9 %)**
  - Finne stier fra noder til andre noder som minimerer summen av kantvektene
 - b) **Hvis man vet hvordan man finner korteste en-til-alle veier kan man også finne korteste alle-til-en veier. Sant eller usant? (1.9 %)**
  - Sant
 - c) **Korteste vei har optimal substruktur. Sant eller usant? (1.9 %)**
  - Sant
 - d) **Hvis man har korteste vei fra node A til B og korteste vei fra node B til C så kan man sette sammen disse to for å få korteste vei fra A til C. Sant eller usant? (1.9 %)**
  - Usant
 - e) **Hvis man har funnet korteste vei fra A til C, og denne veien går innom B, har vi også funnet korteste fra vei fra A til B og fra B til C. Sant eller usant? (1.9 %)**
  - Sant
 - f) **Hvilken algoritme egner seg best til å finne korteste vei i en urettet graf der alle kantvekter er 7? (1.9 %)**
  - BFS
 - g) **Hvis en graf har negative sykler kan man øke kantvekten på alle kanter like mye slik at syklene blir positive og finne korteste med noen av algoritmene fra pensum. Sant eller usant? (1.9 %)**
  - Usant
 - h) **Vi har u.d=3,v.d=8,w(u,v)=2u.d=3,v.d=8,w(u,v)=2. Hva blir u.du.d og v.dv.d etter RELAX(u,v,w)RELAX(u,v,w)? (1.9 %)**
  - u.d=3,v.d=5u.d=3,v.d=5
 - i) **Vi har u.d=5,v.d=7,w(u,v)=4u.d=5,v.d=7,w(u,v)=4. Hva blir u.du.d og v.dv.d etter RELAX(u,v,w)RELAX(u,v,w)? (1.9 %)**
  - u.d=5,v.d=7u.d=5,v.d=7

## Oppgave 2:
Denne oppgaven handler om Bellman-Ford. Se kapittel 24.1.
<En graf>
I denne oppgaven skal vi bruke denne grafen. Vi skal finne korteste vei fra node F. For dette skal vi bruke Bellman-Ford (se side 651). 

Når du utfører Bellman-Ford skal du iterere over kanter i alfabetisk rekkefølge. Der kanten fra A til B heter AB og kanten fra F til C heter FC.
 - a) **Etter linje 1 i algoritmen - hva er F.dF.d? (1.9 %)**
  - 0
 - b) **Etter linje 1 i algoritmen - hva er A.dA.d? (1.9 %)**
  - ∞∞
 - c) **Etter én iterasjon av for-løkken på linje 2-4 - hva er B.dB.d? (3.8 %)**
  - ∞∞
 - d) **Etter én iterasjon av for-løkken på linje 2-4 - hva er C.dC.d? (3.8 %)**
  - 8
 - e) **Etter én iterasjon av for-løkken på linje 2-4 - hva er D.dD.d? (3.8 %)**
  - 6
 - f) **Etter to iterasjoner av for-løkken på linje 2-4 - hva er B.dB.d? (3.8 %)**
  - 9
 - g) **Etter to iterasjoner av for-løkken på linje 2-4 - hva er C.dC.d? (3.8 %)**
  - 4
 - h) **Etter to iterasjoner av for-løkken på linje 2-4 - hva er D.dD.d? (3.8 %)**
  - 3
 - i) **Bellman-Ford fungerer med negative kanter (men ingen negative sykler). Sant eller usant? (1.9 %)**
  - Sant
 - j) **Bellman-Ford oppdager negative sykler. Sant eller usant? (1.9 %)**
  - Sant
 - k) **Hva er kjøretiden til Bellman-Ford? (1.9 %)**
  - θ(EV)θ(EV)

## Oppgave 3:
Denne oppgaven handler om DAG shortest path. Se kapittel 24.2.
 - a) **Kan vi bruke DAG shortest path på grafen i Bellman-Ford-oppgaven over? (1.9 %)**
  - Nei, grafen inneholder en sykel
 - b) **Vi kan bruke DAG shortest path med negative kanter. Sant eller usant? (1.9 %)**
  - Sant
 - c) **Hvor mange ganger kjører vi RELAXRELAX på hver kant? (1.9 %)**
  - 1
 - d) **Hva er kjøretiden til DAG shortest path? (1.9 %)**
  - θ(V+E)θ(V+E)

## Oppgave 4:
Denne oppgaven handler om Dijkstra. Se kapittel 24.3.

I denne oppgaven skal vi bruke denne grafen. Vi skal finne korteste vei fra node F. For dette skal vi bruke Dijkstra (se side 658). 

Hvis du kan velge mellom to noder velger du i alfabetisk rekkefølge.
 - a) **I hvilken rekkefølge legges nodene til i S? (11.4 %)**
  - FEABDC
 - b) **Hva er C.dC.d etter én iterasjon av while-løkken på linje 4-8? (3.8 %)**
  - 8
 - c) **Hva er C.dC.d etter to iterasjoner av while-løkken på linje 4-8? (3.8 %)**
  - 8
 - d) **Hva er C.dC.d etter tre iterasjoner av while-løkken på linje 4-8? (3.8 %)**
  - 8
 - e) **Hva er C.dC.d etter fire iterasjoner av while-løkken på linje 4-8? (3.8 %)**
  - 7
 - f) **Hva er C.dC.d etter fem iterasjoner av while-løkken på linje 4-8? (3.8 %)**
  - 4
 - g) **For å få Dijkstra til å fungere med negative kanter kan man legge på en konstant på alle kantervekter slik at alle kantvektene blir positive og deretter kjøre Dijkstra. Sant eller usant? (1.9 %)**
  - Usant
 - h) **Dijkstra er en grådig algoritme. Sant eller usant? (1.9 %)**
  - Sant
 - i) **På hvilken måte beviser boka Dijkstra sin korrekthet? (Teorem 24.6 på side 659) (7.6 %)**
  - Viser at neste node som velges til enhver tid har riktig avstandsestimat
