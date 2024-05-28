package com.papeleria.app.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.papeleria.app.entidades.Producto;

public interface ProductoRepository extends MongoRepository <Producto, String> {
   
}