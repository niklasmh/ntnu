__author__ = 'Niklas'


def isheltallmellom0og100(num):
    if not num.isdigit():
        return False
    elif num > 100 or num < 0:
        return False
    else:
        return True


poeng = input("Hvor mange poeng fikk du på exphil-eksamen? ")

while not isheltallmellom0og100(poeng):
    if poeng.isdigit():
        if poeng > 100:
            poeng = input("IKKE GODKJENT!! Men hva fikk du egentlig? ")
        else:
            poeng = input("Du gjør meg stolt! Men vi må være litt seriøse. Hva fikk du? ")
    else:
        poeng = input("Skriv inn et heltall: ")

p = int(poeng)

if p >= 89:
    print("Du fikk en A? Dette er ikke akseptabelt!")
elif p >= 77:
    print("B er slettes ikke greit.")
elif p >= 65:
    print("C er på grensa til for bra.")
elif p >= 53:
    print("D. Du er en verdig NTNU student!")
elif p >= 41:
    print("E er bra! Du gjør både mor og far og meg stolt! Stå på videre.")
else:
    print("Du gav mest faen i faget som mulig. Dette krever respekt! Og en F :)")

