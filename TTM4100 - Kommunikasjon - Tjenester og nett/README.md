# Velkommen til TTM4100 - Kommunikasjon - Tjenester og nett

## Oppsummering

### Introduction: Computer networks and the Internet

What is the Internet?
- Network edge
  - Apps on end systems/hosts
  - Edge routers in providers network (From providers view)
- Access networks
  - Wired, wireless links
  - Fiber, copper, radio, satellite
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
    time to send bits into link = L / R
    d = length of physical link
    s = propagation speed in medium (-2x10⁴ m/sec)
    propagation delay = d / s
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

[//]: # "########  ##     ## ##    ##  ######  ####  ######     ###    ##            ##          ###    ##    ## ######## ########"
[//]: # "##     ## ##     ##  ##  ##  ##    ##  ##  ##    ##   ## ##   ##            ##         ## ##    ##  ##  ##       ##     ##"
[//]: # "##     ## ##     ##   ####   ##        ##  ##        ##   ##  ##            ##        ##   ##    ####   ##       ##     ##"
[//]: # "########  #########    ##     ######   ##  ##       ##     ## ##            ##       ##     ##    ##    ######   ########"
[//]: # "##        ##     ##    ##          ##  ##  ##       ######### ##            ##       #########    ##    ##       ##   ##"
[//]: # "##        ##     ##    ##    ##    ##  ##  ##    ## ##     ## ##            ##       ##     ##    ##    ##       ##    ##"
[//]: # "##        ##     ##    ##     ######  ####  ######  ##     ## ########      ######## ##     ##    ##    ######## ##     ##"

- **Physical layer**
  - Digital communication, transmission of 0s and 1s by the physical layer.
    - Using either radio waves or voltage as measurements for 0s and 1s.
    - Need to be optimal as it will give higher rates and more efficient network.
    - Bits makes propagations. They make **propagation delay**.
    - They are sended over
      - Guided media - solid - copper, fiber, coax.
      - Unguided media - no wire - EMS - bidirectional - affected by refletion, interference and obstruction by objects.

[//]: # "##       #### ##    ## ##    ##      ##          ###    ##    ## ######## ########"
[//]: # "##        ##  ###   ## ##   ##       ##         ## ##    ##  ##  ##       ##     ##"
[//]: # "##        ##  ####  ## ##  ##        ##        ##   ##    ####   ##       ##     ##"
[//]: # "##        ##  ## ## ## #####         ##       ##     ##    ##    ######   ########"
[//]: # "##        ##  ##  #### ##  ##        ##       #########    ##    ##       ##   ##"
[//]: # "##        ##  ##   ### ##   ##       ##       ##     ##    ##    ##       ##    ##"
[//]: # "######## #### ##    ## ##    ##      ######## ##     ##    ##    ######## ##     ##"

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
                - No collision: Node send new frame in next slot.
                - Collision: Retransmits after p probability time until success.
                - Pros:
                  - Transmits at full rate of channel continously.
                  - Decentralized.
                  - Simple.
                - Cons:
                  - Wasting slots in collisions.
                  - Empty slots.
                  - Needs to sync with clock - usually from a GPS.
                  - Nodes must detect collision in less time than time to transmit packet.
                - Probability of success in a node: `p(1-p)ᴺ⁻¹`
                - Probability of success in any node: `Np(1-p)ᴺ⁻¹`
                - At best: 37% success.
                - Pure unslottet ALOHA is at 18% - because they are not synced.
              - ALOHA
              - CSMA
                - **Listen before transmit:** Send entire frame if idle, else if busy, defer transfer.
                - Collision can still occur: Propagation delay nodes may not hear each others transmission. Packet wasted.
              - CAMA/CD
                - Easier to detect collision in wired connections.
                - Used by Ethernet.
                - Efficiency = `1 / (1 + 5t_prop / t_trans)`
                  - t_prop = max propagation delay between 2 nodes in LAN.
                  - t_trans = time to transmit max-size frame.
                - Pros:
                  - Simple.
                  - Cheap.
                  - Decentrialized.
                  - Better performance than ALOHA.
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
      - FDMA (Frequency Division Multiple Access)
        - Channel spectrum divided into frquency bands.

[//]: # "##    ## ######## ######## ##      ##  #######  ########  ##    ##      ##          ###    ##    ## ######## ########"
[//]: # "###   ## ##          ##    ##  ##  ## ##     ## ##     ## ##   ##       ##         ## ##    ##  ##  ##       ##     ##"
[//]: # "####  ## ##          ##    ##  ##  ## ##     ## ##     ## ##  ##        ##        ##   ##    ####   ##       ##     ##"
[//]: # "## ## ## ######      ##    ##  ##  ## ##     ## ########  #####         ##       ##     ##    ##    ######   ########"
[//]: # "##  #### ##          ##    ##  ##  ## ##     ## ##   ##   ##  ##        ##       #########    ##    ##       ##   ##"
[//]: # "##   ### ##          ##    ##  ##  ## ##     ## ##    ##  ##   ##       ##       ##     ##    ##    ##       ##    ##"
[//]: # "##    ## ########    ##     ###  ###   #######  ##     ## ##    ##      ######## ##     ##    ##    ######## ##     ##"

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
    - HOL (Head-of-line) blocking
      - Happens when packet is not allowed access to a free resource because it is being blocked (e.g. in a FIFO (First in, first out) queue) by another packet waiting for an unavailable resource. (Exam v2016)
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

[//]: # "######## ########     ###    ##    ##  ######  ########   #######  ########  ########      ##          ###    ##    ## ######## ########"
[//]: # "   ##    ##     ##   ## ##   ###   ## ##    ## ##     ## ##     ## ##     ##    ##         ##         ## ##    ##  ##  ##       ##     ##"
[//]: # "   ##    ##     ##  ##   ##  ####  ## ##       ##     ## ##     ## ##     ##    ##         ##        ##   ##    ####   ##       ##     ##"
[//]: # "   ##    ########  ##     ## ## ## ##  ######  ########  ##     ## ########     ##         ##       ##     ##    ##    ######   ########"
[//]: # "   ##    ##   ##   ######### ##  ####       ## ##        ##     ## ##   ##      ##         ##       #########    ##    ##       ##   ##"
[//]: # "   ##    ##    ##  ##     ## ##   ### ##    ## ##        ##     ## ##    ##     ##         ##       ##     ##    ##    ##       ##    ##"
[//]: # "   ##    ##     ## ##     ## ##    ##  ######  ##         #######  ##     ##    ##         ######## ##     ##    ##    ######## ##     ##"

- **Transport layer**
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

[//]: # "   ###    ########  ########  ##       ####  ######     ###    ######## ####  #######  ##    ##      ##          ###    ##    ## ######## ########"
[//]: # "  ## ##   ##     ## ##     ## ##        ##  ##    ##   ## ##      ##     ##  ##     ## ###   ##      ##         ## ##    ##  ##  ##       ##     ##"
[//]: # " ##   ##  ##     ## ##     ## ##        ##  ##        ##   ##     ##     ##  ##     ## ####  ##      ##        ##   ##    ####   ##       ##     ##"
[//]: # "##     ## ########  ########  ##        ##  ##       ##     ##    ##     ##  ##     ## ## ## ##      ##       ##     ##    ##    ######   ########"
[//]: # "######### ##        ##        ##        ##  ##       #########    ##     ##  ##     ## ##  ####      ##       #########    ##    ##       ##   ##"
[//]: # "##     ## ##        ##        ##        ##  ##    ## ##     ##    ##     ##  ##     ## ##   ###      ##       ##     ##    ##    ##       ##    ##"
[//]: # "##     ## ##        ##        ######## ####  ######  ##     ##    ##    ####  #######  ##    ##      ######## ##     ##    ##    ######## ##     ##"

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

[//]: # "                  ######  ##     ## ########        ## ########  ######  ########"
[//]: # "                 ##    ## ##     ## ##     ##       ## ##       ##    ##    ##"
[//]: # "                 ##       ##     ## ##     ##       ## ##       ##          ##"
[//]: # "                  ######  ##     ## ########        ## ######   ##          ##"
[//]: # "                       ## ##     ## ##     ## ##    ## ##       ##          ##"
[//]: # "                 ##    ## ##     ## ##     ## ##    ## ##       ##    ##    ##"
[//]: # "                  ######   #######  ########   ######  ########  ######     ##"

[//]: # "                                       #### ##    ##"
[//]: # "                                        ##  ###   ##"
[//]: # "                                        ##  ####  ##"
[//]: # "                                        ##  ## ## ##"
[//]: # "                                        ##  ##  ####"
[//]: # "                                        ##  ##   ###"
[//]: # "                                       #### ##    ##"

[//]: # "##     ##  #######  ########  ########      ########  ######## ########    ###    #### ##        ######"
[//]: # "###   ### ##     ## ##     ## ##            ##     ## ##          ##      ## ##    ##  ##       ##    ##"
[//]: # "#### #### ##     ## ##     ## ##            ##     ## ##          ##     ##   ##   ##  ##       ##"
[//]: # "## ### ## ##     ## ########  ######        ##     ## ######      ##    ##     ##  ##  ##        ######"
[//]: # "##     ## ##     ## ##   ##   ##            ##     ## ##          ##    #########  ##  ##             ##"
[//]: # "##     ## ##     ## ##    ##  ##            ##     ## ##          ##    ##     ##  ##  ##       ##    ##"
[//]: # "##     ##  #######  ##     ## ########      ########  ########    ##    ##     ## #### ########  ######"









[//]: # "##       #### ##    ## ##    ##      ##          ###    ##    ## ######## ########"
[//]: # "##        ##  ###   ## ##   ##       ##         ## ##    ##  ##  ##       ##     ##"
[//]: # "##        ##  ####  ## ##  ##        ##        ##   ##    ####   ##       ##     ##"
[//]: # "##        ##  ## ## ## #####         ##       ##     ##    ##    ######   ########"
[//]: # "##        ##  ##  #### ##  ##        ##       #########    ##    ##       ##   ##"
[//]: # "##        ##  ##   ### ##   ##       ##       ##     ##    ##    ##       ##    ##"
[//]: # "######## #### ##    ## ##    ##      ######## ##     ##    ##    ######## ##     ##"

### Link layer
Tasks:
- Translate between IP and MAC with ARP.
  - Broadcasts around in the network for a machine with an spesific IP. Tha machine with IP will answer back with its MAC address.
  - Wireshark: Src: Apple_44:45:67 | Dest: Broadcast | Protocol: ARP | Len: 42 | Info: Who has 123.456.789.10? Tell 0.0.0.0
  - MAC address prefixes: http://standards-oui.ieee.org/oui/oui.txt
  - Send datagram from AtB, through R:
    - A: Dest B -> R 111.111.111.110 next hop
    - R: Dest B -> B 222.222.222.222 next hop
  - Two ARP tables in router R, one for each IP subnetwork (LAN)

Ethernet (Wired):
  - First widely used LAN technology.
  - Dominant wired LAN technology.
  - Cheap $20 for network interface card.
  - Kept up with speed race: 10Mbps - 10 Gbps
  - Frame structure:
    - Preamble: **8 bytes**. 7*10101010 + 10101011
      - Used to sync receiver, sender clock rates.
    - Dest. addr: **6 bytes**
    - Src. addr: **6 bytes**
    - Type: **2 bytes**
      - Describes how to intepret the packet. E.g. IPv4, AppleTalk, ARP...
    - Data, like an IP packet. (min **46 bytes**)
    - CRC: **4 bytes**, CRC-32 checked at reciever: if error is detected, frame is dropped.
  - Connectionless -> unreliable.
    - No handshake, like UDP in a way, between send/receive NIC (Network Interface Cards).
    - Sending NIC does not send ACKs or NACKs to sending NIC.
      - Streams kan lack datagrams (have gaps).
      - Gaps are filled inn using TCP - else application see gaps.
  - Ethernet (802.3) MAC protocol:
    - unslottet CSMA/CD.
  - Ex:
    - A <----> B
    - 10 Mbit/s ethernet.
    - Propagation delay `325 bit times => RTT = 650 bit times`
    - A transmits a frame, but B transmits a frame before A finishes. **Can A finish before it detects that B has transmittet?**
    - A starts at `t = 0`, worst case A tranmits a minimum (8 + 6 + 6 + 2 + 46 + 4) bytes = 72 bytes = 576 bits.
    - Worst case B transmits at `t = 324` because that is just below `325 bit times => T = 324+325 = 649 > 576`
    - There is a max length of the ethernet segments to be sure to detect collisions - depends on the physical medium.

Link layer switches:
  - Interconnecting switches: Plug-and-play through self-learning.
    - C sends framt to I, I responds to C.
  




[//]: # "##    ## ######## ######## ##      ##  #######  ########  ##    ##      ##          ###    ##    ## ######## ########"
[//]: # "###   ## ##          ##    ##  ##  ## ##     ## ##     ## ##   ##       ##         ## ##    ##  ##  ##       ##     ##"
[//]: # "####  ## ##          ##    ##  ##  ## ##     ## ##     ## ##  ##        ##        ##   ##    ####   ##       ##     ##"
[//]: # "## ## ## ######      ##    ##  ##  ## ##     ## ########  #####         ##       ##     ##    ##    ######   ########"
[//]: # "##  #### ##          ##    ##  ##  ## ##     ## ##   ##   ##  ##        ##       #########    ##    ##       ##   ##"
[//]: # "##   ### ##          ##    ##  ##  ## ##     ## ##    ##  ##   ##       ##       ##     ##    ##    ##       ##    ##"
[//]: # "##    ## ########    ##     ###  ###   #######  ##     ## ##    ##      ######## ##     ##    ##    ######## ##     ##"
### Network layer

#### 4.1 Intro

Services:
- Network layer service modals
- Forwarind VS. routing
- How a router works
- Routing (path selection)
- Dealing with scale

Protocols:
- IP
- ICMP (Internet Control Message Protocol)
- Routing protocols

Functions:
- Addressing
  - Global addresses crossing different network technologies.
- Fragmentation and reassembly (deprecated in IPv6, not needed)
  - Underlying network technologies have different props.
    - MTU (Maximum Transfer Unit)
    - MaxSegmSize = Congestion Control
  - Network links have an MTU
    - Largest possible link-level frame.
    - Ethernet 1500 bytes.
  - Large IP datagram divided ("fragmented") within net
    - One datagram becomes several datagrams.
    - "Reassembled" only at final destination! Else much resources is used.
- Rounting and forwarding
  - Find the route from source to destination.
  - Forward packets from input to output.
- Network interconnect
  - Different underlying network technologies.

Exists in every node (both host and router)

Routers examine header fields in all IP datagrams passing through.

Sending side encapsulation segments into datagrams.

#### 4.2 Virtual circuts and datagram

- Best effort: datagram
- Packet switching
  - Store-and-forward
  - Handles packets
  - Statistical multiplexing
- VC VS. IP (datagram)
  - VC: Connection oriented
    - Connection set-up establishment state information in network nodes.
    - Routes connections.
    - Packets follow the same path.
    - Guarantee packets in sequence.
    - Shorter headers.
    - Each packet VC number.
    - Delayed duplicates are avoided.
    - Router table space per connection.
    - Problems if subnetwork is based on datagram.
    - RTT for connection setup. Then TCP => 2 trips for sending data.
    - Raouter failures: VC terminated.
  - IP datagram: Connectionless
    - No set-up and establishment of state information.
    - Routes packets.
    - Packets take different ways to the destination.
    - Robust against network failure.
    - Congestion avoidance.
    - No requirement on underlying network.
    - Longer headers.
    - Routers do not hold state information per connection.
    - Potential for congestion.
    - No establishing delay.
    - Router failures: limited.
- VC model - signaling establishes state information
  - Connection setup packet has complete destination address.
  - Explicit connection establishment -> possibility to reserve resources.
    - Reserve resources: Band width. Memory and CPU capacity.
  - RTT (Rount-trip-time) deplay before first data packet can be sent.
  - Each data packet has a smaller identifier.
  - If a node or link fails, connection must be reestablished.
  - After establish connection we can send data (data flow).
    - Going same path both ways.
  - E.g. ATM (Asynchronous Transfer Mode).
  - Forwarding based on VC numbers:
    - Forwarding table in network node:
      <pre>
      Incoming interface | Incoming VC # | Outgoing interface | Outgoing VC #
      . . . . 1 . . . . .| . . . 12 . . .| . . . . 3 . . . . .| . . . 22
      </pre>
    - Tables are created on connection establishment.
- Datagram model - connectionless
  - We send data at once! No connection establishment/setup.
    - Sender has no knowledge of if receiver is alive.
    - Do only need to know the first hop-router.

#### 4.3 What is inside a router

Functions:
- Routing algorithm.
- Forward datagrams.

Sequence:
1. Queuing on input port if datagrams arrive faster than forwarding rate into switch fabric
    - Physical layer: Bit level reception
      - Line termination.
    - Data link layer: e.g. Ethernet, IEEE802.3
      - Data link processing (protocol, decapsulation).
    - Decentralized switching: complete input port processing at 'line speed'
      - Lookup, forwarding.
        - Given datagram destination, lookup output port using forwarding table in input port memory.
      - Queueing.
2. Switching fabric
    - Transfer packet from input buffer to appropriate output buffer.
    - Switching rate: rate at which packets can be tranferred from inputs to outputs.
      - Often measured as multiple of input/output line rate.
      - N inputs: switching rate N times line rate desirable.
    - 3 options:
      - Memory - Old - CPU controls.
        - Packet copied to systems memory
        - One packet at a time.
        - Speed limited by memory bandwidth (2 bus crossing per datagram).
        - First generation routers: traditional computers with switching under control of CPU.
      - Bus - Old
        - Datagram from input port memory to output port memory via shared bus.
        - One packet at a time. Like ethernet.
        - Bus contention: switching speed limited by bus bandwidth.
      - Crossbar - Today, beause we have much larger matrices.
        - Interconnection network.
        - Overcome bus bandwidth limitations.
        - Forwards multiple packets in parallel.
        - Switching via interconnection network
          - Banyan networks, crossbar, other interconnection nets initially developed to connect processors in multiprocessor.
          - When packet from port A needs to forward to port Y, controller closes cross point at intersection of two buses.
        - Advanced design: fragmenting datagram into fixed length cells, switch cells through the fabric.
    - Performance on router: Packets per sec [PPS]
3. Output port - queuing and loss when packets arrive from fabric faster than output line speed
    - Buffers required to queue packets
      - Buffering rule of thumb: average buffering equal to "typical" RTT * C_link
        - E.g.: R = 250 ms, C_link = 10 Gps -> 2.5 Gbit buffer.
    - Recent recommendation: with N flows, buffering equal to RTT * C_link / sqrt(N)
      - Based on experience.
    - Scheduling discipline chooses among queued datagrams for transmission.
    - Steps:
      - Queuing buffer management.
      - -> Data link processing (protocol, decapsulation).
      - -> Line termination.

#### 4.4 IP: Internet protocol

The network layer in routers and hosts

Routing protocols:
- Path selection
- RIP
- OSPF
- BGP
^
|
+---> Forwarding table.

- Datagram format
- IPv4 addressing
  - Addressing conventions.
    - Hierachical naming.
    - Subnet/22 | host => len(host) = 2^(32-22) - 2 = 2^8 - 2
    - Minus 2 for 0.0.0.0 (Router/Subnet) and 255.255.255.255 (Broadcast/DHCP request)
  - Datagram format.
    - Most fields are unchanged from source to destination.
    - Fields:
      <pre>
      Ver . . . . 4 . . | IP version (IPv4 or IPv6)
      HLen. . . . 4 . . | Number of 32 bit words in header
      TOS . . . . 8 . . | Service quality
      Length. . .16 . . | Number of bytes in the datagram
      Ident . . .16 . . | Used for fragmentation/reassembly
      Flag/Off. .16 . . | DF, MF, Offset: in *8 bytes
      TTL . . . . 8 . . | Time to live (remaining hops)
      Protocol. . 8 . . | Upper layer protocol (TCP=6, UDP=17)
      Checksum. .16 . . | Checksum for header
      Address . .32 . . | Source and destination address
      <b>Max IP datagram length</b> is 65535 bytes.
      </pre>
  - Packet handling conventions.
    <pre>
    FTP-------+ . . . . . . . . .
    SMTP-----TCP-----+. . . . . +---NET1.
    HTTP------+ . . . | . . . . |
    . . . . . . . . . +----IP---+---NET2
    . . . . . . . . . | . . . . |
    NV-------UDP-----+. . . . . +---NETₙ
    RTP-------+ . . . . . . . . .
    </pre>
  - Based on datagram and "best effort" service.
  - Makes it possible to connect a wide range of technologies.
    - Homogenous internetwork.
  - **Everything over IP**
    - Higher layer transport protocols such as TCP and UDP are applied above IP in the end systems.
  - **IP Everywhere**
    - No reqirements un underlying networks - the protocol can run everywhere.
- ICMP
  - Error reporting. E.g. TTL timeout.
  - Router "signaling".
- IPv6

#### 4.5 Routing algorithms

- Link state VS. Distance vector
- Hierarchical routing


[//]: # "######## ########     ###    ##    ##  ######  ########   #######  ########  ########      ##          ###    ##    ## ######## ########"
[//]: # "   ##    ##     ##   ## ##   ###   ## ##    ## ##     ## ##     ## ##     ##    ##         ##         ## ##    ##  ##  ##       ##     ##"
[//]: # "   ##    ##     ##  ##   ##  ####  ## ##       ##     ## ##     ## ##     ##    ##         ##        ##   ##    ####   ##       ##     ##"
[//]: # "   ##    ########  ##     ## ## ## ##  ######  ########  ##     ## ########     ##         ##       ##     ##    ##    ######   ########"
[//]: # "   ##    ##   ##   ######### ##  ####       ## ##        ##     ## ##   ##      ##         ##       #########    ##    ##       ##   ##"
[//]: # "   ##    ##    ##  ##     ## ##   ### ##    ## ##        ##     ## ##    ##     ##         ##       ##     ##    ##    ##       ##    ##"
[//]: # "   ##    ##     ## ##     ## ##    ##  ######  ##         #######  ##     ##    ##         ######## ##     ##    ##    ######## ##     ##"

### Transport layer

ACKs n stuff

[//]: # "   ###    ########  ########  ##       ####  ######     ###    ######## ####  #######  ##    ##      ##          ###    ##    ## ######## ########"
[//]: # "  ## ##   ##     ## ##     ## ##        ##  ##    ##   ## ##      ##     ##  ##     ## ###   ##      ##         ## ##    ##  ##  ##       ##     ##"
[//]: # " ##   ##  ##     ## ##     ## ##        ##  ##        ##   ##     ##     ##  ##     ## ####  ##      ##        ##   ##    ####   ##       ##     ##"
[//]: # "##     ## ########  ########  ##        ##  ##       ##     ##    ##     ##  ##     ## ## ## ##      ##       ##     ##    ##    ######   ########"
[//]: # "######### ##        ##        ##        ##  ##       #########    ##     ##  ##     ## ##  ####      ##       #########    ##    ##       ##   ##"
[//]: # "##     ## ##        ##        ##        ##  ##    ## ##     ##    ##     ##  ##     ## ##   ###      ##       ##     ##    ##    ##       ##    ##"
[//]: # "##     ## ##        ##        ######## ####  ######  ##     ##    ##    ####  #######  ##    ##      ######## ##     ##    ##    ######## ##     ##"

### Applikasjon layer

FTP-stuff

[//]: # "##      ## #### ########  ######## ##       ########  ######   ######          ###    ##    ## ########       ##     ##  #######  ########  #### ##       ########"
[//]: # "##  ##  ##  ##  ##     ## ##       ##       ##       ##    ## ##    ##        ## ##   ###   ## ##     ##      ###   ### ##     ## ##     ##  ##  ##       ##"
[//]: # "##  ##  ##  ##  ##     ## ##       ##       ##       ##       ##             ##   ##  ####  ## ##     ##      #### #### ##     ## ##     ##  ##  ##       ##"
[//]: # "##  ##  ##  ##  ########  ######   ##       ######    ######   ######       ##     ## ## ## ## ##     ##      ## ### ## ##     ## ########   ##  ##       ######"
[//]: # "##  ##  ##  ##  ##   ##   ##       ##       ##             ##       ##      ######### ##  #### ##     ##      ##     ## ##     ## ##     ##  ##  ##       ##"
[//]: # "##  ##  ##  ##  ##    ##  ##       ##       ##       ##    ## ##    ##      ##     ## ##   ### ##     ##      ##     ## ##     ## ##     ##  ##  ##       ##"
[//]: # " ###  ###  #### ##     ## ######## ######## ########  ######   ######       ##     ## ##    ## ########       ##     ##  #######  ########  #### ######## ########"

### Wireless and mobile

#### 6.1 Intro

Elements in a network:
- Wireless hosts.
- Wireless links.
- Base station.
- Network infrastructure.

Ad-hoc mode:
- **No base** stations
- Nodes can only transmit to other nodes within link coverage.
- Nodes organize themselves into a network: route among themselves.

Classifying wireless networks:

| | Infrastructure-based | Infrastructure-less
| --- | --- | ---
| Single-hop | Base station connected to a larger wired network. **Ex: 802.11 in public and 3G** | Base station not connected to wireless network. **Ex: Bluetooth and ad hoc in 802.11**
| Multi-hop | Base station is wired to the larger network. Nodes may connect through other wireless nodes in network. **Ex: Some wireless sensor and wireless mesh networks** | No base, so relay on other nodes to reach destination. Nodes can be mobile. **Ex: Mobile (MANETs) and vehicular (VANET) ad hoc**

#### 6.2

CDMA er ikke pensum lengre.

#### 6.3

IEEE 802.11 wireless LAN
- CSMA/CA for muliple access.
- Base station and ad-hoc
  - Base station = access point (AP)
- Basic Service Set (BSS)

To avoid data frame collisions, make small reservation packets.
- This works for long frames such that you can reserve a channel for a while.
- First it transmits small RTS (request-to-send) packets using CSMA.
  - Since they are small they does not cost much on collision, making this option optimal.
- Access point then broadcasts CTS (clear-to-send) to the RTS request.
  - All nodes will also hear the CTS, but only the sender got permission.
- After sending the long packet, the receiver sends back an ACK.

802.3 contains:
- Source address.
- Destination address.
- Type.
- Length.
- Frame.
- Checksum.

802.11 contains:
- Frame control.
  - Protocol version.
  - Type.
  - SybType.
    - Management (beacon, probe, auth).
    - Control (RTS, CTS, ACK).
    - Data.
  - To AP.
  - From AP.
  - More frag.
  - Retry.
  - Power mgt.
  - Mora data.
  - WEP (added security/enscryption).
  - Rsvd.
- Duration - transmission time (data + ACK) in RTS/CTS and data frames in nanosec.
- Address 1 (MAC to source).
- Address 2 (MAC to destination).
- Address 3 (MAC to router).
- Seq - for re,iable data transfer.
- Address 4.
- Payload.
- CRC.


[//]: # "       ######  ########  ######  ##     ## ########  #### ######## ##    ##"
[//]: # "      ##    ## ##       ##    ## ##     ## ##     ##  ##     ##     ##  ##"
[//]: # "      ##       ##       ##       ##     ## ##     ##  ##     ##      ####"
[//]: # "       ######  ######   ##       ##     ## ########   ##     ##       ##"
[//]: # "            ## ##       ##       ##     ## ##   ##    ##     ##       ##"
[//]: # "      ##    ## ##       ##    ## ##     ## ##    ##   ##     ##       ##"
[//]: # "       ######  ########  ######   #######  ##     ## ####    ##       ##"

[//]: # "                              #### ##    ##"
[//]: # "                               ##  ###   ##"
[//]: # "                               ##  ####  ##"
[//]: # "                               ##  ## ## ##"
[//]: # "                               ##  ##  ####"
[//]: # "                               ##  ##   ###"
[//]: # "                              #### ##    ##"

[//]: # " ######   #######  ##     ## ########  ##     ## ######## ######## ########"
[//]: # "##    ## ##     ## ###   ### ##     ## ##     ##    ##    ##       ##     ##"
[//]: # "##       ##     ## #### #### ##     ## ##     ##    ##    ##       ##     ##"
[//]: # "##       ##     ## ## ### ## ########  ##     ##    ##    ######   ########"
[//]: # "##       ##     ## ##     ## ##        ##     ##    ##    ##       ##   ##"
[//]: # "##    ## ##     ## ##     ## ##        ##     ##    ##    ##       ##    ##"
[//]: # " ######   #######  ##     ## ##         #######     ##    ######## ##     ##"

[//]: # "##    ## ######## ######## ##      ##  #######  ########  ##    ##  ######"
[//]: # "###   ## ##          ##    ##  ##  ## ##     ## ##     ## ##   ##  ##    ##"
[//]: # "####  ## ##          ##    ##  ##  ## ##     ## ##     ## ##  ##   ##"
[//]: # "## ## ## ######      ##    ##  ##  ## ##     ## ########  #####     ######"
[//]: # "##  #### ##          ##    ##  ##  ## ##     ## ##   ##   ##  ##         ##"
[//]: # "##   ### ##          ##    ##  ##  ## ##     ## ##    ##  ##   ##  ##    ##"
[//]: # "##    ## ########    ##     ###  ###   #######  ##     ## ##    ##  ######"

### Security in computer networks

Symmetric key:
- Faster -> Less CPU while being secure.
- Same key for both encrypt and decrypt.
- Less secure if the medium is less secure.
- Cannot sign as the key does belong to more than one end.
Public key:
- Slower -> Needs more math.
- Needs a private key and a public one.
- Can be used over less secure networks as long you do not exploit your private key.
- Can sign and verify the author.
- RSA is using this idea.

Signing:
- Normally you can use `m + H(m + s) = m'`.
  - m = Message
  - H = Hashfunction (SHA-1, MD5, etc..)
  - s = Secret - must be available in both ends - and not by a middleman.
  - m' = Message with signing. This can then be verified as the end know the secret value.
- A valid signing process should make sure author and integrity is correct. The method above keeps both.

MAC VS. digital signing:
- MAC (Message Authentication Code)
  - Do not rely on encryption.
- Digital signing
  - Must have public key infrastructure -> to verify the author.
  - DS is also used for digital certificates.
- Both
  - Uses hash.
  - Are extensively used in practice.

Securing wireless LANs:
- WiFi used 802.11 spesification - today with 802.11i which is more secure.
- WEP (Wired Equivalent Privacy)
  - Goal is to act like wired network when it comes to security.
  - Steps:
    1. Wireless host requests auth by access point.
    2. Access point responds to auth with 128-byte **nonce** (one time hash) value.
    3. Wireless host encrypts the **nonce** using symmetric key that is then shared with access point.
    4. Access point then decrypts the **nonce**.

Firewalls:
- Goals:
  - All traffic from outside to inside, and vice versa, passes through the firewall.
  - Only auth traffic, as defined by local security policy, will be allowed to pass.
  - The firewall itself is immune to penetration.
- Cisco and Check Point are leading firewall vendors today (2015). Can create firewall using iptables on Linux.
- Categories to callify firewalls:
  - Traditional packet filters.
    - Every packet goes through one router to the public Internet - this router is the "filter".
    - Filter rules:
      - IP source/dest.
      - Protocol type in IP datagram field: TCP, UDP, ICMP, OSPF...
      - TCP flag bits: SYN, ACK...
      - ICMP message type.
      - Rules for datagrams leaving/entering the network.
      - Rules for router interfaces.
    - Example rules:

      | Policy | Firewall setting
      | --- | ---
      | No outside Web access. | Drop all outgoing packets to any IP address, port 80.
      | Prevent network for being used for a smurf DoS attack. | Drop all ICMP ping packets going to a broadcast address (xx.xx.255.255).
    - Rules in table:

      | Action | Src | Dest | Protocol | Src port | Dest port | Flag bit
      | --- | --- | --- | --- | --- | --- | ---
      | allow | xxx.xx/x | outside of xxx.xx/x | TCP | > 1337 | 80 | ACK
  - Stateful filters.
    - Can watch the connections, making handshakes (SYN, SYNACK, ACK) and end calls (FIN) visible.
    - This method can then check if the incoming request was requested by anyone from inside the firewall.
    - The connection can then watch the sessions from handshake to closed connection (ACKs should also be correct to see an ongoing connection).
  - Application gateways.
    - Decides which application data that should arrive to the applications.
    - Looks beyond TCP/UDP/IP headers.

[//]: # "##     ## ##     ## ##       ######## #### ##     ## ######## ########  ####    ###"
[//]: # "###   ### ##     ## ##          ##     ##  ###   ### ##       ##     ##  ##    ## ##"
[//]: # "#### #### ##     ## ##          ##     ##  #### #### ##       ##     ##  ##   ##   ##"
[//]: # "## ### ## ##     ## ##          ##     ##  ## ### ## ######   ##     ##  ##  ##     ##"
[//]: # "##     ## ##     ## ##          ##     ##  ##     ## ##       ##     ##  ##  #########"
[//]: # "##     ## ##     ## ##          ##     ##  ##     ## ##       ##     ##  ##  ##     ##"
[//]: # "##     ##  #######  ########    ##    #### ##     ## ######## ########  #### ##     ##"

[//]: # "##    ## ######## ######## ##      ##  #######  ########  ##    ## #### ##    ##  ######"
[//]: # "###   ## ##          ##    ##  ##  ## ##     ## ##     ## ##   ##   ##  ###   ## ##    ##"
[//]: # "####  ## ##          ##    ##  ##  ## ##     ## ##     ## ##  ##    ##  ####  ## ##"
[//]: # "## ## ## ######      ##    ##  ##  ## ##     ## ########  #####     ##  ## ## ## ##   ####"
[//]: # "##  #### ##          ##    ##  ##  ## ##     ## ##   ##   ##  ##    ##  ##  #### ##    ##"
[//]: # "##   ### ##          ##    ##  ##  ## ##     ## ##    ##  ##   ##   ##  ##   ### ##    ##"
[//]: # "##    ## ########    ##     ###  ###   #######  ##     ## ##    ## #### ##    ##  ######"

### Multimedia networking

Fixed playout delays:
- What: When data is streamed, we want a continous/uninterrupted flow.
- Problem: Packets arrive destination at different times (async requests) which makes some packets "too late" for the "live show".
- Solution: Add some more time for the lastest packets to arrive.

CDN (Content Distribution Network):
- What: Services that provide content.
- Problem: Hard to get content fast. Especially movies at a reasonable pace according to the clients transmission rate.
- Solution: Offer service that can distribute content faster by having duplicate files (static files - as they are much easier to save) on different servers around the globe.
  - They can then serve the files from near locations - making it alot faster.
    - Uses ping to find the closest choice.
  - The IP address can also be the same as long as the servers have duplicated content.
