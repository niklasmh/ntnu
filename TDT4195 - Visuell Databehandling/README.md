# Grunnleggende Visuell Databehandling

### Clipping:

```
if c1 v c2 = 0000: Entirely inside
if c1 ^ c2 != 0000: Entirely outside
```

| Endpoint | Code | Endpoint | Code
| --- | --- | --- | ---
| a | 0001 | e | 0100
| b | 0101 | f | 0010
| c | 0000 | g | 0001
| d | 0000 | f | 1010

| c₁ c₂ c₃ c₄ | v
| --- | ---
| 0000 | 
| ⋮ | 
| 1000 | v₁ v₂ v₃ v₄
| ⋮ |
| 1111 |

f(x, y) = ax + by + c
a = y2 - y1
b = x1 - x2
c = x2y1 - x1y2

0,10 -- 10,10
 |        |
 |        |
0,0 --- 10,0

a = 12 - 0 = 12
b = -10 - 10 = -20
c = 10*0 - 10*12
a \* 0 + b \* 10 + c = -320

#### LB Algorithm

`P = p1 + t * (p2 - p1), t ∊ [0, 1]`

or

`x = x1 + t * dx, y = y1 + t * dy`

where

`dx = x2 - x1, dy = y2 - y1`

```
xmin <= x1 + t * dx <= xmax
ymin <= y1 + t * dy <= ymax
```

or

```
-t * dx <= x1 - xmin,
 t * dx <= xmax - x1,
-t * dy <= y1 - ymin,
 t * dy <= ymax - y1
```

## NikkApp ultimate formula finally used:

`px1 - (-(qy2-qy1)*(px1-qx1)+(qx2-qx1)*(py1-qy1))/((qx2-qx1)*(py2-py1)-(px2-px1)*(qy2-qy1)) * (px2-px1)`

Common form:

`t * pi <= qi`

where

```
p1 = -dx, q1 = x1 - xmin
p2 = dx, q2 = xmax - x1
p3 = -dy, q3 = y1 - tmin
p4 = dy, q4 = ymax - y1
```

tᵢₙ = max({ (qᵢ / pᵢ) | pᵢ < 0, i: 1..4} U {0})
tₒᵤₜ = min({ (qᵢ / pᵢ) | pᵢ > 0, i: 1..4} U {1})

### Example

dx = 2.5 & dy = 2.5
p1 = -2.5, q1 = -0.5

Compute: tm = max({})


## Lecture 3

            v2
       vi1 / \
+------------+vw
|        /   | \
|     v0 -- -|- v1
|            |vi0
|            |
|            |
+------------+
  
Stage 0: v0 v2 v1
Stage 1: vi0 v0 v2 vi2
Stage 2: vi2 vi0 v0 v2
Stage 3: vi3 vi0 v0 vi1
