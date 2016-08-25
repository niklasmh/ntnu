__author__ = 'Niklas'


def plus(a, b):
    return a+b


def minus(a, b):
    return a-b


def gange(a, b):
    return a*b


def dele(a, b):
    return a/b

a = int(input("Første tall: "))
o = ""
while o != "+" and o != "-" and o != "*" and o != "/":
    o = input("Hvilken operasjon vil du utføre av \"+\", \"-\", \"*\" eller \"/\"? ")

operasjon = "legge til"
if o == "-":
    operasjon = "trekke ifra"
elif o == "*":
    operasjon = "gange med"
elif o == "/":
    operasjon = "dele med"

b = int(input("Hva vil du %s %d? " % (operasjon, a)))

svar = 0
if o == "-":
    svar = minus(a, b)
elif o == "*":
    svar = gange(a, b)
elif o == "/":
    svar = dele(a, b)
else:
    svar = plus(a, b)

print("Din operasjon resulterte slik: %d%s%d = %.2f" % (a, o, b, svar))
