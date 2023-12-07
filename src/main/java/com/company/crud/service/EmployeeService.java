// This code defines a service interface, EmployeeService, under the com.company.crud.service package.
// The interface declares methods for performing CRUD operations on Employee entities.

package com.company.crud.service;

import com.company.crud.entity.Employee;

import java.util.List;

// EmployeeService is an interface that declares methods for CRUD operations on Employee entities.
public interface EmployeeService {

    // Retrieves a list of all employees.
    List<Employee> findAll();

    // Retrieves an employee by their ID.
    Employee findById(int theId);

    // Saves or updates an employee.
    Employee save(Employee theEmployee);

    // Deletes an employee by their ID.
    void deleteById(int theId);

}
