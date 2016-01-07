
import controller.InputController;
import controller.ViewController;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model;
import registry.Registry;
import utils.Settings;
import view.Frame;
import view.FrameFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zoka123
 */
public class Application {

    private Settings settings;

    public Application(Settings settings) {
        this.settings = settings;
    }

    private void setup() {
        Registry.getInstance().set("model.structure", new Model());
        Registry.getInstance().set("model.info", new Model());
    }

    private Object get(String key) {
        return Registry.getInstance().get(key);
    }

    public void start() {

        setup();

        Thread uiThread = new Thread(new ViewController(), "thread.view");
        uiThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }

        InputController ctl = new InputController(settings);
        ctl.work();

    }

}
