import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main1 extends JFrame{
       
	JButton btn3;
	JButton btn4;
	  public Main1(){
		this.setTitle("WHAT KIND OF ROLE YOU WANT TO PLAY IN THIS APPLICATION ?");
		this.setSize(400,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		btn3 = new JButton("  USER  ");
		btn4 = new JButton("  ADMIN ");
		JPanel panel = new JPanel();		
		panel.setLayout(null);
		panel.setBounds(0,0,400,500);
		panel.setBackground(new Color(255, 230, 230));
		
		btn3.setBounds(0,130,400,20); 
		btn4.setBounds(0,170,400,20);
		
		panel.add(btn3);
	 	panel.add(btn4);
		 this.add(panel);
		MyLis lis = new MyLis();
		 btn3.addActionListener(lis);
		btn4.addActionListener(lis);
		btn3.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				Userframe Uframe =new Userframe();
				Uframe.setVisible(true);
				}
			
		});
		btn4.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				Adminframe Aframe =new Adminframe();
				Aframe.setVisible(true);
				}
			
		});
		 
	  }
			
				
}	