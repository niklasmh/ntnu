# Del 1 - design

Oppgave: *Lag en skisse evt. digital prototype og begrunn valg av interaktive elementer og gjerne hvorfor alternativer ble forkastet.*

Data:

**Formål:** Uformatert String  
**Rom:** Formatert String, først bygg som består av bokstaver, mellomrom, bindestrek og tall, og så romnummer, som er et heltall. Eksempel: IT-vest 115  
**Dato:** Dato frem i tid. Eksempel: 29/1-2015  
**Fra-tidspunkt:** time:min. Eksempel: 10:15  
**Til-tidspunkt:** time:min, må være etter fra-tidspunkt (møter over midnatt støttes ikke, så begge er på samme dato. Eksempel: 12:00  
**Repetisjonsfrekvens:** tall som angir tid (dager) til neste i den repeterende rekka. 0 eller negativt tall angir ikke-repeterende. Eksempel (ukentlig): 7  
**Slutt-dato:** Brukes hvis hendelse er repeterende (altså Repetisjonsfrekvens > 0) og angir etter hvilken dato repetisjonen er over.

### Min måte å håndere dataene:

**Formål:** Tekst felt.  
**Rom:** Tekstfelt med en nummer komponent.  
**Dato:** Et dato UI-element.  
**Fra-tidspunkt:** 3 nummer felter hvor alle har en range henholdvis 0-23, 0-59 og 0-59.  
**Til-tidspunkt:** 3 nummer felter hvor alle har en range henholdvis 0-23, 0-59 og 0-59.  
**Repetisjonsfrekvens:** En nummer range fra 0->  
**Slutt-dato:** Et dato UI-element.
