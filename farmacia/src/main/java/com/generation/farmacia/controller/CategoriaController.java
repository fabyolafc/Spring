package com.generation.farmacia.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.generation.farmacia.model.CategoriaModel;
import com.generation.farmacia.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
	
		
		@Autowired
		private CategoriaRepository repositoty;
		
		@GetMapping
		public ResponseEntity<List<CategoriaModel>> GetAll(){
			return ResponseEntity.ok(repositoty.findAll());
		}

		@GetMapping("/{id}")
		public ResponseEntity<CategoriaModel> GetById(@PathVariable long id){
			return repositoty.findById(id)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/nomeCategoria/{nomeCategoria}")
		public ResponseEntity<List<CategoriaModel>> GetByTitulo(@PathVariable String nomeCategoria){
			return ResponseEntity.ok(repositoty.findAllByNomeCategoriaContainingIgnoreCase (nomeCategoria));
		}
		
		@PostMapping
		public ResponseEntity<CategoriaModel> post (@Valid @RequestBody CategoriaModel categoria){
			return ResponseEntity.status(HttpStatus.CREATED).body(repositoty.save(categoria));
		}
		
		@PutMapping
		public ResponseEntity<CategoriaModel> put (@Valid @RequestBody CategoriaModel categoria){
			return ResponseEntity.status(HttpStatus.OK).body(repositoty.save(categoria));
		}
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable long id) {
			repositoty.deleteById(id);
		}	
}
