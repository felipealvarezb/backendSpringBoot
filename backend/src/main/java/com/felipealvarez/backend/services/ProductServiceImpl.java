package com.felipealvarez.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.felipealvarez.backend.domain.Branch;
import com.felipealvarez.backend.domain.Product;
import com.felipealvarez.backend.repository.BranchRepository;
import com.felipealvarez.backend.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

  @Autowired private ProductRepository productRepository;
  @Autowired private BranchRepository branchRepository;

  @Override
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  public Product save(Product entity) throws Exception{
    log.info("saving Product instance");

    if (entity == null) {
      throw new Exception("Entity not found");
    }

    if (entity.getBranch() == null || entity.getBranch().getId() == null) {
      throw new Exception("Branch ID is required");
    }

    Branch branch = branchRepository.findById(entity.getBranch().getId())
        .orElseThrow(() -> new Exception("Branch not found"));

    entity.setBranch(branch);

    return productRepository.save(entity);
  }

  @Override
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  public Product update(Product entity) throws Exception{
    log.info("updating Product instance");

    if (entity == null) {
      throw new Exception("Entity not found");
    }

    if (!productRepository.existsById(entity.getId())) {
      throw new Exception("Entity not found with that key");
    }

    return productRepository.save(entity);
  }

  @Override
  public List<Product> getTopProductsByStockForFranchise(Long franchiseId) throws Exception {
    if (franchiseId == null) {
      throw new Exception("Franchise ID cannot be null");
    }

    return productRepository.getTopProductsByStockForFranchise(franchiseId);
  }

  public void delete(Product entity) throws Exception{
    log.info("deleting Product instance");

    if (entity == null) {
      throw new Exception("Entity not found");
    }

    if (entity.getId() == null) {
      throw new Exception("Product Id is empty");
    }

    if (!productRepository.existsById(entity.getId())) {
      throw new Exception("Entity with id: " + entity.getId() + " not found");
    }

    productRepository.deleteById(entity.getId());
    log.info("delete Product successful");
  }
}
