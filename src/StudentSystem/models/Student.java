package StudentSystem.models;

import StudentSystem.interfaces.PersonOperations;
public class Student extends Person implements PersonOperations {
    private static int studentCounter=101245;
    private int rollNum;
    private int studentLevel;
    private float currentGPA=0;



    public Student(String name,int studentLevel,String email,float gpa){
        super(name, email);
        studentCounter++;
      this.rollNum=studentCounter;
      this.studentLevel=studentLevel;
      this.currentGPA=gpa;
        System.out.println("number of current students: "+studentCounter);
    }

    public Student(String name,int studentLevel,String email){
        super(name, email);
        studentCounter++;
      this.rollNum=studentCounter;
      this.studentLevel=studentLevel;
        System.out.println("number of current students: "+studentCounter);
    }

    public Student(int rollNum, String name,int studentLevel, String email) {
        super(name, email);
        this.rollNum = rollNum;
        this.studentLevel=studentLevel;
    }

    public int getRollNum() {
        return rollNum;
    }

    public static int getStudentCounter() {
        return studentCounter;
    }

    public float getCurrentGPA() {
        return currentGPA;
    }

    public int getStudentLevel() {
        return studentLevel;
    }

    @Override
    public void getInfo(){

        System.out.println("The Roll Number of Student " + getName() + " is: " + getRollNum());

        System.out.println( "And the Email of Student " + getName()+ " is: " + getEmail() );

        System.out.println(  getName()+ "in Level: " + getStudentLevel());

        if (studentLevel != 1) System.out.println("And his overall GPA is: " +currentGPA );
    }


}
