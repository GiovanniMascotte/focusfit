package br.usjt.focusfit.service;

import br.usjt.focusfit.model.dto.UsuarioDTO;

public interface IUsuarioService {
	public void criarUsuario(UsuarioDTO usuarioDto);
	
	public void editarUsuario(UsuarioDTO usuarioDto);
	
	public void deletarUsuario(UsuarioDTO usuarioDto);
	
	public Boolean login(String usuario, String senha);
}
