package Shopping;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ADMIN1 {

	private JFrame frame;
	private static JTextField trypro;
	private static JTextField tryprocost;
	private JTextField txtproids;
	private static JTable table;
	private static JComboBox sc;
	/**
	 * Launch the application.
	 */
	public static void ads() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADMIN1 window = new ADMIN1();
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
	public ADMIN1() {
		initialize();
		cr();
		t1();
		//t2();
	}
	
	public static void t2(){
		
		
		
		String p,pc;
		p = trypro.getText();
		pc = tryprocost.getText();
		try {
			
			String q = "insert into ele2(ename,ecost) values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(q);
		//	pstmt.setString(1,pi);
			pstmt.setString(1,p);
			pstmt.setString(2,pc);
			pstmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null,"record added in ELECTRONICS");
			
			trypro.setText("");
			tryprocost.setText("");
			trypro.requestFocus();
			t1();
			}
			catch(Exception ei) {
				ei.printStackTrace();
			}
	
		
	
		}
		
	
	
	
	public static void t1(){
		try {
		
			String q = "select * from ele2;";
			PreparedStatement pst ;
			ResultSet set ;
			pst = con.prepareStatement(q);
			set = pst.executeQuery();
	        table.setModel(DbUtils.resultSetToTableModel(set));
			
			}catch(Exception e) {
			System.out.println("some thing went wrong");
			}
		
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 716, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VIRTUAL SHOPPING");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(20, 11, 257, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 255, 240));
		panel.setBounds(20, 48, 257, 233);
		frame.getContentPane().add(panel);
		
		trypro = new JTextField();
		trypro.setColumns(10);
		trypro.setBounds(119, 83, 128, 20);
		panel.add(trypro);
		
		JLabel lblNewLabel_1_1 = new JLabel("PRODUCT  :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 77, 103, 28);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("COST :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(10, 108, 103, 28);
		panel.add(lblNewLabel_1_1_1);
		
		tryprocost = new JTextField();
		tryprocost.setColumns(10);
		tryprocost.setBounds(119, 114, 128, 20);
		panel.add(tryprocost);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			t2();
				}
				
				
		});
		btnNewButton.setBounds(10, 153, 89, 28);
		panel.add(btnNewButton);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pi;
				pi = txtproids.getText();
			
				try {
					String q = "delete from ele2 where eid = ?";
					PreparedStatement pstmt = con.prepareStatement(q);	
					pstmt.setString(1,pi);
					pstmt.executeUpdate();
					String p = "SET @num := 0;";
					String p3 = "UPDATE ele2 SET eid = @num := (@num+1);";
					String p4 = "ALTER TABLE ele2 AUTO_INCREMENT = 1;";
			        java.sql.Statement stmt = con.createStatement(); 
					stmt.execute(p);  
					stmt.execute(p3); 
					stmt.execute(p4); 
					JOptionPane.showMessageDialog(null,"record updated");
					txtproids.setText("");
					trypro.setText("");
					tryprocost.setText("");
					txtproids.requestFocus();
					t1();
					}
					catch(Exception ei) {
						ei.printStackTrace();
					}
				
			}
		});
		btnDelete.setBounds(119, 153, 89, 28);
		panel.add(btnDelete);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(240, 248, 255));
		panel_2.setBounds(20, 314, 277, 70);
		frame.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("SEARCH");
		lblNewLabel_2.setBounds(10, 11, 66, 14);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("PRODUCT ID :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 31, 103, 28);
		panel_2.add(lblNewLabel_1_2);
		
		txtproids = new JTextField();
		txtproids.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					String id = txtproids.getText();
					PreparedStatement pst ;
					pst = con.prepareStatement("select eid,ename,ecost from ele2 where eid = ?");
					pst.setString(1,id);
					ResultSet set = pst.executeQuery();
					if(set.next() == true) {
						String eid = set.getString(1);
						String ename = set.getString(2);
						String ecost = set.getString(3);
						txtproids.setText(eid);
						trypro.setText(ename);
						tryprocost.setText(ecost);
						
					}
					else {
						txtproids.setText("");
						trypro.setText("");
						tryprocost.setText("");
						
					}
				}
			catch(Exception ed) {
				
			}
				
				
			}
		});
		txtproids.setColumns(10);
		txtproids.setBounds(129, 37, 138, 20);
		panel_2.add(txtproids);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(287, 48, 371, 239);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
