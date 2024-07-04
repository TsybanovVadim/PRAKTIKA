/*
Вариант B
9. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.
Осуществить проверку корректности ввода чисел.
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите число от 1 до 12: ");
        int number = input.nextInt();

        String month;
        if (number < 1 || number > 12) {
            System.out.println("Введенное число не входит в диапазон");
        }
        else {
            month = months(number);
            System.out.print("Месяц: " + month);
        }

    }
    public static String months(int number) {
        switch (number) {
            case 1:
                return "Январь";
            case 2:
                return "Февраль";
            case 3:
                return "Март";
            case 4:
                return "Апрель";
            case 5:
                return "Май";
            case 6:
                return "Июнь";
            case 7:
                return "Июль";
            case 8:
                return "Август";
            case 9:
                return "Сентябрь";
            case 10:
                return "Октябрь";
            case 11:
                return "Ноябрь";
            case 12:
                return "Декабрь";
            default:
                return "Введенное число не входит в диапазон";
        }
    }
}