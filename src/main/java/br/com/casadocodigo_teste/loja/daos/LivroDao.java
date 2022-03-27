package br.com.casadocodigo_teste.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo_teste.loja.models.Livro;

public class LivroDao {
		@PersistenceContext
		private EntityManager em;
		
		public void salvar(Livro livro) {
				em.persist(livro);
		}
		
		public List<Livro> listar(){
				String jpql = "select distinct(l) from Livro l join fetch l.autores";
				return em.createQuery(jpql, Livro.class).getResultList();
		}
}
