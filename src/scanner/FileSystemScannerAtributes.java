package scanner;

/**
 * @author Emil
 */
public class FileSystemScannerAtributes {

    String creationTime;
    String fileName;
    String filetype;
    Long fileSize;

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
    String modifiedTime;

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

    @Override
    public String toString() {
        return "FileSystemScannerAtributes{" + "creationTime=" + creationTime + ", fileName=" + fileName + ", filetype=" + filetype + ", fileSize=" + fileSize + ", modifiedTime=" + modifiedTime + '}';
    }
    

}
