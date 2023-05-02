package br.com.emanoel.habilidades.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bk_id")
	private Long id;

	@Column(name = "bk_titulo", nullable = false, length = 80)
	private String titulo;

	@Column(name = "br_autor", nullable = false, length = 80)
	private String autor;

	@Column(name = "br_categoria", nullable = false, length = 80)
	private String categoria;

	@Column(name = "bk_ano_publicao", nullable = false, length = 100)
	private Date dataPublicao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Date getDataPublicao() {
		return dataPublicao;
	}

	public void setDataPublicao(Date dataPublicao) {
		this.dataPublicao = dataPublicao;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", categoria=" + categoria
				+ ", dataPublicao=" + dataPublicao + "]";
	}

}
