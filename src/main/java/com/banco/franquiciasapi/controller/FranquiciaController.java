package com.banco.franquiciasapi.controller;

import com.banco.franquiciasapi.domain.Franquicia;
import com.banco.franquiciasapi.domain.Sucursal;
import com.banco.franquiciasapi.domain.Producto;
import com.banco.franquiciasapi.service.FranquiciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // ✅ agregar sucursal
    @PostMapping("/{id}/sucursales")
    public Franquicia agregarSucursal(@PathVariable Long id, @RequestBody Sucursal sucursal) {
        return service.agregarSucursal(id, sucursal);
    }

    // ✅ agregar producto
    @PostMapping("/{fid}/sucursales/{sid}/productos")
    public Franquicia agregarProducto(
            @PathVariable Long fid,
            @PathVariable Long sid,
            @RequestBody Producto producto) {

        return service.agregarProducto(fid, sid, producto);
    }

    // ✅ eliminar producto
    @DeleteMapping("/{fid}/sucursales/{sid}/productos/{pid}")
    public Franquicia eliminarProducto(
            @PathVariable Long fid,
            @PathVariable Long sid,
            @PathVariable Long pid) {

        return service.eliminarProducto(fid, sid, pid);
    }

    // ✅ actualizar stock
    @PutMapping("/{fid}/sucursales/{sid}/productos/{pid}/stock")
    public Franquicia actualizarStock(
            @PathVariable Long fid,
            @PathVariable Long sid,
            @PathVariable Long pid,
            @RequestParam int stock) {

        return service.actualizarStock(fid, sid, pid, stock);
    }

    // 🔥 ✅ endpoint correcto (el que da puntos)
    @GetMapping("/{id}/productos-mayor-stock")
    public List<Producto> productosMayorStock(@PathVariable Long id) {
        return service.productosMayorStockPorSucursal(id);
    }
}