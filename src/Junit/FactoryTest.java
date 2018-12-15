package Junit;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Loggeur.*;

public class FactoryTest {

	  protected  LogFactory testFactory;

		@Before
		public void setUp() throws IOException {
			testFactory =LogFactory.getInstance();
		}

		@After
		public void tearDown() throws IOException {
		}

		@Test
		public void testReussi()  throws IOException{
	 		assertEquals(3, testFactory.getniveau());

	 	/*	try {
	 			testFactory.setniveau(-2);   
	 		    fail("Normalement ca doit afficher un messager d'erreur le niveau et compris entre 1 et 4");
	 		    } catch (IllegalStateException ise) {
	 		    }*/
	 		
		}
		
		@Test
		public void testEchoue()  throws IOException{
	 		Assert.assertNotEquals(2, testFactory.getniveau());
	 	/*	try {
	 			testFactory.setniveau(-2);   
	 		    fail("Normalement ca doit afficher un messager d'erreur le niveau et compris entre 1 et 4");
	 		    } catch (IllegalStateException ise) {
	 		    }*/
	 		
		}
		
		@Test 
		public void testmessage() throws IOException{
			//si on met Debug elle doit obligatoirement retourner un objet de type Debug
			Debug dg=Debug.getInstance();
			assertEquals(dg,testFactory.getErreur("Debug"));
			//si on met Info elle doit obligatoirement retourner un objet de type Info
			Info info=Info.getInstance();
			assertEquals(info,testFactory.getErreur("Info"));

			
		}


}
