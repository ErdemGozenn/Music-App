package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainFrame extends JFrame {

    private JPanel contentPane;

    /**
     * Frame instances for navigation
     */
    AddFrame ad = new AddFrame(this);
    SearchFrame sf = new SearchFrame(this);
    DisplayFrame df = new DisplayFrame(this);
    DeleteFrame dff = new DeleteFrame(this);
    AddPlaylistFrame tf = new AddPlaylistFrame(this);

    /**
     * Create the frame.
     */
    public MainFrame() {
        setTitle("Music Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 639, 371);

        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load and draw the background image
                ImageIcon background = new ImageIcon("path/to/your/image.jpg");
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Add button: Navigate to AddFrame
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ad.setVisible(true);
                setVisible(false);
            }
        });
        btnAdd.setBounds(31, 20, 137, 97);
        contentPane.add(btnAdd);

        // Search button: Navigate to SearchFrame
        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sf.setVisible(true);
                setVisible(false);
            }
        });
        btnSearch.setBounds(253, 20, 137, 97);
        contentPane.add(btnSearch);

        // Display button: Navigate to DisplayFrame
        JButton btnDisplay = new JButton("Display");
        btnDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                df.setVisible(true);
                setVisible(false);
            }
        });
        btnDisplay.setBounds(463, 20, 137, 97);
        contentPane.add(btnDisplay);

        // Add Playlist button: Navigate to AddPlaylistFrame
        JButton btnTotalDuration = new JButton("Add Playlist");
        btnTotalDuration.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setVisible(true);
                setVisible(false);
            }
        });
        btnTotalDuration.setBounds(31, 172, 137, 97);
        contentPane.add(btnTotalDuration);

        // Delete button: Navigate to DeleteFrame
        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dff.setVisible(true);
                setVisible(false);
            }
        });
        btnDelete.setBounds(253, 172, 137, 97);
        contentPane.add(btnDelete);

        // Exit button: Close the application
        JButton btnExit = new JButton("EXIT");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnExit.setBounds(463, 172, 137, 97);
        contentPane.add(btnExit);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
