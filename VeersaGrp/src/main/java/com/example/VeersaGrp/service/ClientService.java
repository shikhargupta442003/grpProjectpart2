package com.example.VeersaGrp.service;

import com.example.VeersaGrp.dto.ClientDto;


public interface ClientService {

    ClientDto registerClient(ClientDto clientDto);

    ClientDto findClient(Long clientId);
}
