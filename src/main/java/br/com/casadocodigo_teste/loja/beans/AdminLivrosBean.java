package br.com.casadocodigo_teste.loja.beans;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo_teste.loja.daos.AutorDao;
import br.com.casadocodigo_teste.loja.daos.LivroDao;
import br.com.casadocodigo_teste.loja.models.Autor;
import br.com.casadocodigo_teste.loja.models.Livro;

@Named
@RequestScoped
public class AdminLivrosBean {
		@Inject
		private LivroDao livroDao;
		@Inject
		private AutorDao autorDao;
		@Inject
		private FacesContext context;
		private Livro livro = new Livro(); 
		private Part capaLivro;
		
		public Livro getLivro() {
			return livro;
		}
		
		public void setLivro(Livro livro) {
			this.livro = livro;
		}
		
		public List<Autor> getAutores(){
			 return autorDao.listar();
		}

		public Part getCapaLivro() {
			return capaLivro;
		}

		public void setCapaLivro(Part capaLivro) {
			this.capaLivro = capaLivro;
		}
		
		@Transactional
		public String salvaLivro()  throws IOException {
			System.out.println("teste");
			FileSaver fileSaver = new FileSaver();
			String path = fileSaver.write(this.capaLivro, "livros");
	        livro.setCapaPath(path);
	        System.out.println("result " + path + " + " + livro.getCapaPath());
	        livroDao.salvar(livro);
			
			System.out.println("Livro cadastrado: " + livro);
			
	        context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage( null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Livro cadastrado com sucesso!", "Livro cadastrado com sucesso!"));
			
			return "/livros/lista?faces-redirect=true";
		}
	
}

