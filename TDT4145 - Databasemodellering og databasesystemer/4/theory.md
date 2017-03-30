# Problem 1: Normalization theory

### a) Define the following concepts: Key, super key and functional dependency.
- Key	A minimal set of attributes that uniquely identifies a touble in a relation.
- Super key	Equal to a key, except that it does not have to be minimal. 
- Functional dependency	A set attribute that is decided by a different attribute in the row. I.e. in the FD X → Y, Y is determined by X. Both X and Y can be a single or a set of attributes. 

### b) Explain what is meant by the closure, X+, of a set of attributes, X, with respect to a set of functional dependencies. Show an algorithm to find X+.
- A closure is the set of dependencies that include X or can be inferred from X. 

### c) Assume F = {a→e, ac→d, b→c}. Calculate the following closures: a+, ab+, e+
- a+ = {a, e}
- ab+ = {a→e, b→c, ac→d} = {a, b, c, d, e}
- e+ = {e}

### d) How do you decide if a set of attributes is a super key for a table? How do you decide that a super key is also a key?
- If the closure of the set of attributes contain all the attributes in the table, it is a super key. If none of the attributes can be removed without changing the closure, it is also a key.

### e) How do you decide if a decomposition of a table (R) into two projections (R₁ og R₂) has the lossless join property?
- If the intersection of R₁ and R₂ is equal to R₁ or R₂ the projections has the lossless join property.

### f) Assume a table R(a, b, c, d) and the functional dependency F = {b→c}. Below three decompositions of R are shown. Find which decompositions have the lossless join property. You must explain your answer.

- **R₁(a, b, c) and R₂(b, c, d)**
  - Lossless: No
  - Explanation: Intersection is b,c. a or d would be required for lossless
- **R₁(a, b, d) and R₂(b, c, d)**
  - Lossless: Yes
  - Explanation: Intersection b,c. b→c, which gives us b, c, d = R₂
- **R₁(a, b, d) and R₂(b, c)**
  - Lossless: Yes
  - Explanation: Interseciton b, b→c = R₂

### g) Give a definition of the 3rd normal norm (3NF).
- 3NF requires that:
  - The relation R is in 2NF
  - Every non-prime attribute of R is non-transitively dependent on every key of R.  
(aka attribute which isn’t part of a key)  
A transitive dependency is a functional dependency in which X → Z (X determines Z) indirectly, by virtue of X → Y and Y → Z (where it is not the case that Y → X).  
Aka et hvert ikke-nøkkel attributt er direkte avhengig av enhver nøkkel i R.

### h) The table R(A B C D) is not on 3NF when the functional dependencies are F = { A → B, C → D }. A possible decomposition of R is R₁(A B), R₂(C D) and R₃(A C). Is this decomposition a good solution? Your answer must be explained. 
R(A B C D)
F = { A → B, C → D }
R₁ (A B), R₂(C D), R₃(A C)
R₁ and R₃, and R₂ and R₃ have the lossless property, thus it is a good solution.


# Problem 2: 16.31 Static hashing

_A PARTS file with Part# as the hash key includes records with the following Part# values: 2369, 3760, 4692, 4871, 5659, 1821, 1074, 7115, 1620, 2428, 3943, 4750, 6975, 4981, and 9208. The file uses 8 buckets, numbered 0—7. Each bucket is one disk block and holds two records. Load these records into the file in the given order, using the hash function h(K) = K mod 8. Calculate the average number of block accesses for a random retrieval on Part#._

Use the hash function to insert all the posts into respective blocks:
<pre>
<b>B</b> | <b>Posts</b>
--|-----------
0 | 3760, 9206
1 | 2369
2 | 1074
3 | 5659, 7115
4 | 4692, 1620, 2428
5 | 1821, 4981
6 | 4750
7 | 4871, 3943, 6975
</pre>

As the blocs only supported 2 posts, we have overflow in both block 4 and 7. We solve this by chaining. When calculating average block reads, we have two blocs requiring two block assess, and thirteen requiring only one.

