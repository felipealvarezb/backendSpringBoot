package com.felipealvarez.backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.felipealvarez.backend.domain.Branch;
import com.felipealvarez.backend.domain.Product;
import com.felipealvarez.backend.dto.ProductDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  @Mapping(source = "branchId", target = "branch")
  public Product productDTOToProduct(ProductDTO productdDto);

  @Mapping(source = "branch.id", target = "branchId")
  public ProductDTO productToProductDTO(Product product);

  default Branch mapBranchIdToBranch(Long branchId) {
    if (branchId == null) {
        return null;
    }
    Branch branch = new Branch();
    branch.setId(branchId);
    return branch;
}
}
