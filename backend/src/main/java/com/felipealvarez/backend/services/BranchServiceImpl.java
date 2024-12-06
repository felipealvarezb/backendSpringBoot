package com.felipealvarez.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.felipealvarez.backend.domain.Branch;
import com.felipealvarez.backend.domain.Franchise;
import com.felipealvarez.backend.repository.BranchRepository;
import com.felipealvarez.backend.repository.FranchiseRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BranchServiceImpl implements BranchService{

  @Autowired private BranchRepository branchRepository;

  @Autowired private FranchiseRepository franchiseRepository;

  @Override
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  public Branch save(Branch entity) throws Exception{
    log.info("saving Branch instance");

    if (entity == null) {
      throw new Exception("Entity not found");
    }

    if (entity.getFranchise() == null || entity.getFranchise().getId() == null) {
      throw new Exception("Franchise ID is required");
    }

    Franchise franchise = franchiseRepository.findById(entity.getFranchise().getId())
      .orElseThrow(() -> new Exception("Franchise not found"));

    entity.setFranchise(franchise);

    return branchRepository.save(entity);
  }

  @Override
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  public Branch update(Branch entity) throws Exception{
    log.info("updating Branch instance");

    if (entity == null) {
      throw new Exception("Entity not found");
    }

    if (!branchRepository.existsById(entity.getId())) {
      throw new Exception("Entity not found with that key");
    }

    return branchRepository.save(entity);

  }
  
}
