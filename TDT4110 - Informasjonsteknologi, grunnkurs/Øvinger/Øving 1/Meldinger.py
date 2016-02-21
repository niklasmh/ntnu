i = 0

def logg(tid, navn, meld):
    global i
    i += 1
    print("Msg", str(i) + ","+tid+":", navn, "sendte foelgende melding: \"" + meld + "\"")

def main():
    logg("23:59", "Mr.Y", "Har du mottatt pakken?")
    logg("0:00", "Mdm. Evil", "Ja. Pakken er mottatt.")
    logg("0:03", "Dr. Horrible", "All you need is love!")
    logg("0:09", "Mr. Y", "Dr. Horrible, Dr. Horrible, calling Dr. Horrible .")
    logg("0:09", "Mr. Y", "Dr. Horrible, Dr. Horrible wake up now.")
    logg("0:09", "Dr. Horrible", "Up now!")

main()
