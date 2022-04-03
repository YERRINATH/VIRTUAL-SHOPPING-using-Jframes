package Shopping;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.UIManager;
//import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
//import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Option extends JFrame {

	private JPanel contentPane;
	private static JTextField user;
	private static JPasswordField pass;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Option frame = new Option();
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
	static boolean b = false;
	public Option() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 343, 357);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ADMIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//ADC A = new ADC();
				ADC.ads();
				
			}
		});
		btnNewButton.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnNewButton.setBounds(215, 11, 102, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("USERNAME :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(10, 85, 87, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblPassword.setBounds(10, 137, 87, 30);
		contentPane.add(lblPassword);
		
		user = new JTextField();
		user.setBounds(96, 91, 149, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(96, 143, 149, 20);
		contentPane.add(pass);
		
		JButton btnNewButton_1 = new JButton("SUBMIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(java.awt.event.ActionEvent e) {
				b = false;
			check();
						 if(b = true) {
							 USERA1.UA();
						}
						 else {
							 JOptionPane.showMessageDialog(null,"PLEASE RE-ENTER CORRECT DETAILS ");
						 }									
			}		
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(96, 195, 89, 23);
		contentPane.add(btnNewButton_1);
	}
	static Connection con;
    public static Connection cr() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String user = "root";
			String password = "pass";
			String url = "jdbc:mysql://localhost:3306/ele";
			con = DriverManager.getConnection(url, user, password);	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;			
	}
    public static void check() {
    	String p;
		String pc;
		p = user.getText();
		pc = pass.getText();
	
				try {
				String q = "select * from reg where ename = "+p+" and ecost ="+ pc;
				PreparedStatement ps = con.prepareStatement(q);

			    ResultSet rs = ps.executeQuery();
			    while(rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String phone = rs.getString(3);
					System.out.println("1"+id);
					System.out.println("2"+name);
					System.out.println("3"+phone);
					if(p.equals(name) && pc.equals(phone)) {
					b = true;
					USERA1.UA();
					}
					else {
						JOptionPane.showMessageDialog(null,"TRY AGAIN ENTERING CORRECT DETAILS");
					}
					
			    }
			    
				
				 }
				catch(Exception d) {
					d.printStackTrace();
				}
    }
}
