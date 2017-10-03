# Øving 3

## a)

```
                0.6                 0.4
IF distance is Small AND delta is Growing THEN action is None
=> 0.4
                0.6                0.3
IF distance is Small AND delta is Stable THEN action is SlowDown
=> 0.3
                 0.1                  0.4
IF distance is Perfect AND delta is Growing THEN action is SpeedUp
=> 0.1
                 0.0            (1 - 0.4)                 (1 - 0)
IF distance is VeryBig AND (delta is NOT Growing OR delta is NOT GrowingFast) THEN action is FloorIt
=> 0.0
                  0.0
IF distance is VerySmall THEN action is BrakeHard
=> 0.0
```

Ut fra diagrammet får jeg:

| X | Y | X*Y
|:---:|:---:|:---:
| -7 | 0 | 0 |
| -6 | 0.3 | -1.8 |
| -5 | 0.3 | -1.5 |
| -4 | 0.3 | -1.2 |
| -3 | 0.3 | -0.9 |
| -2 | 0.3 | -0.6 |
| -1 | 0.4 | -0.4 |
| 0 | 0.4 | 0.0 |
| 1 | 0.4 | 0.4 |
| 2 | 0.3 | 0.6 |
| 3 | 0.1 | 0.3 |
| 4 | 0.1 | 0.4 |
| 5 | 0.1 | 0.5 |
| 6 | 0.1 | 0.6 |
| 7 | 0 | 0 |

Sum:
`Y = -3.6, X*Y = 3.4`

Dette gir at defuzzificationsummen blir:
`X*Y / Y = -3.6 / 3.4 = -1.0588`

## b)
