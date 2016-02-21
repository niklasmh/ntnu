__author__ = 'Niklas'
# -*- coding: utf-8 -*-

# a)


filename = 'tall.txt'


def addtofile(antall=100):
    f = open(filename, 'w')
    for i in range(antall):
        f.write(str(i) + "\n")
    f.close()

#addtofile()


# b)


def checkfile():
    with open(filename, 'r') as f:
        i = 0
        tall = []
        for line in f:
            tall += line.split() # split() just in case. Tallene kan være separert med mellomrom.
        for t in tall:
            if int(t) == int(i):
                print(str(t) + ": Korrekt!")
            else:
                print(str(t) + ": Feil!")
            i += 1

#checkfile()


# c)


def main():
    respons = " "
    while respons != "":
        respons = input("Blank for å stoppe\n1: Skrive inn til fil\n2: Lese fra fil\n")

        if respons == '1':
            f = open(filename, 'w')
            txt = input("Første linje (blank for å avslutte fila)\n")
            while txt != "":
                f.write(txt + "\n")
                txt = input("Neste linje (blank for å avslutte fila)\n")
            f.close()
        elif respons == '2':
            print("-- Åpner '" + filename + "' --")
            print(open(filename, 'r').read())
            print("-- Ferdig --\n")
        else:
            print("Done!")

main()