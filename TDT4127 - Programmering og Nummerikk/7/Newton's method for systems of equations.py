#!/usr/bin/python3

# a)
def f0(x):
    return x[1] - x[0]**3

def f1(x):
    return x[0]**2 + x[1]**2 - 1

def F(x):
    return [ f0(x), f1(x) ]

'''
x = [1, 2]
print(f0(x), f1(x), F(x))
#'''

# b)
def df(f, x, dim, h = .00000001):
    # Finding the acutal derivative value
    h0 = h if dim == 0 else 0
    h1 = h if dim == 1 else 0
    return round((f([x[0] + h0, x[1] + h1]) - f([x[0], x[1]])) / h, 6)

def df0(x, dim, h = .00000001):
    return df(f0, x, dim)

def df1(x, dim, h = .00000001):
    return df(f1, x, dim)

def DF(x):
    return [
        [ df0(x, 0), df0(x, 1) ],
        [ df1(x, 0), df1(x, 1) ]
    ]

def DF2(x):
    # How the task was supposed to be
    df0x0 = lambda x: -3*x[0]**2
    df0x1 = lambda x: 1
    df1x0 = lambda x: 2*x[0]
    df1x1 = lambda x: 2*x[1]
    return [
        [ df0x0(x), df0x1(x) ],
        [ df1x0(x), df1x1(x) ]
    ]

'''
print(DF([1, 2]))
print(DF([0, 0]))
#'''

# c)
def augMatrix(x):
    df = DF(x)
    f = F(x)
    return [ df[0] + [-f[0]], df[1] + [-f[1]] ]
'''
print(augMatrix([1, 2]))
#'''

# d)
import gauss_elim as ge
def newtonStep(x):
    A = augMatrix(x)
    ge.gauss(A)
    bs = ge.back_substitution(A)
    x_k = [ x[0] + bs[0], x[1] + bs[1] ]
    return x_k

#'''
x = [1, 2]
for i in range(8):
    x = newtonStep(x)
    print(x)
#'''
