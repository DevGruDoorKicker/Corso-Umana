package elementiMultidimensionali;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Arrays {


	static void arrayInput(int[]array) {
		
		for (int i = 0; i < array.length; i++) {
			
			array[i]=1;
			
		}
	}

	
	
	
	

	
	
	
	
	
	
	// gli array non hanno limiti dimensionali a meno che non siano già stati creati
	
	
	int array[]=new int[10]; //gli array sono puntatori ed allora vogliono il new
	int array2[]=new int[] {1,2,3,4,5}; //array di dim implicitamente definita
	int array3[]={1,2,3,4,5};
	
	// le quadre possono andare o dopo il tipo di variabile o dopo la variabile stessa
	
	//attenzione però. queste due cose sono diverse
	int[] aa, bb; 
	int aa1;
	int bb2[];
	
	// gli array possone essere eterogenei/omogenei e possono essere collezioni di diversi oggetti
	// gl array non possono avere indici "out of bound"
	
	
	
	public static void main(String[] args) {
		
		
		
		
		
		
		
		System.out.println("################");
				
		int array[]=new int[10];
			
		for (int i = 0; i < array.length; i++) { //stampo gli elementi del vettore
			
			System.out.println(array[i]);
			
		}
		
		
		System.out.println("################");
		
		//matrici. poca applicazione
		
		int[] [] matrice=new int[10][10];
		
		int[] [] matrice2={ {1,2} ,{3,4}};
		
		for (int i = 0; i < matrice2.length; i++) { //stampo gli elementi della matrice
			
			for (int j = 0; j < matrice2.length; j++) {
				System.out.println(matrice2[i][j]);
				
			}
		}
		
		System.out.println("################");
		//array sparso. a scopo conoscitivo
	
		String multi[][]=new String [][] {
			
			{"a","b"}, {"c"} , {"a","b","c"}//righe    
			};
			
			
		//ho commentato fuori perché dava errore e non penso che sia troppo importante	
			
//		for (int i = 0; i < multi.length; i++) { //stampo gli elementi della matrice sparsa
//			
//			for (int j = 0; j < multi[i].length; j++) {  // stampo gli elementi, colonne dell'elemento i-esimo
//				System.out.println(matrice2[i][j]);				
//			}
//		}
		
		// da tastiera la dimensione dell'array
		
		Scanner key=new Scanner(System.in); //attenzione a 	key.close(); per chiudere
	
		int input=key.nextInt();
		
		int [] array2=new int[input]; //poi posso stampare
		
		
		System.out.println("################");
		
		// passare array a metodi. I METODI LI CREO SEMPRE AL TOP DELLA CLASSE
	
			arrayInput(array2); // applico la funzione che modifica il valore ad 1 del vettore input-dimensionale appena creato
		
			System.out.println(array2[2]);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
