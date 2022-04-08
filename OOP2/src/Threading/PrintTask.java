package Threading;

import java.util.Random;

public class PrintTask implements Runnable{
    private final int sleepTime;
    private final String taskName;
    private final static Random generator = new Random();
    Thread t;

    public PrintTask(String name){
        taskName = name;
        sleepTime = generator.nextInt(5000);

        /* way no. 2 to create thread
        *  tar mane eitar akta object create korlei
        *  eita akta thread a chole jabe */

//        t = new Thread(this);
//        t.start();
    }

    public void run(){
        try{
            System.out.printf("%s is going to sleep for %d milliseconds.\n", taskName, sleepTime);
            Thread.sleep(sleepTime);
        }catch (InterruptedException exception){
            System.out.printf("%s %s\n", taskName, "terminated permanently due to interruption");
        }

        System.out.printf("%s done sleeping\n", taskName);
    }
}
