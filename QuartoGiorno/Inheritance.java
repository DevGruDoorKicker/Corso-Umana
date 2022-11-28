package quartoGiorno;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class Inheritance   {

	// se la classe genitore ha già una funzione chiamata allo stesso modo uso override per richiamarla @Override
	
	// la parola chiave extends permette l'eredità dei metodi e degli attributi della classe padre
	
	// super chiama costruttore specifico del genitore
	
	// super.nomefunzione permette lo shadowing che in alternativa all'override permette di richiamare la funzione omonima in maniera più light. funziona anche con le
	//variabili
	
	// metodo polimorfico: è un singolo metodo che è in grado di agire su istanze di oggetti diversi legati da un legame di ereditarietà
	
	
	
	static void methPol(Class1 obj) {  			// in input voglio il puntatore più generico ma i metodi chiamati all'interno sono quelli specifici
		obj.m1();
		System.out.println("ChiamataMethPol");
		
		if (obj instanceof Class2) {
			
			((Class2)obj).extra();				// assicurandomi di avere un elemento della class2 posso poi, castando obj, avere i metodi associati alla classe stessa
		}
		
		
		
		
	}
	
	
	
	
	
	
	static class Class1 {
		
		
		int k=10;
		int a;
		
		public Class1(int a) {
			
			this.a=a;
			System.out.println("Costruito c1");
		}
		
		
	
		public void m1() {
			
			System.out.println("M1C1");
		}
		
		
		
	}
	
	
	static class Class2 extends Class1 {  
	
		int k=100;                 // avendo un k diverso nella classe1 con super.k stamperei 10; mentre avrei 100 stampando k
		
		public Class2(int a) {
			
			super(a);
		}
	
	@Override	
	public void m1() {
		//super.m1();
		System.out.println("M2C2");
	}

	public void extra() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + k;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)           				//oggeto uguale a se stesso
			return true;
		if (obj == null)						
			return false;
		if (getClass() != obj.getClass())
			return false;
		Class2 other = (Class2) obj;
		if (k != other.k)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	}
	
	
	
	
	
	public static void main(String[] args) {
		
	Class1 class1= new Class2(12);  // oggetto generico di class 1 con le funzionalità della classe 1 ma non della 2
		
	//Class2 class2=new Class1(32);   // non ho visibilità al di sopra dell'oggetto della classe che estende
	System.out.println("##########################");	
	
	methPol(new Class1(10));
	methPol(new Class2(0));			// il metodo mi permette di chiamare in in put sia un oggetto di class1 che class2 perché una estende l'altra
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	
	
}
