package com.felipealvarez.backend.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.felipealvarez.backend.domain.Franchise;
import com.felipealvarez.backend.repository.FranchiseRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FranchiseServiceImpl implements FranchiseService {

  @Autowired
  private FranchiseRepository franchiseRepository;

  @Override
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  public Franchise save(Franchise entity) throws Exception {
    log.info("saving Franchise instance");

    if (entity == null) {
      throw new Exception("Entity not found");
    }

    return franchiseRepository.save(entity);
  }

  @Override
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  public Franchise update(Franchise entity) throws Exception {
    log.info("updating Franchise instance");

    if (entity == null) {
      throw new Exception("Entity not found");
    }

    Franchise existingFranchise = franchiseRepository.findById(entity.getId())
        .orElseThrow(() -> new Exception("Entity not found with that key"));

    if (entity.getName() != null) {
      existingFranchise.setName(entity.getName());
    }

    if (existingFranchise.getBranches() == null) {
        existingFranchise.setBranches(new ArrayList<>());
    }

    return franchiseRepository.save(existingFranchise);
  }
}
