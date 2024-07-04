import java.util.Objects;

public class Guitar {
    private String name;
    private GuitarString guitarString;
    private Tuner pickup;

    public Guitar(String name, GuitarString guitarString, Tuner pickup) {
        this.name = name;
        this.guitarString = guitarString;
        this.pickup = pickup;
    }

    public void play() {
        System.out.println("Игра на гитаре");
    }
    public void tune() {
        System.out.println("Настройка гитары" + " c помощью: '" + pickup.getType() + "'");
    }

    public void changeString(GuitarString newString) {
        this.guitarString = newString;
        System.out.println("Струна была поменяна" + " на струну '" +  newString.getMaterial() + "'");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Guitar guitar = (Guitar) obj;
        return name.equals(guitar.name) && guitarString.equals(guitar.guitarString) && pickup.equals(guitar.pickup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, guitarString, pickup);
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "name='" + name + '\'' +
                ", guitarString=" + guitarString +
                ", tuner=" + pickup +
                '}';
    }
}