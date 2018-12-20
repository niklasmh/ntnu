#!/usr/bin/python3

#''' a)
def every_fourth_element(string):
    return string[::4]

print(every_fourth_element('I Was Told There’d Be Cake'))
#'''

#''' b)
def concat_two_last_chars_in_strings(liste):
    concat = ''
    for string in liste:
        concat += string[-2:]
    return concat

print(concat_two_last_chars_in_strings(['sabel', 'kan', 'mestr', 'kuleis']))
#'''

''' c)
1 => Feil. Den prøver å sette en ikke-muterbar streng.
2 => Riktig. Returnerer 'Cake'.
3 => Feil. Syntaksfeil. Prøver å hente ukjent string[]. Kan fikses med string[:].
'''
