import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private long rollNumber;
    private String grade;

    public Student(String name, long rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public long getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(long rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;
    private Scanner scanner;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.println("Enter student details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Roll Number: ");
        long rollNumber = Long.parseLong(scanner.nextLine());
        System.out.print("Grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(name, rollNumber, grade);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void removeStudent(long rollNumber) {
        boolean removed = false;
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                System.out.println("Student removed successfully.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }

    public void searchStudent(long rollNumber) {
        boolean found = false;
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Student details:");
                System.out.println(student);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("All students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    sms.addStudent();
                    break;
                case 2:
                    System.out.print("Enter the Roll Number of the student to remove: ");
                    long rollToRemove = Long.parseLong(scanner.nextLine());
                    sms.removeStudent(rollToRemove);
                    break;
                case 3:
                    System.out.print("Enter the Roll Number of the student to search: ");
                    long rollToSearch = Long.parseLong(scanner.nextLine());
                    sms.searchStudent(rollToSearch);
                    break;
                case 4:
                    sms.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting Student Management System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
