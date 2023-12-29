package USC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.security.*;
import java.util.HashSet;
import java.util.Set;

public class SignUp {
	

    private JFrame frmSignUp;
    private JTextField usernameField;
    private JTextField schoolID;
    private JPasswordField passwordField_1;
    private JTextField facultyField;
    private Set<String> registeredUsernames = new HashSet<>();
    private Set<String> registeredSchoolIDs = new HashSet<>();
    private Set<String> registeredFaculties = new HashSet<>();
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignUp window = new SignUp();
                    window.frmSignUp.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SignUp() {
        registeredUsernames = new HashSet<>();
        registeredSchoolIDs = new HashSet<>();
        registeredFaculties = new HashSet<>();
        loadExistingData(); // Load existing data when initializing
        initialize();
        frmSignUp.setLocationRelativeTo(null);
    }

    private void initialize() {
        frmSignUp = new JFrame();
        frmSignUp.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\rey code\\Images\\logo.png"));
        frmSignUp.setTitle("Register - USC Event Manager");
        frmSignUp.getContentPane().setBackground(new Color(255, 255, 255));
        frmSignUp.getContentPane().setForeground(new Color(0, 0, 0));
        frmSignUp.setBounds(100, 100, 427, 639);
        frmSignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmSignUp.getContentPane().setLayout(null);
        frmSignUp.setResizable(false);
        
        
        JPanel faculty = new JPanel();
        faculty.setBackground(new Color(0, 128, 255));
        faculty.setBounds(0, 116, 413, 402);
        frmSignUp.getContentPane().add(faculty);
        faculty.setLayout(null);
        
        JButton registerButton = new JButton("REGISTER");
        registerButton.setBounds(194, 346, 130, 23);
        registerButton.setFont(new Font("Tw Cen MT", Font.BOLD, 11));
        faculty.add(registerButton);
        registerButton.addActionListener(e -> saveUserData());
        
        JLabel logoLabel = new JLabel("");
        logoLabel.setBounds(111, 0, 211, 204);
        faculty.add(logoLabel);
        logoLabel.setIcon(new ImageIcon("D:\\rey code\\Images\\logo.png"));
        
        JLabel usernameLabel = new JLabel("NAME:");
        usernameLabel.setBounds(39, 207, 100, 25);
        usernameLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
        usernameLabel.setForeground(Color.WHITE);
        faculty.add(usernameLabel);
        
        JLabel emailLabel = new JLabel("SCHOOL ID:");
        emailLabel.setBounds(39, 243, 100, 25);
        emailLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
        emailLabel.setForeground(Color.WHITE);
        faculty.add(emailLabel);
        
        JLabel passwordLabel = new JLabel("FACULTY:");
        passwordLabel.setBounds(39, 279, 100, 25);
        passwordLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
        passwordLabel.setForeground(Color.WHITE);
        faculty.add(passwordLabel);
        
        usernameField = new JTextField();
        usernameField.setBounds(159, 207, 200, 25);
        faculty.add(usernameField);
        usernameField.setColumns(10);
        
        schoolID = new JTextField();
        schoolID.setBounds(159, 243, 200, 25);
        faculty.add(schoolID);
        schoolID.setColumns(10);
        
        JLabel passwordLabel_1 = new JLabel("PASSWORD:");
        passwordLabel_1.setBounds(39, 316, 100, 25);
        passwordLabel_1.setForeground(Color.WHITE);
        passwordLabel_1.setFont(new Font("Arial Black", Font.BOLD, 14));
        faculty.add(passwordLabel_1);
        
        passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(159, 316, 200, 25);
        faculty.add(passwordField_1);
        
        facultyField = new JTextField();
        facultyField.setBounds(159, 279, 200, 25);
        facultyField.setColumns(10);
        faculty.add(facultyField);
        
        JButton LogIn = new JButton("Login");
        LogIn.setFont(new Font("Tw Cen MT", Font.BOLD, 11));
        LogIn.setBounds(293, 378, 89, 23);
        LogIn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		LogIn.addActionListener(new ActionListener() {
        		    public void actionPerformed(ActionEvent e) {
        		       
        		        LogIn logInPage = new LogIn();
        		        logInPage.main(null);
        		        frmSignUp.setVisible(false);
        		    }
        		});

        	}
        });
        
        faculty.add(LogIn);
        
        JLabel lblNewLabel = new JLabel("Already have and account? Click Login.");
        lblNewLabel.setBounds(17, 384, 266, 14);
        lblNewLabel.setFont(new Font("Arial", Font.ITALIC, 13));
        faculty.add(lblNewLabel);
        
        // ActionListener for the REGISTER button
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Save user data to a text file
                saveUserData();
            }
        });
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(230, 203, 17));
        panel_1.setBounds(0, 0, 413, 602);
        frmSignUp.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JLabel titleLabel = new JLabel("REGISTER");
        titleLabel.setBounds(141, 32, 181, 41);
        titleLabel.setFont(new Font("Franklin Gothic Heavy", Font.BOLD, 24));
        panel_1.add(titleLabel);
        
        JLabel subtitleLabel = new JLabel("Create an Account");
        subtitleLabel.setBounds(124, 70, 193, 20);
        subtitleLabel.setFont(new Font("Franklin Gothic Heavy", Font.BOLD | Font.ITALIC, 17));
        panel_1.add(subtitleLabel);
        
        Label label_3 = new Label("Service and Honor,");
        label_3.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 18));
        label_3.setBounds(124, 520, 209, 37);
        panel_1.add(label_3);
        
        Label label_3_1 = new Label("Voices through Actions");
        label_3_1.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 18));
        label_3_1.setBounds(105, 547, 273, 45);
        panel_1.add(label_3_1);
    }
    private void loadExistingData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\rey code\\Code\\src\\USC\\DATA\\USCEventManagementData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name:")) {
                    registeredUsernames.add(line.substring(6).trim());
                } else if (line.startsWith("ID:")) {
                    registeredSchoolIDs.add(line.substring(4).trim());
                } else if (line.startsWith("Faculty:")) {
                    registeredFaculties.add(line.substring(8).trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void saveUserData() {
        String username = usernameField.getText().trim();
        String email = schoolID.getText().trim();
        String faculty = facultyField.getText().trim();
        String password = new String(passwordField_1.getPassword()).trim();

        if (username.isEmpty() || email.isEmpty() || faculty.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(frmSignUp, "Please fill in all fields.", "Incomplete Information", JOptionPane.WARNING_MESSAGE);
        } else if (!isValidSchoolID(email)) {
            JOptionPane.showMessageDialog(frmSignUp, "Please enter a valid School ID.", "Invalid School ID", JOptionPane.WARNING_MESSAGE);
        } else if (registeredUsernames.contains(username) || registeredSchoolIDs.contains(email) || registeredFaculties.contains(faculty)) {
            JOptionPane.showMessageDialog(frmSignUp, "Data already exists. Login to continue.", "Duplicate Data", JOptionPane.WARNING_MESSAGE);
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\rey code\\Code\\src\\USC\\DATA\\USCEventManagementData.txt", true))) {

                // Encrypt the password using SHA-256
                String encryptedPassword = encryptPassword(password);

                // Write user data to the text file with organized format
                String userData = "Name: " + username + "\nID: " + email + "\nFaculty: " + faculty + "\nPassword: " + encryptedPassword + "\n";
                writer.write(userData);

                // Add registered data to the sets
                registeredUsernames.add(username);
                registeredSchoolIDs.add(email);
                registeredFaculties.add(faculty);

                // Clear the fields after saving
                usernameField.setText("");
                schoolID.setText("");
                facultyField.setText("");
                passwordField_1.setText("");

                JOptionPane.showMessageDialog(frmSignUp, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                System.out.println("User data saved successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    

    private boolean isValidSchoolID(String id) {
        // School ID should be 9 characters long, including 8 numbers and 1 special character
        // Check for 8 digits and 1 special character anywhere in the string
        return id.length() == 9 && id.matches("(?=.*[!@#$%^&*()_+\\-={}\\[\\]|;:'\"<>,.?/\\\\])(?=.*\\d).{9}");
    }


    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            StringBuilder stringBuilder = new StringBuilder();
            for (byte hashedByte : hashedBytes) {
                stringBuilder.append(Integer.toString((hashedByte & 0xff) + 0x100, 16).substring(1));
            }

            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    
}
}