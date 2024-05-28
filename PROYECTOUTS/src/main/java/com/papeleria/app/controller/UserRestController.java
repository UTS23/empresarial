package com.papeleria.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.papeleria.app.entidades.User;
import com.papeleria.app.exception.NotFoundException;
import com.papeleria.app.repositorio.UserRepository;


@RestController
@RequestMapping(value = "api/users")
public class UserRestController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/listarUser")
	private List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/listarUser/{id}")
	public User getUserId(@PathVariable String id) {
		//API:mirar_user
		return userRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuario no encontrado"));
	}
}
