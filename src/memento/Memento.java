/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memento;

import java.util.Calendar;
import java.util.List;
import scanner.FileAtributes;

/**
 *
 * @author ahuskano
 */
public class Memento {
    
    private List<FileAtributes> state;
    private String time;
    
    public Memento(){
        
    }
    public Memento(List<FileAtributes> state) {
        this.state=state;
        time=Calendar.getInstance().getTime().toString();
    }

    public List<FileAtributes> getState() {
        return state;
    }

    public void setState(List<FileAtributes> state) {
        time=Calendar.getInstance().getTime().toString();
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
     
}
