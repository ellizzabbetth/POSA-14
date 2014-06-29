package edu.vuum.mocca;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

/**
 * @class SimpleAtomicLong
 *
 * @brief This class implements a subset of the
 *        java.util.concurrent.atomic.SimpleAtomicLong class using a
 *        ReentrantReadWriteLock to illustrate how they work.
 */
class SimpleAtomicLong
{
    /**
     * The value that's manipulated atomically via the methods.
     */
    private long mValue;


    /**
     * The ReentrantReadWriteLock used to serialize access to mValue.
     */
<<<<<<< HEAD

    // TODO -- you fill in here by replacing the null with an
    // initialization of ReentrantReadWriteLock.
    private ReentrantReadWriteLock mRWLock = new ReentrantReadWriteLock();
=======
    // TODO - add the implementation
>>>>>>> refs/remotes/upstream/master

    /**
     * Creates a new SimpleAtomicLong with the given initial value.
     */
<<<<<<< HEAD
    public SimpleAtomicLong(long initialValue)
    {
        // TODO -- you fill in here
    	mValue = initialValue;
=======
    public SimpleAtomicLong(long initialValue) {
        // TODO - you fill in here
>>>>>>> refs/remotes/upstream/master
    }

    /**
     * @brief Gets the current value
     * 
     * @returns The current value
     */
<<<<<<< HEAD
    public synchronized long get()
    {
        // TODO -- you fill in here
        mRWLock.readLock().lock();
        try{ 
        	long value = mValue;
        	return  value;
        	}
        finally { mRWLock.readLock().unlock();}
=======
    public long get() {
        // TODO - you fill in here
>>>>>>> refs/remotes/upstream/master
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the updated value
     */
<<<<<<< HEAD
    public long decrementAndGet()
    {    
        // TODO -- you fill in here
        mRWLock.writeLock().lock();
        try {
        	mValue = mValue - 1;
            long value = mValue;
        	return value;}
        finally {mRWLock.writeLock().unlock();}
      
=======
    public long decrementAndGet() {
        // TODO - you fill in here
>>>>>>> refs/remotes/upstream/master
    }

    /**
     * @brief Atomically increments by one the current value
     * increments the value and returns the previous value
     * @returns the previous value
     */
<<<<<<< HEAD
    public long getAndIncrement()
    {
        // TODO -- you fill in here
        mRWLock.writeLock().lock();
        try {
        	long value = mValue;
            mValue = mValue + 1;
        	return value;}
        finally {
        	mRWLock.writeLock().unlock();
        	}
        
=======
    public long getAndIncrement() {
        // TODO - you fill in here
>>>>>>> refs/remotes/upstream/master
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the previous value
     */
<<<<<<< HEAD
    public long getAndDecrement()
    {
       // TODO -- you fill in here
         mRWLock.writeLock().lock();
        try {
        	long value = mValue;
            mValue = mValue - 1;
        	return value;
        	}
        finally {
        	mRWLock.writeLock().unlock();
        	}  
=======
    public long getAndDecrement() {
        // TODO - you fill in here
>>>>>>> refs/remotes/upstream/master
    }

    /**
     * @brief Atomically increments by one the current value
     * gets the value and returns the updated value
     * @returns the updated value
     */
<<<<<<< HEAD
    public long incrementAndGet()
    {
         // TODO -- you fill in here
         mRWLock.writeLock().lock();
         try {
       		 mValue = mValue + 1;
             long value = mValue;
        	 return value;
        	 }
         finally {
        	 mRWLock.writeLock().unlock();
        	 }
         
=======
    public long incrementAndGet() {
        // TODO - you fill in here
>>>>>>> refs/remotes/upstream/master
    }
}

