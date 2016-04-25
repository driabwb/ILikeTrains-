package com.david.iter1iliketrains;

import com.badlogic.gdx.graphics.g2d.Batch;

public class WorldReset extends GameObject {
    private boolean isReset = false;

    public void setReset(boolean reset) {
        isReset = reset;
    }

    public boolean isReset() {
        return isReset;
    }

    public WorldReset(boolean reset){
        super(0,0);
        isReset = reset;

    }

    @Override
    public void draw(Batch b){}
    @Override
    public void update(double delta){}
}
