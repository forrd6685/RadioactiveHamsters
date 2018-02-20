package com.gdx.scratches;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.gdx.hamsters.Hamsters;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class ScrGhosts implements Screen, InputProcessor {

    SpriteBatch batch;
    int nGhostX, nGhostY, nGhostDirOld, nGhostDirNew, nGhostdX, nGhostdY, nHamsterMove;
    boolean bGhostChangeDir, bOutOfBounds;
    OrthographicCamera ocCam;
    SprGhost sprGhost;
    SprHamster sprHamster;

    public ScrGhosts(Hamsters aThis) {
        batch = new SpriteBatch();
        sprGhost = new SprGhost(275, 200, 30, 30);
        sprHamster = new SprHamster(0, 0, 30, 30);
        nGhostdX = 0;
        nGhostdY = 0;
        bGhostChangeDir = false;
        Gdx.input.setInputProcessor(this);
        ocCam = new OrthographicCamera();
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
        if (bGhostChangeDir == true) {
            nGhostDirOld = nGhostDirNew;
            nGhostDirNew = GhostDirection(nGhostDirNew, nGhostDirOld);
            bGhostChangeDir = false;
        }
        nGhostdY = Vertical(nGhostDirNew, nGhostdY);
        nGhostdX = Horizontal(nGhostDirNew, nGhostdX);
        sprGhost.setX(sprGhost.getX() + nGhostdX);
        sprGhost.setY(sprGhost.getY() + nGhostdY);
        
        bOutOfBounds = isOutOfBounds(sprGhost.getX(), sprGhost.getY(), sprGhost.getWidth(), sprGhost.getHeight());
        if (bOutOfBounds == true) {
            sprGhost.setX(sprGhost.getX() - nGhostdX);
            sprGhost.setY(sprGhost.getY() - nGhostdY);
            bGhostChangeDir = true;
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

    public static int Vertical(int nNum1, int nNum2) {
        if (nNum1 == 1) {
            nNum2 = 2;
        } else if (nNum1 == 3) {
            nNum2 = -2;
        } else {
            nNum2 = 0;
        }
        return nNum2;
    }

    public static int Horizontal(int nNum1, int nNum2) {
        if (nNum1 == 2) {
            nNum2 = 2;
        } else if (nNum1 == 4) {
            nNum2 = -2;
        } else {
            nNum2 = 0;
        }
        return nNum2;
    }

    public static boolean isOutOfBounds(float fX, float fY, float fW, float fH) {
        if (0 < fX && fX + fW < Gdx.graphics.getWidth() && 0 < fY && fY + fH < Gdx.graphics.getHeight()) {
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
        if (keycode == Input.Keys.SPACE) {
            bGhostChangeDir = true;
        }
        if (keycode == Input.Keys.W) {
            nHamsterMove = 1;
        } else if (keycode == Input.Keys.D) {
            nHamsterMove = 2;
        } else if (keycode == Input.Keys.S) {
            nHamsterMove = 3;
        } else if (keycode == Input.Keys.A) {
            nHamsterMove = 4;
        }
        return false;
    }

    @Override
    public boolean keyUp(int i) {
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
