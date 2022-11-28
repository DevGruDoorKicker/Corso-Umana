package exercQuartoGiorno;

import java.util.ArrayList;


//7. Effettuare un refactor del codice precedente, prevedendo la possibilità di 
//assegnazione di un numero illimitato di Projects per ciascun Employee. Rivedere di conseguenza le implementazioni dei metodi addProjToEmp e printProjs.
//
//Aggiungere inoltre la possibilità di rimuovere Project da un Employee attraverso il metodo seguente:
//
//	boolean removeProjFromEmp(Project p) {
//		..
//	}
//
//Il metodo dovrebbe restituire il valore true in caso di rimozione 
//con successo e false in caso contrario (ex: tentativo di rimozione di un Project non associato a quel Employee). 














public class Employee {

	

	int id;
	String name;
	int age;
	ArrayList<Project> projects=new ArrayList<>(); ; //non metto questo come attributo per comodità di non avere array vuoti nel niente se non ho progetti da dare
	private int internalId; // è private perché non deve essere modificata dal main altrimenti

	
	
	
	public Employee(int id, String name, int age, int internalId) {
		
		this.id = id;
		this.name = name;
		this.age = age;
		this.internalId = internalId;
	}


	public void addProj() {
		
		projects.add(new Project(internalId++, 3, "test1"+internalId));
		
	}

	public boolean removeProj(Project project) {
		
		if (project==null) {	
			
			return false;
		}
			
		projects.remove(project);
		return true;
	}

	public void stampa() {
					
		for (Project p : projects) {
			
			System.out.print(p.id);
			System.out.print(" ");
			System.out.print(p.budget);
			System.out.print(" ");
			System.out.print(p.proName);
			System.out.print(" ");
		}
	}






	static class Project{
		
		private int id;
		private int budget;
		private String proName;
		
		public Project(int id, int budget, String proName) {
			
			this.id = id;
			this.budget = budget;
			this.proName = proName;
		}
		
		
		@Override                             
		public boolean equals(Object obj) {
			
			
			if (obj==null) {				// posso inserire la logica qui a monte anziché nel remove (a valle)
				return false;
			}
			
			if (!(obj instanceof Project)) { // se l'oggetto non è di tipo project ritorno falso
				return false;
			}
			
			
			Project project = (Project) obj;
													
			return this.id==project.id;	
	}

		
		
	}
}
