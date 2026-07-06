import java.time.LocalDate;

// Задание №1
public class Товар {
    String name;
    String production_date;
    String create_country;
    int price;
    Boolean booking_status;
    public Товар(String name, String production_date, String create_country, int price, Boolean booking_status) {
        this.name = name;
        this.production_date = production_date;
        this.create_country = create_country;
        this.price = price;
        this.booking_status = booking_status;
    }
    public void tovar_info(){
        System.out.println("Название товара: " + name);
        System.out.println(" Дата изготовления: " + production_date);
        System.out.println(" Страна производитель " + create_country);
        System.out.println(" Стоимость: " + price + "$");
        System.out.println(" Статус Заказа: " + booking_status);
    }

    public static void main(String[] args) {
        Товар mashina = new Товар("Тойота", "03.07.2026", "США", 25, false);
        mashina.tovar_info();

        Товар[] tovarMassive = new Товар[5];
        tovarMassive[0] = new Товар("Samsung S25 Ultra", "01.02.2025", "Korea", 5599, true);
        tovarMassive[1] = new Товар("Xiaomi 12S Ultra", "09.06.2022", "China", 1035, false);
        tovarMassive[2] = new Товар("HUAWEI Mate 50 Pro", "06.09.2022", "China", 1299, false);
        tovarMassive[3] = new Товар("Google Pixel 7 Pro", "06.07.2022", "China", 899, true);
        tovarMassive[4] = new Товар("iPhone 14 Pro Max", "07.09.2022", "China", 1099, true);
    }
}
