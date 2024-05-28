package com.papeleria.app.service;



import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papeleria.app.entidades.Producto;

@Service
public class CarritoService {
	private List<Producto> carrito = new ArrayList<>();
	

    @Autowired
    private ProductoService productoService;

    public void agregarAlCarrito(String productoId) {     	
    	System.out.println("Agregando producto al carrito con ID: " + productoId);
        Producto producto = productoService.obtenerProductoPorId(productoId);
        if (producto != null) {
            carrito.add(producto);
            System.out.println("Producto agregado al carrito: " + producto);
        }
    	
    } 
    
    public double calcularTotalCarrito() {
        return carrito.stream()
            .mapToDouble(producto -> producto.getPrecio())
            .sum();
    }
    
    public void limpiarCarrito() {
        carrito.clear();
    }
    

    public List<Producto> obtenerProductosEnCarrito() {
        return carrito;
    }
    
    public void removerDelCarrito(String productoId) {
        carrito.removeIf(producto -> producto.getId().equals(productoId));
    }
    
}
