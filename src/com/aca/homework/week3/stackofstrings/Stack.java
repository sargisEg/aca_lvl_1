package com.aca.homework.week3.stackofstrings;

public class Stack {
    private String[] stringStack;

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.printStack();
        stack.push("main");
        stack.push("push");
        stack.push("push");
        stack.push("push");
        stack.printStack();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.printStack();

    }

    public Stack(){
        this.stringStack = new String[10];
    }

    public void push(String pushString){
        if(stringStack[9] != null) throw new ArrayIndexOutOfBoundsException("Stack is full");
        for (int i = 0; i < stringStack.length; i++) {
            if(stringStack[i] == null){
                stringStack[i] = pushString;
                System.out.println("<" + stringStack[i] + "> is pushed");
                break;
            }
        }
    }

    public void pop(){
        if(stringStack[9] != null) throw new ArrayIndexOutOfBoundsException("Stack is empty");
        for (int i = 0; i < stringStack.length; i++) {
            if(stringStack[i] == null){
                System.out.println("<" + stringStack[i-1] + "> is popped");
                stringStack[i-1] = null;
                break;
            }
        }
    }

    public void printStack(){
        if (stringStack[0] != null) {
            System.out.print("< ");
            for (int i = 0; i < stringStack.length; i++) {
                if (stringStack[i] != null)
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
