package ua.goit.gojava.Model;

import java.util.Date;

/**
 * Class {@code AudioFile} inherited from class {@code File}
 * and may contain only audio-data
 * @version 2.0 01.04.2016
 * @author Alex Korneyko
 */
public class AudioFile extends File {

    private String audioFormat;                         //Формат аудио

    public AudioFile(String audioFormat){
        this.audioFormat = audioFormat;
    }

    public AudioFile(String fileName, int fileSize, Date createFileDate, boolean readOnly,
                     boolean hidden, String audioFormat) {

        super(fileName, fileSize, createFileDate, readOnly, hidden);
        this.audioFormat = audioFormat;
    }

    public String getAudioFormat() {
        return audioFormat;
    }

    public void setAudioFormat(String audioFormat) {
        if(audioFormat.length() > 255){
            throw new IllegalArgumentException();
        }
        this.audioFormat = audioFormat;
    }

    @Override
    public String toString() {
        return super.toString() + "fileType=audio " +
                "audioFormat='" + audioFormat + '\'';
    }
}
