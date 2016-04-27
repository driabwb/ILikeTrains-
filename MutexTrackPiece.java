package com.david.iter1iliketrains;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class MutexTrackPiece extends TrackPiece {
    private int x, y;
    private int radius = 50;
    private ShapeRenderer renderer = null;
    private boolean isLock;
    private Lock lock = null;

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
        if(isLock){
            if(lock.isLocked()){
                nextPiece = false;
                return curPos;
            }else{
                lock.lock();
            }
        }else {
            lock.unlock();
        }
        nextPiece = true;
        return curPos;
    }
}
