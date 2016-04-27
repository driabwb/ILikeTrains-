package com.david.iter1iliketrains;

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
