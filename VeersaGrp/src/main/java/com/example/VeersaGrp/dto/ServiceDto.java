package com.example.VeersaGrp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDto {

    private Long serviceId;

    private String name;

    private List<ProgramDto> programs;

    private Set<ClientDto> clients;


}
