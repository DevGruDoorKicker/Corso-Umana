package com.business.employeedatabase.EmployeeDb.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository  extends JpaRepository <Employee, Long> {

/*
        List<Employee> create(Employee employee);
        void delete(Employee employee);
        List<Employee> update(Employee employee);
        List<Employee> findAllById(Employee employee);
*/

}
