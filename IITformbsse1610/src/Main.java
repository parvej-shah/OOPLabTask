import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("IITDU Football League Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Name
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        JTextField nameField = new JTextField(20);
        panel.add(nameField, gbc);

        // Email
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        JTextField emailField = new JTextField(20);
        panel.add(emailField, gbc);

        // Phone
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        JTextField phoneField = new JTextField(20);
        panel.add(phoneField, gbc);

        // Address
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Address:"), gbc);
        gbc.gridx = 1;
        JTextField addressField = new JTextField(20);
        panel.add(addressField, gbc);

        // Gender
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Gender:"), gbc);
        gbc.gridx = 1;
        JPanel genderPanel = new JPanel();
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderPanel.add(male);
        genderPanel.add(female);
        panel.add(genderPanel, gbc);

        // DOB
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Date of Birth:"), gbc);
        gbc.gridx = 1;
        JPanel dobPanel = new JPanel();
        JComboBox<String> dayBox = new JComboBox<>(Constants.DAYS);
        JComboBox<String> monthBox = new JComboBox<>(Constants.MONTHS);
        JComboBox<String> yearBox = new JComboBox<>(Constants.YEARS);
        dobPanel.add(dayBox);
        dobPanel.add(monthBox);
        dobPanel.add(yearBox);
        panel.add(dobPanel, gbc);

        // Degree
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Degree:"), gbc);
        gbc.gridx = 1;
        JComboBox<String> degreeBox = new JComboBox<>(Constants.DEGREES);
        panel.add(degreeBox, gbc);

        // Batch Number
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Batch Number:"), gbc);
        gbc.gridx = 1;
        JComboBox<String> batchBox = new JComboBox<>(Constants.BATCHNUMBERS);
        panel.add(batchBox, gbc);

        // Roll No
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Roll No:"), gbc);
        gbc.gridx = 1;
        JComboBox<String> rollBox = new JComboBox<>(Constants.ROLLNUMBERS);
        panel.add(rollBox, gbc);

        // Preferred Position
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Preferred Position:"), gbc);
        gbc.gridx = 1;
        JComboBox<String> positionBox = new JComboBox<>(Constants.POSITIONS);
        panel.add(positionBox, gbc);

        // Played Inter-Department
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Played Inter-Department?"), gbc);
        gbc.gridx = 1;
        JCheckBox interDeptCheck = new JCheckBox("Yes");
        panel.add(interDeptCheck, gbc);

        // Experience
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Football Experience:"), gbc);
        gbc.gridx = 1;
        JTextArea experienceArea = new JTextArea(4, 20);
        panel.add(new JScrollPane(experienceArea), gbc);

        // Profile Photo
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Profile Photo:"), gbc);
        gbc.gridx = 1;
        JPanel photoPanel = new JPanel();
        JButton fileButton = new JButton("Choose File");
        JLabel filePathLabel = new JLabel();
        photoPanel.add(fileButton); photoPanel.add(filePathLabel);
        panel.add(photoPanel, gbc);

        final String[] selectedFilePath = {""};
        fileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(frame);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                selectedFilePath[0] = file.getAbsolutePath();
                filePathLabel.setText(file.getName());
            }
        });

        // Submit Button
        gbc.gridx = 1; gbc.gridy++;
        JButton registerBtn = new JButton("Register");
        panel.add(registerBtn, gbc);

        registerBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();
            String address = addressField.getText().trim();
            String gender = male.isSelected() ? "Male" : "Female";
            String dob = dayBox.getSelectedItem() + "-" + monthBox.getSelectedItem() + "-" + yearBox.getSelectedItem();
            String degree = (String) degreeBox.getSelectedItem();
            String batch = (String) batchBox.getSelectedItem();
            String roll = (String) rollBox.getSelectedItem();
            String position = (String) positionBox.getSelectedItem();
            boolean playedInterDept = interDeptCheck.isSelected();
            String experience = experienceArea.getText().trim();
            String photo = selectedFilePath[0];

            Participant participant = new Participant(name,email,phone,address,gender ,dob,degree,batch,roll,position,playedInterDept,experience,photo);
            if (Validator.isValid(participant)) {
                DataHandler.saveToFile(participant,"participants.txt");
            }
            else{
                JOptionPane.showMessageDialog(frame,"Invalid Data");
            }
        });

        frame.add(new JScrollPane(panel));
        frame.setVisible(true);
    }
}
