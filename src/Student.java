public class Student{
    private static int idCounter = 100;
    private int id;
    private String name;
    private int age;
    private String course;

    public Student(String name, int age, String course){
        this.id = idCounter++;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void updateDetails(String name, int age, String course){
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public void display(){
        System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age + " | Course: " + course);
    }
}