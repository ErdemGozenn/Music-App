package GUI;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Is_A.Music;
import MainAndSystem.MusicSys;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddFrame extends JFrame {

    private JPanel contentPane;
    private JTextField txtTitle;
    private JTextField txtArtist;
    private JTextField txtGenre;
    private JTextField txtDuration;
    private JTextField txtTheme;
    private JTextField txtYear;
    MainFrame mf;


    void clean() {
        txtTitle.setText("");
        txtArtist.setText("");
        txtGenre.setText("");
        txtDuration.setText("");
        txtTheme.setText("");
        txtYear.setText("");
    }

    /**
     * AddFrame constructor
     */
    public AddFrame(MainFrame frame) {
        mf = frame;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 714, 472);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(25, 23, 350, 345);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Title");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(10, 26, 114, 26);
        panel.add(lblNewLabel);

        JLabel lblArtist = new JLabel("Artist");
        lblArtist.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblArtist.setBounds(10, 62, 114, 26);
        panel.add(lblArtist);

        JLabel lblGenre = new JLabel("Genre");
        lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblGenre.setBounds(10, 98, 114, 26);
        panel.add(lblGenre);

        JLabel lblDuration = new JLabel("Duration");
        lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblDuration.setBounds(10, 128, 114, 31);
        panel.add(lblDuration);

        JLabel lblTheme = new JLabel("Theme");
        lblTheme.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTheme.setBounds(10, 176, 114, 26);
        panel.add(lblTheme);

        JLabel lblReleasedYear = new JLabel("Released Year");
        lblReleasedYear.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblReleasedYear.setBounds(10, 212, 114, 26);
        panel.add(lblReleasedYear);

        txtTitle = new JTextField();
        txtTitle.setBounds(145, 26, 177, 26);
        panel.add(txtTitle);
        txtTitle.setColumns(10);

        txtArtist = new JTextField();
        txtArtist.setColumns(10);
        txtArtist.setBounds(145, 62, 177, 26);
        panel.add(txtArtist);

        txtGenre = new JTextField();
        txtGenre.setColumns(10);
        txtGenre.setBounds(145, 98, 177, 26);
        panel.add(txtGenre);

        txtDuration = new JTextField();
        txtDuration.setColumns(10);
        txtDuration.setBounds(145, 137, 177, 26);
        panel.add(txtDuration);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(385, 23, 305, 345);
        contentPane.add(textArea);

        txtTheme = new JTextField();

        txtTheme.setColumns(10);
        txtTheme.setBounds(145, 176, 177, 26);
        panel.add(txtTheme);
        /*txtTheme.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    boolean res = false;
                    if (txtTitle.getText().equals("") || txtArtist.getText().equals("") || txtGenre.getText().equals("") || txtDuration.getText().equals("")) {
                        textArea.setText("Fill the necessary fields");
                    } else {
                        String title = txtTitle.getText();
                        String artist = txtArtist.getText();
                        String genre = txtGenre.getText();
                        double duration = Double.parseDouble(txtDuration.getText());

                        if (rdbSingle.isSelected()) {
                            if (txtTheme.getText().equals("")) {
                                textArea.setText("Fill the necessary fields.");
                            } else {
                                String theme = txtTheme.getText();
                                res = MusicSys.addTracks("Single", title, artist, duration, genre, 0, theme);
                                if (res) {
                                    textArea.setText("Single is added.");
                                } else {
                                    textArea.setText("A single with the same title already exists in the system.");
                                }
                            }
                        }
                    }
                }
            }
        });*/


        txtYear = new JTextField();
        txtYear.setColumns(10);
        txtYear.setBounds(145, 212, 177, 26);
        panel.add(txtYear);


        JRadioButton rdbSingle = new JRadioButton("Single");
        rdbSingle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbSingle.isSelected()) {
                    txtTheme.setEditable(true);
                    txtYear.setEditable(false);
                }
            }
        });
        rdbSingle.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rdbSingle.setBounds(6, 257, 103, 21);
        panel.add(rdbSingle);

        JRadioButton rdbAlbum = new JRadioButton("Album");
        rdbAlbum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbAlbum.isSelected()) {
                    txtTheme.setEditable(false);
                    txtYear.setEditable(true);
                }
            }
        });
        rdbAlbum.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rdbAlbum.setBounds(145, 259, 103, 21);
        panel.add(rdbAlbum);


        ButtonGroup group = new ButtonGroup();
        group.add(rdbSingle);
        group.add(rdbAlbum);


        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Music res = null;
                if (txtTitle.getText().equals("") || txtArtist.getText().equals("") || txtGenre.getText().equals("") || txtDuration.getText().equals("")) {
                    textArea.setText("Fill the necessary fields");
                } else {
                    String title = txtTitle.getText();
                    String artist = txtArtist.getText();
                    String genre = txtGenre.getText();
                    double duration = Double.parseDouble(txtDuration.getText());
                    
                    if (rdbSingle.isSelected()) {
                        if (txtTheme.getText().equals(""))
                            textArea.setText("Fill the necessary fields.");
                        else {
                            String theme = txtTheme.getText();
                            res = MusicSys.searchMusic(title);
                            if(res!=null)
                            	textArea.setText("A Music with the same title already exists in the system.");
                            else {
                            	MusicSys.addTracks("Single", title, artist, duration, genre, 0, theme);
                            	textArea.setText("Single is added.");
                            	clean();
                            }
                            	
                            
                        }
                    } else if (rdbAlbum.isSelected()) {
                        if (txtYear.getText().equals("")) {
                            textArea.setText("Fill the necessary fields.");
                        } else {
                        	res = MusicSys.searchMusic(title);
                            int year = Integer.parseInt(txtYear.getText());
                            
                            if(res!=null)
                            	textArea.setText("An Music with the same title already exists in the system.");
                            else {
                            	textArea.setText("Album is added.");
                            	MusicSys.addTracks("Album", title, artist, duration, genre, year, "");
                            	clean();
                            }
                            	
                        }
                    }
                }
            }
        });
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAdd.setBounds(55, 284, 85, 49);
        panel.add(btnAdd);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clean();
                textArea.setText("");
            }
        });
        btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnClear.setBounds(216, 286, 85, 49);
        panel.add(btnClear);

        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                mf.setVisible(true);
            }
        });
        btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnClose.setBounds(541, 392, 124, 33);
        contentPane.add(btnClose);
    }
}



