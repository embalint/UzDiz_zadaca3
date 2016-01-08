/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Model;
import registry.Registry;
import scanner.FileScanner;
import utils.Reader;
import utils.Settings;
import utils.Writer;
import view.Frame;

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

            Writer.clear((Frame) this.get("frame.input"));
            Writer.resetPosition();

            boolean flag;
            
            choice = Reader.read("Menu item: ");
            ((Model) Registry.getInstance().get("model.info")).setString(choice);

            switch (choice) {
                case "1":
                    break;

                case "2":
                    FileScanner fs = new FileScanner();
                    ArrayList<String> fileList = fs.getFileList();
                    ((Model) Registry.getInstance().get("model.structure")).setBuffer(fileList);
                    break;

                case "3":
                    // Set scan flag
                    Registry.getInstance().set("thread.scan.active", true);
                    flag = (boolean) Registry.getInstance().get("thread.scan.active");
                    ((Model) Registry.getInstance().get("model.info")).setString("Scan thread active: " + flag);
                    break;

                case "4":
                    Registry.getInstance().set("thread.scan.active", false);
                    flag = (boolean) Registry.getInstance().get("thread.scan.active");
                    ((Model) Registry.getInstance().get("model.info")).setString("Scan thread active: " + flag);
                    break;

                case "5":
                    break;

                case "6":
                    break;

                case "7":
                    break;

                case "8":
                    break;

                case "9":
                    break;

            }
        } while (choice != "Q");

    }

}
