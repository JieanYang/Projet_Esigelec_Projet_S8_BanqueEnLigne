package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Class.Compte;
import Class.Transaction;
import Class.User;
import dao.CompteDao;
import dao.TransactionDao;
import dao.UserDao;

/**
 * Servlet implementation class ManagerServlet_extractDataClients
 */
@WebServlet("/ManagerServlet_extractDataClients")
public class ManagerServlet_extractDataClients extends HttpServlet {

	public static void main(String[] args) throws ServletException, IOException {
		ManagerServlet_extractDataClients ms = new ManagerServlet_extractDataClients();
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		ms.doGet(request, response);
	}


	private static final long serialVersionUID = 1L;
       
	/**
	 * Variables
	 */
	private List<Integer> list_idUsers;
	private Map<Integer, Integer[]> list_idUser_idComptes = new HashMap<Integer, Integer[]>();
	private Map<Integer, Integer[]> list_idCompte_idTransactions = new HashMap<Integer, Integer[]>();


    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet_extractDataClients() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set contenType and characterEncoding
		response.setContentType("text/html;charset=big5");
		response.setCharacterEncoding("utf-8");
		 
		// Process of Data
		this.initiateData();
		System.out.println("finish data");
		//System.out.println(list_idUser_idComptes);
		HttpSession session = request.getSession();
		session.setAttribute("list_idUsers", list_idUsers);
		session.setAttribute("list_idUser_idComptes", list_idUser_idComptes);
		session.setAttribute("list_idCompte_idTransactions", list_idCompte_idTransactions);
		// session.setAttribute("c", 3);

		
		
		
		// go to a page specific
		RequestDispatcher rd;
		rd = getServletContext().getRequestDispatcher("/extractDataAllClients.jsp");
		rd.forward(request, response);
		 	
		 
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void initiateData() {
		// Clear vistigial datas
		list_idUser_idComptes.clear();
		list_idCompte_idTransactions.clear();
		
		UserDao userDao = new UserDao();
		CompteDao compteDao = new CompteDao();
		TransactionDao transactionDao = new TransactionDao();
		
		List<User> list_AllUser = userDao.getListUser();
		list_idUsers = new ArrayList<Integer>();
		for(int p=0; p < list_AllUser.size(); p++) {
			if (list_AllUser.get(p).getCategorie_user().equals("client") || list_AllUser.get(p).getCategorie_user().equals("Client")) {
				list_idUsers.add(list_AllUser.get(p).getId_user());
			}
		}
		
		// Filter the information to have a list withclients
		for(User oneClient : list_AllUser) {
			if (oneClient.getCategorie_user().equals("client") || oneClient.getCategorie_user().equals("Client")) {
				//System.out.println("id user:"+ oneClient.getId_user());
				List<Compte> list_comptesOneClient = compteDao.getListCompteById_lient(oneClient.getId_user());
				Integer[] id_comptes = new Integer[list_comptesOneClient.size()];
				
				for(int i=0; i < list_comptesOneClient.size(); i++) {
					//System.out.println("id compte: "+list_comptesOneClient.get(i).getId_compte());
					id_comptes[i] = list_comptesOneClient.get(i).getId_compte();
					
					List<Transaction> list_transactionsOneCompte = transactionDao.getListTransactionById_compte(id_comptes[i]);
					Integer[] id_transactions = new Integer[list_transactionsOneCompte.size()];
					//System.out.println("id_compte -> " + id_comptes[i]);
					for(int j=0; j < id_transactions.length; j++) {
						id_transactions[j] = list_transactionsOneCompte.get(j).getId_transaction();
						//System.out.println(id_transactions[j]);
					}
					list_idCompte_idTransactions.put(id_comptes[i], id_transactions);

				}
				list_idUser_idComptes.put(oneClient.getId_user(), id_comptes);
				
			}
		}
		
		
		
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/*
	 * Generate the CSV file
	 * 
	 * private void extractCSV(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Create workbook file
		HSSFWorkbook wb = new HSSFWorkbook();
		
		*//** 
		 *  Create sheets ...
		 *//*
		// Create sheet list of client situations
		this.createSheet(wb, "client situations");
		// Create sheet list of clients
		this.createSheet(wb, "clients");
		// Create sheet list of comptes
		this.createSheet(wb, "comptes");
		// Create sheet list of transactions
		this.createSheet(wb, "transactions");
		
		// Save file
		String fileName = "DataExtract_manager.xls";
		String path = getServletContext().getRealPath("/")+fileName;
		try {
			FileOutputStream fout = new FileOutputStream(path);
			wb.write(fout);
			fout.close();
			wb.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		*//**
		 * Download file and delete file
		 *//*
		// Set MIME type of file 
		response.setContentType(getServletContext().getMimeType(fileName)); 
		// Set Content-Disposition  
        response.setHeader("Content-Disposition", "attachment;filename="+fileName);  
        // Read the target file, send the file to client by response
        // Gain the path of file
        String fullFileName = path;
        //System.out.println(fullFileName);  
        // Read the file
        InputStream in = new FileInputStream(fullFileName);  
        OutputStream out = response.getOutputStream();
        // send file
        int b;  
        while((b=in.read())!= -1)  
        {  
            out.write(b);  
        }   
        in.close();  
        out.close(); 
        
        // Delete file after finish dowload
        File file = new File(path);
        file.delete();
	}

	private void createSheet(HSSFWorkbook wb, String sheetName) {
		// Create sheet and Prepare the outil for use
		HSSFSheet sheet = wb.createSheet("list of " + sheetName);
		HSSFRow row;
		HSSFCell cell;
		// style
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.valueOf("CENTER"));
		
		
		if (sheetName.equals("clients")) {
			// Index of line
			int i = 0;
			// Create first titles row
			String[] titles = {"id_user", "nom", "prenom", "email", "adresse", "telephone", "ville", "pays", "data de naissacne"};
			row = sheet.createRow(i);
			for (int j = 0; j < titles.length; j++) {
				cell = row.createCell(j);
				cell.setCellValue(titles[j]);
				cell.setCellStyle(style);
			}
			i++;
			
			// Insert datas into the new row
			for (User client : this.list_AllClients) {
				// Create a new row
				row = sheet.createRow(i);
				for (int j = 0; j < titles.length; j++) {
					cell = row.createCell(j);
					cell.setCellStyle(style);
					switch(j) {
						case 0: cell.setCellValue(client.getId_user()); break;
						case 1: cell.setCellValue(client.getNom()); break;
						case 2: cell.setCellValue(client.getPrenom()); break;
						case 3: cell.setCellValue(client.getEmail()); break;
						case 4: cell.setCellValue(client.getAdresse()); break;
						case 5: cell.setCellValue(client.getTelephone()); break;
						case 6: cell.setCellValue(client.getVille()); break;
						case 7: cell.setCellValue(client.getPays()); break;
						case 8:
							if (client.getDateNaissance() != null) {
								cell.setCellValue(client.getDateNaissance().toString());

							} else {
								cell.setCellValue("null");
							} break;
					}
				}
				i++;
			}
			
		} else if (sheetName.equals("comptes")) {
			// Index of line
			int i = 0;
			// Create first titles row
			String[] titles = {"id_compte", "id_user", "categorie compte", "etat", "solde", "date create", "date delete"};
			row = sheet.createRow(i);
			for (int j = 0; j < titles.length; j++) {
				cell = row.createCell(j);
				cell.setCellValue(titles[j]);
				cell.setCellStyle(style);
			}
			i++;
			
			// Insert datas into the new row
			for (Compte compte : this.list_AllComptes) {
				// Create a new row
				row = sheet.createRow(i);
				for (int j = 0; j < titles.length; j++) {
					cell = row.createCell(j);
					cell.setCellStyle(style);
					switch(j) {
						case 0: cell.setCellValue(compte.getId_compte()); break;
						case 1: cell.setCellValue(compte.getId_user()); break;
						case 2: cell.setCellValue(compte.getCategorie_compte()); break;
						case 3: cell.setCellValue(compte.getEtat()); break;
						case 4: cell.setCellValue(compte.getSolde()); break;
						case 5:
							if (compte.getDate_create() != null) {
								cell.setCellValue(compte.getDate_create().toString()); 
							} else {
								cell.setCellValue("null");
							} break;
						case 6: 
							if (compte.getDate_delete() != null) {
								cell.setCellValue(compte.getDate_delete().toString()); 
							} else {
								cell.setCellValue("null");
							} break;
					}
				}
				i++;
			}
		} else if (sheetName.equals("transactions")) {
			// Index of line
			int i = 0;
			// Create first titles row
			String[] titles = {"id_transaction", "categorie transaction", "id compte emetteur", "id compte recepteur", "date transaction", "somme", "description", "date create"};
			row = sheet.createRow(i);
			for (int j = 0; j < titles.length; j++) {
				cell = row.createCell(j);
				cell.setCellValue(titles[j]);
				cell.setCellStyle(style);
			}
			i++;
			
			// Insert datas into the new row
			for (Transaction transaction : this.list_AllTransactions) {
				// Create a new row
				row = sheet.createRow(i);
				for (int j = 0; j < titles.length; j++) {
					cell = row.createCell(j);
					cell.setCellStyle(style);
					switch(j) {
						case 0: cell.setCellValue(transaction.getId_transaction()); break;
						case 1: cell.setCellValue(transaction.getCategorie_transaction()); break;
						case 2: cell.setCellValue(transaction.getId_compte_emetteur()); break;
						case 3: cell.setCellValue(transaction.getId_compte_recepteur()); break;
						case 4:
							if (transaction.getDate_transaction() != null) {
								cell.setCellValue(transaction.getDate_transaction().toString()); 
							} else {
								cell.setCellValue("null");
							} break;
						case 5: cell.setCellValue(transaction.getSomme()); break;
						case 6: cell.setCellValue(transaction.getDescription()); break;
						case 7: 
							if (transaction.getDate_create() != null) {
								cell.setCellValue(transaction.getDate_create().toString()); 
							} else {
								cell.setCellValue("null");
							} break;
					}
				}
				i++;
			}
		} else if(sheetName.equals("client situations")) {
			// Index of line
			int i = 0;
			// Create first titles row
			String[] titles = {"id_user", "nom", "prenom", "email", "telephone", "ville", "pays",
					"id_compte", "categorie compte", "etat", "solde", "depots total", "nombre des transactions"};
			row = sheet.createRow(i);
			for (int j = 0; j < titles.length; j++) {
				cell = row.createCell(j);
				cell.setCellValue(titles[j]);
				cell.setCellStyle(style);
			}
			i++;
			
			// Analyse data
			UserDao userDao = new UserDao();
			CompteDao compteDao = new CompteDao();
			TransactionDao transactionDao = new TransactionDao();
			
			for(Compte compte: this.list_AllComptes) {				
				User client = userDao.getUser(compte.getId_user());
				List<Compte> list_compteOneClient = compteDao.getListCompteById_lient(client.getId_user());
				int depotsTotalOneClient = 0;
				for(Compte compte_calculate: list_compteOneClient) {
					depotsTotalOneClient += compte_calculate.getSolde();
				}
				int numberOfTransactionsOneCompte = transactionDao.getNumberTransactionById_compte(compte.getId_compte());
				String[] data_situationOneClient = new String[titles.length];
				
				// Data client
				data_situationOneClient[0] = String.valueOf(client.getId_user());
				data_situationOneClient[1] = String.valueOf(client.getNom());
				data_situationOneClient[2] = String.valueOf(client.getPrenom());
				data_situationOneClient[3] = String.valueOf(client.getEmail());
				data_situationOneClient[4] = String.valueOf(client.getTelephone());
				data_situationOneClient[5] = String.valueOf(client.getVille());
				data_situationOneClient[6] = String.valueOf(client.getPays());
				// Data compte
				data_situationOneClient[7] = String.valueOf(compte.getId_compte());
				data_situationOneClient[8] = String.valueOf(compte.getCategorie_compte());
				data_situationOneClient[9] = String.valueOf(compte.getEtat());
				data_situationOneClient[10] = String.valueOf(compte.getSolde());
				data_situationOneClient[11] = String.valueOf(depotsTotalOneClient);

				// Data transaction
				data_situationOneClient[12] = String.valueOf(numberOfTransactionsOneCompte);
				
				
				*//**
				 *  Insert datas
				 *//*
				// Create a new row
				row = sheet.createRow(i);
				
				// Insert the data into columns
				for(int n = 0; n < data_situationOneClient.length; n++) {
					cell = row.createCell(n);
					cell.setCellStyle(style);
					cell.setCellValue(data_situationOneClient[n]);
				}
				
				i++;
			}
			
		}
		
	}
*/

}
