package quintoGiorno;

import java.lang.management.MemoryPoolMXBean;

import javax.swing.tree.DefaultTreeSelectionModel;

// interfacce. di solito finiscono con il suffisso "able"
//da sole non sono istanziabili come le classi abstract
// in java ci sono le referenceVariables and non i puntatori


abstract interface Trainable{           //abstract è ridondante
	
	 public abstract void attendtraining();      //i metodi non possono avere body ed anche qui abstract è ridondante
	 
	 public int age=10;  // nelle interfacce è finale(non modificabile e deve essere assegnata per forza) e statico(non creo istanze di interfacce)
	 
	 public default void dafeaultTest() {    //giustificazione dell'aggiunta di un metodo con il body: backward compatibility risolta con default.
		 									// così la classe che vedesse una libreria di funzioni associate ad un interfaccia aggiornata non perderebbe le funzionalità
		 									
		 
	 }
}

interface WriteableAndreadable{
	
	public void read();
	public void write();
	
	public default void m1() {					//metodo default è una funzionalità aggiunta di recente
		
	}
}







public class Class1 {


	public static void mPol(Trainable obj) {
		
		obj.attendtraining();			            //il polimorfismo riconosce la differenza tra gli oggetti della classtest e della classtest2 come si vede dall' output del main
		
		if (obj instanceof WriteableAndreadable) {
			
			((WriteableAndreadable) obj).write();    //potrebbe funzionare anche se al posto di writableAndreadable mettessi la classtest2 ma avrei possibilmente
													 // metodi in più che non avrei necessità di richiamare oltre a quelli dell'interfaccia
			((WriteableAndreadable) obj).read();
			
		}
		
		if (obj instanceof Parent) {				// avrei potuto usare classtest2 con la funzione in override al posto di parent
			
			((Parent) obj).move();
		}
		
	}
	

	
	public static void main(String[] args) {
	
		ClassTest c2=new ClassTest();		
		c2.attendtraining();
		
		System.out.println("#########################################");
		
		
		Trainable trainable= new ClassTest();         //classe ed interfacce sono legate. posso usare puntatori diversi dagli oggetti istanziati (polimorfismo attraverso interfacce)
		Trainable trainable2= new ClassTest2();
		
		mPol(trainable);
		
		System.out.println("#########################################");
		
		mPol(trainable2);     
		
		System.out.println("#########################################");
		
	
		
		
	}
	
	
}


class Parent {
	
	
	public void move() {
		System.out.println("Move");
	}
	

	
}



class ClassTest implements Trainable {           //implements lega classi alle interfacce. devo implementare tutti i metodi richiesti dall'interfaccia

	@Override									// richiamato dall'interfaccia training. Sono sempre obbligato a dare body al metodo overridato dall'interfaccia
	public void attendtraining() {
		// TODO Auto-generated method stub
		System.out.println("attendTraining");
	}
	
	
	
}

class ClassTest2 extends Parent implements Trainable, WriteableAndreadable{         // definizione completa di classe

	@Override									
	public void attendtraining() {
		// TODO Auto-generated method stub
		System.out.println("attendTraining 2");
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		System.out.println("Read Funct");
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("Write Funct");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.move();
	}
	
	

	
	
}










