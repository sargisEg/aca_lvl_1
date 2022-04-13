package com.aca.homework.week3.stackofstrings;

public class Stack {
    private String[] stringStack;
    private int index;

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.printStack();
        stack.push("main");
        stack.push("push");
        stack.push("push");
        stack.push("push");
        stack.printStack();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.printStack();

    }

    public Stack(){
        this.stringStack = new String[10];
        index = 0;
    }

    public void push(String pushString){
        if(index == 10) throw new ArrayIndexOutOfBoundsException("Stack is full");
        stringStack[index] = pushString;
        System.out.println("<" + stringStack[index] + "> is pushed");
        index++;
    }

    public String pop(){
        String poppedString;
        if(index == 0) throw new ArrayIndexOutOfBoundsException("Stack is empty");
        index--;
        poppedString = stringStack[index];
        stringStack[index] = null;
        return poppedString;

    }

    public void printStack(){
        if (index != 0) {
            System.out.print("< ");
            for (int i = 0; i < index; i++) {
                System.out.print(stringStack[i] + " ");
            }
            System.out.println(" >");
        }else System.out.println("Stack is empty");
    }
}

/*
Create a Stack class that has push and pop methods.
The user should be able to push a string value on top of the stack and pop out of the stack.
The Stack can take up to 10 string values.
push "main", "push", "push", "push" and pop  4 times and print the popped values.
note: all variables of The Stack class must be private.
*/
