package com.david.iter1iliketrains;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

/* The Level 1 World
 * The intent is that this stores all of the objects in the world and tells then to draw and update.
 * It additionally serves as the input handler so that it can delegate (with modification) to the
 * appropriate objects
 */
public class Level1World extends InputAdapter {
    // This is a singleton object (There should only ever be 1
    private static Level1World theWorld = null;
    // Everything in the scene
    private List<GameObject> gameObjects = null;
    // Something LibGDX uses for drawing (Not really used, mostly for future use.)
    private Batch batch = null;
    // The camera for drawing
    private OrthographicCamera camera = null;
    // The current object being dragged; null if none
    private GameObject draggedObject = null;

    // The button for start simulation
    private PlayButton playButton = null;
    // Skips level
    private ForwardButton forwardButton = null;
    // The track for the train
    private Track track1 = null;
    // The train itself
    private Train train1 = null;
    // The Lock for the actual mutex
    private Lock theLock = null;
    // The locking mutex (dragged from)
    private Mutex lock = null;
    // The unlocking mutex (dragged from)
    private Mutex unlock = null;

    // Intstantiate everything (Takes the game for level switching)
    private Level1World(Game game){
        batch = new SpriteBatch();
        // Get the width and height of the screen to render on
        int width = Gdx.graphics.getWidth();
        int height = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(width, height);
        camera.setToOrtho(false, width, height);

        // Create a bunch of track pieces for the Track the Train will run on
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

        // Create the rest of the drawn items
        train1 = new Train(width/2, height/4, track1);
        theLock = new Lock();
        lock = new Mutex(width/8, 3*height/4, true, theLock, Color.RED);
        unlock = new Mutex(width/8+300, 3*height/4, false, theLock, Color.GREEN);
        playButton = new PlayButton(width - 200, 100);
        forwardButton = new ForwardButton(width-200, height-300,game);

        // Add Game objects to the list of objects in the scene
        gameObjects = new ArrayList<GameObject>();
        gameObjects.add(track1);
        gameObjects.add(train1);
        gameObjects.add(lock);
        gameObjects.add(unlock);
        gameObjects.add(playButton);
        gameObjects.add(forwardButton);
    }

    // Singleton request function
    public static synchronized Level1World getTheWorld(Game game){
        if(null == theWorld){
            theWorld = new Level1World(game);
        }
        return theWorld;
    }

    public void draw(){
        batch.setProjectionMatrix(camera.combined);
        for(GameObject go : gameObjects){
            go.draw(batch);
        }
        if(null != draggedObject){
            draggedObject.draw(batch);
        }

        // Draw all the scenes text
        batch.begin();
        AssetLoader.font.draw(batch, "Locks", lock.getX()+100, lock.getY()+200);
        AssetLoader.font.draw(batch, "Play", playButton.getX()-50, playButton.getY()+200);
        AssetLoader.font.draw(batch, "Forward", forwardButton.getX()-100, forwardButton.getY()+200);
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
        // Given y is opposite drawn y for some reason
        y = Gdx.graphics.getHeight() - y;
        // For debugging
        Gdx.app.log(this.getClass().getName(), "Point: (" + x + ", " + y + ")");

        for (GameObject go : gameObjects) {
            // Try to touch each object; returns null if did not hit the object
            draggedObject = go.touchDown(x, y, button);
            if(null != draggedObject){
                // The reset signal for the level is special
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

    // Just keep moving the dragged object around
    @Override
    public boolean touchDragged(int x, int y, int ptr){
        if(null != draggedObject){
            draggedObject.setX(x);
            draggedObject.setY(Gdx.graphics.getHeight() - y);
        }

        return null != draggedObject;
    }

    // The only objects to be dragged are mutex so try to place a mutex on the only thing it can
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
