#!/usr/bin/python3

from sys import stdin


class Node:
    def __init__(self, id):
        self.child = []
        self.id = id
        self.ratatosk = False
        self.next_child = 0
        self.level = 0


def dfs(root):
    stack = [root]
    while stack:
        this = stack[len(stack) - 1]
        if this.ratatosk:
            return len(stack) - 1
        if this.next_child == len(this.child):
            stack.pop()
        else:
            stack.append(this.child[this.next_child])
            this.next_child += 1

def bfs(root):
    #print("Parent: " + str(root.id))
    #parent = None
    #lvl = {}
    #stack = [root]
    #if root.ratatosk:
    #    return 0
    #i = 1
    #while len(stack) > 0:
    #    next = []
    #    for u in stack:
    #        u.child = [c for c in sorted(u.child, key=lambda n: n.id)]
    #        for v in u.child:
    #            if v.id not in lvl:
    #                if v.ratatosk:
    #                    return i
    #                lvl[v.id] = i
    #                next.append(v)
    #    stack = next
    #    i = i + 1
    #    #print(" ".join([str(s.id) for s in stack]))
    #return i
    queue = [(root, 0)] 
    while len(queue) > 0:
        this, dybde = queue.pop(0)
        if this.ratatosk:
            return dybde
        for b in this.child:
            queue.append((b, dybde + 1))

# level = { s: ø }
# 2 parent = { s: None }
# 3 i = 0
# 4 frontier = [s] ← level i - 1
# 5 while frontier:
# 6     next = [] ← level i
# 7     for u in frontier:
# 8         for v in Adj[u]:
# 9             if v not in level: # Unngå duplikater
# 10                level[v] = i
# 11                parent[v] = u
# 12                next.append(v)
# 13     frontier = next
# 14     i = i + 1

function = stdin.readline().strip()
number_of_nodes = int(stdin.readline())
nodes = []
for i in range(number_of_nodes):
    nodes.append(Node(i))
start_node = nodes[int(stdin.readline())]
ratatosk_node = nodes[int(stdin.readline())]
ratatosk_node.ratatosk = True
for line in stdin:
    number = line.split()
    temp_node = nodes[int(number.pop(0))]
    for child_number in number:
        temp_node.child.append(nodes[int(child_number)])

if function == 'dfs':
    print(dfs(start_node))
elif function == 'bfs':
    print(bfs(start_node))
elif function == 'velg':
    print(bfs(start_node))
