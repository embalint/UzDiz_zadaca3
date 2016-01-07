/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

import java.io.File;
import java.net.URI;

/**
 *
 * @author ahuskano
 */
public class CustomFile extends File{

    public CustomFile(String pathname) {
        super(pathname);
    }

    public CustomFile(String parent, String child) {
        super(parent, child);
    }

    public CustomFile(File parent, String child) {
        super(parent, child);
    }

    public CustomFile(URI uri) {
        super(uri);
    }
    

    @Override
    public String toString() {
        return "FIle{" +this.getName()+ '}';
    }
    
    
    
}
