#!/usr/bin/python3

distance = 3.75
delta = 1.2

distanceset = {
    "start": 0,
    "end": 10,
    "keys": {
        "VerySmall": (0, 0, 1.25, 2.5),
        "Small": (1.5, 3, 3, 4.5),
        "Perfect": (3.5, 5, 5, 6.5),
        "Big": (5.5, 7, 7, 8.5),
        "VeryBig": (7.5, 9, 10, 10)
    }
}

deltaset = {
    "start": -5,
    "end": 5,
    "keys": {
        "ShringkingFast": (0, 0, -4, -2.5),
        "Shringking": (-3.5, -2, -2, -0.5),
        "Stable": (-1.5, 0, 0, 1.5),
        "Growing": (0.5, 2, 2, 3.5),
        "GrowingFast": (2.5, 4, 5, 5)
    }
}

actions = {
    "start": -10,
    "end": 10,
    "keys": {
        "BrakeHard": (-10, -10, -8, -5),
        "SlowDown": (-7, -4, -4, -1),
        "None": (-3, 0, 0, 3),
        "SpeedUp": (1, 4, 4, 7),
        "FloorIt": (5, 8, 10, 10)
    }
}

fuzzysets = {
    "distance": distanceset,
    "delta": deltaset
}

def AND (x, y):
    return min(x, y)

def OR (x, y):
    return max(x, y)

def NOT (x):
    return 1 - x

def getval (fuzzyset, key, x):
    keyset = fuzzyset["keys"][key]

    # Sjekker om endene slutter på topp
    if fuzzyset["start"] == keyset[0] and x <= keyset[1]: return 1
    if fuzzyset["end"] == keyset[3] and x >= keyset[2]: return 1

    # Sjekker deretter om x er utenfor trapeset
    if x <= keyset[0]: return 0
    if x >= keyset[3]: return 0

    # Sjekker så om x er på toppen av trapeset
    if keyset[1] <= x <= keyset[2]: return 1

    # Om vi kommer hit treffer x i en av bakkene
    if keyset[0] < x < keyset[1]: return (x - keyset[0]) / (keyset[1] - keyset[0])
    if keyset[2] < x < keyset[3]: return 1 - (x - keyset[2]) / (keyset[3] - keyset[2])

    return 0

def fuzzyfication (sets):
    dist = sets["distance"]
    delt = sets["delta"]
    weights = {}
    weights["None"] = AND(getval(dist, "Small", distance), getval(delt, "Growing", delta))
    weights["SlowDown"] = AND(getval(dist, "Small", distance), getval(delt, "Stable", delta))
    weights["SpeedUp"] = AND(getval(dist, "Perfect", distance), getval(delt, "Growing", delta))
    weights["FloorIt"] = AND(getval(dist, "VeryBig", distance), OR(NOT(getval(delt, "Growing", delta)), NOT(getval(delt, "GrowingFast", delta))))
    weights["BreakHard"] = getval(dist, "VerySmall", distance)
    return weights

def aggregation (actions, weights):
    #for i in range(actions["start"], actions["end"]):

    #for (action, val) in actions["keys"]:

    return []

def defuzzyfication ():
    return 0

def main ():
    weights = fuzzyfication(fuzzysets)
    values = aggregation(actions, weights)

main()
