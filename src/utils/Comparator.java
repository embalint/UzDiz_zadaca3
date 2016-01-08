/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import iterator.ItemContainer;
import iterator.ItemsIterator;
import iterator.Iterator;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.List;
import scanner.FileAtributes;

/**
 *
 * @author ahuskano
 */
public class Comparator {
    
    public static ArrayList<String> compare(ArrayList<FileAtributes> oldList, ArrayList<FileAtributes> newList){
        ArrayList<String> difference=new ArrayList();
        Iterator oldIterator=new ItemsIterator(oldList);
        Iterator newIterator=new ItemsIterator(newList);
         while(newIterator.hasNext()){
             FileAtributes newItem=newIterator.next();
             while(oldIterator.hasNext()){
                 FileAtributes oldItem=oldIterator.next();
                 if(newItem.getFileName().equals(oldItem.getFileName())){
                     String msg=compareFiles(oldItem, newItem);
                     if(msg!=null)
                         difference.add(msg);
                 }
             }
         } 
        return difference;
    }

    public static String compareFiles(FileAtributes oldFile, FileAtributes newFile){
        if(newFile.getCreationTime()!=oldFile.getCreationTime()){
            return "Different creation time";
        }else if(newFile.getModifiedTime()!=oldFile.getModifiedTime()){
            return "FIle is modified";
        }else if(newFile.getFileSize()!=oldFile.getFileSize()){
            return "FIle size changed";
        }
        return null;
    }

}
