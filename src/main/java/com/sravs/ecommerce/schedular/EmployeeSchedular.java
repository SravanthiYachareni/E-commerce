package com.sravs.ecommerce.schedular;

import com.sravs.ecommerce.graphql.entity.EmployeeEntity;
import com.sravs.ecommerce.graphql.model.Employee;
import com.sravs.ecommerce.graphql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeSchedular {

   @Autowired
    EmployeeService employeeService;

}
