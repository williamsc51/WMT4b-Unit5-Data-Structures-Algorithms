import java.util.ArrayList;
import java.util.List;

public class Class {

    private String className;
    private String semester;

    public Class(String className, String semester) {
        this.className = className;
        this.semester = semester;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    static public List<Class> allClasses(){
        Class geometry = new Class("Geometry", "Summer 2022");
        Class envSci = new Class("Environmental Science", "Fall 2022");
        Class compLit = new Class("Comparative Literature", "Spring 2023");

        List<Class> list = new ArrayList<>();
        list.add(geometry);
        list.add(envSci);
        list.add(compLit);

        return list;
    }
}
