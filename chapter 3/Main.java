/*
Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString(). Определить дополнительно
методы в классе, создающем массив объектов. Задать критерий выбора данных
и вывести эти данные на консоль. В каждом классе, обладающем информацией,
должно быть объявлено несколько конструкторов.
Book: id, Название, Автор(ы), Издательство, Год издания, Количество
страниц, Цена, Тип переплета.
Создать массив объектов. Вывести:
a) список книг заданного автора;
b) список книг, выпущенных заданным издательством;
c) список книг, выпущенных после заданного года.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Вывод");
        System.out.println("[1] список книг заданного автора");
        System.out.println("[2] список книг, выпущенных заданным издательством");
        System.out.println("[3] список книг, выпущенных после заданного года");

        System.out.print("Выбор действия: ");

        int choice = input.nextInt();
        input.nextLine();

        Book[] books = {
                new Book(1111, "Война и мир", "Лев Толстой", "Издатель 1",  1865, 120, 500, "ABС"),
                new Book(1456, "Горе от ума", "Александр Грибоедов", "Издатель 2", 1822, 5, 400, "VXC"),
                new Book(2954, "Отцы и дети", "Иван Тургенев", "Издатель 3", 1862, 65, 350, "ИИС"),
                new Book(9554, "Портрет Дориана Грея", "Оскар Уайльд", "Издатель 4", 1890, 50, 500, "СВAФ"),
                new Book(2332, "Преступление и наказание", "Фёдор Достоевский", "Издатель 5", 1866, 80, 250, "DDD"),
        };

        switch (choice) {
            case 1:
                System.out.print("\nВведите автора: ");
                String author = input.nextLine();

                for (Book book : books) {
                    if (book.getAuthor().equals(author)) {
                        System.out.println(book);
                    }
                }
                break;

            case 2:
                System.out.print("\nВведите издательство: ");
                String publishing = input.nextLine();

                for (Book book : books) {
                    if (book.getPublishing().equals(publishing)) {
                        System.out.println(book);
                    }
                }
                break;

            case 3:
                System.out.print("\nВведите год: ");
                int year = input.nextInt();

                for (Book book : books) {
                    if (book.getYear() > year) {
                        System.out.println(book);
                    }
                }
                break;

            default:
                System.out.println("\nНеверное число");
        }

        input.close();
    }
}


