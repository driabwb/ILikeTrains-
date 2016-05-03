package com.david.iter1iliketrains;

import com.badlogic.gdx.graphics.g2d.Batch;

/*
 *  This is the class all other in play game object derive from.
 *  This provides a basic interface for the Worlds.
 *  Being able to draw, update, touch.
 *  This also provides a base for enforcing the position of items
 */
public abstract class GameObject {
    // Position of game object
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

    // Unused method for if it makes sense for an item to be dragged
    public boolean isDraggable(){
        return false;
    }

    // Unused method for if it makes sense for an item to be clicked (pressed)
    public boolean isClickable(){
        return false;
    }

    // Touch down returns an object in case the world needs to react
    // TODO: refactor to not need the game object return
    public GameObject touchDown(int x, int y, int button) { return null; }

    public abstract void draw(Batch b);
    public abstract void update(double delta);

    // Convenience funciton for determining distance from the object
    protected double distance2(int x, int y){
        return Math.pow((x-this.x), 2) + Math.pow((y-this.y), 2);
    }
}
