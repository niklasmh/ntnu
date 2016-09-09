#!/usr/bin/python3
from sys import stdin

def main():
    ol = map(ord, list(stdin.readline())) # Word List
    s = map(ord, stdin.read()) # Search

    wt = ({}, []) # Word Tree
    p = [] # Positions
    sc = 0 # Save Count
    ac = 0 # Add Count

    #if 63 in set(s): # May use this instead
    #if 63 in s or True:
    #    print("? found! Going into advanced build")
    for c, l in enumerate(ol):
        if 96 < l < 123:
            p.append(l)
            continue
        if l is 63:
            p.append(l)
            continue
        if l is 32 or l is 10:
            n = wt
            for i in p:
                if i not in n[0]:
                    n[0][i] = ({}, [])
                n = n[0][i]
            n[1].append(sc)
            ac = ac + 1
            sc = c + ac
            p = []
    #else:
    #    print("? not found! Going into easy build")

    b = [] # Build array
    p = [] # Positions

    for o in s:
        if 96 < o < 123:
            b.append(o)
            continue
        if o is 10:
            print("".join(map(chr, b)) + ":", end="")
            n = wt
            for l in b:
                if l in n[0]:
                    n = n[0][l]
            p.extend(n[1])
            p.sort()
            for i in p:
                print(" " + str(i), end="")
            print()
            b = []
            p = []

    
main()
