package by.epam.pia.learning.string.stringasarray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//4. В строке найти количество чисел.

public class Task4 {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("data/task3.data"))) { //можно тот же файл что и для предыдущей задачи
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.print(line + " -> ");
                int result = findNumbers(line);
                System.out.println("Чисел в строке:" + result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int findNumbers(String line) {

        char[] chars = getCharArray(line);
        int numbers = 0;
        for (int i = 0, charsLength = chars.length; i < charsLength; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                numbers++;
                int rank = getRank(chars, i);
                i += rank - 1;
            }
        }
        return numbers;
    }

    private static int getRank(char[] chars, int i) {

        int rank = 0;
        int len = chars.length;
        while (i + rank < len && (chars[i + rank] >= '0' && chars[i] <= '9')) {
            rank++;
        }
        return rank;
    }

    private static char[] getCharArray(String str) {

        return str.toCharArray();
    }
}
