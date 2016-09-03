package phishtank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmptyText {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public  void emptytext() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmptyText window = new EmptyText();
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
	public EmptyText() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 349, 215);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterTheUrl = new JLabel("ENTER THE URL FIRST !");
		lblEnterTheUrl.setForeground(new Color(0, 102, 51));
		lblEnterTheUrl.setBounds(102, 35, 192, 14);
		frame.getContentPane().add(lblEnterTheUrl);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			}
		});
		btnOk.setBackground(SystemColor.activeCaption);
		btnOk.setBounds(113, 115, 89, 23);
		frame.getContentPane().add(btnOk);
	}
}
