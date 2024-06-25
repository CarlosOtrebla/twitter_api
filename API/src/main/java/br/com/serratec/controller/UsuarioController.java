package br.com.serratec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.serratec.entity.Usuario;
import br.com.serratec.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public List<Usuario> listarUsuarios() {
		return service.listarUsuarios();
	}
	
	@PostMapping
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario usuario) throws Exception {
		Usuario novoUsuario = service.inserir(usuario);
		return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
		return service.atualizar(id, usuario);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		return service.deletar(id);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> autenticar(@RequestBody Usuario credenciais) {
		Usuario usuario = service.autenticar(credenciais.getEmail(), credenciais.getSenha());
		if (usuario != null) {
			return new ResponseEntity<>(usuario, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		}
	}
	
}
