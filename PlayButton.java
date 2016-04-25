package com.david.iter1iliketrains;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class PlayButton extends GameObject{
    private boolean play = false;
    private ShapeRenderer renderer = null;
    private int radius = 0;
    private WorldReset reset = null;

    public PlayButton(int x, int y) {
        this(x, y, 100);
    }

    public PlayButton(int x, int y, int radius){
        super(x,y);
        this.radius = radius;
        renderer = new ShapeRenderer();
        reset = new WorldReset(false);
    }

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }

    public WorldReset getReset() { return reset; }

    @Override
    public void draw(Batch b){
        if(play){
            renderer.setColor(Color.RED);
        } else{
            renderer.setColor(Color.GREEN);
        }
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.circle(getX(), getY(), 100);
        renderer.end();
    }

    // It does not make sense for the play button to update
    @Override
    public void update(double delta){}

    @Override
    public GameObject touchDown(int x, int y, int button){
        Gdx.app.log(this.getClass().getName(), "Point: (" + this.x + ", " + this.y + ")");
        if(Math.pow(radius, 2) >= distance2(x,y)){
            play = !play;
            reset.setReset(!play);
            return reset;
        }
        return null;
    }
}
