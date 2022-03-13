package GenericStack;

public class MyEmptyStackException extends RuntimeException{
    public MyEmptyStackException(){
        this("GenericStack.Stack is empty");
    }

    public MyEmptyStackException(String exception){
        super(exception);
    }
}
