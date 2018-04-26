package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	// all in one Panel
	private JPanel panel;

	public MainFrame() {
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setPanel(JPanel panels) {
		this.panel = panels;
		this.setContentPane(this.panel);
		this.validate();
		this.repaint();
	}
}
