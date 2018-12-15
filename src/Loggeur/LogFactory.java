package Loggeur;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;


public class LogFactory  {
	 


	private File logFile;
	private InputStream inputStream;
	private String result = "";
	private String fich;
	private String cons;
	private int niveau ;
	private String chemin;
	private static LogFactory instance=null;


	/**
	 * On initialise tout les données possible a l'aide de fichier Conf.properties
	 * On récupère le chemin, si on doit écrire dans la console, écrire dans un fichier et le niveau
	 * @throws IOException
	 */
	private  LogFactory() throws IOException {
		String file="TRUE";
		String console="TRUE";
		  this.chemin=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		  this.chemin = "Log-" + this.chemin;
		String nivel="DEBUG";
		
		try {
			Properties prop = new Properties();
			String propFileName = "conf.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			// get the property value and print it out
			this.chemin = prop.getProperty("FILE.PATH");
			console = prop.getProperty("CONSOLE.ACTIVE");
			file = prop.getProperty("FILE.ACTIVE");
			nivel =prop.getProperty("MIN_LVL");
 
			this.fich=file;
			System.out.println(file);
			this.cons=console;
			System.out.println(this.cons);
			
			this.result = "On a écriture en fichier: " + file + " en console: " + console;
			System.out.println(this.result);
			} catch (IOException e) {
				System.out.println("Exception: " + e);
			} finally {
				inputStream.close();
			}
		if(file.equals("TRUE")){
			if(file.equals("FALSE")){
				System.out.println("Vous avez mal orthographié FALSE ou TRUE, on a donc initialié en TRUE "+ this.fich);
				this.fich="TRUE";
			}
		}
			
		if(console.equals("TRUE")){
			if(console.equals("FALSE")){
				System.out.println("Vous avez mal orthographié FALSE ou TRUE en console, on a donc initialié en TRUE "+this.cons);
				this.cons="TRUE";
			}
		}
		
		if(nivel.equals("DEBUG")){this.niveau=1;}
		else{ 
			if(nivel.equals("INFO")){this.niveau=2;}
			else{
				if(nivel.equals("ERROR")){this.niveau=4;}
				else{
					if(nivel.equals("WARN")){this.niveau=3;}
					else{
						System.out.println("Error dans la syntaxe, par conséquent on a initialisé en debug");
						this.niveau=1;}
					}
				}
		}
		
	}
	
	public static LogFactory getInstance() throws IOException {
		 if(instance == null) {
	         instance = new LogFactory();
	      }
	      return instance;
	}
	
	/**
	 * @return le nom du fichier
	 */
	public String getChemin() {return this.chemin;}
	
	/**
	 * @return si on veux ou on écrire dans la console
	 */
	public String getConsol() {return this.cons;}
	
	/**
	 * @return si on veux ou on écrire dans le fichier
	 */
	public String getFile() {return this.fich;}
	
	/**
	 * On crée un tableau contenant les 3 information du fichier conf.properties: 
	 * chemin, 
	 * écrire dans le fichier, 
	 * écrire dans la console
	 * @return le tableau
	 */
	public String[] getData(){
		String[] array = new String[] {this.chemin, this.cons, this.fich};
		return array;
	}
	
		/*public void setniveau(int i){
			this.niveau=i;
		}*/
		
	/**
	 * @return le niveau 
	 */
		public int getniveau(){return this.niveau;}
	
	/**
	 * On regarde si notre valeur correspond a un niveau existant
	 * @param Niveau
	 * @return Niveau
	 */
 	   public Logg getErreur(String Niveau){
	      if(Niveau == null){
	         return null;
	      }		
	      if(Niveau.equalsIgnoreCase("Debug")){
	         Debug deg= Debug.getInstance();
	         return deg;
	         
	      } else if(Niveau.equalsIgnoreCase("Info")){
	    	  Info inf= Info.getInstance();
		         return inf;
	         
	      } else if(Niveau.equalsIgnoreCase("Error")){
	    	  Error erreur= Error.getInstance();
	         return erreur;
	      } else if(Niveau.equalsIgnoreCase("Warn")){
	    	  Warn warng= Warn.getInstance();
		         return warng;
		      }
	      else if(Niveau.equalsIgnoreCase("Exception")){
	    	  Exception exp=Exception.getInstance();
		         return exp;
		      }
	      
	      return null;
	   }
 	   
 	   
 	   public String getNameFile() {
 		String name="./Fichiers-Loggeur/" + this.chemin;
 		return name;
 	   }
 	   
 	  
	
}
