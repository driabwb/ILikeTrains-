package com.david.iter1iliketrains;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

// Class for the level 1 screen
//   Most methods are not truely implemented because they were unneccessary and I don't fully
//   understand their use.
public class Level1Screen implements Screen {
    // The world for level 1 (handles most of the details
    private Level1World theWorld = null;

    Level1Screen(Game game){
        theWorld = Level1World.getTheWorld(game);
        Gdx.input.setInputProcessor(theWorld);
    }

    @Override
    public void show() {

    }

    // This is the update and draw method
    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Update eveything in the world
        theWorld.update(delta);
        // Render the world
        theWorld.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
