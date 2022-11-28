package exercQuartoGiorno;

//7. Implementare la seguente gerarchia.
//
//Employee20
//	id
//	name
//	payh - float
//	numh - int
//	calcSal()
//
//	|
//-----------------
//|		 	     |
//EmpTD20	      EmpTI20
//	 	 		  rit - float
//calcSal()		  calcSal()
//payh*numh	      payh*numh*rit
//impMethod() {}
//
//Prevedere una collocazione corretta per il metodo calcSal.
//Impedire l'istanziazione diretta di Employee20.
//Considerare inoltre le classi EmpTD20 e EmpTI20 non specializzabili.
//
//Test dal main. 





abstract class EmployeeEred {
	
	
	private int id;
	private String name;
	private float payh;
	private int numh;
	
	
	public EmployeeEred(int id, String name, float payh, int numh) {
		this.id = id;
		this.name = name;
		this.payh = payh;
		this.numh = numh;
	}



	public float calcSal() {
				
		return numh*payh;
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		

		Operaio2 operaio=new Operaio2(2, "Giggi", 2, 5, 10);
		
		System.out.println(operaio.calcSal());
		
	}
	
}
	
	
	
	
	 final class Impiegato extends EmployeeEred{

		public Impiegato(int id, String name, float payh, int numh) {
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
	

	
	final class Operaio extends EmployeeEred{

		private float rit;
				
		public Operaio(int id, String name, float payh, int numh, float rit) {
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	














