package Threading.Unsynchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest {
    public static void main(String[] args) {
        SimpleArray sharedSimpleArray = new SimpleArray(6);

        ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
        ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(writer1);
        executor.execute(writer2);
        executor.shutdown();

        try{
            boolean taskEnded = executor.awaitTermination(1, TimeUnit.MINUTES);
            if(taskEnded)
                System.out.println(sharedSimpleArray);
            else
                System.out.printf("Time out while waiting for task to finish.\n");
        }catch (InterruptedException ex){
            System.out.println("Interrupted while wait for tasks to finish.");
        }
    }
}
