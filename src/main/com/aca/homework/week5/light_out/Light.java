package com.aca.homework.week5.light_out;


public class Light {
    private boolean state;

    private Light(boolean state) {
        this.state = state;
    }

    public static Light ofOn() {
        return new Light(true);
    }

    public static Light ofOff() {
        return new Light(false);
    }

    public boolean isStateOn() {
        return state;
    }

    public void switchLight() {
        this.state = !this.state;
    }

    @Override
    public String toString() {
        if (this.state) {
            return "+";
        } else {
            return "0";
        }
    }
}

/*
 * Create a Light class that can be either in 'on' or 'off' state.
 *Create a Game class that container matrix of lights of 5x5.
 *Create an initialzie() method that will fill the matrix with the light having the above depicted state where + means that the light is 'on' and 0 is 'off'.
 *To make the Game graphic more understandable fill the board with numbers, |s and -s.
 *The Game class should have start method that start asking light position in a format '(x,y)' and will switch the light state located at (x,y), (x-1,y), (x+1,y), (x,y-1) and (x,y+1) coordinates.
 *The game ends when all light are off.
 *for instance to win the game user should input the following strings
 *(3,3)
 *(1,1)
 *(5,5)
 *(5,1)
 *(1,5)
 *After each user input the moves count and the updated game graphic should be printed.
 */

