/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import registry.Registry;

/**
 *
 * @author ahuskano
 */
public class Controller implements Runnable {

    protected Object get(String key) {
        return Registry.getInstance().get(key);
    }

    public void work() {

    }

    @Override
    public void run() {
        work();
    }

}
