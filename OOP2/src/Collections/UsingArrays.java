package Collections;

import java.util.Arrays;

public class UsingArrays {
    private final int[] intArray = {1,5,6,7};
    private int[] filledIntArray, intArrayCopy;

    private void fillArray(){
        filledIntArray = new int[10];
        Arrays.fill(filledIntArray,5);
    }

    private void copyArray(){
        intArrayCopy = new int[intArray.length];
        System.arraycopy(intArray,0,intArrayCopy,0,intArray.length);
    }

    private void printArrays(){
        System.out.println("Filled Array: ");
        for(int e: filledIntArray)
            System.out.print(e + " ");
        System.out.println("\nCopied Array: ");
        for(int e: intArrayCopy)
            System.out.print(e + " ");
    }

    public static void main(String[] args) {
        UsingArrays usingArrays = new UsingArrays();
        usingArrays.fillArray();
        usingArrays.copyArray();
        usingArrays.printArrays();
    }
}
