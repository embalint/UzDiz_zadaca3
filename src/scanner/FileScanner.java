/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

import controller.InputController;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import registry.Registry;

/**
 *
 * @author Emil
 */
public class FileScanner {
    
    private static String separate="  ";

    File actual = new File((String) Registry.getInstance().get("filepath"));

    public ArrayList<FileAtributes> listFileTree(File dir, int level) {
        ArrayList<FileAtributes> fileTree = new ArrayList<FileAtributes>();
        for (File entry : dir.listFiles()) {
          //  fileTree.add(String.join("", Collections.nCopies(level, separate))+entry);
            FileAtributes file=getFile(entry);
              fileTree.add(file);
            if (!entry.isFile()) 
                file.setChildrens(listFileTree(entry,level+1));
            }
        return fileTree;
    }
    
    public FileAtributes getFile(File file){
        BasicFileAttributes attributes;
        try {
            attributes = Files.readAttributes(Paths.get(file.getPath()), BasicFileAttributes.class);
       
            FileAtributes attr = new FileAtributes(
                        attributes.creationTime().toString(),
                        file.getName(),
                        file.isDirectory()?"directory":"file",
                        attributes.size(),
                        attributes.lastModifiedTime().toString(),
                    file.getParent()
            );
            return attr;
       } catch (IOException ex) {
            Logger.getLogger(FileScanner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<FileAtributes> getFileList() {

        return new ArrayList<FileAtributes>(listFileTree(actual,0));
        
        /*
        ArrayList<String> buffer = new ArrayList<>();

        for (File f : )) {

            BasicFileAttributes attributes;
            try {
                attributes = Files.readAttributes(Paths.get(f.getPath()), BasicFileAttributes.class);

                FileTime creTime = attributes.creationTime();
                FileSystemScannerAtributes attr = new FileSystemScannerAtributes();

                attr.setFileSize(attributes.size());
                attr.setCreationTime(creTime.toString());
                attr.setFileName(f.getName());
                attr.setModifiedTime(attributes.lastModifiedTime().toString());
                attr.setFiletype(Files.probeContentType(Paths.get(f.getPath())));

                buffer.add(attr.toString());

            } catch (IOException ex) {
                Logger.getLogger(InputController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return buffer;
*/
    }

    private static boolean isDirEmpty(final Path actual) throws IOException {
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(actual)) {
            return !dirStream.iterator().hasNext();
        }
    }

}
