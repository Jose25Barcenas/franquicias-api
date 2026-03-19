package com.banco.franquiciasapi.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Franquicia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Sucursal> sucursales;
}
