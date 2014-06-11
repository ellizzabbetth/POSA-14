package edu.vuum.mocca;
// Import the necessary Java synchronization and scheduling classes.


import java.util.concurrent.CountDownLatch;

/**
 * @class PingPongRight
 *
 * @brief This class implements a Java program that creates two
 *        instances of the PlayPingPongThread and start these thread
 *        instances to correctly alternate printing "Ping" and "Pong",
 *        respectively, on the console display.
 */
public class PingPongRight {
    /**
     * Number of iterations to run the test program.
     */
    public static int mMaxIterations = 10;
    
    /**
     * Latch that will be decremented each time a thread exits.
     */
    public static CountDownLatch mLatch = new CountDownLatch(2); // TODO - You fill in here

    /**
     * @class PlayPingPongThread
     *
     * @brief This class implements the ping/pong processing algorithm
     *         using the SimpleSemaphore to alternate printing "ping"
     *         and "pong" to the console display.
     */
    public static class PlayPingPongThread extends Thread
    {
    	  /**
         * Constants to distinguish between ping and pong
         * SimpleSemaphores, if you choose to use an array of
         * SimpleSemaphores.  If you don't use this implementation
         * feel free to remove these constants.
         */
        private final static int FIRST_SEMA = 0;
        private final static int SECOND_SEMA = 1;

        /**
         * Maximum number of loop iterations.
         */
        private int mMaxLoopIterations = 10;

        /**
         * String to print (either "ping!" or "pong"!) for each
         * iteration.
         */
        // TODO - You fill in here.
    	private String mStringToPrint;

        /**
         * Two SimpleSemaphores use to alternate pings and pongs.  You
         * can use an array of SimpleSemaphores or just define them as
         * two data members.
         */
        // TODO - You fill in here
    	private SimpleSemaphore mSemas[] = new SimpleSemaphore[2];
    	
    	
        /**
         * Constructor initializes the data member.
         */
        public PlayPingPongThread (String stringToPrint, SimpleSemaphore semaphoreOne, SimpleSemaphore semaphoreTwo, int maxIterations)
        {
            // TODO - You fill in here.
           // super(stringToPrint);
        	mStringToPrint = stringToPrint;
        	mSemas[FIRST_SEMA] = semaphoreOne;
        	mSemas[SECOND_SEMA] = semaphoreTwo;
        	mMaxLoopIterations = maxIterations;
        }

        /**
         * Main event loop that runs in a separate thread of control
         * and performs the ping/pong algorithm using the
         * SimpleSemaphores.
         */
        public void run () 
        {
            /* TODO - You fill in here.*/
        	 
              
              for (int loopsDone = 1;
                      loopsDone <= mMaxIterations;
                      ++loopsDone) {
                     // Perform the template method protocol for printing a
                     // "ping" or a "pong" on the display.  Note that the
                     // acquire() and release() hook methods that control
                     // the scheduling of the threads are deferred to
                     // subclasses.

                     acquire();

                     System.out.println
                         (mStringToPrint + "(" + loopsDone + ")");

                     release();
                 }

                 // Indicate that this thread is done playing ping/pong.
                 mLatch.countDown();

                 // Exit the thread when the loop is done.
                 
        }

        /**
         * Method for acquiring the appropriate SimpleSemaphore.
         * The counting semaphore is initialized with a given number of "permits". 
         * For each call to acquire() a permit is taken by the calling thread. 
         * For each call to release() a permit is returned to the semaphore. Thus, at most N threads can pass the acquire() method without any release() calls, where N is the number of permits the semaphore was initialized with. The permits are just a simple counter. Nothing fancy here.
         */
        private void acquire() {
            // TODO fill in here
        	mSemas[FIRST_SEMA].acquireUninterruptibly();
        }

        /**
         * Method for releasing the appropriate SimpleSemaphore.
         */
        private void release() {
            // TODO fill in here
        	mSemas[SECOND_SEMA].release();
        }
    }

    /**
     * The method that actually runs the ping/pong program.
     */
    public static void process(String startString, 
                               String pingString,
                               String pongString, 
                               String finishString, 
                               int maxIterations) throws InterruptedException {

        // TODO initialize this by replacing null with the appropriate
        // constructor call.
    	mLatch = new CountDownLatch(2);
    	
    	
            // Create the ping and pong SimpleSemaphores that control
            // alternation between threads.

            // TODO - You fill in here.
        	SimpleSemaphore pingSema = new SimpleSemaphore(1, true);
        	SimpleSemaphore pongSema = new SimpleSemaphore(0, true);
        	

            System.out.println(startString);

            // Create the ping and pong threads, passing in the string
            // to print and the appropriate SimpleSemaphores.
            PlayPingPongThread ping =
                new PlayPingPongThread(pingString, pingSema, pongSema, maxIterations);
            PlayPingPongThread pong =
                new PlayPingPongThread(pongString, pongSema, pingSema, maxIterations/* TODO - You fill in here */);
            
            // Initiate the ping and pong threads, which will call the
            // run() hook method.
            ping.start();
            pong.start();

            // Use barrier synchronization to wait for both threads to
            // finish.
            mLatch.await();
            
            // TODO - replace replace the following line with a
            // CountDownLatch barrier synchronizer call that waits for
            // both threads to finish.
            //throw new java.lang.InterruptedException();
            
            System.out.println(finishString);
        } 
    
    /**
     * The main() entry point method into PingPongRight program.
     * 
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        process("Ready...Set...Go!", 
                "Ping!  ",
                " Pong! ",
                "Done!",
                mMaxIterations);
    }
    
    
}
