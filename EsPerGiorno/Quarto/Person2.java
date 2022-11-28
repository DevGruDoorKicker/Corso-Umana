package exercQuartoGiorno;

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

















public class Person2 {
	
	
	
	private int id;
	private String name;
	
	
	
	

	public Person2(int id, String name) {	
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
		Person2 person = (Person2) obj;
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
	
	public static void main(String[] args) {
		
		
		Person2 person=new Person2(2, "gino");
		Person2 person2=new Person2(2, "GIGGI");
		Person2 person3=new Person2(2, "gino");
		
		Operaio2 operaio=new Operaio2(2, "Giggi", 2, 5, 10);
		
		
		System.out.println(operaio);
		System.out.println(person);
		
		System.out.println(person.equals(person3));
		System.out.println(person.equals(person2));
		

		
	}
	
	
}


	abstract class EmployeeEred2 extends Person2{
		
		
		
		private float payh;
		private int numh;
		
		
		public EmployeeEred2(int id, String name,float payh, int numh) {
			super(id,name);
			this.payh = payh;
			this.numh = numh;
		}



		public float calcSal() {
					
			return numh*payh;
		}



		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString()+" paga oraria "+payh+" numero ore "+numh;
		}
		
		
		
	
		
	}
	
	
	final class Impiegato2 extends EmployeeEred{	

		public Impiegato2(int id, String name, float payh, int numh) {
			super(id, name, payh, numh);
			// TODO Auto-generated constructor stub
		}

		public void impMethod() {
			
		}

		@Override
		public float calcSal() {
			// TODO Auto-generated method stub
			return super.calcSal();
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
		
		
		
		
		
	}
	

	
	final class Operaio2 extends EmployeeEred{

		private float rit;
					
		
		@Override
		public float calcSal() {
			// TODO Auto-generated method stub		
			return super.calcSal()*this.rit;
		}


		@Override
		public String toString() {
			return super.toString() + "Operaio [rit=" + rit + "]";
		}
		
		public Operaio2(int id, String name, float payh, int numh, float rit) {
			super(id, name, payh, numh);
			this.rit=rit;
			// TODO Auto-generated constructor stub
		}
		
		
		
		
	}
	
	
	
	
