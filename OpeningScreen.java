package com.david.iter1iliketrains;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class OpeningScreen implements Screen {
    OpeningScreenWorld theWorld = null;
    OpeningScreenRenderer renderer = null;

    public OpeningScreen(){
        theWorld = new OpeningScreenWorld();
        renderer = new OpeningScreenRenderer(theWorld);

    }

    public void dispose(){

    }

    public void render(float timeSinceLastRender){
        theWorld.update(timeSinceLastRender);
        renderer.render();
    }

    public void show(){

    }

    public void hide(){

    }

    public void pause(){

    }

    public void resume(){

    }

    public void resize(int width, int height){

    }
}
