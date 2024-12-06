package com.felipealvarez.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.felipealvarez.backend.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

  @Query("SELECT p FROM Product p WHERE p.branch.franchise.id = :franchiseId " +
    "AND p.stock = (SELECT MAX(p2.stock) FROM Product p2 WHERE p2.branch.id = p.branch.id)")
  List<Product> getTopProductsByStockForFranchise(@Param("franchiseId") Long franchiseId);
}
