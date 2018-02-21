package com.gdx.scratches;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.gdx.hamsters.Hamsters;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ScrGhosts implements Screen, InputProcessor {

    SpriteBatch batch;
    int nGhostX, nGhostY, nGhostDirOld, nGhostDirNew, nGhostdX, nGhostdY, nHamDir, nHamVorH, nHamdX, nHamdY, nRanGhostMove;
    boolean bGhostChangeDir, bGhostOutOfBounds, bHamsterOutOfBounds, bGhostRanMove, bIsHit;
    OrthographicCamera ocCam;
    SprGhost sprGhost;
    SprHamster sprHamster;
    Hamsters game;

    public ScrGhosts(Hamsters aThis) {
        batch = new SpriteBatch();
        sprGhost = new SprGhost(275, 200, 30, 30);
        sprHamster = new SprHamster(100, 100, 30, 30);
        nGhostdX = 0;
        nGhostdY = 0;
        bGhostChangeDir = false;
        Gdx.input.setInputProcessor(this);
        ocCam = new OrthographicCamera();
        game = aThis;
    }

    @Override
    public void show() {
        ocCam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        ocCam.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        ocCam.update();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255, 255, 255, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        nRanGhostMove = (int) (Math.random() * 50 + 1);
        if (nRanGhostMove == 1) {
            bGhostChangeDir = true;
        }
        if (bGhostChangeDir == true) {
            nGhostDirOld = nGhostDirNew;
            nGhostDirNew = GhostDirection(nGhostDirNew, nGhostDirOld);
            bGhostChangeDir = false;
        }
        nGhostdX = horizontal(nGhostDirNew, nGhostdX);
        nGhostdY = vertical(nGhostDirNew, nGhostdY);
        nHamVorH = nHamDir % 2;
        if (nHamVorH == 0) {
            nHamdX = horizontal(nHamDir, nHamdY);
            nHamdY = 0;
        } else {
            nHamdY = vertical(nHamDir, nHamdX);
            nHamdX = 0;
        }
        sprGhost.setX(sprGhost.getX() + nGhostdX);
        sprGhost.setY(sprGhost.getY() + nGhostdY);
        sprHamster.setX(sprHamster.getX() + nHamdX);
        sprHamster.setY(sprHamster.getY() + nHamdY);
        bIsHit = isHit(sprGhost, sprHamster);
        if (bIsHit == true) {
            game.updateState(1);
        }
        bGhostOutOfBounds = isOutOfBounds(sprGhost);
        if (bGhostOutOfBounds == true) {
            sprGhost.setX(sprGhost.getX() - nGhostdX);
            sprGhost.setY(sprGhost.getY() - nGhostdY);
            bGhostChangeDir = true;
        }
        bHamsterOutOfBounds = isOutOfBounds(sprHamster);      
        if (bHamsterOutOfBounds == true) {
            sprHamster.setX(sprHamster.getX() - nHamdX);
            sprHamster.setY(sprHamster.getY() - nHamdY);
        }
        batch.begin();
        //batch.draw(Ghost, Ghost.getX(), Ghost.getY());
        sprGhost.draw(batch);
        sprHamster.draw(batch);
        batch.end();
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
    
    public boolean isHit(Sprite spr1, Sprite spr2) {
        return spr1.getBoundingRectangle().overlaps(spr2.getBoundingRectangle());
    }
    public static boolean isOutOfBounds(Sprite spr1) {
        if (0 < spr1.getX() && spr1.getX() + spr1.getWidth() < Gdx.graphics.getWidth() && 0 < spr1.getY() && spr1.getY() + spr1.getHeight() < Gdx.graphics.getHeight()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void resize(int i, int i1) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.W) {
            nHamDir = 1;
        } else if (keycode == Input.Keys.D) {
            nHamDir = 2;
        } else if (keycode == Input.Keys.S) {
            nHamDir = 3;
        } else if (keycode == Input.Keys.A) {
            nHamDir = 4;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        nHamDir = 0;
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;

    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;

    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;

    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;

    }

    @Override
    public boolean scrolled(int i) {
        return false;

    }
}
