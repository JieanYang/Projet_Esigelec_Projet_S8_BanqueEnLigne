package servlet;

import java.io.FileOutputStream;
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

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import Class.Compte;
import Class.Transaction;
import dao.CompteDao;
import dao.TransactionDao;

/**
 * Servlet implementation class ClientServlet_consulter_solde_histoire
 */
@WebServlet("/ClientServlet_consulter_solde_histoire")
public class ClientServlet_consulter_solde_histoire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet_consulter_solde_histoire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=big5");
		response.setCharacterEncoding("big5");		
		
		// receive id_client
		int id_client = Integer.valueOf(request.getParameter("id_client"));

		
		// list Compte et transaction
		List<Compte> list_compte = new ArrayList<Compte>();
		List<Transaction> list_transaction = new ArrayList<Transaction>();
		
		
		// Dao
		CompteDao compteDao = new CompteDao();
		TransactionDao transactionDao = new TransactionDao();
		
		
		
		// list of compte, fill list
		list_compte = compteDao.getListCompteById_lient(id_client);
		 
		Map<String, String> listId_compteMap = new HashMap<String, String>();
		for(Compte item: list_compte){
			if(item.getCategorie_compte().equals("courant")){
				listId_compteMap.put("courant", String.valueOf(item.getId_compte()));
				// System.out.println(id_compte_courrant);
			}
			if(item.getCategorie_compte().equals("epargne")){
				listId_compteMap.put("epargne", String.valueOf(item.getId_compte()));
				// System.out.println(id_compte_epargne);
			}
			if(item.getCategorie_compte().equals("titre")){
				listId_compteMap.put("titre", String.valueOf(item.getId_compte()));
				// System.out.println(id_compte_titre);
			}
			
		}
		 
		
		
		 
		 List<Transaction> listTansaction_Onecompte = new ArrayList<Transaction>();
		 int id_compte;
		 for(int i=0; i<list_compte.size();i++) {
			// for each id_compte
			id_compte = list_compte.get(i).getId_compte();
		 	listTansaction_Onecompte = transactionDao.getListTransactionById_compte(id_compte);
		 	
		 	for(int j=0; j<listTansaction_Onecompte.size(); j++) {
		 		// list_transaction, add transactions of id_compte dans list_transaction for return
			 	list_transaction.add(listTansaction_Onecompte.get(j));
		 	}
		 }
		 
		 
		// filter into three list
		List<Transaction> listTransaction_compteCourant = new ArrayList<Transaction>();
		List<Transaction> listTransaction_compteEpargne = new ArrayList<Transaction>();
		List<Transaction> listTransaction_compteTitre = new ArrayList<Transaction>();
		// System.out.println("courant"+id_compte_courrant);
		List<Integer> list_existence = new ArrayList<Integer>();
		list_existence.clear();
		for(Transaction item: list_transaction){
			if( Integer.valueOf(listId_compteMap.get("courant")) == item.getId_compte_emetteur() ||
					Integer.valueOf(listId_compteMap.get("courant")) == item.getId_compte_recepteur() ){
				if(list_existence.indexOf(item.getId_transaction()) == -1 ){
					list_existence.add(item.getId_transaction());
					listTransaction_compteCourant.add(transactionDao.getTransaction(item.getId_transaction()));
				}
			}
		}
		
		list_existence.clear();
		for(Transaction item: list_transaction){			
			if( Integer.valueOf(listId_compteMap.get("epargne")) == item.getId_compte_emetteur() ||
					Integer.valueOf(listId_compteMap.get("epargne")) == item.getId_compte_recepteur() ){
				if(list_existence.indexOf(item.getId_transaction()) == -1 ){
					list_existence.add(item.getId_transaction());
					listTransaction_compteEpargne.add(transactionDao.getTransaction(item.getId_transaction()));
				}
			}
		}
		
		list_existence.clear();
		for(Transaction item: list_transaction){
			if( Integer.valueOf(listId_compteMap.get("titre")) == item.getId_compte_emetteur() ||
					Integer.valueOf(listId_compteMap.get("titre")) == item.getId_compte_recepteur() ){
				if(list_existence.indexOf(item.getId_transaction()) == -1 ){
					list_existence.add(item.getId_transaction());
					listTransaction_compteTitre.add(transactionDao.getTransaction(item.getId_transaction()));
				}
			}
		}
		
		
		Map<String, List<Transaction>> listTransaction_compteMap = new HashMap<String, List<Transaction>>();
		listTransaction_compteMap.put("courant", listTransaction_compteCourant);
		listTransaction_compteMap.put("epargne", listTransaction_compteEpargne);
		listTransaction_compteMap.put("titre", listTransaction_compteTitre);
		
		
		// Session
		 HttpSession session = request.getSession();
		 session.setAttribute("CompteInfo", listId_compteMap);
		 session.setAttribute("TransactionInfo", listTransaction_compteMap);

		
		if(request.getParameter("method").equals("extractCSV")) {
			// If we want to extractCSV, we will pass the data to the methode extractCSV
			this.extractCSV(request, response, listTransaction_compteMap, listId_compteMap);
		}


		 // go to a page specific
		 RequestDispatcher rd;
		 rd = getServletContext().getRequestDispatcher("/clientPage_consulter_solde_histoireTransactions.jsp");
		 rd.forward(request, response);	
	}

	
	
	// Generate a file CSV which contains the data of Transaction
	private void extractCSV(HttpServletRequest request, HttpServletResponse response,
			Map<String, List<Transaction>> listTransaction_compteMap, Map<String, String> listId_compteMap) throws ServletException, IOException {
		
		
		// Create workbook
		HSSFWorkbook wb = new HSSFWorkbook();
		
		// Create sheet
		HSSFSheet sheet = wb.createSheet("listTransaction");
		/*HSSFSheet sheet_epargne = wb.createSheet("listTransaction_epargne");
		HSSFSheet sheet_titre = wb.createSheet("listTransaction_titre");*/
		
		// Index of line
		int i = 0;
		
		// Create first row
		HSSFRow row = sheet.createRow(i);
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.valueOf("CENTER"));
		
		// Create first cell in a row
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("Compte courrant");
		cell.setCellStyle(style);
		i++;
		
		
		// Create first cell in a row
		row = sheet.createRow(i);
		cell = row.createCell(0);
		cell.setCellValue("transaction_categorie");
		cell.setCellStyle(style);
		
		cell = row.createCell(1);
		cell.setCellValue("date");
		cell.setCellStyle(style);
		
		cell = row.createCell(2);
		cell.setCellValue("description");
		cell.setCellStyle(style);
		
		cell = row.createCell(3);
		cell.setCellValue("somme");
		cell.setCellStyle(style);
		
		i++;
		
		
		for(Transaction item: listTransaction_compteMap.get("courant")) {
			int id_compte = Integer.valueOf(listId_compteMap.get("courant"));
			
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(item.getCategorie_transaction());
			row.createCell(1).setCellValue(item.getDate_transaction().toString().split(" ")[0]);
			row.createCell(2).setCellValue(item.getDescription());
			
			if (item.getId_compte_emetteur() == id_compte)
				row.createCell(3).setCellValue("-"+item.getSomme());
			else if(item.getId_compte_recepteur() == id_compte)
				row.createCell(3).setCellValue("+"+item.getSomme());
			
			i++;
		}
		
		row = sheet.createRow(i);
		cell = row.createCell(0);
		cell.setCellValue("Compte epargne");
		cell.setCellStyle(style);
		i++;
		
		for(Transaction item: listTransaction_compteMap.get("epargne")) {
			int id_compte = Integer.valueOf(listId_compteMap.get("epargne"));
			
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(item.getCategorie_transaction());
			row.createCell(1).setCellValue(item.getDate_transaction().toString().split(" ")[0]);
			row.createCell(2).setCellValue(item.getDescription());
			
			if (item.getId_compte_emetteur() == id_compte)
				row.createCell(3).setCellValue("-"+item.getSomme());
			else if(item.getId_compte_recepteur() == id_compte)
				row.createCell(3).setCellValue("+"+item.getSomme());
			
			i++;
		}
		
		row = sheet.createRow(i);
		cell = row.createCell(0);
		cell.setCellValue("Compte titre");
		cell.setCellStyle(style);
		i++;
		
		for(Transaction item: listTransaction_compteMap.get("titre")) {
			int id_compte = Integer.valueOf(listId_compteMap.get("titre"));
			
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(item.getCategorie_transaction());
			row.createCell(1).setCellValue(item.getDate_transaction().toString().split(" ")[0]);
			row.createCell(2).setCellValue(item.getDescription());

			if (item.getId_compte_emetteur() == id_compte)
				row.createCell(3).setCellValue("-"+item.getSomme());
			else if(item.getId_compte_recepteur() == id_compte)
				row.createCell(3).setCellValue("+"+item.getSomme());
			
			i++;
		}
		
		try {
			FileOutputStream fout = new FileOutputStream("C:\\Users\\yja85\\Desktop\\GitHub\\projet_s8_banque/dataTransaction.xls");
			wb.write(fout);
			fout.close();
			wb.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Success to export transactions");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
