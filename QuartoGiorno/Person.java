package quartoGiorno;

import java.util.ArrayList;


//Parte di ripasso

public class Person{
		
		private String name;             // se due puntatori puntano allo stesso oggetto è una questione di posizione in memoria
										 // differenza tra primitivi e puntatori. String pooling etc.									
		public Person(String name) {     // 2 new String creano 2 oggetti diversi e quindi hanno 2 posizioni in memoria diverse ma se String a e String b sono assegnate
										// allo stesso valore allora l'uguaglianza è verificata
			this.name = name;
		}
		
		
		@Override                             //annotazione che aiuta a definire che il metodo è ereditato da un'altra classe e quindi di risalire agli argomenti
		public boolean equals(Object obj) {
			
			Person person= (Person) obj;
													//occhio a cambiare l afirma perché cambierebbe il risultato
			return this.name.equals(person.name);	// nostra implementazione che cerca l'uguaglianza tra oggetti confrontando i nomi
		}
		
		
	
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stubs
			
			
			
			
			Person person2=new Person("ciccio");
			Person person=new Person("ciccio");
			
			System.out.println(person.equals(person2));		
			System.out.println(person==person2);
			
			System.out.println("############################");
			
			ArrayList<Person> myPersons= new ArrayList<>() ;
			
			myPersons.add(person);
			myPersons.add(person2);
			
			System.out.println(myPersons.contains(person));
			System.out.println(myPersons.contains(new Person("ciccio")));		
			
			System.out.println("############################");
			
			
			ArrayList<StringBuilder> mBuilders= new ArrayList<>();
			
			mBuilders.add(new StringBuilder("Pover"));
			mBuilders.add(new StringBuilder("Pover2"));
			mBuilders.add(new StringBuilder("Pover3"));
			
			ArrayList<StringBuilder> clone=(ArrayList<StringBuilder>) mBuilders.clone();
			
			System.out.println(mBuilders==clone);   // dà falso perché è un o shallow clone a differenza con un deep clone che devo definire
													// java reflection api mi permettere di clonare al volo classi fatte da altri
			
			StringBuilder el1=mBuilders.get(0);
			StringBuilder el1c=clone.get(0);
			
			System.out.println(el1==el1c);
			
		}				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
		
		
		
		
		

