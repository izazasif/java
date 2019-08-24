import javax.swing.*;

public class MyFrame extends JFrame{
	
	reception 		uRec;
	administration 	uAdm;
	pharmacy 	    uPha;
	Discharge          uDis;
	JTabbedPane			tab;
	
	public MyFrame(){
		this.setTitle("Admin Dashbord");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		
		addComponentToFrame();
		this.setVisible(true);
	}
	
	public void addComponentToFrame(){
		this.uDis       = new Discharge();
		this.uRec 	= new reception(this);
		this.uAdm	= new administration();
		this.uPha 	= new pharmacy();
		this.tab		= new JTabbedPane();
		
		this.tab.addTab("Reception", this.uRec);
		this.tab.addTab("Administration", this.uAdm);
		this.tab.addTab("pharmacy",this.uPha);
		this.tab.addTab(" Discharge",this.uDis);
		
		this.add(tab);
		
	}
}