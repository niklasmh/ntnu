# Velkommen til TTM4100 - Kommunikasjon - Tjenester og nett

## Oppsummering

### Introduction: Computer networks and the Internet

What is the Internet?
- Network edge
  - Apps on end systems/hosts
  - Edge routers in providers network (From providers view)
- Access networks
  - Wired, wireless links
  - Fiber, copper, radio, atellite
- Network core
  - Interconnected routers
  - Network og networks
- Routers
  - Forward packets
Packets
  - Chunks of data

This architecture makes it possible to access from both wireless and wire in the same way.

There are 4 protocol layers in this subject.

<pre>
Application -> Message --> M
Transport . -> Segment --> M, Hₜ
Network . . -> Datagram -> M, Hₜ, Hₙ
Link. . . . -> Frame ----> M, Hₜ, Hₙ, Hₑ
Physical. . -> Bit --> M, Hₜ, Hₙ, Hₑ -> To swith, router, Internet, then same way into end system.

*Where all layers adds an header to the request.
</pre>

When we forwards in the **link layer** we look at the **MAC address**.
When we forwards in the **network layer** we look at the **IP address**. No other options.
When we forwards in the **transport layer** we look at the **TCP, UDP, etc..**.
The others has alot of more options.

Performance parameters (Ytelse):
- **Throuhput** (Båndbredde) = Rate which bits are transferred between sender/receiver.
  - Fiber makes connection much faster than copper.
  - Unit bits per time.
  - Instantaneous rate at given point in time.
  - Average rate over longer period of time.
  - Capacity Rₛ bits/sec -> Capacity R_c bits/sec.
  - End-to-end througput cannot exceed bottleneck link.
- **Packet delay**, or variation in delay.
  - Calculation:
<pre>
R = link bandwidth (bit/s)
L = packet length (bits)
time to send bits into link = `L / R`
d = length of physical link
s = propagation speed in medium (-2x10⁴ m/sec)
propagation delay = d/s
</pre>
  - Sources:
    1. Nodal processing
      - Check bit errors.
      - Determine output link.
    2. Queueing
      - Time waiting at output link for transmission.
      - Depends on congestion level of router.
    3. Transmission
    4. Propagation
- **Packet loss** - packet arriving to full queue -> Overflow => dropped.
  - Queue (buffer) preceding link has finite capacity
  - Lost packet mat be retransmittet by previous node, by source end system, or not at all.

Internet approach bottom up:
- **Physical**
  - Digital communication, transmission of 0s and 1s by the physical layer.
    - Using either radio waves or voltage as measurements for 0s and 1s.
    - Need to be optimal as it will give higher rates and more efficient network.
    - Bits makes propagations. They make **propagation delay**.
    - They are sended over
      - Guided media - solid - copper, fiber, coax.
      - Unguided media - no wire - EMS - bidirectional - affected by refletion, interference and obstruction by objects.
- **Link**
  - **Framing** bits and transmit them over the link which is point-to-point of broadcast - using MAC address.
    - They are transported to the next device, by hop-to-hop, that should process the data further.
    - Subject spesific: Broadcast link layer
      - CSMA/CD (Carrier Sense Multiple Access/Collision Detect, IEEE 802.3)
        - Ethernet, wait and listen. Sending when it is less propagation.
      - CSMA/CD (Carrier Sense Multiple Access/Collision Avoidance, IEEE 802.11)
        - Avoid collision. Typically in wireless networks.
    - Switches are the bridges in the link layer and uses MAC addresses.
      - MAC (Medium Access Control)
        - FF-FF-FF-FF-FF-FF = 16¹² = 2⁴⁸ = much addresses.
        - 3 first bytes is service (Apple, MS, etc...)
      - ARP (Address Resolution Protocol)
        - When we want from IP to MAC address.
        - This happens inside the link layer in a network.
    - Detects error hop-by-hop.
      - Parity bits
      - Mod 2 addition
      - CRC - cyclic redunancy check
      - FEC - forward error correction
    - MAC protocol (Medium Access Protocol)
      - Tranmit into a shared broadcast channel
        1. Channel partitioning
          - Divide channel into smaller "pieces" (time slots, frequency, code).
          - Allocate piece to node for exclusive use.
          - Methods: [T, M, C]DMA.
        2. Random access
          - Channel not divided, allow collisions.
          - "Recover" from collisions.
          - Methods
            - Slottet ALOHA
              - Sending at the same time. Sync clocks to know when the slots begin.
            - ALOHA
            - CSMA
            - CAMA/CD
            - CSMA/CA
        3. Taking turns
          - Nodes take turns, but nodes with more to send can take longer turns.
          - Methods
            - Polling (take the one who reaches its hand)
            - Token passing (passing a mic to speaker)
      - Wireless VS. wired
        - Much easier with wired as wireless has unguided media.
        - Wireless downsides
          - Decreasing signal strength: Travels through matter (path loss).
          - Interference from sources.
          - Multipath propagation. Radio signal reflects off objects ground, arriving destination in different times.
          - SNR (Signal to Noice Ratio). Makes it easier to extract signal from noise.
      - The link layer is implemented in the network card through network drivers in each and every host/node.
        - NIC (Network interface card) implements link + physical layer.
        - Link layer is a mix of hardware and software.
- The frame transports the **IP datagram** one hop towards its destination.
- The IP datagram contains the **IP addresses** from both sender and receiver. NAT will translate if used.
- **Routers** forwards IP datagrams **hop-by-hop**, using **forwarding tables** built by **routing protocol** information exchange.
- The provided IP service is a **connectionless**, **best-effort** service without guarantees.
- The **end-to-end transport layer** adds error, flow- and congestion control.
- **Domain Name System** translates between names an IP addresses.
- Distributed applications run onlu in end systems and exchange data across the network.

### Link layer
Tasks:

### Network layer
Tasks:

### Transport layer
### Applikasjon layer

### Wireless and mobile

### Security in computer networks

### Multimedia networking
