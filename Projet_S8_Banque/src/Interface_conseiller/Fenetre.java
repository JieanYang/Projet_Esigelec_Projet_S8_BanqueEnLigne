package Interface_conseiller;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	private JPanel p;
	
	public Fenetre() {
		this.init();
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void init() {
		this.setTitle("List of Message");
	}
	
	public void setPanel(JPanel p) {
		this.p = p;
		this.setContentPane(this.p);
		// this.revalidate();
		this.validate();
		this.repaint();
	}
	

}
