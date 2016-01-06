
import registry.Registry;
import utils.Settings;
import view.FrameFactory;

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

        Settings settings = new Settings(1, 1, 30, 100, "O", 2);
        Registry.getInstance().set("app.settings", settings);
        Registry.getInstance().set("frame.factory", new FrameFactory((Settings) Registry.getInstance().get("app.settings")));

        Application app = new Application(settings);
        app.start();

    }

}
