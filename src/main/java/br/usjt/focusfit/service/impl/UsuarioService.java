package br.usjt.focusfit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.focusfit.model.dto.UsuarioDTO;
import br.usjt.focusfit.model.entity.Usuario;
import br.usjt.focusfit.repository.UsuarioRepository;
import br.usjt.focusfit.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	UsuarioRepository repository;
	
	@Override
	public void criarUsuario(UsuarioDTO usuarioDto) {
		repository.save(Usuario.builder()
				.usuario(usuarioDto.getUsuario())
				.email(usuarioDto.getEmail())
				.senha(usuarioDto.getSenha())
				.peso(usuarioDto.getPeso())
				.altura(usuarioDto.getAltura())
				.idade(usuarioDto.getIdade())
				.build());
	}

	@Override
	public void editarUsuario(UsuarioDTO usuarioDto) {
		Usuario usuario = repository.findByUsuario(usuarioDto.getUsuario());
		
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setPeso(usuarioDto.getPeso());
		usuario.setAltura(usuarioDto.getAltura());
		usuario.setIdade(usuarioDto.getIdade());
		
		repository.save(usuario);
	}

	@Override
	public void deletarUsuario(UsuarioDTO usuarioDto) {
		repository.delete(repository.findByUsuario(usuarioDto.getUsuario()));
	}

	@Override
	public Boolean login(String usuarioLogin, String senha) {
		Usuario usuario = repository.findByUsuario(usuarioLogin);
		if (usuario.getSenha().equals(senha)) {
			return true;
		} else {
			return false;
		}
		
	}

}
