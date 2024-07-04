/*
Разработать проект управления процессами на основе создания и реализации интерфейсов для следующих предметных областей:
Письма. Возможности:
создать/удалить письмо,
добавить/удалить отправителя;
добавить текст письма;
добавить/удалить приложения к письму;
поставить дату отправки;
отправить/принять письмо;
проверить адресат на существование.
Добавить специализированные методы для Заказного письма.
*/


// Interface for managing letters
interface Letter {
    void createLetter(String Theme);
    void deleteLetter();

    void addSender(String sender);
    void removeSender();

    void addText(String text);

    void addAttachment(String attachment);
    void removeAttachment();

    void setDate(int date_day, int date_month, int date_year);

    void sendLetter();
    void acceptLetter();

    void checkAddresseeExistence(String addressee);
}
interface RegisteredMail extends Letter {
    void addTracknumber(int track);
}

class ThisLetter implements RegisteredMail {

    private String Theme;
    private String sender;
    private String text;
    private String attachment;
    private int date_day;
    private int date_month;
    private int date_year;
    private String adress = "Mark";
    private int track;



    @Override
    public void createLetter(String Theme) {
        this.Theme = Theme;
        System.out.println("Cоздано письмо");
        System.out.println("Тема: " + Theme);

    }

    @Override
    public void deleteLetter() {
        System.out.println("Письмо удалено");
    }

    @Override
    public void addSender(String sender) {
        this.sender = sender;
        System.out.println("Отправитель был добавлен: " + sender);


    }

    @Override
    public void removeSender() {
        this.sender = null;
        System.out.println("Отправитель был удален");
    }

    @Override
    public void addText(String text) {
        this.text = text;
        System.out.println("Содержание письма: " + this.text);


    }

    @Override
    public void addAttachment(String attachment) {
        this.attachment = attachment;
        System.out.println("Было добавлено приложение: " + this.attachment);
    }

    @Override
    public void removeAttachment() {
        this.attachment = null;
        System.out.println("Приложение было удалено");

    }

    @Override
    public void setDate(int date_day, int date_month, int date_year) {
        this.date_day = date_day;
        this.date_month = date_month;
        this.date_year = date_year;
        System.out.println("Выставлена дата: " + date_day + "." + date_month + "." + date_year);

    }

    @Override
    public void sendLetter() {
        System.out.println("Сообщение отправлено");
    }

    @Override
    public void acceptLetter() {
        System.out.println("Сообщение принято");
    }

    @Override
    public void checkAddresseeExistence(String addressee) {
        if (this.adress == addressee) {
            System.out.println("Адрес " + addressee + " был найден");


        }
        else
            System.out.println("Адрес " + addressee + " не был найден");
    }
    @Override
    public void addTracknumber(int track) {
        this.track = track;
        System.out.println("Трек-номер " + track + " присвоен ");

    }

}


public class Main {
    public static void main(String[] args) {
        ThisLetter myLetter = new ThisLetter();
        myLetter.createLetter("About Something");
        myLetter.addSender("Somebody");
        myLetter.addText("Hello...");
        myLetter.addAttachment("NameCO Price List");
        myLetter.setDate(15, 11,2024);
        myLetter.checkAddresseeExistence("Mark");
        myLetter.addTracknumber(12365489);

        myLetter.sendLetter();
        myLetter.acceptLetter();

        myLetter.deleteLetter();
        myLetter.removeSender();
        myLetter.removeAttachment();
    }
}