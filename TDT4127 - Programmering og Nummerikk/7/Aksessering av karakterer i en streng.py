#!/usr/bin/python3

#''' a)
def print_chars(string):
    for char in string:
        print(char)

print_chars('Discworld')
#'''

#''' b)
def third_letter_in_string(string):
    return string[2] if len(string) > 2 else 'q'

print(third_letter_in_string('Mistborn'))
print(third_letter_in_string('IT'))
#'''

#''' c)
def indices_count(string):
    return len(string) - 1

print(indices_count('The Way og Kings'))
print(indices_count('Elantris'))
#'''
