package ua.goit.gojava.View;

import ua.goit.gojava.Model.*;

import java.text.SimpleDateFormat;

/**
 * Класс, выводящий в консоль содержимое коллекции файлов
 */
public class ShowDirectory {

    /**
     * Вывод с использованием переопределённых методов toString в объектах коллекции
     *
     * @param directory объект директория с коллекцией файлов
     */
    public static void asLines(Directory directory) {

        if (directory == null) return;

        System.out.println(directory + "\n");

        String allFilesString = "";

        for (File file : directory.files) {
            allFilesString += file + "\n";
        }
        System.out.println(allFilesString);


    }

    /**
     * Форматированный вывод коллекции в виде таблицы
     *
     * @param directory   объект директория с коллекцией файлов
     * @param columnWidth ширина колонок в таблице
     */
    public static void asTable(Directory directory, int columnWidth) {

        if (directory == null) return;

        System.out.println(directory + "\n");

        //Форматирование вывода времени создания файла
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");

        //Заголовок таблицы
        System.out.println("|" + addSpaces("File name", columnWidth) +
                "|" + addSpaces("Size", columnWidth) +
                "|" + addSpaces("Date", columnWidth) +
                "|" + addSpaces("Attributes", columnWidth) +
                "|" + addSpaces("File Type", columnWidth) +
                "|");

        //Вывод параметров каждого файла в таблицу
        for (File file : directory.files) {

            //Создание строки для вывода
            String outputString = "|" + addSpaces(file.getFileName(), columnWidth);
            outputString += "|" + addSpaces(String.valueOf(file.getFileSize()), columnWidth);
            outputString += "|" + addSpaces(String.valueOf(dateFormat.format(file.getCreateFileDate())), columnWidth);
            outputString += "|" + addSpaces(
                    ((file.isHidden() ? "hd " : "   ") + (file.isReadOnly() ? "ro" : "   ")), columnWidth);

            //Вспомогательная подстрока, в которой формируется тип и формат файла
            String fileType = "";

            if (file instanceof AudioFile) {
                fileType = "Audio(" + ((AudioFile) file).getAudioFormat() + ")";
            }
            if (file instanceof ImageFile) {
                fileType = "Image(" + ((ImageFile) file).getImageFileFormat() + ")";
            }
            if (file instanceof TextFile) {
                fileType = "Text(" + ((TextFile) file).getTextCodePage() + ")";
            }

            //Присоединение вспомогательной строки к основной
            outputString += "|" + addSpaces(fileType, columnWidth);
            outputString += "|";

            //Вывод в консоль созданной отформатированной строки с параметрами текущего файла
            System.out.println(outputString);
        }
        System.out.println("Done!\n");
    }

    /**
     * Метод добавляющий в конец строки пробелы для получения строки
     * строго заданной длинны
     *
     * @param text      строка произвольной длинны
     * @param reqLength необходимая длинна результирующей строки
     * @return строка строгой длинны, дополненная пробелами
     */
    private static String addSpaces(String text, int reqLength) {
        String lengthenedString = text;

        //Добавление пробелов, пока длинна строки не совпадёт с необходимой длинной
        for (int i = text.length(); i < reqLength; i++) {
            lengthenedString += " ";
        }
        return lengthenedString;
    }
}
