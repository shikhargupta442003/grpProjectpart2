package com.example.VeersaGrp.service.impl;

import com.example.VeersaGrp.dto.ClientDto;
import com.example.VeersaGrp.mapper.ClientMapper;
import com.example.VeersaGrp.mapper.ProgramMapper;
import com.example.VeersaGrp.mapper.ServiceMapper;
import com.example.VeersaGrp.model.Client;
import com.example.VeersaGrp.repository.ClientRepository;
import com.example.VeersaGrp.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    @Autowired
    private final ClientRepository clientRepository;
    @Autowired
    private final ClientMapper clientMapper ;

    @Override
    public ClientDto registerClient(ClientDto clientDto) {


        Client client = clientMapper.toEntity(clientDto);
        Client savedClient = clientRepository.save(client);
        return clientMapper.toDto(savedClient);
    }

    @Override
    public ClientDto findClient(Long clientId) {
        Client client =clientRepository.findById(clientId)
                        .orElseThrow(() -> new RuntimeException("Client not found"));
        return clientMapper.toDto(client);
    }
}
