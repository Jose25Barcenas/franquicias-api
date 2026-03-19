package com.banco.franquiciasapi.repository;

import com.banco.franquiciasapi.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
