package com.banco.franquiciasapi.repository;


import com.banco.franquiciasapi.domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
}
