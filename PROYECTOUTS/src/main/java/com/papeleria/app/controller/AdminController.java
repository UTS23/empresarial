package com.papeleria.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.papeleria.app.entidades.User;
import com.papeleria.app.exception.NotFoundException;
import com.papeleria.app.repositorio.UserRepository;


import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "administrador")
public class AdminController {
	@Autowired
	private UserRepository userRepository;

	@ModelAttribute("user")
	public User userModel() {
		return new User();
	}

	@GetMapping("/")
	public String UserListTemplate(Model model, HttpSession session) {
		boolean isAdmin = (session.getAttribute("isAdmin") != null) && (boolean) session.getAttribute("isAdmin");

		if (isAdmin) {
			model.addAttribute("users", userRepository.findAll());
			return "administrador";
		} else {
			session.setAttribute("msg", "Lo siento no tienes permiso para ingresar a esa página");
			return "redirect:/logueo";
		}

	}
	
	@GetMapping("/new")
	public String userNewTemplate(Model model, HttpSession session) {

		// Verificar_si_es_administrador
		boolean isAdmin = (session.getAttribute("isAdmin") != null) && (boolean) session.getAttribute("isAdmin");

		if (isAdmin) {
			// Crear_nuevo_usuario
			model.addAttribute("user", new User());
			return "crearUser";
		} else {
			session.setAttribute("msg", "Lo siento no tienes permiso para ingresar a esa página");
			return "redirect:/logueo";
		}

	}

	@GetMapping("/edit/{id}")
	public String userEditTemplate(@PathVariable("id") String id, Model model, HttpSession session) {
		
		// Verificar_si_es_administrador
				boolean isAdmin = (session.getAttribute("isAdmin") != null) && (boolean) session.getAttribute("isAdmin");
		
				if (isAdmin) {
					
				
		
		model.addAttribute("user",userRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuario no encontrado")));
		return "crearUser";
				}else {
					session.setAttribute("msg", "Lo siento no tienes permiso para ingresar a esa página");
					return "redirect:/logueo";
				}
				
	}

	@PostMapping("/save")
	public String userSaveProcces(@ModelAttribute("user") User user) {
		if (user.getId().isEmpty()) {
			user.setId(null);
		}

		userRepository.save(user);
		return "redirect:/administrador/";
	}

	@GetMapping("/delete/{id}")
	public String userDeleteProccess(@PathVariable("id") String id,  HttpSession session) {

		// Verificar_si_es_administrador
		boolean isAdmin = (session.getAttribute("isAdmin") != null) && (boolean) session.getAttribute("isAdmin");

		if (isAdmin) {
			userRepository.deleteById(id);
			return "redirect:/administrador/";
		}else {
			session.setAttribute("msg", "Lo siento no tienes permiso para ingresar a esa página");
			return "redirect:/logueo";
		}
		
	}

}
