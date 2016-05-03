package com.david.iter1iliketrains;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class Iter1ILikeTrains extends Game {
	public void dispose(){
		return;
	}
	// Go straight to the opening screen
	public void create(){
		setScreen(new OpeningScreen(this));
	}

	// Always return to the opening sceen.
	public void resume() { setScreen(new OpeningScreen(this)); }
}
