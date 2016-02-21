import math

pi = math.pi

def sin(rad):
    return math.sin(rad)

def degToRad(deg):
    return deg*pi/180

def radToDeg(rad):
    return rad*180/pi

h = float(input("Hva skal delta h være? ")) #10**-3
x = float(input("Hvor mange grader er vinkelen? ")) #pi

f1 = sin(degToRad(x))
f2 = sin(degToRad(x) + h)

d = (f2 - f1)/h

print("Den deriverte av sin(" + str(format(x, ".0f")) + ") med delta =", h, "er ca.", format(d, ".2f"))
