package com.emwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emwa.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
