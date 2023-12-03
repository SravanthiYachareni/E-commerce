package com.sravs.ecommerce.graphql.transformer;

import com.sravs.ecommerce.graphql.entity.EmployeeEntity;
import com.sravs.ecommerce.graphql.model.Employee;

import java.util.ArrayList;
import java.util.List;

public final class EmployeeTransformer {

    public static List<Employee> transformToEmployee(List<EmployeeEntity> employeeEntities) {
        List<Employee> employeeList = new ArrayList<>();
        employeeEntities.forEach(i -> {
            Employee employee = Employee.builder()
                    .id(String.valueOf(i.getId()))
                    .firstName(i.getFirstName()).lastName(i.getLastName())
                    .desk(i.getDesk()).pid(i.getPid())
                    .email(i.getEmail()).xid(i.getXid())
                    .region(i.getRegion()).eidosEnabled(i.isEidosEnabled())
//                    .eidosGroup(i.getEidosGroup()).eidosTeam(i.getEidosTeam())
//                    .peregineRole(i.getPeregineRole()).peregineRole(i.getPeregineRole())
                    .build();
            employeeList.add(employee);
        });
        return employeeList;
    }
}
