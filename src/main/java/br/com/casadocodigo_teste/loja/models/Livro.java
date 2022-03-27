package br.com.casadocodigo_teste.loja.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Livro {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@NotBlank
		@Length(min = 5)
		private String titulo;
		
		@ManyToMany
		@Size(min=1) 
	    @NotNull
		private List<Autor> autores = new ArrayList<Autor>();
		
		@Lob
		@Length(min = 10)
		@NotBlank
		private String descricao;
		
		@Min(50)
		private Integer numeroPaginas;
		@DecimalMin("20")
		private BigDecimal preco;
		
		@Temporal(TemporalType.DATE)
		private Calendar dataPublicacao;
		
		 private String capaPath;
		
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public Integer getNumeroPaginas() {
			return numeroPaginas;
		}
		public void setNumeroPaginas(Integer numeroPaginas) {
			this.numeroPaginas = numeroPaginas;
		}
		public BigDecimal getPreco() {
			return preco;
		}
		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public List<Autor> getAutores() {
			return autores;
		}
		public void setAutores(List<Autor> autores) {
			this.autores = autores;
		}
		public Calendar getDataPublicacao() {
			return dataPublicacao;
		}
		public void setDataPublicacao(Calendar dataPublicacao) {
			this.dataPublicacao = dataPublicacao;
		}
		
		@Override
		public String toString() {
			return "Livro [id=" + id + ", titulo=" + titulo + ", autores=" + autores + ", descricao=" + descricao
					+ ", numeroPaginas=" + numeroPaginas + ", preco=" + preco + ", dataPublicacao=" + dataPublicacao
					+ ", capaPath=" + capaPath + "]";
		}
		public String getCapaPath() {
			return capaPath;
		}
		public void setCapaPath(String capaPath) {
			this.capaPath = capaPath;
		}
		
}

