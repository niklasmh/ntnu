#!/usr/bin/python3

#''' a)
def join_with_space(s1, s2):
    return s1 + ' ' + s2

print(join_with_space('James', 'Bond'))
#'''

#''' b)
def concat_strings(liste):
    return ''.join(liste)

print(concat_strings(['abc', 'defg', 'hijklm', 'nop']))
#'''

#''' c)
def first_char_in_strings(liste):
    for string in liste:
        print(string[0])

first_char_in_strings(['UKA', 'lever', 'videre'])
#'''

''' d)
func2(
    func1(['Klabert', 'Oslo', 'Tur', 'stubbe']) => 'bob'
) => 'bobbob'
'''
