// This code defines a service class, EmployeeServiceImpl, under the com.company.crud.service package.
// The class implements the EmployeeService interface and provides implementations for CRUD operations on Employee entities.

package com.company.crud.service;

import com.company.crud.dao.EmployeeRepository;
import com.company.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// The @Service annotation indicates that this class is a Spring service component.
@Service
public class EmployeeServiceImpl implements EmployeeService {

    // The EmployeeRepository instance will be injected into this class using constructor-based dependency injection.
    private EmployeeRepository employeeRepository;

    @Autowired
    // Constructor with Autowired annotation to inject the EmployeeRepository dependency.
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    // Implements the findAll method to retrieve a list of all employees sorted by first name.
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByFirstNameAsc();
    }

    // Implements the findById method to retrieve an employee by their ID.
    @Override
    public Employee findById(int theId) {
        // Finds the employee by ID using the findById method provided by JpaRepository.
        Optional<Employee> result = employeeRepository.findById(theId);

        // Checks if the employee is present in the Optional result.
        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            // Throws a runtime exception if the employee with the specified ID is not found.
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    // Implements the save method to save or update an employee.
    @Override
    public Employee save(Employee theEmployee) {
        // Saves or updates the employee using the save method provided by JpaRepository.
        return employeeRepository.save(theEmployee);
    }

    // Implements the deleteById method to delete an employee by their ID.
    @Override
    public void deleteById(int theId) {
        // Deletes the employee by ID using the deleteById method provided by JpaRepository.
        employeeRepository.deleteById(theId);
    }
}
