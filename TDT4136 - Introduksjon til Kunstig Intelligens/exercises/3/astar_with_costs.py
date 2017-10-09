#!/usr/bin/python3

import tkinter as tk
from sys import stdin, argv
argc = len(argv)
from time import sleep

INFINITY = 99999
DIST_FACTOR = 0
COST_FACTOR = 10 # Task 2: Only the cost matter
ANIMATE = False
SHOW_BOARD_ONLY = False
INTERVAL = 20
FILE = None

if argc >= 2: FILE = argv[1]
if argc >= 3:
  if argv[2].lower() == "show":
    SHOW_BOARD_ONLY = True
  else:
    INTERVAL = int(argv[2])
    ANIMATE = INTERVAL > 0
if argc >= 4:
  try:
    (DIST_FACTOR, COST_FACTOR) = map(int, argv[3].split(","))
  except:
    print("The 3. arg is on format: dist_factor,cost_factor")
    print("Now using 1,1 as default...")

root = tk.Tk()

start = None
goal = None
M = []
PM = []
ch = 0
x = 0
y = 0

if FILE:
  for i in open(FILE, "r"):
    M.append([])
    x = 0
    for j in i[:-1]:
      node = [None, INFINITY, INFINITY, j, (x, y), []]
      M[ch].append(node)
      if not start and j == "A": start = node
      if not goal and j == "B": goal = node
      x += 1
    ch += 1
    y += 1
else:
  for i in stdin:
    M.append([])
    x = 0
    for j in i[:-1]:
      node = [None, INFINITY, INFINITY, j, (x, y), []]
      M[ch].append(node)
      if not start and j == "A": start = node
      if not goal and j == "B": goal = node
      x += 1
    ch += 1
    y += 1

cw = len(M[0])

# Centering the window and setting the size to 80% of the smallest side
sw = root.winfo_screenwidth()
sh = root.winfo_screenheight()

if sw / sh < cw / ch:
  w = .8 * sw / cw
  h = .8 * (sw * ch / cw) / ch
else:
  w = .8 * (sh * cw / ch) / cw
  h = .8 * sh / ch

root.geometry('%dx%d+%d+%d' % (w * cw, h * ch, sw / 2 - w * cw / 2, sh / 2 - h * ch / 2))

# Making sense of the data
colors = {
  "#": "gray",
  "A": "red",
  "B": "lime",
  ".": "white",
  "w": "blue",
  "m": "gray",
  "f": "green",
  "g": "lightgreen",
  "r": "orange"
}

types = {
  "#": 1, # Block
  "A": 0, # Start
  "B": 0, # Goal
  ".": 0,
  "w": 0,
  "m": 0,
  "f": 0,
  "g": 0,
  "r": 0
}

costs = {
  "A": 0,
  "B": 0,
  ".": 1,
  "w": 100,
  "m": 50,
  "f": 10,
  "g": 5,
  "r": 1
}

# Adding a heuristic based on the distance from goal and cost
def heuristic_cost_estimate(src, dst):
  dist_factor = DIST_FACTOR
  cost_factor = COST_FACTOR
  (sx, sy) = getPoint(src)
  (dx, dy) = getPoint(dst)
  return (abs(sx - dx) + abs(sy - dy)) * dist_factor + costs[getSign(src)] * cost_factor
  #return ((sx - dx)**2 + (sy - dy)**2)**.5 * dist_factor + costs[getSign(src)] * cost_factor

# The main code for finding the path
def astar(M, start, goal):
  global root

  state = {
    "closedSet": {},
    "openSet": {},
    "cameFrom": fillDictByMap(M, None),
    "gScore": fillDictByMap(M),
    "fScore": fillDictByMap(M)
  }

  state["openSet"][getId(start)] = start
  drawHalfCross(getPoint(start)[0], getPoint(start)[1])
  state["gScore"][getId(start)] = 0
  state["fScore"][getId(start)] = heuristic_cost_estimate(start, goal)

  def Refresh(frame):
    state = frame.state
    state["after_id"] = frame.after(INTERVAL, Refresh, frame)

    if state["openSet"]:
      run_astar_step(state, frame)
    else:
      frame.after_cancel(state["after_id"])
      print("Failed")

  root.state = state
  if ANIMATE:
    Refresh(root)
  else:
    while state["openSet"]:
      mode = run_astar_step(state)
      if mode == 0:
        continue
      elif mode == 1:
        return 1
    print("Failed")

def run_astar_step(state, frame=None):
  vals = list(state["openSet"].values())
  if len(vals): current = vals.pop()
  for val in vals:
    if getScore(state["fScore"], val) < getScore(state["fScore"], current):
      current = val

  if current == goal:
    #draw_markings(M, state["closedSet"], state["openSet"]) # If we want to draw every state once again
    reconstruct_path(state["cameFrom"], current)
    if frame:
      frame.after_cancel(state["after_id"])
    return 1

  if getId(current) in state["openSet"]:
    del state["openSet"][getId(current)]
    (x, y) = getPoint(current)
    drawOtherHalfCross(x, y)
  state["closedSet"][getId(current)] = current

  for neighbor in getNeighbors(M, current):
    neighbor_id = getId(neighbor)

    if neighbor_id in state["closedSet"]:
      continue

    if not neighbor_id in state["openSet"]:
      (x, y) = getPoint(neighbor)
      drawHalfCross(x, y)
      state["openSet"][neighbor_id] = neighbor

    temp_gScore = getScore(state["gScore"], current) + dist_between(current, neighbor)

    if temp_gScore >= getScore(state["gScore"], neighbor):
      continue

    (nx, ny) = getPoint(neighbor)
    (cx, cy) = getPoint(current)
    drawLine(nx, ny, cx, cy)
    state["cameFrom"][neighbor_id] = current
    state["gScore"][neighbor_id] = temp_gScore
    state["fScore"][neighbor_id] = getScore(state["gScore"], neighbor) + heuristic_cost_estimate(neighbor, goal)
  return 2

