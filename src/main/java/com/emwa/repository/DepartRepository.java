package com.emwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emwa.model.Depart;

@Repository
public interface DepartRepository extends JpaRepository<Depart, Long>{

}
