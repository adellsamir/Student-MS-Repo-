@startuml
' Abstract Person class
abstract class Person {
    - name: String
    - email: String
    + displayInfo(): void
}

' Student class inheriting from Person
class Student {
    - id: int
    + getDetails(): String
}
Person <|-- Student

' Teacher class inheriting from Person
class Teacher {
    - teacherId: int
    + getDetails(): String
}
Person <|-- Teacher

' Interface for Course Operations
interface CourseOperations {
    + addCourse(): void
    + removeCourse(): void
}

' Course class implementing CourseOperations
class Course {
    - courseCode: String
    - courseName: String
    - credits: int
}
CourseOperations <|.. Course

' Enrollment class
class Enrollment {
    - studentId: int
    - courseCode: String
    - enrollmentDate: Date
}

' Relationships
Course "1" *-- "*" Enrollment
Student "1" *-- "*" Enrollment
Teacher "1" --> "*" Course

@enduml
