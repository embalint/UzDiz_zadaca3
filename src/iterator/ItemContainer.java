/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator;

import java.util.ArrayList;
import java.util.List;
import memento.MementoHandler;
import memento.Orginator;
import scanner.FileAtributes;

/**
 *
 * @author ahuskano
 */
public class ItemContainer implements Container{

    private List<FileAtributes> items;
    private MementoHandler handler=new MementoHandler();
    private Orginator orginator=new Orginator();
    
    public ItemContainer(List<FileAtributes> items) {
        this.items = items;
        updateOrginator();
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
        Iterator iterator=this.getIterator();
        while(iterator.hasNext()){
            strings.addAll(iterator.next().getStrings());
        }
        return strings;
    }

    public void setItems(List<FileAtributes> items) {
        this.items = items;
        updateOrginator();
    }
    
    public void addItems(List<FileAtributes> items){
        this.items.addAll(items);
        updateOrginator();
    }
    public void updateOrginator(){
        orginator.setState(items);
    }
    
    public void addItem(FileAtributes item){
        this.items.add(item);
        updateOrginator();
    }
    
    public void saveToMemento(){
       handler.addMemento(orginator.saveState());
    }

    public void retriveFromMemento(int index){
        saveToMemento();
        orginator.getStateFromMemento(handler.getmemento(index));
        items=orginator.getState();
    }
    
    public int getDirectoriesNumber(){
        int number=0;
        Iterator iterator=getIterator();
        while(iterator.hasNext()){
            number+=iterator.next().getDirectoriesNumber();
        }
        return number;
    }
    
    
    public int getFilesNumber(){
        int number=0;
        Iterator iterator=getIterator();
        while(iterator.hasNext()){
            number+=iterator.next().getFilesNumber();
        }
        return number;
    }
    public class ItemsIterator implements Iterator {

       private int index;

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
}
