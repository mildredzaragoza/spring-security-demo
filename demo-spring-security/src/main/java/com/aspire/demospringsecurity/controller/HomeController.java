package com.aspire.demospringsecurity.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aspire.demospringsecurity.model.Usuario;
import com.aspire.demospringsecurity.service.IUsuarioService;

@Controller
public class HomeController {
	@Autowired 
	private IUsuarioService userService;
	
	@GetMapping("/")
	public String inicio() {
		return "index.html";
	}
	
	@GetMapping("/auth-registro")
	public String registroForm(Model model) {
		model.addAttribute("user", new Usuario());
		return "html/registro.html";
	}
	
	@PostMapping("/auth-registro")
	public String registro(HttpServletRequest request) {
		Usuario user = new Usuario(); 
		user.setRole(request.getParameter("role"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		userService.registrarUsuario(user);
	/*	if(result.hasErrors()) {
			System.out.println("Hubo un error en registro - post");
		}else {
			Usuario user = new Usuario();
			user.setRole("ROLE_ADMIN");
			user.setUsername("shabb");
			user.setPassword("1234");
			userService.registrarUsuario(user);
		} */
		return "/auth-login";

	} 
}
