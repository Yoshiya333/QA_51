// Класс Треугольник:
public class Triangle implements Shape, Colored {
    double sideA;
    double sideB;
    double sideC;

    String colorFill;
    String colorBord;

    public Triangle(double sideA, double sideB, double sideC, String colorFill, String colorBord) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;

        this.colorBord = colorBord;
        this.colorFill = colorFill;
    }

    // Считаем Площадь:
    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }
    // Считаем Периметр:
    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
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
