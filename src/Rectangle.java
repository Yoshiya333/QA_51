// Класс - Прямоугольник
public class Rectangle implements Shape, Colored {
    double length;
    double width;

    String colorFill;
    String colorBord;

    // Конструктор Прямоугольника:
    public Rectangle(double length, double width, String colorFill, String colorBord) {
        this.length = length;
        this.width = width;

        this.colorFill = colorFill;
        this.colorBord = colorBord;
    }

    // Дописывам методы для подсчёта:
    @Override
    public double getArea() {
        return length * width;
    }
    @Override
    public double getPerimeter() {
        return (length + width) * 2;
    }

    // Для цветов:
    @Override
    public String getColorFill() {
        return colorFill;
    }
    @Override
    public String getColorBord() {
        return colorBord;
    }
}
