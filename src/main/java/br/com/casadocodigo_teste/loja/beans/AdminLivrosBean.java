package br.com.casadocodigo_teste.loja.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.com.casadocodigo_teste.loja.models.Livro;

@Named
@RequestScoped
public class AdminLivrosBean {
	
		private Livro livro = new Livro(); 
		
		public Livro getLivro() {
			return livro;
		}
		
		public void setLivro(Livro livro) {
			this.livro = livro;
		}

		public void salvaLivro() {
			System.out.println("Livro salvo com sucesso!\n" + livro);
		}
}

