#!/usr/bin/python3

from sys import stdin

def sort_list(A):
    for j in range(1, len(A)):
        k = A[j]
        i = j - 1
        while i >= 0 and A[i] > k:
            A[i+1] = A[i]
            i = i - 1
        A[i+1] = k
    return A

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
        result = find(sorted_list, minimum, maximum)
        print(str(result[0]) + " " + str(result[1]))

if __name__ == "__main__":
    main()
