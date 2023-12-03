package com.sravs.ecommerce.graphql.controller;

import com.sravs.ecommerce.graphql.model.Employee;
import com.sravs.ecommerce.graphql.model.EmployeeInput;
import com.sravs.ecommerce.graphql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @QueryMapping
    public List<Employee> findEmployees(@Argument EmployeeInput input) {
        return employeeService.findEmployeesByFilter(input);
    }
}