# Finding the path back by following each nodes "best path"
def reconstruct_path(cameFrom, current):
  heru = heuristic_cost_estimate(current, goal)
  cost = getCost(current)
  total_path = [ current ]
  (x, y) = getPoint(current)
  drawCircle(x, y, 1 / 4, fill="black")
  while current and getId(current) in cameFrom:
    current = cameFrom[getId(current)]
    total_path.append(current)
    if current:
      heru += heuristic_cost_estimate(current, goal)
      cost += getCost(current)
      (x, y) = getPoint(current)
      drawCircle(x, y, 1 / 4, fill="black")
  print("Heruistic of: " + str(heru))
  print("This path costs: " + str(cost))
  return total_path

def draw_markings(M, closedSet, openSet):
  for i in M:
    for j in i:
      if getId(j) in closedSet:
        (x, y) = getPoint(j)
        drawCross(x, y, (2 - 2**.5 / 2) / 4, fill="black", width=w/28)
      if getId(j) in openSet:
        (x, y) = getPoint(j)
        drawHalfCross(x, y, (2 - 2**.5 / 2) / 4, fill="black", width=w/28)

# Drawing functions
def drawCircle(x, y, r, **kwargs):
  return canvas.create_oval(x * w + w / 2 - w * r, y * h + h / 2 - h * r, x * w + w / 2 + w * r, y * h + h / 2 + h * r, **kwargs)

def drawCross(x, y, p=(2 - 2**.5 / 2) / 4, fill="black", width=w/28, **kwargs):
  return (
    canvas.create_line(x * w + w - w * p, y * h + h * p, x * w + w * p, y * h + h - h * p, fill=fill, width=width, **kwargs),
    canvas.create_line(x * w + w * p, y * h + h * p, x * w + w - w * p, y * h + h - h * p, fill=fill, width=width, **kwargs)
  )

def drawOtherHalfCross(x, y, p=(2 - 2**.5 / 2) / 4, fill="black", width=w/28, **kwargs):
  return canvas.create_line(x * w + w - w * p, y * h + h * p, x * w + w * p, y * h + h - h * p, fill=fill, width=width, **kwargs)

def drawHalfCross(x, y, p=(2 - 2**.5 / 2) / 4, fill="black", width=w/28, **kwargs):
  return canvas.create_line(x * w + w * p, y * h + h * p, x * w + w - w * p, y * h + h - h * p, fill=fill, width=width, **kwargs)

def drawLine(x, y, x2, y2, fill="black", width=w/28, **kwargs):
  return canvas.create_line(x * w + w / 2, y * h + h / 2, x2 * w + w / 2, y2 * h + h / 2, fill=fill, width=width, **kwargs)

def drawRect(x, y, p=0, width=w/28, **kwargs):
  return canvas.create_rectangle(x * w + w * p, y * h + h * p, x * w + w - w * p, y * h + h - h * p, width=width, **kwargs)

# Getting the distance between nodes
def dist_between(src, dst):
  return 1 # As we currently only use this for neighbors in a grid

# Using rectangle number as id, as it is alreade unique
def getId(val): return str(val[0])

# Also defining other params in the nodes
def getH(val): return val[1]
def getG(val): return val[2]
def getSign(val): return val[3]
def getType(val): return types[val[3]]
def getCost(val): return costs[val[3]]
def getPoint(val): return val[4]
def getKids(val): return val[5]

# Check if node has a spesific kid
def hasKid(node, kid):
  return kid in getKids(node)

# Getting all valid neighbors in node
def getNeighbors(M, node):
  (x, y) = getPoint(node)
  neighbors = []
  if x > 0 and getType(M[y][x - 1]) == 0: neighbors.append(M[y][x - 1])
  if y > 0 and getType(M[y - 1][x]) == 0: neighbors.append(M[y - 1][x])
  if y < ch - 1 and getType(M[y + 1][x]) == 0: neighbors.append(M[y + 1][x])
  if x < cw - 1 and getType(M[y][x + 1]) == 0: neighbors.append(M[y][x + 1])
  return neighbors

# Getting scores based on INFINITY as default
def getScore(scoreList, node):
  try:
    return scoreList[getId(node)]
  except:
    return INFINITY

# Fill dict with map values with a default
def fillDictByMap(M, default=INFINITY):
  filledDict = {}
  for i in M:
    for val in i:
      filledDict[getId(val)] = default
  return filledDict

# Creating a canvas to draw on
canvas = tk.Canvas(root, width=cw * w, height=ch * h)
canvas.pack()

# Placing rectangles on the canvas according to the map in the file
for y in range(ch):
  for x in range(cw):
    val = M[y][x]
    (rect, heru, g, sign, point, kids) = val
    val[0] = drawRect(x, y, fill=colors[sign])

# Running the program
if not SHOW_BOARD_ONLY:
  astar(M, start, goal)

root.mainloop()
