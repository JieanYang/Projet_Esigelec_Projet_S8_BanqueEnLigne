package vue;

import java.sql.Timestamp;
import java.util.Date;

import controller.MainControleur;
import dao.TransactionDao;
import dto.Transaction;

public class Test {

	public static void main(String[] args) {
//		MainControleur mControl = new MainControleur();
		MainFrame mFrame = new MainFrame();
		AllPanel allPanel = new AllPanel(mFrame);
		mFrame.setPanel(allPanel.loginPanel());
		
	}
}
