package com.aca.homework.week5.light_out;

import java.util.Scanner;

public class Game {
    private int moves = 0;
    private Light[][] board;
    private int[][] stateOffLightCoordinates = {
            {0, 2},
            {1, 1},
            {1, 3},
            {2, 0},
            {2, 4},
            {3, 3},
            {3, 1},
            {4, 2},
    };

    //0|++0++
    //1|+0+0+
    //2|0+++0
    //3|+0+0+
    //4|++0++
    public Game() {
        initialize();
    }

    private void initialize() {
        boolean stateOff = false;
        boolean stateOn = true;
        board = new Light[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (isStateOffLightsCoordinates(i, j)) {
                    board[i][j] = Light.ofOff();
                } else {
                    board[i][j] = Light.ofOn();
                }
            }
        }
    }

    private boolean isStateOffLightsCoordinates(int x, int y) {
        for (int i = 0; i < stateOffLightCoordinates.length; i++) {
            if (x == stateOffLightCoordinates[i][0]
                    && y == stateOffLightCoordinates[i][1]) {
                return true;
            }
        }
        return false;
    }


    public void startGame() {
        System.out.println("The game started!!");
        printBoard();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please enter a hit coordinates in '(x,y)' format:");
            String newCoordinates = scanner.next();
            while (!isRightFormat(newCoordinates)) {
                System.out.println("Invalid coordinates!!");
                newCoordinates = scanner.next();
            }
            int i = getCoordinate(newCoordinates) % 10;
            int j = getCoordinate(newCoordinates) / 10;
            switchLights(i, j);
            moves++;
            printBoard();
        } while (continueGame());

        System.out.println("You won!!!");

    }

    private boolean isRightFormat(String coordinates) {
        if (checkCoordinatesFormat(coordinates)) {
            return checkCoordinatesNumbers(coordinates);
        }
        return false;
    }

    private boolean checkCoordinatesFormat(String coordinates) {
        if (coordinates.length() == 5) {
            return coordinates.charAt(0) == '('
                    && coordinates.charAt(2) == ','
                    && coordinates.charAt(4) == ')';
        }
        return false;
    }

    private boolean checkCoordinatesNumbers(String move) {
        return move.charAt(1) > '0' && move.charAt(1) < '6'
                && move.charAt(3) > '0' && move.charAt(3) < '6';
    }

    private void switchLights(int i, int j) {
        board[i][j].switchLight();
        if (i - 1 > 0)
            board[i - 1][j].switchLight();
        if (i + 1 < 5)
            board[i + 1][j].switchLight();
        if (j - 1 > 0)
            board[i][j - 1].switchLight();
        if (j + 1 < 5)
            board[i][j + 1].switchLight();
    }


    private int getCoordinate(String move) {
        return Integer.parseInt(move.substring(1, 2)) * 10 + Integer.parseInt(move.substring(3, 4)) - 11;
    }

    private void printBoard() {
        System.out.println("moves: " + moves);
        System.out.println("  12345");
        System.out.println("-------");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (j == 0) {
                    System.out.print(i + 1);
                } else if (j == 1) {
                    System.out.print("|");
                } else {
                    System.out.print(board[i][j - 2]);
                }
            }
            System.out.println();
        }
    }

    private boolean continueGame() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j].isStateOn()) {
                    return true;
                }
            }
        }
        return false;
    }

}

/*
  12345
-------
1|++0++
2|+0+0+
3|0+++0
4|+0+0+
5|++0++

 Create a Game class that container matrix of lights of 5x5.

 Create an initialize() method that will fill the matrix with the light
 having the above depicted state where + means that the light is 'on' and 0 is 'off'.

 To make the Game graphic more understandable fill the board with numbers, |s and -s.

 The Game class should have start method that start asking light position in a format '(x,y)'
 and will switch the light state located at (x,y), (x-1,y), (x+1,y), (x,y-1) and (x,y+1) coordinates.

 The game ends when all light are off.

 */

