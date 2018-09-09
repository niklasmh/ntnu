# Teori - Hardware og software

- **a) Hva er forskjellen på primær og sekundær lagring?**

  - Primærlagring er gjerne tett knyttet til CPU, har mindre kapasitet og er avhengig av strøm for bevaring av data (volatile).
  - Sekundærlagring er gjerne permanent (non volatile) og bruker mer tid på å lagre enn primærlagere. De er også billigere per byte.

- **b) Harddisk, SSD og RAM: Nevn de ulike egenskapene med tanke på permanent/volatilt og tilfeldig/sekvensiell aksess.**

  - Harddisk: Fysisk disk. Permanent. Sekvensiell eller tilfeldig aksess.
  - SSD: Permanent. Sekvensiell eller tilfeldig aksess.
  - RAM: Volatile. Tilfeldig.

- **c) Hvorfor brukes Silisium mye i elektronikk?**

  - Fordi det er en halvleder som krever minimalt med energi for å lede strøm videre. Dette kan derfor brukes i elektronikk som er avhengig av transistorer for å utføre logikk.

- **d) Hva er en transistor?**

  - Transistorer kan føre strøm videre i en krets. Dette skjer med at den har to innganger og èn utgang. Den ene inngangen har selve strømmen som skal videre i systemet, mens den andre inngangen har en basisstrøm som er mye mindre. Justeres denne basisstrømmen riktig vil utgangen av transistoren ta med seg inngangstrømmen. Dette gjør at man kan lage kompleks logikk om man bygger videre på disse enkle komponentene. Den kan også forsterke basert på energien som blir tatt med videre i utgangen.

- **e) Det overføres 32 000 bytes mellom to datamaskiner. Hva må netthastigheten (målt i bits) være for å fullføre denne overføringen i løpet av 40 sekunder?**

  - 32Kb = 256Kbit
  - Netthastigheten = `size [bit] / time [sek] = 256Kbit / 40s = 6.4 Kbit / s`
  - Netthastigheten må derfor være høyere eller lik 6400 bit per sekund.
