#!/usr/bin/python3

# a)
my_first_list = [1, 2, 3, 4, 5, 6]

# b)
print(my_first_list[len(my_first_list) - 1])
print(my_first_list[-1])
print(my_first_list[-1:][0])
print(my_first_list[::-1][0])

# c)
my_first_list[4] = 'pluss'
print(my_first_list)

# d)
my_second_list = my_first_list[-3:]
print(my_second_list)

# e)
print(my_second_list, 'er lik 10')
