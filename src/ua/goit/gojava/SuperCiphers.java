package ua.goit.gojava;

import java.util.Arrays;

/**
 * Класс различных алгоритмов шифрования
 */
public class SuperCiphers {

    private static final int ALPHABET_POWER = 65536;

    /**
     * Алгоритм шифрования по методу Цезаря
     *
     * @param string     строка подлежащая шифрованию или дешифрованию
     * @param shift      ключ шифрования
     * @param encryption действие - true - шифрование, false - дешифрование
     * @return обработанная строка
     */
    public static String Caesar(String string, int shift, boolean encryption) {

        //Если encryption==true, то это шифрование, производится сдвиг по алфавиту вправо
        //если false, то влево.
        shift = encryption ? shift : shift * (-1);

        //Алгоритм шифрования
        char[] charString = string.toCharArray();       //массив символов из входной строки
        String result = "";                             //для зашифрованной строки

        //Шифрование
        for (int i = 0; i < charString.length; i++) {

            /*
            * формула: y = (x + k)MOD ap
            * где:  y - зашифрованный символ
            *       x - шифруемый символ
            *       k - сдвиг относительно шифруемого символа
            *       ap - мощность алфавита (к-во символов)
            */
            charString[i] = (char) ((charString[i] + shift) % ALPHABET_POWER);

            //Формирование строки с шифрованным текстом
            result += charString[i];
        }
        return result;
    }
}
