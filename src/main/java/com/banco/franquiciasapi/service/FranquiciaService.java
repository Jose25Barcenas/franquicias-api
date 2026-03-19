package com.banco.franquiciasapi.service;


import com.banco.franquiciasapi.domain.Franquicia;
import com.banco.franquiciasapi.repository.FranquiciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;

    public Franquicia guardar(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    public Optional<Franquicia> obtener(Long id) {
        return franquiciaRepository.findById(id);
    }
}
