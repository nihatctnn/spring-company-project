// This code defines a repository interface, EmployeeRepository, under the com.company.crud.dao package.
// The interface extends JpaRepository, provided by Spring Data JPA, and specifies Employee entity and its primary key type.

package com.company.crud.dao;

import com.company.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// EmployeeRepository extends JpaRepository, providing CRUD functionality for the Employee entity.
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Defines a custom query method to find all employees and order them by first name in ascending order.
    public List<Employee> findAllByOrderByFirstNameAsc();
}
