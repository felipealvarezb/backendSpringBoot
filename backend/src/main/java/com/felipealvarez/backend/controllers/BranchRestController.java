package com.felipealvarez.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipealvarez.backend.domain.Branch;
import com.felipealvarez.backend.dto.BranchDTO;
import com.felipealvarez.backend.mappers.BranchMapper;
import com.felipealvarez.backend.services.BranchService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/branch")
@Slf4j
public class BranchRestController {
  
  @Autowired private BranchService branchService;
  @Autowired private BranchMapper branchMapper;

  @PostMapping()
  public ResponseEntity<?> save(@RequestBody BranchDTO branchDTO) throws Exception{
    try {
      log.info("Request to save Branch: {}", branchDTO);

      Branch branch = branchMapper.branchDTOToBranch(branchDTO);
      branch = branchService.save(branch);
      return ResponseEntity.ok().body(branchMapper.branchToBranchDTO(branch));
    } catch (Exception e) {
      log.error("Error saving Branch: {}", e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @PutMapping()
  public ResponseEntity<?> update(@RequestBody BranchDTO branchDTO) throws Exception{
    try {
      log.info("Request to update Branch: {}", branchDTO);
      
      Branch branch = branchMapper.branchDTOToBranch(branchDTO);
      branch = branchService.save(branch);
      return ResponseEntity.ok().body(branchMapper.branchToBranchDTO(branch));
    } catch (Exception e) {
      log.error("Error updating Branch: {}", e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
