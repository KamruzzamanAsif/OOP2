package Threading;

public class SynchronizedWithLocking {
    // Lock to control synchronization with this buffer
11 private final Lock accessLock = new ReentrantLock();
12
        13 // conditions to control reading and writing
        14 private final Condition canWrite = accessLock.newCondition();
15 private final Condition canRead = accessLock.newCondition();
16
        17 private int buffer = -1; // shared by producer and consumer threads
18 private boolean occupied = false; // whether buffer is occupied
19
        20 // place int value into buffer
        21 public void set( int value ) throws InterruptedException
22 {
        23 accessLock.lock(); // lock this object
        24
        25 // output thread information and buffer information, then wait
        26 try
        27 {
            // while buffer is not empty, place thread in waiting state
            29 while ( occupied )
                30 {
                31 System.out.println( &quot;Producer tries to write.&quot; );
                32 displayState( &quot;Buffer full. Producer waits.&quot; );
                33 canWrite.await(); // wait until buffer is empty
                34 } // end while
            35
            36 buffer = value; // set new buffer value
            37
            38 // indicate producer cannot store another value
            39 // until consumer retrieves current buffer value
            40 occupied = true;
            41
            42 displayState( &quot;Producer writes &quot; + buffer );
            43
            44 // signal thread waiting to read from buffer
            45 canRead.signal();
            46 } // end try
        47 finally
        48 {
            49 accessLock.unlock(); // unlock this object
            50 } // end finally
        51 } // end method set


    // return value from buffer
54 public int get() throws InterruptedException
55 {
        56 int readValue = 0; // initialize value read from buffer
        57 accessLock.lock(); // lock this object
        58
        59 // output thread information and buffer information, then wait
        60 try
        61 {
            62 // while no data to read, place thread in waiting state
            63 while ( !occupied )
                64 {
                65 System.out.println( &quot;Consumer tries to read.&quot; );
                66 displayState( &quot;Buffer empty. Consumer waits.&quot; );
                67 canRead.await(); // wait until buffer is full
                68 } // end while
            69
            70 // indicate that producer can store another value
            71 // because consumer just retrieved buffer value
            72 occupied = false;
            73
            74 readValue = buffer; // retrieve value from buffer
            75 displayState( &quot;Consumer reads &quot; + readValue );
            76
            77 // signal thread waiting for buffer to be empty
            78 canWrite.signal();
            79 } // end try

        finally
        81 {
            82 accessLock.unlock(); // unlock this object
            83 } // end finally
        84
        85 return readValue;
        86 } // end method get
87
        88 // display current operation and buffer state
        89 public void displayState( String operation )
90 {
        91 System.out.printf( &quot;%-40s%d\t\t%b\n\n&quot;, operation, buffer,
                92 occupied );
        93 } // end method displayState
94 } // end class SynchronizedBuffer
}
