package br.com.casadocodigo_teste.loja.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo_teste.loja.models.Livro;

public class LivroDao {
		@PersistenceContext
		private EntityManager em;
		
		public void salvar(Livro livro) {
				em.persist(livro);
		}
}
