package com.felipealvarez.backend.services;

import java.util.List;

import com.felipealvarez.backend.domain.Product;

public interface ProductService extends GenericService<Product, Long>{

  List<Product> getTopProductsByStockForFranchise(Long franchiseId) throws Exception;
}
