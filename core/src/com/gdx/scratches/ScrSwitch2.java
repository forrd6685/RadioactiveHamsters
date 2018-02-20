/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdx.scratches;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gdx.hamsters.Hamsters;

/**
 *
 * @author forrd6685
 */
public class ScrSwitch2 implements Screen {
   Texture tx;
    SpriteBatch batch;
    Sprite spr;
    
    public ScrSwitch2(Hamsters aThis) {
        batch = new SpriteBatch();
        tx = new Texture("two.png");
        spr = new Sprite(tx);
        // ftdt
    }
    
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(spr, 400 , 400);
        batch.end();
        System.out.println("2");
    }

    @Override
    public void show() {
        
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
}