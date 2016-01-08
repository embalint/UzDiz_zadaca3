package scanner;

import iterator.ItemContainer;
import iterator.Iterator;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import utils.Writer;

/**
 * @author Emil
 */
public class FileAtributes {

    private static String separate = "  ";

    private long creationTime;
    private String fileName;
    private String filetype;
    private String modifiedTime;
    private String parent;
    private int level;

    private Long fileSize;
    private ItemContainer container = new ItemContainer();

    public FileAtributes() {
    }

    public FileAtributes(long creationTime, String fileName, String filetype, Long fileSize, String modifiedTime, String parent, List<FileAtributes> childrens) {
        this.creationTime = creationTime;
        this.fileName = fileName;
        this.filetype = filetype;
        this.fileSize = fileSize;
        this.modifiedTime = modifiedTime;
        this.parent = parent;
        container.addItems(childrens);
    }

    public FileAtributes(long creationTime, String fileName, String filetype, Long fileSize, String modifiedTime, String parent, int level) {
        this.creationTime = creationTime;
        this.fileName = fileName;
        this.filetype = filetype;
        this.fileSize = fileSize;
        this.modifiedTime = modifiedTime;
        this.parent = parent;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public List<FileAtributes> getChildrens() {
        return container.getItems();
    }

    public void setChildrens(List<FileAtributes> childrens) {
        container.addItems(childrens);
    }

    public void addChildren(FileAtributes children) {
        container.addItem(children);
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public boolean isDirectory() {
        return this.filetype.equals(FileScanner.directory_key) ? true : false;
    }

    public ArrayList<String> getStrings() {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add(this.toString());
        Iterator iterator = container.getIterator();
        while (iterator.hasNext()) {
            FileAtributes item = iterator.next();
            if (item.getChildrens().size() > 0) {
                strings.addAll(item.getStrings());
            } else {
                strings.add(item.toString());
            }
        }
        return strings;
    }

    public int getDirectoriesNumber() {
        int number = this.filetype.equals(FileScanner.directory_key) ? 1 : 0;
        Iterator iterator = container.getIterator();
        while (iterator.hasNext()) {
            FileAtributes item = iterator.next();
            if (item.getChildrens().size() > 0) {
                number += item.getDirectoriesNumber();
            } else {
                if (item.isDirectory()) {
                    number += 1;
                }
            }
        }
        return number;
    }

    public int getFilesNumber() {
        int number = this.filetype.equals(FileScanner.directory_key) ? 0 : 1;
        Iterator iterator = container.getIterator();
        while (iterator.hasNext()) {
            FileAtributes item = iterator.next();
            if (item.getChildrens().size() > 0) {
                number += item.getFilesNumber();
            } else {
                if (!item.isDirectory()) {
                    number += 1;
                }
            }
        }
        return number;
    }

    @Override
    public String toString() {
        String colorCode = "";

        if (isDirectory()) {
            colorCode = Writer.ANSI_ESC + Writer.COLOR_GREEN + "m";
        } else {
            colorCode = Writer.ANSI_ESC + Writer.COLOR_YELLOW + "m";
        }

        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String dateCreated = df.format(creationTime);

        return String.join("", Collections.nCopies(level, separate))
                + colorCode
                + fileName
                + " " + dateCreated
                + " " + String.format("%,d", fileSize).replace(",", ".");
    }

}
