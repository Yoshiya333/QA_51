import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Main {

    //------------------------------------------- ЗАДАНИЕ №1 -------------------------------------------

    //Метод по исключению отстающих
    public static void removeLaggingStudent(List<Student> students){
        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    //Перевод успевающего студента на след.курс
    public static void transitionAllStudents(List<Student> students) {
        for (Student student : students) {
            student.transition();
        }
    }

    public static void printStudents(Set<Student> students, int course){
        System.out.println("---Студенты " + course + " курса:---");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    public static void main(String[] args) {

        System.out.println();
        System.out.println("----------------------- Задание №1 -----------------------");
        System.out.println();

        Student student1 = new Student("Михаил", "QA", 51, List.of(5, 4, 5, 5));
        Student student2 = new Student("Александра", "QA", 51, List.of(5, 3, 3 , 2));
        Student student3 = new Student("Андрей", "QA", 51, List.of(4, 4, 4, 3));
        Student student4 = new Student("Алексей", "QA", 51, List.of(1, 2, 3, 4));
        Student student5 = new Student("Екатерина", "QA", 51, List.of(1, 3, 5, 4));
        Student student6 = new Student("Артём", "QA", 51, List.of(3, 5, 3, 4));
        Student student7 = new Student("Даниил", "QA", 51, List.of(2, 3, 2, 4));
        Student student8 = new Student("Илья", "QA", 51, List.of(1, 2, 1, 2));


        //Список из студентов:
        List<Student> studentsList = new ArrayList<>();

        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);
        studentsList.add(student4);
        studentsList.add(student5);
        studentsList.add(student6);
        studentsList.add(student7);
        studentsList.add(student8);

        //создаём set
        java.util.Set<Student> studentSet = new java.util.HashSet<>(studentsList);

        //Отображение всех студентов из списка:
        System.out.println("Всего студентов в коллекции: " + studentsList.size());

        //Удаление отстающих:
        removeLaggingStudent(studentsList);

        //Отображение всех студентов из списка:
        System.out.println();
        System.out.println("Всего студентов в коллекции (после чистки): " + studentsList.size());

        //Перевод студентов:
        transitionAllStudents(studentsList);

        //Отображаем весь список снова:
        System.out.println();
        System.out.println("Всего студентов в коллекции (после перевода): " + studentsList.size());

        System.out.println();
        printStudents(studentSet, 52);


        //------------------------------------------- ЗАДАНИЕ №2 -------------------------------------------
        System.out.println();
        System.out.println("----------------------- Задание №2 -----------------------");
        System.out.println();

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Румянцев", "+7 (952) 145-73-20");
        phoneBook.add("Панин", "+7 (901) 959-50-50");
        phoneBook.add("Куропяткин", "+7 (918) 413-59-68");
        phoneBook.add("Вагина", "+7 (939) 291-67-37");
        phoneBook.add("Румянцев", "+7 (926) 781-43-73");

        System.out.println("Номера для фамилии Иванов: " + phoneBook.get("Иванов"));
        System.out.println("Номера для фамилии Панин: " + phoneBook.get("Панин"));
        System.out.println("Номера для фамилии Куропяткин: " + phoneBook.get("Куропяткин"));
        System.out.println("Номера для фамилии Вагина: " + phoneBook.get("Вагина"));

        //Проверка дубликата
        System.out.println("Номера для фамилии Румянцев: " + phoneBook.get("Румянцев"));

    }
}
