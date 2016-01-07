package scanner;

/**
 * @author Emil
 */
public class FileAtributes {

    private String creationTime;
    private String fileName;
    private String filetype;
    private Long fileSize;
    private String modifiedTime;

    public FileAtributes() {
    }

    public FileAtributes(String creationTime, String fileName, String filetype, Long fileSize, String modifiedTime) {
        this.creationTime = creationTime;
        this.fileName = fileName;
        this.filetype = filetype;
        this.fileSize = fileSize;
        this.modifiedTime = modifiedTime;
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

    @Override
    public String toString() {
                return "File " + fileName + '}';
//        return "FileSystemScannerAtributes{" + "creationTime=" + creationTime + ", fileName=" + fileName + ", filetype=" + filetype + ", fileSize=" + fileSize + ", modifiedTime=" + modifiedTime + '}';
    }
    

}
