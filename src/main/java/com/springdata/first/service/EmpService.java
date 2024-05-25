package com.springdata.first.service;

import com.springdata.first.model.entity.Employee;
import com.springdata.first.model.entity.dto.EmpDto;
import com.springdata.first.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmpService {

     @Autowired(required=true)
    private EmpRepo empRepo;

     public EmpDto getUser(Integer id){
         //Optional for null pointer exception
         Optional<Employee> emp=empRepo.findById(id);
         if(emp.isPresent())
             return EmpDto.toDto(emp.get());
         else
         return null;
         //         return emp.map(EmpDto::toDto).orElse(null);
     }
     public List<Employee> getAllEmp(){
         List<Employee> emp=empRepo.findAll();
         return emp;
     }
     public EmpDto save(Employee employee)
     {
         return EmpDto.toDto(empRepo.save(employee));
     }
     public boolean delete(Integer id)
     {
         if (empRepo.existsById(id)) {
             empRepo.deleteById(id);
             return true;
         }
         else {
             return false;
         }
     }
}
