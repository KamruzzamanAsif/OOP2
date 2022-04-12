package Threading;

// Fig. 23.18: SynchronizedBuffer.java
// methods wait and notify.
public class SynchronizedBuffer implements Buffer
{
        private int buffer = -1; // shared by producer and consumer threads
        private boolean occupied = false; // whether the buffer is occupied
         // place value into buffer
        public synchronized void set( int value )
        {
        // while there are no empty locations, place thread in waiting state
        while ( occupied )
        {
        // output thread information and buffer information, then wait
        System.out.println( &quot;Producer tries to write.&quot; );
        displayState( &quot;Buffer full. Producer waits.&quot; );
        wait();
        } // end while

         buffer = value; // set new buffer value

         // indicate producer cannot store another value
         // until consumer retrieves current buffer value
         occupied = true;

        displayState( &quot;Producer writes &quot; + buffer );

        notifyAll(); // tell waiting thread(s) to enter runnable state
         } // end method set; releases lock on SynchronizedBuffer

// return value from buffer
 public synchronized int get()
{
     // while no data to read, place thread in waiting state
     while ( !occupied )
         {
        // output thread information and buffer information, then wait
        System.out.println( &quot;Consumer tries to read.&quot; );
         displayState( &quot;Buffer empty. Consumer waits.&quot; );
         wait();
         } // end while

// indicate that producer can store another value
     // because consumer just retrieved buffer value
     occupied = false;

    displayState( &quot;Consumer reads &quot; + buffer );

    notifyAll(); // tell waiting thread(s) to enter runnable state

     return buffer;
    } // end method get; releases lock on SynchronizedBuffer

         // display current operation and buffer state
         public void displayState( String operation )
{
     System.out.printf( &quot;%-40s%d\t\t%b\n\n&quot;, operation, buffer,
             occupied );
    } // end method displayState
} // end class SynchronizedBuffer
