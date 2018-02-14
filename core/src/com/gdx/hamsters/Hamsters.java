package com.gdx.hamsters;

import com.badlogic.gdx.Game;
import com.gdx.scratches.scraGhosts;

public class Hamsters extends Game {

    @Override
    public void create() {
        this.setScreen(new scraGhosts(this));

    }

    @Override
    public void render() {
        super.render();
    }
}
