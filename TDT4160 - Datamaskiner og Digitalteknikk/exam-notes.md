# Øving til eksamen i TDT4160

### Forkortelser og forklaringer
 - **IJVM**  -  (Integer Java Virtual Machine)
 - **ALU**   -  (Arithmetic Logic Unit)
 - **MPC**   -  (Micro Program Counter)
 - **PROM**  -  (Programmable Read Only Memory)
 - **EPROM** -  (Eraseable Programmable Read Only Memory) Sletter minneverdier med UV-lys.
 - **EEPROM** -  (Electrical Eraseable Programmable Read Only Memory) Kan omprogrammeres.
 - **ISA** (Instruction Set Architecture)
   - **RISC**  -  (Reduced Instruction Set Computing)
     - **Instruksjonsstørrelse:** Et ord eller to "bytes"
     - **Utføringstid:** En sykel per instruksjon.
     - **Arbeid gjort:** Mindre arbeid per instruksjon.
     - **Instruksjoner per program:** Mange.
   - **CISC**  -  (Complex) Instruction Set Computing)
     - **Instruksjonsstørrelse:** Multiple Words
     - **Utføringstid:** Antall sykler per instruksjon kan bestå av flere 1ere og 10ere.
     - **Arbeid gjort:** Mye arbeid per instruksjon.
     - **Instruksjoner per program:** Mange færre enn RISC.
 - Microarchitecture
   - Von Neumann:
     - Bruker samme bus for instruksjoner og data. Simpelt design - færre komponenter.
       - Beregninger skjer **sekvensielt** pga. dette.
     - Kan endre sin egen programkode.
     - Komponenter (hver for seg)
       - **CPU** (Control Processing Unit)
       - Instruction & Data Memory i ett.
     - Utfordringer idag:
       - Dataoverføring mellom minne og CPU.
   - Harward:
     - Separert bus for instruksjoner og data. Kan aksessere både data og instruksjoner i parallell.
     - Komponenter (hver for seg parallellt)
       - CPU
       - Instruction Memory
       - Data Memory
 - Hardware Components
   - Valgfritt å ha de med.
   - Kan være:
     - **RAM** (Random Access Memory)
     - **ROM** (Read-Only Memory)
     - Input & Output ports.
 - Mikro**prosessor**
   - ISA + Microarchitecture
 - Micro**controller**
   - ISA + Microarchitecture + Hardware Components
 - MIR (Micro Instruction Register)
   - **Addr**  -  (Address)                peker på neste mikroinstruksjon i instruksjonen.
   - **J**     -  (Jam)                    sier ifra om ALU har flagget neste mikroinstruksjon eller om det kommer hopp (betinget hopp).
   - **ALU**   -  (Aritmethic Logic Unit)  bestemmer hvilken funksjon ALU skal gjennomføre.
   - **C**     -  (C-bus)                  inneholder adressen til C-bussen, som blir det samme som adressen til registeret det skal skrives til.
   - **Mem**   -  (Memory)                 sier ifra om det skal gjøres noe med minne.
   - **B**     -  (B-bus)                  inneholder adressen til B-bussen, som blir det samme som adressen til registeret det skal leses fra.
 - Dataavhengigheter:
   - **RAW**  -  (Read-After-Write)   (sanne dataavhengigheter) er når f.eks. instruksjon 1 skriver til et register og instruksjon 2 skal lese fra det samme registeret.
   - **WAW**  -  (Write-After-Write)  (utavhengigheter) er når f.eks. instruksjon 3 skriver til register 1 og instruksjon 1 skriver til register 1.
   - **WAR**  -  (Write-After-Read)   (antiavhengigheter) er når f.eks. instruksjon 3 skriver til register 1 og instruksjon 2 leser fra R1.
 - **RAM** (Random Access Memory)
   - **SRAM**   - (Statisk RAM)             er raskt og trenger ikke oppdateres. Brukes ofte i hurtigbuffere.
   - **DRAM**   - (Dynamisk RAM)            må friskes opp jevnlig. Det tar mindre plass en SRAM (2 vs. 6 transistorer).
   - **SDRAM**  - (Synkront Dynamisk RAM)   betyr at data blir overført til/fra RAM synkront med klokka (og systembussen).
 - **IC** (Integrated Circut)
 - **Multiplex** - **2ⁿ** data inputs, **1** data output og n kontroll input.
 - **Demultiplex** - **1** data input, **2ⁿ** data output og n kontroll input.
 - **Half-adder** - A + B = sum + carry.
 - **Full-adder** - 2 Half-adders.
 - **Klokkepuls**
   - Valigvis: 100Mhz - 4GHz.
   - Verdier: 0 og 1.
   - Den er asymmetrisk.
   - Den utfører operasjoner på 0, derfor er 0 lengre enn 1.
 - **Latency hiding** - Cache brukes til dette for å øke ytelse.

