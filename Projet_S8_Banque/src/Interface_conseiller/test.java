package Interface_conseiller;

import javax.swing.*;

public class test {

		public static void main(String[] args) {
			Fenetre f = new Fenetre();
//			Panels_conseiller p = new Panels_conseiller(f);
//			f.setPanel(p.get_P_listOfMessage());
			f.setId_client(3);
			f.setId_compte(3);
			f.setTitre_fenetre("Frame");
			PanelConseiller_transactionsUnCompte p = new PanelConseiller_transactionsUnCompte(f);
			f.setPanel(p);
		}
}
