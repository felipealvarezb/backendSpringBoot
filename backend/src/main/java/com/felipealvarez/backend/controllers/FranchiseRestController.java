package com.felipealvarez.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipealvarez.backend.domain.Franchise;
import com.felipealvarez.backend.dto.FranchiseDTO;
import com.felipealvarez.backend.mappers.FranchiseMapper;
import com.felipealvarez.backend.services.FranchiseService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/franchise")
@Slf4j
public class FranchiseRestController {

  @Autowired private FranchiseService franchiseService;
  @Autowired private FranchiseMapper franchiseMapper;

  @PostMapping()
  public ResponseEntity<?> save(@RequestBody FranchiseDTO franchiseDTO) throws Exception{
    try {
      log.info("Request to save Franchise: {}", franchiseDTO);
    
    Franchise franchise = franchiseMapper.franchiseDTOToFranchise(franchiseDTO);
    franchise = franchiseService.save(franchise);
    return ResponseEntity.ok().body(franchiseMapper.franchiseToFranchiseDTO(franchise));
    } catch (Exception e) {
      log.error("Error saving Franchise: {}", e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @PutMapping()
  public ResponseEntity<?> update(@RequestBody FranchiseDTO franchiseDTO) throws Exception{
    try {
      log.info("Request to update Franchise: {}", franchiseDTO);
    
      Franchise franchise = franchiseMapper.franchiseDTOToFranchise(franchiseDTO);
    franchise = franchiseService.save(franchise);
    return ResponseEntity.ok().body(franchiseMapper.franchiseToFranchiseDTO(franchise));
    } catch (Exception e) {
      log.error("Error updating Franchise: {}", e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
