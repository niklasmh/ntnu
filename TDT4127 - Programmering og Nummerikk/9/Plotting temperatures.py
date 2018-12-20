#!/usr/bin/python3

''' a)
f = open('Trondheim_temperatures_list.txt', 'r')
print(f.read())
#'''

# b)
def get_list(line):
    return list(map(float, line.split(' ')))

'''
print(get_list('9.1 8.3 4.5 9.1 3.3'))
#'''

# c)
def get_data(file):
    f = open(file)
    dates = f.readline().split(' ')
    meantemps = get_list(f.readline())
    mintemps = get_list(f.readline())
    maxtemps = get_list(f.readline())
    return (dates, meantemps, mintemps, maxtemps)

'''
print(get_data('Trondheim_temperatures_list.txt'))
#'''

#''' d)
import matplotlib.pyplot as plt
def make_graph(file):
    (dates, meantemps, mintemps, maxtemps) = get_data(file)
    N = len(dates)
    x_axis = list(range(N))
    plt.plot(x_axis, meantemps, label='Mean')
    plt.plot(x_axis, mintemps, label='Minimum')
    plt.plot(x_axis, maxtemps, label='Maximun')
    year = dates[0].split('.')[2]
    plt.title('Temperatures for Trondheim, ' + year)
    plt.xlabel('Months')
    plt.ylabel('Temperature. °C')
    plt.legend()
    months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
    plt.xticks(range(15, 365, 31), months)
    min_val = min(mintemps)
    max_val = max(maxtemps)
    #plt.axis([1, N, min_val - 1, max_val + 1])
    plt.show()

make_graph('Trondheim_temperatures_list.txt')
#'''
