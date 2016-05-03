package com.david.iter1iliketrains;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class AssetLoader {
    // Font Assets
    public static BitmapFont font = null;
    public static BitmapFont title = null;

    // Static function to initialize all the assests
    public static void load(){
        if(font != null) {
            return;
        }

        font = new BitmapFont(Gdx.files.internal("data/DroidSerif.fnt"));
        title = new BitmapFont(Gdx.files.internal("data/Title.fnt"));

    }
}
