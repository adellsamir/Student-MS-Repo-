package StudentSystem.models;


public class Course {

    private String courseCode;
    private String courseName;
    private float credits;

    public Course(String courseCode,String courseName,float credits){

        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCredits(float credits) {
        this.credits = credits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public float getCredits() {
        return credits;
    }


}
