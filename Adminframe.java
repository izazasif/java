import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
class Adminframe extends JFrame{
	
	JTextField tf;
	JTextField tf1;
	JButton btn;
	JButton btn1;
	JLabel lbl;
	JLabel lbl1;
	JLabel lbl2;
	public Adminframe(){
				
		this.setTitle("ADMIN LOG IN FORM");
		this.setSize(400,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		
		btn = new JButton("LOG IN");
		lbl = new JLabel("Username  :");
		lbl1 = new JLabel("Password  :");
		tf 	= new JTextField("");
		tf1 	= new JTextField("");
		JPanel panel = new JPanel();		
		panel.setLayout(null);
		panel.setBounds(0,0,400,500);
		panel.setBackground(new Color(31, 31, 46));
		lbl.setBackground(new Color(255, 255, 255));
		lbl.setBackground(new Color(255, 255, 255));
		
		lbl.setBounds(50,50,100,20);
		lbl1.setBounds(50,80,100,20);
		tf.setBounds(130,50,100,20);
		tf1.setBounds(130,80,100,20);
		btn.setBounds(140,120,80,20); 
		
		panel.add(lbl);
		panel.add(lbl1);
		panel.add(tf);
		panel.add(tf1);
	 	panel.add(btn);
		
		this.add(panel);
		//Mysql mysql = new Mysql();
		  MyLis lis = new MyLis();
		btn.addActionListener(lis);
		   btn.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java1","root","");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM `admin`");

					 while(rs.next())
					{
						 if ( rs.getString(2).equals(tf.getText()) && rs.getString(3).equals(tf1.getText()) )
						 {	
							 
							 dispose();
		 // JOptionPane.showMessageDialog(null,"Login!!");
		            MyFrame frame = new MyFrame();
		            frame.setVisible(true); 
							 
						 }
						 else {
							 JOptionPane.showMessageDialog(null,"WRONG USERNAME OR PASSWORD!!");
						 }
							 
					}
					con.close();
				}					
		catch(Exception c){
		JOptionPane.showMessageDialog(null," Problem !!");
		}  
				
			}
			
		});

	
}
}