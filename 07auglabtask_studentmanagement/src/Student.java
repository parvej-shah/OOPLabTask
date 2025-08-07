public class Student {
    private int studentId;
    private String studentName;
    private String major;

    public Student(int studentId, String studentName, String major) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.major = major;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + studentName + ", Major: " + major;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student newStudent)) return false;
        return studentId == newStudent.getStudentId();
    }

    @Override
    public int hashCode() {
        return studentId;
    }

}
