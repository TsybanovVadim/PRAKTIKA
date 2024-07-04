/* 15. Создать класс Computer с внутренним классом, с помощью объектов которого можно хранить информацию об операционной системе, процессоре
и оперативной памяти */

public class Main {
    public static void main(String[] args) {
        Computer myComputer = new Computer("My Laptop", new Computer.Configuration("Java", "Intel Core i7", 16));
        System.out.println(myComputer.toString());

    }
}

