/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Model;
import view.ParentFrame;

/**
 *
 * @author ahuskano
 */
public class Controller {
    
    private ParentFrame view;
    private Model model;

    public Controller() {
    }

    
    public Controller(ParentFrame view, Model model) {
        this.view = view;
        this.model = model;
    }

    public ParentFrame getView() {
        return view;
    }

    public void setView(ParentFrame view) {
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    
    
    
}
