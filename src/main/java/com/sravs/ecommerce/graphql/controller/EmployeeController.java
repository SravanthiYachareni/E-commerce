package com.sravs.ecommerce.graphql.controller;

import com.sravs.ecommerce.graphql.model.Employee;
import com.sravs.ecommerce.graphql.model.EmployeeInput;
import com.sravs.ecommerce.graphql.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Slf4j
@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @QueryMapping
    public List<Employee> findEmployees(@Argument EmployeeInput input) {
        log.info("EmployeeInput request has been received");
        return employeeService.findEmployeesByFilter(input);
    }

    @QueryMapping
    public List<Employee> findEmployeesByPaging(@Argument int page, @Argument int size) {
        log.info("findEmployeesByPaging has been called with page number "+page+ " and size" + " " +size);
        return employeeService.getAll(page, size);
    }

    @QueryMapping
    public List<Employee> findEmployeesByPid(@Argument String pid) {
        log.info("findEmployeesByPid has been called by " + pid );
        return employeeService.getAllByPid(pid);
    }
}