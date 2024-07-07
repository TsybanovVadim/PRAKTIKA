import java.math.BigDecimal;

public class City {
    private int id;
    private String name;
    private int foundationYear;
    private BigDecimal area;

    public City(int id, String name, int foundationYear, BigDecimal area) {
        this.id = id;
        this.name = name;
        this.foundationYear = foundationYear;
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }
}