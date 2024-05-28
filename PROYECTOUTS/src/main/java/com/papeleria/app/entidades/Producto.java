package com.papeleria.app.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
public class Producto {
	@Id
    private String id;
    private String nombre;
    private double precio;
    private String imagen;
    
	public Producto() {
		super();
	}

	public Producto(String id, String nombre, double precio, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.imagen = imagen;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	  
    
}
