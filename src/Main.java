public class Main {

    public static int checkMassive(String[][] array, String arrayName) throws MyArraySizeException, MyArrayDataException{

        //Проверка кол-ва строк и столбцов:
        if (array.length != 4) {
            throw new MyArraySizeException("Ошибка! В " + arrayName + " строк должно быть 4! Сейчас: " + array.length);
        }
        for (int i = 0; i < array.length; i++){

            if(array[i].length != 4) {
                throw new MyArraySizeException("Ошибка! В " + arrayName + " колонок должно быть 4! А сейчас: " + array[i].length);
            }
        }
        System.out.println("Проверка прошла! " + arrayName + " соответствует требованиям!");

        //Считаем сумму:
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    String m = array[i][j];
                    if (m == null) {
                        m = "0";
                    }
                    sum += Integer.parseInt(m);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в " + arrayName + " В ячейках: " + i + " " + j + " лежит не число: " + array[i][j]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] dM1 = new String[4][4];
        String[][] dM2 = new String[4][2];
        String[][] dM3 = {
                {"1", "2", "3", "4"},
                {"5", "6", "5", "8"},
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"}
        };
        String[][] dM4 = {
                {"1", "2", "76", "5"},
                {"5", "2", "1", "99"},
                {"1", "3", "3", "3"},
                {"2", "5", "2", "1"}
        };
        String[][] dM5 = {
                {"5", "упс", "5", "5"},
                {"5", "132", "5", "5"},
                {"5", "12", "5", "5"},
                {"5", "33", "5", "5"}
        };

        try {
            System.out.println("---Проверяем #1---");
            int sum = checkMassive(dM1, "Массив №1");
            System.out.println("Сумма в массиве: " + sum);
        }  catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("---Проверяем #2---");
            int sum = checkMassive(dM2, "Массив №2");
            System.out.println("Сумма в массиве: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("---Проверяем #3---");
            int sum = checkMassive(dM3, "Массив №3");
            System.out.println("Сумма в массиве: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("---Проверяем №4---");
            int sum = checkMassive(dM4, "Массив №4");
            System.out.println("Сумма в массиве: " + sum);
        }  catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("---Проверяем №5---");
            int sum = checkMassive(dM5, "Массив №5");
            System.out.println("Сумма в массиве: " + sum);
        }  catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---Проверяем Выход За Границы Массива---");

        try {
            System.out.println("Проверка массива №1");
            String[] bounds = dM1[3];
            System.out.println("Исключений не выявлено!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймали исключение: " + e);
        }

        try {
            System.out.println("Проверка массива №2");
            String[] bounds = dM2[10];
            System.out.println("Исключений не выявлено!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймали исключение: " + e);
        }
    }
}
