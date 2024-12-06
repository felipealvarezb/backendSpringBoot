package com.felipealvarez.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipealvarez.backend.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

  //List<Product> findTopProductByStock_FranchiseId(Long franchiseId);
}
