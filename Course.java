import java.util.ArrayList;
import java.util.List;

public class Course {
    private String title;
    private List<Student> students;

    public Course(String title) {
        this.title = title;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void showStudents() {
        if (students.isEmpty()) {
            System.out.println("Немає студентів у курсі.");
        } else {
            for (Student s : students) {
                System.out.println(s.getId() + ": " + s.getName());
            }
        }
    }

    public double calculateAverageGrade() {
        double total = 0.0;
        int count = 0;
        for (Student s : students) {
            total += s.getAverageGrade();
            count++;
        }
        return count == 0 ? 0.0 : total / count;
    }

    public String getTitle() { return title; }
    public List<Student> getStudents() { return students; }
}