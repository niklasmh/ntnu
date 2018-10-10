#!/usr/bin/python3

# a)
matrix = [
    [1, -2, 1, 0],
    [0, 2, -8, 8],
    [-4, 5, 9, -9]
]

# b)
def add(row1, row2, num):
    for i in range(len(row2)):
        row2[i] += row1[i] * num

A = [[2,3,4], [5,-3,6]]
add(A[0], A[1], -5/2)
print(A)

# c)
def swap(row1, row2):
    for i in range(len(row1)):
        row1[i], row2[i] = row2[i], row1[i]

A = [[2,3,4], [5,-3,6]]
swap(A[0], A[1])
print(A)

# d)
def getMaxRow(A, row_ind, col_ind):
    N = len(A)
    A_range = A[col_ind][row_ind+1:N+1]
    max_val = max(A_range)
    return A_range.index(max_val)

A = [[0,1,2,3], [4,5,6,7], [8,9,1,2]]
print(getMaxRow(A, 0, 0))

# e)
def row_ops(A, row_ind, col_ind):
    if A[col_ind][row_ind] == 0:
        return
