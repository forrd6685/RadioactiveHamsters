package com.gdx.scratches;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.Gdx;

public class SprGhost extends Sprite{
    public SprGhost(int nX, int nY, int nW, int nH) {
        super(new Texture(Gdx.files.internal("ghost.png")));
        setSize(nW, nH);
        setPosition(nX, nY);      
//        setFlip(true, true);
    }
}
