import java.util.Objects;

public class GuitarString {
    private String material;


    public GuitarString(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return this.material;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GuitarString that = (GuitarString) obj;
        return material.equals(that.material);
    }
    @Override
    public int hashCode() {
        return Objects.hash(material);
    }
    @Override
    public String toString() {
        return "GuitarString{" +
                "material='" + material + '\'' +
                '}';
    }
}