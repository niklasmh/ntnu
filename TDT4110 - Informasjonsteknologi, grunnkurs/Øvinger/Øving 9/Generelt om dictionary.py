__author__ = 'Niklas'
# -*- coding: utf-8 -*-

# a)

fam = {}


def addtodict(dict, name, key):
    dict[key] = name

# b)


key = " "
while key != "":
    key = input("Familiemedlem\n")

    if key != "":
        name = input("Navn:\n")

        if name != "":
            if key in fam:
                if (isinstance(fam[key], list)):
                    fam[key].append(name)
                else:
                    fam[key] = [fam[key], name]
            else:
                addtodict(fam, name, key)
                print("La til nøkkel - " + key)
            print("La " + name + " til " + key)
        else:
            fam.pop(key, None)
            print("Fjernet alt fra " + key)

        print(fam)
