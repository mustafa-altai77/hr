package com.springdata.first.model.entity.dto;

import com.springdata.first.model.entity.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpDto {

    private Integer id;
    private String firstName;
    private String LastName;
    private double salary;

    public static EmpDto toDto(Employee entity)
    {
        return EmpDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .LastName(entity.getLastName())
                .salary(entity.getSalary())
                .build();
    }
}
