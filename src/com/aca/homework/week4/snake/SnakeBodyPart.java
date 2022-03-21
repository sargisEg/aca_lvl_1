package com.aca.homework.week4.snake;

public class SnakeBodyPart {
    private static int snakeAllSize = 0;
    private int xOfPart;
    private int yOfPart;
    private int indexOfBodyPart;


    public SnakeBodyPart() {
        indexOfBodyPart = 0;
    }

    public static int getSnakeAllSize() {
        return snakeAllSize;
    }

    public static BoardPixel getPixelOfSnakeBodyPartByIndex(int index, BoardPixel[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].getSnakeBodyPart() != null)
                    if (board[i][j].getSnakeBodyPart().getIndexOfBodyPart() == index)
                        return board[i][j];
            }
        }
        throw new IllegalArgumentException("Not found index: " + index);
    }

    public int getIndexOfBodyPart() {
        return indexOfBodyPart;
    }

    public void setIndexOfBodyPart(int indexOfBodyPart) {
        this.indexOfBodyPart = indexOfBodyPart;
    }

    public void putSnakeHead() {
        snakeAllSize++;
        indexOfBodyPart = snakeAllSize;
    }


}
