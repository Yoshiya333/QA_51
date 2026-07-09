public class Main {

    public static void main(String[] args) {

        // Создаём фигуры:
        Rectangle rectangle1 = new Rectangle(10, 5, "Белый", "Чёрный");
        Circle circle1 = new Circle(22, "Синий", "Белый");
        Triangle triangle1 = new Triangle(10, 15, 10, "Красный", "Чёрный");

        //Вывод информации в консоль:
        System.out.println("---Прямоугольник---");
        System.out.println("Заданные параметры: ");
        System.out.println("Длина: " + rectangle1.length);
        System.out.println("Ширина: " + rectangle1.width);
        rectangle1.printColorInfo();
        System.out.println("Периметр: " + rectangle1.getPerimeter());
        System.out.println("Площадь: " + rectangle1.getArea());
        System.out.println();

        System.out.println("---Круг---");
        System.out.println("Заданные параметры: ");
        System.out.println("Радиус: " + circle1.radius);
        circle1.printColorInfo();
        System.out.println("Периметр: " + circle1.getPerimeter());
        System.out.println("Площадь: " + circle1.getArea());
        System.out.println();

        System.out.println("---Треугольник---");
        System.out.println("Заданные параметры: ");
        System.out.println("1 сторона: " + triangle1.sideA);
        System.out.println("2 сторона: " + triangle1.sideB);
        System.out.println("3 сторона: " + triangle1.sideC);
        triangle1.printColorInfo();
        System.out.println("Периметр: " + triangle1.getPerimeter());
        System.out.println("Площадь: " + triangle1.getArea());
        System.out.println();
    }
}
