/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author ahuskano
 */
public class Model extends Observable {
    
    private ArrayList<String> buffer;
    
    public ArrayList<String> getBuffer() {
        return buffer;
    }
    
    public void setBuffer(ArrayList<String> buffer) {
        this.buffer = buffer;
        this.doNotify();
    }
    
    public void doNotify() {
        setChanged();
        notifyObservers();
    }
    
    public void setString(String txt) {
        ArrayList<String> b = new ArrayList<>();
        b.add(txt);
        this.setBuffer(b);
    }
    
}
