package StudentSystem.Services;

import StudentSystem.models.Course;
import StudentSystem.interfaces.CoursesOperations;
import java.util.ArrayList;
import java.util.List;

public class CoursesServices implements CoursesOperations{
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added successfully!");
    }

    public void getCourseInfo() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            System.out.println("--- Course List ---");
            for (Course course : courses) {
                System.out.print("course name: "+course.getCourseName()+'\n'+"course code: "+course.getCourseCode()+'\n'+"course cost: "+course.getCredits());
            }
        }
    }
}
