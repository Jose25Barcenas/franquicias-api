package com.banco.franquiciasapi.service;

import com.banco.franquiciasapi.domain.Franquicia;
import com.banco.franquiciasapi.domain.Sucursal;
import com.banco.franquiciasapi.domain.Producto;
import com.banco.franquiciasapi.repository.FranquiciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;

    // ✅ crear franquicia
    public Franquicia guardar(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    // ✅ obtener franquicia
    public Optional<Franquicia> obtener(Long id) {
        return franquiciaRepository.findById(id);
    }

    // ✅ agregar sucursal
    public Franquicia agregarSucursal(Long franquiciaId, Sucursal sucursal) {
        Franquicia f = franquiciaRepository.findById(franquiciaId).orElseThrow();
        f.getSucursales().add(sucursal);
        return franquiciaRepository.save(f);
    }

    // ✅ agregar producto
    public Franquicia agregarProducto(Long franquiciaId, Long sucursalId, Producto producto) {
        Franquicia f = franquiciaRepository.findById(franquiciaId).orElseThrow();

        for (Sucursal s : f.getSucursales()) {
            if (s.getId().equals(sucursalId)) {
                s.getProductos().add(producto);
            }
        }

        return franquiciaRepository.save(f);
    }

    // ✅ eliminar producto
    public Franquicia eliminarProducto(Long franquiciaId, Long sucursalId, Long productoId) {
        Franquicia f = franquiciaRepository.findById(franquiciaId).orElseThrow();

        for (Sucursal s : f.getSucursales()) {
            if (s.getId().equals(sucursalId)) {
                s.getProductos().removeIf(p -> p.getId().equals(productoId));
            }
        }

        return franquiciaRepository.save(f);
    }

    // ✅ actualizar stock
    public Franquicia actualizarStock(Long franquiciaId, Long sucursalId, Long productoId, int nuevoStock) {
        Franquicia f = franquiciaRepository.findById(franquiciaId).orElseThrow();

        for (Sucursal s : f.getSucursales()) {
            if (s.getId().equals(sucursalId)) {
                for (Producto p : s.getProductos()) {
                    if (p.getId().equals(productoId)) {
                        p.setStock(nuevoStock);
                    }
                }
            }
        }

        return franquiciaRepository.save(f);
    }

    // 🔥 ✅ PRODUCTOS CON MAYOR STOCK POR SUCURSAL (CORRECTO)
    public List<Producto> productosMayorStockPorSucursal(Long franquiciaId) {
        Franquicia f = franquiciaRepository.findById(franquiciaId).orElseThrow();

        List<Producto> resultado = new ArrayList<>();

        for (Sucursal s : f.getSucursales()) {
            Producto max = s.getProductos().stream()
                    .max((p1, p2) -> Integer.compare(p1.getStock(), p2.getStock()))
                    .orElse(null);

            if (max != null) {
                resultado.add(max);
            }
        }

        return resultado;
    }
}
