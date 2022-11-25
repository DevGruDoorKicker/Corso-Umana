package elementiMultidimensionali;

public class StringBuilderClass {

	
	//classe mutabile. niente degrado di performance come nel caso delle stringhe
	
	// non creo mai stringhe nuove ma le modifico e basta	
	
	
	String strEs="";
	StringBuilder stringBuilder=new StringBuilder();
	
	long inizio= System.currentTimeMillis(); //prendo il tempo trascorso dal 1970 e lo confronto dopo che il ciclo è finito
	
	public float getMillisStr() {
					
		for (int i = 0; i < 10000000; i++) {
			strEs+="JavaCode"; 
			
		}
		
		long fine= System.currentTimeMillis();
		
		return (fine-inizio);
	}
	
	
	public float getMillisStrBuild() {
		
		for (int i = 0; i < 10000000; i++) {
			stringBuilder.append("javacode");
			
		}
		
		long fine= System.currentTimeMillis();
		
		return fine-inizio;
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		
		
	StringBuilder sbBuilder=new StringBuilder(); // costruttore default
	StringBuilder sbBuilder2=new StringBuilder("lamoa"); 

	
	// aggiungo cose alla stringa vuota
	
	sbBuilder.append(10);
	sbBuilder.append('c');
	
	System.out.println(sbBuilder);
	
	System.out.println("###############");
	
	// insert inserisce nella posizione indicata
	
	sbBuilder2.insert(0, "AYYYY");
	
	System.out.println(sbBuilder2);
	
	System.out.println("###############");
	
	System.out.println("stringa senza cancellazioni " + sbBuilder + " diventa: ");
	
	sbBuilder.delete(0, 2);
	
	System.out.println(sbBuilder);	
	
	System.out.println("##############################");
	
	
	//esercizio performance
	
//	Effettuare un benchmark che metta a confronto le performance di String vs StringBuilder utilizzando un ciclo for che concateni ad ogni loop
//	la stringa "JavaCode" ad una stringa esistente.
//
//	for (int i=0; i<10000; i++)
//		..
//
//Il benchmark dovrebbe mettere a confronto il tempo impiegato ad eseguire il loop richiesto in caso di utilizzo di String vs StringBuilder. 
//	Documentarsi sull'utilizzo di System.currentTimeMillis().
//	
//	
// FUNZIONI INSERITE AD INIZIO CLASSE
	
	
	StringBuilderClass stringBuilder=new StringBuilderClass();
	
	StringBuilderClass string=new StringBuilderClass();
	
	System.out.println(stringBuilder.getMillisStrBuild()/1000.0f);
	System.out.println(string.getMillisStrBuild()/1000.0f);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
}
