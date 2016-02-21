def addledd(tall, xer=0, fortegn=0):
    if tall == 0:
        return ""
    else:
        if fortegn == 0 or (a == 0 and xer == 1) or (a == 0 and b == 0 and xer == 0):
            ledd = str(tall)
        elif tall < 0:
            ledd = " - "*fortegn + str(-tall)
        else:
            ledd = " + "*fortegn + str(tall)

        ledd += "x*"*xer

        if xer > 0:
            ledd = ledd[:-1]

        return ledd


a = int(input("Hva skal være a: ") or 0)
b = int(input("Hva skal være b: ") or 0)
c = int(input("Hva skal være c: ") or 0)

d = b**2 - 4*a*c

if d < 0:
    print("Ligningen %s%s%s = 0 har to imaginære løsninger." % (addledd(a, 2), addledd(b, 1, 1), addledd(c, fortegn=1)))
elif d > 0:
    print("Ligningen %s%s%s = 0 har to reelle løsninger." % (addledd(a, 2), addledd(b, 1, 1), addledd(c, fortegn=1)))
else:
    print("Ligningen %s%s%s = 0 har én reell dobbeltrot." % (addledd(a, 2), addledd(b, 1, 1), addledd(c, fortegn=1)))
