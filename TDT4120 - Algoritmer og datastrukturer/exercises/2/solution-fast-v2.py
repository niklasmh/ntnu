#!/usr/bin/python3
from sys import stdin

def main():
    ol = map(ord, list(stdin.readline())) # Word List
    s = map(ord, stdin.read()) # Search

    wt = ({}, []) # Word Tree
    p = [] # Positions
    sc = 0 # Save Count
    ac = 0 # Add Count
    
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
    
    b = [] # Build array
    p = [] # Positions
    br = False # Break
    pb = {} # PosiBilities

    for o in s:
        if 96 < o < 123:
            b.append(o)
            continue
        if o is 63:
            b.append(o)
            continue
        if o is 10:
            print("".join(map(chr, b)) + ":", end="")
            n = wt
            for l in b:
                if l is 63:
                    print("?", end="")
                    # Giving up... This loop is going to be slow anyway
                    #    if m in n[0]:
                    #        n = n[0][m]
                    #    else:
                    #print(" " + chr(m), end="")
                    #p.extend(n[1])
                    #break
                    #if l in n[0]:
                    #        n = n[0][l]
                elif l in n[0]:
                    n = n[0][l]
                else:
                    print()
                    b = []
                    p = []
                    br = True
                    break
            if br:
                br = False
                continue
            
            p.extend(n[1])
            p.sort()
            for i in p:
                print(" " + str(i), end="")
            print()
            b = []
            p = []

main()
