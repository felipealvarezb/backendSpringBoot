package com.felipealvarez.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipealvarez.backend.domain.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long>{}
