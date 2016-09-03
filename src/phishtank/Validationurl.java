package phishtank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Validationurl {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void validate() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Validationurl window = new Validationurl();
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
	public Validationurl() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 332, 233);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFormatOfThe = new JLabel("FORMAT OF THE URL IS INCORRECT !");
		lblFormatOfThe.setForeground(new Color(0, 102, 51));
		lblFormatOfThe.setBounds(43, 22, 273, 14);
		frame.getContentPane().add(lblFormatOfThe);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnOk.setBackground(SystemColor.activeCaption);
		btnOk.setBounds(103, 110, 89, 23);
		frame.getContentPane().add(btnOk);
	}
}
