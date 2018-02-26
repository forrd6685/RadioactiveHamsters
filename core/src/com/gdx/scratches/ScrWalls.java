/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdx.scratches;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gdx.hamsters.GamHamsters;

/**
 *
 * @author vachb8648
 */
public class ScrWalls implements Screen, InputProcessor {

    SpriteBatch batch;
    int nHamDir, nHamVorH, nHamdX, nHamdY;
    boolean bHamsterOutOfBounds;
    OrthographicCamera ocCam;
    SprHamster sprHamster;
    GamHamsters game;

    public ScrWalls(GamHamsters aThis) {
        batch = new SpriteBatch();
        sprHamster = new SprHamster(100, 100, 30, 30);
        Gdx.input.setInputProcessor(this);
        ocCam = new OrthographicCamera();
        game = aThis;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float f) {
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
