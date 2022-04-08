package Generics.GenericStack;

import java.util.EmptyStackException;

public class StackTest {
    private double[] doubleElements = {1.1,2.2,3.3,4.4,5.5,6.6};
    private int[] integerElements = {1,2,3,4,5,6,7,8,9,10,11};

    private Stack<Double> doubleStack;
    private Stack<Integer> integerStack;

    public void testStacks(){
        doubleStack = new Stack<Double>(5);
        integerStack = new Stack<Integer>(10);

        testPushDouble();
        testPopDouble();
        testPushInteger();
        testPopInteger();
    }

    public void testPushDouble(){
        try{
            System.out.println("\nPushing elements into double stack");
            for(double elements: doubleElements){
                System.out.printf("%.1f ", elements);
                doubleStack.push(elements);
            }
        }catch (FullStackException fullStackException){
            System.err.println();
            fullStackException.printStackTrace();
        }
    }

    public void testPopDouble(){
        try{
            System.out.println("\nPopping elements into double stack");
            double popValue;
            while(true){
                popValue = doubleStack.pop();
                System.out.printf(".1f ", popValue);
            }
        }catch (EmptyStackException emptyStackException){
            System.err.println();
            emptyStackException.printStackTrace();
        }
    }

    public void testPushInteger(){
        try{
            System.out.println("\nPushing elements into integer stack");
            for(int elements: integerElements){
                System.out.printf("%.1f ", elements);
                integerStack.push(elements);
            }
        }catch (FullStackException fullStackException){
            System.err.println();
            fullStackException.printStackTrace();
        }
    }

    public void testPopInteger(){
        try{
            System.out.println("\nPopping elements from integer stack");
            int popValue;
            while(true){
                popValue = integerStack.pop();
                System.out.printf("%d ", popValue);
            }
        }catch (EmptyStackException emptyStackException){
            System.err.println();
            emptyStackException.printStackTrace();
        }
    }

    // main
    public static void main(String[] args) {
        StackTest application = new StackTest();
        application.testStacks();
    }
}
