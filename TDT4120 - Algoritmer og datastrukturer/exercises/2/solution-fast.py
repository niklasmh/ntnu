#!/usr/bin/python3

from sys import stdin, stderr
import traceback

def bygg(ol):
    n = ({}, [])
    sn = n
    for e in ol:
        n = sn
        for i, l in enumerate(e[0]):
            if l not in n[0]:
                n[0][l] = [{}, []]
            if i + 1 >= len(e[0]):
                n[0][l][1].append(e[1])
            n = n[0][l]
    return sn

def posisjoner(o, i, n):
    try:
        l = ord(o[i])
        if l == 63:
            i = i + 1
            ps = []
            for b in n[0]:
                if i == len(o):
                    for p in n[0][b][1]:
                        ps.append(p)
                try:
                    for p in posisjoner(o, i, n[0][b]):
                        ps.append(p)
                except:
                    continue
            return ps
        else:#if 96 < l < 123:
            return posisjoner(o, i + 1, n[0][o[i]])
    except:
        try:
            return n[0][o[i]][1]
        except:
            return []

def main():
    try:
        os = stdin.readline().split()
        ol = []
        p = 0
        for o in os:
            ol.append((o, p))
            p += len(o) + 1
        tn = bygg(ol)
        for so in stdin:
            so = so.strip()
            print("%s:" % so, end='')
            p = posisjoner(so, 0, tn)
            p.sort()
            for p in p:
                print(" %s" % p, end='')
            print()
    except:
        traceback.print_exc(file=stderr)

if __name__ == "__main__":
    main()
