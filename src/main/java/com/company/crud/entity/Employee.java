// This code defines an entity class, Employee, under the com.company.crud.entity package.
// The @Entity annotation indicates that instances of this class will be entities and can be managed by JPA.
// The @Table annotation specifies the name of the database table to which this entity is mapped.

package com.company.crud.entity;

import jakarta.persistence.*;

// Employee entity represents the "employee" table in the database.
@Entity
@Table(name="employee")
public class Employee {

    // Fields representing columns in the "employee" table.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="company_id")
    private int companyId;

    // Constructors

    // Default constructor required by JPA.
    public Employee() {
    }

    // Parameterized constructor for creating instances of the Employee class with specified values.
    public Employee(String firstName, String lastName, String email, Integer companyId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.companyId = companyId;
    }

    // Getter and setter methods for accessing and modifying private fields.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
