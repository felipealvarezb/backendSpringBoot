package com.felipealvarez.backend.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.felipealvarez.backend.domain.Branch;
import com.felipealvarez.backend.domain.Franchise;
import com.felipealvarez.backend.domain.Product;
import com.felipealvarez.backend.dto.BranchDTO;

@Mapper(componentModel = "spring")
public interface BranchMapper {

  @Mapping(source = "franchise.id", target = "franchiseId")
  @Mapping(source = "products", target = "productIds")
  public BranchDTO branchToBranchDTO(Branch branch);

  // Método default para convertir productos -> IDs
  default List<Long> mapProductsToProductIds(List<Product> products) {
    if (products == null) {
      return new ArrayList<>();
    }
    return products.stream()
        .map(Product::getId)
        .collect(Collectors.toList());
  }

  @Mapping(source = "franchiseId", target = "franchise")
  @Mapping(source = "productIds", target = "products")
  public Branch branchDTOToBranch(BranchDTO branchdDto);

  // Método default para convertir IDs -> Productos
  default List<Product> mapProductIdsToProducts(List<Long> productIds) {
    if (productIds == null) {
      return new ArrayList<>();
    }
    return productIds.stream()
        .map(id -> {
          Product product = new Product();
          product.setId(id);
          return product;
        })
        .collect(Collectors.toList());
  }

  // Método default para convertir franchiseId -> Franchise
  default Franchise mapFranchiseIdToFranchise(Long franchiseId) {
    if (franchiseId == null) {
      return null;
    }
    Franchise franchise = new Franchise();
    franchise.setId(franchiseId);
    return franchise;
  }
}
