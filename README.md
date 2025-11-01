# Neural Networks and Genetic Programing
Assignment 2 for *Fundamentals of AI* course
---
Other assignments for the course can be found here:
- [Assignment 1](https://github.com/Kanorade/AI-Ass1-Basic-ML-Algorithms)

--- 
This assignment is broken into 2 parts: 
1. Part One: Neural Networks
2. Part Two: Genetic Programming (source code is on a seperate branch, may fix it later)

A summary of the each part and the problem its trying to solve is described below.

A detailed description of the results of the assignment can be found in "Assignment 2.pdf"

---

The code can be run by downloading the submission.zip file and extracting it. The Assignment is split into seperate directories, 
parts one and two. For each directory there is:
- a runnable jar file
- a readme file on how to run it (part two only, part one is missing for some reason)
- the traning and testing files used

All of Part One (Neural Network) was written from scratch for learning purposes, although skeleton code was provided. Due to how time 
consuming it would be to write Genetic Programming code from scratch, the Java package JGAP was used to implement sympolic regression 
for Part Two.
## Part 1: Classifying Pingu with a Neural Network
Implementing a simple neural network to classify penguins.
### Training and Test Data
As described in the assignment description:

Obtained from [palmer-
penguins: Palmer Archipelago (Antarctica) penguin data](https://allisonhorst.github.io/palmerpenguins/)

The original dataset contained 344 penguins, with species corresponding to their: species, island, bill length (mm), 
bill depth (mm), flipper length (mm), body mass (g), sex, and the year of observation. To simplify the task, we have 
processed the dataset to remove all missing values and keep only the four real-valued numerical features, plus the 
species as the class label. The processed dataset consists of three species (classes) of penguins: 146 of class “Adelie”, 
119 of class “Gentoo”, and 68 of class “Chinstrap”. The features are bill length (mm), bill depth (mm),
flipper length (mm) and body mass (g).

### Output:
It will display the weights of the neural network for the first 100 iterations with the traning data; or earlier if a conversion has occured. It will then test the accuracy of the NN model using the test file provided.

## Part 2: Genetic Programming for Symbolic Regression
Using genetic programing to evolve a mathematical function.
### Dataset
The goal is to use to GP to discover a mathematical function most closely match the provides (x,y) coordinates provided in regression.txt found in the Resources directory.

Coordinates provided in regression.txt:
| x | y |
| ----------- | ----------- |
| -2.00 | 37.00000|
| -1.75 | 24.16016|
| -1.50 | 15.06250|
| -1.25 | 8.91016|
| -1.00 | 5.00000|
| -0.75 | 2.72266|
| -0.50 | 1.56250|
| -0.25 | 1.09766|
|  0.00 | 1.00000|
|  0.25 | 1.03516|
|  0.50 | 1.06250|
|  0.75 | 1.03516|
|  1.00 | 1.00000|
|  1.25 | 1.09766|
|  1.50 | 1.56250|
|  1.75 | 2.72266|
|  2.00 | 5.00000|
|  2.25 | 8.91016|
|  2.50 | 15.06250|
|  2.75 | 24.16016|

### Output
A series of log4j reports.
Displays the most suitable mathematical function of each generation that best fits the y values at a given x. The program stops when the "fitness" is very close to zero
