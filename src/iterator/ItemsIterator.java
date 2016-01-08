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

public class ItemsIterator implements Iterator {
     
    private List<FileAtributes> items=new ArrayList();
       
       private int index;

       public ItemsIterator(){
           
       }
       
       public ItemsIterator(List<FileAtributes> items){
           this.items=items;
       }

        public List<FileAtributes> getItems() {
            return items;
        }

        public void setItems(ArrayList<FileAtributes> items) {
            this.items = items;
        }
       
       
        @Override
        public boolean hasNext() {
            if(index < items.size()){
                return true;
             }
             return false;   
        }

        @Override
        public FileAtributes next() {
            if(this.hasNext()){
                return items.get(index++);
             }
             return null;
        }

    }