package elementiMultidimensionali;

import java.util.ArrayList;

public class ArrayListss {

	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		//sintassi di inizializzazione
		ArrayList<String> arrayList=new ArrayList<>();
		
		// non ha dimensione limitata, posso aggiungere all'infinito
		arrayList.add("lmao");
		
		
		// per ogni dato primitivo ho una classe wrapper corrispondente. Classi che incorporano i valori in oggetti come sovrainsiemi. Il tipo dell'arraylist può essere solo un oggetto(un puntatore)
		ArrayList<Integer> arrayList2=new ArrayList<>();
		
		//inboxing. trasformo una variabile in un oggetto.numObj è un puntatore alla variabile num. Outboxing tira fuori l'intero dall'oggetto
		int num=10;
		Integer numObj=num;
		
		
		arrayList2.add(2);
		arrayList2.add(22);
		arrayList2.add(222);
		
		//tiro fuori l'oggetto e lo associo a numIndex
		int numIndex= arrayList2.get(0);
		
		//dimensione
		arrayList2.size();
		
		
		// foreach è ideale per scansionare gli elementi di una lista di cui non conosco la dim
		for (Integer a: arrayList2) {
			
			System.out.println(a);
		}
		
		
		
		
		
		
	}

	
	
}
