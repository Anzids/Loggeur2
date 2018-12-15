package Loggeur;

import java.io.IOException;

public class FactoryPatternDemo {

	public static void main( String[] args) throws IOException {
	      LogFactory shapeFactory = LogFactory.getInstance();
	      
	      //shapeFactory.setniveau(1);
 	      Logg dg1 = shapeFactory.getErreur("Debug");
 	      System.out.println(shapeFactory.getniveau());
	      dg1.afficherError("samya", shapeFactory.getniveau(),shapeFactory.getChemin(),shapeFactory.getConsol(),shapeFactory.getFile());
	      
	      
 	      Logg dg2 = shapeFactory.getErreur("Info");
 	     dg2.afficherError("samya", shapeFactory.getniveau(),shapeFactory.getChemin(),shapeFactory.getConsol(),shapeFactory.getFile());
	      
 	    Logg dg3 = shapeFactory.getErreur("Warn");
	     dg3.afficherError("samya", shapeFactory.getniveau(),shapeFactory.getChemin(),shapeFactory.getConsol(),shapeFactory.getFile());
	     
	     Logg dg4 = shapeFactory.getErreur("Error");
	     dg4.afficherError("samya", shapeFactory.getniveau(),shapeFactory.getChemin(),shapeFactory.getConsol(),shapeFactory.getFile());
	     
	     
	     int a = 4;
			int b = 0;
			try {
			  int c = a / b;
			
			} catch(ArithmeticException ex) {
				
				Logg dg5 = shapeFactory.getErreur("Exception");
			     dg5.afficherError("Message:"+ex.getMessage()+" StackTrace:"+ex.getStackTrace(), shapeFactory.getniveau(),shapeFactory.getChemin(),shapeFactory.getConsol(),shapeFactory.getFile());
 			}

	      
	   }
	
}
