package GenericStack;

public class FullStackException extends RuntimeException{
    public FullStackException(){
        this("GenericStack.Stack is full");
    }

    public FullStackException(String exception){
        super(exception);
    }
}
