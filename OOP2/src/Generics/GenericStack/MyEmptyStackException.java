package Generics.GenericStack;

public class MyEmptyStackException extends RuntimeException{
    public MyEmptyStackException(){
        this("Generics.GenericStack.Stack is empty");
    }

    public MyEmptyStackException(String exception){
        super(exception);
    }
}
