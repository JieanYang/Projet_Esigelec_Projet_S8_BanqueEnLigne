package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.Transaction;

/**
 * Servlet implementation class BordereauCheque
 */
@WebServlet("/BordereauServlet")
public class BordereauServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BordereauServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fileName = "bordereaucheque.jpg";
		String path = getServletContext().getRealPath("/")+"Image\\"+fileName;
		System.out.println(path);
		
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
	    
	    
	    // write file
	    int b;  
	    while((b=in.read())!= -1)  
	    {  
	        out.write(b);  
	    }  
	      
	    in.close();  
	    out.close();		
		
		System.out.println("telechargement éffectué");
		
		response.sendRedirect("Clientconnecte.jsp");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("yhea");
		String fileName = "bordereaucheque.jpg";
		String path = getServletContext().getRealPath("/")+"Image\\"+fileName;
		System.out.println(path);
		
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
	    
	    
	    // write file
	    int b;  
	    while((b=in.read())!= -1)  
	    {  
	        out.write(b);  
	    }  
	      
	    in.close();  
	    out.close();		
		
		System.out.println("telechargement éffectué");
		

}
}
