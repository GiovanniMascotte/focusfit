package br.usjt.focusfit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.usjt.focusfit.model.dto.ResponseBody;
import br.usjt.focusfit.model.dto.UsuarioDTO;
import br.usjt.focusfit.service.IUsuarioService;

@Controller
@RequestMapping("/api/usuario/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	IUsuarioService usuarioService;
    
	@PostMapping("criarUsuario")
    public ResponseEntity<ResponseBody> criarUsuario(@RequestBody UsuarioDTO usuarioDto) {
		usuarioService.criarUsuario(usuarioDto);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseBody.builder().mensagem("Usuário criado com sucesso.").build());
    }

	@PutMapping("editarUsuario")
	public ResponseEntity<ResponseBody> editarUsuario(@RequestBody UsuarioDTO usuarioDto) {
		usuarioService.editarUsuario(usuarioDto);
		
		return ResponseEntity.accepted()
				.body(ResponseBody.builder().mensagem("Usuário editado com sucesso.").build());
    }
	
	@DeleteMapping("deletarUsuario")
	public ResponseEntity<ResponseBody> deletarUsuario(@RequestBody UsuarioDTO usuarioDto) {
		usuarioService.deletarUsuario(usuarioDto);
		
		return ResponseEntity.ok(ResponseBody.builder().mensagem("Usuário excluído com sucesso.").build());
    }
	
	@GetMapping("login")
	public ResponseEntity<ResponseBody> login(@RequestParam(value="USUARIO") String usuario, @RequestParam(value="SENHA") String senha) {
		Boolean sucessoLogin = usuarioService.login(usuario, senha);
		
		if (!sucessoLogin) {
			return ResponseEntity.badRequest()
					.body(ResponseBody.builder().mensagem("Usuário ou senha inválido(s).").build());
		}
		
		return ResponseEntity.ok(ResponseBody.builder().mensagem("Login efetuado com sucesso.").build());
	}
}
