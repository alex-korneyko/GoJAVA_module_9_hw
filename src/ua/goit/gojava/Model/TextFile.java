package ua.goit.gojava.Model;

import java.util.Date;

/**
 * Class {@code TextFile} inherited from class {@code File}
 * and may contain only text-data
 * @version 2.0 01.04.2016
 * @author Alex Korneyko
 */
public class TextFile extends File {

    private String textCodePage;                        //Кодировка

    public TextFile(String textCodePage) {
        this.textCodePage = textCodePage;
    }

    public TextFile(String fileName, int fileSize, Date createFileDate, boolean readOnly,
                    boolean hidden, String textCodePage) {

        super(fileName, fileSize, createFileDate, readOnly, hidden);
        this.textCodePage = textCodePage;
    }

    public String getTextCodePage() {
        return textCodePage;
    }

    public void setTextCodePage(String textCodePage) {
        if (textCodePage.length() > 255){
            throw new IllegalArgumentException();
        }
        this.textCodePage = textCodePage;
    }

    @Override
    public String toString() {
        return super.toString() + "fileType=text " +
                "textCodePage='" + textCodePage + '\'';
    }
}
