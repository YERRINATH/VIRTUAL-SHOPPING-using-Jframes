package Shopping;

import java.awt.EventQueue;
import java.awt.Color;
//import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
//import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.awt.SystemColor;
//import javax.swing.JComboBox;

public class USERA1 {

	private JFrame frame;
	private JTextField trypro;
	private JTextField tryprocost;
	private JTextField txtproid;
	private static JTable table1;

	/**
	 * Launch the application.
	 */
	public static void UA() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					USERA1 window = new USERA1();
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
	public USERA1() {
		initialize();
		cr();
		t1();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public static void t1(){
		try {
		
			String q = "select * from ele2;";
			PreparedStatement pst ;
			ResultSet set ;
			pst = con.prepareStatement(q);
			set = pst.executeQuery();
	        table1.setModel(DbUtils.resultSetToTableModel(set));
			
			}catch(Exception e) {
			System.out.println("some thing went wrong");
			}
		
		}
	
static Connection con;
private JTextField total;
private JTable table2;
	
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
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.setBounds(100, 100, 700, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 255, 240));
		panel.setBounds(10, 11, 257, 159);
		frame.getContentPane().add(panel);
		
		trypro = new JTextField();
		trypro.setColumns(10);
		trypro.setBounds(119, 28, 128, 20);
		panel.add(trypro);
		
		JLabel lblNewLabel_1_1 = new JLabel("PRODUCT  :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 22, 103, 28);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("COST :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(10, 63, 103, 28);
		panel.add(lblNewLabel_1_1_1);
		
		tryprocost = new JTextField();
		tryprocost.setColumns(10);
		tryprocost.setBounds(119, 69, 128, 20);
		panel.add(tryprocost);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					

					String id = txtproid.getText();
					PreparedStatement pst ;					
					pst = con.prepareStatement("select eid,ename,ecost from ele2 where eid = ?");
					pst.setString(1,id);
					ResultSet set = pst.executeQuery();
					if(set.next() == true) {
						String ei = set.getString(1);
						String enam = set.getString(2);
						String ecos = set.getString(3);
				set = pst.executeQuery();				
				TableModel table1 = table2.getModel();
				int[] indexs = table2.getSelectedRows();
				Object[] row = new Object[2];
				DefaultTableModel model = (DefaultTableModel) table2.getModel();
				for(int i = 0; i < indexs.length; i++) {
					row[0] = model.getValueAt(indexs[i], 0);
					row[1] = model.getValueAt(indexs[i], 1);
					row[2] = model.getValueAt(indexs[i], 2);
					model.addRow(row);					
				}
				
				 table2.setModel(DbUtils.resultSetToTableModel(set));
			        table2.setVisible(true);
//						
//		        table2.setModel(DbUtils.resultSetToTableModel(set));
//		        table2.setVisible(true);
//					
					}	}
				
				catch(Exception eo) {
					JOptionPane.showMessageDialog(null,"TRY AGAIN ENTERING CORRECT DETAILS");
				}
				
				
				
			}
		});
		btnNewButton.setBounds(10, 109, 89, 28);
		panel.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(240, 248, 255));
		panel_2.setBounds(10, 181, 277, 70);
		frame.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("SEARCH");
		lblNewLabel_2.setBounds(10, 11, 66, 14);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("PRODUCT ID :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 31, 103, 28);
		panel_2.add(lblNewLabel_1_2);
		
		txtproid = new JTextField();
		txtproid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					String id = txtproid.getText();
					PreparedStatement pst ;
					pst = con.prepareStatement("select eid,ename,ecost from ele2 where eid = ?");
					pst.setString(1,id);
					ResultSet set = pst.executeQuery();
					if(set.next() == true) {
						String eid = set.getString(1);
						String ename = set.getString(2);
						String ecost = set.getString(3);
						txtproid.setText(eid);
						trypro.setText(ename);
						tryprocost.setText(ecost);
						total.setText(ecost);
					}
					else {
						txtproid.setText("");
						trypro.setText("");
						tryprocost.setText("");
						
					}
				}
			catch(Exception ed) {
				
			}
				
				
			}
		});
		txtproid.setColumns(10);
		txtproid.setBounds(129, 37, 138, 20);
		panel_2.add(txtproid);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(297, 11, 377, 240);
		frame.getContentPane().add(scrollPane);
		
		table1 = new JTable();
		scrollPane.setViewportView(table1);
		
		JLabel lblNewLabel = new JLabel("TOTAL :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(347, 360, 56, 37);
		frame.getContentPane().add(lblNewLabel);
		
		total = new JTextField();
		total.setFont(new Font("Tahoma", Font.BOLD, 13));
		total.setColumns(10);
		total.setBounds(403, 360, 128, 29);
		frame.getContentPane().add(total);
		
		JButton btnNewButton_1 = new JButton("BUY");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Payments p = new Payments();
				p.pay();
				
				
			}
		});
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(539, 360, 89, 31);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 267, 264, 130);
		frame.getContentPane().add(scrollPane_1);
		
		table2 = new JTable();
		scrollPane_1.setViewportView(table2);
		
		JLabel tot = new JLabel("New label");
		tot.setFont(new Font("Tahoma", Font.BOLD, 13));
		tot.setBounds(413, 367, 96, 25);
		//Component x = 10;
	
		
		JFormattedTextField x_1 = new JFormattedTextField();
		x_1.setBounds(398, 369, 56, 20);

	}
}
