package by.epam.pia.learning.string.stringasarray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.

public class Task1 {

    public static void main(String[] args) {

        //можно ли в пределах одного класса вынести чтение из файла в отдельный метод?
        //чтобы получать на выходе из метода по одной прочитанной строке.
        //и так чтобы не открывать/закрывать каждый раз поток чтения?

        try (BufferedReader reader = new BufferedReader(new FileReader("data/task1.data"))) {
            String line;
            while ((line = reader.readLine()) != null) {

                System.out.print(line +" -> ");
                String result = camelToSnake(line); //создание объекта в цикле (дорогая операция?). Объявление вынести наружу?
                System.out.println(result); // с одной стороны она не нужна, можно сразу перенести в sout, но бывает нужны
                                            // промежуточные значения. Как все-таки правильно?
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String camelToSnake(String line) {

        char[] chars = getCharArray(line);
        char[] result = new char[chars.length * 2];
        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                if (i > 0 && (chars[i - 1] <'A' || chars[i - 1] > 'Z')) {
                    result[k] = '_';
                    k++;
                }
                result[k] = (char) (chars[i] + 32);
                k++;

            } else {
                result[k] = chars[i];
                k++;
            }
        }
        return new String(result);
    }

    private static char[] getCharArray(String str) {

        return str.toCharArray();
    }
}
