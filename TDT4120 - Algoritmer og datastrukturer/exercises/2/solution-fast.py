#!/usr/bin/python3

from sys import stdin, stderr
import traceback

class Node:
    def __init__(self):
        self.barn = {}
        self.posi = []

def bygg(ordliste):
    node = Node()
    snode = node
    for element in ordliste:
        node = snode
        for i, letter in enumerate(element[0]):
            if letter not in node.barn:
                node.barn[letter] = Node()
            if i + 1 >= len(element[0]):
                node.barn[letter].posi.append(element[1])
            node = node.barn[letter]
    return snode

def posisjoner(ord, indeks, node):
    try:
        return posisjoner(ord, indeks + 1, node.barn[ord[indeks]])
    except:
        return node.barn[ord[indeks]].posi

def main():
    try:
        ord = stdin.readline().split()
        ordliste = []
        pos = 0
        for o in ord:
            ordliste.append((o, pos))
            pos += len(o) + 1
        toppnode = bygg(ordliste)
        for sokeord in stdin:
            sokeord = sokeord.strip()
            print("%s:" % sokeord, end='')
            posi = posisjoner(sokeord, 0, toppnode)
            posi.sort()
            for p in posi:
                print(" %s" % p, end='')
            print()
    except:
        traceback.print_exc(file=stderr)

if __name__ == "__main__":
    main()