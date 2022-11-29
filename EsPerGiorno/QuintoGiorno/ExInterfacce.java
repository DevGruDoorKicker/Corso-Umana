package exercQuintoGiorno;



//fulvio dice:8. Implementare la classe Student555 che permetta ad uno studente di essere un footballer e un f1driver 
//nello stesso istante attraverso l'implementazione delle interfacce opportune.
//
//		Student555
//			id
//			name
//
//		IFootballer
//			score()
//			
//		IF1Friver
//			driveToTheLimit()
//
//Scrivere inoltre un metodo polimorfico che permetta dato in input un oggetto Student555 di invocare i suoi aspetti da footballer e di f1driver. 
//




public class ExInterfacce {
	
	

	
	public static void mPol(Student obj) {
				
			obj.driveToLimit();
			obj.score();			
			
	}
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Student student=new Student();
		
		mPol(student);
		
		System.out.println("#########################################");
		
//		F1Driver f1Driver=new Student();         dovrei fare un'altra/altre funzioni mpol
//		FootBaller footBaller=new Student();
//		
//		mPol(f1Driver);
//		mPol(footBaller);
		
	}

}



class Student implements F1Driver, FootBaller{
	
	private int id;
	private String name;
	
	@Override
	public void score() {
		// TODO Auto-generated method stub
		System.out.println("GOALSSSSSSSSSSSSSSS");
	}
	@Override
	public void driveToLimit() {
		// TODO Auto-generated method stub
		System.out.println("BROOM BROOM");
	}
	
	
	
	
}


interface FootBaller  {
	
	void score();
	
}

interface F1Driver{
	
	void driveToLimit();
}










