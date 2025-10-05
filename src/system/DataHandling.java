package system;

import java.io.*;
import java.util.ArrayList;

public class DataHandling {
    private static ArrayList<Student> records = new ArrayList<>();
    private static final String FILE_NAME = "student_records.dat";

    public static void addStudent(Student s) {
        records.add(s);
    }

    public static void removeStudent(Student s) {
        records.remove(s);
    }

    public static ArrayList<Student> getAllStudents() {
        return records;
    }

    public static Student getStudentById(String id) {
        for (Student s : records) {
            if (s.getId().equalsIgnoreCase(id)) return s;
        }
        return null;
    }
}
