/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

import controller.Controller;
import controller.InputController;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model;
import registry.Registry;

/**
 *
 * @author Emil
 */
public class FileScanner extends Controller {

    File actual = new File((String) this.get("filepath"));

    @Override
    public void work() {

        ArrayList<String> buffer = new ArrayList<>();

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

    private static boolean isDirEmpty(final Path actual) throws IOException {
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(actual)) {
            return !dirStream.iterator().hasNext();
        }
    }

}
