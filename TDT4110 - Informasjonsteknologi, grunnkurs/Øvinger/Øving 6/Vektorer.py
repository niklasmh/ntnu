__author__ = 'Niklas'
# -*- coding: utf-8 -*-

def inputvec():
    vec = input("Skriv inn 3D vektor (slik: 1.2,2,3):\n")
    while vec.translate(''.join([",", "."])).isdigit():
        vec = input("Skriv inn 3D vektor (slik: 1.2,2,3):\n")

    vec = vec.split(",")
    vec = vec[:3]
    vec = [float("{0:.2f}".format(float(i))) for i in vec]

    return vec

vec1 = inputvec()


def skalar(vec=[1, 1, 1], c=1):
    print(lengde(vec))
    s = [c*vec[0], c*vec[1], c*vec[2]]
    print(lengde(s))
    print((lengde(s)/lengde(vec)))
    return s


def lengde(vec):
    return (vec[0]**2 + vec[1]**2 + vec[2]**2)**(1/2)


def dotprod(vec, vecto):
    return vec[0]*vecto[0] + vecto[1]*vec[1] + vecto[2]*vec[2]

vec2 = skalar(vec1, 2)
print(vec2)


vec2 = inputvec()
print(dotprod(vec1, vec2))


#1.2,32.,242.21
