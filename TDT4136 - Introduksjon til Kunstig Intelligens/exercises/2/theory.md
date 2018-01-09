# Assignment 1

## 1 Models and Entailment in Propositional Logic

### Task 1.1

a) 

| A | B | ¬A | ¬B | ¬A ∧ ¬B
|---|---|:---:|:---:|:---:|
| 0 | 0 | 1 | 1 | 1
| 0 | 1 | 1 | 0 | 0
| 1 | 0 | 0 | 1 | 0
| 1 | 1 | 0 | 0 | 0

¬A ∧ ¬B \|= ¬B is true

b)

| A | B | ¬A | ¬B | ¬A ∨ ¬B
|---|---|:---:|:---:|:---:
| 0 | 0 | 1 | 1 | 1
| 0 | 1 | 1 | 0 | 1
| 1 | 0 | 0 | 1 | 1
| 1 | 1 | 0 | 0 | 0

¬A ∨ ¬B \|= ¬B is false

c)

| A | B | ¬A | ¬A ∧ B | A ∨ B
|---|---|:---:|:---:|:---:
| 0 | 0 | 1 | 0 | 0
| 0 | 1 | 1 | 0 | 1
| 1 | 0 | 0 | 0 | 1
| 1 | 1 | 0 | 1 | 1

¬A ∧ B \|= A ∨ B is true

d)

| A | B | A ⇒ B | A ⇔ B
|---|---|:---:|:---:|:---:
| 0 | 0 | 1 | 1
| 0 | 1 | 1 | 0
| 1 | 0 | 0 | 0
| 1 | 1 | 1 | 1

A ⇒ B \|= A ⇔ B is false

e)

| A | B | C | ¬B | (A ⇒ B) ⇔ C | A ∨ ¬B ∨ C
|---|---|---|:---:|:---:|:---:
| 0 | 0 | 0 | 1 | 0 | 1
| 0 | 0 | 1 | 1 | 1 | 1
| 0 | 1 | 0 | 0 | 0 | 0
| 0 | 1 | 1 | 0 | 1 | 1
| 1 | 0 | 0 | 1 | 1 | 1
| 1 | 0 | 1 | 1 | 0 | 1
| 1 | 1 | 0 | 0 | 0 | 1
| 1 | 1 | 1 | 0 | 1 | 1

(A ⇒ B) ⇔ C \|= A ∨ ¬B ∨ C is true

f)

| A | B | ¬A | ¬B | (¬A ⇒ ¬B) | (A ∧ ¬B)
|---|---|:---:|:---:|:---:|:---:|:---:
| 0 | 0 | 1 | 1 | 1 | 1 | 1
| 0 | 1 | 1 | 0 | 0 | 0 | 0
| 1 | 0 | 0 | 1 | 1 | 1 | 1
| 1 | 1 | 0 | 0 | 1 | 1 | 1

(¬A ⇒ ¬B) ∧ (A ∧ ¬B) is satisfiable

g)

| A | B | ¬A | ¬B | (¬A ⇔ ¬B) | (A ∧ ¬B) | (¬A ⇔ ¬B) ∧ (A ∧ ¬B)
|---|---|:---:|:---:|:---:|:---:|:---:
| 0 | 0 | 1 | 1 | 1 | 0 | 0
| 0 | 1 | 1 | 0 | 0 | 0 | 0
| 1 | 0 | 0 | 1 | 0 | 1 | 0
| 1 | 1 | 0 | 0 | 1 | 0 | 0

(¬A ⇔ ¬B) ∧ (A ∧ ¬B) is not satisfiable

### Task 1.2

a) ¬A38 ∧ ¬A49 = 2⁹⁸

b) A27 ∧ ¬A46 ∧ A57 = 2⁹⁷

c) A27 ∧ (A46 ∨ ¬A57) = 3/4 * 2¹⁰⁰

d) ¬A85 ⇒ ¬A91 = 2⁹⁸

e) (¬A14 ⇔ ¬A19) ∧ (A21 ⇒ A22) = 3/4 * 2⁹⁹

f) A41 ∧ ¬A59 ∧ A64 ∧ ¬A85 ∧ A87 ∧ ¬A90 = 2⁹⁴

### Task 1.3

| P3.1| P3.2| P3.3| P4.4| Valid | Claims
|:---:|:---:|:---:|:---:|:-----:|:---
|  0  |  0  |  0  |  0  |   0   | a1, a3
|  0  |  0  |  0  |  1  |   0   | a1, a2, a4
|  0  |  0  |  1  |  0  |   0   | a1, a3, a4
|  0  |  0  |  1  |  1  |   0   | a1, a2, a4
|  0  |  1  |  0  |  0  |   0   | a3
|  0  |  1  |  0  |  1  |   0   | a2, a4
|  0  |  1  |  1  |  0  |   0   | a3, a4
|  0  |  1  |  1  |  1  |   0   | a2, a4
|  1  |  0  |  0  |  0  |   0   | a1, a3
|  1  |  0  |  0  |  1  |   1   | a1, a2, a4
|  1  |  0  |  1  |  0  |   1   | a1, a3, a4
|  1  |  0  |  1  |  1  |   1   | a1, a2, a4
|  1  |  1  |  0  |  0  |   0   | a3
|  1  |  1  |  0  |  1  |   0   | a2, a4
|  1  |  1  |  1  |  0  |   0   | a3, a4
|  1  |  1  |  1  |  1  |   0   | a2, a4

