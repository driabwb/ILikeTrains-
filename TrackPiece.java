package com.david.iter1iliketrains;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class TrackPiece {
    protected TrackPiece next = null;
    protected boolean nextPiece = false;

    public TrackPiece(TrackPiece n){
        next = n;
        nextPiece = false;
    }

    public TrackPiece getNext() {
        return next;
    }

    public void setNext(TrackPiece next) {
        this.next = next;
    }

    public abstract boolean addMutex(Mutex m);
    public abstract void draw(Batch sb);
    public abstract Vector2 getNextPosition(Vector2 currentVector2);
    public TrackPiece getCurrentTrackPiece(){
        if(nextPiece){
            nextPiece = false;
            return next;
        }

        return this;
    }
}
