package com.david.iter1iliketrains;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.List;


public class Track extends GameObject{
    private List<TrackPiece> trackPieces = null;
    private TrackPiece startPiece = null;
    private TrackPiece currentPiece = null;

    public Track(int x, int y, List<TrackPiece> pieces){
        super(x,y);
        trackPieces = pieces;
        currentPiece = trackPieces.get(0);
        startPiece = currentPiece;
    }

    public void reset(){
        currentPiece = startPiece;
    }

    public boolean addMutex(Mutex m){
        TrackPiece curr = startPiece;
        do{
            if(curr.addMutex(m)){
                return true;
            }
            curr = curr.getNext();
        }while(curr != startPiece);
        return false;
    }

    @Override
    public void draw(Batch sb){
        TrackPiece curr = startPiece;
        startPiece.draw(sb);
        do{

            curr.draw(sb);
            curr = curr.getNext();
        }while(startPiece != curr);
    }

    @Override
    public void update(double delta){}

    public Vector2 nextPosition(Vector2 p){
        Gdx.app.log(this.getClass().getName(), "Before: " + p.toString());
        p = currentPiece.getNextPosition(p);
        currentPiece = currentPiece.getCurrentTrackPiece();
        Gdx.app.log(this.getClass().getName(), "After: " + p.toString());
        return p;
    }
}
