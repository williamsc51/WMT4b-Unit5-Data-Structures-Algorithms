import java.util.List;
import java.util.stream.Collectors;

public class ClientBusinessObjectImpl {

    public List<Student> getAllStudentsBySubject(String subject){

        return Student.allStudent().stream().filter(s-> s.getSubject() == "Algebra" || s.getSubject() == "Calculus").collect(Collectors.toList());
    }
}
