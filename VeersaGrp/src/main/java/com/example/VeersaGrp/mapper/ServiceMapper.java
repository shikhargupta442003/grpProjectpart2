package com.example.VeersaGrp.mapper;

import com.example.VeersaGrp.dto.ServiceDto;
import com.example.VeersaGrp.model.Service;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(uses = { ClientMapper.class},componentModel = "spring")
public interface ServiceMapper {

    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

    @Mapping(target = "programs", ignore = true)
    @Mapping(target = "clients", ignore = true)
    Service toEntity(ServiceDto serviceDto);

    @Mapping(target = "programs", ignore = true)
    @Mapping(target = "clients", ignore = true)
    ServiceDto toDto(Service service);
}
