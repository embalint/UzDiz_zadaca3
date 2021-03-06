/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import iterator.ItemContainer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Model;
import newFunctionality.TotalArea;
import registry.Registry;
import scanner.FileScanner;
import utils.Comparator;
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
        boolean flag = (boolean) this.get("thread.scan.active");

        do {

            if (flag) {
                Writer.colorStack.add(Writer.COLOR_GREEN);
            } else {
                Writer.colorStack.add(Writer.COLOR_YELLOW);
            }

            ((Frame) this.get("frame.input")).clearAndShowBorders();
            Writer.position(((Frame) this.get("frame.input")).getWriterStartPosition());

            Writer.printColorCode(Writer.getActiveColor());
            choice = Reader.read();
            Writer.colorStack.pop();

            ((Model) Registry.getInstance().get("model.info")).setString(choice);
            FileScanner fs = new FileScanner();

            ItemContainer container = (ItemContainer) Registry.getInstance().get("model.structure.iterator");

            switch (choice) {
                case "1":
                    container.setItems(fs.getFileList());
                    ArrayList<String> infoData = new ArrayList();
                    infoData.add("Directories: " + container.getDirectoriesNumber());
                    infoData.add("Files: " + container.getFilesNumber());
                    ((Model) Registry.getInstance().get("model.info")).setBuffer(infoData);
                    
                    break;

                case "2":
                    ((Model) Registry.getInstance().get("model.structure")).setBuffer(container.getStrings());
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
                    
                    ((Model) Registry.getInstance().get("model.structure")).setBuffer(container.getMementoInfo());
                    break;

                case "6":
                    ((Model) Registry.getInstance().get("model.info")).setString("Provide value in format 6 M");
                    break;

                case "7":
                    ((Model) Registry.getInstance().get("model.info")).setString("Provide value in format 7 N");
                    break;

                case "8":
                    container.setItems(fs.getFileList());
                    container.saveToMemento();
                    ((Model) Registry.getInstance().get("model.structure")).setBuffer(container.getStrings());
                    break;

                case "9":
                    TotalArea total = new TotalArea();
                    ((Model) Registry.getInstance().get("model.info")).setString("Total area of all shapes " + total.totalArea());

                    break;

                default:

                    if (choice.contains("6 ")) {
                        choice = choice.replace("6 ", "");
                        ((Model) Registry.getInstance().get("model.info")).setString("Set to: " + choice);
                        container.retriveFromMemento(Integer.valueOf(choice)-1);
                    }

                    if (choice.contains("7 ")) {
                        choice = choice.replace("7 ", "");
                        ((Model) Registry.getInstance().get("model.info")).setString("Compare current to: " + choice);
                        ArrayList<String> buffer=Comparator.compare(container.getFromMemento(Integer.valueOf(choice)-1),container.getItems());
                        ((Model) Registry.getInstance().get("model.structure")).setBuffer(buffer);
                    }

            }
        } while (choice != "Q");

    }

}
