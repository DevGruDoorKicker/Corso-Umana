package encapsulation;

import java.util.Iterator;

import javax.security.auth.kerberos.KerberosKey;
import javax.swing.UIDefaults.ProxyLazyValue;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Class1 {

	public void multipliArgomenti(int... k) {
		
		System.out.println(k.length);
		
		for (int i = 0; i < k.length; i++) {
			System.out.println(k[i]);
	
		}
	}
			
			
			
		int max(int num1,int num2)	{           // la visibilità non c'entra con l'overloading
			
			return num1>num2? num1:num2;
		}
		
		float max(float num1,float num2)	{
			
			return num1>num2? num1:num2;
		}
			
		
		int min(int a, int b) {                // qui chiamo prima int perché occupa meno memoria di long (meno memory consuming)
			
			return -1;
		}
		long min(long a, long b) {
			
			return -1;
		}
			
		public int test(int a, int b) {
			
			 int max=a>b? a:b;	 
			 
			return max;
		}
	
		
	
	
	
	
	
}










class Class3{	
	
	String name;
	int age;
	private int voto; //se non metto private non ho i set che controllano valori ammissibili. encapsulement (visibilità e metodi)
	
	
	public Class3() {
		
		//costruttore ed inizializzatore sono allo stesso livello quindi uno non può andare dentro la'altro
		
		
	}
	
	public Class3(String name){
		
		this.name=name; //con this referenzio la variabile della classe. property rooting
		this.age=40;
		
		
		
	}
	public Class3(String name, int age){
		
		this.name=name;               //costruttore più completo (con più parametri)
		this.age=age;
		
	}
	
	public Class3(int age){
		
		this("lmao", age); // chiamata da fare solo dentro il costruttore. in automatico, this() cerca un costruttore. Constructor chaining. deve essere il primo statement in aossoluto
		
	}
	
	
	
		
		{
			System.out.println( "prova");//initializer che vengono eseguiti prima del costruttore ma il costruttore può avere argomenti in input. questo succede anche se l'initializer è prima del costruttore. 
		}
		
		static {
			//initializer statico in cui le variabili vengono inizializzate ogni volta con lo stesso valore. primo ad essere eseguito
			System.out.println("lmao");
		}
		
	public void finalize() {
		
		
		// cancella i valori come ultimo passaggio. meteodo distruttore
	}

	public int getVoto() {
		return voto; //dovrebbe essere un valore humuan readable
	}

	public void setVoto(int voto) {
		
		if (voto<20 || voto >30) {
			return; //non ritorno nulla
		}
		
		this.voto = voto;
	}
		
		
	float lmao(int i) {
		
		return ((float) i);

	}
		
		
		
		
		
		
		
		
		
	
	
}










 class Class2{
		
		public static void main(String[] args) {
					
			System.out.println("Lmao");
			
			new Class1().multipliArgomenti(1,2,3,4,5,6,3);
			
			new Class3();
			
			Class3 class3=new Class3("a");
			System.out.println(class3.name); // riconosce l'attributo name nella classe 3 richiamandolo con il punto.
			System.out.println(class3.age);
			
			Class3 class4=new Class3("ciccio graziani",67);
			
			System.out.println(class4.age  +" " + class4.name);
			
			class3.setVoto(18);
			
			new Class3().setVoto(25);
			new Class3("lmao", 15).getVoto();
			
		}
			
		
	}
	
	
	
	
	
	
	
	
