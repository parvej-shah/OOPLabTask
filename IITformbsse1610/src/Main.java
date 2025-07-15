import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("IITDU Football League Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);

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

        // Gender
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Gender:"), gbc);
        gbc.gridx = 1;
        JPanel genderPanel = new JPanel();
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JRadioButton other = new JRadioButton("Other");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male); genderGroup.add(female); genderGroup.add(other);
        genderPanel.add(male); genderPanel.add(female); genderPanel.add(other);
        panel.add(genderPanel, gbc);

        // DOB
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Date of Birth:"), gbc);
        gbc.gridx = 1;
        JPanel dobPanel = new JPanel();
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) days[i - 1] = String.valueOf(i);
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] years = new String[31];
        for (int i = 0; i < 31; i++) years[i] = String.valueOf(1990 + i);
        JComboBox<String> dayBox = new JComboBox<>(days);
        JComboBox<String> monthBox = new JComboBox<>(months);
        JComboBox<String> yearBox = new JComboBox<>(years);
        dobPanel.add(dayBox); dobPanel.add(monthBox); dobPanel.add(yearBox);
        panel.add(dobPanel, gbc);

        // Degree
        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Degree:"), gbc);
        gbc.gridx = 1;
        String[] degrees = {"BSc in CSE", "MSc in CSE", "PhD in CSE"};
        JComboBox<String> degreeBox = new JComboBox<>(degrees);
        panel.add(degreeBox, gbc);

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
            String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : (other.isSelected() ? "Other" : ""));
            String dob = dayBox.getSelectedItem() + "-" + monthBox.getSelectedItem() + "-" + yearBox.getSelectedItem();
            String degree = (String) degreeBox.getSelectedItem();
            String photo = selectedFilePath[0];

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || gender.isEmpty() || photo.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields and upload a photo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (FileWriter writer = new FileWriter("registration_data.txt", true)) {
                writer.write("Name: " + name + "\n");
                writer.write("Email: " + email + "\n");
                writer.write("Phone: " + phone + "\n");
                writer.write("Gender: " + gender + "\n");
                writer.write("DOB: " + dob + "\n");
                writer.write("Degree: " + degree + "\n");
                writer.write("Photo Path: " + photo + "\n");
                writer.write("-----------------------------------\n");

                JOptionPane.showMessageDialog(frame, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.add(new JScrollPane(panel));
        frame.setVisible(true);
    }
}
