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
import scanner.FileSystemScannerAtributes;
import utils.Reader;
import utils.Writer;
import view.Frame;

/**
 *
 * @author ahuskano
 */
public class InputController extends Controller {

    public void work() {
        String choice = "";

        do {

            Writer.clear((Frame) this.get("frame.input"));
            Writer.resetPosition();
            choice = Reader.read("Menu item: ");
            ((Model) Registry.getInstance().get("model.info")).setString(choice);

            if (choice.equals("2")) {
                ArrayList<String> buffer = new ArrayList<>();
                File actual = new File((String) this.get("filepath"));
                for (File f : actual.listFiles()) {

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

                ((Model) Registry.getInstance().get("model.structure")).setBuffer(buffer);
            }

        } while (choice != "0");

    }

}
