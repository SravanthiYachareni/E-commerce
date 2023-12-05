package com.sravs.ecommerce.graphql.repositories;

import com.sravs.ecommerce.graphql.entity.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findAll(Specification<EmployeeEntity> spec);

    Page<EmployeeEntity> findAll(Pageable pageable);

    List<EmployeeEntity> findAllByPid(String pid);

}
