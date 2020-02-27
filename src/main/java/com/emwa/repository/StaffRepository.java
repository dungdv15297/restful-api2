package com.emwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emwa.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long>{

}
