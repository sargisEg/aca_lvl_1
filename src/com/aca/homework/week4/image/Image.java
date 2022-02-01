package com.aca.homework.week4.image;

public class Image {
    private int imageX;
    private int imageY;
    private char[][] image;


    public static void main(String[] args) {
        Image image = new Image(5,10);

        image.show();

        image.draw(0,1);
        image.draw(0,2);
        image.draw(0,3);
        image.draw(1,4);
        image.draw(4,8);
        image.draw(3,3);

        image.show();

    }

    public Image(int X, int Y){
        imageX = X;
        imageY = Y;
        image = new char[Y][X];

        for (int i = 0; i < imageY; i++) {
            for (int j = 0; j < imageX; j++) {
                image[i][j] = '-';
            }
        }
    }

    public void show(){
        for (int i = 0; i < imageY; i++) {
            for (int j = 0; j < imageX; j++) {
                System.out.print(image[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void draw(int x, int y){
        image[y][x] = '*';
    }
}
