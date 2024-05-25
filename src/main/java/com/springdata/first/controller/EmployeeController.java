package com.springdata.first.controller;

import com.springdata.first.Message;
import com.springdata.first.model.entity.Employee;
import com.springdata.first.model.entity.dto.EmpDto;
import com.springdata.first.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmpService empService;

    @GetMapping("/get-emp")
    public EmpDto getEmp(@RequestParam Integer id){
        return empService.getUser(id);
    }

    @GetMapping("/get-emps")
    public List<Employee> getAllEmp(){
        return empService.getAllEmp();
    }
    @PostMapping("/add-emp")
    public ResponseEntity<EmpDto> save(@RequestBody Employee emp){
        EmpDto employee=empService.save(emp);
        return ResponseEntity.status(201).body(employee);
    }
    @PutMapping("/update-emp")
    public ResponseEntity<EmpDto> update(@RequestBody Employee emp){
        EmpDto employee=empService.save(emp);
        return ResponseEntity.status(200).body(employee);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Message> delete(@RequestBody EmpDto employee) {
        boolean isDeleted=empService.delete(employee.getId());
        if (isDeleted)
        {
          return   ResponseEntity.ok(new Message("Employee with ID " + employee.getId() + " has been deleted."));
        }
        else {
            return  ResponseEntity.badRequest().body(new Message("Employee with ID " + employee.getId() + " is not found."));
        }

    }
}
