package controleur;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import dto.Transaction;
import dto.User;
import socket.client.SocketClient;

public class ControleurInfoCompteClient {

	public static Timestamp convertStringToTimestamp(String str_date) {
		try {
			DateFormat formatter;
			formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = (Date) formatter.parse(str_date);
			java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

			return timeStampDate;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Vector<Transaction> getListTransac(int compteID) {
		Vector<Transaction> listeTransac = new Vector<Transaction>();
		String lTransac = SocketClient.startClient("listtransac" + "/" + compteID);
		String[] tabTransac = lTransac.split(";");
		for (int i = 1; i < tabTransac.length; i++) {
			String[] trInfo = tabTransac[i].split("/");
			Transaction transaction = new Transaction();

			transaction.setId_transaction(Integer.parseInt(trInfo[0]));
			transaction.setCategorie_transaction(trInfo[1]);
			transaction.setId_compte_emetteur(Integer.parseInt(trInfo[2]));
			transaction.setId_compte_recepteur(Integer.parseInt(trInfo[3]));
			transaction.setDate_transaction(ControleurInfoCompteClient.convertStringToTimestamp(trInfo[4]));
			transaction.setSomme(Float.parseFloat(trInfo[5]));
			transaction.setDescription(trInfo[6]);

			listeTransac.add(transaction);
		}
		return listeTransac;
	}

}
