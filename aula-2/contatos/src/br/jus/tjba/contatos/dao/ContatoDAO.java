package br.jus.tjba.contatos.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.jus.tjba.contatos.model.Contato;

@ApplicationScoped
public class ContatoDAO {
	
	@Inject
	private EntityManager em;

	public List<Contato> findAll(){
		String jql = "select c from Contato c order by c.nome";
		TypedQuery<Contato> query = em.createQuery(jql, Contato.class);
		return query.getResultList();
	}
	
	public Contato findById(Long id){
		String jql = "select c from Contato c where c.id = :id";
		TypedQuery<Contato> query = em.createQuery(jql, Contato.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	public List<Contato> findByEmail(String email){
		String jql = "select c from Contato c where c.email = :email";
		TypedQuery<Contato> query = em.createQuery(jql, Contato.class);
		query.setParameter("email", email);
		return query.getResultList();
	}
	
	public void create(Contato contato){
		em.persist(contato);
	}
	
	public void update(Contato contato){
		em.merge(contato);
	}
	
	public void remove(Contato contato){
		em.remove(contato);
	}
	
	
}
