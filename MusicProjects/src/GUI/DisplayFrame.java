package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.border.EmptyBorder;

import MainAndSystem.MusicSys;

public class DisplayFrame extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */

    MainFrame mf;

    /**
     * Create the frame.
     */
    public DisplayFrame(MainFrame frame) {
        setTitle("Display Frame");
        mf = frame;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 527, 347);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JRadioButton rdbAll = new JRadioButton("All");
        rdbAll.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rdbAll.setBounds(32, 27, 117, 44);
        contentPane.add(rdbAll);

        JRadioButton rdbTitle = new JRadioButton("Title");
        rdbTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rdbTitle.setBounds(195, 27, 117, 44);
        contentPane.add(rdbTitle);

        JRadioButton rdbArtist = new JRadioButton("Artist");
        rdbArtist.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rdbArtist.setBounds(356, 27, 117, 44);
        contentPane.add(rdbArtist);

        // Group the radio buttons to allow only one selection at a time
        ButtonGroup group = new ButtonGroup();
        group.add(rdbAll);
        group.add(rdbTitle);
        group.add(rdbArtist);

        JTextArea textArea = new JTextArea();
        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (rdbAll.isSelected()) {
                    if (MusicSys.getSeries().isEmpty()) {
                        textArea.setText("Add to single or music first");
                    } else {
                        textArea.setText(MusicSys.displayTracks());
                    }
                } else if (rdbTitle.isSelected()) {
                    if (MusicSys.getSeries().isEmpty()) {
                        textArea.setText("Add to single or music first");
                    } else {
                        textArea.setText(MusicSys.displayTracks());
                    }
                } else {
                    if (MusicSys.getSeries().isEmpty()) {
                        textArea.setText("Add to single or music first");
                    } else {
                        textArea.setText(MusicSys.displayTracks());
                    }
                }
            }
        });
        textArea.setText("");
        textArea.setBounds(86, 77, 318, 169);
        contentPane.add(textArea);

        JButton btnNewButton = new JButton("DISPLAY");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbAll.isSelected()) {
                    if (MusicSys.getSeries().isEmpty()) {
                        textArea.setText("Add to single or music first");
                    } else {
                        textArea.setText(MusicSys.displayTracks());
                    }
                } else if (rdbTitle.isSelected()) {
                    if (MusicSys.getSeries().isEmpty()) {
                        textArea.setText("Add to single or music first");
                    } else {
                        textArea.setText(MusicSys.displayTracks());
                    }
                } else {
                    if (MusicSys.getSeries().isEmpty()) {
                        textArea.setText("Add to single or music first");
                    } else {
                        textArea.setText(MusicSys.displayTracks());
                    }
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(195, 269, 117, 31);
        contentPane.add(btnNewButton);

        JButton btnClose = new JButton("CLOSE");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                mf.setVisible(true);
            }
        });
        btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnClose.setBounds(386, 276, 117, 31);
        contentPane.add(btnClose);
    }
}
