package com.aspire.demospringsecurity.service;

import com.aspire.demospringsecurity.model.Usuario;

public interface IUsuarioService {
	public Usuario findByUsername(String username);
	public Usuario registrarUsuario(Usuario usuario);
}
