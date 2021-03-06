/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memento;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahuskano
 */
public class MementoHandler {
    
    private List<Memento> mementoList=new ArrayList();
    
    public void addMemento(Memento memento){
        mementoList.add(memento);
    }
    
    public Memento getmemento(int index){
        return mementoList.get(index);
    }
    
    public int size(){
        return mementoList.size();
    }
    
    public ArrayList<String> getMementoInfo(){
        ArrayList<String> mementos=new ArrayList();
        for(int i=0;i<size();i++){
            Memento memento=mementoList.get(i);
            mementos.add(i+1+"."+memento.getTime());
        }
        return mementos;
    }
}
