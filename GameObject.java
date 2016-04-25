package com.david.iter1iliketrains;

import com.badlogic.gdx.graphics.g2d.Batch;

public abstract class GameObject {
    protected int x = 0;
    protected int y = 0;

    public GameObject(int xPos, int yPos){
        x = xPos;
        y = yPos;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isDraggable(){
        return false;
    }

    public boolean isClickable(){
        return false;
    }

    public GameObject touchDown() { return null; }

    public abstract void draw(Batch b);
    public abstract void update(double delta);
}
