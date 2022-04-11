package Collections;

import java.util.*;

public class ListTest {
    private static final String[] colors = {"black", "blue", "red", "green"};
    List<String> list;
    private String[] newColors;

    public void makeList(){
        list = new LinkedList<>(Arrays.asList(colors));
    }

    public void printList(){
        System.out.println();
        for(String e: list)
            System.out.print(e+" ");
    }

    public void makeUpperCase(){
        ListIterator<String> iterator = list.listIterator();

        while(iterator.hasNext()){
            String s = iterator.next();
            iterator.set(s.toUpperCase());
        }
    }

    public void printReverse(){
        ListIterator<String> iterator = list.listIterator(list.size());
        System.out.println();
        while(iterator.hasPrevious()){
            System.out.print(iterator.previous()+" ");
        }
    }

    public void setNewColors(){
        newColors = list.toArray(new String[list.size()]);
    }

    public void printNewColors(){
        System.out.println();
        for(String s: newColors)
            System.out.print(s+" ");
    }

    public void sort(){
        Collections.sort(list);
    }

    public void sortLengthWise(){
        Collections.sort(list, new LengthComparator());
    }

    public static void main(String[] args) {
        ListTest listTest = new ListTest();
        listTest.makeList();
        listTest.printList();
        listTest.makeUpperCase();
        listTest.printReverse();
        listTest.setNewColors();
        listTest.printNewColors();
        listTest.sort();
        listTest.printList();
        listTest.sortLengthWise();
        listTest.printList();
    }

}
