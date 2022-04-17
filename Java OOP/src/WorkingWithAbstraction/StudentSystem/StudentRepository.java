package WorkingWithAbstraction.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository {
    private final Map<String, Student> studentByName;

    public StudentRepository() {
        this.studentByName = new HashMap<>();
    }

    public void add(Student student) {
        this.studentByName.put(student.getName(), student);
    }

    public Student get(String name) {
        if (this.studentByName.containsKey(name)) {
            return this.studentByName.get(name);
        }
        return null;
    }
}
