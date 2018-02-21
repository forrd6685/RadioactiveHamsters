/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdx.scratches;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gdx.hamsters.Hamsters;

/**
 *
 * @author forrd6685
 */
public class ScrCollection {
    
    SpriteBatch batch;
    int nGhostX, nGhostY, nGhostDirOld, nGhostDirNew, nGhostdX, nGhostdY, nHamsterMove;
    boolean bGhostChangeDir, bOutOfBounds;
    OrthographicCamera ocCam;
    SprGhost sprGhost;
    SprHamster sprHamster;
    
    public ScrCollection(Hamsters aThis) {
        
    }
}
