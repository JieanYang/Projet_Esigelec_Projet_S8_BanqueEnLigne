package vue;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	public MainFrame() {
		this.setTitle("Main Frame");
		getContentPane().setLayout(new GridLayout(0, 1));
		//this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 800);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
