package exerc;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Singleton singleton=Singleton.getSingleton();
		
		Singleton singleton2=Singleton.getSingleton();
	
		
		if (singleton==singleton2) {
			System.out.println(false);
		}
		
		
		
		Persona persona=new Persona(23, "GIGGI");
		
		Persona persona2=new Persona(29, "Ginger");
		
		int a=20;
		int b=40;
		
		Utility utility=new Utility();
		
		
		utility.swap(a, b);
		
		System.out.println(utility.swapAlt(a, b));
		
		utility.swap(persona, persona2);
		
		System.out.println(persona.getId());
		System.out.println(persona2.getId());
		
		
		Elettore elettore=new Elettore("lmao", "stupido", -100);
		Elettore elettore2=new Elettore("lmao", "stupido", -100);
		elettore.printInfo();
		elettore2.printInfo();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	}


