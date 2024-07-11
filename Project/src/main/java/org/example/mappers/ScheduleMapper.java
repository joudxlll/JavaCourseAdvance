package org.example.mappers;


import org.example.dto.SchedulesDTO;
import org.example.models.Schedules;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScheduleMapper {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);


    SchedulesDTO toSchDto(Schedules s);
}
