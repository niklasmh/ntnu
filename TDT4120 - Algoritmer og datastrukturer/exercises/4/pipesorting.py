#!/usr/bin/python3

from sys import stdin


def sort_list(A):
    # NOTICE: The sorted list must be returned.
    # SKRIV DIN KODE HER


def find(A, lower, upper):
    # NOTICE: The result must be returned.
    # SKRIV DIN KODE HER


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
