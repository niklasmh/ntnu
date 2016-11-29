# Teorioppgaver øving 13
## Oppgave 1:
 - a) **Hva er maks flyt-problemet? (4.8 %)**
  - Å finne en flyt av maksimal verdi gjennom et nettverk
 - b) **Hva betyr notasjonen 11/16 mellom node ss og v1v1? (4.8 %)**
  - c(s,v1)=16c(s,v1)=16, f(s,v1)=11f(s,v1)=11
 - c) **Hva er galt med dette flytnettverket?  (4.8 %)**
  - Flyten er ikke opprettholdt.
 - d) **Hva er f(v3,v2)f(v3,v2) i dette flytnettverket? (4.8 %)**
  - 0
 - e) **Hva er galt med dette flytnettverket?  (4.8 %)**
  - Flyten er ikke opprettholdt.
 - f) **Hva er cf(v3,v2)cf(v3,v2) i dette flytnettverket? (4.8 %)**
  - 1
 - g) **Hvor stor er flyten |f||f| i følgende graf?  (4.8 %)**
  - 20
 - h) **Hvilke av disse stiene er en flytforøkende sti (augmenting path)? (4.8 %)**
  - ss, v1v1, v2v2, tt
 - i) **Hva er maks flyt mellom ss og tt? (4.8 %)**
  - 26

## Oppgave 2:
 - a) **Et snitt (S,T)(S,T) av et nettverk er en partisjonering av nodene VV i et nettverk slik at s∈Ss∈S og t∈Tt∈T og gjelder T=V+ST=V+S. (4.8 %)**
  - Usant
 - b) **Hva er et minimalt snitt? (4.8 %)**
  - En partisjonering av noder slik at kapasiteten til snittet er minst mulig.
 - c) **Kapasiteten til det minimale snittet trenger ikke nødvendigvis være lik den maksimale flyten for et gitt nettverk. (4.8 %)**
  - Usant

## Oppgave 3:
 - a) **P ⊆⊆ NP (4.8 %)**
  - sant
 - b) **P ⊆⊆ NPC (4.8 %)**
  - uvisst
 - c) **NP ⊆⊆ NPC (4.8 %)**
  - uvisst
 - d) **Dersom vi kan vise at et problem i NP kan løses i polynomisk tid må P=NP. (4.8 %)**
  - usant

## Oppgave 4:
Du får oppgitt et problem X, og ønsker å finne ut hvilken kompleksitetsklasse problemet tilhører. Hvilke utsagn er sanne?
 - a) **Du sammenlikner XX med problemet YY, som kan løses i polynomisk tid. (4.8 %)**
  - Hvis du kan transformere alle instanser xx av XX til tilsvarende instanser yy av YY i polynomisk tid, og vet at løsningen på yy alltid kan transformeres til løsningen på xx, kan du si at XX tilhører klassen P.
 - b) **Du sammenlikner XX med problemet ZZ, som er NP-komplett. (4.8 %)**
  - Hvis du kan transformere alle instanser zz av ZZ til tilsvarende instanser xx av XX i polynomisk tid, og vet at løsningen på xx alltid kan transformeres til løsningen på zz, kan du si at XX tilhører klassen NPC.

## Oppgave 5:
Du har problemene A, B og C. Alle tre er i NP. Du vet at A er i P og B er i NPC. I denne oppgaven menes det med "reduksjon" en reduksjon i polynomisk tid.
 - a) **Hvilken av følgende reduksjoner viser at C er i P? (4.8 %)**
  - Reduser CC til AA
 - b) **Hvilken av følgende reduksjoner viser at C er i NPC? (4.8 %)**
  - Reduser BB til CC
 - c) **Hvilken av følgende reduksjoner viser at P=NP? (4.8 %)**
  - Reduser BB til AA
