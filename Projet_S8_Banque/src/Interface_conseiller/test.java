package Interface_conseiller;

public class test {

		public static void main(String[] args) {
			Fenetre f = new Fenetre();
//			PanelConseiller_listOfMessage p = new PanelConseiller_listOfMessage(f);

			f.setId_client(3);
			f.setId_compte(3);
			f.setTitre_fenetre("Frame");
			PanelConseiller_transactionsUnCompte p = new PanelConseiller_transactionsUnCompte(f);
			
			f.setPanel(p);
		}
}