package com.papeleria.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.papeleria.app.entidades.Producto;
import com.papeleria.app.service.CarritoService;

@RestController
@RequestMapping("/api/carrito")
public class CarritoRestController {

	@Autowired
    private CarritoService carritoService;

	@PostMapping("/agregar/{productoId}")
	public ResponseEntity<String> agregarAlCarrito(@PathVariable String productoId) {
	    carritoService.agregarAlCarrito(productoId);
	    System.out.println("Producto agregado al carrito con ID: " + productoId);
	    return ResponseEntity.ok("<h1>Producto agregado al carrito</h1>");
	}

    @GetMapping("/productos")
    public List<Producto> obtenerProductosEnCarrito() {
        return carritoService.obtenerProductosEnCarrito();
    }
    
}
