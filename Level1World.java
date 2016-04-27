package com.david.iter1iliketrains;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Level1World extends InputAdapter {
    private static Level1World theWorld = null;
    private List<GameObject> gameObjects = null;
    private Batch batch = null;
    private Camera camera = null;
    private GameObject draggedObject = null;

    private PlayButton playButton = null;
    private ForwardButton forwardButton = null;
    private Track track1 = null;
    private Train train1 = null;
    private Lock theLock = null;
    private Mutex lock = null;
    private Mutex unlock = null;

    private Level1World(Game game){
        batch = new SpriteBatch();
        int width = Gdx.graphics.getWidth();
        int height = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(width, height);

        List<TrackPiece> trackList = new ArrayList<TrackPiece>();
        trackList.add(new StraightTrackPiece(null, new Vector2(width/2, height/4), new Vector2(3*width/4, height/4)));
        trackList.add(new StraightTrackPiece(null, new Vector2(3*width/4, height/4), new Vector2(3*width/4, 3*height/4)));
        trackList.add(new StraightTrackPiece(null, new Vector2(3*width/4, 3*height/4), new Vector2(width/2, 3*height/4)));
        trackList.add(new StraightTrackPiece(null, new Vector2(width/2, 3*height/4), new Vector2(width/2, height/4)));
        trackList.get(0).setNext(trackList.get(1));
        trackList.get(1).setNext(trackList.get(2));
        trackList.get(2).setNext(trackList.get(3));
        trackList.get(3).setNext(trackList.get(0));
        track1 = new Track(0,0, trackList);

        train1 = new Train(width/2, height/4, track1);
        theLock = new Lock();
        lock = new Mutex(width/4, 3*height/4, true, theLock, Color.RED);
        unlock = new Mutex(width/4+300, 3*height/4, false, theLock, Color.GREEN);
        playButton = new PlayButton(width - 200, 100);
        forwardButton = new ForwardButton(width-200, height-300,game);

        gameObjects = new ArrayList<GameObject>();
        gameObjects.add(track1);
        gameObjects.add(train1);
        gameObjects.add(lock);
        gameObjects.add(unlock);
        gameObjects.add(playButton);
        gameObjects.add(forwardButton);
    }

    public static synchronized Level1World getTheWorld(Game game){
        if(null == theWorld){
            theWorld = new Level1World(game);
        }
        return theWorld;
    }

    public void draw(){
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        for(GameObject go : gameObjects){
            go.draw(batch);
        }
        if(null != draggedObject){
            draggedObject.draw(batch);
        }

        AssetLoader.font.draw(batch, "Locks", 200, Gdx.graphics.getHeight() - 100);
        AssetLoader.font.draw(batch, "Play", playButton.getX(), playButton.getY()+200);
        AssetLoader.font.draw(batch, "Forward", forwardButton.getX(), forwardButton.getY());
        batch.end();
    }

    public void update(double delta){
        if(playButton.isPlay()) {
            for (GameObject go : gameObjects) {
                go.update(delta);
            }
        }
    }

    @Override
    public boolean touchDown(int x, int y, int ptr, int button){
        y = Gdx.graphics.getHeight() - y;
        Gdx.app.log(this.getClass().getName(), "Point: (" + x + ", " + y + ")");
        for (GameObject go : gameObjects) {
            draggedObject = go.touchDown(x, y, button);
            if(null != draggedObject){
                if(playButton.getReset() == draggedObject){
                    if(playButton.getReset().isReset()) {
                        train1.reset();
                        theLock.unlock();
                    }
                    draggedObject = null;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean touchDragged(int x, int y, int ptr){
        if(null != draggedObject){
            draggedObject.setX(x);
            draggedObject.setY(Gdx.graphics.getHeight() - y);
        }

        return null != draggedObject;
    }

    @Override
    public boolean touchUp(int x, int y, int ptr, int button){
        y = Gdx.graphics.getHeight() - y;
        Gdx.app.log(this.getClass().getName(), "Point: (" + x + ", " + y + ")");
        if(null == draggedObject){
            return false;
        }
        // Do the mutex placement
        track1.addMutex((Mutex)draggedObject);
        draggedObject = null;
        return true;
    }
}
