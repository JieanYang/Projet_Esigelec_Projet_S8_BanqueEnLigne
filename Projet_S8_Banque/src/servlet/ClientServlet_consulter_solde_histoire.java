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
		 
		Map<String, String> listId_compteMap = new HashMap();
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
		
		
		Map<String, List<Transaction>> listTransaction_compteMap = new HashMap();
		listTransaction_compteMap.put("courant", listTransaction_compteCourant);
		listTransaction_compteMap.put("epargne", listTransaction_compteEpargne);
		listTransaction_compteMap.put("titre", listTransaction_compteTitre);

		
		
		
		// Session
		 HttpSession session = request.getSession();
		 session.setAttribute("CompteInfo", listId_compteMap);
		 session.setAttribute("TransactionInfo", listTransaction_compteMap);
		 
		 

		 // go to a page specific
		 RequestDispatcher rd;
		 rd = getServletContext().getRequestDispatcher("/clientPage_consulter_solde_histoireTransactions.jsp");
		 rd.forward(request, response);
		
		

		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
