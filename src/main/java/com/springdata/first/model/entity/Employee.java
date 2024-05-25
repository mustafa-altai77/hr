package com.springdata.first.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "employees")// the name of table
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)// mean auto increment
    @Column(name = "emp_id")
     private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String LastName;
    private double salary;
}
