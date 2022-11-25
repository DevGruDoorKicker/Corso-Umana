package elementiMultidimensionali;

public class Stringhe {

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		String string=new String("fulvio");
		String string2=new String("fulvio");
		
		System.out.println(string==string2); //false perché 2 oggetti differenti vengono creati, nel caso di assegnazione diretta avrei una sovrascrittura. Nelle strignhe non serve passare il new
		
		
		System.out.println("############################");
		
		String string3="lmao";
		String string4="lmao";
		
		System.out.println(string3==string4); // infatti qui è uguale, ho creato un solo oggetto
		
		// le stringhe sono immutabili. Se string4 venisse modificata verrebbe creata una nuova stringa, nel senso che la stringa 3 sarebbe inalterata
		string4="blah";
		
		System.out.println(string3);
		System.out.println(string4);
		
		// questa cosa rende un lavoro oneroso al garbage collector che deve cancellare tulle strignhe che puntano a valori "vecchi"
		
		
		System.out.println("############################");
		
		//charat
		
		String nsString= new String("pover");
		
		System.out.println("############################");
		
		//lunghezza della stringa
		System.out.println(nsString.length());
		
		System.out.println("############################");
		
		//posso andare fino alla lenght-1 altrimenti vado in "out of bound exeption" e.g. System.out.println(nsString.charAt(10));
		System.out.println(nsString.charAt(0));
		
		
		System.out.println("############################");
		
		//sottraggo ciò che viene prima dell'indice inserito
		String reString=nsString.substring(2);
		
		System.out.println(reString);
		// stringa immutata
		System.out.println(nsString);
		
		System.out.println("############################");
		
		//rimozione spazi alla fine ed all'inizio
		nsString.trim();
		
		System.out.println("############################");
		
		//replace. ha diverse istanze di overloading. questo in particolare sostituisce la lettera vecchia con quella nuova 	
		String string5= nsString.replace("o", "u");
		// sequenza di caratteri
		nsString.replace("pov", "lma");
		
		System.out.println(string5);
		
		System.out.println("############################");
		
		//chiede se la stringa inizia o finisce nel modo indicato. restituisce un booleano. 
		System.out.println(nsString.startsWith("pov"));
		System.out.println(nsString.endsWith("pov"));
		
		System.out.println("############################");
		
		//confronto stra stringhe		
		System.out.println("ginger".equals("bomber")); //questo metodo loeredito dalla classe genitore Object
		System.out.println("ginger".equalsIgnoreCase("GINGEr"));
		
		System.out.println("############################");
		
		// overload degli operatori. e.g. l'operatore somma può, in java, per sommare stringhe e numeri.
		String str="lmayo";
		//posso usare solo il più con le stringhe
		str=str+1; // tutto può essere convertito in una stringa. perché tutto in java ha una rappresentazione in stringa
		str=str+true; 
		// la conversione parte da quando vedo la prima stringa
		str=10+1+str+1;
		System.out.println(str);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
