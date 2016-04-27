package com.david.iter1iliketrains;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class SharedTrackPiece extends TrackPiece{
    private TrackPiece piece = null;
    private SharedTrackObject object = null;
    private boolean isCW;

    public SharedTrackPiece(TrackPiece p, SharedTrackObject obj, boolean isCW){
        super(p.getNext());
        piece = p;
        object = obj;
        this.isCW = isCW;
    }

    @Override
    public Vector2 getNextPosition(Vector2 pos){
        return piece.getNextPosition(pos);
    }

    @Override
    public void draw(Batch b){
        piece.draw(b);
    }

    @Override
    public boolean addMutex(Mutex m){
        return piece.addMutex(m);
    }

    public class SharedTrackObject{
        private boolean cw = false;
        private boolean ccw = false;


        public boolean isSafe(){
            return !(cw&&ccw);
        }
    }
}
