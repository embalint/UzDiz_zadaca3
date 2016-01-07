/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model;
import registry.Registry;
import scanner.FileScanner;
import scanner.FileSystemScannerAtributes;
import utils.Reader;
import utils.Settings;
import utils.Writer;

/**
 *
 * @author ahuskano
 */
public class InputController extends Controller {
    
    private Settings settings;

    public InputController(Settings settings) {
        this.settings = settings;
    }
    

    public void work() {
        String choice = "";

        do {

            Writer.resetPosition();
            choice = Reader.read("Menu item: ");
            ((Model) Registry.getInstance().get("model.info")).setString(choice);

            if (choice.equals("2")) {
                while(true){
                Thread uiThread = new Thread(new FileScanner(), "thread.scann");
                uiThread.start();
                
                
                try {
                    Thread.sleep(settings.getRefreshInterval()*1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(InputController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            }

        } while (choice != "Q");

    }

}
