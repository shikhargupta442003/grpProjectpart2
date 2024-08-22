package com.example.VeersaGrp.mapper;

import com.example.VeersaGrp.dto.ClientDto;
import com.example.VeersaGrp.dto.ProgramDto;
import com.example.VeersaGrp.dto.ServiceDto;
import com.example.VeersaGrp.model.Client;
import com.example.VeersaGrp.model.Program;
import com.example.VeersaGrp.model.Service;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {ProgramMapper.class})
public interface ClientMapper {

    @Mapping(target = "programs", ignore = true)
    @Mapping(target = "services", ignore = true)
    Client toEntity(ClientDto clientDto);

    @Mapping(target = "programs", ignore = true)
    @Mapping(target = "services", ignore = true)
    ClientDto toDto(Client client);

}