a1 = "There is no pit in [3, 2]".  
a2 = "There is a pit in [4, 4]".  
a3 = "There is no a pit in [4, 4]".  
a4 = "There is a pit in [3, 3] or [4, 4]".

## 2 Resolution in Propositional Logic

### Task 2.1

a) A ∨ (B ∧ C ∧ ¬D)  
=> A ∨ (B ∧ (C ∧ ¬D))  
=> (A ∨ B) ∧ (A ∨ (C ∧ ¬D))  
=> (A ∨ B) ∧ (A ∨ C) ∧ (A ∨ ¬D)

b) ¬(A ⇒ ¬B) ∧ ¬(C ⇒ ¬D)  
=> ¬(¬A ∨ ¬B) ∧ ¬(¬C ∨ ¬D)  
=> (A ∧ B) ∧ (C ∧ D)

c) ¬((A ⇒ B) ∧ (C ⇒ D))  
=> ¬((¬A ∨ B) ∧ (¬C ∨ D))  
=> ¬(¬A ∨ B) ∨ ¬(¬C ∨ D)  
=> (A ∧ ¬B) ∨ (C ∧ ¬D)

d) (A ∧ B) ∨ (C ⇒ D)  
=> (A ∧ B) ∨ (¬C ∨ D)

e) A ⇔ (B ⇒ ¬C)  
=> A ⇔ (¬B ∨ ¬C)  
=> (A ⇒ (¬B ∨ ¬C)) ∧ ((¬B ∨ ¬C) ⇒ A)  
=> (¬A ∨ (¬B ∨ ¬C)) ∧ (¬(¬B ∨ ¬C) ∨ A)  
=> (¬A ∨ ¬(B ∧ C)) ∧ ((B ∧ C) ∨ A)  
=> ¬(A ∧ B ∧ C) ∧ (A ∨ B) ∧ (A ∨ C)

### Task 2.2

(D ∧ E) ⇒ C  
¬A ⇒ ¬B  
¬C ∧ E  
¬D ⇒ B

Use resolution to show that KB |= A

### Task 2.3

Do exercise 7.17 / 6.18 from the textbook (“Consider the following sentence. . . ”), but with the following sentence instead of the one in the textbook:  
(¬Party ⇒ ¬(Food ∨ Drinks)) ⇒ (Food ⇒ Party)

## 3 Representations in First-Order Logic

### Task 1

a)

1. 2
2. 1
3. 3

b)

1. 1
2. 1
3. 1
4. 2

c)

1. 1
2. 2
3. 1
4. 1

d)

1. 1
2. 1
3. 3
4. 3

e)

1. 1
2. 1
3. 1
4. 2

### Task 2

a)
CB = "Christian Bale"
GC = "George Clooney"
VK = "Val Kilmer"
c = "Batman"
=> PlayedCharacter(CB, c) ∧ PlayedCharacter(GC, c) ∧ PlayedCharacter(GC, c)

b)
=> ∀p (PlayedCharacter(p, "Batman") ∧ Male(p))

c)
=> ∀p (PlayedCharacter(p, "Batwoman") ∧ Female(p))

d)
CB = "Christian Bale"
HL = "Heath Ledger"
=> ∀c ¬(PlayedCharacter(CB, c) ∧ PlayedCharacter(HL, c))

e)
CN = "Christopher Nolan"
CB = "Christian Bale"
=> ∀m (Directed(CN, m) ⇒ (PlayedCharacter(CB, "Batman") ∧ PlayedInMovie(CB, m))

f)
=> ∃m (CharacterInMovie("Joker", m) ∧ CharacterInMovie("Batman", m))

g)
KC = "Kevin Costner"
=> ∃m (Directed(KC, m) ∧ PlayedInMovie(KC, m))

h)
GC = "George Clooney"
T = "Tarantino"
=> ∀m ¬(PlayedInMovie(GC, m) ∧ PlayedCharacter(T, c)) ∧ ∀m ¬(Directed(T, m) ∧ PlayedInMovie()GC, m)

i)
UT = "Uma Thruman"
T = "Taratino"
=> Female(UT) ∧ ∃m (PlayedInMovie(UT, m) ∧ Directed(T, m))

### Task 3

a)
=> ∀y,z (z < x ∧ x=z*y)

b)
=> ∀y (x = y*2)

c)
=> ∀y (x ≠ y*2)

d)
=> ∀y (x = y*2+1)

e)
=> ∀y ((x!=y) ∧ (x>y) ∧ (y!=1)) ⇒ ¬(x/y)

f,g) help...

## 4 Resolution in First-Order Logic

### Task 1

a) x/Rocky

b) Leo/x, Rocky/y

c) Leo/y, x/Rocky

d) Not possible

e) x/Leo, FastestHorse(Leo)/Rocky

f) Leo/x, y/FastestHorse(Leo)

g) Not possible

### Task 2

a) Philosopher(g(x)) ∧ StudentOf(f(y), g(x))

b) ∀y,x (¬Philosopher(x) ∨ ¬StudentOf(y,x) ∨ (Book(g(x,y)) ∧ Write(x, g(x,y)) ∧ Read(y, g(x,y))))

