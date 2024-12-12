package StudentSystem.Services;

import StudentSystem.models.Enrollment;


import java.util.ArrayList;
import java.util.List;

public class EnrollmentsServices {

    private List<Enrollment> enrollments = new ArrayList<>();


    public void enrollStudent(int studentId, String courseCode) {

        enrollments.add(new Enrollment(studentId, courseCode));
        System.out.println("Student enrolled successfully!");
    }


    public void getEnrollments() {

        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found.");
        } else {
            System.out.println("--- Enrollments ---");

            for (Enrollment enrollment : enrollments) {
                enrollment.getEnrollInfo();
            }
        }
    }

}

