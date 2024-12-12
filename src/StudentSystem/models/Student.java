package StudentSystem.models;

import StudentSystem.interfaces.PersonOperations;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements PersonOperations {

    private static List<Student>allStudents=new ArrayList<>();
    private static int studentCounter=0;
    private int rollNum;



    public Student(String name,String email){
        super(name, email);
        studentCounter++;
      this.rollNum=studentCounter;
      allStudents.add(this);
        System.out.println("number of current students: "+studentCounter);
    }

    // Constructor to recreate students (used when reading from a file)
    public Student(int id, String name, String email) {
        super(name, email);
        this.rollNum = id;
        allStudents.add(this);
    }

    public int getRollNum() {
        return rollNum;
    }

    public static int getStudentCounter() {
        return studentCounter;
    }

public static List<Student>getAllStudents(){
        return allStudents;
}
    @Override
    public void getInfo(){

        System.out.println("The Roll Number of Student " + getName() + " is: " + rollNum);

        System.out.println( "And the Email of Student " + getName()+ " is: " + getEmail() );
    }

}
