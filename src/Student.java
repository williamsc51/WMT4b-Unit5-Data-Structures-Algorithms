import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String subject;

    public Student(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    static public List<Student> allStudent(){
        Student studentJM = new Student("Joy Ma", "Spanish");
        Student studentJH = new Student("Julio Hernandez", "Algebra");
        Student studentJJ = new Student("Jenny Jones", "Calculus");

        List<Student> list = new ArrayList<>();
        list.add(studentJM);
        list.add(studentJH);
        list.add(studentJJ);

        return list;
    }
}
