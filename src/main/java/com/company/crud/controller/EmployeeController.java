// This code defines a controller class, EmployeeController, under the com.company.crud.controller package.
// The controller is responsible for handling HTTP requests related to Employee entities.

package com.company.crud.controller;

import com.company.crud.entity.Employee;
import com.company.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

// The @Controller annotation indicates that this class is a Spring MVC controller.
// The @RequestMapping("/employees") annotation maps the "/employees" URL pattern to this controller.
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // The EmployeeService instance will be injected into this class using constructor-based dependency injection.
    private EmployeeService employeeService;

    @Autowired
    // Constructor with Autowired annotation to inject the EmployeeService dependency.
    public EmployeeController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    // Maps the "/employees/list" URL pattern to the listEmployees method.
    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // Gets the list of employees from the database.
        List<Employee> theEmployees = employeeService.findAll();

        // Adds the list of employees to the Spring model.
        theModel.addAttribute("employees", theEmployees);

        // Returns the name of the view template to render, which is "employees/list-employees".
        return "employees/list-employees";
    }

    // Maps the "/employees/showFormForAdd" URL pattern to the showFormForAdd method.
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // Creates a model attribute to bind form data.
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        // Returns the name of the view template to render, which is "employees/employee-form".
        return "employees/employee-form";
    }

    // Maps the "/employees/showFormForUpdate" URL pattern to the showFormForUpdate method.
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){

        // Gets the employee from the service based on the provided employeeId.
        Employee theEmployee = employeeService.findById(theId);

        // Sets the employee in the model to prepopulate the form.
        theModel.addAttribute("employee", theEmployee);

        // Returns the name of the view template to render, which is "employees/employee-form".
        return "employees/employee-form";
    }

    // Maps the "/employees/save" URL pattern to the saveEmployee method.
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee, RedirectAttributes redirectAttributes){

        // Saves the employee using the EmployeeService.
        employeeService.save(theEmployee);

        // Creates a success message for the saved employee.
        String message = theEmployee.getFirstName() + " " + theEmployee.getLastName() + " saved successfully.";

        // Adds the success message to redirect attributes.
        redirectAttributes.addFlashAttribute("message", message);

        // Uses a redirect to prevent duplicate form submissions.
        return "redirect:/employees/list";
    }

    // Maps the "/employees/delete" URL pattern to the delete method.
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId, RedirectAttributes redirectAttributes){

        // Gets the deleted employee information.
        Employee deletedEmployee = employeeService.findById(theId);

        // Creates a confirmation message.
        String message = deletedEmployee.getFirstName() + " " + deletedEmployee.getLastName() + " başarıyla silindi.";

        // Deletes the employee using the EmployeeService.
        employeeService.deleteById(theId);

        // Adds the confirmation message to redirect attributes.
        redirectAttributes.addFlashAttribute("message", message);

        // Uses a redirect to prevent duplicate form submissions.
        return "redirect:/employees/list";
    }
}
