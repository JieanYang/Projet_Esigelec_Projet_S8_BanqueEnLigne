package Interface_conseiller;

import javax.swing.*;

public class test {
	
	public static void main(String[] args) {
		Fenetre f = new Fenetre();
		Panels_conseiller p = new Panels_conseiller(f);
		JPanel p_list = p.get_P_listOfMessage();
		f.setPanel(p_list);
	}
}
