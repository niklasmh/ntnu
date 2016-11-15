#!/usr/bin/python3

from sys import stdin, stderr

def bp(nm, p):
    n = len(p)
    d = [False] * n
    kp = [0.0] * n
    kp[0] = p[0]
    pre = list(range(n))
    bn = 0
    for i in range(n):
        nd = bn
        d[nd] = True
        hkp = -1.0
        for ne in range(n):
            if not d[ne]:
                if nm[nd][ne]:
                    t = kp[nd] * p[ne]
                    if t > kp[ne]:
                        pre[ne] = nd
                        kp[ne] = t
                if kp[ne] > hkp:
                    bn = ne
                    hkp = kp[ne]
    if (kp[-1] == 0.0): return '0'
    i = n - 1
    sti = []
    while i != 0:
        sti.append(i)
        i = pre[i]
    sti.append(0)
    return '-'.join(map(str, reversed(sti)))

n = int(stdin.readline())
prob = [float(x) for x in stdin.readline().split()]
nm = []
for l in stdin:
    ner = [0] * n
    nes = [int(ne) for ne in l.split()]
    for ne in nes: ner[ne] = 1
    nm.append(ner)

print(bp(nm, prob))
