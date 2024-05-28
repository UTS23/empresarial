package com.papeleria.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papeleria.app.entidades.Producto;
import com.papeleria.app.repositorio.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    public Producto obtenerProductoPorId(String id) {
        return productoRepository.findById(id).orElse(null);
    }

    public void eliminarProducto(String id) {
        productoRepository.deleteById(id);
    }

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizarProducto(Producto productoExistente) {
        return productoRepository.save(productoExistente);
    }
}