### Register forkortelser ([http://datagk.stianj.com/](http://datagk.stianj.com/))
 - **PC**    -  (Program Counter)            inneholder adressen til instruksjonen som utføres, eller neste instruksjon som skal utføres. (avhengig av måten maskinen er bygd).
 - **IR**    -  (Instruction Register)       er der kontrollenheten lagrer instruksjonen som blir gjennomført nå. Den ligger her mens instruksjonen blir dekodet, startet og gjennomført.
 - **MAR**   -  (Memory Address Register)    inneholder adresse til neste minnelokasjon der vi finner neste instruksjon.
 - **MDR**   -  (Memory Data Register)       inneholder data som skal bli lagret i hovedminne (RAM), eller data som har blitt hentet fra minne. Virker som en buffer så data er klar for prosessor.
 - **MBR**   -  (Memory Buffer Register)     er et bufferregister mellom minne og prosessor.
 - **LV**    -  (Local Variable)             inneholder pekerverdi.
 - **SP**    -  (Stack Pointer)              inneholder pekerverdi.
 - **CPP**   -  (Constant Pool Pointer)      inneholder pekerverdi.
 - **TOS**   -  (Top Of Stack)               skal alltid inneholde ordet på toppen av stakken.
 - **OPC**   -  (OpCode || Operation Code)   register kan fritt brukes. Ex: MOV, ADD, LOAD.
 - **H**     -  (Holding Register)           inneholder verdien som skal inn i A-inngangen til ALU.

### ALU-flagg ([http://datagk.stianj.com/](http://datagk.stianj.com/))
 - **N** - settes når svaret fra ALU er negativt
 - **Z** - settes når svaret fra ALU er 0
 - **C** - carry, når vi f.eks. vil legge sammen 255 og 2 i 8-bit uten fortegnsbit. Svaret vil da bli 0000 0010 (2) som betyr (255+2). Et C-flagg vil da bli lagt til i statusregisteret.
 - **V** - overflow, når vi f.eks. vil legge sammen 127 og 127 i 8-bit med fortegnsbit. Svaret vil da bli 1111 1110 (254) eller i toers-kompliment -2. Et V-flagg vil da bli lagt til i statusregisteret.

### Instruction i Micro Program Minne
<pre>
. MPC
0000 0 0100
. . . . . . . .Shift ALU . . C buss . mem B buss
1: H  ← . . TOS: 00 010100 1000000000 000 0111
2: SP ← H + OPC: 00 111100 . 00001000 000 1000
</pre>

 - Branch
   - Addr | J | ALU | C | M | B
 - Ved hopp JMPC, JAMZ, JAMN
   - MPC (Micro PC)
     - JAM kan påvirke MPC
   - Betingahopp
     - hoppinstr && (Z || N): 1 i MIR, ALU -> noe
       - MPC = hopp micro instruksjon
     - hopp micro instruksjon
       - micro instruksjon som utfører et hopp
       - JMPS bit 1 (hopp?)

# Kilder
[http://datagk.stianj.com/](http://datagk.stianj.com/)
