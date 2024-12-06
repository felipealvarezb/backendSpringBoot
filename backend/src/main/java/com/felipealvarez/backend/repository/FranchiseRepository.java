package com.felipealvarez.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipealvarez.backend.domain.Franchise;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Long> {}
