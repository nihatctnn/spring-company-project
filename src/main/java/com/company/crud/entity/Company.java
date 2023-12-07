// This code defines an entity class, Company, under the com.company.crud.entity package.
// The @Entity annotation indicates that instances of this class will be entities and can be managed by JPA.
// The @Table annotation specifies the name of the database table to which this entity is mapped.

package com.company.crud.entity;

import jakarta.persistence.*;

@Entity
@Table(name="company")
public class Company {

    // The @Id annotation indicates the primary key field of the entity.
    // The @GeneratedValue annotation specifies the generation strategy for the primary key.
    // In this case, GenerationType.IDENTITY means that the database will automatically generate the primary key.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="company_id")
    private int companyId;

    private String companyName;

    // Constructors

    // Default constructor required by JPA.
    public Company() {
    }

    // Parameterized constructor for creating instances of the Company class with specified values.
    public Company(int companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
    }

    // Getter and setter methods for accessing and modifying private fields.

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
