package com.example.VeersaGrp.service.impl;

import com.example.VeersaGrp.dto.ServiceDto;
import com.example.VeersaGrp.mapper.ClientMapper;
import com.example.VeersaGrp.mapper.ProgramMapper;
import com.example.VeersaGrp.mapper.ServiceMapper;
import com.example.VeersaGrp.model.Service;
import com.example.VeersaGrp.repository.ClientRepository;
import com.example.VeersaGrp.repository.ProgramRepository;
import com.example.VeersaGrp.repository.ServiceRepository;
import com.example.VeersaGrp.service.ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private ProgramRepository programRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    ServiceMapper serviceMapper;

    @Override
    public ServiceDto registerService(ServiceDto serviceDto) {
        Service service = serviceMapper.toEntity(serviceDto);

//        if (serviceDto.getPrograms() != null) {
//            List<Program> programs=service.getPrograms();
//            service.setPrograms(programs);
//        }
//
//        if (serviceDto.getClients() != null) {
//            Set<Client> clients = service.getClients();
//            service.setClients(clients);
//        }

        Service savedService = serviceRepository.save(service);

        ServiceDto savedServiceDto = serviceMapper.toDto(savedService);


        return savedServiceDto;
    }

    @Override
    public ServiceDto findService(Long serviceId) {
        Service service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return serviceMapper.toDto(service);
    }
}
