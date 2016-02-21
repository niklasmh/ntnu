__author__ = 'Niklas'
# -*- coding: utf-8 -*-


# a)

matrise = [[0, 0, 0],
           [0, 0, 0],
           [0, 0, 0]]


def lagBrett(matrise):
    print("     " + "   ".join([str(i) for i in [1, 2, 3]]))
    print("  ", "-"*13)

    for i, e in enumerate(matrise):
        print(" " + str(i + 1) + " | " + " | ".join([" " if j == 0 else "o" if j == 1 else "x" for j in e]) + " |")
        print("  ", "-"*13)

lagBrett(matrise)

# b)

def vunnet(matrise):
    def likRekke(rekke):
        if (rekke[0] == rekke[1] == rekke[2] > 0):
            return True
        return False

    # Horisontalt
    for e in [i for i in matrise]:
        if likRekke(e):
            return True

    #Vertikalt
    if likRekke([matrise[i][0] for i in range(3)]) or likRekke([matrise[i][1] for i in range(3)]) or likRekke([matrise[i][2] for i in range(3)]):
        return True

    #Skrått
    if likRekke([matrise[i][i] for i in range(3)]) or likRekke([matrise[2-i][i] for i in range(3)]):
        return True

    return False

print(vunnet(matrise))


# c)

p1 = ""
while len(p1) < 1:
    p1 = input("Player 1:\n")

p2 = ""
while len(p2) < 1:
    p2 = input("Player 2:\n")


# d)


def ledig(x, y, matrise):
    if str(x).isdigit() and str(y).isdigit():
        return matrise[max(min(int(y) - 1, 2), 0)][max(min(int(x) - 1, 2), 0)] == 0
    return True


# e)


def valid(x, y, matrise):
    if str(x).isdigit() and str(y).isdigit():
        return (1 <= int(x) <= 3) and (1 <= int(y) <= 3)
    return False


# f)


def main():
    turn = 1

    while not vunnet(matrise):
        coords = input("x y ifra " + (p1 if turn == 1 else p2) + ":\n").split()
        if len(coords) < 1:
            coords = [0, 0]
        if len(coords) < 2:
            coords = [coords[0], 0]
        while not (valid(coords[0], coords[1], matrise) and ledig(coords[0], coords[1], matrise)):
            coords = input("x y ifra " + (p1 if turn == 1 else p2) + ": Forsøk på nytt, invalid input.\n").split()
            if len(coords) < 1:
                coords = [0, 0]
            if len(coords) < 2:
                coords = [coords[0], 0]

        x = int(coords[0]) - 1
        y = int(coords[1]) - 1

        matrise[y][x] = turn

        turn = (1 if turn == 2 else 2)
        lagBrett(matrise)
    turn = (1 if turn == 2 else 2)
    word((p1 if turn == 1 else p2) + " vant!")



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


main()