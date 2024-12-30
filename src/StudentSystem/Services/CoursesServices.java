package StudentSystem.Services;

import StudentSystem.models.Course;
import StudentSystem.interfaces.CoursesOperations;
import java.util.ArrayList;
import java.util.List;

public class CoursesServices implements CoursesOperations{
    private static List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added successfully!");
    }

    public void getCourseInfo(String courseCode) {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (Course course : courses) {
                if (course.getCourseCode().equals(courseCode)){

                    System.out.print("{\n "+course.getCourseName()+
                            '\n'+"course value: "+course.getNumberOfHours()+
                            '\n'+"course code: "+course.getCourseCode()+'\n'+"course cost: "+
                            course.getCredits()+" $"+"\n} ");
                }
            }
        }
    }

    public int getCourseVal(String courseCode) {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return -1;
        }
            for (Course course : courses) {
                if (course.getCourseCode().equals(courseCode)){
                    return course.getNumberOfHours();
                }
            }
        System.out.println("!-There is no course with this code-! \n !-Please check if the course code correct and try again-!");
      return 0;
    }

    public void getAllCoursesInfo(){
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            System.out.println("--- Course List ---");
            for (Course course : courses) {
                System.out.print("\n{\n "+course.getCourseName()+'\n'+"course value: "+course.getNumberOfHours()+'\n'+"course code: "+course.getCourseCode()+'\n'+"course cost: "+course.getCredits()+" $"+"\n} ");
            }
        }
    }


}
