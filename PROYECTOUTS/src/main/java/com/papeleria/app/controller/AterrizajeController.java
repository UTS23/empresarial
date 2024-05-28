package com.papeleria.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.papeleria.app.entidades.Admin;
import com.papeleria.app.entidades.User;
import com.papeleria.app.repositorio.AdminRepository;
import com.papeleria.app.repositorio.UserRepository;

import jakarta.servlet.http.HttpSession;


@Controller
public class AterrizajeController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/login")
	public String loginAdm(Model model) {
		return "login";
	}
	@GetMapping("/terms")
	public String Terminos(Model model) {
		return "Terminos";
	}
	@GetMapping("/returns")
	public String Devoluciones(Model model) {
		return "Devoluciones";
	}
	@GetMapping("/privacy")
	public String Privacidad(Model model) {
		return "Privacidad";
	}
	@GetMapping("/contact")
	public String Contacto(Model model) {
		return "Contacto";
	}
	@GetMapping("/about")
	public String Nosotros(Model model) {
		return "Nosotros";
	}
	@GetMapping("/delivery")
	public String Domicilios(Model model) {
		return "Domicilios";
	}
	@GetMapping("/faq")
	public String Preguntas_Frecuentes(Model model) {
		return "Preguntas";
	}
	
	
	
	
	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
	    Admin admin = adminRepository.findByEmail(email);
	    User user = userRepository.findByEmail(email);

	    if (admin != null && admin.getPassword().equals(password)) {
	        // Si es un administrador, redirigir al panel de administrador
	        session.setAttribute("isAdmin", true);
	        session.setAttribute("isUser", false);
	        return "redirect:/productos";
	    }  else {
	        session.setAttribute("msg", "Correo o contraseña incorrecta. Verifica por favor");
	        return "login"; // Página de inicio de sesión general
	    }
	}

	    
	
}
