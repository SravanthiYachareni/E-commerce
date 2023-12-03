package com.sravs.ecommerce.graphql.service;

import com.sravs.ecommerce.graphql.entity.EmployeeEntity;
import com.sravs.ecommerce.graphql.model.Employee;
import com.sravs.ecommerce.graphql.model.EmployeeInput;
import com.sravs.ecommerce.graphql.repositories.EmployeeRepository;
import com.sravs.ecommerce.graphql.repositories.EmployeeSpecification;
import com.sravs.ecommerce.graphql.transformer.EmployeeTransformer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

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

        employeeRepository.save(employee);
        employeeRepository.save(employee1);
    }

    public List<Employee> findEmployeesByFilter(EmployeeInput filter) {
        Specification<EmployeeEntity> entitySpecification = EmployeeSpecification.filterEmployees(filter);
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll(entitySpecification);
        return EmployeeTransformer.transformToEmployee(employeeEntities);
    }
}

