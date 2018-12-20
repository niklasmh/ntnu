#!/usr/bin/python3

from sys import argv
import re
float_format = re.compile(r'^\-?[0-9]*\.?[0-9]*')

a, b, c = 1, 1, 1

if len(argv) >= 4:
    try:
        a, b, c = map(float, argv[1:])
    except ValueError:
        print('Alle argumenter må være tall. Bruk punktum (.) for desimaltall.')
        exit()
else:
    a_input = input('a: ')
    while not float_format.match(a_input):
        a_input = input('"a" må være et tall: ')
    a = float(a_input)

    b_input = input('b: ')
    while not float_format.match(b_input):
        b_input = input('"b" må være et tall: ')
    b = float(b_input)

    c_input = input('c: ')
    while not float_format.match(c_input):
        c_input = input('"c" må være et tall: ')
    c = float(c_input)

d = b**2 - 4*a*c

if d == 0:
    if a != 0:
        v = -b / (2 * a)
        print('Andregradsligningen {:.2f}*x^2 + {:.2f}*x + {:.2f} har en reell dobbeltrot {:.3e}'.format(a, b, c, v))
    else:
        print('"a" må være noe annet enn', 0)
elif d > 0:
    if a != 0:
        if b >= 0:
            v1 = (2 * c) / (-b - d**.5)
            v2 = (-b - d**.5) / (2 * a)
        else:
            v1 = (-b + d**.5) / (2 * a)
            v2 = (2 * c) / (-b + d**.5)
        print('Andregradsligningen {:.2f}*x^2 + {:.2f}*x + {:.2f} har de to reelle løsningene {:.3e} og {:.3e}'.format(a, b, c, v1, v2))
    else:
        print('"a" må være noe annet enn', 0)
else:
    print('Andregradsligningen {:.2f}*x^2 + {:.2f}*x + {:.2f} har to imaginære løsninger'.format(a, b, c))
