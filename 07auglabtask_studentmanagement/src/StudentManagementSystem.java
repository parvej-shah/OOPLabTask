import java.util.ArrayList;
import java.util.List;

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
        
        System.out.println("=== All Students in the University ===");
        for (Student student : allStudents) {
            System.out.println(student.toString());
        }
        
        System.out.println("\n=== Demonstrating ArrayList Operations ===");
        
        Student newStudent = new Student(6, "Farhan", "Engineering");
        allStudents.add(2, newStudent); // Adding at index 2
        
        System.out.println("After adding Farhan at index 2:");
        for (int i = 0; i < allStudents.size(); i++) {
            System.out.println("Index " + i + ": " + allStudents.get(i).toString());
        }
        
        // Demonstrate removing a student by index
        System.out.println("\nRemoving student at index 1:");
        Student removedByIndex = allStudents.remove(1);
        System.out.println("Removed: " + removedByIndex.toString());
        
        System.out.println("Students after removal by index:");
        for (Student student : allStudents) {
            System.out.println(student.toString());
        }
        
        // Demonstrate removing a student by object
        System.out.println("\nRemoving Tamim by object:");
        boolean removedByObject = allStudents.remove(student3);
        System.out.println("Removal successful: " + removedByObject);
        
        System.out.println("Final list of students:");
        for (Student student : allStudents) {
            System.out.println(student.toString());
        }
        
        System.out.println("\nTotal number of students: " + allStudents.size());
    }
}
