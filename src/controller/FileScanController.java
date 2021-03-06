package controller;

import iterator.ItemContainer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model;
import registry.Registry;
import scanner.FileScanner;
import utils.Settings;

/**
 *
 * @author zoka123
 */
public class FileScanController extends Controller {

    @Override
    public void work() {

        FileScanner fs = new FileScanner();
        while (true) {
            boolean flag = (boolean) this.get("thread.scan.active");

            if (flag) {

                ((Model) Registry.getInstance().get("model.info")).setString("Scan started");
                ItemContainer container=(ItemContainer) Registry.getInstance().get("model.structure.iterator");
                container.setItems(fs.getFileList());                
                container.saveToMemento();
                ((Model) Registry.getInstance().get("model.structure")).setBuffer(container.getStrings());
                ((Model) Registry.getInstance().get("model.info")).setString("Scan finished");

                try {
                    Thread.sleep(((Settings) this.get("app.settings")).getRefreshInterval() * 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FileScanController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {

                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FileScanController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

    }

}
