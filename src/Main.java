public class Main {

    public static void checkMassive(String[][] array, String arrayName) throws MyArraySizeException{
        if (array.length != 4) {
            throw new MyArraySizeException("Ошибка! В " + arrayName + " строк должно быть 4!");
        }
        for (int i = 0; i < array.length; i++){

            if(array[i].length != 4) {
                throw new MyArraySizeException("Ошибка! В " + arrayName + " колонок должно быть 4!");
            }
        }
        System.out.println("Проверка прошла! " + arrayName + " соответствует требованиям!");
    }

    static void main(String[] args) {
        String[][] dM1 = new String[4][4];
        String[][] dM2 = new String[4][2];
        String[][] dM3 = new String[2][4];
        String[][] dM4 = new String[2][2];

        try {
            System.out.println("---Проверяем---");
            checkMassive(dM1, "Массив №1");

            checkMassive(dM2, "Массив №2");

            checkMassive(dM3, "Массив №3");

            checkMassive(dM4, "Массив №4");

        }
        catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
    }
}