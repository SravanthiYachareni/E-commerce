package com.sravs.ecommerce.repository;

import com.sravs.ecommerce.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TokenRepo extends JpaRepository<AuthenticationToken, Integer> {
}
