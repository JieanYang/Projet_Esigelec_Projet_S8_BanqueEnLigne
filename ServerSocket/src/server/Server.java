package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import dao.CompteDao;
import dao.MessageDao;
import dao.OffresDAO;
import dao.TransactionDao;
import dao.UserDao;

public class Server {

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(8008);
			// int iterator = 0;
			while (true) {
				Socket s = server.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

				// System.out.println("waiting for connexion !!!" + iterator);
				// out.println("Connected to the socket server");
				// out.flush();

				String str = null;
				while ((str = in.readLine()) != null) {
					if (str.trim().equals("BYE")) {
						break;
					}

					System.out.println("Reçu : " + str);
					out.println(Server.handleRequest(str));
					out.flush();
				}
				s.close();
				// iterator++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static String encrypt(String strClearText) {
//		String strKey = "379B8FA75B7E7FGT";
//		String strData = null;
//		try {
//			SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "Blowfish");
//			Cipher cipher = Cipher.getInstance("Blowfish");
//			cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
//			byte[] encrypted = cipher.doFinal(strClearText.getBytes());
//			strData = new String(encrypted);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return strData;
//	}

	public static String handleRequest(String request) {
		String[] splitedRequest = request.split("/");
		String response = null;

		// try catch in case the request have a bad format
		try {
			if (splitedRequest[0].equals("login")) {
				// call dao method that check the login
				if (UserDao.getCredentials(splitedRequest[1], splitedRequest[2])) {
					response = "valid";
				} else {
					response = "invalid";
				}
			} else if (splitedRequest[0].equals("utilisateur")) {
				response = UserDao.getCurrentUser(splitedRequest[1]);
			} else if (splitedRequest[0].equals("listclient")) {
				response = UserDao.getListUser();
			} else if (splitedRequest[0].equals("infoclient")) {
				response = UserDao.getClientInfo(Integer.parseInt(splitedRequest[1]));
			}else if (splitedRequest[0].equals("listcompte")) {
				response = CompteDao.getListCompteById_lient(Integer.parseInt(splitedRequest[1]));
			}else if (splitedRequest[0].equals("getcompte")) {
				response = CompteDao.getCompte(Integer.parseInt(splitedRequest[1]));
			}else if (splitedRequest[0].equals("updatecomptecrediter")) {
				response = CompteDao.updateCompte(Integer.parseInt(splitedRequest[1]), Float.parseFloat(splitedRequest[2]));
			}else if (splitedRequest[0].equals("updatecomptedebiter")) {
				response = CompteDao.updateCompte(Integer.parseInt(splitedRequest[1]), Float.parseFloat(splitedRequest[2]));
			}else if (splitedRequest[0].equals("transaction")) {
				response = TransactionDao.addTransaction(Integer.parseInt(splitedRequest[1]),Integer.parseInt(splitedRequest[2]),Float.parseFloat(splitedRequest[3]), splitedRequest[4], splitedRequest[5]);
			}else if (splitedRequest[0].equals("listmessage")) {
				response = MessageDao.getListMessage();
			}else if (splitedRequest[0].equals("infomessage")) {
				response = MessageDao.getMessage(Integer.parseInt(splitedRequest[1]));
			}else if (splitedRequest[0].equals("reponsemessage")) {
				response = MessageDao.updateMessage(Integer.parseInt(splitedRequest[1]), splitedRequest[2]);
			}else if (splitedRequest[0].equals("ajouteroffre")) {
				response = OffresDAO.addOffre(splitedRequest[1], splitedRequest[2]);
			}else if (splitedRequest[0].equals("listtransac")) {
				response = TransactionDao.getListTransac(Integer.parseInt(splitedRequest[1]));
			}else {
				response = "------Invalid request------";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		response = Server.encrypt(response);
		return response;
	}
}
