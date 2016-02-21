__author__ = 'Niklas'
# -*- coding: utf-8 -*-

brett = [[0]*9 for i in range(10)]

def tegn(brett):
    print("    0 1 2   3 4 5   6 7 8 ")
    for i in range(9):
        if i % 3 == 0:
            print("  +-------+-------+-------+")
        print(str(i) + " | " + " ".join([((" " if b == 0 else str(b)) + " |" if (k+1) % 3 == 0 else (" " if b == 0 else str(b))) for k, b in enumerate(brett[i])]))
    print("  +-------+-------+-------+")

tegn(brett)

def sjekk(brett):
    for i, e in enumerate(brett):
        if not unik(e):
            return False

    for i, e in enumerate([[brett[c][b] for c in range(len(brett))] for b in range(len(brett[0]))]):
        if not unik(e):
            return False
    return True


def unik(rekke):
    print(rekke)
    for i, e in enumerate(rekke):
        for j, f in enumerate(rekke):
            if ((e == f or f == 0) and i != j):
                return False
    print("true")
    return True


def ledig(x, y, brett):
    if str(x).isdigit() and str(y).isdigit():
        return brett[max(min(int(y), 8), 0)][max(min(int(x), 8), 0)] == 0
    return True


def valid(x, y, z, brett):
    if str(x).isdigit() and str(y).isdigit() and str(z).isdigit():
        return (0 <= int(x) <= 8) and (0 <= int(y) <= 8) and (0 <= int(z) <= 9)
    return False


def main():
    while not sjekk(brett):
        coords = input("x y z (z er verdien)\n").split()

        if len(coords) < 1:
            coords = [0, 0, -1]
        if len(coords) < 2:
            coords = [coords[0], 0, -1]
        if len(coords) < 3:
            coords = [coords[0], coords[1], -1]

        while not (valid(coords[0], coords[1], coords[2], brett) and ledig(coords[0], coords[1], brett)):
            coords = input("x y z (z er verdien) Forsøk på nytt, invalid input.\n").split()
            if len(coords) < 1:
                coords = [0, 0, -1]
            if len(coords) < 2:
                coords = [coords[0], 0, -1]
            if len(coords) < 3:
                coords = [coords[0], coords[1], -1]

        x = int(coords[0])
        y = int(coords[1])

        brett[y][x] = int(coords[2])
        tegn(brett)


split = [0, 10, 20, 29, 39, 48, 57, 67, 77, 82, 91, 100, 109, 119, 128, 138, 148, 158, 168, 177, 186, 196, 206, 217,
         227, 236, 245, 250, 255, 269, 279, 289, 294, 299, 303, 308, 316, 324, 330, 336]
line = [
"   ###    ########   ######  ########  ######## ########  ######   ##     ## ####       ## ##    ## ##       ##     ## ##    ##  #######  ########   #######  ########   ######  ######## ##     ## ##     ## ##      ## ##     ## ##    ## ########      ####       ####### ## #####     ###         ####      ##                    ### ###   ",
"  ## ##   ##     ## ##    ## ##     ## ##       ##       ##    ##  ##     ##  ##        ## ##   ##  ##       ###   ### ###   ## ##     ## ##     ## ##     ## ##     ## ##    ##    ##    ##     ## ##     ## ##  ##  ##  ##   ##   ##  ##       ##       ####      ####      ##    ##  ##   ##       ####     ####                  ##     ##  ",
" ##   ##  ##     ## ##       ##     ## ##       ##       ##        ##     ##  ##        ## ##  ##   ##       #### #### ####  ## ##     ## ##     ## ##     ## ##     ## ##          ##    ##     ## ##     ## ##  ##  ##   ## ##     ####       ##        ####     ## ##     ## ##  ##    ###                   ##                  ##       ## ",
"##     ## ########  ##       ##     ## ######   ######   ##   #### #########  ##        ## #####    ##       ## ### ## ## ## ## ##     ## ########  ##     ## ########   ######     ##    ##     ## ##     ## ##  ##  ##    ###       ##       ##          ##     ##  ###### ##  #  ## ##     ## #### ####          #######         ##       ## ",
"######### ##     ## ##       ##     ## ##       ##       ##    ##  ##     ##  ##  ##    ## ##  ##   ##       ##     ## ##  #### ##     ## ##        ##  ## ## ##   ##         ##    ##    ##     ##  ##   ##  ##  ##  ##   ## ##      ##      ##                 #######     ##  ## ## ######### #### ####      ##                  ##       ## ",
"##     ## ##     ## ##    ## ##     ## ##       ##       ##    ##  ##     ##  ##  ##    ## ##   ##  ##       ##     ## ##   ### ##     ## ##        ##    ##  ##    ##  ##    ##    ##    ##     ##   ## ##   ##  ##  ##  ##   ##     ##     ##           ####  ##    ##     ##    ##  ##     ##  ##   ##  ### ####                  ##     ##  ",
"##     ## ########   ######  ########  ######## ##        ######   ##     ## ####  ######  ##    ## ######## ##     ## ##    ##  #######  ##         ##### ## ##     ##  ######     ##     #######     ###     ###  ###  ##     ##    ##    ########      #### ###    ######  ##### ## ##     ## ##   ##   ###  ##          #######   ### ###   ",
]


def word(mystr):
    print()
    a = []
    for n in mystr:
        pos = ord(n)
        if 65 <= pos <= 65+25 or 97 <= pos <= 97+25:
            pos -= 65 if pos < 97 else 97

        pos = 26 if pos == 32 else pos
        pos = 27 if pos == 33 else pos
        pos = 28 if pos == 198 or pos == 230 else pos
        pos = 29 if pos == 216 or pos == 248 else pos
        pos = 30 if pos == 197 or pos == 229 else pos
        pos = 31 if pos == 44 else pos
        pos = 32 if pos == 59 else pos
        pos = 33 if pos == 46 else pos
        pos = 34 if pos == 58 else pos
        pos = 35 if pos == 45 else pos
        pos = 36 if pos == 95 else pos
        pos = 37 if pos == 40 else pos
        pos = 38 if pos == 41 else pos

        if 0 <= pos <= 38:
            a.append(pos)

    for n in range(len(line)):
        l = line[n]
        for i in a:
            print(l[split[i]:split[i+1]], end="")
        print()
    print()


game = True

while game:
    game = (input("Wanna play a game??\n1: Ja\n2: Nei\n") == "1")

    if game:
        existing = (input("Wanna play en existing game??\n1: An existing\n2: Get new\n") == "1")

        if existing:
            with open("board1.txt", "r") as f:
                for i, l in enumerate(f):
                    brett[i] = [int(d) for d in list(l.rstrip("\n"))]
        tegn(brett)
        main()
        word("Du vant!")

    if not game:
        word("Heidå")