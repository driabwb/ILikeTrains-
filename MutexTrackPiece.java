package com.david.iter1iliketrains;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class MutexTrackPiece extends TrackPiece {
    // The position for the Piece
    private int x, y;
    // Size for drawing
    private int radius = 50;
    // Thing that draws
    private ShapeRenderer renderer = null;
    // Whether this mutex locks or unlocks
    private boolean isLock;
    // The shared mutex lock
    private Lock lock = null;

    // Create the mutex track piece
    public MutexTrackPiece(int x, int y, boolean isLock, Lock lock, TrackPiece nextPiece){
        super(nextPiece);
        this.x = x;
        this.y = y;
        renderer = new ShapeRenderer();
        this.isLock = isLock;
        if(isLock) {
            renderer.setColor(Color.RED);
        }else {
            renderer.setColor(Color.GREEN);
        }
        this.lock = lock;
    }

    @Override
    public boolean addMutex(Mutex m){
        return false;
    }

    @Override
    public void draw(Batch b){
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.circle(x,y, radius);
        renderer.end();
    }

    @Override
    public Vector2 getNextPosition(Vector2 curPos){
        // If this is an unlocking mutex
        if(isLock){
            // check if the lock is already locked
            if(lock.isLocked()){
                // Don't move on
                nextPiece = false;
                return curPos;
            }else{
                // Lock the lock
                lock.lock();
            }
        }else {
            // Alwasy unlock w/ unlocking mutex
            lock.unlock();
        }
        // Defaultly move on
        nextPiece = true;
        return curPos;
    }
}
