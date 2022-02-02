package com.aca.homework.week4.snake;

public class BoardPixel {
    private int x;
    private int y;
    private char symbol;
    private SnakeBodyPart snakeBodyPart;


    public BoardPixel(int x, int y) {
        this.x = x;
        this.y = y;
        symbol = '0';
    }

    public void putSnakeHead() {
        snakeBodyPart = new SnakeBodyPart();
        snakeBodyPart.putSnakeHead();
        this.putBody();
    }

    public char getSymbol() {
        return symbol;
    }

    public void makeBody() {
        this.snakeBodyPart = new SnakeBodyPart();
        this.putBody();
    }

    private void putBody() {
        this.symbol = '*';
    }

    public void putApple() {
        this.symbol = '=';
    }

    public void putEmpty() {
        this.symbol = '0';
        this.snakeBodyPart = null;
    }

    public SnakeBodyPart getSnakeBodyPart() {
        return snakeBodyPart;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
