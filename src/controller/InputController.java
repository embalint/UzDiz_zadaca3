/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.util.ArrayList;
import model.Model;
import registry.Registry;
import utils.Reader;
import utils.Settings;
import utils.Writer;
import view.Frame;
import view.FrameFactory;

/**
 *
 * @author ahuskano
 */
public class InputController extends Controller {

    public void work() {
        String choice = "";

        do {

            choice = Reader.read("Menu item: ");
            ((Model) Registry.getInstance().get("model.info")).setString(choice);

            if (choice.equals("1")) {
                ArrayList<String> buffer = new ArrayList<>();
                File actual = new File(".");
                for (File f : actual.listFiles()) {
                    buffer.add(f.getName());
                }

                ((Model) Registry.getInstance().get("model.structure")).setBuffer(buffer);
            }

        } while (choice != "0");

    }

}
