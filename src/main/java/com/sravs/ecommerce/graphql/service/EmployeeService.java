package com.sravs.ecommerce.graphql.service;

import com.sravs.ecommerce.graphql.entity.EmployeeEntity;
import com.sravs.ecommerce.graphql.exception.InvalidInputException;
import com.sravs.ecommerce.graphql.model.Employee;
import com.sravs.ecommerce.graphql.model.EmployeeInput;
import com.sravs.ecommerce.graphql.repositories.EmployeeRepository;
import com.sravs.ecommerce.graphql.repositories.EmployeeSpecification;
import com.sravs.ecommerce.graphql.transformer.EmployeeTransformer;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    public void initSQL() { // Testing purpose only
        EmployeeEntity employee = new EmployeeEntity();
        employee.setFirstName("Krishna");
        employee.setLastName("Yachareni");
        employee.setEmail("k@gmail.com");
        employee.setRegion("US");
        employee.setEidosEnabled(true);
        employee.setDesk("Desk");
        employee.setPid("PID1");
        employee.setXid("XID");

        EmployeeEntity employee1 = new EmployeeEntity();
        employee1.setFirstName("Sravanthi");
        employee1.setLastName("Yac");
        employee1.setEmail("s@gmail.com");
        employee1.setRegion("US");
        employee1.setEidosEnabled(false);
        employee1.setDesk("Desk1");
        employee1.setPid("PID2");
        employee1.setXid("XID2");

        EmployeeEntity employee2 = new EmployeeEntity();
        employee2.setFirstName("Joe");
        employee2.setLastName("J");
        employee2.setEmail("j@gmail.com");
        employee2.setRegion("UK");
        employee2.setEidosEnabled(true);
        employee2.setDesk("Desk1");
        employee2.setPid("PID2");
        employee2.setXid("XID2");

        EmployeeEntity employee3 = new EmployeeEntity();
        employee3.setFirstName("Lizzie");
        employee3.setLastName("L");
        employee3.setEmail("l@gmail.com");
        employee3.setRegion("US");
        employee3.setEidosEnabled(false);
        employee3.setDesk("Desk1");
        employee3.setPid("PID2");
        employee3.setXid("XID2");

        employeeRepository.save(employee);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
    }

    public List<Employee> findEmployeesByFilter(EmployeeInput filter) {
        log.info("fetching the employee object by filtering");
        Specification<EmployeeEntity> entitySpecification = EmployeeSpecification.filterEmployees(filter);
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll(entitySpecification);
        return EmployeeTransformer.transformToEmployee(employeeEntities);
    }

    public List<Employee> getAll(int page, int size) {
        if (size == 0) {
            throw new InvalidInputException("Page size must not be less than one");
        }
        log.info("Fetching the employee object with page number");
        Pageable pageable = PageRequest.of(page, size);
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll(pageable).getContent();
        return EmployeeTransformer.transformToEmployee(employeeEntities);
    }
    public  List<Employee> getAllByPid(String pid) {
        if(pid ==null || pid.isEmpty()){
            throw new InvalidInputException(("Pid cannot be empty"));
        }
        log.info("Fetching the employee object By pid");
        List<EmployeeEntity> employeeEntities=employeeRepository.findAllByPid(pid);
        return EmployeeTransformer.transformToEmployee(employeeEntities);
    }
}

