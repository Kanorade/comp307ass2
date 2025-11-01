# Neural Networks and Genetic Programing
Assignment 2 for *Fundamentals of AI* course
---
Other assignments for the course can be found here:
- [Assignment 1](https://github.com/Kanorade/AI-Ass1-Basic-ML-Algorithms)

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
