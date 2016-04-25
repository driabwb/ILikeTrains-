package com.david.iter1iliketrains;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Level1World extends InputAdapter {
    private static Level1World theWorld = null;
    private List<GameObject> gameObjects = null;
    private Batch batch = null;
    private GameObject draggedObject = null;

    private PlayButton playButton = null;

    private Level1World(){
        batch = new SpriteBatch();

        int width = Gdx.graphics.getWidth();
        int height = Gdx.graphics.getHeight();

        List<TrackPiece> trackList = new ArrayList<TrackPiece>();
        trackList.add(new StraightTrackPiece(null, new Vector2(width/2, height/4), new Vector2(3*width/4, height/4)));
        trackList.add(new StraightTrackPiece(null, new Vector2(3*width/4, height/4), new Vector2(3*width/4, 3*height/4)));
        trackList.add(new StraightTrackPiece(null, new Vector2(3*width/4, 3*height/4), new Vector2(width/2, 3*height/4)));
        trackList.add(new StraightTrackPiece(null, new Vector2(width/2, 3*height/4), new Vector2(width/2, height/4)));
        trackList.get(0).setNext(trackList.get(1));
        trackList.get(1).setNext(trackList.get(2));
        trackList.get(2).setNext(trackList.get(3));
        trackList.get(3).setNext(trackList.get(0));
        Track track = new Track(0,0, trackList);

        Train train1 = new Train(width/2, height/4, track);

        Mutex m = new Mutex(width/4, height/4);
        playButton = new PlayButton(width - 200, 100);

        gameObjects = new ArrayList<GameObject>();
        gameObjects.add(track);
        gameObjects.add(train1);
        gameObjects.add(m);
    }

    public static synchronized Level1World getTheWorld(){
        if(null == theWorld){
            theWorld = new Level1World();
        }
        return theWorld;
    }

    public void draw(){
        for(GameObject go : gameObjects){
            go.draw(batch);
        }
    }

    public void update(double delta){
        for(GameObject go : gameObjects){
            go.update(delta);
        }
    }

    @Override
    public boolean touchDown(int x, int y, int ptr, int button){
        return false;
    }

    @Override
    public boolean touchDragged(int x, int y, int ptr){
        return false;
    }

    @Override
    public boolean touchUp(int x, int y, int ptr, int button){
        return false;
    }
}
