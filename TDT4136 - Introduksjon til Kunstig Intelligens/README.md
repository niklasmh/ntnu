# Intro til AI

## Tentativ plan
| Lecture | Description
| --- | ----
| 1 | [Introduction to AI (chapter 1), 2016-08-22.](#lecture-1)
| 2 | [Intelligent agents (chapter 2), 2016-08-29.](#lecture-2)
| 3 | [Logical Agents (2010 version (blue cover): chapter 7, 2014 version (green cover): chapter 6), 2016-09-05.](#lecture-3)
| 4 | [First Order Logic (chapter 8), 2016-09-12.](#lecture-4)
| 5 | [Inference in First order Logic (chapter 9), 2016-09-19.](#lecture-5)
| 6 | [Solving Problems by Searching (chapter 3 & 4.1), 2016-09-26.](#lecture-6)
| 7 | [Adverserial Search (chapter 5), 2016-10-03.](#lecture-7)
| 8 | [Constraint Satisfaction Problems (2010 version (blue cover): chapter 6, 2014 version (green cover): chapter 7), 2016-10-10.](#lecture-8)
| 9 | [Planning (chapter 10-11), 2016-10-17.](#lecture-9)
| 10 | [Knowledge Representation (chapter 12), 2016-10-24.](#lecture-10)
| 11 | [Knowledge Representation (chapter 12), 2016-10-31.](#lecture-11)
| 12 | [Natural Language Processing (2010 version (blue cover): chapter 22, 2014 version (green cover): chapter 21), 2016-11-07.](#lecture-12)
| 13 | [Summary 2016-11-14](#lecture-13)

### Lecture 1

Syllabus:
- AI - A Mordern Approach, Russel & Norvig, 3rd edition
- Lecture notes


Topics:
- Inteligent systems
- Logical systems
- Search
- Knowledge representation
- Planning
- Natural language processing

Today:
- What is AI?
  - There is no formal definition covering all aspects of intelligence.

- Symbolic system hypothesis (Newell and Simon)
- Biological substrate only (John Searle, philosopher)
- Other researchers believe that *sub-synbolic* processing (signal processing) may be needed ro repoicate intelligence.
  - Sub-symbolic: Neural networks

### Lecture 2

State diagram

```
+-----------------------------+   +---------------------+
|                   Sensors <--------                   |
|                     |       |   |                     |
|                     v       |   |                     |
|                  The world  |   |                     |
|                     |       |   |                     |
|                     |       |   |     Environment     |
|                     v       |   |                     |
|  Rules -------> What action |   |                     |
|                     |       |   |                     |
|                     v       |   |                     |
|                 Actuators -------->                   |
+-----------------------------+   +---------------------+
```

State diagram evolved

```
+-----------------------------+   +---------------------+
|                   Sensors <--------                   |
|                     |       |   |                     |
|                     v       |   |                     |
|                  The world  |   |                     |
|                     |       |   |                     |
|                     v       |   |                     |
|                 What will   |   |                     |
|                  be done    |   |                     |
|                     |       |   |     Environment     |
|                     v       |   |                     |
|  Goals -------> What action |   |                     |
|                     |       |   |                     |
|                     v       |   |                     |
|                 Actuators -------->                   |
+-----------------------------+   +---------------------+
```
