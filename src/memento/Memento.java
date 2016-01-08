/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memento;

import java.util.List;
import scanner.FileAtributes;

/**
 *
 * @author ahuskano
 */
public class Memento {
    
    private List<FileAtributes> state;
    
    public Memento(){
        
    }
    public Memento(List<FileAtributes> state) {
        this.state=state;
    }

    public List<FileAtributes> getState() {
        return state;
    }

    public void setState(List<FileAtributes> state) {
        this.state = state;
    }
     
}
