package phishtank;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class Table {

	private JFrame frame;
	static String out="";

	/**
	 * Launch the application.
	 */
	public  void table() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					
					Table window = new Table();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Table() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 718, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 55, 672, 401);
		frame.getContentPane().add(textArea);
		JButton btnGetContents = new JButton("GET CONTENTS");
		btnGetContents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Evaluation s=new Evaluation();
				try {
					out=s.chartsvm();
					textArea.setText(out);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnGetContents.setFont(new Font("Arial", Font.BOLD, 12));
		btnGetContents.setBackground(SystemColor.activeCaption);
		btnGetContents.setBounds(266, 11, 137, 23);
		frame.getContentPane().add(btnGetContents);
	
	}
}
