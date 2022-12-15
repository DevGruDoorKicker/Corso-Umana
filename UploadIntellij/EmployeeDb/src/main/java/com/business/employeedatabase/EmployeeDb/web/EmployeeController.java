package com.business.employeedatabase.EmployeeDb.web;

import com.business.employeedatabase.EmployeeDb.domain.Employee;
import com.business.employeedatabase.EmployeeDb.domain.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/*
 Implementare un servizio web attraverso l'utilizzo di Spring Boot che permetta la gestione di Employee.
Utilizzare
https://start.spring.io

 per la generazione dell'applicazione di base.
Aggiungere le seguenti dipendenze:

	Web
	JPA
	H2

Employee.java


	Long id;
  	String name;
  	String role;

Employee è un'entità.
L'id deve essere auto generato.

Due Employee sono lo stesso se hanno lo stesso id/role/name. Implementare anche il metodo hashCode() utilizzando Objects.hash(id,name,role).
Implementare inoltre la stampa leggibile di un Employee.

Implementare le funzionalità di:

- Create
- Update
- Delete
- Find

di Employees attraverso l'ereditarietà da JpaRepository.

interface EmployeeRepository extends JpaRepository..
..

Permettere il pre-load in H2 database di alcuni Employee d'esempio.

Implementare EmployeeController (controller - C di MVC) attraverso la seguente traccia. Studiare le annotazioni utilizzate. Prevedere la constructor injection del repository.

NOTA1: Metodo one. Sollevare l'exception di EmployeeNotFoundException in caso di id non esistente.
NOTA2: Metodo replaceEmployee. Inserire l'Employee in caso di Employee non esistente.

..
class EmployeeController {

  @GetMapping("/employees")
  List<Employee> all() {
  	// metodo findAll() di repository
  }

  @PostMapping("/employees")
  Employee newEmployee(@RequestBody Employee newEmployee) {
    // metodo save() di repository
  }

  @GetMapping("/employees/{id}")
  Employee one(@PathVariable Long id) {
    // metodo findById() di repository
  }

  @PutMapping("/employees/{id}")
  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

   // metodo findById() di repository + metodo save di repository
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
	// metodo deleteById() di repository
  }
}

Dichiarare l'exception EmployeeNotFoundException come RuntimeException. Il costruttore deve prevedere l'id di Employee non trovato.
Costruire un messaggio dal mandare alla super() utilizzando l'id non trovato.

Aggiungere al progetto la seguente. Descrivere il ruolo della classe in relazione al metodo di segnalazione degli errori in ambito HTTP.

@ControllerAdvice
class EmployeeNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(EmployeeNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String employeeNotFoundHandler(EmployeeNotFoundException ex) {
    return ex.getMessage();
  }
}

Testare il servizio web utilizzando
 */



@RestController
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee newEmployee(@RequestBody Employee newEmployee) {

    return employeeRepository.save(newEmployee);
    }

    @GetMapping("/employees/{id}")
    public Employee one(@PathVariable Long id) throws EmployeeNotFoundAdvice {


        if (employeeRepository.findById(id)==null)
            throw new EmployeeNotFoundAdvice();

        return employeeRepository.findById(id).get();
    }

    @PutMapping("/employees/{id}")
    public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id)  {

        if (id==null)
            return null;

        employeeRepository.findById(id).get().setNome(newEmployee.getNome());
        employeeRepository.findById(id).get().setRole(newEmployee.getRole());

        Employee tmpEmployee=null;

        tmpEmployee.setRole(newEmployee.getRole());
        tmpEmployee.setNome(newEmployee.getNome());
        tmpEmployee.setId(id);

        employeeRepository.save(tmpEmployee);
        //employeeRepository.save(employeeRepository.findById(id).get()).setRole(newEmployee.getRole());


        return  newEmployee;
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }

}
