package com.generation.lojaDeGames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class ProdutoModel {
	
		@Id	
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotNull
		@Size(min = 5, max = 100)
		private String personagem;
			
		@NotNull
		@Size(min = 10, max = 500)
		private float valor;
		
		@NotNull
		@Size(min = 10, max = 500)
		private String habilidade;	
			
		@ManyToOne
		@JsonIgnoreProperties("produto")
		private CategoriaModel categoria;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getPersonagem() {
			return personagem;
		}

		public void setPersonagem(String personagem) {
			this.personagem = personagem;
		}

		public float getValor() {
			return valor;
		}

		public void setValor(float valor) {
			this.valor = valor;
		}

		public String getHabilidade() {
			return habilidade;
		}

		public void setHabilidade(String habilidade) {
			this.habilidade = habilidade;
		}

		public CategoriaModel getCategoria() {
			return categoria;
		}

		public void setCategoria(CategoriaModel categoria) {
			this.categoria = categoria;
		}
	
}
