import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(String name, int age, String course){
        Student s = new Student(name, age, course);
        students.add(s);
        System.out.println("Student added. ID is: " + s.getId());
    }
    public void removeStudent(int id){
        students.removeIf(s -> s.getId() == id);
        System.out.println("Student id detected student rejected");
    }
    public void displayAll(){
        for(Student s : students){
            s.display();
        }
    }
    public void searchById(int id){
        for(Student s : students){
            if(s.getId() == id){
                s.display();
                return;
            }
        }
        System.out.println("Student not found");
    }
    public void updateStudent(int id,String name, int age, String course){
        for(Student s : students) {
            if (s.getId() == id) {
                s.updateDetails(name, age, course);
                System.out.println("Student details updated");
                return;
            }
        }
        System.out.println("Student details not updated");
    }
}
