package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		
		
		// fill the list of compte and transaction
		 list_compte = compteDao.getListCompteById_lient(id_client);
		 List<Transaction> listTansaction_Onecompte = new ArrayList<Transaction>();
		 int id_compte;
		 for(int i=0; i<list_compte.size();i++) {
			 
			 // for each id_compte
			 id_compte = list_compte.get(i).getId_compte();
			
		 	listTansaction_Onecompte = transactionDao.getListTransactionById_compte(id_compte);
		 	
		 	
		 	for(int j=0; j<listTansaction_Onecompte.size(); j++) {
		 		// add transactions of id_compte dans list_transaction for return
			 	list_transaction.add(listTansaction_Onecompte.get(j));
		 	}
		 }		 
		
		
		
		// Session
		 HttpSession session = request.getSession();
		 session.setAttribute("CompteInfo", list_compte);
		 session.setAttribute("TransactionInfo", list_transaction);
		 

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
