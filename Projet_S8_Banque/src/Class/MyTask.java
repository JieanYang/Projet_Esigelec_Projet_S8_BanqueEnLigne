package Class;

import java.util.TimerTask;

import dao.CompteDao;

public class MyTask extends TimerTask{
	CompteDao monDAO =new CompteDao();
	private float soldes ;
  
	public MyTask(float solde){
    this.soldes = solde ;
   }

   @Override
   public void run() {
     this.soldes = (float) ((this.soldes * 0.75)/100) +this.soldes;
     monDAO.modifierSolde(this.soldes);
    
   }

}
