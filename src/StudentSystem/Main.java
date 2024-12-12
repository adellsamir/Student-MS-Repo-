package StudentSystem;

import StudentSystem.models.Course;
import StudentSystem.models.Student;
import StudentSystem.Services.CoursesServices;
import StudentSystem.Services.EnrollmentsServices;

import java.io.*;
import java.util.Scanner;

public class Main {
    static CoursesServices courseService = new CoursesServices();
    static EnrollmentsServices enrollmentService = new EnrollmentsServices();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. View Courses");
            System.out.println("5. View Enrollments");
            System.out.println("6. View Students number");
            System.out.println("7. export all students to the txt file");
            System.out.println("8. show all students in the txt file");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> addCourse();
                case 3 -> enrollStudent();
                case 4 -> courseService.getCourseInfo();
                case 5 -> enrollmentService.getEnrollments();
                case 6 -> System.out.println("Number of students: "+Student.getStudentCounter());
                case 7 -> exportStudentsData();
                case 8 -> readStudentsFromFile();
                case 9 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);

    }

    private static void addStudent() {

        System.out.println("Enter student name: ");
        scanner.nextLine();
        String name = scanner.next();


        String email;
        while (true) {
            System.out.print("Enter student email: ");
            scanner.nextLine();
           email = scanner.nextLine();

            String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

            if (email.matches(emailPattern)) {
                break;
            } else {
                System.out.println("Invalid email format. Please try again.");
            }
        }

        new Student( name, email);
        System.out.println("Student added.");
    }

    private static void addCourse() {
        System.out.print("Enter course code: ");
        String courseCode = scanner.next();

        System.out.println("Enter course name: ");
        scanner.nextLine();
        String courseName = scanner.next();

        System.out.print("Enter course credits: ");
        float credits = Float.parseFloat(scanner.next());

        courseService.addCourse(new Course(courseCode, courseName, credits));
    }

    private static void enrollStudent() {
        System.out.print("Enter student ID to enroll: ");
        int studentId = scanner.nextInt();

        System.out.print("Enter course code: ");
        String courseCode = scanner.next();

        enrollmentService.enrollStudent(studentId, courseCode);
    }

    public static void exportStudentsData(){
        try(BufferedWriter writer=new BufferedWriter(new FileWriter("students.txt"))) {
            for(Student student:Student.getAllStudents()){
                writer.write(student.getRollNum() + "," + student.getName() + "," + student.getEmail());
                writer.newLine();
            }
            System.out.println("All students got export to the txt file.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readStudentsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}


