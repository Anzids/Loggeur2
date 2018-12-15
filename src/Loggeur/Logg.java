package Loggeur;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public interface Logg { 
	
	/**
	 * On a l'affichage de l'erreur dans la console/ le fichier selon le niveau choisis
	 * @param message
	 * @param niveau
	 * @param chemin
	 * @param Consl
	 * @param File
	 * @throws IOException
	 */
	String afficherError(String message,int niveau,String chemin,String Consl,String File) throws IOException;  
	
	/**
	 *  On a l'affichage de l'erreur dans la console/ le fichier selon le niveau choisis
	 * @param message
	 * @param niveau
	 * @param Data
	 * @throws IOException
	 */
	void afficherError(String message,int niveau,String[] Data) throws IOException; 
}
