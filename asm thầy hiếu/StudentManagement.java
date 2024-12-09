import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String fullName;
    private int age;

    public Student(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{fullName='" + fullName + "', age=" + age + "}";
    }
}

public class StudentManagement {
    private static final ArrayList<Student> studentList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- STUDENT MANAGEMENT MENU ---");
            System.out.println("1. Enter student list");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit students by full name");
            System.out.println("4. End");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    enterStudentList();
                    break;
                case 2:
                    findByLastName();
                    break;
                case 3:
                    findAndEditByFullName();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void enterStudentList() {
        System.out.print("Enter number of students: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("Enter full name of student " + (i + 1) + ": ");
            String fullName = scanner.nextLine();
            System.out.print("Enter age of student " + (i + 1) + ": ");
            int age = Integer.parseInt(scanner.nextLine());
            studentList.add(new Student(fullName, age));
        }
        System.out.println("Students added successfully!");
    }

    private static void findByLastName() {
        System.out.print("Enter last name to search: ");
        String lastName = scanner.nextLine();
        boolean found = false;
        for (Student student : studentList) {
            String[] nameParts = student.getFullName().split(" ");
            if (nameParts[nameParts.length - 1].equalsIgnoreCase(lastName)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found with last name: " + lastName);
        }
    }

    private static void findAndEditByFullName() {
        System.out.print("Enter full name to search: ");
        String fullName = scanner.nextLine();
        for (Student student : studentList) {
            if (student.getFullName().equalsIgnoreCase(fullName)) {
                System.out.println("Student found: " + student);
                System.out.print("Enter new full name: ");
                String newFullName = scanner.nextLine();
                System.out.print("Enter new age: ");
                int newAge = Integer.parseInt(scanner.nextLine());
                student.setFullName(newFullName);
                student.setAge(newAge);
                System.out.println("Student information updated successfully!");
                return;
            }
        }
        System.out.println("No student found with full name: " + fullName);
    }
}
