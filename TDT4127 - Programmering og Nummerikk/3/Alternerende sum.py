#!/usr/bin/python3

#''' a) En fin oneliner ;)
solution = sum([(x%2*2-1)*x**2for x in range(int(input('n = '))+1)])
answer = 'Summen av tallserien er {}'.format(solution)
print(answer)
#'''

#''' b)
k = int(input('k = '))
solution = 0
iterasjoner = 0
x = 0
while True:
    x += 1
    if x % 2:
        next_solution = x**2
    else:
        next_solution = -x**2
    if solution + next_solution > k:
        break
    iterasjoner += 1
    solution += next_solution

answer = 'Summen av tallene før summen blir større enn k er {}. Antall iterasjoner: {}'.format(solution, iterasjoner)
print(answer)
#'''
