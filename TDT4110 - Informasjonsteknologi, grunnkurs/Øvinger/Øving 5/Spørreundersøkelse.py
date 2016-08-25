__author__ = 'Niklas'
# -*- coding: utf-8 -*-


def brukerenikkevilsvare():
    svar = (input("Vil du fortsatt svare?\n") or "")

    if svar == "":
        svar = (input("Skjer med å ignorere?\n") or "")

        if svar == "":
            quit()
        else:
            print("Bra du fortsatt henger med.\n")
            return True
    else:
        print("Bra.\n")
        return True


def main():
    avslutt = False
    eromstart = False
    while not avslutt:
        if eromstart:
            # omstart = (input("Vil du starte på nytt?\n1: Ja\n2: Nei") or "2")
            # while omstart != "1" and omstart != "2":
            #     omstart = (input("Gi et ordentlig svar:\n1: Ja\n2: Nei") or "2")
            omstart = "1"
        else:
            omstart = "1"
            eromstart = True

        if omstart == "1":

            # a)
            kjonn = input("Hvilket kjønn?\nm: Male\nf: Female\n")
            while kjonn != "m" and kjonn != "f":
                kjonn = input("Hvilket kjønn?\nm: Male\nf: Female\n")

            kjonn = 0 if kjonn == "m" else 1

            med = brukerenikkevilsvare()
            if not med:
                avslutt = True

            # b)
            alder = input("Hvor gammel? (Skriv et heltall)\n")

            while not alder.isdigit():
                alder = input("Hvor gammel? (Skriv et heltall)\n")

            alder = int(alder)

            # c)
            if not 16 <= alder <= 25:
                print("Du kan ikke ta spørreundersøkelsen pga alder.\n")
                avslutt = True
            else:
                med = brukerenikkevilsvare()
                if not med:
                    avslutt = True

                fag = input("Tar du et fag?\n1: Ja\n2: Nei\n")
                while fag != "1" and fag != "2":
                    fag = input("Gjør du??\n1: Ja\n2: Nei\n")

                med = brukerenikkevilsvare()
                if not med:
                    avslutt = True

                # d)
                itgkspm = "Tar virkelig du ITGK?\n1: Ja\n2: Nei\n"
                if alder < 22:
                    itgkspm = "Tar du ITGK?\n1: Ja\n2: Nei\n"

                variabelmedlem_ITGK = input(itgkspm)
                while variabelmedlem_ITGK != "1" and variabelmedlem_ITGK != "2":
                    variabelmedlem_ITGK = input(itgkspm)

                med = brukerenikkevilsvare()
                if not med:
                    avslutt = True

                timer_lekser = input("Hvor mange timer bruker du daglig på lekser? (Heltall)\n")
                while not timer_lekser.isdigit():
                    timer_lekser = input("Hvor mange timer bruker du daglig på lekser? (Heltall)\n")

                timer_lekser = int(timer_lekser)

                statistikk = "Statistikk:\n\nKjønn: " + ("Mann" if kjonn == "m" else "Kvinne") + "\nAlder:" + str(alder) + "\nTar fag: " + ("Ja" if fag == "1" else "Nei") + "\nTar ITGK: " + ("Ja" if variabelmedlem_ITGK == "1" else "Nei") + "\nTimer daglig:" + str(timer_lekser)

                print(statistikk)

                sikker = input("Vil du avslutte?\n1: Ja\n2: Nei\nEller skriv hade\n")
                while sikker != "1" and sikker != "2" and sikker != "hade":
                    sikker = input("Vil du avslutte?\n1: Ja\n2: Nei\n")

                if sikker == "1" or sikker == "hade":
                    print("Hade!")
                    avslutt = True
                else:
                    print("Bra, da starter vi på nytt :)\n\n")
        else:
            avslutt = True

main()

# Nei, det skal ikke være mulig å hente de ettersom de lå lokalt i en funksjon.



