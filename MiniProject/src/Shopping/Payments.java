package Shopping;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Payments {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void pay() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payments window = new Payments();
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
	public Payments() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 277, 317);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("SELECT PAYMENT METHOD");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(25, 26, 234, 28);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("PAYTM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OTP.otp();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(35, 65, 120, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnPhonePe = new JButton("PHONE PE");
		btnPhonePe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OTP.otp();
				
			}
		});
		btnPhonePe.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPhonePe.setBackground(Color.LIGHT_GRAY);
		btnPhonePe.setBounds(35, 122, 120, 35);
		frame.getContentPane().add(btnPhonePe);
		
		JButton btnGooglePay = new JButton("GOOGLE PAY");
		btnGooglePay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OTP.otp();
				
			}
		});
		btnGooglePay.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGooglePay.setBackground(Color.LIGHT_GRAY);
		btnGooglePay.setBounds(35, 180, 120, 35);
		frame.getContentPane().add(btnGooglePay);
	}
}
