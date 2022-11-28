package exercQuartoGiorno;
import exercQuartoGiorno.Employee.Project;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee employee=new Employee(2, "roberto", 23, 4);
		
		employee.addProj();
		employee.addProj();
		employee.addProj();
		employee.addProj();
		employee.addProj();
		
		

		
		
		employee.stampa();
		
		Project project= new Project(4, 3, "test15");
		
		System.out.println(employee.removeProj(project));
		
		employee.stampa();
		
		System.out.println(employee.removeProj(null));
		
	}

}
