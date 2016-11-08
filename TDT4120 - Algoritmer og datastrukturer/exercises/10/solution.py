#!/usr/bin/python3

Inf = float(1e3000)

def mst(nl, n):
    from heapq import heappop, heappush
    h = []
    t = [0] * n
    w = 0
    for i in nl[0]: heappush(h, i)
    t[0] = 1
    for i in range(1, n):
        if not 0 in t: break
        while h:
            e = heappop(h)
            m = e[1]
            if t[m]: continue
            t[m] = 1
            if w < e[0]: w = e[0]
            for e in nl[m]:
                if not t[e[1]]: heappush(h, e)
            break
    return w


def r():
    from sys import stdin
    lr = stdin.readlines()
    n = len(lr)
    o = 0
    nl = [None] * n
    for l in lr:
        cn = []
        for k in l.split():
            data = k.split(':')
            w = int(data[1])
            m = int(data[0])
            e = (w, m)
            cn.append(e)
        nl[o] = cn
        o += 1
    print (mst(nl, n))

r()
