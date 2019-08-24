import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

class Userframe extends JFrame{
	
	JTextField tf;
	JTextField tf1;
	JButton btn;
	JButton btn1;
	JLabel lbl;
	JLabel lbl1;
	JLabel lbl2;
	 static boolean flag;
	
	public Userframe(){
				
		this.setTitle("USER LOG IN FORM");
		this.setSize(400,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		
		btn = new JButton("LOG IN");
		btn1 = new JButton("create a existing user account ? ");
		lbl = new JLabel("Username  :");
		lbl1 = new JLabel("Password :");
		tf 	= new JTextField("");
		tf1 	= new JTextField("");
		
	

		JPanel panel = new JPanel();		
		panel.setLayout(null);
		panel.setBounds(0,0,400,500);
		panel.setBackground(new Color(153, 153, 153));;
		lbl.setBackground(Color.RED);
		lbl.setBackground(Color.RED);
		
		lbl.setBounds(10,10,100,20);
		lbl1.setBounds(10,40,100,20);
		tf.setBounds(100,10,100,20);
		tf1.setBounds(100,40,100,20);
		btn.setBounds(110,70,80,20); 
		btn1.setBounds(50,110,300,20); 
		
		panel.add(lbl);
		panel.add(lbl1);
		panel.add(tf);
		panel.add(tf1);
	 	panel.add(btn);
	 	panel.add(btn1);
		
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
					ResultSet rs = stmt.executeQuery("SELECT * FROM `user`");

					  while(rs.next())
					{
						 if ( rs.getString(2).equals(tf.getText()) && rs.getString(3).equals(tf1.getText()) )
						 {	
							 
							//JOptionPane.showMessageDialog(null,"Login!!");
							
					dispose(); 
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