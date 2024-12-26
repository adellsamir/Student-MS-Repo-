package StudentSystem.models;

import StudentSystem.interfaces.PersonOperations;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements PersonOperations {

    private static List<Student>allStudents=new ArrayList<>();
    private static int studentCounter=0;
    private int rollNum;
    private int studentLevel;



    public Student(String name,int studentLevel,String email){
        super(name, email);
        studentCounter++;
      this.rollNum=studentCounter;
      this.studentLevel=studentLevel;
      allStudents.add(this);
        System.out.println("number of current students: "+studentCounter);
    }

    // Constructor to recreate students (used when reading from a file)
    public Student(int rollNum, String name,int studentLevel, String email) {
        super(name, email);
        this.rollNum = rollNum;
        this.studentLevel=studentLevel;
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

    public int getStudentLevel() {
        return studentLevel;
    }

    @Override
    public void getInfo(){

        System.out.println("The Roll Number of Student " + getName() + " is: " + getRollNum());

        System.out.println( "And the Email of Student " + getName()+ " is: " + getEmail() );

        System.out.println(  getName()+ "in Level: " + getStudentLevel()  );
    }

}
