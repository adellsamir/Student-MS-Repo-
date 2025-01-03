package StudentSystem.models;

public abstract class Person {
    private String name;
    private String email;

    public Person(String name,String email){
        this.name = name;
        this.email = email;
    }
    public void setName(String name){
        this.name=name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public abstract void getInfo();
}
