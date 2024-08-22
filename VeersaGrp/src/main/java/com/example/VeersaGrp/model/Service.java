package com.example.VeersaGrp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "public")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;


    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "program_service",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name="program_id")
    )
    private List<Program> programs = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "client_service",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name="client_id")
    )
    private Set<Client> clients = new HashSet<>();

    public void setClient(Client client) {
        Set<Client> clients = getClients();

        // Check if services is null and initialize it if necessary
        if (clients == null) {
            clients = new HashSet<>();
        }

        // Add the new service to the set
        clients.add(client);

        // Update the services set
        setClients(clients);
    }

    public void setProgram(Program program) {
        List<Program> programs = getPrograms();

        // Check if services is null and initialize it if necessary
        if (programs == null) {
            programs = new ArrayList<>();
        }

        // Add the new service to the set
        programs.add(program);

        // Update the services set
        setPrograms(programs);
    }
}

