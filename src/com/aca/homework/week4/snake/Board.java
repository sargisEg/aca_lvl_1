package com.aca.homework.week4.snake;


import java.util.Random;
import java.util.Scanner;

public class Board {

    public static void main(String[] args) {
        Snake[][] board = new Snake[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Snake(i, j);
            }
        }

        board[0][0].setSnakeHead();
        board[2][1].setApple();

        print(board);

        char move;
        Scanner scanner = new Scanner(System.in);
        System.out.println("please choose the direction");
        move = scanner.next().charAt(0);

        while (true) {
            if (move == 'd') {
                int xHead = Snake.getBySize(Snake.getSnakeSize(), board).getX();
                int yHead = Snake.getBySize(Snake.getSnakeSize(), board).getY() + 1;  // snake head cooridinates after move
                Board.move(board,xHead,yHead); // moving snake
                print(board);
            } else if (move == 'a') {
                int xHead = Snake.getBySize(Snake.getSnakeSize(), board).getX();
                int yHead = Snake.getBySize(Snake.getSnakeSize(), board).getY() - 1;
                Board.move(board,xHead,yHead);
                print(board);
            } else if (move == 'w') {
                int xHead = Snake.getBySize(Snake.getSnakeSize(), board).getX() - 1;
                int yHead = Snake.getBySize(Snake.getSnakeSize(), board).getY();
                Board.move(board,xHead,yHead);
                print(board);
            } else if (move == 's') {
                int xHead = Snake.getBySize(Snake.getSnakeSize(), board).getX() + 1;
                int yHead = Snake.getBySize(Snake.getSnakeSize(), board).getY();
                Board.move(board,xHead,yHead);
                print(board);
            }
            System.out.println("please choose the direction");
            move = scanner.next().charAt(0);
        }
    }

    public static void move(Snake[][] board, int xHead, int yHead){

        if(xHead > 7 || xHead < 0 || yHead > 7 || yHead < 0)
            System.out.println("cannot move");
        else if (board[xHead][yHead].getSymbol() == '=') {  // apple eating
            board[xHead][yHead].setSnakeHead();
            newApple(board);
        }else if(board[xHead][yHead].getSymbol() == '*') {
            System.out.println("cannot move");
        }else {

            Snake.getBySize(1, board).setEmpty(); // snake tail setting

            for (int i = 1; i <= Snake.getSnakeSize(); i++) { //snake body switching
                Snake.getBySize(i, board).setSize(i - 1);
            }

            board[xHead][yHead].setBody();             // snake head setting
            board[xHead][yHead].setSize(Snake.getSnakeSize());
        }
    }

    public static void print(Snake[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j].getSymbol());
            }
            System.out.println();
        }
    }

    public static void newApple(Snake[][] board){
        int appleX;
        int appleY;
        do{
            appleX = (new Random()).nextInt(8);
            appleY = (new Random()).nextInt(8);

        }while (board[appleX][appleY].getSymbol() == '*');
        board[appleX][appleY].setApple();
    }
}

/*

Given an 8x8 matrix filled by 0s,
 a small point snake located at (0x0) position, and an apple at (2,1).
Every time the program prints the snake board and asks a user to enter a snake movement direction.
The entered w symbol means up, s down, left, and d right.
When the snake eats the apple, its size increases from the tail, and a new apple appears in a random free position.
* */