/*В символьном файле находится информация об N числах с плавающей запятой
с указанием локали каждого числа отдельно. Прочитать информацию из файла.
Проверить на корректность, то есть являются ли числа числами. Преобразовать
к числовымзначениями вычислить сумму и среднее значениепрочитанных чисел.
Создать собственный класс исключения. Предусмотреть обработку исключений, возникающих при нехватке памяти,
отсутствии самого файла по заданному адресу, отсутствии или некорректности требуемой записи в файле, недопустимом значении числа (выходящим за пределы максимально допустимых
значений) и т.д. */





import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;

class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }
}

class OutOfMemoryException extends Exception {
    public OutOfMemoryException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\TWT\\IdeaProjects\\chapter9\\src\\file";
        File file = new File(path);
        double sum = 0;
        int count = 0;

        try {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;

                while ((line = br.readLine())!= null) {
                    try {
                        String[] parts = line.split("\\s+");
                        for (String part : parts) {
                            try {
                                double number = Double.parseDouble(part);
                                if (Double.isInfinite(number) || Double.isNaN(number)) {
                                    throw new InvalidNumberException("Недопустимое значение числа: " + part);
                                }
                                sum += number;
                                count++;
                            } catch (NumberFormatException e) {
                                throw new InvalidNumberException("Некоректное число: " + part);
                            }
                        }
                    } catch (InvalidNumberException e) {
                        System.err.println(e.getMessage());
                    }
                }

                br.close();
            } catch (OutOfMemoryError e) {
                throw new OutOfMemoryException("Не хватает памяти");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + file);
        } catch (IOException e) {
            System.err.println("Ошибка чтения: " + file);
        } catch (OutOfMemoryException e) {
            System.err.println(e.getMessage());
        }

        double average = count > 0? sum / count : 0;
        System.out.println("Сумма: " + sum);
        System.out.println("Среднее значение: " + average);
    }
}