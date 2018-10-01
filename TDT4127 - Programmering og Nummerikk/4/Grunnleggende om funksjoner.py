#!/usr/bin/python3

''' a)
def siksak():
    print()                                         ##
    print("**  **  **  **  **  **  **  **  **")     ##
    print("  **  **  **  **  **  **  **  **")       ##
    print()                                         ##

print("Data fra spørreundersøkelse")
siksak()
print("Del 1: ... div. data her, ikke vist")
siksak()
print("Del 2: ... mer data ...")
siksak()
print("Del 3: ... enda mer data ...")
siksak()
print("Del 4: ... ytterligere data ...")
#'''

''' b)
from turtle import *
 
def flyto(x, y):
    up()
    goto(x, y)
    down()

def draw(farge, radius):
    begin_fill()
    color(farge)
    circle(radius)
    end_fill()

bgcolor("grey")

# tegner ansikt
flyto(0, -100)
draw("yellow", 100)

# det ene øyet
flyto(-30, 20)
draw("green", 20)

# pupill
draw("black", 10)

# det andre øyet
flyto(30, 20)
draw("green", 20)

# pupill
draw("black", 10)

# munnen
flyto(0, -50)
pensize(5)
color("red")
circle(50,30)
circle(50,-60)
#'''

''' c)
def komparativ(adj):
    # GROVT FORENKLET FOR Å KUNNE FOKUSERE PÅ HOVEDPOENGET
    if len(adj) >= 8: # unøyaktig
        svar = "mer " + adj
    else:
        svar = adj + "ere"
    return svar

### TILLEGG 1, ny funksjon, kommer her:
def superlativ(adj):
    # GROVT FORENKLET FOR Å KUNNE FOKUSERE PÅ HOVEDPOENGET
    if len(adj) >= 8: # unøyaktig
        svar = "mere " + adj
    else:
        svar = adj + "est"
    return svar

#DEL AV KODEN HVOR SYSTEMET DISSER BRUKEREN
adj = input("Beskriv deg selv med et adjektiv: ")
print("Hah! Jeg er mye", komparativ(adj), "!")

### TILLEGG 2 kommer her ...
print("Jeg er faktisk", superlativ(adj), "i hele verden.")

# DEL AV KODEN HVOR BRUKEREN TRENER PÅ Å GRADBØYE
adj = input("Skriv inn et adjektiv: ")
svar = input("Hva er komparativ for" + adj + "? ")
fasit = komparativ(adj)
if svar == fasit:
    print("Korrekt!")
else:
    print("Feil, det var", fasit)

### TILLEGG 3 kommer her...
adj = input("Skriv inn et adjektiv: ")
svar = input("Hva er superlativ for" + adj + "? ")
fasit = superlativ(adj)
if svar == fasit:
    print("Korrekt!")
else:
    print("Feil, det var", fasit)
#'''

''' d)
def main():
    def komparativ(adj):
        # GROVT FORENKLET FOR Å KUNNE FOKUSERE PÅ HOVEDPOENGET
        if len(adj) >= 8: # unøyaktig
            svar = "mer " + adj
        else:
            svar = adj + "ere"
        return svar

    ### TILLEGG 1, ny funksjon, kommer her:
    def superlativ(adj):
        # GROVT FORENKLET FOR Å KUNNE FOKUSERE PÅ HOVEDPOENGET
        if len(adj) >= 8: # unøyaktig
            svar = "mere " + adj
        else:
            svar = adj + "est"
        return svar

    #DEL AV KODEN HVOR SYSTEMET DISSER BRUKEREN
    adj = input("Beskriv deg selv med et adjektiv: ")
    print("Hah! Jeg er mye", komparativ(adj), "!")

    ### TILLEGG 2 kommer her ...
    print("Jeg er faktisk", superlativ(adj), "i hele verden.")

    # DEL AV KODEN HVOR BRUKEREN TRENER PÅ Å GRADBØYE
    adj = input("Skriv inn et adjektiv: ")
    svar = input("Hva er komparativ for" + adj + "? ")
    fasit = komparativ(adj)
    if svar == fasit:
        print("Korrekt!")
    else:
        print("Feil, det var", fasit)

    ### TILLEGG 3 kommer her...
    adj = input("Skriv inn et adjektiv: ")
    svar = input("Hva er superlativ for" + adj + "? ")
    fasit = superlativ(adj)
    if svar == fasit:
        print("Korrekt!")
    else:
        print("Feil, det var", fasit)

main()
#'''
