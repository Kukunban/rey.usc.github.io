package USC;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EventDashboard {

    private JFrame frame;
    private JPanel contentPanel;
    private CardLayout cardLayout;
    private JTable dataTable;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EventDashboard window = new EventDashboard();
                    window.frame.setVisible(true);
                    window.frame.setLocationRelativeTo(null); // Center the JFrame
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public EventDashboard() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBackground(new Color(0, 128, 192));
        frame.setForeground(new Color(0, 128, 192));
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\rey code\\Images\\logo.png"));
        frame.setTitle("USC Event Management Dashboard");
        frame.setBounds(100, 100, 500, 400); // Adjusted the frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        frame.getContentPane().setBackground(new Color(0, 128, 255));
        frame.setResizable(false);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 128, 255));
        frame.getContentPane().add(headerPanel, BorderLayout.NORTH);
        headerPanel.setLayout(null);

        JLabel titleLabel = new JLabel("USC Event Management System");
        titleLabel.setBounds(120, 5, 306, 24);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);

        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(new Color(0, 128, 255));
        frame.getContentPane().add(menuPanel, BorderLayout.WEST);
        menuPanel.setLayout(new GridLayout(2, 1, 0, 20)); // Updated rows to accommodate the removed button

        JButton btnEvents = new JButton("Events");
        btnEvents.setBackground(new Color(230, 203, 17)); // #e6cb11 color code for yellow-orange
        btnEvents.setFont(new Font("Sylfaen", Font.BOLD, 13));
        menuPanel.add(btnEvents);

        JButton btnUsers = new JButton("Users");
        btnUsers.setBackground(new Color(230, 203, 17));
        btnUsers.setFont(new Font("Sylfaen", Font.BOLD, 13));
        menuPanel.add(btnUsers);

        contentPanel = new JPanel();
        frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);

        // Create a DefaultTableModel with columns
        String[] columnNames = {"Event Name", "Institute", "Date", "Time"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        dataTable = new JTable(model); // Assign to the class-level dataTable variable
        JScrollPane scrollPane = new JScrollPane(dataTable);
        scrollPane.setBackground(new Color(230, 203, 17)); // Set background color to yellow-orange (#e6cb11)
        scrollPane.setEnabled(false);
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        dataTable.setDefaultEditor(Object.class, null);
        JTableHeader header = dataTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 12));
        header.setBackground(new Color(0, 128, 255)); // Set background color to blue (#0080FF)
        header.setForeground(Color.WHITE);

        // Set the table's cell renderer to display the logo as a watermark
        ImageIcon logo = new ImageIcon("‪D:\\rey code\\Images\\logo.png"); // Replace with the actual path to your logo
        dataTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setIcon(logo);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setOpaque(false);

                // Set the opacity (50% transparent)
                label.setBackground(new Color(255, 255, 255, 127)); // Adjust alpha value for opacity

                return label;
            }
        });

        // Button actions
        btnEvents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Events");
                loadBookedEventsToTable();
            }
        });

        btnUsers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Users");
                frame.setVisible(false);
                int registeredUserCount = getRegisteredUserCount(); // Fetch the count of registered users

                JOptionPane.showMessageDialog(frame,
                        "Number of registered users: " + registeredUserCount,
                        "Registered Users", JOptionPane.INFORMATION_MESSAGE);
                frame.setVisible(true);
            }
        });

        // Show the welcome panel initially
        cardLayout.show(contentPanel, "Welcome");
    }

    private void loadBookedEventsToTable() {
        DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
        model.setRowCount(0); // Clear existing data

        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\rey code\\Code\\src\\USC\\DATA\\BookingDetails.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                model.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getRegisteredUserCount() {
        int count = 0;
        // Logic to retrieve the count of registered users (from file/database)
        // You should replace this logic with your actual data retrieval mechanism
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\rey code\\Code\\src\\USC\\DATA\\USCEventManagementData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("ID:")) {
                    count++; // Increment count for each user ID found
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public Window getFrame() {
        return frame;
    }
}
