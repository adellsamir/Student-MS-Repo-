package StudentSystem.models;

import java.util.Date;

public class Enrollment {

    private int studentRollNum;
    private String courseCode;
    private Date enrollmentDate;

    public Enrollment(int studentRollNum, String courseCode) {
        this.studentRollNum = studentRollNum;
        this.courseCode = courseCode;
        this.enrollmentDate = new Date();
    }

    public void getEnrollInfo(){
        System.out.println("Enrollment: Student ID " + studentRollNum + ", Course Code " + courseCode + ", Date " + enrollmentDate);
    }

}
