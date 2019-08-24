import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JComboBox;

import java.sql.*;


public class reception extends JPanel{
	
	JButton btn1;
	JButton btn2;
	MyFrame frame;
	JLabel lbl;
	JTextField txt;
	
	JTabbedPane			tab;
	
	public reception(){
		
	}
	
	public reception(MyFrame frame){
		this.frame = frame;
		this.setLayout(null);
		this.setBackground(new Color(55,55,25));
		addComponentToPanel();
	}
	
	public void addComponentToPanel(){
		
		/* this.tab=new JTabbedPane();
		this.adm=new patientAdm ();
		this.tab.addTab("Reception", this.adm);
		this.add(tab); */
		 
		this.btn1 = new JButton(" ADMIT PATIENT ");
		this.btn1.setBounds(20, 20, 140, 30);
		this.add(btn1);
		
		this.btn2 = new JButton(" UPDATE HISTORY ");
		this.btn2.setBounds(180, 20, 140, 30);
		this.add(btn2);
		
		Listener uLis = new Listener(frame);
		this.btn1.addActionListener(uLis);
		
		 MyLis lis = new MyLis();
		btn2.addActionListener(lis);
		
	btn2.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
			//dispose();
			JFrame frame2 = new JFrame();
			frame2.setTitle("UPDATE ANY DATA");
			frame2.setSize(400, 500);
			frame2.setLocationRelativeTo(null);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.setVisible(true);
			JButton bt = new JButton ("Back");
			bt.setBounds(300, 10, 100, 30);
		JPanel panel = new JPanel();		
		panel.setLayout(null);
		panel.setBounds(0,0,400,500);
		panel.setBackground(new Color(179, 30, 20));
		  bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
		    
		    frame2.dispose();
		 }
		});		 	  
     
		
		
		lbl= new JLabel("chose what kind of data you wants to update");
		lbl.setBackground(Color.BLACK);
		lbl.setBounds(10,40,300,20);
		panel.add(lbl);
		panel.add(bt);
		/* JComboBox jc=new JComboBox();
		jc.setBounds(20,60,150,30); */
		String[] petStrings = { "id", "payment", "date"};
		JComboBox jc=new JComboBox(petStrings);
        jc.setBounds(20,60,150,30);
		
		jc.setSelectedIndex(-1);
             
			 panel.add(jc);
        frame2.add(panel);
            /*  add(jc); */
        /*     jc.addItem("date"); */  
			jc.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
             JFrame frame3 = new JFrame();
			frame3.setTitle("UPDATE ANY DATA");
			frame3.setSize(200, 300);
			frame3.setLocationRelativeTo(null);
			frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame3.setVisible(true); 
			 
			 JButton btn=new JButton("update");
			 btn.setBounds(90, 80, 90, 15);
			 
			 JPanel panel =new JPanel();
			 panel.setLayout(null);
		     panel.setBounds(0,0,200,300);
		     panel.setBackground(new Color(179, 30, 20));
			  
			  JLabel lbl= new JLabel("Enter amount");
			  JLabel lbl2= new JLabel("id number");
		     lbl.setBackground(Color.BLACK);
		     lbl2.setBackground(Color.BLACK);
		    lbl.setBounds(10,20,150,20);
		    lbl2.setBounds(10,05,150,20);
			
			  JTextField tf 	= new JTextField("");
			  JTextField tf1 	= new JTextField("");
			  
			  tf.setBounds(70,40,80,20);
			  tf1.setBounds(70,10,80,20);
			  
		  panel.add(lbl);
		  panel.add(lbl2);
		  panel.add(tf);
		  panel.add(tf1);
		  panel.add(btn);
		  frame3.add(panel);
            MyLis lis = new MyLis();
		btn.addActionListener(lis);
		   btn.addActionListener( new ActionListener(){
              public void actionPerformed(ActionEvent e){
    
	          try{
					Class.forName("com.mysql.jdbc.Driver");
					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java1","root","");
					 Statement stmt = con.createStatement();
					 int value1 = Integer.parseInt(tf1.getText());
					 int value2 = Integer.parseInt(tf.getText()); 
					 String query="UPDATE `patient` SET `payment`='"+value2+"' WHERE id='"+value1+"'";
				stmt.execute(query);
				JOptionPane.showMessageDialog(null, "UPDATED successfully");
	       }
		   catch(Exception c){
				   
				   }
		frame3.dispose();	 
			 }
		});		 	  
     
	 
            }
        });
			
			}
			
		});
	
		
		}
	
}
