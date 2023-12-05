package com.sravs.ecommerce.graphql.repositories;

import com.sravs.ecommerce.graphql.entity.EmployeeEntity;
import com.sravs.ecommerce.graphql.model.EmployeeInput;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public final class EmployeeSpecification {

    public static Specification<EmployeeEntity> filterEmployees(EmployeeInput filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Add conditions based on the fields in the EmployeeInput object
            if (filter.getFirstName() != null) {
                predicates.add(criteriaBuilder.equal(root.get("firstName"), filter.getFirstName()));
            }
            if (filter.getLastName() != null) {
                predicates.add(criteriaBuilder.equal(root.get("lastName"), filter.getLastName()));
            }
            if (filter.getEmail() != null) {
                predicates.add(criteriaBuilder.equal(root.get("email"), filter.getEmail()));
            }
            if (filter.getId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), filter.getId()));
            }
            if (filter.getPid() != null) {
                predicates.add(criteriaBuilder.equal(root.get("pid"), filter.getPid()));
            }
            if (filter.getRegion() != null) {
                predicates.add(criteriaBuilder.equal(root.get("region"), filter.getRegion()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

