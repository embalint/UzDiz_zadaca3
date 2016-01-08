/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import iterator.ItemContainer;
import java.util.ArrayList;
import model.Model;
import newFunctionality.TotalArea;
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
        boolean flag;

        do {

            ((Frame) this.get("frame.input")).clearAndShowBorders();
            Writer.position(((Frame) this.get("frame.input")).getWriterStartPosition());

            choice = Reader.read();
            ((Model) Registry.getInstance().get("model.info")).setString(choice);

            switch (choice) {
                case "1":
                    break;

                case "2":
                    FileScanner fs = new FileScanner();
                    ItemContainer iterator = new ItemContainer();
                    iterator.setItems(fs.getFileList());

                    ArrayList<String> fileList = iterator.getStrings();
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
                    TotalArea total = new TotalArea();
                    ((Model) Registry.getInstance().get("model.info")).setString("Total area of all shapes " + total.totalArea());

                    break;

            }
        } while (choice != "Q");

    }

}
