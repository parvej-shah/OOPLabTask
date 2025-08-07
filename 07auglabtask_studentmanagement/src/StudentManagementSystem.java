import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentManagementSystem {
    public static void main(String[] args) {

        List<Student> allStudents = new ArrayList<>();
        
        Student student1 = new Student(1, "Adnan", "Computer Science");
        Student student2 = new Student(2, "Sakib", "Mathematics");
        Student student3 = new Student(3, "Tamim", "Physics");
        Student student4 = new Student(4, "Marin", "Chemistry");
        Student student5 = new Student(5, "Dirve", "Biology");

        allStudents.add(student1);
        allStudents.add(student2);
        allStudents.add(student3);
        allStudents.add(student4);
        allStudents.add(student5);
        // taskShowArrayList(allStudents);
        // enrolement(allStudents);
        taskHashmap(allStudents);

    }

    public static void enrolement(List<Student> allStudents) {
        java.util.Set<Student> courseEnrolled = new java.util.HashSet<>();

        Student s1 = allStudents.get(0);
        Student s3 = allStudents.get(4);
        Student s2 = allStudents.get(2);
        courseEnrolled.add(s1);
        courseEnrolled.add(s3);
        courseEnrolled.add(s2);

        boolean addedAgain = courseEnrolled.add(s2);
        System.out.println("Tamim again? " + addedAgain);

        boolean isEnrolled = courseEnrolled.contains(s2);
        System.out.println("Is Tamim (id=3) enrolled? " + isEnrolled);

        Student checkStudent = allStudents.get(1); // sakib
        boolean isSakibEnrolled = courseEnrolled.contains(checkStudent);
        System.out.println("Is Sakib (id=2) enrolled? " + isSakibEnrolled);

        // student with same id
        Student student3 = new Student(3, "Parvej", "Physics");
        boolean isParvejEnrolled = courseEnrolled.contains(student3);
        System.out.println("Is Parvej (id=3) enrolled? " + isParvejEnrolled);

        System.out.println("\nAll students enrolled in the course:");
        for (Student s : courseEnrolled) {
            System.out.println(s);
        }
    }
    public static void taskShowArrayList(List<Student> allStudents) {

        System.out.println("All Students in the University");
        for (Student student : allStudents) {
            System.out.println(student.toString());
        }

        System.out.println("\nDemonstrating ArrayList Operations");
        Student newStudent = new Student(6, "Farhan", "Engineering");
        allStudents.add(2, newStudent);
        System.out.println("After adding Farhan at index 2:");
        for (int i = 0; i < allStudents.size(); i++) {
            System.out.println("Index " + i + ": " + allStudents.get(i).toString());
        }

        System.out.println("\nRemoving student at index 1:");
        Student removedByIndex = allStudents.remove(1);
        System.out.println("Removed: " + removedByIndex.toString());
        System.out.println("Students after removal by index:");
        for (Student student : allStudents) {
            System.out.println(student.toString());
        }

        System.out.println("\nRemoving newly added by object:");
        boolean removedByObject = allStudents.remove(newStudent);
        System.out.println("Removal successful: " + removedByObject);

        System.out.println("Final list of students:");
        for (Student student : allStudents) {
            System.out.println(student.toString());
        }

        System.out.println("\nTotal number of students: " + allStudents.size());
    }
    public static void taskHashmap(List<Student> allStudents) {
        Map<Integer, Student> studentMap = new HashMap<>();

        for (Student student : allStudents) {
            studentMap.put(student.getStudentId(), student);
        }
        int id = 2;
        Student studenthashed = studentMap.get(id);
        if (studenthashed != null) {
            System.out.println("Student found: " + studenthashed);
        } else {
            System.out.println("No student found with ID: " + id);
        }
    }
}
