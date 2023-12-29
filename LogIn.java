package USC;
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.security.*;
import java.util.HashMap;
import java.util.Map;

public class LogIn {

	private JFrame frmUscEventManager;
	private JPasswordField password;
	private JTextField schoolID;
	private Map<String, String> registeredUsers = new HashMap<>();

	/**
	 * Launch the application.
	 */
	public JFrame getFrame() {
		return frmUscEventManager;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
					window.frmUscEventManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public LogIn() {
		loadRegisteredUsers();
		initialize();
		frmUscEventManager.setLocationRelativeTo(null); 
		
	}

	private void loadRegisteredUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\rey code\\Code\\src\\USC\\DATA\\USCEventManagementData.txt"))) {
            String line;
            String id = "";
            String encryptedPassword = "";
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("ID:")) {
                    id = line.substring(4).trim();
                } else if (line.startsWith("Password:")) {
                    encryptedPassword = line.substring(10).trim();
                    registeredUsers.put(id, encryptedPassword);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	

	 
	private void initialize() {
		frmUscEventManager = new JFrame();
		frmUscEventManager.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\rey code\\Images\\logo.png"));
		frmUscEventManager.setTitle("USC Event Manager");
		frmUscEventManager.getContentPane().setBackground(new Color(255, 255, 255));
		frmUscEventManager.getContentPane().setForeground(new Color(0, 0, 0));
		frmUscEventManager.setBounds(100, 100, 427, 639);
		frmUscEventManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUscEventManager.getContentPane().setLayout(null);
		frmUscEventManager.setResizable(false);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));
		panel.setBounds(0, 116, 413, 402);
		frmUscEventManager.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(104, 0, 200, 223);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("D:\\rey code\\Images\\logo.png"));
		
		Label label_2 = new Label("SCHOOL ID:");
		label_2.setFont(new Font("Arial Black", Font.BOLD, 14));
		label_2.setBackground(new Color(255, 255, 255));
		label_2.setBounds(30, 250, 153, 25);
		panel.add(label_2);
		
		Label label_2_1 = new Label("PASSWORD:");
		label_2_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		label_2_1.setBackground(Color.WHITE);
		label_2_1.setBounds(30, 295, 153, 25);
		panel.add(label_2_1);
		
		JButton logIn = new JButton("LOG IN");
		logIn.setFont(new Font("Tw Cen MT", Font.BOLD, 11));
		logIn.setBounds(217, 331, 130, 23);
		panel.add(logIn);
		logIn.addActionListener(e -> {
            String enteredID = schoolID.getText().trim();
            String enteredPassword = new String(password.getPassword()).trim();
            String encryptedEnteredPassword = encryptPassword(enteredPassword);

            if (registeredUsers.containsKey(enteredID)) {
                String storedEncryptedPassword = registeredUsers.get(enteredID);

                if (storedEncryptedPassword.equals(encryptedEnteredPassword)) {
                    JOptionPane.showMessageDialog(frmUscEventManager, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    openBookingPage();
                } else {
                    JOptionPane.showMessageDialog(frmUscEventManager, "Incorrect Password. Please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frmUscEventManager, "School ID not found. Please register.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });
		
		
		
		
		password = new JPasswordField();
		password.setBackground(new Color(248, 215, 61));
		password.setFont(new Font("Tahoma", Font.BOLD, 11));
		password.setBounds(189, 295, 173, 25);
		panel.add(password);
		
		schoolID = new JTextField();
		schoolID.setFont(new Font("Tahoma", Font.BOLD, 11));
		schoolID.setBackground(new Color(248, 215, 61));
		schoolID.setBounds(189, 250, 173, 25);
		panel.add(schoolID);
		schoolID.setColumns(10);
		
		
		
		JButton signUp = new JButton("SIGN UP");
		signUp.setFont(new Font("Tw Cen MT", Font.BOLD, 11));
		signUp.setBounds(281, 360, 120, 23);
		panel.add(signUp);
		
        // Add ActionListener to the SIGN UP button
        signUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the SignUp window
                SignUp SignUpPage = new SignUp();
                SignUpPage.main(null);
                frmUscEventManager.setVisible(false);
                
            }
        });

		
		Label label_2_1_1 = new Label("Doesn't have an account? Register here!");
		label_2_1_1.setFont(new Font("Arial", Font.ITALIC, 13));
		label_2_1_1.setBackground(Color.WHITE);
		label_2_1_1.setBounds(30, 360, 373, 25);
		panel.add(label_2_1_1);
		
		Canvas canvas_2 = new Canvas();
		canvas_2.setBackground(new Color(255, 255, 255));
		canvas_2.setBounds(10, 229, 393, 163);
		panel.add(canvas_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 203, 17));
		panel_1.setBounds(0, 0, 413, 602);
		frmUscEventManager.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		Canvas canvas_1 = new Canvas();
		canvas_1.setBounds(10, 30, 413, 11);
		panel_1.add(canvas_1);
		
		Label label = new Label("UNIVERSITY STUDENT COUNCIL");
		label.setBounds(74, 0, 382, 41);
		label.setFont(new Font("Franklin Gothic Heavy", Font.BOLD, 17));
		panel_1.add(label);
		
		Label label_1 = new Label("EVENT MANAGEMENT");
		label_1.setBackground(new Color(255, 255, 255));
		label_1.setBounds(107, 47, 275, 35);
		label_1.setFont(new Font("Franklin Gothic Heavy", Font.BOLD | Font.ITALIC, 19));
		panel_1.add(label_1);
		
		Label label_1_1 = new Label("SYSTEM");
		label_1_1.setBackground(new Color(255, 255, 255));
		label_1_1.setBounds(169, 68, 197, 44);
		label_1_1.setFont(new Font("Franklin Gothic Heavy", Font.BOLD | Font.ITALIC, 19));
		panel_1.add(label_1_1);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(new Color(255, 255, 255));
		canvas.setBounds(10, 39, 393, 73);
		panel_1.add(canvas);
		
		Label label_3 = new Label("Service and Honor,");
		label_3.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 18));
		label_3.setBounds(126, 530, 209, 37);
		panel_1.add(label_3);
		
		Label label_3_1 = new Label("Voices through Actions");
		label_3_1.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 18));
		label_3_1.setBounds(107, 557, 273, 45);
		panel_1.add(label_3_1);
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
		 private void openBookingPage() {
		        // Close the login window
		        frmUscEventManager.dispose();

		        // Open the booking window
		        EventQueue.invokeLater(new Runnable() {
		            public void run() {
		                try {
		                    Booking bookingPage = new Booking();
		                    bookingPage.getFrame().setVisible(true);
		                } catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
		        });
		        
		 }
	}