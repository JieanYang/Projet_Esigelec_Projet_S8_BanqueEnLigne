package vue;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	// all in one Panel
	private JPanel allPanel = new JPanel();

	public MainFrame() {
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setPanel(JPanel panels) {
		this.allPanel = panels;
		this.setContentPane(this.allPanel);
		this.validate();
		this.repaint();
	}
}
