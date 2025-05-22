package GUI;

import java.awt.Font;
import java.awt.event.*;
import java.util.Set;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import MainAndSystem.MusicSys;
import Is_A.Music;

public class SearchFrame extends JFrame {

    private JPanel contentPane;
    private MainFrame mainFrame;
    private JComboBox<String> cbTitle; // ComboBox declared as a field for easier access

    /**
     * Create the frame.
     */
    public SearchFrame(MainFrame frame) {
        setTitle("Search Frame");
        this.mainFrame = frame;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 556, 365);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Title");
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTitle.setBounds(28, 33, 68, 31);
        contentPane.add(lblTitle);

        // Initialize ComboBox for titles
        cbTitle = new JComboBox<>();
        cbTitle.setBounds(212, 33, 136, 31);
        contentPane.add(cbTitle);

        // Populate ComboBox initially
        updateComboBox();

        // TextArea for displaying details
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBounds(38, 100, 460, 154);
        contentPane.add(textArea);

        // ScrollPane for TextArea
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(38, 100, 460, 154);
        contentPane.add(scrollPane);

        // Search Button
        JButton btnSearch = new JButton("SEARCH");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedTitle = (String) cbTitle.getSelectedItem();
                if (selectedTitle != null) {
                    Music foundMusic = MusicSys.searchMusic(selectedTitle); // Assuming "searchMusicByTitle" searches by title.
                    if (foundMusic != null) {
                        textArea.setText(foundMusic.toString());
                    } else {
                        textArea.setText("No music found with the title: " + selectedTitle);
                    }
                }
            }
        });
        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSearch.setBounds(382, 33, 116, 31);
        contentPane.add(btnSearch);

        // Close Button
        JButton btnClose = new JButton("CLOSE");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                mainFrame.setVisible(true);
            }
        });
        btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnClose.setBounds(402, 282, 97, 36);
        contentPane.add(btnClose);

        // Add WindowFocusListener to refresh ComboBox when frame gains focus
        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                updateComboBox();
            }
        });

        // Optional: Timer for periodic updates (e.g., every 5 seconds)
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateComboBox();
            }
        });
        timer.start();
    }

    /**
     * Updates the ComboBox with the latest titles from MusicSys.
     */
    private void updateComboBox() {
        cbTitle.removeAllItems(); // Clear current items
        Set<Music> allTracks = MusicSys.getSeries(); // Get updated series
        if (allTracks == null || allTracks.isEmpty()) {
            System.out.println("MusicSys.getSeries() returned an empty set.");
        } else {
            System.out.println("Updating ComboBox with the following tracks:");
            for (Music track : allTracks) {
                String title = track.getTitle();
                if (title == null || title.isEmpty()) {
                    System.out.println("Skipping track with invalid title: " + track);
                } else {
                    cbTitle.addItem(title);
                    System.out.println("Added title to ComboBox: " + title);
                }
            }
        }
        cbTitle.revalidate();
        cbTitle.repaint();
    }
}
