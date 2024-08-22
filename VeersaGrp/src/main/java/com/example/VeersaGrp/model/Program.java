package com.example.VeersaGrp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "public")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long programId;


    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany(mappedBy = "programs",cascade = CascadeType.ALL)
    private Set<Service> services =new HashSet<>();


    public void setService(Service service) {
        Set<Service> services = getServices();

        // Check if services is null and initialize it if necessary
        if (services == null) {
            services = new HashSet<>();
        }

        // Add the new service to the set
        services.add(service);

        // Update the services set
        setServices(services);
    }
}
