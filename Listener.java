import java.awt.event.*;
import java.awt.event.ActionEvent.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Listener implements ActionListener{
	
	MyFrame frame;

	JLabel lbl;
	JLabel lbl1;
	JLabel lbl2;
	JLabel lbl3;
	JLabel lbl4;
	JLabel lbl5;
	private boolean status;
	
	
	JTextField tf;
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	JTextField tf4;
	JTextField tf5;
	
	
	
	JButton btn;
	JButton btn1;
	
	public Listener(){
	}
	
	public Listener(MyFrame frame){
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e){
		/* this.frame.dispose(); */
		 
	    JFrame frame2 = new JFrame();
		
		frame2.setTitle(" Patient Admint Form ");
		frame2.setSize(600,500);
		frame2.setLocationRelativeTo(null);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame2.setVisible(true);	
	   
	   btn = new JButton(" CONFIRM ");
		btn1 = new JButton(" SHOW ALL ");
		
	   lbl = new JLabel("  id    :");
	   lbl1 = new JLabel(" name  :");
	   lbl2 = new JLabel(" age  :");
	   lbl3 = new JLabel(" payment  :");
	   lbl4 = new JLabel(" Date  :");
	   lbl5 = new JLabel(" address  :");
	   
		
		 tf 	= new JTextField("");
		 tf1 	= new JTextField("");
		 tf2 	= new JTextField("");
		 tf3 	= new JTextField("");
		 tf4 	= new JTextField("");
		 tf5 	= new JTextField("");
		 
		
	
		//System.exit(0);
		JPanel panel = new JPanel();		
		panel.setLayout(null);
		panel.setBounds(0,0,400,500);
		panel.setBackground(new Color(179, 0, 0));
		
		lbl.setBackground(Color.BLACK);
		lbl1.setBackground(Color.BLACK);
		lbl2.setBackground(Color.BLACK);
		lbl3.setBackground(Color.BLACK);
		lbl4.setBackground(Color.BLACK);
		lbl5.setBackground(Color.BLACK);
		
		
		
		lbl.setBounds(10,10,100,20);
		lbl1.setBounds(10,40,100,20);
		lbl2.setBounds(10,70,100,20);
		lbl3.setBounds(10,100,100,20);
		lbl4.setBounds(10,130,100,20);
		lbl5.setBounds(10,160,100,20);
		
		
		
		tf.setBounds(100,10,100,20);
		tf1.setBounds(100,40,100,20);
		tf2.setBounds(100,70,100,20);
		tf3.setBounds(110,100,100,20);
		tf4.setBounds(100,130,100,20);
		tf5.setBounds(100,160,100,20);
		
		
		
		btn.setBounds(110,250,120,30); 
		btn1.setBounds(240,250,150,30); 
		
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
		
		
		frame2.add(panel);
		MyLis lis = new MyLis();
		  btn.addActionListener(lis);
		   btn.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
				 try{
        Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java1","root","");
	   Statement stmt = con.createStatement();
        
		double value1 = Double.parseDouble(tf.getText());
        String value2=tf1.getText();
        double value3 = Double.parseDouble(tf2.getText());
       double value4 = Double.parseDouble(tf3.getText());
        String value5=tf4.getText();
        String value6=tf5.getText();
        String sql="INSERT INTO `patient`(`id`, `name`, `age`,`payment`,`date`, `address`) VALUES ("+value1+","+"'"+value2+"',"+"'"+value3+"',"+"'"+value4+"',"+"'"+value5+"',"+"'"+value6+"')";
        stmt.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "inserted successfully");
				 }
    catch(Exception r){
		JOptionPane.showMessageDialog(null,e);
		}

    
          
				
			}
			
		}); 
			/* MyLis lis = new MyLis();
		  btn1.addActionListener(lis); */
		   btn1.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
						
		 String [] columns = new String [] {"id", "name","age", "payment","date","address"};
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
	   ResultSet rs = stmt.executeQuery("select * from patient");
       
        
			rs.beforeFirst();

			int i = 0;
			
			while (rs.next()) {

				int j = 0;

				data[i][j++] = rs.getString("id");
				data[i][j++] = rs.getString("name");
				data[i][j++] = rs.getString("age");
				data[i][j++] = rs.getString("payment");
				data[i][j++] = rs.getString("date");
				data[i][j++] = rs.getString("address");

				i++;
			}
     status = true;
				 }
    catch(Exception r){
		JOptionPane.showMessageDialog(null,"ELSE");
		} 
    
          
				
			}
			
		});
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}