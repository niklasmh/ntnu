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
'''
A = [[2, 3, 4], [5, -3, 6]]
add(A[0], A[1], -5/2)
print(A)
#'''

# c)
def swap(row1, row2):
    for i in range(len(row1)):
        row1[i], row2[i] = row2[i], row1[i]
'''
A = [[2, 3, 4], [5, -3, 6]]
swap(A[0], A[1])
print(A)
#'''

# d)
def getMaxRow(A, row_ind, col_ind):
    N = len(A)
    max_i = row_ind
    max_val = A[max_i][col_ind]
    for i in range(row_ind + 1, N):
        if max_val < abs(A[i][col_ind]):
            max_i = i
            max_val = abs(A[i][col_ind])
    return max_i
'''
A = [[0, 1, 2, 3], [4, 5, 6, 7], [8, 9, 1, 2]]
print(getMaxRow(A, 0, 0))
#'''

# e)
def row_ops(A, row_ind, col_ind):
    if A[row_ind][col_ind] == 0:
        return

    for i in range(row_ind + 1, len(A)):
        add(A[row_ind], A[i], -A[i][col_ind] / A[row_ind][col_ind])
'''
A = [[0, 1, 1, 3], [1, 2, 3, 0], [1, 3, 4, -2]]
row_ops(A, 0, 0)
print(A)

A = [[1, 1, 1, 3], [1, 2, 3, 0], [1, 3, 4, -2]]
row_ops(A, 0, 0)
print(A)
#'''

# f)
def gauss(A):
    row_ind = 0
    col_ind = 0
    N = len(A)

    # 1. Find the maximum entry (in absolute value) of in the pivot column from the pivot row to the bottom.
    #    a. If this is not possible (i.e. all rows below the pivot row, including the pivot row have 0 in the pivot column), increase the index of the pivot column by 1 and repeat.
    # 2. Swap the entries in the pivot row and the row with the maximum value.
    # 3. Add multiples of the pivot row to the rows below such that the pivot column has only 0 entries after the pivot row. This means: If the pivot element has value aij and the element of same column in a later row has value aik, add (-alk/aij) multiples of the pivot row to that row.
    # 4. Increase the numbering of the pivot row and the pivot column by 1.
    # 5. If the pivot row is the last row and/or if the pivot column number exceeds the number of columns in the matrix (not counting the extra column with b0,b1,b2 ), stop the iterations. Otherwise, repeat from step 1.

    while True:

        # 1.
        max_row = 0
        while max_row == 0 and col_ind < N:
            max_row = getMaxRow(A, row_ind, col_ind)
            if A[max_row][col_ind] == 0:
                col_ind += 1 # 1.a
            else:
                break
        if A[max_row][col_ind] == 0:
            return

        # 2.
        if max_row != 0:
            swap(A[max_row], A[row_ind])

        # 3.
        row_ops(A, row_ind, col_ind)

        # 4.
        row_ind += 1
        col_ind += 1

        # 5.
        if row_ind >= N and col_ind >= N:
            return

#'''
print('Gauss elimination:')
A = [[0,1,2,3], [4,5,6,7], [8,9,1,2]]
print(A)
gauss(A)
print('~', A)
#'''

# g) Challenge (optional)
def back_substitution(A):
    N = len(A)
    row_ind = N - 1
    col_ind = N - 1
    x = []
    while col_ind >= 0 and row_ind >= 0:
        last_x = A[row_ind][N] / A[row_ind][col_ind]
        x.append(last_x)
        for i in range(row_ind - 1, -1, -1):
            A[i][N] -= last_x*A[i][col_ind]
            A[i][col_ind] = 0
        row_ind -= 1
        col_ind -= 1
    return x[::-1]

#'''
print('Back substitution:')
A = [[1, 1, 1, 3], [1, 2, 3, 0], [1, 3, 4, -2]]
print(A)
gauss(A)
print('=>', back_substitution(A))
#'''
