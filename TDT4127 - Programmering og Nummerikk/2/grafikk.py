#!/usr/bin/python3

import time
from turtle import *

print('Hei, jeg kan tegne en trekant')


answer = input('Velg pennefarge, NTNU-rosa (R) eller NTNU-turkis (T): ') or '_'
color = '#ad208e'
while answer not in 'RT':
    answer = input('NTNU-rosa (R) eller NTNU-turkis (T): ') or '_'

if answer == 'T':
    color = '#5cbec9'


answer = input('Fyllfarge, NTNU-gul (G), -oransj (O), -lilla (L): ') or '_'
fill_color = '#d5d10e'
while answer not in 'GOL':
    answer = input('NTNU-gul (G), -oransj (O), -lilla (L): ') or '_'

if answer == 'O':
    fill_color = '#f58025'
elif answer == 'L':
    fill_color = '#552988'


answer = input('Ønsker du spissen på trekanten opp eller ned (O / N)? ') or '_'
is_up = True
while answer not in 'ON':
    answer = input('Opp eller ned (O / N)? ') or '_'

if answer == 'N':
    is_up = False


pensize(7)
pencolor(color)
bgcolor('grey')
fillcolor(fill_color)

# Tegner en fylt trekant
begin_fill()
forward(200)        # gå 100 piksler framover
if is_up: left(120) # drei 120 grader venstre
else: right(120)    # drei 120 grader høyre
forward(200)
if is_up: left(120) # drei 120 grader venstre
else: right(120)    # drei 120 grader høyre
forward(200)
end_fill()

# Holder vinduet med tegningen åpent i 10 sekunder. Ha dette som siste linje i koden din
time.sleep(10)
