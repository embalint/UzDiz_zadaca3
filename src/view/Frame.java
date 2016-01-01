/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import utils.Settings;

/**
 *
 * @author ahuskano
 */
public abstract class Frame {
    
    private Settings settings;
    
    protected abstract void show();
    protected abstract void clear();
    
    public Frame(Settings settings){
        this.settings=settings;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }
    
    
    
}
