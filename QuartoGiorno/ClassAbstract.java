package quartoGiorno;

import javax.xml.ws.AsyncHandler;

public class ClassAbstract {

	
	// classe che pu� essere solo ereditata ma non pu� essere istanziata (classe estendibile)
	
	// classe final invece pu� essere solo istanziata ma non ereditata
	
	
	
	abstract class AbstractClass{    //uso per costruire funzionalit� per framework
			
		void m1() {				
			
		}
		
		abstract void m2();     //metodo astratto. metodo non implementato cio� senza body che pu� essere solo richiamata dando del codice
		
	}
	
	
	final class FinalClass {
		
		void m1() { 			//nessun metodo overridabile, metodi che non sono modificabili		
		}
		
		void m2() {				// anche i metodi singolo possono essere final e bloccare per singolo metodo impostato come final
		}
		
	}
	
	
	
}
