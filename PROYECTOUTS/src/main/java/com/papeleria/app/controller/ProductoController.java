package com.papeleria.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.papeleria.app.entidades.Producto;
import com.papeleria.app.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.obtenerTodosLosProductos());
        return "productos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevoProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "producto_form";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarProducto(@PathVariable("id") String id, Model model) {
        Producto producto = productoService.obtenerProductoPorId(id);
        if (producto != null) {
            model.addAttribute("producto", producto);
            return "producto_form";
        } else {
            return "redirect:/productos";
        }
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        productoService.crearProducto(producto);
        return "redirect:/api/productos/productos";
    }
}
