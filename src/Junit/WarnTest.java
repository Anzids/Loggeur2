package Junit;
import Loggeur.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WarnTest {
	Warn wn;
	LogFactory logf;
	
	@Before
	public void setUp() throws IOException {
		  wn=Warn.getInstance();
		  logf=LogFactory.getInstance();
	}

	@After
	public void tearDown() throws IOException {
	}

	@Test
	public void test() throws IOException {
		assertEquals("", wn.afficherError("samya", 4, logf.getChemin(), "TRUE", "FALSE") );
	}
	
	//Cette fonction va tester si on permet d'ecrire dans le fichier ca s'ecrit ou pas 
	@Test
	public void testEcrireFileWarn() throws IOException{
		int count=0,count2=0;
		FileInputStream fis = new FileInputStream(logf.getNameFile());
		LineNumberReader l = new LineNumberReader(new BufferedReader(new InputStreamReader(fis)));
		           fis.mark(0);
		while ((l.readLine())!=null){
		                count = l.getLineNumber();
		             }
		fis.close();
		wn.afficherError("samya", 3,logf.getChemin() , "TRUE", "TRUE");
		FileInputStream fis2 = new FileInputStream(logf.getNameFile());
		LineNumberReader l2 = new LineNumberReader(new BufferedReader(new InputStreamReader(fis2)));
		while ((l2.readLine())!=null) { count2 = l2.getLineNumber();}

		assertNotEquals(count2, count);
	}

}
