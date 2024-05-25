package com.springdata.first.repository;

import com.springdata.first.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// it takes the Employee model and the id is Integer
public interface EmpRepo extends JpaRepository<Employee,Integer> {

}
