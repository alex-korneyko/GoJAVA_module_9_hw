package ua.goit.gojava.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Класс директории. Содержит коллекцию файлов и несколько
 * служебных методов для генерации случайных файлов для демонстрации
 */
public class Directory {

    private String directoryName;                   //Имя директории

    public List<File> files = new ArrayList<>();    //Колеекция файлов

    //Конструктор для создания пустой директории
    public Directory(String directoryName) {
        this.directoryName = directoryName;
    }

    //Конструктор для создания директории с некоторым количеством
    //файлов сгенерированных случайным образом
    public Directory(String directoryName, int randomFilesCount) {

        int maxFileSize = 2_000_000_000;            //Максимальный размер файлов для генерации

        this.directoryName = directoryName;

        //Генерация файлов случайного типа
        for (int i = 0; i < randomFilesCount; i++) {

            switch ((int) (Math.random() * 3)) {
                case 0:
                    files.add(new AudioFile(rndAudioFormat()));
                    break;
                case 1:
                    files.add(new ImageFile(rndImageFormat()));
                    break;
                case 2:
                    files.add(new TextFile(rndCodePage()));
            }

            //Заполнение полей, общих для любого типа файла
            files.get(files.size()-1).setFileName(rndName());                           //Имя файла
            files.get(files.size()-1).setFileSize((int) (Math.random() * maxFileSize)); //Размер
            files.get(files.size()-1).setCreateFileDate(new Date());                    //Дата создания
            files.get(files.size()-1).setHidden(((int) (Math.random() * 5)) == 0);      //Скрытый
            files.get(files.size()-1).setReadOnly(((int) (Math.random() * 2)) != 0);    //Только для чтения
        }
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        if (directoryName.length() > 255) {
            throw new IllegalArgumentException("Name is too long");
        }
        this.directoryName = directoryName;
    }

    /**
     * Подсчёт общего размера директории (сумма размеров всех файлов)
     * @return сумма размеров файлов в директории
     */
    public long getDirSize() {
        long size = 0;

        for (File file : files) {
            size += file.getFileSize();
        }
        return size;
    }

    @Override
    public String toString() {
        return "Directory: '" + directoryName +
                "'; Size: " + getDirSize()+" bytes;"+" Files: "+files.size()+"pcs";
    }

    /**
     * Метод генерации случайного имени.
     * @return имя файла
     */
    private String rndName() {

        String fileName = "";

        short firstSymbolCode = 97;             //Код первой буквы в UNICODE
        short lastSymbolCode = 122;             //Код последней буквы в UNICODE
        byte minLength = 1;                     //Минимальная длина имени
        byte maxLength = 8;                     //Максимальная длина имени

        //Формула рандомного числа от min до max. Количество букв в имени файла
        int nameLength = minLength + (int) (Math.random()
                * ((maxLength - minLength) + 1));

        for (int i = minLength; i <= nameLength; i++) {

            //составленгие имени файла из случайных букв
            char symbol = (char) (firstSymbolCode + (int) (Math.random()
                    * ((lastSymbolCode - firstSymbolCode) + 1)));

            fileName += symbol;
        }

        return fileName;
    }

    /**
     * Генерация случайного формата аудиофайла
     * @return формат аудио
     */
    private String rndAudioFormat() {
        switch ((int) (Math.random() * 4)) {
            case 0:
                return "mp3";
            case 1:
                return "AAC";
            case 2:
                return "Ogg";
            default:
                return "AC3";
        }
    }

    /**
     * Генерация случайного формата изображения
     * @return  формат изображения
     */
    private String rndImageFormat() {
        switch ((int) (Math.random() * 4)) {
            case 0:
                return "jpg";
            case 1:
                return "png";
            case 2:
                return "gif";
            default:
                return "bmp";
        }
    }

    /**
     * Генерация случайной кодировки текстового файла
     * @return кодировка текста
     */
    private String rndCodePage() {
        switch ((int) (Math.random() * 3)) {
            case 0:
                return "UNICODE";
            case 1:
                return "ASCII";
            default:
                return "Win-1251";
        }
    }
}
