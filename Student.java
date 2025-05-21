import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int id;
    private List<Integer> grades;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        int sum = 0;
        for (int g : grades) sum += g;
        return (double) sum / grades.size();
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public List<Integer> getGrades() { return grades; }
}