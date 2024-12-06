package com.felipealvarez.backend.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.felipealvarez.backend.domain.Branch;
import com.felipealvarez.backend.domain.Franchise;
import com.felipealvarez.backend.dto.FranchiseDTO;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {

  @Mapping(source = "branches", target = "branchIds")
  public FranchiseDTO franchiseToFranchiseDTO(Franchise franchise);

  @Mapping(source = "branchIds", target = "branches")
  public Franchise franchiseDTOToFranchise(FranchiseDTO franchisedDto);

  // Convierte List<Branch> -> List<Long>
  default List<Long> mapBranchesToBranchIds(List<Branch> branches) {
    if (branches == null) {
        return new ArrayList<>();
    }
    return branches.stream()
            .map(Branch::getId)
            .collect(Collectors.toList());
}

  // Convierte List<Long> -> List<Branch>
  default List<Branch> mapBranchIdsToBranches(List<Long> branchIds) {
    if (branchIds == null) {
        return new ArrayList<>();
    }
    return branchIds.stream()
            .map(id -> {
                Branch branch = new Branch();
                branch.setId(id);
                return branch;
            })
            .collect(Collectors.toList());
}
}
