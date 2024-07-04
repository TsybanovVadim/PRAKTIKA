/*8. Прочитать текст Java-программы и удалить из него все лишние пробелы
и табуляции, оставив только необходимые для разделения операторов.*/

import java.io.*;

public class Main {
    public static void main(String[] args) {

        String pathInputFile = "C:\\Users\\TWT\\IdeaProjects\\chapter10\\src\\inputFile";
        String pathOutputFile = "C:\\Users\\TWT\\IdeaProjects\\chapter10\\src\\outputFile";
        File inputFile = new File(pathInputFile);
        File outputFile = new File(pathOutputFile);

        try {
            if (!inputFile.exists()) {
                throw new FileNotFoundException("Input file not found: " + pathInputFile);
            }
            if (!outputFile.exists()) {
                throw new FileNotFoundException("Output file not found: " + pathOutputFile);
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String trimmedLine = line.replaceAll("\\s+", " ");
                    writer.write(trimmedLine);
                    writer.newLine();
                }
                System.out.println("Программа успешно завершила удаление лишних пробелов и табуляций из текста.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: файл не найден - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        }

    }
}
