package phishtank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Help {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void Help1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help window = new Help();
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
	public Help() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 749, 521);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\kripanshu\\Desktop\\Screenshot.jpg"));
		lblNewLabel.setBounds(4, 0, 529, 471);
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea txtrSteps = new JTextArea();
		txtrSteps.setText("STEPS -\r\n1. Enter the URL .\r\n2. Click on SEARCH button\r\n for evaluation of URL .\r\n3. Click on ANALYSIS button \r\nfor Classification report to \r\nmatch results .\r\n\r\n");
		txtrSteps.setBounds(512, 11, 221, 283);
		frame.getContentPane().add(txtrSteps);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			}
		});
		btnOk.setBackground(SystemColor.activeCaption);
		btnOk.setBounds(585, 389, 89, 23);
		frame.getContentPane().add(btnOk);
	}
}
