package com.gdx.hamsters;

import com.badlogic.gdx.Game;
import com.gdx.scratches.ScrSwitch1;
import com.gdx.scratches.ScrSwitch2;
import com.gdx.scratches.ScrGhosts;

public class Hamsters extends Game {

    ScrGhosts scraGhosts;
    ScrSwitch1 ScrSwitch1;
    ScrSwitch2 ScrSwitch2;
    int nScreen;

    public void updateState(int _nScreen) {
        nScreen = _nScreen;
        if (nScreen == 0) {
            setScreen(ScrSwitch1);
        } else if (nScreen == 1) {
            setScreen(ScrSwitch2);
        } else if (nScreen == 2) {
            setScreen(scraGhosts);
        }
    }

    @Override
    public void create() {
        nScreen = 2;
        ScrSwitch1 = new ScrSwitch1(this);
        ScrSwitch2 = new ScrSwitch2(this);
        scraGhosts = new ScrGhosts(this);
        updateState(nScreen);
        
    }

    @Override
    public void render() {
        super.render();
    }
}
