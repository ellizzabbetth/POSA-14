package edu.vuum.mocca;
<<<<<<< HEAD

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;

/**
 * @class SimpleSemaphore
 *
 * @brief This class provides a simple counting semaphore
 *        implementation using Java a ReentrantLock and a
 *        ConditionObject.  It must implement both "Fair" and
 *        "NonFair" semaphore semantics, just liked Java Semaphores. 
 */
public class SimpleSemaphore {
    /**
     * Constructor initialize the data members.  
     * 
     * Semaphore can be initialized with constructors Semaphore(int permits) or 
     * Semaphore(int permits, boolean fair). Semaphore(int permits) creates a semaphore 
     * with given number of permits and unfair fairness setting and the other constructor 
     * creates a semaphore with given fairness setting. When fairness is set to true, 
     * the semaphore gives permits to access mutual resources in the order the threads 
     * have asked for it (FIFO) and when fairness is set false,
	 * semaphore can give permit to a thread asking for it before it gives permit to the
	 *  already waiting thread in the queue. To avoid starving the fairness should be set true.
     */
    public SimpleSemaphore (int permits, boolean fair)
    { 
        // TODO - you fill in here
    	 mPermits = permits;
         lock = new ReentrantLock(fair);
         isZero = lock.newCondition();
    }

    /**
     * Acquire one permit from the semaphore in a manner that can
     * be interrupted.
     */
    public void acquire() throws InterruptedException {
        // TODO - you fill in here
    	lock.lock();
        while (mPermits == 0)
            isZero.await();
        mPermits--;
        lock.unlock();
    }

    /**
     * Acquire one permit from the semaphore in a manner that
     * cannot be interrupted.
     */
    public void acquireUninterruptibly() {
        // TODO - you fill in here
    	lock.lock();
        while (mPermits == 0)
            try {
                isZero.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        mPermits--;
        lock.unlock();
    }

    /**
     * Return one permit to the semaphore.
     */
    void release() {
        // TODO - you fill in here
    	   lock.lock();
           try {
               mPermits++;
               isZero.signal();
           } finally {
               lock.unlock();
           }
    }
    
    /**
     * Return the number of permits available.
     */
    public int availablePermits(){
    	// TODO - you fill in here
    	return mPermits; // You will change this value. 
    }
    
    // ---------------------------
    // DATA MEMBERS 
    // There are two types of semaphores: Counting 
    // Semaphore and Binary Semaphore. 
    // Counting Semaphore can be used for mutual 
    // exclusion and conditional synchronization. 

    //Condition factors out the Object monitor methods (wait, notify and notifyAll) into distinct objects to give the effect of having multiple wait-sets per object, by combining them with the use of arbitrary Lock implementations. Where a Lock replaces the use of synchronized methods and statements, a Condition replaces the use of the Object monitor methods.
    // Conditions (also known as condition queues or condition variables) provide a means for one thread to suspend execution (to "wait") until notified by another thread that some state condition may now be true. Because access to this shared state information occurs in different threads, it must be protected, so a lock of some form is associated with the condition. The key property that waiting for a condition provides is that it atomically releases the associated lock and suspends the current thread, just like Object.wait.

    //A Condition instance is intrinsically bound to a lock. To obtain a Condition instance for a particular Lock instance use its newCondition() method.
    
    /**
     * Define a ReentrantLock to protect the critical section.
     */
    // TODO - you fill in here
    private ReentrantLock lock;

    /**
     * Define a ConditionObject to wait while the number of
     * permits is 0.
     */
    // TODO - you fill in here
    private Condition isZero;
    /**
     * Define a count of the number of available permits.
     */
    // TODO - you fill in here.  Make sure that this data member will
    // ensure its values aren't cached by multiple Threads..
    private int mPermits;
}

=======
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @class SimpleSemaphore
 * 
 * @brief This class provides a simple counting semaphore implementation using
 *        Java a ReentrantLock and a ConditionObject (which is accessed via a
 *        Condition). It must implement both "Fair" and "NonFair" semaphore
 *        semantics, just liked Java Semaphores.
 */
public class SimpleSemaphore {
    /**
     * Define a ReentrantLock to protect the critical section.
     */
    // TODO - you fill in here

    /**
     * Define a Condition that waits while the number of permits is 0.
     */
    // TODO - you fill in here

    /**
     * Define a count of the number of available permits.
     */
    // TODO - you fill in here. Make sure that this data member will
    // ensure its values aren't cached by multiple Threads..

    public SimpleSemaphore(int permits, boolean fair) {
        // TODO - you fill in here to initialize the SimpleSemaphore,
        // making sure to allow both fair and non-fair Semaphore
        // semantics.
    }

    /**
     * Acquire one permit from the semaphore in a manner that can be
     * interrupted.
     */
    public void acquire() throws InterruptedException {
        // TODO - you fill in here.
    }

    /**
     * Acquire one permit from the semaphore in a manner that cannot be
     * interrupted.
     */
    public void acquireUninterruptibly() {
        // TODO - you fill in here.
    }

    /**
     * Return one permit to the semaphore.
     */
    void release() {
        // TODO - you fill in here.
    }

    /**
     * Return the number of permits available.
     */
    public int availablePermits() {
        // TODO - you fill in here to return the correct result
    	return 0;
    }
}
>>>>>>> refs/remotes/upstream/master
