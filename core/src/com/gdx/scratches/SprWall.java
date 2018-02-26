package com.gdx.scratches;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;

public class SprWall extends Sprite{
    public SprWall(int nW, int nH, int nX, int nY){
        super(new Texture(Gdx.files.internal("testwall.jpg")));
        setPosition(nX, nY);
        setSize(nW, nH);
        setFlip(false, true);
    }
}