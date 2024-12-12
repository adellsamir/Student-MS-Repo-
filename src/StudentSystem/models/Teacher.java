package StudentSystem.models;
import StudentSystem.interfaces.PersonOperations;
public class Teacher extends Person implements PersonOperations{
    private int teacherId;

    public Teacher(String name,String email,int teacherId){
        super(name, email);
        this.teacherId = teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    @Override
    public void getInfo() {
        System.out.println("The Teacher ID of Mr/ " + getName() + " is: " + teacherId);

        System.out.println( "And the Email of Mr/ " + getName()+ " is: " + getEmail() );
    }
}
