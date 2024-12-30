package StudentSystem;

import StudentSystem.models.Course;
import StudentSystem.models.Student;
import StudentSystem.Services.StudentsServices;
import StudentSystem.Services.CoursesServices;
import StudentSystem.Services.EnrollmentsServices;


import java.util.Scanner;

public class Main {
    static CoursesServices courseService = new CoursesServices();
    static StudentsServices studentsServices = new StudentsServices();
    static EnrollmentsServices enrollmentService = new EnrollmentsServices();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.print("\n1. Add Student  <-->  " );
            System.out.print("2. Add Course");
            System.out.print("\n3. Show all course info  <-->  ");
            System.out.print("4. Show all students info");
            System.out.print("\n5. Enroll Student in Course  <-->  ");
            System.out.print("6. View Enrollments");
            System.out.print("\n7. Search for specific course  <-->  ");
            System.out.print("8. Search for specific student");
            System.out.print("\n9. export all students to the txt file  <-->  ");
            System.out.print("10. show all students in the txt file");
            System.out.println("11. EXIT");
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> addCourse();
                case 3 -> courseService.getAllCoursesInfo();
                case 4 -> studentsServices.getAllStudentsInfos();
                case 5 -> enrollStudent();
                case 6 -> enrollmentService.getEnrollments();
                case 7 -> getCourseInfo();
                case 8 -> getStudentInfo();
                case 9 -> studentsServices.exportStudentsData();
                case 10 -> studentsServices.readStudentsFromFile();
                case 11 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 11);

    }

    private static void addStudent() {

        System.out.println("Enter student name: ");
        scanner.nextLine();
        String name = scanner.next();


        String email;
        while (true) {
            System.out.print("Enter student email: ");
            scanner.nextLine();
           email = scanner.next();

            String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

            if (email.matches(emailPattern)) {
                break;
            } else {
                System.out.println("Invalid email format. Please try again.");
            }
        }

        System.out.print("Enter student Level: ");
        int studentLevel = scanner.nextInt();

        if (studentLevel == 2){
            studentsServices.addStudent( new Student( name,studentLevel,email,studentsServices.calcGPA(12)));
        } else if (studentLevel == 3){
            studentsServices.addStudent( new Student( name,studentLevel,email,studentsServices.calcGPA(24)));
        } else if (studentLevel == 4){
            studentsServices.addStudent( new Student( name,studentLevel,email,studentsServices.calcGPA(36)));
        }else {
            studentsServices.addStudent( new Student( name,studentLevel,email));
        }
        System.out.println("Student added.");
    }

    private static void addCourse() {
        System.out.print("Enter course code: ");
        scanner.nextLine();
        String courseCode = scanner.next();

        System.out.println("Enter course name: ");
        scanner.nextLine();
        String courseName = scanner.next();

        System.out.print("Enter Course value(Number of hours): ");
        int courseValue = scanner.nextInt();
        courseService.addCourse(new Course(courseCode, courseName,courseValue));
    }

    private static void enrollStudent() {
        System.out.println("Enter student ID :");
        int studentId = scanner.nextInt();

        System.out.println("Enter course code: ");
        scanner.nextLine();
        String courseCode = scanner.next();

        enrollmentService.enrollStudent(studentId, courseCode);
    }

    private static void getCourseInfo(){
        System.out.println("Enter course code :");
        scanner.nextLine();
        String courseCode = scanner.next();

        courseService.getCourseInfo(courseCode);
    }

    private static void getStudentInfo(){
        System.out.println("Enter roll number :");
        int rollNum = scanner.nextInt();

        studentsServices.getStudentInfo(rollNum);
    }

}


