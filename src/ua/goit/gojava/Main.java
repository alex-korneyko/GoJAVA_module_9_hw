package ua.goit.gojava;

import ua.goit.gojava.Model.Directory;
import ua.goit.gojava.Model.File;

public class Main {
    public static void main(String[] args) {

        //Создание директории. Указывается имя директории и количество файлов в ней
        //Файл будут создаваться случайным образом, параметры файлов тоже случайные
        Directory directory1 = new Directory("First", 5);

        String allFilesString = "";         //Строка, которая будет содержать инфо всех файлов

        //Наполнение строки
        for (File file : directory1.files) {
            allFilesString += file + "\n";
        }

        //Печать строки, в которой инфо всех файлов
        System.out.println("Source string:");
        System.out.println(allFilesString);

        //Шифрование и вывод строки
        allFilesString = SuperCiphers.Caesar(allFilesString, 10, true);
        System.out.println("Encrypted string:");
        System.out.println(allFilesString+"\n");

        //Дешифрование и вывод строки
        allFilesString = SuperCiphers.Caesar(allFilesString, 10, false);
        System.out.println("Decrypted string");
        System.out.println(allFilesString);


    }
}

