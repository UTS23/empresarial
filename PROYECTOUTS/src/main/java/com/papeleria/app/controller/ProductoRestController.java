package com.papeleria.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.papeleria.app.entidades.Producto;
import com.papeleria.app.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodosLosProductos() {
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable String id) {
        Producto producto = productoService.obtenerProductoPorId(id);
        if (producto != null) {
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.crearProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable String id, @RequestBody Producto productoDetalles) {
        Producto productoExistente = productoService.obtenerProductoPorId(id);
        if (productoExistente != null) {
            productoExistente.setNombre(productoDetalles.getNombre());
            productoExistente.setPrecio(productoDetalles.getPrecio());
            productoExistente.setImagen(productoDetalles.getImagen());
            Producto productoActualizado = productoService.actualizarProducto(productoExistente);
            return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable String id) {
        Producto productoExistente = productoService.obtenerProductoPorId(id);
        if (productoExistente != null) {
            productoService.eliminarProducto(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
