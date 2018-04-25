package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
 * Generate data for the situation of one client
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
		System.out.println("servlete for dataOneClient start");

		int id_select = Integer.valueOf(request.getParameter("id_user_input"));

		HttpSession session = request.getSession();
		Map<Integer, Integer[]> list_idUser_idComptes = (Map<Integer, Integer[]>)session.getAttribute("list_idUser_idComptes");
		Map<Integer, Integer[]> list_idCompte_idTransactions = (Map<Integer, Integer[]>)session.getAttribute("list_idCompte_idTransactions");
		
		String date_periode_start_string = request.getParameter("date_periode_start");
		String date_periode_finish_string = request.getParameter("date_periode_finish");
		//System.out.println("string:\n"+date_periode_start_string);
		//System.out.println(date_periode_finish_string);
		
		// Convert the date from string to date
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date date_periode_start = null;
		java.sql.Date date_periode_finish = null;
		try {
			date_periode_start = new java.sql.Date(dateForm.parse(date_periode_start_string).getTime());
			date_periode_finish = new java.sql.Date(dateForm.parse(date_periode_finish_string).getTime());
			//System.out.println("date:\n"+date_periode_start);
			//System.out.println(date_periode_finish);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		
		CompteDao compteDao = new CompteDao();
		TransactionDao transactionDao = new TransactionDao();
		Compte compte;
		Transaction transaction;
		list_grapheData.clear();
		
		
		Integer[] list_comptes = (Integer[])list_idUser_idComptes.get(id_select);
		//System.out.println("id client: "+id_select);
		for(int i=0; i< list_comptes.length; i++) {
			float somme_income = 0;
			float somme_outcome = 0;
			compte = compteDao.getCompte(list_comptes[i]);
			//System.out.println("id compte: " + list_comptes[i] +" -> "+ compte.getCategorie_compte());
			
			Integer[] list_transactionsOneCompte = (Integer[])list_idCompte_idTransactions.get(list_comptes[i]);
			List<Integer> list_transactionsOneCompte_afterFilter = new ArrayList<Integer>();
			
			//Filter the data within a periode
			System.out.println("filter transaction start");
			if(date_periode_start == null && date_periode_finish == null) {
				for(int a = 0; a < list_transactionsOneCompte.length; a++) {
					list_transactionsOneCompte_afterFilter.add(list_transactionsOneCompte[a]);
				}
			} else if(date_periode_start != null && date_periode_finish == null) {
				for(int j=0; j< list_transactionsOneCompte.length; j++) {
					transaction = transactionDao.getTransaction(list_transactionsOneCompte[j]);
					if(transaction.getDate_transaction().getTime() > date_periode_start.getTime()) {
						list_transactionsOneCompte_afterFilter.add(list_transactionsOneCompte[j]);
					}	
				}	
			} else if (date_periode_start == null && date_periode_finish != null) {
				for(int j=0; j< list_transactionsOneCompte.length; j++) {
					transaction = transactionDao.getTransaction(list_transactionsOneCompte[j]);
					if(transaction.getDate_transaction().getTime() < date_periode_finish.getTime()) {
						list_transactionsOneCompte_afterFilter.add(list_transactionsOneCompte[j]);
					}	
				}	
			} else {
				for(int j=0; j< list_transactionsOneCompte.length; j++) {
					transaction = transactionDao.getTransaction(list_transactionsOneCompte[j]);
					//System.out.println("id_transaction:"+list_transactionsOneCompte[j]);
					//System.out.println("datetime:"+transaction.getDate_transaction().getTime());
					if(transaction.getDate_transaction().getTime() > date_periode_start.getTime() && transaction.getDate_transaction().getTime() < date_periode_finish.getTime()) {
						
						list_transactionsOneCompte_afterFilter.add(list_transactionsOneCompte[j]);
					}	
				}			
			}
			System.out.println("filter transaction finish");
			
			for(int j=0; j< list_transactionsOneCompte_afterFilter.size(); j++) {
				//System.out.println("id transaction of compte "+list_comptes[i]+":"+list_transactionsOneCompte[j]);
				transaction = transactionDao.getTransaction(list_transactionsOneCompte_afterFilter.get(j));
				if(transaction.getId_compte_recepteur() == list_comptes[i]) {
					//System.out.println("income");
					somme_income += transaction.getSomme();
				} else if(transaction.getId_compte_emetteur() == list_comptes[i]) {
					//System.out.println("outcome");
					somme_outcome -= transaction.getSomme();
				}
			}
			//System.out.println("somme_income:"+somme_income);
			//System.out.println("somme_outcome:"+somme_outcome);
			list_grapheData.put("income->"+compte.getCategorie_compte(), somme_income);
			list_grapheData.put("outcome->"+compte.getCategorie_compte(), somme_outcome);
			list_grapheData.put("total->"+compte.getCategorie_compte(), somme_income+somme_outcome);
			list_grapheData.put("id_client", Float.valueOf(id_select));
		}
		
		
		session.setAttribute("list_grapheData", list_grapheData);
		session.setAttribute("date_start_oneClient", date_periode_start_string);
		session.setAttribute("date_finish_oneClient", date_periode_finish_string);
		
		
		System.out.println("servlete for dataOneClient finish");
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
