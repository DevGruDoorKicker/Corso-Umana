package exerc;



//. Implementare la seguente classe garantendo l'incapsulamento appropriato.
//
//Employee (
//	id
//	firstName
//	lastName
//	age
//	
//	printInfo() {
//		..
//	}
//}
//
//Il valore di id deve essere generato automaticamente in modo univoco, leggibile ma non scrivibile.
//I campi firstName e lastName devono essere, una volta impostati, a sola lettura. Utilizzare come rafforzativo il modificatore final (valutare se necessario).
//L'età è leggibile e scrivibile con controllo dei valori ammissibili (ex.: age non può essere negativa)
//Il metodo printInfo deve prevedere la stampa degli attributi di Employee.
//
//Effettuare il test della classe dal main.
//




















public class Elettore {

	
	private final String nome;
	private final String cognome;
	
	private int age;
	private final int id; //solo il costruttore ha la chance di impostare il valore con il final, i costruttori sono obbligati a farlo, il costruttore dovrebbe essere unico
	

	private static int conta;
		
	
	
	public Elettore(String nome3, String cognome3, int age2) {
		this.id = conta++;
		this.nome = nome3;
		this.cognome = cognome3;
		setAge(age2); // il costruttore richiama il set per controllare le eccezioni 
		
	}
	public String getNome() {
		return nome;
	}
	
	
	
	public String getCognome() {
		
		return cognome;
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if (age<0) {
			return;
		}
		this.age = age;
		
	}
	public int getId() {
		return id;
	}	
	
	
	public void printInfo() {
		
		System.out.println(id +" "+ nome+" "+ cognome+" " +age);
	}
	

	
	
	
	
}
