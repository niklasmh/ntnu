__author__ = 'Niklas'
# -*- coding: utf-8 -*-

# a)

def sammenligne(str1, str2):
    for i in range(len(str1)if len(str1)<len(str2)else len(str2)):
        if str1[i]!=str2[i]:
            return False
    return True

print(sammenligne("Hei", "Hallo"))
print(sammenligne("Hei", "Hei"))


# b)

def revers(str1):
    newstr = ""
    for c in str1:
        newstr = c + newstr
    return newstr

print("sgnelkab ->", revers("sgnelkab"))
print("agnes i senga ->", revers("agnes i senga"))


# c)

def ispalindrom(str):
    if sammenligne(str, revers(str)):
        return True
    return False

print(ispalindrom("halla"))
print(ispalindrom("abba"))


# d)

def strinneholder(bit, str):
    for i, c in enumerate(str[:-len(bit)]):
        if sammenligne(bit, str[i:i+len(bit)]):
            return i
    return False

print(strinneholder("hei", "hei på deg"))
print(strinneholder("en", "dette er en string"))
print(strinneholder("yoniggah", "envanligstring"))

for i, c in enumerate("noe"):
    print(i, c)

print("abba"[2:2+len("ba")])