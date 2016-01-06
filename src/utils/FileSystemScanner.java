package utils;




import main.Main;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import static main.Main.scannerList;

import utils.FileSystemScannerAtributes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Emil
 */
public class FileSystemScanner {

    File directory;
    String[] directoryContents;
    ArrayList<String> fileLocations;
    

    public FileSystemScanner(String filePath) {
        this.directory = new File(filePath);
        this.directoryContents = directory.list();
        fileLocations = new ArrayList<String>();
        System.out.println(filePath);
        

    }

    public void returntDir() throws IOException {
        int counter = scannerList.size();
        
        for (String fileName : directoryContents) {
            scannerList.add(new FileSystemScannerAtributes());
            File temp = new File(String.valueOf(directory), fileName);
            fileLocations.add(String.valueOf(temp));
            Path path = Paths.get(fileLocations.get(counter));
        
            
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            FileTime creTime = attributes.creationTime();
            scannerList.get(counter).setFileSize(attributes.size());
            scannerList.get(counter).setCreationTime(creTime.toString());
            scannerList.get(counter).setFileName(fileName);
            scannerList.get(counter).setModifiedTime(attributes.lastModifiedTime().toString());
            scannerList.get(counter).setFiletype(Files.probeContentType(path));
            
            counter++;
           

        }
        
        
    }

}
