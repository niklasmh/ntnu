#!/usr/bin/python3

# a)
number_list = list(range(0, 100))
print(number_list)

# b)
s = 0
for i in number_list:
    if i % 3 == 0 or i % 10 == 0:
        s += i
print(s)

# c)
for i in range(0, len(number_list) - 1, 2):
    number_list[i], number_list[i+1] = number_list[i+1], number_list[i]
print(number_list)

# d)
reversed_list = []
for i in range(len(number_list) - 1, -1, -1):
    reversed_list.append(number_list[i])
print(reversed_list)
