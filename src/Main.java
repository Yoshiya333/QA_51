import java.sql.PreparedStatement;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Для тестов:
        int a = 5;
        int b = 20;
        int c = 5;
        int d = 20;
        int f = 0;

        // Задание №1
        printThreeWords();

        // Задание №2
        checkSumSign();

        // Задание №3
        printColor();

        // Задание №4
        compareNumbers(a, b);

        // Задание №5
        boolean resultCheckNumbers = checkNumbers(5, 10);
        System.out.println("Результат проверки: " + resultCheckNumbers);
        System.out.println();

        // Задание №6
        PlusOrMinus(f);

        // Задание №7
        boolean resultPlusOrMinus2 = PlusOrMinus2(9);
        System.out.println("Результат проверки: " + resultPlusOrMinus2);
        System.out.println();

        // Задание №8
        CyclKoroche("QA_51", 5);

        // Задание №9
        boolean resultYearCheck = yearCheck(2026);
        System.out.println("Год Високосный?: " + resultYearCheck);
        System.out.println();

        // Задание №10
        elementsZero();

        // Задание №11
        massive();

        // Задание №12
        MassiveCycle();

        // Задание №13
        dvumernMassive();

        // Задание №14
        int[] resultMassiveAnswer = massiveAnswer(5,15);
        System.out.println(Arrays.toString(resultMassiveAnswer));
    }

    /* Задание №1
    Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple
     */
    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
        System.out.println();
    }

    /* Задание №2
    Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями, которыми захотите.
    Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0, то вывести в консоль сообщение
    “Сумма положительная”, в противном случае - “Сумма отрицательная”;
     */
    static void checkSumSign() {
        int a = 3;
        int b = 9;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
        System.out.println();
    }

    /* Задание №3
    Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
    Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”,
    если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”;
     */
    static void printColor() {
        int value = 0;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (0 < value && value <= 100) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }
        System.out.println();
    }

    /* Задание №4
    Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b,
    и инициализируйте их любыми значениями, которыми захотите. Если a больше или равно b, то необходимо вывести в консоль сообщение
    “a >= b”, в противном случае “a < b”;
     */
    static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
        System.out.println();
    }

    /* Задание №5
    Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно),
    если да – вернуть true, в противном случае – false.
     */
    static boolean checkNumbers(int c, int d) {
        boolean result = c + d >= 10 && c + d <= 20;
        System.out.println(result);
        System.out.println();
        return result;
    }

    /* Задание №6
    Напишите метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
     */
    static void PlusOrMinus(int f) {
        if (f >= 0) {
            System.out.println("Число положительное!");
        } else {
            System.out.println("Число отрицательное!");
        }
    }

    /* Задание №7
    Напишите метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    Замечание: ноль считаем положительным числом.
     */
    static boolean PlusOrMinus2(int f) {
        boolean result = f < 0;
        System.out.println();
        return result;
    }

    /* Задание №8
    Напишите метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль указанную строку, указанное количество раз;
     */
    static void CyclKoroche(String abc, int i) {
        for (int count = 0; count < i; count++) {
            System.out.println(abc);
        }
    }

    /* Задание №9
    Напишите метод, который определяет, является ли год високосным,
    и возвращает boolean (високосный - true, не високосный - false). Каждый 4-й год является високосным,
    кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    static boolean yearCheck(int year) {
        boolean result;
        if (year % 400 == 0) {
            result = true;
        } else if (year % 100 == 0) {
            result = false;
        } else if (year % 4 == 0) {
            result = true;
        } else {
            result = false;
        }
        System.out.println();
        return result;
    }

    /* Задание №10
    Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    static void elementsZero() {
        int[] elements = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == 1) {
                elements[i] = 0;
            } else {
                elements[i] = 1;
            }
        }
        System.out.println(java.util.Arrays.toString(elements));
        System.out.println();
    }

    /* Задание №11
    Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
     */
    static void massive() {
        int[] celMassive = new int[100];
        for (int i = 0; i < celMassive.length; i++) {
            celMassive[i] = i + 1;
        }
        System.out.println(Arrays.toString(celMassive));
        System.out.println();
    }

    /* Задание №12
    Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    static void MassiveCycle() {
        int[] massive = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int result = 0;
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] < 6) {
                result = massive[i] * 2;
                System.out.println(result);
            }
        }
        System.out.println();
    }

    /* Задание №13
    Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами
    (можно только одну из диагоналей, если обе сложно).
    Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];
     */
    static void dvumernMassive() {
        int[][] dvum = new int[10][10];
        for (int i = 0; i < dvum.length; i++) {
            dvum[i][i] = 1;
            dvum[i][dvum.length - 1 - i] = 1;
        }
        for (int i = 0; i < dvum.length; i++) {
            for (int j = 0; j < dvum.length; j++) {
                System.out.print(dvum[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* Задание №14
    Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len,
    каждая ячейка которого равна initialValue.
     */
    static int[] massiveAnswer(int len, int initialValue) {
        int[] massiveCreate = new int[len];
        for(int i = 0; i < massiveCreate.length; i++) {
            massiveCreate[i] = initialValue;
        }
        System.out.println();
        return massiveCreate;
    }
}