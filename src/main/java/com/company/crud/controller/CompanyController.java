// This code defines a controller class, CompanyController, under the com.company.crud.controller package.
// The controller is responsible for handling HTTP requests related to Company entities.

package com.company.crud.controller;

import com.company.crud.entity.Company;
import com.company.crud.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

// The @Controller annotation indicates that this class is a Spring MVC controller.
// The @RequestMapping("/companies") annotation maps the "/companies" URL pattern to this controller.
@Controller
@RequestMapping("/companies")
public class CompanyController {

    // The CompanyService instance will be injected into this class using constructor-based dependency injection.
    private CompanyService companyService;

    @Autowired
    // Constructor with Autowired annotation to inject the CompanyService dependency.
    public CompanyController(CompanyService theCompanyService) {
        this.companyService = theCompanyService;
    }

    // Maps the "/companies/list" URL pattern to the listCompanies method.
    @GetMapping("/list")
    public String listCompanies(Model theModel) {
        // Get the list of companies from the database using the CompanyService.
        List<Company> theCompanies = companyService.findAll();

        // Add the list of companies to the Spring model.
        theModel.addAttribute("companies", theCompanies);

        // Return the name of the view template to render, which is "companies/list-companies".
        return "companies/list-companies";
    }
}
