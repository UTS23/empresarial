package com.papeleria.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.papeleria.app.entidades.Producto;
import com.papeleria.app.service.CarritoService;

@Controller
public class CarritoController {
	
	@Autowired
    private CarritoService carritoService;

	@GetMapping("/carrito")
    public String verCarrito(Model model) {
		List<Producto> productosEnCarrito = carritoService.obtenerProductosEnCarrito();
	    model.addAttribute("productosEnCarrito", productosEnCarrito);
	    model.addAttribute("carritoVacio", productosEnCarrito.isEmpty());
	    return "carrito";
    }
	
	@PostMapping("/carrito/remover/{id}")
	public String removerDelCarrito(@PathVariable String id) {
		carritoService.removerDelCarrito(id);
		System.out.println("Producto eliminado del carrito con ID: " + id);
	    return "redirect:/carrito";
    }

}
