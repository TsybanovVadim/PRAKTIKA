/*
24. Определить сумму всех целых чисел, встречающихся в заданном тексте
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите текст: "); // fa31fds11
        String text = input.nextLine();

        int sum = 0;
        char[] arraytext = text.toCharArray();
        for(int i = 0; i < text.length(); i++) {
            if(Character.isDigit(arraytext[i])) {
                sum +=  Character.getNumericValue(arraytext[i]);
            }
            else {

            }
        }
        System.out.println("Сумма всех целых чисел: " + sum);
    }
}