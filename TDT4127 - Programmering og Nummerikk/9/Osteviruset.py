#!/usr/bin/python3

cheeses = {
    'cheddar': ('A235-4', 'A236-1', 'A236-2', 'A236-3', 'A236-5', 'C31-1', 'C31-2'),
    'mozarella': ('Q456-9', 'Q456-8', 'A234-5', 'Q457-1', 'Q457-2'),
    'gombost': ('ZLAFS55-4', 'ZLAFS55-9', 'GOMBOS-7', 'A236-4'),
    'geitost': ('SPAZ-1', 'SPAZ-3', 'EMACS45-0'),
    'port salut': ('B15-1', 'B15-2', 'B15-3', 'B15-4', 'B16-1', 'B16-2', 'B16-4'),
    'camembert': ('A243-1', 'A234-2', 'A234-3', 'A234-4', 'A235-1', 'A235-2', 'A235-3'),
    'ridder': ('GOMBOS-4', 'B16-3'),
}

# a)
print(cheeses['port salut'])

# b)
infected_cheeses = []
for ost, hyller in cheeses.items():
    for hylle in hyller:
        prefix = hylle.split('-')[0]
        if prefix in ['B13', 'B15', 'A234', 'A235', 'C31']:
            infected_cheeses.append(ost)
            break

print('Potentially infected cheeses:', infected_cheeses)

# c)
for ost, hyller in cheeses.items():
    any_infected_hyller = False
    for hylle in hyller:
        prefix = hylle.split('-')[0]
        if prefix in ['B13', 'B15', 'A234', 'A235', 'C31']:
            any_infected_hyller = True
            break
    if not any_infected_hyller:
        for hylle in hyller:
            print(hylle, ost)
