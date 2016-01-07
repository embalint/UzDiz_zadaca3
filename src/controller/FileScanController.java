package controller;

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

        boolean flag = (boolean) this.get("thread.scan.active");
        if (flag) {

            ArrayList<String> fileList = fs.getFileList();
            ((Model) Registry.getInstance().get("model.structure")).setBuffer(fileList);

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
