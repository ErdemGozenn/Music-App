package GUI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class StartPage extends JFrame {

    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public StartPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 955, 535);

        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load and draw the background image
                ImageIcon background = new ImageIcon("C:\\Users\\lenovo\\Desktop/indire.jpg");
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        contentPane.setLayout(null); // Use absolute positioning
        setContentPane(contentPane);

        // Add JLabel for the message
        JLabel clickMessage = new JLabel("Click the screen for opening the main page");
        clickMessage.setFont(new Font("Arial", Font.BOLD, 24));
        clickMessage.setForeground(Color.DARK_GRAY);
        clickMessage.setHorizontalAlignment(SwingConstants.CENTER);
        clickMessage.setBounds(0, 215, 955, 102); // Centered message
        contentPane.add(clickMessage);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("/Users/erdemgozen/eclipse-workspace/MusicProjects/src/WhatsApp Image 2024-12-20 at 10.42.17 PM.jpeg"));
        lblNewLabel.setBounds(22, 0, 955, 501);
        contentPane.add(lblNewLabel);

        // Add mouse click listener
        contentPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Open MainFrame when the screen is clicked
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
                dispose(); // Close the StartPage
            }
        });
    }
}