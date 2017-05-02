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
- **Physical layer**
  - Digital communication, transmission of 0s and 1s by the physical layer.
    - Using either radio waves or voltage as measurements for 0s and 1s.
    - Need to be optimal as it will give higher rates and more efficient network.
    - Bits makes propagations. They make **propagation delay**.
    - They are sended over
      - Guided media - solid - copper, fiber, coax.
      - Unguided media - no wire - EMS - bidirectional - affected by refletion, interference and obstruction by objects.
- **Link layer**
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
- **Network layer**
  - The frame transports the **IP datagram** one hop towards its destination.
    - Datagram
      - A packet which contains
        - Protocol head
          - IP address to source
          - IP address to destination
    - Network layer exists in all devices, except those which only handles the link layer.
      - End systems.
      - Network nodes. Routers.
    - Protocols
      - IP (Internet Protocol)
        - Addressing conventions.
        - Datagram format.
        - Packet handling conventions.
      - ICMP (Internet Control Message Protocol)
        - Error reporting.
        - Router "signing"?
      - DHCP (Dynamic Host Configuration Protocol)
      - ARP (Address Resolution Protocol)
        - Between link and network layer.
  - The IP datagram contains the **IP addresses** from both sender and receiver. NAT will translate if used.
    - Methods for calculating shortest path
      - Distance vector
        - Measures its neighbour distances and shares it with its neighbours.
      - Link state
        - Floats into the network and finds the state to all the links which the system is connected to.
    - Best effort service
      - The Internet datagram model is connectionless.
      - Each datagram packet is independent - not dependent on other packets.
    - Routing protocols build routing/forwarding tables
    - Routers use the destination IP-address to forward the datagram on the appropriate outbound link.
  - **Routers** forwards IP datagrams **hop-by-hop**, using **forwarding tables** built by **routing protocol** information exchange.
    - Routing: Making the forwarding tables = determine route taken by packets from source to destination.
    - Forwarding: Pack in and pack out based on the forwarding tables = move packets from routers input to appropriate router output - Longest prefix matching on destination address of each datagram.
    - Each router has a [memory, bus, switch matrix] with in- and output.
    - Routing algorithm
      - Local forwarding table:
        <pre>
        Header val | Output link
        . . . 0100 | 3
        . . . 0101 | 2
        . . . 0111 | 2
        . . . 1001 | 1
        </pre>
    - **CIDR** (Classless InterDomain Routing)
      - Address format: a.b.c.d/x, where X is # bits in subnet portion of address.
      - 123.45.67.0/23 <-------- subnet part --------> <-- host part -->
    - **NAT** (Network Address Translation)
      - Making use of port numbers in transport layer.
        - TCP and UDP has port number, which makes it possible to translate between local and public addresses.
    - **DHCP** (Dynamic Host Configuration Protocol)
      - Broadcasts/emits message to recieve a new address.
      - Then the device will pick from the IPs available, then it can communicate.
- The provided IP service is a **connectionless**, **best-effort** service without guarantees.
- **Network layer**
    - UDP:
      - Contains:
        - Header at 32 bit
          - Source port #
          - Dest port #
          - Length
          - Checksum
        - Application data.
      - Unreliable, unordered delivery.
      - No-frills extension of "best-effort" IP.
    - TCP: Much more.
      - Contains:
        - Header at 32 bit??
          - Source port #
          - Dest port #
          - Sequence number
          - ACK number
          - Head length
          - Res
          - [U, A, P, R, S, F]
          - Window
          - Checksum
          - Urgent data ptr.
          - Options (variable length)
        - Application data
      - Reliable, in-order delivery.
      - Connection setup.
      - Point-to-point full duplex.
        - One sender, one receiver.
      - Connection-oriented.
        - Handshaking. Initiates sender and receiver state before data exchange.
        - 3-way handshake to set up and make access information available in both ends before we can send data.
      - Error control.
        - Bit error. Checksum.
        - Segment error. Find if any segments are lost.
      - Flow control.
        - Sender will not overwhelm receiver.
      - Congestion control.
        - Sender adjust transmission dependent on network load.
        - Important to do as packets can get lost and sender needs to send packets less frequently.
      - Safe channel. Therefore it must handle error and packet loss in both directions.
        - Checksum
        - Receiver feedback (ACK, NAK)
        - Retransmission on NAK
        - Sequence number on data packets
        - Checksum on ACK/NAK
        - Retransmission on duplicate ACK
        - Countdown timer
        - Retransmission on timeout
        - Own variable for congestion window -> If too many packets are sent and we need to slow down
    - Well known port numbers:
      <pre>
      Application. . . . . . . | Port - App. layer protocol. . | Underlying transport protocol
      Email. . . . . . . . . . | 25 - SMTP . . . . . . . . . . | TCP
      Remote terminal access . | 23 - Telnet . . . . . . . . . | TCP
      Web. . . . . . . . . . . | 80 - HTTP . . . . . . . . . . | TCP
      File transfer. . . . . . | 20, 21 - FTP. . . . . . . . . | TCP
      Streaming multimedia . . | HTTP (YT, FB) . . . . . . . . | TCP or UDP
      Internet telephony . . . | SIP, RTP, proprietary (Skype) | Typically UDP, but TCP for FW.
      </pre>
- The **end-to-end transport layer** adds error, flow- and congestion control.
- **Application layer**
  - **Domain Name System** translates between names and IP addresses.
  - Distributed applications run only in end systems and exchange data across the network.
    - Communication protocols accessed through API.

A day in a life of a simple web page request:
- **DHPC** -> Emit/Broadcasts that there is a new host on network. The routers return addresses and the host can choose IP - if more than one.
  - UDP: Src MAC: 00:ff:bb:cc...., Dst MAC: ff.ff.ff.ff.ff.ff, Src IP: 0.0.0.0, Dst IP: 255.255.255.255
- **ARP** -> Needs own IP from MAC, asks ARP tables.
- **DNS**/UDP -> Get IP address for website.
- **TCP** -> 3-way handshake. Establish a reliable connection.
- **HTTP** -> Send request with Src IP, Dst IP over TCP.
- **TCP** -> Close connection.

### Link layer
Tasks:

### Network layer
Tasks:

### Transport layer
### Applikasjon layer

### Wireless and mobile

### Security in computer networks

### Multimedia networking
