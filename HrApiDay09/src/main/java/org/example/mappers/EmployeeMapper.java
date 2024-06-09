package org.example.mappers;

import org.example.dto.DepartmentDto;
import org.example.dto.EmployeeDto;
import org.example.models.Department;
import org.example.models.Employees;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {JobMapper.class})
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);


    EmployeeDto toEmpDto(Employees e);

}
