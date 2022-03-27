package br.com.casadocodigo_teste.loja.beans;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo_teste.loja.daos.LivroDao;
import br.com.casadocodigo_teste.loja.models.Livro;

@Model
public class AdminListaLivrosBean {
	
	@Inject
	private LivroDao livroDao;
	private List<Livro> livros = new ArrayList<Livro>();
	
	public List<Livro> getLivros() {
		this.livros = livroDao.listar();
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
}
