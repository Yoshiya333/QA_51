public class Животное {
    String name;
    //Заложенные навыки:
    public void run(int len_prep){
        System.out.println(name + " пробежал " + len_prep + "м.");
    }
    public void swim(int len_prep){
        System.out.println(name + " проплыл " + len_prep + "м.");
    }
    public static int animalCount = 0;
    public static int dogCount = 0;
    public static int catCount = 0;
    //Конструктор
    public Животное(String name) {
    this.name = name;
    animalCount += 1;
    }
}
public class Собака extends Животное {
    public Собака(String name) {
        super(name);
        dogCount += 1;
    }
    @Override
    public void swim(int len_prep) {
        if(len_prep > 10) {
            System.out.println("Собака " + name + " больше не проплывёт!");
        }
        else {
            System.out.println(name + " проплыл " + len_prep + "м.");
        }
    }
    @Override
    public void run(int len_prep) {
        if(len_prep > 500) {
            System.out.println("Собака " + name + " больше не пробежит!");
        }
        else{
            System.out.println(name + " пробежал " + len_prep + "м.");
        }
    }
}
public class Кот extends Животное {
    boolean sitost;
    int appetite;
    public Кот (String name, int appetite) {
        super(name);
        this.appetite = appetite;
        catCount += 1;
    }
    public void eat(Миска miska) {
        if(miska.mojnoKushats(this.appetite)) {
            this.sitost = true;
            System.out.println(name + " плотно покушал!");
        }
        else {
            System.out.println(name + " остался голодным!");
        }
    }
    @Override
    public void swim(int len_prep) {
        System.out.println("Кот " + name + " не умеет плавать!");
    }
    @Override
    public void run(int len_prep) {
        if(len_prep > 200) {
            System.out.println("Кот " + name + " больше не пробежит!");
        }
        else{
            System.out.println(name + " пробежал " + len_prep + "м.");
        }
    }
}

public class Миска {
    int food = 0;
    public Миска(int food) {
        this.food = food;
    }
    public void addFood(int amount){
        if(amount > 0){
            this.food += amount;
            System.out.println("Миска пополнена на " + amount + " единиц еды!" + " Всего еды в миске: " + food);
        }
        else {
            System.out.println("А руки-то пустые!");
        }
    }
    public void amountFood() {
        System.out.println("В миске: " + food + " единиц еды!");
    }
    public boolean mojnoKushats(int amount){
        if(amount > food){
            System.out.println("В миске недостаточно еды!");
            return false;
        }
        else{
            food -= amount;
            return true;
        }
    }
}

public void main(String[] args) {

    //Создание миски с едой:
    Миска plate1 = new Миска(0);

    //Создаём собак:
    Собака dog1 = new Собака("Бобик");
    Собака dog2 = new Собака("Рекс");

    //Создаём котов:
    Кот[] cats = {
        new Кот("Барсик", 5),
        new Кот("Кузя", 10),
        new Кот("Мурзик", 15)
    };

    //Проверка навыков:
    dog1.run(150);
    dog1.swim(300);
    cats[0].run(201);
    cats[1].swim(350);

    //Счётчики:
    System.out.println("Счётчик Животных: " + Животное.animalCount);
    System.out.println("Счётчик Собак: " + Животное.dogCount);
    System.out.println("Счётчик Котов: " + Животное.catCount);

    //Кормление:
    plate1.amountFood();
    plate1.addFood(29);
    for (Кот cat : cats) {
        cat.eat(plate1);
    }
    plate1.amountFood();

    //Сытость:
    System.out.println("Статус сытости:");
    for (Кот cat : cats) {
        System.out.println(cat.name + " : " + cat.sitost);
    }
}