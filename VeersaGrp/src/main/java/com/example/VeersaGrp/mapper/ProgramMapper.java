package com.example.VeersaGrp.mapper;

import com.example.VeersaGrp.dto.ProgramDto;
import com.example.VeersaGrp.model.Program;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(uses = {ClientMapper.class, ServiceMapper.class},componentModel = "spring")
public interface ProgramMapper {


    @Mapping(target = "client", source = "client")
    @Mapping(target = "services", source = "services")
    Program toEntity(ProgramDto programDto);

    @Mapping(target = "client", source = "client")
    @Mapping(target = "services", source = "services")
    ProgramDto toDto(Program program);
}