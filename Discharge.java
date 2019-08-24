import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JComboBox;

import java.sql.*;

public class Discharge extends JPanel{
	
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JButton btn5;
	
	public Discharge(){
		this.setLayout(null);
		this.setBackground(new Color(125,25,125));
		addComponentToPanel();
	}
	
	public void addComponentToPanel(){
		this.btn2 = new JButton("Patient Discharge");
		this.btn2.setBounds(30, 250, 120, 30);
		this.add(btn2);
		
		this.btn3 = new JButton("Doctor Quite job");
		this.btn3.setBounds(190, 250, 180, 30);
		this.add(btn3);
		
		
		this.btn4 = new JButton("Delete Medicine");
		this.btn4.setBounds(420, 250, 140, 30);
		this.add(btn4);
		
		this.btn5 = new JButton("Back");
		this.btn5.setBounds(390, 30, 70, 30);
		this.add(btn5);
		
		
		MyLis lis2 = new MyLis();
	btn2.addActionListener(lis2);
	
	btn2.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFrame frame2 = new JFrame();
			frame2.setTitle("Medicine Add Form");
			frame2.setSize(400, 500);
			frame2.setLocationRelativeTo(null);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.setVisible(true);
			
		JPanel panel = new JPanel();		
		panel.setLayout(null);
		panel.setBounds(0,0,400,500);
		panel.setBackground(new Color(10, 87, 91));
		
		frame2.add(panel);
		 JButton btn=new JButton("search");
		JButton btn1=new JButton("Delete");
		
		JLabel lbl=new JLabel("id            :");
		JLabel lbl1=new JLabel("NAME         :");
		JLabel lbl2=new JLabel("Admint Date  :");
		JLabel lbl3=new JLabel("Total Cost   :");
		JLabel lbl4=new JLabel("Release Date :");
		JLabel lbl5=new JLabel("<=== Give Id Number");
		
		
		JTextField tf=new JTextField("");
		JTextField tf1=new JTextField("");
		JTextField tf2=new JTextField("");
		JTextField tf3=new JTextField("");
		JTextField tf4=new JTextField("");
		JTextField tf5=new JTextField("");
		
		lbl.setBackground(Color.BLACK);
		lbl1.setBackground(Color.BLACK);
		lbl2.setBackground(Color.BLACK);
		lbl3.setBackground(Color.BLACK);
		lbl4.setBackground(Color.BLACK);
		lbl5.setBackground(Color.BLACK);
		
		lbl.setBounds(10,110,100,20);
		lbl1.setBounds(10,140,100,20);
		lbl2.setBounds(10,170,100,20);
		lbl3.setBounds(10,200,100,20);
		lbl4.setBounds(10,230,100,20);
		lbl5.setBounds(200,10,150,20);
		
		tf.setBounds(30,10,140,20);
		tf1.setBounds(100,110,100,20);
		tf2.setBounds(100,140,100,20);
		tf3.setBounds(100,170,100,20);
		tf4.setBounds(100,200,100,20);
		tf5.setBounds(100,230,100,20);
		
		btn.setBounds(50,40,90,20); 
		btn1.setBounds(180,290,90,20); 
		
		panel.add(lbl);
		panel.add(lbl1);
		panel.add(lbl2);
		panel.add(lbl3);
		panel.add(lbl4);
		panel.add(lbl5);
		
		panel.add(tf);
		panel.add(tf1);
		panel.add(tf2);
		panel.add(tf3);
		panel.add(tf4);
		panel.add(tf5);
		
		panel.add(btn);
	 	panel.add(btn1);
		
        /* MyLis lis = new MyLis();
		btn.addActionListener(lis);
		   btn.addActionListener( new ActionListener(){
              public void actionPerformed(ActionEvent e){
    
	          try{
					Class.forName("com.mysql.jdbc.Driver");
					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java1","root","");
					 Statement stmt = con.createStatement("SELECT * FROM `patient` WHERE id='"+value1+"'");
					 int value1 = Integer.parseInt(tf.getText()); 
					// String query="SELECT * FROM `patient` WHERE id='"+value1+"'";
			//	stmt.execute(query);
			  stmt.setString(1,value1);
				JOptionPane.showMessageDialog(null, "UPDATED successfully");
				 ResultSet rs = stmt.executeQuery();

 

            if (rs.next()) {

                String s = rs.getString(1);
                String s1 = rs.getString(2);
                String s2 = rs.getString(4);
                String s3 = rs.getString(5);


                tf1.setText(s);
                tf2.setText(s1);
                tf3.setText(s2);
                tf4.setText(s3);

            } else {

                JOptionPane.showMessageDialog(null, "Name not Found");

            }
	
	       }
		   catch(Exception c){
				   
				   }
		 
			 }
		});	 */	
		
		
		
		
		
		
		}
		
});
		
		
			
		
	btn3.addActionListener(lis2);
	
	btn3.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
		
		
			}
		
});
	
  	
   	
	btn4.addActionListener(lis2);
	
	btn4.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
		
		
			}
		
});
	
	btn5.addActionListener(lis2);
	
	btn5.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
		
		
			}
		
});
	
 
	
  	
	
	
	

	
		
	}
}