package com.papeleria.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.papeleria.app.entidades.Producto;
import com.papeleria.app.service.CarritoService;

@Controller
@RequestMapping("/confirmacion-compra")
public class FinalizarCompraController {

	@Autowired
    private CarritoService carritoService;

    @GetMapping
    public String mostrarConfirmacionCompra(Model model) {
        List<Producto> productosEnCarrito = carritoService.obtenerProductosEnCarrito();
        double total = carritoService.calcularTotalCarrito();
        
        model.addAttribute("productosEnCarrito", productosEnCarrito);
        model.addAttribute("total", total);

        // Limpiar el carrito después de finalizar la compra
        carritoService.limpiarCarrito();

        return "confirmacion-compra";
    }
}
