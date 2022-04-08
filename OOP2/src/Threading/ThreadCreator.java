package Threading;

public class ThreadCreator {
    public static void main(String[] args) {
        System.out.printf("Creating threads.\n");

        Thread thread1 = new Thread(new PrintTask("task1"));
        Thread thread2 = new Thread(new PrintTask("task2"));
        Thread thread3 = new Thread(new PrintTask("task3"));

        /* way no. 2 to create thread */
//        new PrintTask("task1");
//        new PrintTask("task2");
//        new PrintTask("task3");

        System.out.printf("Threads created, starting tasks.\n");

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.printf("Tasks started, main ends.\n");
    }
}
