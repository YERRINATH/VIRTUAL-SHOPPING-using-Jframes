package Shopping;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OTP {

	private JFrame frame;
	private static JTextField go;
	private JTextField eo;

	/**
	 * Launch the application.
	 */
	public static void otp() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OTP window = new OTP();
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
	public OTP() {
		initialize();
		go();
	}
	static int n;
	public static void go() {
		Random rnd = new Random ();
	n = 100000 + rnd.nextInt (900000);
	//	n = set.getString();
	String s=String.valueOf(n);
	go.setText(s);
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		go = new JTextField();
		go.setColumns(10);
		go.setBounds(182, 29, 227, 33);
		frame.getContentPane().add(go);
		
		JLabel lblNewLabel_1_1 = new JLabel("GENERATED  OTP  :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 29, 167, 33);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ENTER  OTP  : ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(10, 88, 167, 33);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		eo = new JTextField();
		eo.setColumns(10);
		eo.setBounds(182, 88, 227, 33);
		frame.getContentPane().add(eo);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String i = go.getText();
				String id = eo.getText();
				if(i.equals(id)) {
					JOptionPane.showMessageDialog(null,"AMOUNT PAID SUCESSFULLY\n YOUR BOOKED PRODUCTS WIILL BE DELIVERED IN 5 DAYS\n                        \t\t ***THANK YOU***");
					 USERA1.UA();
				}
				else {
					JOptionPane.showMessageDialog(null,"PLESE ENTER CORRECT OTP");
					go();
					
				}
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnOk.setBackground(Color.LIGHT_GRAY);
		btnOk.setBounds(187, 156, 120, 35);
		frame.getContentPane().add(btnOk);
	}

}
