package com.david.iter1iliketrains;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

// A representation of a Train
public class Train extends GameObject{
    private Rectangle rect = null;
    private static ShapeRenderer shapeRenderer = null;
    private Track track = null;
    private int initX,initY;

    public Train(int x, int y, Track myTrack){
        super(x,y);
        initX = x;
        initY = y;
        rect = new Rectangle(x, y,50,50);
        shapeRenderer = new ShapeRenderer();
        track = myTrack;
    }

    @Override
    public void draw(Batch sb){
        shapeRenderer.setColor(Color.PINK);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(rect.getX()- rect.getWidth()/2, rect.getY()-rect.getHeight()/2, rect.getWidth(), rect.getHeight());
        shapeRenderer.end();
    }

    public boolean isFinishedRun(){
        return true;
    }

    public void reset(){
        super.setX(initX);
        super.setY(initY);
        rect.setPosition(initX, initY);
        track.reset();
    }

    @Override
    public void update(double delta){
        this.move(track.nextPosition(getPosition()));
    }

    public void move(Vector2 vec){
        rect.setPosition(vec.x, vec.y);
    }

    @Override
    public void setX(int x){
        super.setX(x);
        rect.setX(x);
    }

    @Override
    public void setY(int y){
        super.setY(y);
        rect.setY(y);
    }

    public Vector2 getPosition(){
        return rect.getPosition(new Vector2());
    }
}
