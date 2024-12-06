package com.felipealvarez.backend.dto;

import java.util.List;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchDTO {
  
  private Long id;
  @Nonnull
  private String name;
  @Nonnull
  private Long franchiseId;
  private List<Long> productIds;
}
