/*
Ввести с консоли n целых чисел. На консоль вывести:
1. Четные и нечетные числа
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");

        int n = in.nextInt();
        int[] numbers = new int[n];

        System.out.print("Введите " + n + " чисел: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }

        System.out.print("Четные числа: ");
        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.print(number + " ");
            }
        }

        System.out.print("\nНечетные числа: ");
        for (int number : numbers) {
            if (number % 2 != 0) {
                System.out.print(number + " ");
            }
        }
    }
}