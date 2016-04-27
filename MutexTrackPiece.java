package com.david.iter1iliketrains;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class MutexTrackPiece extends TrackPiece {
    private int x, y;
    private int radius = 50;
    private ShapeRenderer renderer = null;

    public MutexTrackPiece(int x, int y, TrackPiece nextPiece){
        super(nextPiece);
        this.x = x;
        this.y = y;
        renderer = new ShapeRenderer();
        renderer.setColor(Color.GREEN);
    }

    @Override
    public boolean addMutex(int x, int y, int radius){
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
        nextPiece = true;
        return curPos;
    }
}
