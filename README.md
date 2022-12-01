
# Command Line Based Jungle Game

[Jungle game](https://en.wikipedia.org/wiki/Jungle_(board_game)) is a traditional Chinese board game. This is a software engineering course project.

This repository contains:
1. Brief introduction
2. Dependencies
3. How to install and execute
4. Operations
5. Authors

## Description
Year: 2022

The command line based Jungle game implementation. 
[Here](https://en.wikipedia.org/wiki/Jungle_(board_game)#Rules) is the game rules.

## Dependencies

- Java 11 environment
- Intellij IDEA IDE (Recommended, but it can also be compiled in shell.)
- Apache Maven 3.8.6 (Optional)
- Junit 4.11 (Optional)

## How to install and execute

To install this project, you can simply download the source code 
under folder "clj/src" to your desired directory.

To compile this project in intellij IDEA,
access the "Edit Configurations" in "App.java" and ensure the Java 11 is used.
Click the "Build" button and "Run" button to launch the application.

If you have installed Apache Maven, you can compile the source code in shell 
under the source code directory by entering
```sh
mvn clean package
```

After you launch the application, two players should enter their name and the
party (Blue or Red) will be given to each player randomly.

## Operations

After entering the names, a random player will be chosen to move first.
You can know who is playing in this turn by observing the first hint sentence 
after each turn begin.

Pieces are represented by a traditional Chinese character on map. 
To move a piece, you should enter the piece index on map, following the format of
"column first, then row", i.e. A7.

Then, you should enter the direction to move. (This is not case-sensitive)
- To move forward, enter "w"
- To move backward, enter "s"
- To move to the left, enter "a"
- To move to the right, enter "d"

The applicatoin will alert user for any invalid movement, then you should re-enter
the correct command.

## Authors

- [@chichunho](https://github.com/chichunho)
- [@CheungKW0301](https://github.com/CheungKW0301)
- [@hyt061141](https://github.com/hyt061141)
