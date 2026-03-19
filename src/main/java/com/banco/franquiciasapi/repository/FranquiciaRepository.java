package com.banco.franquiciasapi.repository;

import com.banco.franquiciasapi.domain.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> {
}
