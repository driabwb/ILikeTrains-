package com.david.iter1iliketrains;

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

    Mutex(int x, int y) {
        this(x,y, Color.CYAN);
    }

    Mutex(int x, int y, Color c){
        super(x,y);
        renderer = new ShapeRenderer();
        renderer.setColor(c);
    }

    @Override
    public void draw(Batch b){
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.circle(getX(), getY(), 100);
        renderer.end();
    }

    @Override
    public void update(double delta){}
}
