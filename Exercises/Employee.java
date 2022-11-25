package exerc;

import java.lang.reflect.Array;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Employee {

//testo
	
	
//	//A partire da un array di Employee pre-popolato, calcolare la somma dei salari che un'azienda deve sborsare
//	a fine mese. Il calcolo del salario del singolo Employee è pagah*numh.
//
//	Employee 
//		id
//		numh
//		pagah
//
//main
//
//	Sum: ___ 
	
	
	private int id;
	private int numh;
	private int pagah;
	
	
	public float stipendio(Employee employee) {
		
		return (float)employee.getPagah()*employee.getNumh();
		
	}
	
	float somma=0;
	
	public float sum(Employee[] array) {
		
		
		for (int i = 0; i < array.length; i++) {
			
			//somma+=array[i].getNumh()*array[i].getPagah(); stessa roba
			somma+=array[i].stipendio(array[i]);
		}
		
		return somma;
	}
	
	
	
	public Employee(int id, int numh, int pagah) {
		
		this.id = id;
		this.numh = numh;
		this.pagah = pagah;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumh() {
		return numh;
	}

	public void setNumh(int numh) {
		this.numh = numh;
	}

	public int getPagah() {
		return pagah;
	}

	public void setPagah(int pagah) {
		this.pagah = pagah;
	}
	
	public static void main(String[] args) {
		
		
		Employee [] array=new Employee[3];
		
		array[0]=new Employee(23, 8, 1500);;
		array[1]=new Employee(24, 10, 1800);
		array[2]= new Employee(25,12, 1900);
		
		//System.out.println(array[0].getPagah()*array[0].getNumh());
		
		
		System.out.println(array[0].stipendio(array[0]));
		
		//alternativa nominando le variabili
		
		Employee employee=new Employee(12, 21, 1200);
		Employee employee2=new Employee(15, 123, 1200);
		Employee employee3=new Employee(17, 322, 1200);
		
		System.out.println(employee.getNumh()*employee.getPagah());
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
