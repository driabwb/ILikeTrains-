package com.david.iter1iliketrains;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ForwardButton extends GameObject{
    private ShapeRenderer renderer = null;
    private Game theGame = null;
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
        if(Math.pow(radius, 2) >= distance2(x,y)){
            theGame.setScreen(new Level2Screen(theGame));
        }
        return this;
    }
}

