package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
 * Servlet implementation class ManagerServlet_dataOneClient
 */
@WebServlet("/ManagerServlet_dataOneClient")
public class ManagerServlet_dataOneClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	private Map<String, Float> list_grapheData = new HashMap<String, Float>();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet_dataOneClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_select = Integer.valueOf(request.getParameter("id_user_input"));

		HttpSession session = request.getSession();
		Map<Integer, Integer[]> list_idUser_idComptes = (Map<Integer, Integer[]>)session.getAttribute("list_idUser_idComptes");
		Map<Integer, Integer[]> list_idCompte_idTransactions = (Map<Integer, Integer[]>)session.getAttribute("list_idCompte_idTransactions");
		
		CompteDao compteDao = new CompteDao();
		TransactionDao transactionDao = new TransactionDao();
		Compte compte;
		Transaction transaction;
		list_grapheData.clear();
		
		
		Integer[] list_comptes = (Integer[])list_idUser_idComptes.get(id_select);
		System.out.println("id client: "+id_select);
		for(int i=0; i< list_comptes.length; i++) {
			float somme_income = 0;
			float somme_outcome = 0;
			compte = compteDao.getCompte(list_comptes[i]);
			System.out.println("id compte: " + list_comptes[i] +" -> "+ compte.getCategorie_compte());
			
			Integer[] list_transactionsOneCompte = (Integer[])list_idCompte_idTransactions.get(list_comptes[i]);
			for(int j=0; j< list_transactionsOneCompte.length; j++) {
				System.out.println("id transaction of compte "+list_comptes[i]+":"+list_transactionsOneCompte[j]);
				transaction = transactionDao.getTransaction(list_transactionsOneCompte[j]);
				if(transaction.getId_compte_recepteur() == list_comptes[i]) {
					System.out.println("income");
					somme_income += transaction.getSomme();
				} else if(transaction.getId_compte_emetteur() == list_comptes[i]) {
					System.out.println("outcome");
					somme_outcome -= transaction.getSomme();
				}
			}
			System.out.println("somme_income:"+somme_income);
			System.out.println("somme_outcome:"+somme_outcome);
			list_grapheData.put("income->"+compte.getCategorie_compte(), somme_income);
			list_grapheData.put("outcome->"+compte.getCategorie_compte(), somme_outcome);
			list_grapheData.put("total->"+compte.getCategorie_compte(), somme_income+somme_outcome);
			list_grapheData.put("id_client", Float.valueOf(id_select));
		}
		
		
		session.setAttribute("list_grapheData", list_grapheData);
		
		
		
		request.getRequestDispatcher("dataOneClient.jsp").forward(request, response);
		//response.getWriter().append("id:"+id_select+"Served at : ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
