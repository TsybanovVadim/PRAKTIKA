import java.util.Objects;

/*Создать приложение, удовлетворяющее требованиям, приведенным в задании. Наследование применять только в тех заданиях, в которых это логически
обосновано. Аргументировать принадлежность классу каждого создаваемого
метода и корректно переопределить для каждого класса методы equals(),
hashCode(), toString().
Создать объект класса Гитара, используя классы Струна, Тюнер.
Методы: играть, настраивать, заменять струну.*/

public class Main {
    public static void main(String[] args) {
        GuitarString string = new GuitarString("Железо");
        Tuner tuner = new Tuner("Classic Tuner");
        Guitar guitar = new Guitar("Акустика - классик", string, tuner);
        System.out.println(guitar.toString());
        guitar.play();
        guitar.tune();
        GuitarString newString = new GuitarString("Нейлон");
        guitar.changeString(newString);
        System.out.println(guitar.toString());

    }
}