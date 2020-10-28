package by.epam.pia.learning.string.stringasarray;

//5. Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов
// заменить на одиночные пробелы. Крайние пробелы в строке удалить.

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task5 {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("data/task5.data"))) { //можно тот же файл что и для предыдущей задачи
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.print("[" + line + "] -> [");
                String result = trimSpaces(line);
                System.out.println(result + "]");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String trimSpaces(String line) {

        char[] chars = getCharArray(line);
        char[] result = new char[chars.length];
        int k = 0;
        for (int i = 0, charsLength = chars.length; i < charsLength; i++) {
            int spaces;
            if (chars[i] == ' ') {
                spaces = getNumberSpaces(chars, i);
                int tmpIndex = i + spaces - 1;
                if (i != 0 && tmpIndex != charsLength - 1) {
                    result[k] = ' ';
                    k++;
                }
                i = tmpIndex;
            } else {
                result[k] = chars[i];
                k++;
            }
        }
        return new String(result);
    }

    private static int getNumberSpaces(char[] chars, int i) {

        int result = 0;
        int len = chars.length;
        while (i + result < len && chars[i + result] == ' ') {
            result++;
        }
        return result;
    }

    private static char[] getCharArray(String str) {

        return str.toCharArray();
    }
}
