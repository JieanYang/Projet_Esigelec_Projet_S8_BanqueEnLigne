package servlet;

import java.io.IOException;
import java.util.ArrayList;
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
 */
@WebServlet("/total_depot")
public class total_depot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
private Map<String, Float> list_grapheData = new HashMap<String, Float>();
	
	public static void main(String[] args) throws ServletException, IOException {
		total_depot test = new total_depot();
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		test.doGet(request, response);
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public total_depot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlete for dataOneClient start");

		//int id_select = Integer.valueOf(request.getParameter("id_user_input"));

		HttpSession session = request.getSession();
		
		list_grapheData.clear();
		//Recuperer toutes les transactions
		TransactionDao transactionDao = new TransactionDao();
		//Liste de toutes les transactions
		List<Transaction> List_All_Transaction = transactionDao.getListTransaction();
		System.out.println(List_All_Transaction.size());
		//Fitrer les transactions
		List<Transaction> List_Apres_filtre = new ArrayList<Transaction>();
		
		float somme_income = 0;
		float somme_outcome = 0;
		float total = 0;
		for(int i=0; i<List_All_Transaction.size(); i ++) {
			
			
			if(List_All_Transaction.get(i).getId_compte_emetteur()==999 || List_All_Transaction.get(i).getId_compte_recepteur()==999) {
				List_Apres_filtre.add(List_All_Transaction.get(i));
				
				
				if(List_All_Transaction.get(i).getId_compte_recepteur() == 999) {
					//System.out.println("income");
					somme_income  += List_All_Transaction.get(i).getSomme();
				} else if(List_All_Transaction.get(i).getId_compte_emetteur() == 999) {
					//System.out.println("outcome");
					somme_outcome -= List_All_Transaction.get(i).getSomme();
				}
			}
			//list_grapheData.put("income->", somme_income);
			//list_grapheData.put("outcome->", somme_outcome);
		    //list_grapheData.put("total->", somme_income+somme_outcome);
			
			session.setAttribute("somme_income", somme_income);
			session.setAttribute("somme_outcome", somme_outcome);
			session.setAttribute("total", somme_income+somme_outcome);
		}
		//somme Compte 
		
		
		//Integer[] list_comptes = (Integer[])list_idUser_idComptes.get(id_select);
		//System.out.println("id client: "+id_select);
		
		//pour chaque compte on recupere la liste des transactions, et pour chaque transaction si l'id de trouve dans la colonne id_compte_recepteur la somme augmente
		
		
			
			//variable de session pour afficher les sommes sur le graph
		//session.setAttribute("list_grapheData", list_grapheData);

			//list_grapheData.put("id_client", Float.valueOf(id_select));
		
		
		
		
		
		
		
		System.out.println("servlete for dataOneClient finish");
		request.getRequestDispatcher("total_depot_page.jsp").forward(request, response);
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
