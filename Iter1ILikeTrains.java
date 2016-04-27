package com.david.iter1iliketrains;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class Iter1ILikeTrains extends Game {
	public void dispose(){
		return;
	}
	public void create(){
		setScreen(new OpeningScreen(this));
	}

	public void resume() { setScreen(new OpeningScreen(this)); }
}
