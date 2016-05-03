package com.david.iter1iliketrains;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

// Provides the general interface for track pieces
//  These form a linked list that is a 'track'
public abstract class TrackPiece {
    // The piece after this one in the track
    protected TrackPiece next = null;
    // Should the train move to the next track on the next update
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

    // Check and Add a mutex within this track piece
    public abstract boolean addMutex(Mutex m);
    public abstract void draw(Batch sb);
    // Get the next position of a train given its current position
    public abstract Vector2 getNextPosition(Vector2 currentVector2);
    public TrackPiece getCurrentTrackPiece(){
        if(nextPiece){
            nextPiece = false;
            return next;
        }

        return this;
    }
}
