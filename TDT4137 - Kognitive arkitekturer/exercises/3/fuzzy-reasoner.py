#!/usr/bin/python3

distanceset = {
    start: 0,
    end: 10,
    nodes: {
        "VerySmall": (0, 0, 1.25, 2.5),
        "Small": (1.5, 3, 3, 4.5),
        "Perfect": (3.5, 5, 5, 6.5),
        "Big": (5.5, 7, 7, 8.5),
        "VeryBig": (7.5, 9, 10, 10)
    }
}

deltaset = {
    start: -5,
    end: 5,
    nodes: {
        "ShringkingFast": (0, 0, -4, -2.5),
        "Shringking": (-3.5, -2, -2, -0.5),
        "Stable": (-1.5, 0, 0, 1.5),
        "Growing": (0.5, 2, 2, 3.5),
        "GrowingFast": (2.5, 4, 5, 5)
    }
}

fuzzysets = [
    distanceset,
    deltaset
]
