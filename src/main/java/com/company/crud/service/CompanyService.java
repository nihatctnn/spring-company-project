// This code defines an interface, CompanyService, under the com.company.crud.service package.
// The interface declares methods for handling CRUD (Create, Read, Update, Delete) operations related to Company entities.

package com.company.crud.service;
import com.company.crud.entity.Company;
import java.util.List;

// The CompanyService interface declares methods for interacting with Company entities.
public interface CompanyService {

    // Declares a method to retrieve a list of all companies.
    List<Company> findAll();
}