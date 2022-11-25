package exerc;

import java.awt.Container;

import javax.swing.text.StyledEditorKit.ForegroundAction;

//Implementare la seguente struttura object oriented garantendo l'assegnazione di un Employee ad un massimo
//di 3 Project simultanei a cui un Employee può essere associato.
//
//"has-a" "is-a"
//
//	Employee
//		id
//		name
//		age
//		addProjToEmp 		(method)
//		printProjs			(method)
//
//	Project
//		id
//		prjname
//		budget
//
//Test dal main
//
//	1. Creazione Projects
//	2. Creazione di Employee
//	3. Associazione tra Employee e alcuni Projects
//	4. Stampa in printProjs Employee human-readable di Employee (id, name) + Projects (prjname, budget)
//
//

public class Employee2 {

	
	int id;
	String name;
	int age;
	Project[] project=new Project[3]; //non metto questo come attributo per comodità di non avere array vuoti nel niente se non ho progetti da dare
	private int internalId; // è private perché non deve essere modificata dal main altrimenti
	
	
	
	public Employee2(int id, String name, int age) {

		this.id = id;
		this.name = name;
		this.age = age;
		
		
	}
	


	public void addProjToEmp(Project project) {
		 
			if (internalId<3) {
				
				this.project[internalId++]=new Project(23, "test", 2000f);
			}	
			
			if (internalId==3) {
				return;
			};
		
	}
	
	public void printProj() {
		
			
		 // this è usato come rappresentazione della classe Employee2 in questo caso
		
		for (int i = 0; i < internalId; i++) {
			
			System.out.println(project[i].proName+ " " + project[i].id + " " +project[i].budget);
		}
		
		
	}
	
	
	
	

	static class Project{
		int id;
		String proName;
		float budget;
		
		
		public Project(int id, String proName, float budget) {

			this.id = id;
			this.proName = proName;
			this.budget = budget;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		Employee2 employee2=new Employee2(23, "Alessandro", 29);
		
		Project project1=new Project(23, "test", 2000);
		Project project2=new Project(24, "lmao", 20003);
		Project project3=new Project(25, "pover", 20002);
		
			
		employee2.addProjToEmp(project1);
		employee2.addProjToEmp(project2);
		employee2.addProjToEmp(project3);
		
		employee2.printProj();
			
		
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
}
