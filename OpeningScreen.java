package com.david.iter1iliketrains;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

// Class for the Opening screen
//   Most methods are not truely implemented because they were unneccessary and I don't fully
//   understand their use
public class OpeningScreen implements Screen {
    // The things in the world
    OpeningScreenWorld theWorld = null;
    // An Object responsible for rendering everything in scene
    OpeningScreenRenderer renderer = null;

    public OpeningScreen(Game game){
        // Designate what deals with the user inputs to the system
        Gdx.input.setInputProcessor(new OpeningScreenInputHandler(game));
        theWorld = new OpeningScreenWorld();
        renderer = new OpeningScreenRenderer(theWorld);

    }

    public void dispose(){

    }
    // Update and draws the world
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
