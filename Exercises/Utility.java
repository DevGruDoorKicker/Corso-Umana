package exerc;

public class Utility {

	
	private int num;
	
	
	
	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public static void swap(Persona persona1, Persona persona2) {
		
		Persona tmPersona=persona1;
		
		persona1.setId(persona2.getId());		
		persona1.setNome(persona2.getNome());
		
		persona2.setId(tmPersona.getId());
		persona2.setNome(tmPersona.getNome());	
		
	}
	
	public static int swapAlt(int a, int b ) { // funziona perché ho un return ma senza vettori ho solo un ritorno
		
		int tmpNum=a;
		
		a=b;
		
		b=tmpNum;
			
		return a;
	}
	
	public static void swap(int num, int num2 ) { // non funziona per pass bycopy
		
		int tmpNum=num;
		
		num=num2;
		
		num2=tmpNum;
			
		
	}
	

	
	
	
	
	
	
	
	
}
