package com.business.employeedatabase.EmployeeDb.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;


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








@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;
    private String role;


    public Employee(){
    }

    public Employee(String nome, String role) {
        this.nome = nome;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,nome,role);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && nome.equals(employee.nome) && role.equals(employee.role);
    }






}
