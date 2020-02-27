package com.emwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emwa.model.Recruitment;

@Repository
public interface RecruitmentRepository extends JpaRepository<Recruitment, Long>{

}
