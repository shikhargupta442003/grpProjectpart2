package com.example.VeersaGrp.service;

import com.example.VeersaGrp.dto.ProgramDto;

import java.util.List;


public interface ProgramService {
    ProgramDto registerProgram(ProgramDto programDto, List<Long> serviceIds,Long clientId);

    ProgramDto findProgram(Long programId);
}
