import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        int studentIdCounter = 1;

        while (true) {
            System.out.println("\n--- Меню ---");
            System.out.println("1. Створити курс");
            System.out.println("2. Додати студента до курсу");
            System.out.println("3. Ввести оцінку студенту");
            System.out.println("4. Переглянути студентів курсу");
            System.out.println("5. Середній бал по курсу");
            System.out.println("6. Вихід");
            System.out.print("Виберіть опцію: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Очистка

            switch (option) {
                case 1:
                    System.out.print("Назва курсу: ");
                    String courseName = scanner.nextLine();
                    courses.add(new Course(courseName));
                    System.out.println("Курс створено.");
                    break;
                case 2:
                    Course course1 = chooseCourse(courses, scanner);
                    if (course1 != null) {
                        System.out.print("Ім'я студента: ");
                        String name = scanner.nextLine();
                        course1.addStudent(new Student(name, studentIdCounter++));
                        System.out.println("Студента додано.");
                    }
                    break;
                case 3:
                    Course course2 = chooseCourse(courses, scanner);
                    if (course2 != null) {
                        course2.showStudents();
                        System.out.print("ID студента: ");
                        int sid = scanner.nextInt();
                        Student target = course2.getStudents().stream()
                            .filter(s -> s.getId() == sid).findFirst().orElse(null);
                        if (target != null) {
                            System.out.print("Оцінка: ");
                            int grade = scanner.nextInt();
                            target.addGrade(grade);
                            System.out.println("Оцінка додана.");
                        } else {
                            System.out.println("Студента не знайдено.");
                        }
                    }
                    break;
                case 4:
                    Course course3 = chooseCourse(courses, scanner);
                    if (course3 != null) course3.showStudents();
                    break;
                case 5:
                    Course course4 = chooseCourse(courses, scanner);
                    if (course4 != null)
                        System.out.println("Середній бал: " + course4.calculateAverageGrade());
                    break;
                case 6:
                    System.out.println("Вихід з програми.");
                    return;
                default:
                    System.out.println("Невідома опція.");
            }
        }
    }

    private static Course chooseCourse(List<Course> courses, Scanner scanner) {
        if (courses.isEmpty()) {
            System.out.println("Курсів немає.");
            return null;
        }
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getTitle());
        }
        System.out.print("Виберіть курс: ");
        int index = scanner.nextInt() - 1;
        if (index < 0 || index >= courses.size()) {
            System.out.println("Некоректний вибір.");
            return null;
        }
        return courses.get(index);
    }
}