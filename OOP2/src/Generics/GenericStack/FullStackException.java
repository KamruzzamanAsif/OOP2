package Generics.GenericStack;

public class FullStackException extends RuntimeException{
    public FullStackException(){
        this("Generics.GenericStack.Stack is full");
    }

    public FullStackException(String exception){
        super(exception);
    }
}
