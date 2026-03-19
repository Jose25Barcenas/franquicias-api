package com.banco.franquiciasapi.controller;

import com.banco.franquiciasapi.domain.Franquicia;
import com.banco.franquiciasapi.service.FranquiciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/franquicias")
@RequiredArgsConstructor
public class FranquiciaController {

    private final FranquiciaService service;

    @PostMapping
    public Franquicia crear(@RequestBody Franquicia franquicia) {
        return service.guardar(franquicia);
    }

    @GetMapping("/{id}")
    public Franquicia obtener(@PathVariable Long id) {
        return service.obtener(id).orElseThrow();
    }
}
