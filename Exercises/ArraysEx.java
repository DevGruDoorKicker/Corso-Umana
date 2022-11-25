package exerc;

import java.lang.reflect.Array;
import java.util.Scanner;

public class ArraysEx {
	
	
//	. A partire da una classe Utility, fornire 2 implementazioni di un metodo che calcoli e 
//	restituisca la media di un insieme di valori interi passati in input. Il numero di valori non è conosciuto in fase di compilazione.
//
//	Utility class
//
//		.. avg1 (..)
//		.. avg2 (..)
//
//	Riflettere sulla possibilità di utilizzare l'overload dei metodi. 
//	
	
	
	
// una l'ho fatta ma quella con varargs	ho avuto difficoltà
	
	
	
	
	
	
	static class Utility{
		
		float conta=0;
			
		public float avg(int[] array) {
			
			for (int i = 0; i < array.length; i++) {
				
				conta+=array[i];
				
			}
			
			float avg=(float) conta/array.length;
			return avg;
			
		}
					
	
	
	
	public float avg2(int... array) { // alternativa alla chiamata del vettore "flessibile"
		
		for (int i = 0; i < 2; i++) {
			array[i]=2;
			
		}	
				
		for (int i = 0; i < array.length; i++) {
			
			conta+=array[i];
			
		}
		
		float avg=(float) conta/array.length;
		return avg;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// esercizio mio senza consegna
	public float avg(int num) {
		
		int [] array=new int[num];
		
		
		for (int i = 0; i < 2; i++) {
			array[i]=2;
			
		}	
		
		for (int i = 0; i < array.length; i++) {
			
			conta+=array[i];
			
		}
		
		float avg=(float) conta/array.length;
		return avg;
		
	}

	
				
}
	

	static Utility array2=new Utility();
	
	public static void main(String[] args) {
		
		Scanner key=new Scanner(System.in);
		
		int dim=key.nextInt();
		
		int [] array=new int[dim];
		
		for (int i = 0; i < array.length; i++) {
			array[i]=1;
			
		}		
		
		
		
		System.out.println(array2.avg(array));		
		
		System.out.println(array2.avg2(array));	
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	


}
