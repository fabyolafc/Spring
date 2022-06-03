package com.generation.lojaDeGames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class CategoriaModel {

		@Id	
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
			
		@NotNull
		private String jogo;
			
		@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
		@JsonIgnoreProperties("categoria")
		private List<ProdutoModel> produto;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getJogo() {
			return jogo;
		}

		public void setJogo(String jogo) {
			this.jogo = jogo;
		}

		public List<ProdutoModel> getProduto() {
			return produto;
		}

		public void setProduto(List<ProdutoModel> produto) {
			this.produto = produto;
		}
	
}
