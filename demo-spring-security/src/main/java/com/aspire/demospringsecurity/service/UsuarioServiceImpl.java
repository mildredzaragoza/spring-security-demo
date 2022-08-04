package com.aspire.demospringsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aspire.demospringsecurity.model.Usuario;
import com.aspire.demospringsecurity.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	@Autowired
	private UsuarioRepository usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Usuario findByUsername(String username) {
		return usuarioService.findByUsername(username);
	}

	@Override
	public Usuario registrarUsuario(Usuario usuario) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		return usuarioService.save(usuario);
	}
	
	
}
