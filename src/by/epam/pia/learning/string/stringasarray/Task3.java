package by.epam.pia.learning.string.stringasarray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//3. В строке найти количество цифр.

public class Task3 {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("data/task3.data"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.print(line + " -> ");
                int result = findDigits(line);
                System.out.println( "Цифр в строке:"+result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int findDigits(String line) {

        char[] chars = getCharArray(line);
        int digits=0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                digits++;
            }
        }
        return digits;
    }

    private static char[] getCharArray(String str) {

        return str.toCharArray();
    }
}
