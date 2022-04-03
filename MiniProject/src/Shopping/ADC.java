package Shopping;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ADC extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void ads() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADC frame = new ADC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ADC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(10, 36, 87, 30);
		contentPane.add(lblNewLabel);
		
		user = new JTextField();
		user.setColumns(10);
		user.setBounds(107, 42, 149, 20);
		contentPane.add(user);
		
		JLabel lblPassword = new JLabel("PASSWORD :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblPassword.setBounds(10, 78, 87, 30);
		contentPane.add(lblPassword);
		
		pass = new JPasswordField();
		pass.setBounds(107, 84, 149, 20);
		contentPane.add(pass);
		
		JButton btnNewButton_1 = new JButton("SUBMIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p,pc;
				p = user.getText();
				pc = pass.getText();
				ADE my = new ADE();
				my.setName1("YERRINATH");
				my.setName("REDDY");
				if(p.equals(my.getName1()) && pc.equals(my.getName())) {
					ADMIN1.ads();
					
				}
				else {
					JOptionPane.showMessageDialog(null,"TRY AGAIN ENTERING CORRECT DETAILS");
				}
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(107, 126, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
