// Класс КРУг:
public class Circle implements Shape, Colored {

    double radius;

    String colorFill;
    String colorBord;

    // Конструктор для Круга:
    public Circle(double radius, String colorFill, String colorBord) {
        this.radius = radius;

        this.colorFill = colorFill;
        this.colorBord = colorBord;
    }

    // Считаем Площадь Круга:
    @Override
    public double getArea() {
        return (radius * radius) * Math.PI;
    }

    // Считаем Периметр Круга:
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getColorFill() {
        return colorFill;
    }
    @Override
    public String getColorBord () {
        return colorBord;
    }
}
