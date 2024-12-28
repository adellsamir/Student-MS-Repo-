package StudentSystem.models;


public class Course {

    private String courseCode;
    private String courseName;
    private int numberOfHours;
    private float credits;

    public Course(String courseCode,String courseName,int numberOfHours){

        this.courseCode = courseCode;
        this.courseName = courseName;
        this.numberOfHours=numberOfHours;
        this.credits =numberOfHours*1000;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public float getCredits() {
        return credits;
    }


}
