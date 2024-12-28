package StudentSystem.Services;

import StudentSystem.models.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class StudentsServices {

    CoursesServices coursesServices = new CoursesServices();
    static Scanner scanner = new Scanner(System.in);
    private static List<Student>allStudents=new ArrayList<>();

    public void addStudent(Student student ) {
        allStudents.add(student);
        System.out.println("Student added successfully!");
    }

    public void getStudentInfo(int rollNum) {
        if (allStudents.isEmpty()) {
            System.out.println("No students available.");
            }else{
            for (Student student : allStudents){
                if (student.getRollNum() == rollNum){
                    System.out.println("The Roll Number of Student " + student.getName() + " is: " + student.getRollNum());

                    System.out.println( "And the Email of Student " +student.getName()+ " is: " + student.getEmail() );

                    System.out.println(  student.getName()+ "in Level: " + student.getStudentLevel()  );

                    if (student.getStudentLevel() != 1) System.out.println("And his overall GPA is: " +student.getCurrentGPA() );
                }
            }
        }
        }

    public void getAllStudentsInfos (){
    if (allStudents.isEmpty()) {
        System.out.println("No students available.");
    }else{
        for (Student student : allStudents){
                System.out.print( " {"+student.getName() + "ID: " + student.getRollNum());

                System.out.println( "Email: " + student.getEmail() );

                System.out.println( "Student Level: " + student.getStudentLevel()  );

                if (student.getStudentLevel() != 1) System.out.println("GPA: " +student.getCurrentGPA() );

            System.out.print(" }\n");
        }
    }

}

    public float convertGradeToGPA(int grade) {
        if (grade >= 95) {
            return 5.0F;
        } else if (grade >= 90) {
            return (float) (4.5 + (grade - 90) * 0.1); // Between 90 and 94
        } else if (grade >= 85) {
            return (float) (4.0 + (grade - 85) * 0.1); // Between 85 and 89
        } else if (grade >= 80) {
            return (float) (3.5 + (grade - 80) * 0.1); // Between 80 and 84
        } else if (grade >= 75) {
            return (float) (3.0 + (grade - 75) * 0.1); // Between 75 and 79
        } else if (grade >= 70) {
            return (float) (2.5 + (grade - 70) * 0.1); // Between 70 and 74
        } else if (grade >= 65) {
            return (float) (2.0 + (grade - 65) * 0.1); // Between 65 and 69
        } else if (grade >= 60) {
            return (float) (1.5 + (grade - 60) * 0.1); // Between 60 and 64
        } else {
            return 0.0F; // Below 60
        }
    }

    public float calcGPA(int numberOfCourses ){
        float GPA=0;

        int choice=-1;
        while (choice != 1 && choice != 2) {

            System.out.println("Enter all student grades to calc his GPA or enter his Current GPA instead");

            System.out.println("chose 1 to: Enter GPA . \nchose 2 to: Enter all student grads .");
            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter the GPA: ");
                GPA = Float.parseFloat(scanner.next());
            }

            else if (choice == 2) {

                double totalWeightedGPA = 0;
                int totalCreditHours = 0;
                for (int i = 1; i <=numberOfCourses ; i++) {

                    System.out.println("Enter the code of Course number ("+ i +") :" );
                    scanner.nextLine();
                    String course1Code = scanner.nextLine();

                    int numberOfHours =coursesServices.getCourseVal(course1Code);

                    System.out.println("Enter the grade for this subject: ");
                    int grade = scanner.nextInt();

                    float subGPA =convertGradeToGPA(grade);

                    totalWeightedGPA += subGPA * numberOfHours;
                    totalCreditHours += numberOfHours;

                    System.out.println("GPA for this subject: " + subGPA);
                }

        GPA = (float) (totalWeightedGPA / totalCreditHours);

            } else System.out.println("Wrong input please try again . ");
        }
        return GPA;
    }

    public  void exportStudentsData(){
        try(BufferedWriter writer=new BufferedWriter(new FileWriter("students.txt"))) {
            for(Student student:allStudents){
                writer.write(student.getRollNum() + "," + student.getName() + "," + student.getEmail());
                writer.newLine();
            }
            System.out.println("All students got export to the txt file.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public   void readStudentsFromFile() {
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
