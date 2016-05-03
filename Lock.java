package com.david.iter1iliketrains;

// Simple Lock class with two states
//   All methods are synchronized to reduce multiple thread collision
public class Lock {
    private boolean isLocked = false;

    public Lock(){}

    public synchronized boolean isLocked() {
        return isLocked;
    }

    public synchronized void lock() {
        isLocked = true;
    }

    public synchronized void unlock(){
        isLocked = false;
    }
}
