// This code includes the implementation of the CompanyService interface under the com.company.crud.service package.
// The CompanyServiceImpl class is responsible for CRUD (Create, Read, Update, Delete) operations using the CompanyRepository
// and provides the business logic as part of the Spring framework.

package com.company.crud.service;

import com.company.crud.dao.CompanyRepository;
import com.company.crud.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// The @Service annotation indicates that this class is a Spring-managed service.
@Service
public class CompanyServiceImpl implements CompanyService {

    // An instance of the CompanyRepository class will be used within this class.
    private CompanyRepository companyRepository;

    // The CompanyRepository instance is injected into this class using constructor-based dependency injection.
    @Autowired
    public CompanyServiceImpl(CompanyRepository theCompanyRepository) {
        companyRepository = theCompanyRepository;
    }

    // Implements the findAll method from the CompanyService interface.
    @Override
    public List<Company> findAll() {
        // The findAll method calls the findAll method of companyRepository to retrieve all companies
        // and returns this list.
        return companyRepository.findAll();
    }

}
