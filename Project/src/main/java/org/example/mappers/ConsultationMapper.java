package org.example.mappers;


import org.example.dto.ConsultationsDTO;
import org.example.models.Consultations;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

//Consultations to ConsultationsDTO
@Mapper
public interface ConsultationMapper {
    ConsultationMapper INSTANCE = Mappers.getMapper(ConsultationMapper.class);


    ConsultationsDTO toConDto(Consultations c);
}
