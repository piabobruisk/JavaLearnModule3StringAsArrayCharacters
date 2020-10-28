package by.epam.pia.learning.string.stringasarray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//2. Замените в строке все вхождения 'word' на 'letter'.

public class Task2 {

    private static final String FIND_WORD = "word";
    private static final String REPLACE_WORD = "letter";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("data/task2.data"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.print(line + " -> ");
                String result = findAndReplace(line);
                System.out.println(result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String findAndReplace(String line) {

        char[] chars = getCharArray(line);
        char[] findChars = getCharArray(FIND_WORD);
        char[] replaceChars = getCharArray(REPLACE_WORD);
        char[] result = new char[chars.length * 2];
        int k = 0;

        for (int i = 0; i < chars.length; i++) {
            if (findWord(chars, i, findChars)) {
                k = replaceWord(result, k, replaceChars);
                i += findChars.length - 1;
            } else {
                result[k] = chars[i];
                k++;
            }
        }
        return new String(result);
    }

    private static int replaceWord(char[] chars, int k, char[] replaceChars) {

        int j = 0;
        for (; j < replaceChars.length; j++) {
            chars[k + j] = replaceChars[j];
        }
        return k + j;
    }

    private static boolean findWord(char[] chars, int i, char[] findChars) {

        for (int j = 0; j < findChars.length; j++) {
            if (findChars[j] != chars[j + i]) return false;
        }
        return true;
    }

    private static char[] getCharArray(String str) {

        return str.toCharArray();
    }

}
