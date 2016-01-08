/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator;

import java.util.ArrayList;
import java.util.List;
import scanner.FileAtributes;

/**
 *
 * @author ahuskano
 */
public class ItemContainer implements Container{

 private List<FileAtributes> items;

    public ItemContainer(List<FileAtributes> items) {
        this.items = items;
    }

    public ItemContainer() {
        this.items=new ArrayList();
    }
   
    
    @Override
    public Iterator getIterator() {
          return new ItemsIterator();
    }

    public List<FileAtributes> getItems() {
        return items;
    }
    
    public ArrayList<String> getStrings(){
        ArrayList<String> strings=new ArrayList<String>();
        for(FileAtributes file:items){
            strings.addAll(file.getStrings());
        }
        return strings;
    }

    public void setItems(List<FileAtributes> items) {
        this.items = items;
    }
    
    public void addItems(List<FileAtributes> items){
        for(FileAtributes item:items)
            this.items.add(item);
    }
    
    public void addItem(FileAtributes item){
        this.items.add(item);
    }
    
    public class ItemsIterator implements Iterator {

       private int index;

        @Override
        public boolean hasNext() {
            if(index < items.size()){
                return true;
             }
             return false;    }

        @Override
        public FileAtributes next() {
            if(this.hasNext()){
                return items.get(index++);
             }
             return null;
        }

    }
}