Thus, we have `13/15\*1 + 2/15\*2 = 17/15` block accesses on average for accessing Part [#]
 
# Problem 3: 16.32 Extendible hashing

_Load the records of problem 2 (16.31) into expandable hash files based on extendible hashing. Show the structure of the directory at each step, and the global and local depths. Use the hash function h(K) = K mod 128. Start with global depth 2 and four blocks._

P.t = Points to
L.d = Local depth

<pre>
 2 | P.t | L.d | Values
 . |-----|-----|----------
00 | . . | . 2 | 3760 4692
01 | . . | . 2 | 2369 1821
10 | . . | . 2 | 1074
11 | . . | . 2 | 4871 5659
</pre>

<pre>
 3 .| P.t | L.d | Values
 . .|-----|-----|----------
000 | . . | . 2 | 3760 4692
001 | . . | . 2 | 2369 1821
010 | . . | . 2 | 1074
011 | . . | . 3 | 5659 7115
100 | 000 | . . |
101 | 001 | . . |
110 | 010 | . . |
111 | . . | . 3 | 4871
</pre>

<pre>
 3 .| P.t | L.d | Values
 . .|-----|-----|----------
000 | . . | . 2 | 3760
001 | . . | . 2 | 2369 1821
010 | . . | . 2 | 1074
011 | . . | . 3 | 5659 7115
100 | . . | . 3 | 4692 1620
101 | 001 | . . |
110 | 010 | . . |
111 | . . | . 3 | 4871
</pre>

<pre>
 3 .| P.t | L.d | Values
 . .|-----|-----|----------
000 | . . | . 2 | 3760
001 | . . | . 2 | 2369 1821
010 | . . | . 2 | 1074
011 | . . | . 3 | 5659 7115
100 | . . | . 3 | 4692 1620
101 | 001 | . . |
110 | 010 | . . |
111 | . . | . 3 | 4871
</pre>

<pre>
 4 . | P.t .| L.d | Values
 . . |-----.|-----|----------
0000 | . . .| . 3 | 3760
0001 | . . .| . 3 | 2369
0010 | . . .| . 2 | 1074
0011 | . . .| . 3 | 5659 7115
0100 | . . .| . 4 | 4692 1620
0101 | . . .| . 3 | 1821 4981
0110 | 0010 | . . |
0111 | . . .| . 3 | 4871 3943
1000 | . . .| . 3 | 9208
1001 | 0001 | . . |
1010 | 0010 | . . |
1011 | 0011 | . . |
1100 | . . .| . 4 | 2428
1101 | 0101 | . . |
1110 | 0110 | . . |
1111 | . . .| . 4 | 6975
</pre>


# Problem 4: B+-trees

### a)
_Assume we are to create a B+-tree-index for a student database with 400000 students. The student records themselves are stored in a heapfile. The primary key for a student is student number, an integer using 4 bytes representation. Assume a block identifier to be 4 bytes. On the leaf level there is a pointer to the block where the student record is. This pointer is a block identifier as well. Assume a block to be 4096 bytes. How many blocks will exist at the different levels of the B+-tree? Explain the assumptions that you make._

- Every index will occupy 8 bytes, 4 for the identifier, and 4 for the record pointer.  
Bases on “experience” we know that each block will usually only be about 65% full. I.e. a block of size 4096 bytes will hold `4096 / 8 * 2/3 ~ 341` posts per block.  
To hold 400.000 students, we will need approx. `400.000 / 341 = 1173` blocks on the leaf level.  
Total of 2 layers + root. Leaf is layer two. Layer one will have 4 blocs, and root is one.

### b)
_If you are to insert student 400001 in the student database, how many disk accesses do you get? Explain the assumptions you make?_

- 1 write to end of heapfile + read to find end, plus read root and lever 1, plus read and write leaf level = 2 writes and 4 reads

### c)
_If you are to find and update a leaf level record of the B+-tree, how long time does it take? Assume reasonable disk access timing and describe these assumptions._

- Assume 10ms per access, 4 reads give us a 40ms access time.  

### d)
_Assume there is space for 3 records in each block in a B+-tree. Assume the B+-tree to initially be empty. Show the B+-tree after each insertion of records with the following keys: 12, 7, 9, 3, 18, 22, 1, 37, 11._

<pre>
 . . +-------[9, 18, -]--------+ . . .
 . . | . . . . . | . . . . . . | . . .
[1, 3, 7] . [9, 11, 12] . [18, 22, 37]
</pre>

# Problem 5: Storage and queries

_We have a table to keep information about employees:_

_`Employee (ssn, fname, lname, salary, super_ssn, dno)`_

_The attribute ssn is the primary key for the table. We have chosen to store and index the table in the following manner. The table is stored in a clustered, static hash-structure where all 100 000 employee records are stored in 1250 data blocks. The search key is ssn. Overflow is organized such that the record is stored in the first successive block with enough space. In average 1.2 blocks are accessed per search on ssn._

_The table is also indexed through an unclustered B+-tree with the search key ‘lname’ (last name) which gives ssn to employees. The B+-tree has 3 levels and 600 blocks on the leaf level. Give an estimate on how many blocks which are accessed (i.e. read and written) when executing the following SQL-statements:_

1. INSERT INTO Employee VALUES (‘12345678901’, ‘Hans’, ‘Hansen’, 500000, ‘98765432101’, 101);
2. SELECT * FROM Employee WHERE ssn=’12345678901’;
3. SELECT * FROM Employee WHERE lname=’Hansen’;
4. SELECT lname FROM Employee WHERE salary > 600000; Anta 10% av de ansatte tilfredstiller betingelsen.
5. SELECT DISTINCT lname FROM Employee ORDER BY lname;

_Give an explanation for each answer._

1. The insert will require 3 reads of the B+ tree, and then one write. Then it will read on average 1.2 blocs and write once. Total 4.2 reads and 2 writes, 6.2 block accesses. 
2. Can use the hash directly, 1.2 accesses
3. 3 reads in the B+ tree, pluss 1.2 reads per hit. Total: 3+1.2*#OfHansen
4. WHERE salary > 100000 forces a complete search. All 1250 blocks are accessed.
5. Two reads to reach the leaf lever in the B+ tree, plus the 600 leaf nodes. Total 602 accesses. 
