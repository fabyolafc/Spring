package com.generation.lojaDeGames.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.generation.lojaDeGames.model.UserLogin;
import com.generation.lojaDeGames.model.Usuario;
import com.generation.lojaDeGames.repository.UsuarioRepository;
import com.generation.lojaDeGames.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins ="*", allowedHeaders = "*")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository repository;

	@PostMapping("/logar")
	public ResponseEntity<UserLogin> Autentication(@RequestBody Optional<UserLogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.CadastrarUsuario(usuario));
	}

	@PutMapping
	public ResponseEntity<Usuario> atualizar (@RequestBody Usuario user){
	 return null;
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> pegarTodos(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}
}