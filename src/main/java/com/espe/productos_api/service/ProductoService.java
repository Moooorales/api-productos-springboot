package com.espe.productos_api.service;

import com.espe.productos_api.exception.ProductoInvalidoException;
import com.espe.productos_api.exception.ProductoNoEncontradoException;
import com.espe.productos_api.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductoService {
    private final List<Producto> productos = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(1);

    public List<Producto> obtenerTodos() {
        return productos;
    }

    public Producto obtenerPorId(Long id) {
        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductoNoEncontradoException("Producto con ID " + id + " no fue encontrado."));
    }

    public Producto guardar(Producto producto) {
        if (producto.getPrecio() == null || producto.getPrecio() <= 0) {
            throw new ProductoInvalidoException("El precio del producto debe ser mayor a cero.");
        }
        if (producto.getStock() == null || producto.getStock() < 0) {
            throw new ProductoInvalidoException("El stock del producto no puede ser negativo.");
        }

        producto.setId(contadorId.getAndIncrement());
        productos.add(producto);
        return producto;
    }

    public void eliminar(Long id) {
        Producto producto = obtenerPorId(id);
        productos.remove(producto);
    }
}