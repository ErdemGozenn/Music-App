package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Is_A.*;
import MainAndSystem.MusicSys;

public class PlaylistSet extends JFrame {

	private static final long serialVersionUID = 1L;

	   private JPanel contentPane;
	    private JTextField txtTitle;
	    private JTextField txtArtist;
	    private JTextField txtGenre;
	    private JTextField txtDuration;
	    private JTextField txtTheme;
	    MainFrame mf;


	    void clean() {
	        txtTitle.setText("");
	        txtArtist.setText("");
	        txtGenre.setText("");
	        txtDuration.setText("");
	        txtTheme.setText("");
	      
	    }
	    
	    AddPlaylistFrame apf;
	    
	    
	public PlaylistSet(AddPlaylistFrame frame) {
		apf = frame;
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 714, 472);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JPanel panel = new JPanel();
	        panel.setBounds(25, 23, 350, 392);
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


	        ButtonGroup group = new ButtonGroup();


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
	                    
	                 
	                        if (txtTheme.getText().equals(""))
	                            textArea.setText("Fill the necessary fields.");
	                        else {
	                            String theme = txtTheme.getText();
	                           boolean ck =  MusicSys.addPlaylist( title, artist,  duration,  genre,  theme);
	                         
	                           if(ck)
	                        	{
	                        	   textArea.setText("Single is added into "+ MusicSys.p1.getName()+" playlist.");
	                        	   clean();
	                        	}
	                           else
	                           {
	                        	   textArea.setText("The single already exist in " + MusicSys.p1.getName()+" playlist.");
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
	        
	        JButton btnDisplay = new JButton("Display");
	        btnDisplay.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String res = "";
	        		res += MusicSys.displayPlaylist();
	        		res += "Playlist Size: " + MusicSys.calculatePlaylistSize();
	        		res += "Total Duration: " + MusicSys.calculateDurationForPlaylist();
	        		textArea.setText(res);
	        	}
	        });
	        btnDisplay.setBounds(55, 341, 250, 45);
	        panel.add(btnDisplay);

	        JButton btnClose = new JButton("Close");
	        btnClose.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                dispose();
	                apf.setVisible(true);
	            }
	        });
	        btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        btnClose.setBounds(541, 392, 124, 33);
	        contentPane.add(btnClose);
	    }
	}


