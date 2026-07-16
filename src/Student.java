import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    //Конструктор Студента:
    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    //Высчитываем средний балл:
    public double getAverageGrade() {
        if(this.grades.isEmpty()){
            return 0.0;
        }

        double sum = 0;
        for(int grade : this.grades) {
            sum += grade;
        }
        return sum / this.grades.size();
    }

    //Переводим студента на след.курс:
    public void transition(){
        if(getAverageGrade() >= 3.0) {
            this.course += 1;
        }
    }

    public int getCourse() {
        return this.course;
    }
    public String getName() {
        return this.name;
    }
}
