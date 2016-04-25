package com.david.iter1iliketrains;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.List;


public class Track extends GameObject{
    private List<TrackPiece> trackPieces = null;
    private TrackPiece currentPiece = null;

    public Track(int x, int y, List<TrackPiece> pieces){
        super(x,y);
        trackPieces = pieces;
        currentPiece = trackPieces.get(0);
    }

    @Override
    public void draw(Batch sb){
        for(TrackPiece tp : trackPieces){
            tp.draw(sb);
        }
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
