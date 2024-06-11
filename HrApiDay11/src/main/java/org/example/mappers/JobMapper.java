package org.example.mappers;

import org.example.dto.DepartmentDto;
import org.example.dto.JobsDto;
import org.example.models.Department;
import org.example.models.Jobs;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface JobMapper {
    JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);

    //    @Mapping(source = "departmentId", target = "deptId")
//    @Mapping(source = "departmentName", target = "deptName")
//    @Mapping(source = "locationId", target = "locId")
    JobsDto tojobDto(Jobs j);

    Jobs toModel(JobsDto dto);

//
}
