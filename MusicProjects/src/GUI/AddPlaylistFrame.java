package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainAndSystem.MusicSys;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPlaylistFrame extends JFrame {

	private JPanel contentPane;

	MainFrame mf;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	PlaylistSet set = new PlaylistSet(this);
	
	public AddPlaylistFrame(MainFrame frame) {
		mf = frame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblNewLabel.setBounds(44, 39, 67, 32);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(156, 44, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusicSys.p1.setName((String)textField.getText());
				set.setVisible(true);
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(156, 103, 96, 38);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				mf.setVisible(true);
			}
		});
		btnClose.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClose.setBounds(156, 178, 96, 38);
		contentPane.add(btnClose);
	}
}
