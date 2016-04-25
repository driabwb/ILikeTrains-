package com.david.iter1iliketrains;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class StraightTrackPiece extends TrackPiece {
    private Vector2 begin;
    private Vector2 end;
    private Vector2 delta;
    private static ShapeRenderer renderer = null;

    public StraightTrackPiece(TrackPiece next, Vector2 begin, Vector2 end){
        super(next);
        this.begin = begin;
        this.end = end;
        delta = new Vector2(end);
        delta.sub(begin);
        renderer = new ShapeRenderer();
    }

    @Override
    public void draw(Batch sb) {
        Gdx.app.log(this.getClass().getName(), "Begin: " + begin.toString());
        Gdx.app.log(this.getClass().getName(), "End: " + end.toString());
        renderer.setColor(Color.GOLD);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.rect(begin.x,begin.y, delta.x+5, delta.y+5);
        renderer.end();
    }

    @Override
    public Vector2 getNextPosition(Vector2 currentPosition) {
        Vector2 forward = new Vector2(end);
        forward.sub(currentPosition);
        Gdx.app.log(this.getClass().getName(), "Forward: " + forward.toString());
        if(100 >= forward.len2()) {
            nextPiece = true;
            currentPosition = end.cpy();
            return  currentPosition;
        }
        currentPosition = currentPosition.add(forward.nor().scl(10));
        return currentPosition;
    }
}
