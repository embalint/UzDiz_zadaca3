
import controller.Controller;
import model.Model;
import utils.Settings;
import view.ParentFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ahuskano
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ParentFrame view = new ParentFrame(new Settings(1, 1, 25, 50), ParentFrame.HORIZONTAL);
        Model model = new Model();
        Controller controller = new Controller(view, model);

    }

}
