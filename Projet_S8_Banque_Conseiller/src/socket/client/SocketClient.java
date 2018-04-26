package socket.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SocketClient {

	private final static String host = "localhost";

	public SocketClient() {

	}

	public static String startClient(String request) {
		String retour = null;
		try {
			Socket socket = new Socket(host, 8008);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

			// send data to server
			out.println(request);
			out.flush();
			out.println("BYE");
			out.flush();

			// receive data from server
			String response = null;
			while ((response = in.readLine()) != null) {
//				retour = SocketClient.decrypt(response);
				retour = response;
				System.out.println("reponse serveur: " + retour);
			}
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retour;
	}
	
//	public static String decrypt(String strEncrypted) {
//		String strKey = "379B8FA75B7E7FGT";
//		String strData="";
//		try {
//			SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
//			Cipher cipher=Cipher.getInstance("Blowfish");
//			cipher.init(Cipher.DECRYPT_MODE, skeyspec);
//			byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
//			strData=new String(decrypted);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return strData;
//	}

	// public static void main(String[] args) {
	// SocketClient.startClient("login/c@mail.com/p");
	// }

}
