package Threading;

// Fig. 23.16: BlockingBuffer.java
2 // Creates a synchronized buffer using an ArrayBlockingQueue.
        3 import java.util.concurrent.ArrayBlockingQueue;
4
        5 public class BlockingBuffer implements Buffer
6 {
        7 private final ArrayBlockingQueue&lt;Integer&gt; buffer; // shared buffer
        8
        9 public BlockingBuffer()
        10 {
        11 buffer = new ArrayBlockingQueue&lt;Integer&gt;( 1 );
        12 } // end BlockingBuffer constructor
        13
        14 // place value into buffer
        15 public void set( int value ) throws InterruptedException
        16 {
        17 buffer.put( value ); // place value in buffer
        18 System.out.printf( &quot;%s%2d\t%s%d\n&quot;, &quot;Producer writes &quot;, value,
        19 &quot;Buffer cells occupied: &quot;, buffer.size() );
        20 } // end method set

// return value from buffer
        23 public int get() throws InterruptedException
        24 {
        25 int readValue = 0; // initialize value read from buffer
        26
        27 readValue = buffer.take(); // remove value from buffer
        28 System.out.printf( &quot;%s %2d\t%s%d\n&quot;, &quot;Consumer reads &quot;,
        29 readValue, &quot;Buffer cells occupied: &quot;, buffer.size() );
        30
        31 return readValue;
        32 } // end method get
        33 } // end class BlockingBuffer


