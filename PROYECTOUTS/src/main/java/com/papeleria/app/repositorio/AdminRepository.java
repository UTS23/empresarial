package com.papeleria.app.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.papeleria.app.entidades.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {
	
	public Admin findByEmail(String email);
	
	

}
