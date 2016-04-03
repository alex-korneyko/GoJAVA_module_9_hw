package ua.goit.gojava.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class {@code File} is super-class for all files
 * @version 2.0 01.04.2016
 * @author Alex Korneyko
 */
public abstract class File {

    private String fileName;            //имя файла
    private int fileSize;               //размер файла
    private Date createFileDate;        //дата создания
    private boolean readOnly;           //флаг "только для чтения"
    private boolean hidden;             //флаг "скрытый"


    public File() {}

    public File(String fileName, int fileSize, Date createFileDate, boolean readOnly, boolean hidden) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.createFileDate = createFileDate;
        this.readOnly = readOnly;
        this.hidden = hidden;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        if(fileName.length() > 255){
            throw new IllegalArgumentException();
        }

        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public Date getCreateFileDate() {
        return createFileDate;
    }

    public void setCreateFileDate(Date createFileDate) {
        this.createFileDate = createFileDate;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        return "fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", createFileDate=" + dateFormat.format(createFileDate) +
                ", readOnly=" + readOnly +
                ", hidden=" + hidden + ", ";
    }


}
