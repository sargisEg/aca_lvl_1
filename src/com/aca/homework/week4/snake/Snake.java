package com.aca.homework.week4.snake;

public class Snake {
    private static int snakeSize;
    private int x;
    private int y;
    private char symbol;
    private int size;


    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
        symbol = '0';
        size = 0;
        snakeSize = 0;
    }

    public static Snake getBySize(int size, Snake[][] snake) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (snake[i][j].size == size)
                    return snake[i][j];
            }
        }
        throw new IllegalArgumentException("Not found size: " + size);
    }

    public static int getSnakeSize() {
        return snakeSize;
    }

    public void setSnakeHead() {
            snakeSize++;
            size = snakeSize;
            this.setBody();
    }

    public char getSymbol() {
        return symbol;
    }
    public void setBody(){
        this.symbol = '*';
    }
    public void setApple(){
        this.symbol = '=';
    }

    public void setEmpty(){
        this.symbol = '0';
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
