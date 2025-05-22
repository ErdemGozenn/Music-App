package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import MainAndSystem.MusicSys;
import Is_A.Music;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;

public class DeleteFrame extends JFrame {

    private JPanel contentPane;
    private JComboBox<String> comboBox;
    private JTextArea textArea;
    private MainFrame mf;
    private Timer timer;

    /**
     * Create the frame.
     */
    public DeleteFrame(MainFrame frame) {
        mf = frame;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 548, 357);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Delete");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(35, 36, 70, 38);
        contentPane.add(lblNewLabel);

        comboBox = new JComboBox<>();
        comboBox.setBounds(198, 36, 138, 38);
        contentPane.add(comboBox);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(70, 95, 405, 153);
        contentPane.add(textArea);

        
        startComboBoxUpdateTimer();

        JButton btnDelete = new JButton("DELETE");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedTitle = (String) comboBox.getSelectedItem();
                if (selectedTitle != null) {
                 
                    Music foundMusic = MusicSys.searchMusic(selectedTitle);
                    if (foundMusic != null) {
                      
                        MusicSys.deleteMusic(selectedTitle);

                       
                        Music checkMusic = MusicSys.searchMusic(selectedTitle);
                        if (checkMusic == null) {
                            comboBox.removeItem(selectedTitle); 
                            textArea.setText("Music titled \"" + selectedTitle + "\" has been successfully deleted.");
                        } else { 
                            textArea.setText("Failed to delete music titled \"" + selectedTitle + "\".");
                        }
                    } else {
                        textArea.setText("No music found with the title: \"" + selectedTitle + "\".");
                    }
                } else {
                    textArea.setText("Please select a title to delete.");
                }
            }
        });
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnDelete.setBounds(383, 36, 92, 38);
        contentPane.add(btnDelete);

        JButton btnClose = new JButton("CLOSE");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                mf.setVisible(true);
                if (timer != null) {
                    timer.cancel(); 
                }
            }
        });
        btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnClose.setBounds(383, 278, 92, 32);
        contentPane.add(btnClose);
    }

  //Update in each 2 sec
    private void startComboBoxUpdateTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        updateComboBox();
                    }
                });
            }
        }, 0, 2000); 
    }

   
    private void updateComboBox() {
        // ComboBox'ı sıfırla
        comboBox.removeAllItems();

      
        Set<Music> allTracks = MusicSys.getSeries();

        if (allTracks.isEmpty()) {
            textArea.setText("No tracks available in the system.");
        } else {
            for (Music track : allTracks) {
                comboBox.addItem(track.getTitle());
            }
        }
    }
}
