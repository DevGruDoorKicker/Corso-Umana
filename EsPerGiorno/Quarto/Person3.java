package exercQuartoGiorno;

import java.util.ArrayList;



//9. In relazione all'esercitazione precedente, scrivere un metodo polimorfico che sia in grado 
//di stampare il salario di tutte le categorie di dipendenti passate in input. In caso di EmpTD2, chiamare anche impMethod().
//
//Prevedere la simulazione di dati attraverso un array/ArrayList.
//
//		3 employees -> ...
//		for (..)
//			mpolim(..) 


//8. Effettuare un refactor del codice precedente prevedendo una nuova classe genitore Person.
//
//Person
//	id
//	name
//
//Considerare la stampa "human readable" di un oggetto Person. Valutare l'utilizzo del metodo  toString()
//Due oggetti Person devono inoltre essere considerati uguali se hanno lo stesso id e lo stesso nome. 
//
//Test dal main. 
//





public class Person3 {
	
	
	
	private int id;
	private String name;
	
	
	
	

	public Person3(int id, String name) {	
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person3 person = (Person3) obj;
		if (id != person.id)
			return false;
		if (name == null) {
			if (person.name != null)
				return false;
		} 
		
		else if (!name.equals(person.name))
			return false;
		
		return true;
	}
	
	static void methPol(EmployeeEred3 obj) {  			
		
			System.out.println(obj.calcSal());  ///riconosce in automatico che tipo di dato è tra operaio e impiegato
		
			if (obj instanceof Impiegato3) { 				
				((Impiegato3) obj).impMethod();
			
			}			
			
	}		

	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		Person3 person=new Person3(2, "gino");
		Person3 person2=new Person3(2, "GIGGI");
		Person3 person3=new Person3(2, "gino");
		
		Operaio3 operaio=new Operaio3(2, "Giggi", 2, 5, 10);
		Impiegato3 impiegato3=new Impiegato3(2, "gigner", 20, 10);
		Impiegato3 impiegato4=new Impiegato3(2, "gigner", 20, 10);
		
		
		System.out.println(operaio);
		System.out.println(person);
		
		System.out.println(person.equals(person3));
		System.out.println(person.equals(person2));
		
		
		ArrayList<EmployeeEred3> employeeEred3s=new ArrayList<>();
		
		employeeEred3s.add(operaio);
		employeeEred3s.add(impiegato3);
		employeeEred3s.add(impiegato4);
		
		for (EmployeeEred3 e : employeeEred3s) {
			
			Person3.methPol(e);
			
		}
		
		
		
		

		
	}
	
	
}



	abstract class EmployeeEred3 extends Person3{
		
		private float payh;
		private int numh;
		
		
		public EmployeeEred3(int id, String name, float payh, int numh) {
			super(id, name);
			this.payh = payh;
			this.numh = numh;
		}



		public float calcSal() {
					
			return numh*payh;
		}
	
	
	}
	
	 final class Impiegato3 extends EmployeeEred3{

		public Impiegato3(int id, String name, float payh, int numh) {
			super(id, name, payh, numh);
			
		}
		
		public void impMethod() {
			
		}

		@Override
		public float calcSal() {
			// TODO Auto-generated method stub
			return super.calcSal();
		}
			
		
	}
	

	
	final class Operaio3 extends EmployeeEred3{

		private float rit;
				
		public Operaio3(int id, String name, float payh, int numh, float rit) {
			super(id, name, payh, numh);
			this.rit=rit;
			// TODO Auto-generated constructor stub
		}
		
		
		@Override
		public float calcSal() {
			// TODO Auto-generated method stub		
			return super.calcSal()*this.rit;
		}
			
		
	}
















