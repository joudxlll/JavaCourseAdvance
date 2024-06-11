import org.example.models.School;
import org.example.models.Student;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

public class TestSchool {

    private School school;

    @BeforeEach
    public void CreateObjects() {
        school = new School();
        Student s1 = new Student("Joud", 20, "Riyadh", 1001, "Computer Science");
        Student s2 = new Student("Ali", 22, "Qassim", 1002, "Mathematics");
        Student s3 = new Student("Nour", 25, "Jeddah", 1003, "Physics");
        school.addStudent(s1);
        school.addStudent(s2);
        school.addStudent(s3);
    }

    @Test
    public void testAddStudent() {
        Student newStudent = new Student("Ahmed", 23, "Riyadh", 1004, "Chemistry");
        school.addStudent(newStudent);

        Assertions.assertTrue(school.getStudents().contains(newStudent));
    }

    @Test
    public void testRemoveStudent() {
        school.removeStudent(1002);
        int actual = school.getStudents().size();


        Assertions.assertEquals(2, actual);
    }

    @Test
    public void testSortStudentsByName() {
        school.sortStudentsByName();
        ArrayList<Student> actual = school.getStudents();

        ArrayList<Student> expected = new ArrayList<>();
        Student s1 = new Student("Ali", 22, "Qassim", 1002, "Mathematics");
        Student s2 = new Student("Joud", 20, "Riyadh", 1001, "Computer Science");
        Student s3 = new Student("Nour", 25, "Jeddah", 1003, "Physics");
        expected.add(s1);
        expected.add(s2);
        expected.add(s3);

        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void testFindStudentByBinarySearch() {
        Student foundStudent = school.findStudentByIdBinarySearch(1003);
        Assertions.assertEquals("Nour", foundStudent.getName());
    }

}
