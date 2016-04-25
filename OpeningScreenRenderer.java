package com.david.iter1iliketrains;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class OpeningScreenRenderer {
    // Model
    private OpeningScreenWorld theWorld = null;

    // Drawing
    private OrthographicCamera camera = null;
    private SpriteBatch sb = null;

    public OpeningScreenRenderer(OpeningScreenWorld world){
        theWorld = world;

        camera = new OrthographicCamera();
        camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        sb = new SpriteBatch();
        AssetLoader.load();
    }

    public void render(){
        Gdx.app.log(this.getClass().getName(), "Render");
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.begin();
        AssetLoader.title.draw(sb, "I Like Trains!", theWorld.getWidth()/4, theWorld.getHeight()/2);
        sb.end();
    }


}
