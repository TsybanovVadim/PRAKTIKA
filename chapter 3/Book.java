public class Book {
    private int ID;
    private String name;
    private String author;
    private String publishing;
    private int year;
    private int quantity;
    private int price;
    private String type;


    public Book(int ID, String name, String author, String publishing, int year, int quantity, int price, String type) {
        this.ID = ID;
        this.name = name;
        this.author = author;
        this.publishing = publishing;
        this.year = year;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublishing() {
        return publishing;
    }
    public int getYear() {
        return year;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getPrice() {
        return price;
    }
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Book:" + " ID='" + ID + '\'' + " Name='" + name + '\'' + " Author='" + author + '\'' + " Year='" + year + '\'' + " Quantity='" + quantity + '\'' + " Price='" + price + '\'' +" Type='" + type;
    }
}