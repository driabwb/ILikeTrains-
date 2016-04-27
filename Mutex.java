package com.david.iter1iliketrains;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

public class Mutex extends GameObject {
    private ShapeRenderer renderer;

    private int radius = 100;
    private boolean isLocked = false;

    Mutex(int x, int y, boolean locked) {
        this(x,y, locked, Color.CYAN);
    }

    Mutex(int x, int y, boolean locked, Color c){
        super(x,y);
        renderer = new ShapeRenderer();
        renderer.setColor(c);
        isLocked = locked;
    }

    @Override
    public GameObject touchDown(int x, int y, int button){
        Gdx.app.log(this.getClass().getName(), "Point: (" + this.x + ", " + this.y + ")");
        if(distance2(x,y) > Math.pow(radius, 2)){
            return null;
        }

        return new Mutex(x, y, isLocked, renderer.getColor());
    }

    @Override
    public void draw(Batch b){
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.circle(getX(), getY(), radius);
        renderer.end();
    }

    @Override
    public void update(double delta){}

    public int getRadius(){
        return radius;
    }

    public boolean isLocked(){
        return isLocked;
    }
}
