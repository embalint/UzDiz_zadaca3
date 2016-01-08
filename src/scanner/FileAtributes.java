package scanner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emil
 */
public class FileAtributes {

    private String creationTime;
    private String fileName;
    private String filetype;
    private String modifiedTime;
    private String parent;

    private Long fileSize;
    private List<FileAtributes> childrens;

    public FileAtributes() {
    }

    public FileAtributes(String creationTime, String fileName, String filetype, Long fileSize, String modifiedTime, String parent,List<FileAtributes> childrens) {
        this.creationTime = creationTime;
        this.fileName = fileName;
        this.filetype = filetype;
        this.fileSize = fileSize;
        this.modifiedTime = modifiedTime;
        this.parent=parent;
        this.childrens = childrens;
    }
    
    public FileAtributes(String creationTime, String fileName, String filetype, Long fileSize, String modifiedTime,String parent) {
        this.creationTime = creationTime;
        this.fileName = fileName;
        this.filetype = filetype;
        this.fileSize = fileSize;
        this.modifiedTime = modifiedTime;
        this.parent=parent;
        this.childrens=new ArrayList();
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
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
        return childrens;
    }

    public void setChildrens(List<FileAtributes> childrens) {
        this.childrens = childrens;
    }
    public void addChildren(FileAtributes children) {
        this.childrens.add(children);
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
    
    public ArrayList<String> getStrings(){
        ArrayList<String> strings=new ArrayList<String>();
        for(FileAtributes item:childrens)
            strings.add(item.toString());
        return strings;
    }
    
    @Override
    public String toString() {
        return "File: " +"name=" + fileName + ", type=" + filetype + ", size=" + fileSize +  ", created=" + creationTime +", modified=" + modifiedTime + '}';
    }
    

}
