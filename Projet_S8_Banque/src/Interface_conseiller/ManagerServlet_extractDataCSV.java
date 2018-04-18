package Interface_conseiller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import Class.Compte;
import Class.Transaction;
import Class.User;
import dao.CompteDao;
import dao.TransactionDao;
import dao.UserDao;

/**
 * Servlet implementation class ManagerServlet_extractDataCSV
 */
@WebServlet("/ManagerServlet_extractDataCSV")
public class ManagerServlet_extractDataCSV extends HttpServlet {
	
	public static void main(String[] args) throws ServletException, IOException {
		ManagerServlet_extractDataCSV ms = new ManagerServlet_extractDataCSV();
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		ms.doGet(request, response);
	}
	/**
	 * Version
	 */
	private static final long serialVersionUID = 1L;
       
	/**
	 * Variables
	 */
	private List<User> list_AllClients = new ArrayList<User>();
	private List<Compte> list_AllComptes = new ArrayList<Compte>();
	private List<Transaction> list_AllTransactions = new ArrayList<Transaction>();
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet_extractDataCSV() {
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
		 this.extractCSV(request, response);
		 
		// go to a page specific
//		RequestDispatcher rd;
//		rd = getServletContext().getRequestDispatcher("/index.jsp");
//		rd.forward(request, response);
		 	
		 
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void initiateData() {
		// Clear vistigial datas
		this.list_AllClients.clear();
		this.list_AllComptes.clear();
		this.list_AllTransactions.clear();
		
		UserDao userDao = new UserDao();
		CompteDao compteDao = new CompteDao();
		TransactionDao transactionDao = new TransactionDao();
		
		List<User> list_AllUser = userDao.getListUser();
		// Filter the information to have a list withclients
		for(User item : list_AllUser) {
			if (item.getCategorie_user().equals("client") || item.getCategorie_user().equals("Client")) {
				this.list_AllClients.add(item);
			}
		}
		
		this.list_AllComptes = compteDao.getListCompte();
		this.list_AllTransactions = transactionDao.getListTransaction();
		
		
	}

	private void extractCSV(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Create workbook file
		HSSFWorkbook wb = new HSSFWorkbook();
		
		/** 
		 *  Create sheets ...
		 */
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
		
		/**
		 * Download file and delete file
		 */
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
					"id_compte", "categorie compte", "etat", "solde", "nombre des transactions"};
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
				// Data transaction
				data_situationOneClient[11] = String.valueOf(numberOfTransactionsOneCompte);
				
				
				/**
				 *  Insert datas
				 */
				// Create a new row
				row = sheet.createRow(i);
				
				// Insert the data into columns
				cell = row.createCell(0);
				cell.setCellStyle(style);
				cell.setCellValue(data_situationOneClient[0]);
				
				cell = row.createCell(1);
				cell.setCellStyle(style);
				cell.setCellValue(data_situationOneClient[1]);
				
				cell = row.createCell(2);
				cell.setCellStyle(style);
				cell.setCellValue(data_situationOneClient[2]);
				
				cell = row.createCell(3);
				cell.setCellStyle(style);
				cell.setCellValue(data_situationOneClient[3]);
				
				cell = row.createCell(4);
				cell.setCellStyle(style);
				cell.setCellValue(data_situationOneClient[4]);
				
				cell = row.createCell(5);
				cell.setCellStyle(style);
				cell.setCellValue(data_situationOneClient[5]);
				
				cell = row.createCell(6);
				cell.setCellStyle(style);
				cell.setCellValue(data_situationOneClient[6]);
				
				cell = row.createCell(7);
				cell.setCellStyle(style);
				cell.setCellValue(data_situationOneClient[7]);
				
				cell = row.createCell(8);
				cell.setCellStyle(style);
				cell.setCellValue(data_situationOneClient[8]);
				
				cell = row.createCell(9);
				cell.setCellStyle(style);
				cell.setCellValue(data_situationOneClient[9]);
				
				cell = row.createCell(10);
				cell.setCellStyle(style);
				cell.setCellValue(data_situationOneClient[10]);
				
				cell = row.createCell(11);
				cell.setCellStyle(style);
				cell.setCellValue(data_situationOneClient[11]);
				i++;
			}
			
			/*// Insert datas into the new row
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
						}*/
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
