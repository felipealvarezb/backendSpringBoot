package com.felipealvarez.backend.dto;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
  
  private Long id;
  @Nonnull
  private String name;
  @Nonnull
  private Integer stock;
  @Nonnull
  private Long branchId;
}
