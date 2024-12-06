package com.felipealvarez.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipealvarez.backend.domain.Product;
import com.felipealvarez.backend.dto.ProductDTO;
import com.felipealvarez.backend.mappers.ProductMapper;
import com.felipealvarez.backend.services.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/product")
@Slf4j
public class ProductRestController {
  
  @Autowired private ProductService productService;
  @Autowired private ProductMapper productMapper;

  @PostMapping()
  public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) throws Exception{
    try {
      log.info("Request to save Product: {}", productDTO);
    
      Product product = productMapper.productDTOToProduct(productDTO);
      product = productService.save(product);
      return ResponseEntity.ok().body(productMapper.productToProductDTO(product));
    } catch (Exception e) {
      log.error("Error saving product: {}", e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @PutMapping()
  public ResponseEntity<?> update(@RequestBody ProductDTO productDTO) throws Exception{
    try {
      log.info("Request to update Product: {}", productDTO);
    
      Product product = productMapper.productDTOToProduct(productDTO);
      product = productService.save(product);
      return ResponseEntity.ok().body(productMapper.productToProductDTO(product));
    } catch (Exception e) {
      log.error("Error updating product: {}", e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @GetMapping("/top-products/{franchiseId}")
  public ResponseEntity<?> getTopProductsByStock(@PathVariable Long franchiseId) {
    try {
      log.info("Request to get top products by stock for franchise: {}", franchiseId);
      List<Product> topProducts = productService.getTopProductsByStockForFranchise(franchiseId);
      return ResponseEntity.ok().body(topProducts);
    } catch (Exception e) {
      log.error("Error getting top products by stock: {}", e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }


}
