package quintoGiorno;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

// eccezioni


// throw è il modo di solloevare le eccezioni


// le eccezioni sono classi. Guardare lo schema Throwable con figli Exception, Error sui moduli etc...








public class Class2 {

	
	
	
	static void m0() {
		
		try {											// esiste il blocco try finally
					
		} finally {
		
		}
	}
	
	
	
	
	
	static void exceptHandl(int num) throws Exception {
		
		if (num>=10) {								//throw solleva e propaga? l'eccezione
			throw new Exception("Overheating");		// infatti excepion è una classe che va istanziata ed è il genitore delle checked
													// NullPointerExcpetion non sarebbe stata segnalata in fase di compilazione perché non checked
		}
		
		if (num<0) {
			throw new NullPointerException("overPressure");	
		}
	}
	
	static void exceptHand2() {
		
		try {
			
			exceptHandl(10);					// catturo l'eccezione tramite il costrutto try catch. Il codice problematico va nel try
													// se non conosco la tipologia specifica di errore posso mettere le classi genitore (come ho fatto nel catch)
		} 
			
		catch (Exception e) {
			System.out.println(e.getMessage());    //stampa overheating
			
			}
		
		finally {									
														// la prova chiave finally permette dieseguire sempre il codice indifferentemente da ciò che succede nei catch
			
														// anche mettendo 9 nella funzione excepthandl2 il finally viene eseguito
			System.out.println("finally");				
		}
	}
	
	
static void exceptHand3() {
		
		try {
			
			exceptHandl(10);					
													
		} 
			
		catch (NullPointerException e) {						// posso avere più catch per ogni try
			System.out.println(e.getMessage());   	
			
			}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());   
			
			}
		catch (Exception e) {									// catch alla fine deve essere fatta sulla classe genitore per comprendere tutti gli errori non invocati
			System.out.println(e.getMessage());   
			
			}
		
		finally {										
												
														
			System.out.println("finally 2");				
		}
	}		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) /*throws FileNotFoundException */{
		
		//String [] array= new String[] {"a"};
		
		
		//System.out.println(array[2].length());            // errore del programmatore (runtime cioè in fase di run), ho passato un indice che non esiste andando outOfBound	
		
		//FileInputStream rInputStream=new FileInputStream("file.txt");  //codice smette di compilare(eccezione checked).Può essere dovuta ad interazione con database esterni
		
																	//gestisco l'errore usando il throw "throws FileNotFoundException" allora la propago mettendola a video
		
		exceptHand2();
		System.out.println("############################################");
		exceptHand3();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
