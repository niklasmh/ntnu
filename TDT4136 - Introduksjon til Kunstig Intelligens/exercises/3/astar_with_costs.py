#!/usr/bin/python3

import tkinter as tk
from sys import stdin, argv
argc = len(argv)
from time import sleep

# Setting used constants
INFINITY = float("inf")
DIST_FACTOR = 0
COST_FACTOR = 10 # Task 2: Only the cost matter
ANIMATE = False
SHOW_BOARD_ONLY = False
INTERVAL = 20
FILE = None

# Getting args from user
# Format: <file> [interval_in_ms [dist_factor,cost_factor]]
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

# Defining the GUI in Tkinter
root = tk.Tk()

# Setting some variables in the global scope
start = None
goal = None
M = []
PM = []
ch = 0
x = 0
y = 0

# Check if file is piped in with "< file.txt" or added as an argument
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

# Centering the window and setting the size of the smallest side
sw = root.winfo_screenwidth()
sh = root.winfo_screenheight()

# Calculating the block sizing for the board based on the window size
if sw / sh < cw / ch:
  w = .8 * sw / cw
  h = .8 * (sw * ch / cw) / ch
else:
  w = .8 * (sh * cw / ch) / cw
  h = .8 * sh / ch

# Positioning the window in center and setting width to the calculated one
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
  dist = (abs(sx - dx) + abs(sy - dy)) * dist_factor # Hamming distance
  cost = costs[getSign(src)] * cost_factor # Cost based on type
  return dist + cost

# The main code for finding the path
def astar(M, start, goal):
  global root

  # Declearing a state with:
  # - Closed nodes => empty dict of closed nodes with id as key
  # - Open nodes => empty dict of open nodes with id as kay
  # - Parent node => dict with all nodes and None as value on all of them
  # - g(x) score => dict with infinity on all nodes by default
  # - f(x) score => dict with infinity on all nodes by default
  state = {
    "closed": {},
    "open": {},
    "parent": fillDictByMap(M, None),
    "gScore": fillDictByMap(M),
    "fScore": fillDictByMap(M)
  }

  # Now adding the start node to the open dict
  state["open"][getId(start)] = start

  # Adding a open mark on the start node
  drawHalfCross(getPoint(start)[0], getPoint(start)[1])

  # Also setting the start node to 0 for g(x)
  state["gScore"][getId(start)] = 0

  # Calculating an initial heruistic to the start node
  # As g(x) is 0 we do not need any g(x) value added to the f(x) for this node
  state["fScore"][getId(start)] = heuristic_cost_estimate(start, goal)

  # Making it possible to go step by step in time with animation frames
  def Refresh(frame):
    state = frame.state
    state["after_id"] = frame.after(INTERVAL, Refresh, frame)

    if state["open"]: # Continue as long there are elements in the open dict
      run_astar_step(state, frame)
    else: # If the open set is empty, the search is over and has failed
      frame.after_cancel(state["after_id"])
      print("Failed")

  root.state = state
  if ANIMATE:
    Refresh(root)
  else:
    while state["open"]: # Continue as long there are elements in the open dict
      mode = run_astar_step(state)
      if mode == 0: # If the stepper returns 1, the algorithm is still searching
        continue
      elif mode == 1: # If the stepper returns 1, the goal has been found
        return

    # If the open set is empty, the search is over and has failed
    print("Failed")

# Running a step in A* based on the current state
def run_astar_step(state, frame=None):
  
  # First checking the state for the "best node" based on the f(x)
  vals = list(state["open"].values())
  if len(vals): current = vals.pop()
  for val in vals:
    if getScore(state["fScore"], val) < getScore(state["fScore"], current):
      current = val

  # If the current is the goal, we are done
  if current == goal:
    #draw_markings(M, state["closed"], state["open"]) # If we want to draw every state once again
    reconstruct_path(state["parent"], current)
    if frame:
      frame.after_cancel(state["after_id"])
    return 1

  # Deleting the chosen from open nodes and adding it to closed nodes
  if getId(current) in state["open"]:
    del state["open"][getId(current)]
    (x, y) = getPoint(current)
    drawOtherHalfCross(x, y)
  state["closed"][getId(current)] = current

  # Going through all its neighbors
  for neighbor in getNeighbors(M, current):
    neighbor_id = getId(neighbor)

    # If neighbor is closed, we stop. Skipping this makes A* greedy and fast.
    if neighbor_id in state["closed"]:
      continue

    # Then, if the neigbor does not exist in open nodes:
    if not neighbor_id in state["open"]:
      (x, y) = getPoint(neighbor)
      drawHalfCross(x, y)

      # Adding the neighbor to the open set, making it searchable in the future
      state["open"][neighbor_id] = neighbor

    # Calculating a score for this node
    temp_gScore = getScore(state["gScore"], current) + dist_between(current, neighbor)

    # If the score calculated previously is not "better", skip, as it has already a better parent
    if temp_gScore >= getScore(state["gScore"], neighbor):
      continue

    (nx, ny) = getPoint(neighbor)
    (cx, cy) = getPoint(current)
    drawLine(nx, ny, cx, cy)

    # Connecting the current node as the parent
    state["parent"][neighbor_id] = current

    # Setting the new g(x) score to the calculated one
    state["gScore"][neighbor_id] = temp_gScore

    # Setting a new f(x) = g(x) + h(x) to the neighbor
    state["fScore"][neighbor_id] = temp_gScore + heuristic_cost_estimate(neighbor, goal)
  return 2

# Finding the path back by following each nodes "best path"
def reconstruct_path(parent, current):
  heru = heuristic_cost_estimate(current, goal)
  cost = getCost(current)
  total_path = [ current ]
  (x, y) = getPoint(current)
  drawCircle(x, y, 1 / 4, fill="black")
  while current and getId(current) in parent:
    current = parent[getId(current)]
    total_path.append(current)
    if current:
      heru += heuristic_cost_estimate(current, goal)
      cost += getCost(current)
      (x, y) = getPoint(current)
      drawCircle(x, y, 1 / 4, fill="black")
  #print("Heruistic of: " + str(heru))
  print("This path costs: " + str(cost))
  return total_path

def draw_markings(M, closed, openSet):
  for i in M:
    for j in i:
      if getId(j) in closed:
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

# Displaying the GUI
root.mainloop()
