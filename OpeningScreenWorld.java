package com.david.iter1iliketrains;


import com.badlogic.gdx.Gdx;

public class OpeningScreenWorld {

    private int screenWidth = 0;
    private int screenHeight = 0;

    OpeningScreenWorld(){
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
    }
    public void update(double dt){

    }

    public int getWidth(){
        return screenWidth;
    }

    public int getHeight(){
        return screenHeight;
    }
}
