import java.time.LocalDate;
import java.util.PriorityQueue;

public class Task{
    private static int idCounter= 100;
    private int id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Priority priority;
    private Boolean completed;

    public Task(String title, String description, LocalDate dueDate, Priority priority){
        this.id = idCounter++;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }

    public enum Priority{
        LOW, MEDIUM, HIGH;
    }

    public int getId(){
        return id;
    }

    public void markComplete(){
        completed = true;
    }

    @Override
    public String toString(){
        return String.format("ID: %d| Title: %s| Due Date: %s| Priority: %s| Completed:%s\nDescription: %s", id, title,
               dueDate, priority, completed ? "Yes" : "No", description);
    }


}
