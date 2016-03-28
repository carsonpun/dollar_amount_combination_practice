# Introduction

This is a practice exercise to calculate all the combinations for a given amount of dollars (in integer) and a given set of face value.

# To run

Say you want to get all the possible combination for the total 6 dollars, with the face value set 1,2 and 5

`sbt "run 6 1 2 5"`

which will return
```
Map(5 -> 0, 1 -> 2, 2 -> 2)
Map(2 -> 0, 1 -> 1, 5 -> 1)
Map(2 -> 0, 5 -> 0, 1 -> 6)
Map(5 -> 0, 2 -> 1, 1 -> 4)
Map(1 -> 0, 5 -> 0, 2 -> 3)
------------------------------
total number of solutions: 5
```
