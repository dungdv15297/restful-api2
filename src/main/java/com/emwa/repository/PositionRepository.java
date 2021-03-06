package com.emwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emwa.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long>{

}
