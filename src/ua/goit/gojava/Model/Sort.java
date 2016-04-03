package ua.goit.gojava.Model;

import java.util.List;

/**
 * Сортировка файлов в директории
 * Created by admin on 01.04.2016.
 */
public class Sort {

    /**
     * Сортировка файлов по имени
     *
     * @param directory директория с файлами для сортировки
     */
    public static void byName(Directory directory) {

        if (directory == null) return;

        //Сортировка по алгоритму 'insertion'
        for (int i = 1; i < directory.files.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (compare(directory.files.get(j - 1).getFileName(), directory.files.get(j).getFileName()) > 0) {
                    swap(directory.files, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Сортировка файлов по размеру
     *
     * @param directory директория с файлами для сортировки
     */
    public static void bySize(Directory directory) {

        if (directory == null) return;

        //Сортировка по алгоритму 'insertion'
        for (int i = 1; i < directory.files.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (compare(directory.files.get(j - 1).getFileSize(), directory.files.get(j).getFileSize()) > 0) {
                    swap(directory.files, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Универсальный метод сравнения двух объектов
     *
     * @param obj1 любой объект
     * @param obj2 любой объект
     * @return результат сравнения
     */
    private static int compare(Object obj1, Object obj2) {
        if (obj1 instanceof String && obj2 instanceof String) {
            return ((String) obj1).compareTo((String) obj2);
        }

        if (obj1 instanceof Integer && obj2 instanceof Integer) {
            return ((Integer) obj1).compareTo((Integer) obj2);
        }

        return 0;
    }

    /**
     * Обмен местами двух файлов в коллекции
     *
     * @param files  коллекция файлов
     * @param index1 позиция первого файла
     * @param index2 позиция второго файла
     */
    private static void swap(List<File> files, int index1, int index2) {
        File file = files.get(index1);
        files.remove(index1);
        files.add(index2, file);
    }
}
