import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JComboBox;

import java.sql.*;


public class administration extends JPanel{
	
	JButton btn2;
	
	
	
	
	public administration(){
		this.setLayout(null);
		this.setBackground(new Color(55,55,25));
		addComponentToPanel();
	}
	
	
	public void addComponentToPanel(){
		this.btn2 = new JButton("DOCTOR REGISTRATION");
		this.btn2.setBounds(200, 250, 200, 30);
		this.add(btn2);
	
	
	 MyLis lis2 = new MyLis();
	this.btn2.addActionListener(lis2);
		
	btn2.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFrame frame2 = new JFrame();
			frame2.setTitle("Doctor Registration Form");
			frame2.setSize(400, 500);
			frame2.setLocationRelativeTo(null);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.setVisible(true);
			
		JPanel panel = new JPanel();		
		panel.setLayout(null);
		panel.setBounds(0,0,400,500);
		panel.setBackground(new Color(179, 30, 20));
		
		JButton btn=new JButton("CONFIRM");
		JButton btn1=new JButton("SHOW ALL");
         		
		JLabel lbl=new JLabel("ID               :");
		JLabel lbl1=new JLabel("NAME            :");
		JLabel lbl2=new JLabel("AGE             :");
		JLabel lbl3=new JLabel("DEPARTMENT      :");
		JLabel lbl4=new JLabel("SALARY          :");
		JLabel lbl5=new JLabel("CONTACT NUMBER  :");
		JLabel lbl6=new JLabel("ADDRESS         :")  ;

	
	
		JTextField tf=new JTextField("");
		JTextField tf1=new JTextField("");
		JTextField tf2=new JTextField("");
		JTextField tf3=new JTextField("");
		JTextField tf4=new JTextField("");
		JTextField tf5=new JTextField("");
		JTextField tf6=new JTextField("");
		
		lbl.setBackground(Color.BLACK);
		lbl1.setBackground(Color.BLACK);
		lbl2.setBackground(Color.BLACK);
		lbl3.setBackground(Color.BLACK);
		lbl4.setBackground(Color.BLACK);
		lbl5.setBackground(Color.BLACK);
		lbl6.setBackground(Color.BLACK);
		
		
		
		lbl.setBounds(10,10,100,20);
		lbl1.setBounds(10,40,100,20);
		lbl2.setBounds(10,70,100,20);
		lbl3.setBounds(10,100,100,20);
		lbl4.setBounds(10,130,100,20);
		lbl5.setBounds(10,160,100,20);
		lbl6.setBounds(10,200,100,20);
		
		
		
		tf.setBounds(100,10,100,20);
		tf1.setBounds(100,40,100,20);
		tf2.setBounds(100,70,100,20);
		tf3.setBounds(110,100,100,20);
		tf4.setBounds(100,130,100,20);
		tf5.setBounds(100,160,100,20);
		tf6.setBounds(100,200,100,20);
		
		
		
		btn.setBounds(110,250,120,30); 
		btn1.setBounds(240,250,150,30); 
		
		panel.add(lbl);
		panel.add(lbl1);
		panel.add(lbl2);
		panel.add(lbl3);
		panel.add(lbl4);
		panel.add(lbl5);
		panel.add(lbl6);
		
		
		
		panel.add(tf);
		panel.add(tf1);
		panel.add(tf2);
		panel.add(tf3);
		panel.add(tf4);
		panel.add(tf5);
		panel.add(tf6);
		
		
	
		
		panel.add(btn);
	 	panel.add(btn1);
		
		frame2.add(panel);
		
		
		
	 MyLis lis2 = new MyLis();
	btn.addActionListener(lis2);
		
	btn.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
	
		     try{
        Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java1","root","");
	   Statement stmt = con.createStatement();
        
		double value0 = Double.parseDouble(tf.getText());
        String value1=tf1.getText();
        double value2 = Double.parseDouble(tf2.getText());
        String value3=tf3.getText();
		double value4 = Double.parseDouble(tf4.getText());
        String value5=tf5.getText();
        String value6=tf6.getText();
        String sql="INSERT INTO `doctor`(`id`, `name`, `age`,`department`,`salary`,`contact number`, `address`) VALUES ("+value0+","+"'"+value1+"',"+"'"+value2+"',"+"'"+value3+"',"+"'"+value4+"',"+"'"+value5+"',"+"'"+value6+"')";
        stmt.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "inserted successfully");
				 }
    catch(Exception r){
		JOptionPane.showMessageDialog(null,e);
		}
		   
	
	
		
		
		
		
		}
			
		});
		
/* 		MyLis lis2 = new MyLis();
	btn1.addActionListener(lis2); */
		
	btn1.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
	    				
		 String [] columns = new String [] {"id", "name","age","department", "salary","contact number","address"};
        String [][] data = new String [30][30]; /* { {null, null, null, null},
            
		{null,null,null,null},{null, null, null, null},{null, null, null, null},{null, null, null, null},{null, null, null, null}}; */
      
        JTable table = new JTable(data, columns);

       
        table.setDragEnabled(true);
        table.setDropMode(DropMode.INSERT_ROWS);
        table.setFillsViewportHeight(true);
        TransferHandler dnd = new TransferHandler() {

        };
        table.setTransferHandler(dnd);
        JScrollPane scroll = new JScrollPane(table);

      
        JFrame window = new JFrame();
        window.getContentPane().add(scroll);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true); 
		
		    		   try{	 
			 
        Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java1","root","");
	   Statement stmt = con.createStatement();
	   ResultSet rs = stmt.executeQuery("select * from doctor");
       
        
			rs.beforeFirst();

			int i = 0;
			
			while (rs.next()) {

				int j = 0;

				data[i][j++] = rs.getString("id");
				data[i][j++] = rs.getString("name");
				data[i][j++] = rs.getString("age");
				data[i][j++] = rs.getString("department");
				data[i][j++] = rs.getString("salary");
				data[i][j++] = rs.getString("contact number");
				data[i][j++] = rs.getString("address");

				i++;
			}
    
				 }
    catch(Exception r){
		JOptionPane.showMessageDialog(null,"ELSE");
		} 
    
          
		
		
		
		
		
		
		
		}
			
		});
		



		}
			
	

	});
	
	
	
	
	
	
	
	}
		}