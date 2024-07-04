import java.util.Objects;

public class Tuner {
    private String type;

    public Tuner(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tuner pickup = (Tuner) obj;
        return type.equals(pickup.type);
    }
    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
    @Override
    public String toString() {
        return "Tuner{" +
                "type='" + type + '\'' +
                '}';
    }
}