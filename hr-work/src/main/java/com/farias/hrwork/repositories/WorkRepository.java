package com.farias.hrwork.repositories;

import com.farias.hrwork.entities.Worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<Worker, Long> {
    
}
