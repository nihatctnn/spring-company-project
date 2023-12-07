// This code defines a repository interface, CompanyRepository, under the com.company.crud.dao package.
// The interface extends JpaRepository, provided by Spring Data JPA, and specifies Company entity and its primary key type.

package com.company.crud.dao;

import com.company.crud.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// CompanyRepository extends JpaRepository, providing CRUD functionality for the Company entity.
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    // This method declaration is not necessary, as JpaRepository already provides the findAll method.
    // However, it is here to illustrate that custom query methods can be added to the repository.
    public List<Company> findAll();
}
