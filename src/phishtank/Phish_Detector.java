package phishtank;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;





import org.apache.commons.validator.routines.UrlValidator;

import java.awt.Color;
import java.awt.SystemColor;

public class Phish_Detector {

	private JFrame frame;
	private JTextField t1;
static String input,output,output1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Phish_Detector window = new Phish_Detector();
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
	public Phish_Detector() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 960, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		t1 = new JTextField();
		t1.setBounds(117, 50, 559, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JLabel lblUrl = new JLabel("ENTER URL : ");
		lblUrl.setForeground(SystemColor.activeCaption);
		lblUrl.setBounds(10, 53, 91, 14);
		frame.getContentPane().add(lblUrl);
		
		JLabel l1 = new JLabel(" ");
		l1.setFont(new Font("Arial", Font.PLAIN, 12));
		l1.setBackground(Color.LIGHT_GRAY);
		l1.setBounds(193, 133, 496, 28);
		frame.getContentPane().add(l1);
		JTextArea l2 = new JTextArea();
		l2.setFont(new Font("Arial", Font.PLAIN, 12));
		l2.setBackground(Color.WHITE);
		l2.setBounds(192, 170, 484, 131);
		frame.getContentPane().add(l2);
		/*JScrollPane pane = new JScrollPane ();
		pane.getViewport ().setView ( l2 );*/
		JLabel lblPhishingUrlDetector = new JLabel("PHISHING URL DETECTOR");
		lblPhishingUrlDetector.setForeground(new Color(0, 153, 102));
		lblPhishingUrlDetector.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPhishingUrlDetector.setBounds(352, 11, 215, 28);
		frame.getContentPane().add(lblPhishingUrlDetector);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBackground(SystemColor.inactiveCaption);
		btnSearch.setFont(new Font("Arial", Font.BOLD, 12));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*Pattern p = Pattern.compile("(http:\/\/|https:\/\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$");
				Matcher m;
				m=p.matcher(t1.getText());
				boolean matches = m.matches();
				;*/
				
				
				UrlValidator urlv=new UrlValidator();

if(t1.getText().equals(""))
{
	EmptyText e=new EmptyText();
	e.emptytext();
}
else
	if(!urlv.isValid(t1.getText())) 
{
		Validationurl e1=new Validationurl();
		e1.validate();
} else

{
	
	input=t1.getText().trim();
JsonParsing obj=new JsonParsing();
Wot obj1=new Wot();

try {
	output=obj.Check(input);
	l1.setText(output);
	
	
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	output1=obj1.check1(input);
	l2.setText(output1);
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
				
			
			}
			
		});
	
		btnSearch.setBounds(269, 94, 110, 28);
		frame.getContentPane().add(btnSearch);
		
		JLabel lblFilter = new JLabel("FILTER 1 RESPONSE :");
		lblFilter.setForeground(SystemColor.activeCaption);
		lblFilter.setBounds(10, 140, 127, 14);
		frame.getContentPane().add(lblFilter);
		
		JLabel lblFilter_1 = new JLabel("FILTER 2 RESPONSE :");
		lblFilter_1.setForeground(SystemColor.activeCaption);
		lblFilter_1.setBounds(10, 176, 127, 14);
		frame.getContentPane().add(lblFilter_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\kripanshu\\Desktop\\CategoryHelp.png"));
		label.setBounds(42, 322, 258, 148);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\kripanshu\\Desktop\\rating.jpg"));
		label_1.setBounds(401, 312, 533, 158);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\kripanshu\\Desktop\\phishing-300x232.jpg"));
		label_2.setBounds(676, 67, 258, 222);
		frame.getContentPane().add(label_2);
		
		JButton button = new JButton("");
		button.setBackground(Color.WHITE);
		button.setIcon(new ImageIcon("C:\\Users\\kripanshu\\Desktop\\Nuvola_actions_help.png"));
		button.setFont(new Font("Tahoma", Font.BOLD, 17));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Help h= new Help();
			h.Help1();
			
			}
		});
		button.setBounds(883, 11, 51, 56);
		frame.getContentPane().add(button);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			l1.setText("");
			l2.setText("");
			t1.setText("");
			
			}
		});
		btnClear.setFont(new Font("Arial", Font.BOLD, 12));
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.setBounds(138, 94, 96, 28);
		frame.getContentPane().add(btnClear);
		
		JButton btnAnalysisReport = new JButton("ANALYSIS REPORT");
		btnAnalysisReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SVM svm=new SVM();
				Table t=new Table();
				try {
					svm.chartsvm();
					t.table();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAnalysisReport.setBackground(Color.LIGHT_GRAY);
		btnAnalysisReport.setFont(new Font("Arial", Font.BOLD, 12));
		btnAnalysisReport.setBounds(409, 94, 158, 28);
		frame.getContentPane().add(btnAnalysisReport);
		
		
		
		
		
		
	}
}
