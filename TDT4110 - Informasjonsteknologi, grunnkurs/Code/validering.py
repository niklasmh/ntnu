import re
__author__ = 'Niklas'
# -*- coding: utf-8 -*-


def main():
    navn = input("navn:\n")
    while not navn.isalpha():
        navn = input("navn din jævel:\n")

    y = input("År:\n")
    while not y.isdigit():
        y = input("År din jævel:\n")

    email = input("email:\n")
    while not re.match(r'.+@.+', email):
        email = input("email din jævel:\n")

    phone = input("nummer:\n")
    while not phone.isdigit() and re.match(r'^\+?(47)?[0-9]{,8}', phone):
        phone = input("nummer din jævel:\n")

    print("Du er så smart, du")

main()
