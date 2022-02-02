package com.aca.homework.week4.snake;

import java.util.Random;
import java.util.Scanner;

public class Board {
    private BoardPixel[][] board;

    public Board() {
        this.board = new BoardPixel[8][8];
    }

    public static void main(String[] args) {
        Board board = new Board();

        board.makeBoardAndPrint();
        board.startSnakeGame();
    }

    public void move(int xHead, int yHead) {

        char apple = '=';

        if (moveCheck(xHead, yHead))
            System.out.println("cannot move");
        else if (board[xHead][yHead].getSymbol() == apple) {
            board[xHead][yHead].putSnakeHead();
            putNewAppleInBoard();
        } else {
            SnakeBodyPart.getPixelOfSnakeBodyPartByIndex(1, board).putEmpty(); // snake tail setting

            for (int i = 1; i <= SnakeBodyPart.getSnakeAllSize(); i++) { //snake body switching
                if (i != 1)
                    SnakeBodyPart.getPixelOfSnakeBodyPartByIndex(i, board).getSnakeBodyPart().setIndexOfBodyPart(i - 1);
            }

            board[xHead][yHead].makeBody();             // snake head setting
            board[xHead][yHead].getSnakeBodyPart().setIndexOfBodyPart(SnakeBodyPart.getSnakeAllSize());
        }
    }

    public boolean moveCheck(int xHead, int yHead) {
        return ((xHead > 7 || xHead < 0 || yHead > 7 || yHead < 0)
                || (board[xHead][yHead].getSymbol() == '*'));
    }


    public int getXOfSnakeHead() {
        return SnakeBodyPart.getPixelOfSnakeBodyPartByIndex(SnakeBodyPart.getSnakeAllSize(), board).getX();
    }

    public int getYOfSnakeHead() {
        return SnakeBodyPart.getPixelOfSnakeBodyPartByIndex(SnakeBodyPart.getSnakeAllSize(), board).getY();
    }

    public void moveRightAndPrint() {
        int xHead = getXOfSnakeHead();
        int yHead = getYOfSnakeHead() + 1;
        move(xHead, yHead);
        printBoard();
    }

    public void moveLeftAndPrint() {
        int xHead = getXOfSnakeHead();
        int yHead = getYOfSnakeHead() - 1;
        move(xHead, yHead);
        printBoard();
    }

    public void moveDownAndPrint() {
        int xHead = getXOfSnakeHead() + 1;
        int yHead = getYOfSnakeHead();
        move(xHead, yHead);
        printBoard();
    }

    public void moveUpAndPrint() {
        int xHead = getXOfSnakeHead() - 1;
        int yHead = getYOfSnakeHead();
        move(xHead, yHead);
        printBoard();
    }

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j].getSymbol());
            }
            System.out.println();
        }
    }

    public void putNewAppleInBoard() {
        int appleX;
        int appleY;
        do {
            appleX = (new Random()).nextInt(8);
            appleY = (new Random()).nextInt(8);

        } while (board[appleX][appleY].getSymbol() == '*');
        board[appleX][appleY].putApple();
    }

    public BoardPixel[][] getBoard() {
        return board;
    }

    public void startSnakeGame() {

        char right = 'd';
        char left = 'a';
        char up = 'w';
        char down = 's';

        Scanner scanner = new Scanner(System.in);
        System.out.println("please choose the direction");
        char move = scanner.next().charAt(0);

        while (true) {
            if (move == left) {
                moveLeftAndPrint();
            } else if (move == right) {
                moveRightAndPrint();
            } else if (move == up) {
                moveUpAndPrint();
            } else if (move == down) {
                moveDownAndPrint();
            }
            System.out.println("please choose the direction");
            move = scanner.next().charAt(0);
        }
    }

    public void makeBoardAndPrint() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new BoardPixel(i, j);
            }
        }

        board[0][0].putSnakeHead();
        board[2][1].putApple();

        printBoard();
    }
}

/*

Given an 8x8 matrix filled by 0s,
 a small point snake located at (0x0) position, and an apple at (2,1).
Every time the program prints the snake board and asks a user to enter a snake movement direction.
The entered w symbol means up, s down, left, and d right.
When the snake eats the apple, its size increases from the tail, and a new apple appears in a random free position.
* */
