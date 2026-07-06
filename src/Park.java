public class Park {
    String parkName;
    public Park(){}
    public Park(String parkName) {
        this.parkName = parkName;
    }
    public class Attractions {
        String name;
        String timeWork;
        int price;
        public Attractions(String name, String timeWork, int price){
            this.name = name;
            this.timeWork = timeWork;
            this.price = price;
        }
        public void attractInfo() {
            System.out.println("Название парка: " + parkName + " Название аттракциона: " + name + " Время работы: " + timeWork + " Цена: " + price + " рублей");
        }
    }


    public static void main(String[] args) {
    Park park1 = new Park("Парк Маяковского");
    Park.Attractions Американские_горки = park1.new Attractions("Американские горки", "10-22", 150);

    Park park2 = new Park("Сочи Парк");
    Park.Attractions Квантовый_Скачок = park2.new Attractions("Квантовый скачок", "10 - 21", 800);
    Park.Attractions Змей_Горыныч = park2.new Attractions("Змей Горыныч", "10:30 - 20:30", 800);

    Park park3 = new Park("Остров Мечты");
    Park.Attractions Полёт_в_тоннеле = park3.new Attractions("Полёт в тоннеле", "12-22", 500);
    Park.Attractions Кобра = park3.new Attractions("Кобра", "11-21", 400);

    Park park4 = new Park("Диснейленд Париж");
    Park.Attractions Гора_Звёздного_Войска = park4.new Attractions("Гора Звёздного Войска", "09-23", 1500);

    Американские_горки.attractInfo();
    Квантовый_Скачок.attractInfo();
    Змей_Горыныч.attractInfo();
    Полёт_в_тоннеле.attractInfo();
    Кобра.attractInfo();
    Гора_Звёздного_Войска.attractInfo();
    }
}
