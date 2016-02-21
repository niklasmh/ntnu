h = float(input("Hva er høyden på tetraederet? "))
a = h*3/6**(1/2)

A = 3**(1/2)*a**2
V = 2**(1/2)*a**3/12

print("Volumet er", V, " og arealet er", A)

#Kunne importert sqrt og pow, men ** = eksponenten og **(1/2) blir kvadratroten
