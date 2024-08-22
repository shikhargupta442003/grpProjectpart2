package com.example.VeersaGrp.service.impl;

import com.example.VeersaGrp.dto.ProgramDto;
import com.example.VeersaGrp.mapper.ClientMapper;
import com.example.VeersaGrp.mapper.ProgramMapper;
import com.example.VeersaGrp.mapper.ServiceMapper;
import com.example.VeersaGrp.model.Client;
import com.example.VeersaGrp.model.Program;
import com.example.VeersaGrp.repository.ClientRepository;
import com.example.VeersaGrp.repository.ProgramRepository;
import com.example.VeersaGrp.repository.ServiceRepository;
import com.example.VeersaGrp.service.ProgramService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    @Autowired
    ProgramRepository programRepository;
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProgramMapper programMapper;



    @Override
    public ProgramDto registerProgram(ProgramDto programDto, List<Long> serviceIds,Long clientId) {
        Program program = programMapper.toEntity(programDto);
        Client client=clientRepository.getReferenceById(clientId);

        for(Long serviceId:serviceIds){
            com.example.VeersaGrp.model.Service service= serviceRepository.getReferenceById(serviceId);
            service.setClient(client);
            service.setProgram(program);
            program.setService(service);
        }
        Program result= programRepository.save(program);
        return programMapper.toDto(result);
    }

    @Override
    public ProgramDto findProgram(Long programId) {
        Program program=programRepository.getReferenceById(programId);
        return programMapper.toDto(program);
    }
}
