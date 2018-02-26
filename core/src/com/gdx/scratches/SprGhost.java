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

    public void Movement(Sprite spr1, int nDirOld, int nDirNew) {
        nDx = 0;
        nDy = 0;
        nDirOld = nDirNew;
        nDirNew = GhostDirection(nDirNew, nDirOld);
        nDx = horizontal(nDirNew, nDx);
        nDy = vertical(nDirNew, nDy);
//        spr1.setX(spr1.getX() + nDx);
//        spr1.setY(spr1.getY() + nDy);
    }

    public void OOB(Sprite spr1) {
        spr1.setX(spr1.getX() - nDx);
        spr1.setY(spr1.getY() - nDy);
    }

    public static int GhostDirection(int nNum1, int nNum2) {
        while (nNum1 == nNum2) {
            nNum1 = (int) (Math.random() * 4 + 1);
        }
        return nNum1;
    }

    public static int vertical(int nNum1, int nNum2) {
        if (nNum1 == 1) {
            nNum2 = 2;
        } else if (nNum1 == 3) {
            nNum2 = -2;
        } else {
            nNum2 = 0;
        }
        return nNum2;
    }

    public static int horizontal(int nNum1, int nNum2) {
        if (nNum1 == 2) {
            nNum2 = 2;
        } else if (nNum1 == 4) {
            nNum2 = -2;
        } else {
            nNum2 = 0;
        }
        return nNum2;
    }
}
