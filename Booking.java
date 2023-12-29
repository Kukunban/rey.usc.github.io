package USC;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Toolkit;

public class Booking {

    private JFrame frmUscEventManagement;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Booking window = new Booking();
                    window.frmUscEventManagement.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Booking() {
        initialize();
        frmUscEventManagement.setLocationRelativeTo(null);
    }

    private void initialize() {

        frmUscEventManagement = new JFrame();
        frmUscEventManagement.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\rey code\\Images\\logo.png"));
        frmUscEventManagement.setTitle("USC Event Management System");
        frmUscEventManagement.getContentPane().setBackground(new Color(255, 128, 0));
        frmUscEventManagement.setBounds(100, 100, 450, 360);
        frmUscEventManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUscEventManagement.getContentPane().setLayout(null);
        frmUscEventManagement.setResizable(false);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(114, 67, 200, 223);

        ImageIcon icon = new ImageIcon("D:\\rey code\\Images\\logo.png");
        Image image = icon.getImage();

        // Create a new (blank) image with the same dimensions as the original image
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        java.awt.Graphics2D g2d = bufferedImage.createGraphics();

        // Set the transparency
        float opacity = 0.5f; // Opacity of 50%
        g2d.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, opacity));

        // Draw the original image onto the new image
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        ImageIcon newIcon = new ImageIcon(bufferedImage);

        JLabel lblNewLabel_1_1_1 = new JLabel("VISIT DASHBOARD");
        lblNewLabel_1_1_1.setForeground(new Color(0, 0, 160));
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1.setBackground(new Color(0, 0, 160));
        lblNewLabel_1_1_1.setBounds(155, 189, 167, 59);
        frmUscEventManagement.getContentPane().add(lblNewLabel_1_1_1);
        
        JEditorPane editorPane_1_1_1_1 = new JEditorPane();
        editorPane_1_1_1_1.setEditable(false);
        editorPane_1_1_1_1.setBackground(new Color(230, 203, 17));
        editorPane_1_1_1_1.setBounds(150, 204, 146, 29);
        frmUscEventManagement.getContentPane().add(editorPane_1_1_1_1);

        JLabel lblNewLabel_1_1 = new JLabel("PLANNING TO USE THE STUDENT CENTER?");
        lblNewLabel_1_1.setBackground(new Color(0, 0, 160));
        lblNewLabel_1_1.setForeground(new Color(0, 0, 160));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1.setBounds(73, 80, 313, 78);
        frmUscEventManagement.getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_2 = new JLabel("Maintained By: Rey Loremia");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
        lblNewLabel_2.setBounds(288, 298, 138, 14);
        frmUscEventManagement.getContentPane().add(lblNewLabel_2);

        JButton btnNewButton_1 = new JButton("BOOK NOW!");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmUscEventManagement.setVisible(false); // Hide the main booking page
                ImageIcon dialogIcon = new ImageIcon("D:\\rey code\\Images\\logo.png");
                
                String eventName = "";
                while (true) {
                eventName = (String) JOptionPane.showInputDialog(frmUscEventManagement, "Enter event name:",
                        "USC Event Management System", JOptionPane.QUESTION_MESSAGE, dialogIcon, null, null);
                if (eventName != null && !eventName.trim().isEmpty()) {
                    break; // Break the loop if the input is not null and not empty
                } else {
                    JOptionPane.showMessageDialog(frmUscEventManagement, "Please enter the event name.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }        
                String institute = "";
                while (true) {
                    institute = (String) JOptionPane.showInputDialog(frmUscEventManagement, "Enter institute name:",
                            "USC Event Management System", JOptionPane.QUESTION_MESSAGE, dialogIcon, null, null);
                    if (institute != null && !institute.trim().isEmpty()) {
                        break; // Break the loop if the input is not null and not empty
                    } else {
                        JOptionPane.showMessageDialog(frmUscEventManagement, "Please enter the institute name.", "USC Event Management System", JOptionPane.ERROR_MESSAGE);
                    }
                }
                String date = "";
                while (true) {
                    date = (String) JOptionPane.showInputDialog(frmUscEventManagement, "Enter the date of your:",
                            "USC Event Management System", JOptionPane.QUESTION_MESSAGE, dialogIcon, null, null);
                    if (date != null && !date.trim().isEmpty()) {
                        break; // Break the loop if the input is not null and not empty
                    } else {
                        JOptionPane.showMessageDialog(frmUscEventManagement, "Please enter the date of the event.", "USC Event Management System", JOptionPane.ERROR_MESSAGE);
                    }
                }
                String time = "";
                while (true) {
                    time = (String) JOptionPane.showInputDialog(frmUscEventManagement, "Enter time of event:",
                            "USC Event Management System", JOptionPane.QUESTION_MESSAGE, dialogIcon, null, null);
                    if (time != null && !time.trim().isEmpty()) {
                        break; // Break the loop if the input is not null and not empty
                    } else {
                        JOptionPane.showMessageDialog(frmUscEventManagement, "Please enter the time of the event.", "USC Event Management System", JOptionPane.ERROR_MESSAGE);
                    }
                }

                if (date != null && time != null && eventName != null && institute != null && !date.trim().isEmpty()
                        && !time.trim().isEmpty() && !eventName.trim().isEmpty() && !institute.trim().isEmpty()) {
                    System.out.println("Date: " + date);
                    System.out.println("Time: " + time);
                    System.out.println("Event Name: " + eventName);
                    System.out.println("Institute: " + institute);
                    saveBookingDetails(eventName, institute, date, time); // Call method to save details
                    JOptionPane.showMessageDialog(frmUscEventManagement,
                            "IT MUST BE CLEANED BEFORE AND AFTER YOU USE IT!");
                    frmUscEventManagement.setVisible(true); // Reappear the main booking page
                } else {
                    JOptionPane.showMessageDialog(frmUscEventManagement, "Please fill in all details!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    frmUscEventManagement.setVisible(true); // Reappear the main booking page
                }
            }
        });

        JButton btnToDashboard = new JButton("TO DASHBOARD");
        btnToDashboard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the EventDashboard window
                EventDashboard eventDashboard = new EventDashboard();
                JFrame dashboardFrame = (JFrame) eventDashboard.getFrame();
                dashboardFrame.setLocationRelativeTo(null); // Center the dashboard window
                dashboardFrame.setVisible(true);

                // Close the current Booking window
                frmUscEventManagement.setVisible(false);
            }
        });
        btnToDashboard.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnToDashboard.setBounds(158, 244, 128, 30);
        frmUscEventManagement.getContentPane().add(btnToDashboard);

        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton_1.setBounds(150, 148, 145, 45);
        frmUscEventManagement.getContentPane().add(btnNewButton_1);

        JEditorPane editorPane_1_1_1 = new JEditorPane();
        editorPane_1_1_1.setEditable(false);
        editorPane_1_1_1.setBackground(new Color(230, 203, 17));
        editorPane_1_1_1.setBounds(58, 100, 326, 37);
        frmUscEventManagement.getContentPane().add(editorPane_1_1_1);

        JLabel lblNewLabel_1 = new JLabel("WELCOME TATA!");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 29));
        lblNewLabel_1.setBounds(98, 11, 245, 78);
        frmUscEventManagement.getContentPane().add(lblNewLabel_1);
        lblNewLabel.setIcon(newIcon);
        frmUscEventManagement.getContentPane().add(lblNewLabel);

        frmUscEventManagement.setVisible(true);

        JEditorPane editorPane = new JEditorPane();
        editorPane.setBackground(new Color(0, 128, 255));
        editorPane.setBounds(10, 11, 416, 301);
        frmUscEventManagement.getContentPane().add(editorPane);
        
        JLabel label = new JLabel("New label");
        label.setBounds(174, 80, 49, 14);
        frmUscEventManagement.getContentPane().add(label);
    }

    public Window getFrame() {
        return frmUscEventManagement;
    }

    private void saveBookingDetails(String eventName, String institute, String date, String time) {
        try (FileWriter writer = new FileWriter("D:\\rey code\\Code\\src\\USC\\DATA\\BookingDetails.txt", true)) {
            // Write the details with commas as delimiters
            String details = eventName + "," + institute + "," + date + "," + time + "\n"; // Separate each entry by a new line
            writer.write(details);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    }
