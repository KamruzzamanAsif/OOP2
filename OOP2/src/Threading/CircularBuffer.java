package Threading;

public class CircularBuffer implements Buffer
4 {
        5 private final int[] buffer = { -1, -1, -1 }; // shared buffer
        6
        7 private int occupiedCells = 0; // count number of buffers used
        8 private int writeIndex = 0; // index of next element to write to
        9 private int readIndex = 0; // index of next element to read
        10
        11 // place value into buffer
        12 public synchronized void set( int value ) throws InterruptedException
        13 {
        14 // output thread information and buffer information, then wait;
        15 // while no empty locations, place thread in blocked state
        16 while ( occupiedCells == buffer.length )
        17 {
        18 System.out.printf( &quot;Buffer is full. Producer waits.\n&quot; );
        19 wait(); // wait until a buffer cell is free
        20 } // end while
        21
        22 buffer[ writeIndex ] = value; // set new buffer value
        23
        24 // update circular write index
        25 writeIndex = ( writeIndex + 1 ) % buffer.length;
        26
        27 ++occupiedCells; // one more buffer cell is full
        28 displayState( &quot;Producer writes &quot; + value );
        29 notifyAll(); // notify threads waiting to read from buffer
        30 } // end method set

// return value from buffer
        33 public synchronized int get() throws InterruptedException
        34 {
        35 // wait until buffer has data, then read value;
        36 // while no data to read, place thread in waiting state
        37 while ( occupiedCells == 0 )
        38 {
        39 System.out.printf( &quot;Buffer is empty. Consumer waits.\n&quot; );
        40 wait(); // wait until a buffer cell is filled
        41 } // end while
        42
        43 int readValue = buffer[ readIndex ]; // read value from buffer
        44
        45 // update circular read index
        46 readIndex = ( readIndex + 1 ) % buffer.length;
        47
        48 --occupiedCells; // one fewer buffer cells are occupied
        49 displayState( &quot;Consumer reads &quot; + readValue );
        50 notifyAll(); // notify threads waiting to write to buffer
        51
        52 return readValue;
        53 } // end method get
        54
        55 // display current operation and buffer state
        56 public void displayState( String operation )
        57 {
        58 // output operation and number of occupied buffer cells
        59 System.out.printf( &quot;%s%s%d)\n%s&quot;, operation,
        60 &quot; (buffer cells occupied: &quot;, occupiedCells, &quot;buffer cells: &quot; );

        for ( int value : buffer )
        63 System.out.printf( &quot; %2d &quot;, value ); // output values in buffer
        64
        65 System.out.print( &quot;\n &quot; );
        66
        67 for ( int i = 0; i &lt; buffer.length; i++ )
        68 System.out.print( &quot;---- &quot; );
        69
        70 System.out.print( &quot;\n &quot; );
        71
        72 for ( int i = 0; i &lt; buffer.length; i++ )
        73 {
        74 if ( i == writeIndex &amp;&amp; i == readIndex )
        75 System.out.print( &quot; WR&quot; ); // both write and read index
        76 else if ( i == writeIndex )
        77 System.out.print( &quot; W &quot; ); // just write index
        78 else if ( i == readIndex )
        79 System.out.print( &quot; R &quot; ); // just read index
        80 else
        81 System.out.print( &quot; &quot; ); // neither index
        82 } // end for
        83
        84 System.out.println( &quot;\n&quot; );
        85 } // end method displayState
        86 } // end class CircularBuffer


