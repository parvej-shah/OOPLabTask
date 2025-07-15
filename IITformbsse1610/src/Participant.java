public class Participant {

    // Personal Info
    private String name;
    private String phone;
    private String email;
    private String address;
    private String gender;
    private String dateOfBirth;
    private String degree;
    private String batchNumber;
    private String rollNo;
    private String picturePath;

    // Football Info
    private String preferredPosition;
    private boolean playedInterDepartment;
    private String experience;

    // Constructor
    public Participant(String name, String phone, String email, String address, String gender,
                       String dateOfBirth, String degree, String batchNumber,String rollNo, String picturePath,
                       String preferredPosition, boolean playedInterDepartment, String experience) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.degree = degree;
        this.batchNumber = batchNumber;
        this.rollNo = rollNo;
        this.picturePath = picturePath;
        this.preferredPosition = preferredPosition;
        this.playedInterDepartment = playedInterDepartment;
        this.experience = experience;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDegree() {
        return degree;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public String getPreferredPosition() {
        return preferredPosition;
    }

    public boolean hasPlayedInterDepartment() {
        return playedInterDepartment;
    }

    public String getExperience() {
        return experience;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public void setPreferredPosition(String preferredPosition) {
        this.preferredPosition = preferredPosition;
    }

    public void setPlayedInterDepartment(boolean playedInterDepartment) {
        this.playedInterDepartment = playedInterDepartment;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public boolean isPlayedInterDepartment() {
        return playedInterDepartment;
    }

    // For easy writing to file
    @Override
    public String toString() {
        return "Name: " + name +
                "\nPhone: " + phone +
                "\nEmail: " + email +
                "\nAddress: " + address +
                "\nGender: " + gender +
                "\nDate of Birth: " + dateOfBirth +
                "\nDegree: " + degree +
                "\nBatch Number: " + batchNumber +
                "\nRoll No: " + rollNo +
                "\nPicture Path: " + picturePath +
                "\nPreferred Position: " + preferredPosition +
                "\nPlayed Inter-departmental: " + (playedInterDepartment ? "Yes" : "No") +
                "\nExperience: " + experience + "\n";
    }
}
