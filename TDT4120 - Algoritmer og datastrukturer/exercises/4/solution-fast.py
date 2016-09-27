#!/usr/bin/python3

from sys import stdin

def sort_list(A):
    # Split every second element into sublists: [2,1], [10,3] ...
    split = [A[i - 1:i + 1] for i in range(1, len(A) + 1, 2)]

    #elements = len(A)
    #if elements % 2 == 0:
    #    split = [[[A[i]], [A[i + 1]]] for i in range(0, elements - 1, 2)]
    #else:
    #    split = [[[A[i]], [A[i + 1]]] for i in range(0, elements - 2, 2)]
    #    split.append([[A[elements - 1]]])

    print(split)

    # Find the amount of steps needed. 1, 2, 4, 8, 16 ... 2**n
    length = len(A)
    steps = 0
    while 1<<steps < length:
        steps = steps + 1
    print(steps)

    # List for recording the process
    new_split = []

    for i in range(len(split) - 1):
        if split[i][0] > split[i][1]:
            split[i][0], split[i][1] = split[i][1], split[i][0]
    new_split.append(split)

    for s in range(2, 3):#steps:
        new_split.append([])
        for i in range(0, len(new_split[s - 2]), 2): # [[1, 12], [4, 13], [5, 11], [3, 6], [16]]
            new_split[s - 1].append([])
            pos1, pos2 = 0, 0
            print(new_split)
            for j in range(2*2**s):
                print(j)
                for ns in new_split:
                    print(ns)
                if pos1 >= len(new_split[s - 2][j]):
                    new_split[s - 1][len(new_split[s - 1]) - 1].append(new_split[s - 2][j + 1][pos2])
                    continue
                if pos2 >= len(new_split[s - 2][j + 1]):
                    new_split[s - 1][len(new_split[s - 1]) - 1].append(new_split[s - 2][j][pos1])
                    continue

                if new_split[s - 2][j][pos1] < new_split[s - 2][j + 1][pos2]:
                    new_split[s - 1][len(new_split[s - 1]) - 1].append(new_split[s - 2][j][pos1])
                    pos1 = pos1 + 1
                else:
                    new_split[s - 1][len(new_split[s - 1]) - 1].append(new_split[s - 2][j + 1][pos2])
                    pos2 = pos2 + 1

    for ns in new_split:
        print(ns)

    return [1,2,3]#new_split[len(new_split) - 1][0]

def find(A, lower, upper):
    half_low = len(A) // 2
    interval = [0, len(A) - 1]
    i = 11
    while i > 0:
        i = i - 1
        half_low = (interval[0] + interval[1]) // 2
        if lower < A[half_low]:
            interval[1] = half_low - 1
        elif lower > A[half_low]:
            interval[0] = half_low + 1
        else:
            break

    half_low = (interval[0] + interval[1]) // 2
    if lower < A[half_low]:
        half_low = half_low - 1

    half_upper = len(A) // 2
    interval = [0, len(A) - 1]
    i = 11
    while i > 0:
        i = i - 1
        half_upper = (interval[0] + interval[1]) // 2
        if upper < A[half_upper]:
            interval[1] = half_upper - 1
        elif upper > A[half_upper]:
            interval[0] = half_upper + 1
        else:
            break

    half_upper = (interval[0] + interval[1]) // 2
    if upper > A[half_upper]:
        half_upper = half_upper + 1

    return [A[half_low if half_low > 0 else 0], A[half_upper if half_upper < len(A) else len(A) - 1]]

def main():
    input_list = []
    for x in stdin.readline().split():
        input_list.append(int(x))

    sorted_list = sort_list(input_list)

    for line in stdin:
        word = line.split()
        minimum = int(word[0])
        maximum = int(word[1])
        #result = find(sorted_list, minimum, maximum)
        result = [1, 2]
        print(str(result[0]) + " " + str(result[1]))

if __name__ == "__main__":
    main()
