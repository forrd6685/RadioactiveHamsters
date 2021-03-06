package com.gdx.scratches;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.Gdx;

public class SprGhost extends Sprite {

    int nDx, nDy;

    public SprGhost(int nX, int nY, int nW, int nH) {
        super(new Texture(Gdx.files.internal("ghost.png")));
        setSize(nW, nH);
        setPosition(nX, nY);
//        setFlip(true, true);
    }

    public void Movement(int nDirNew) {
        nDx = 0;
        nDy = 0;
        if (nDirNew == 1) {
            nDy = 2;
            nDx = 0;
        } else if (nDirNew == 2) {
            nDx = 2;
            nDy = 0;
        } else if (nDirNew == 3) {
            nDy = -2;
            nDx = 0;
        } else if (nDirNew == 4) {
            nDx = -2;
            nDy = 0;
        }
        setX(getX() + nDx);
        setY(getY() + nDy);
    }

    public void OOB() {
        setX(getX() + nDx);
        setY(getY() + nDy);
    }

    public int GhostDirection(int nDirNew, int nDirOld) {
        while (nDirNew == nDirOld) {
            nDirNew = (int) (Math.random() * 4 + 1);
        }
        return nDirNew;
    }
}
