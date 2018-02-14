package com.gdx.scratches;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.gdx.hamsters.Hamsters;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;

public class scraGhosts implements Screen, InputProcessor {

    Game game;
    SpriteBatch batch;
    Sprite sprGhost;
    Texture txGhost;
    int nGhostX, nGhostY, nDirOld, nDirNew, nScreenX, nScreenY, nGhostdX, nGhostdY;
    boolean bSpace;

    public scraGhosts(Hamsters aThis) {
        batch = new SpriteBatch();
        txGhost = new Texture("ghost.png");
        sprGhost = new Sprite(txGhost);
        nGhostX = 275;
        nGhostY = 200;
        nGhostdX = 0;
        nGhostdY = 0;
        bSpace = false;
        nScreenX = 500;
        nScreenY = 500;
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255, 255, 255, 100);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (bSpace == true) {
            nDirOld = nDirNew;
            nDirNew = direction(nDirNew, nDirOld);
            System.out.println(nDirNew);
            bSpace = false;
        }
        nGhostdY = vertical(nDirNew, nGhostdY);
        nGhostdX = horizontal(nDirNew, nGhostdX);
        nGhostX += nGhostdX;
        nGhostY += nGhostdY;
        batch.begin();
        batch.draw(txGhost, nGhostX, nGhostY, 30, 30);
        batch.end();
        

    }

    public static int direction(int nNum1, int nNum2) {
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
            bSpace = true;
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
