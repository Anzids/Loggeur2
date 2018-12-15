package Loggeur;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exception implements Logg{

	private Date date;
	private DateFormat dateFormat; 
	private static  Exception instance = null;
	private File logFile;

	/**
	 * Initialisation des dates des exceptions
	 */
	private Exception() {
		this.date = new Date();
		this.dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	}
	
	/**
	 * 
	 * @return instance d'exception
	 */
	public static Exception getInstance() {
	      if(instance == null) {
	         instance = new Exception();
	      }
	      return instance;
	   }
	
	@Override
	public String afficherError(String message, int niveau, String chemin,String Consl,String File) throws IOException  {
		// TODO Auto-generated method stub
		String messageFinal="";
		if (niveau == 4) {
			
			 messageFinal = "["+this.dateFormat.format(this.date)+"]" + " (class Exception) : <" + message + ">\n";
			//System.out.println(messageFinal);
			File dir = new File("Fichiers-Loggeur");
			if (!dir.exists()) {
				dir.mkdir();
			}
			if(File.equals("TRUE")){
				logFile = new File("./Fichiers-Loggeur/" + chemin);
			}
			
			if(File.equals("TRUE")){
				ecrireMessage(messageFinal);
			}
			if(Consl.equals("TRUE")){
				
				System.out.println(messageFinal);
			}
					}
		return messageFinal;
	}
	
	@Override
	public void afficherError(String message, int niveau, String[] Data) throws IOException  {
		// TODO Auto-generated method stub
		if (niveau == 4) {
			
			String messageFinal="";
			if (niveau == 4) {
				
				 messageFinal = "["+this.dateFormat.format(this.date)+"]" + " (class Exception) : <" + message + ">\n";
				//System.out.println(messageFinal);

					File dir = new File("Fichiers-Loggeur");
					if (!dir.exists()) {
						dir.mkdir();
					}
					if(Data[2].equals("TRUE")){
						logFile = new File("./Fichiers-Loggeur/" + Data[0]);
					}
					
					try {
						if(Data[2].equals("TRUE")){
							ecrireMessage(messageFinal);
						}
					} catch (java.lang.Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(Data[1].equals("TRUE")){
						
						System.out.println(messageFinal);
					}
						}
					}
	}
	
	public void ecrireMessage(String message) throws IOException  {
		  BufferedWriter writer = null ;

		try {

			writer = new BufferedWriter(new FileWriter(logFile, true));
			writer.write(message+"\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
			}
		} 
	}

}
