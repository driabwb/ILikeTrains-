package com.david.iter1iliketrains;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

// Convinience class for moving through levels especially since the 'win' conditions are not implemented
public class ForwardButton extends GameObject{
    // Thing that draws
    private ShapeRenderer renderer = null;
    // The present game to move to the next screen
    private Game theGame = null;
    // size for drawing
    private int radius = 100;

    public ForwardButton(int x, int y, Game game){
        super(x,y);
        theGame = game;
        renderer = new ShapeRenderer();
    }

    @Override
    public void draw(Batch b){
        renderer.setColor(Color.CYAN);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.circle(getX(), getY(), 100);
        renderer.end();
    }

    @Override
    public void update(double delta){}

    @Override
    public GameObject touchDown(int x, int y, int button){
        Gdx.app.log(this.getClass().getName(), "Point: (" + this.x + ", " + this.y + ")");
        // If touching the button
        if(Math.pow(radius, 2) >= distance2(x,y)){
            // Move to the level 2 screen
            theGame.setScreen(new Level2Screen(theGame));
        }
        return null;
    }
}

