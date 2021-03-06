package com.david.iter1iliketrains;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.InputProcessor;

// Handles the user input on the opening screen
//   This just passes you through if you touch the screen
public class OpeningScreenInputHandler implements InputProcessor {
    Game theGame = null;

    OpeningScreenInputHandler(Game g){
        theGame = g;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        theGame.setScreen(new Level1Screen(theGame));
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
