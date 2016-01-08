
import registry.Registry;
import utils.ArgumentValidator;
import utils.Settings;
import utils.Writer;
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

        ArgumentValidator val = new ArgumentValidator(args);

        if (val.Validation() == true) {

            Registry.getInstance().set("filepath", args[3]);
            Writer.colorStack.add(Writer.COLOR_WHITE);

            Settings settings = new Settings(
                    1,
                    1,
                    Integer.parseInt(args[0]),
                    Integer.parseInt(args[1]),
                    args[2],
                    Integer.parseInt(args[4])
            );

            Registry.getInstance().set("app.settings", settings);
            Registry.getInstance().set("frame.factory", new FrameFactory((Settings) Registry.getInstance().get("app.settings")));

            Application app = new Application(settings);
            app.start();

        }

    }

}
