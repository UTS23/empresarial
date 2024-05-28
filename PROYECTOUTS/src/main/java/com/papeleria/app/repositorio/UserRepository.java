package com.papeleria.app.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.papeleria.app.entidades.User;



public interface UserRepository extends MongoRepository<User, String> {

	public User findByEmail(String email);

}
