/* 2. Ввести число, занести его цифры в стек. Вывести число, у которого цифры
идут в обратном порядке. */

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        int re_number = 0;
        int progress_number = 1;

        Stack<Integer> stack = new Stack<>(); // создали стэк для интов

        while (number > 0) {
            int temp = number % 10;
            stack.push(temp);
            number /= 10;
        }


        while (!stack.isEmpty()) {
            re_number = re_number + (stack.pop() * progress_number);
            progress_number *= 10;
        }
        System.out.println("Цифры в обратном порядке: " + re_number);

    }
}