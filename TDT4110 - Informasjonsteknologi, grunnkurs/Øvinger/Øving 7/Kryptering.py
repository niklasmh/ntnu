__author__ = 'Niklas'
# -*- coding: utf-8 -*-

# a)


def krypt(str, hakk=2):
    return "".join([chr(97+(ord(c)+hakk-97) % 26) for c in str])

print(krypt("acbdefgh"))

# b)


def dekrypt(str, hakk=2):
    return "".join([chr(97+(ord(c)-hakk-97) % 26) for c in str])

print(krypt(dekrypt("acbdefgh")))

# c)

print(dekrypt(krypt(input("Skriv en setning:\n"))))

# d)

