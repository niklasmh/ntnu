a = 5
inpt = input("Skriv inn et tall: ")
while not (inpt.isdigit()):
    inpt = input("Skriv inn et tall, din jævel: ")

b = int(inpt)

if a*b < a+b:
    print("Det minste er a*b som blir %d*%d = %d" % (a, b, a*b))
elif a*b > a+b:
    print("Det minste er a+b som blir %d+%d = %d" % (a, b, a+b))
else:
    print("Både a*b og a+b er like og blir %d*%d = %d+%d = %d" % (a, b, a, b, a*b))

svar = int(input("\nOg hva er 3*4? "))

while svar != 12:
    svar = int(input("Det var feil, prøv igjen: "))

print("Riktig! Gratz bro")