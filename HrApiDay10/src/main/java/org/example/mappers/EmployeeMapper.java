package org.example.mappers;

import org.example.dto.DepartmentDto;
import org.example.dto.EmployeeDto;
import org.example.models.Department;
import org.example.models.Employees;
import org.example.models.Jobs;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {JobMapper.class})
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(source = "e.employee_id", target = "employee_id")
    @Mapping(source = "e.job_id", target = "job_id")
    EmployeeDto toEmpDto(Employees e, Jobs j);


//    EmployeeDto toEmpDto(Employees e);

}
